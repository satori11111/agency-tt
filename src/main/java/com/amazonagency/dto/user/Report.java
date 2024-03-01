package com.amazonagency.dto.user;

import com.amazonagency.model.report.sales.asin.SalesAndTrafficByAsin;
import com.amazonagency.model.report.sales.date.SalesAndTrafficByDate;
import com.amazonagency.model.report.specification.ReportSpecification;
import java.util.List;
import lombok.Data;

@Data
public class Report {
    private ReportSpecification reportSpecification;
    private List<SalesAndTrafficByDate> salesAndTrafficByDate;
    private List<SalesAndTrafficByAsin> salesAndTrafficByAsin;
}