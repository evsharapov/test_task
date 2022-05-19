package com.example.alab.dao.repository;

import com.example.alab.dao.model.Person;
import com.example.alab.dto.LuckyUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

    @Query(value = "SELECT name, second_name as secondName, patronymic, document_type as documentType, number as documentNumber from person p " +
            "inner join document d on p.document_id = d.id where d.number like '%777%' and d.active = 'true'", nativeQuery = true)
    List<LuckyUser> getLuckyUsers();

    List<Person> findAll();
}
