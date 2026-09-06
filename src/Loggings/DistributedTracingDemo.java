package Loggings;

import java.util.UUID;
import java.util.logging.Logger;

/**
 * ===================================================================================
 *               DISTRIBUTED TRACING & MDC (MAPPED DIAGNOSTIC CONTEXT)
 * ===================================================================================
 * 
 * 📌 PROBLEM IN MICROSERVICES ARCHITECTURE:
 * When a user clicks "Buy Now", the request goes through:
 *   [Client UI] -> [API Gateway] -> [Order Service] -> [Payment Service] -> [Inventory Service] -> [Email Service]
 * 
 * If the request fails, how do you find which service caused the error out of 100 microservices?
 * Searching logs by timestamp alone is impossible because thousands of requests happen simultaneously!
 * 
 * 💡 SOLUTION: DISTRIBUTED TRACING
 * 1. Trace ID: Generated at the API Gateway for the ENTIRE transaction workflow. Passed in HTTP Header: `X-Trace-Id`.
 * 2. Span ID: Represents a single unit of work inside one service (e.g. `OrderService.createOrder()`). Passed in HTTP Header: `X-Span-Id`.
 * 3. MDC (Mapped Diagnostic Context): Automatically attaches Trace ID & Span ID to EVERY log output in Java (SLF4J/Logback).
 * 
 * Tools used in industry: OpenTelemetry, Jaeger, Zipkin, AWS X-Ray, Datadog APM.
 * 
 * ===================================================================================
 */
public class DistributedTracingDemo {

    private static final Logger log = Logger.getLogger(DistributedTracingDemo.class.getName());

    // TraceContext simulation class (In real Spring Boot / Quarkus, handled by OpenTelemetry or Micrometer Tracing)
    public static class TraceContext {
        private final String traceId;
        private final String spanId;
        private final String serviceName;

        public TraceContext(String traceId, String spanId, String serviceName) {
            this.traceId = traceId;
            this.spanId = spanId;
            this.serviceName = serviceName;
        }

        public String getTraceId() { return traceId; }
        public String getSpanId() { return spanId; }
        public String getServiceName() { return serviceName; }

        public String formatLogMessage(String message) {
            return String.format("[%s] [TraceID: %s] [SpanID: %s] %s", 
                    serviceName, traceId, spanId, message);
        }
    }

    public static void main(String[] args) {
        System.out.println("=========================================================");
        System.out.println("    SIMULATING DISTRIBUTED TRACING ACROSS MICROSERVICES   ");
        System.out.println("=========================================================\n");

        // 1. User initiates checkout at API Gateway
        String globalTraceId = "tr-" + UUID.randomUUID().toString().substring(0, 8);
        System.out.println("🌐 Incoming Request at API Gateway. Assigned Trace ID: " + globalTraceId + "\n");

        // Call Service 1: API Gateway
        apiGatewayHandler(globalTraceId);
    }

    private static void apiGatewayHandler(String traceId) {
        String spanId = "span-gateway-1";
        TraceContext context = new TraceContext(traceId, spanId, "API-GATEWAY");

        log.info(context.formatLogMessage("1. Authenticated user request. Forwarding to Order Service..."));

        // Forward to Order Service (Passing Trace ID in headers)
        orderServiceHandler(traceId);
    }

    private static void orderServiceHandler(String traceId) {
        String spanId = "span-order-2";
        TraceContext context = new TraceContext(traceId, spanId, "ORDER-SERVICE");

        log.info(context.formatLogMessage("2. Creating order record in DB..."));

        // Forward to Payment Service
        paymentServiceHandler(traceId);
    }

    private static void paymentServiceHandler(String traceId) {
        String spanId = "span-payment-3";
        TraceContext context = new TraceContext(traceId, spanId, "PAYMENT-SERVICE");

        log.info(context.formatLogMessage("3. Calling Bank API gateway..."));
        log.info(context.formatLogMessage("4. Payment approved by Bank! Charging account..."));

        // Forward to Notification Service
        notificationServiceHandler(traceId);
    }

    private static void notificationServiceHandler(String traceId) {
        String spanId = "span-notify-4";
        TraceContext context = new TraceContext(traceId, spanId, "NOTIFICATION-SERVICE");

        log.info(context.formatLogMessage("5. Sending SMS and Email confirmation to customer. Done!"));
        
        System.out.println("\n=========================================================");
        System.out.println("✅ Notice how ALL logs share the EXACT SAME Trace ID: " + traceId);
        System.out.println("   In Kibana/Loki/Datadog, searching 'TraceID=" + traceId + "'");
        System.out.println("   instantaneously reveals the complete execution path across all 4 services!");
        System.out.println("=========================================================");
    }
}
