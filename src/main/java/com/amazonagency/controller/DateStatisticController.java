package com.amazonagency.controller;

import com.amazonagency.model.report.sales.asin.SalesAndTrafficByAsin;
import com.amazonagency.model.report.sales.date.SalesAndTrafficByDate;
import com.amazonagency.service.DateStatisticService;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("statistic/date")
@RequiredArgsConstructor
public class DateStatisticController {
    private final DateStatisticService dateStatisticService;


    @GetMapping("/all")
    public Page<SalesAndTrafficByDate> findAllStatistic(Pageable pageable) {
        return  dateStatisticService.getAll(pageable);
    }
    @GetMapping("/search")
    public List<SalesAndTrafficByDate> findAllStatisticByDate(@RequestParam("from") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
                                                              @RequestParam("to") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to) {
        return  dateStatisticService.getByDateBetween(from, to);
    }
}
