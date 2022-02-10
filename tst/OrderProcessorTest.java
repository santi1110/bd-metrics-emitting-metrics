import com.amazonaws.services.cloudwatch.model.StandardUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class OrderProcessorTest {

    private static final String ORDER_ID = "orderId-1234";
    private static final String CUSTOMER_ID =  "customerId-58483";
    private static final String PAYMENT_ID = "paymentId-13424";
    private static final double TOTAL_PRICE = 13.99;
    private static final String METRIC_NAME = "ORDER_TOTALS";

    @Mock
    private MetricsPublisher metricsPublisher;

    @InjectMocks
    private OrderProcessor orderProcessor;

    @BeforeEach
    public void setup() {
        initMocks(this);
    }


    @Test
    public void processOrder_validOrder_logsOrderTotalMetric() {
        // GIVEN
        Order order = new Order(ORDER_ID, CUSTOMER_ID, PAYMENT_ID,TOTAL_PRICE);

        // WHEN
        orderProcessor.processOrder(order);

        // THEN
        verify(metricsPublisher, times(1)).addMetric(METRIC_NAME, TOTAL_PRICE, StandardUnit.None);
    }
}
