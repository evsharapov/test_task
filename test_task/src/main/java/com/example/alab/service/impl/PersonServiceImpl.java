package com.example.alab.service.impl;

import com.example.alab.dao.model.Person;
import com.example.alab.dao.repository.PersonRepository;
import com.example.alab.dto.LuckyUser;
import com.example.alab.dto.LuckyUsersRes;
import com.example.alab.dto.MapOfListsRes;
import com.example.alab.service.PersonService;
import com.example.alab.util.Grouper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Override
    public LuckyUsersRes getLuckyUsers() {

        List<LuckyUser> luckyUsers = personRepository.getLuckyUsers();

        return LuckyUsersRes.builder()
                .luckyUsers(luckyUsers)
                .build();
    }

    @Override
    public MapOfListsRes getMap() {

        List<Person> persons = personRepository.findAll();

        return MapOfListsRes.builder()
                .map(Grouper.groupByName(persons))
                .build();
    }
}
