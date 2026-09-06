package Loggings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;

/**
 * ===================================================================================
 *                    METRICS & MONITORING IN BACKEND ENGINEERING
 * ===================================================================================
 * 
 * 📌 WHAT IS MONITORING AND WHY DO WE USE METRICS?
 * - Monitoring tracks overall system health by collecting numerical measurements (metrics) over time.
 * - Dashboards (e.g., Grafana) plot these metrics to give real-time graphs of CPU, memory, traffic, and latency.
 * - Alerts (e.g., Alertmanager, PagerDuty) trigger when metrics breach thresholds (e.g. "Error rate > 5% for 5 mins").
 * 
 * 📐 KEY MONITORING FRAMEWORKS:
 * 1. RED Pattern (For Microservices & Web APIs):
 *    - Rate: Request per second (QPS / RPS).
 *    - Errors: Number or percentage of failing requests.
 *    - Duration: Time taken to serve requests (Latency / Percentiles: p50, p90, p99).
 * 
 * 2. USE Pattern (For Infrastructure & Host Resources):
 *    - Utilization: % of resource actively used (e.g., 85% CPU utilization).
 *    - Saturation: Work queue depth / backlog (e.g., DB Connection pool queue length).
 *    - Errors: Count of resource error events.
 * 
 * ===================================================================================
 */
public class MetricsAndMonitoringDemo {

    // --- 1. COUNTER METRIC (Only increases monotonically) ---
    // Example: total_http_requests, total_failed_logins
    private static final AtomicLong httpRequestsTotal = new AtomicLong(0);
    private static final AtomicLong httpErrorsTotal = new AtomicLong(0);

    // --- 2. GAUGE METRIC (Can go UP and DOWN) ---
    // Example: active_db_connections, memory_used_bytes, current_queue_size
    private static int activeDbConnections = 0;

    // --- 3. HISTOGRAM / TIMER (Measures distribution of response times) ---
    // Example: http_request_duration_seconds
    private static final List<Long> requestLatenciesMs = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) {
        System.out.println("=========================================================");
        System.out.println("     BACKEND METRICS & MONITORING SIMULATION (RED FRAMEWORK)");
        System.out.println("=========================================================\n");

        // Simulate incoming web API requests
        simulateIncomingTraffic(20);

        // Export metrics (Simulates Prometheus scrape endpoint: /actuator/prometheus)
        exportPrometheusMetrics();
    }

    private static void simulateIncomingTraffic(int requestCount) {
        System.out.println("🚀 Simulating " + requestCount + " incoming API requests...\n");

        for (int i = 0; i < requestCount; i++) {
            // Increment Counter
            httpRequestsTotal.incrementAndGet();

            // Simulate Gauge fluctuation (active connections)
            activeDbConnections = ThreadLocalRandom.current().nextInt(2, 15);

            // Simulate API response time (Duration)
            long latencyMs = ThreadLocalRandom.current().nextLong(10, 250);

            // Simulate 10% error rate
            if (i % 10 == 0) {
                httpErrorsTotal.incrementAndGet();
                latencyMs += 500; // Error requests usually take longer due to timeouts
            }

            requestLatenciesMs.add(latencyMs);
        }
    }

    /**
     * Simulates what Prometheus metric output looks like when scraping a backend app!
     */
    private static void exportPrometheusMetrics() {
        System.out.println("=========================================================");
        System.out.println("   PROMETHEUS FORMATTED METRICS EXPORT (/actuator/prometheus)");
        System.out.println("=========================================================");

        // Counter format
        System.out.println("# HELP http_requests_total The total number of HTTP requests.");
        System.out.println("# TYPE http_requests_total counter");
        System.out.println("http_requests_total{method=\"POST\",handler=\"/api/v1/orders\"} " + httpRequestsTotal.get());

        System.out.println("\n# HELP http_requests_errors_total Total HTTP request failures.");
        System.out.println("# TYPE http_requests_errors_total counter");
        System.out.println("http_requests_errors_total{status=\"500\"} " + httpErrorsTotal.get());

        // Gauge format
        System.out.println("\n# HELP db_connections_active Current active database connections.");
        System.out.println("# TYPE db_connections_active gauge");
        System.out.println("db_connections_active{pool=\"hikari-cp\"} " + activeDbConnections);

        // Histogram / Latency calculation (P50, P90, P99)
        Collections.sort(requestLatenciesMs);
        long p50 = getPercentile(requestLatenciesMs, 50);
        long p90 = getPercentile(requestLatenciesMs, 90);
        long p99 = getPercentile(requestLatenciesMs, 99);

        System.out.println("\n# HELP http_request_duration_ms HTTP response duration percentiles.");
        System.out.println("# TYPE http_request_duration_ms summary");
        System.out.println("http_request_duration_ms{quantile=\"0.50\"} " + p50 + " ms");
        System.out.println("http_request_duration_ms{quantile=\"0.90\"} " + p90 + " ms");
        System.out.println("http_request_duration_ms{quantile=\"0.99\"} " + p99 + " ms");

        System.out.println("=========================================================");
        System.out.println(" In Grafana, developers create graphs using PromQL like:");
        System.out.println("   - Error Rate % = rate(http_requests_errors_total[5m]) / rate(http_requests_total[5m]) * 100");
        System.out.println("=========================================================");
    }

    private static long getPercentile(List<Long> latencies, int percentile) {
        if (latencies.isEmpty()) return 0;
        int index = (int) Math.ceil((percentile / 100.0) * latencies.size()) - 1;
        index = Math.max(0, Math.min(index, latencies.size() - 1));
        return latencies.get(index);
    }
}
