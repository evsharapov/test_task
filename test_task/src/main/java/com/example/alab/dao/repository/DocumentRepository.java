package com.example.alab.dao.repository;

import com.example.alab.dao.model.Document;
import org.springframework.data.repository.CrudRepository;

public interface DocumentRepository extends CrudRepository<Document, Long> {
}
