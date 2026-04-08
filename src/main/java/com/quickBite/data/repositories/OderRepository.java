package com.quickBite.data.repositories;

import com.quickBite.data.models.Oder;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OderRepository extends MongoRepository<Oder,String> {
    boolean existsOderById(String oderId);
}
