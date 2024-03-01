package com.amazonagency.model.report.specification;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportSpecification {

    private String id;

    private String reportType;

    private ReportOptions reportOptions;

    private LocalDate dataStartTime;

    private LocalDate dataEndTime;

    private List<String> marketplaceIds = new ArrayList<>();

}
