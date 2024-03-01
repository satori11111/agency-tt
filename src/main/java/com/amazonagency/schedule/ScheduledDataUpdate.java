package com.amazonagency.schedule;

import com.amazonagency.dto.user.Report;
import com.amazonagency.repository.AsinStatisticRepository;
import com.amazonagency.repository.DateStatisticRepository;
import com.amazonagency.service.FileReaderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
@RequiredArgsConstructor
public class ScheduledDataUpdate {
    private static final String filePath = "src/main/resources/report/test_report.json";
    private final AsinStatisticRepository asinStatisticRepository;
    private final DateStatisticRepository dateStatisticRepository;
    private final FileReaderService fileReaderService;
    private final ObjectMapper objectMapper;

    @Scheduled(fixedRate = 200_000)
    @CacheEvict(cacheNames = {
            "statsByAsins",
            "allStatsByAsins",
            "statsByDateBetween",
            "allStatsByDates",
    })
    public void update() {
        String file = fileReaderService.read(filePath);
        Report report;
        try {
            report = objectMapper.readValue(file, Report.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        asinStatisticRepository.deleteAll();
        dateStatisticRepository.deleteAll();
        asinStatisticRepository.saveAll(report.getSalesAndTrafficByAsin());
        dateStatisticRepository.saveAll(report.getSalesAndTrafficByDate());
    }

}
