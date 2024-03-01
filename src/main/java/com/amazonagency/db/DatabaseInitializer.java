package com.amazonagency.db;

import com.amazonagency.dto.user.Report;
import com.amazonagency.repository.AsinStatisticRepository;
import com.amazonagency.repository.DateStatisticRepository;
import com.amazonagency.service.FileReaderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DatabaseInitializer {
    private static final String filePath = "src/main/resources/report/test_report.json";
    private final FileReaderService fileReaderService;
    private final ObjectMapper objectMapper;
    private final DateStatisticRepository dateStatisticRepository;
    private final AsinStatisticRepository asinStatisticRepository;

    @EventListener(ApplicationReadyEvent.class)
    void init() {
        String file = fileReaderService.read(filePath);
        Report report;
        try {
            report = objectMapper.readValue(file, Report.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        asinStatisticRepository.saveAll(report.getSalesAndTrafficByAsin());
        dateStatisticRepository.saveAll(report.getSalesAndTrafficByDate());
    }
}
