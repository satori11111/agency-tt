package com.amazonagency.service;

import com.amazonagency.model.report.sales.asin.SalesAndTrafficByAsin;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AsinStatisticService {
    List<SalesAndTrafficByAsin> findReportsByAsin(List<String> asins);

    Page<SalesAndTrafficByAsin> findAllReportsByAsins(Pageable pageable);
}
