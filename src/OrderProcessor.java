import com.amazonaws.services.cloudwatch.model.StandardUnit;

/**
 * Order Processor class.
 */
public class OrderProcessor {

    private MetricsPublisher metricsPublisher;

    /**
     * Constructs a OrderProcessor object.
     *
     * @param metricsPublisher used to publish metrics to CloudWatch.
     */
    public OrderProcessor(MetricsPublisher metricsPublisher) {
        this.metricsPublisher = metricsPublisher;
    }

    /**
     * Processes an order and payment.
     *
     * @param newOrder The order to be processed
     */
    public void processOrder(Order newOrder) {
        try {
            double totalPrice = newOrder.getTotalPrice();
            metricsPublisher.addMetric("ORDER_TOTALS", totalPrice, StandardUnit.None);
            // Order processing code omitted

        } catch (Exception e) {
            System.out.println("Exception thrown while processing order: " + e.getMessage());
        }
    }
}
