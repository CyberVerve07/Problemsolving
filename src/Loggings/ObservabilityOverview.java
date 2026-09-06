package Loggings;

/**
 * ===================================================================================
 *                    LOGGING, MONITORING & OBSERVABILITY IN BACKEND
 * ===================================================================================
 * 
 * 📌 WHAT ARE THEY AND WHY DO WE NEED THEM IN BACKEND DEVELOPMENT?
 * 
 * 1. LOGGING (What happened?):
 *    - Logging is the process of recording discrete events that occur in your application.
 *    - Example log: "2026-09-06 19:10:05 [INFO] [TraceID: abc-123] Order #501 placed by user #42 for amount $99.99"
 *    - Why: Helps developers debug failures, audit user activity, and understand historical events.
 * 
 * 2. MONITORING (Are things working overall?):
 *    - Monitoring is the process of collecting, aggregating, and analyzing quantitative metrics over time.
 *    - Key Metrics: CPU usage, Memory consumption, Requests per second (RPS/QPS), Error rates, Latency (p50, p90, p99).
 *    - Why: Alerts on-call engineers when system performance degrades or services crash (e.g., via Grafana, Datadog, Prometheus).
 * 
 * 3. OBSERVABILITY / O11y (WHY are things broken?):
 *    - Observability is a measure of how well you can understand the internal state of a system based on its external outputs.
 *    - In microservices, when a request fails across 10 services, Monitoring tells you "Error rate is high", but Observability tells you "Payment service timed out because DB connection pool on Node 3 was exhausted".
 * 
 * -----------------------------------------------------------------------------------
 * 🏛️ THE 3 PILLARS OF OBSERVABILITY (MELT / LMT):
 * -----------------------------------------------------------------------------------
 * 1. LOGS: Detailed timestamped text/JSON messages about a specific event. (High detail, high volume)
 * 2. METRICS: Numeric aggregations measured over time intervals. (Low volume, high performance, good for dashboards/alerts)
 *    - 3 Main Metric Types:
 *      a) Counter: Only goes UP (e.g., total_orders_placed, total_http_errors).
 *      b) Gauge: Goes UP & DOWN (e.g., active_db_connections, memory_usage_mb).
 *      c) Histogram / Timer: Measures distribution of values (e.g., API response times in milliseconds).
 * 3. TRACES (Distributed Tracing): Tracking a single request as it flows through multiple microservices using:
 *    - Trace ID: Unique ID for the entire user request workflow across all services.
 *    - Span ID: Unique ID for a specific operation within a single service.
 * 
 * ===================================================================================
 */
public class ObservabilityOverview {

    public static void main(String[] args) {
        System.out.println("=========================================================");
        System.out.println("   BACKEND OBSERVABILITY CHEAT SHEET & QUICK EXPLANATION  ");
        System.out.println("=========================================================");
        System.out.println("1. LOGS      --> Discrete records of events ('Order failed because card expired')");
        System.out.println("2. METRICS   --> Aggregated numerical stats over time ('HTTP 500 rate = 4.2%')");
        System.out.println("3. TRACES    --> Journey of a request across microservices via Trace ID");
        System.out.println("=========================================================");
        System.out.println("Run other classes in package 'Loggings' to see hands-on examples!");
    }
}
