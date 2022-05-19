package com.example.alab.service;

import com.example.alab.dto.LuckyUsersRes;
import com.example.alab.dto.MapOfListsRes;

public interface PersonService {
    LuckyUsersRes getLuckyUsers();
    MapOfListsRes getMap();
}
