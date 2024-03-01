package com.amazonagency.repository;

import com.amazonagency.model.report.sales.asin.SalesAndTrafficByAsin;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsinStatisticRepository extends MongoRepository<SalesAndTrafficByAsin, String> {
    List<SalesAndTrafficByAsin> findByParentAsinIn(List<String> asin);
}
