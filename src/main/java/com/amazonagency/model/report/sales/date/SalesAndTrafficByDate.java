package com.amazonagency.model.report.sales.date;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalesAndTrafficByDate {

    private LocalDate date;

    private SalesByDate salesByDate;

    private TrafficByDate trafficByDate;

}
