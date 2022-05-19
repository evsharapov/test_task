package com.example.alab.util;

import com.example.alab.dto.NamedObject;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Grouper {
    public static <T extends NamedObject>  Map<String, List<T>> groupByName(Collection<T> objects) {
        return objects.stream().collect(Collectors.groupingBy(NamedObject::getName));
    }
}
