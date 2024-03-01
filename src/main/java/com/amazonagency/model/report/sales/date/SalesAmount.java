package com.amazonagency.model.report.sales.date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalesAmount {

    private double amount;

    private String currencyCode;

}
