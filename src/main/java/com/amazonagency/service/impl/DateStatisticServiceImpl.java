package com.amazonagency.service.impl;

import com.amazonagency.model.report.sales.date.SalesAndTrafficByDate;
import com.amazonagency.repository.DateStatisticRepository;
import com.amazonagency.service.DateStatisticService;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CachePut;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DateStatisticServiceImpl implements DateStatisticService {
    private final DateStatisticRepository dateStatisticRepository;

    @Override
    @CachePut("statsByDateBetween")
    public List<SalesAndTrafficByDate> getByDateBetween(LocalDate from, LocalDate to) {
        return dateStatisticRepository.findAllByDateBetween(from, to);
    }

    @Override
    @CachePut("allStatsByDates")
    public Page<SalesAndTrafficByDate> getAll(Pageable pageable) {
        return dateStatisticRepository.findAll(pageable);
    }
}
