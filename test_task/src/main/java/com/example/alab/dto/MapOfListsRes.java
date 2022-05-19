package com.example.alab.dto;

import com.example.alab.dao.model.Person;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@Builder
public class MapOfListsRes {
    private Map<String, List<Person>> map;
}
