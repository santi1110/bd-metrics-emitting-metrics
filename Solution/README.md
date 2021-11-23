### Order Total Metrics

**Branch name:** metrics-prework

**RDE workfows:**
* `rde wflow run metrics-prework-emittingmetrics-orderprocessortest`

Expected time required: 10 min

You are building an order processing service for your online store.  You would like to track the total amount for each
order as a metric to keep track of how much money your store is making.

Update the `OrderProcessor` and `MetricsPublisher` to log a metric in CloudWatch with the following information:

1. Namespace: `"EXAMPLE/ORDERS"`
1. Dimension: `"ENVIRONMENT"` with a value of `"PRODUCTION"`
1. Metric Name: `"ORDER_TOTALS"`
1. Metric Value: the `totalPrice` of the passed in `Order`
1. Metric Unit: `StandardUnit.None` 

Note that we have provided a separate `MetricsPublisher` class that integrates with CloudWatch. The `MetricsPublisher` 
has two methods `addMetric`, which calls CloudWatch to log the given metric, and `buildMetricDataRequest`, a helper
method called by `addMetric` that builds the `PutMetricDataRequest` request object to pass to CloudWatch. 

To log the order totals metric, you will:
1. Update `buildMetricDataRequest` in `MetricsPublisher` to build the `PutMetricDataRequest` using the above metric
   information. 
    * Note that `buildMetricsDataRequest` takes in three parameters: `metricName`, `value`, and `unit`. These 
      parameter values should be used when building the `PutMetricDataRequest` object.
1. Update `processOrder` in `OrderProcessor` to log the `totalPrice` of the `Order` by calling `MetricsPublisher`'s
`addMetric` method.


HINTS:
* [I don't know what classes I need!](hints/hint-01.md)
