package com.amazonagency.service;


import com.amazonagency.model.report.sales.date.SalesAndTrafficByDate;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DateStatisticService {

    List<SalesAndTrafficByDate> getByDateBetween(LocalDate dateFrom, LocalDate dateTo);

    Page<SalesAndTrafficByDate> getAll(Pageable pageable);
}
