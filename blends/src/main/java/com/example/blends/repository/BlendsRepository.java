package com.example.blends.repository;

import com.example.blends.model.Blend;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BlendsRepository extends MongoRepository<Blend, String> {
    boolean existsBlendByName(String id);
}
