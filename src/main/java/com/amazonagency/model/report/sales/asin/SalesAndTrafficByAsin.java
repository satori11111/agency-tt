package com.amazonagency.model.report.sales.asin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalesAndTrafficByAsin {

    private String parentAsin;

    private SalesByAsin salesByAsin;

    private TrafficByAsin trafficByAsin;

}
