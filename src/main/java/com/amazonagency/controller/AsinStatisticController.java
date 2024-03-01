package com.amazonagency.controller;

import com.amazonagency.model.report.sales.asin.SalesAndTrafficByAsin;
import com.amazonagency.service.AsinStatisticService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("statistic/asin")
@RequiredArgsConstructor
public class AsinStatisticController {
    private final AsinStatisticService asinStatisticService;

    @GetMapping("/all")
    public Page<SalesAndTrafficByAsin> findAll(Pageable pageable) {
        return asinStatisticService.findAllReportsByAsins(pageable);
    }

    @GetMapping("/search")
    public List<SalesAndTrafficByAsin> findByAsinIn(@RequestParam("asins") List<String> asins) {
        return asinStatisticService.findReportsByAsin(asins);
    }

}
