package com.amazonagency.service.impl;

import com.amazonagency.model.report.sales.asin.SalesAndTrafficByAsin;
import com.amazonagency.repository.AsinStatisticRepository;
import com.amazonagency.service.AsinStatisticService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CachePut;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AsinStatisticServiceImpl implements AsinStatisticService {
    private final AsinStatisticRepository asinStatisticRepository;


    @Override
    @CachePut("statsByAsins")
    public List<SalesAndTrafficByAsin> findReportsByAsin(List<String> asins) {
        return asinStatisticRepository.findByParentAsinIn(asins);
    }

    @Override
    @CachePut("allStatsByAsins")
    public Page<SalesAndTrafficByAsin> findAllReportsByAsins(Pageable pageable) {
        return asinStatisticRepository.findAll(pageable);
    }
}
