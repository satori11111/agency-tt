package com.amazonagency.repository;

import com.amazonagency.model.report.sales.date.SalesAndTrafficByDate;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DateStatisticRepository extends MongoRepository<SalesAndTrafficByDate, String> {
    List<SalesAndTrafficByDate> findAllByDateBetween(LocalDate from, LocalDate to);
    List<SalesAndTrafficByDate> findAllByDate(LocalDate date);
}
