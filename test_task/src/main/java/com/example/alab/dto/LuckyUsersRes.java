package com.example.alab.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class LuckyUsersRes {

    private List<LuckyUser> luckyUsers;

    @Data
    @AllArgsConstructor
    public class LuckyUserDTO implements LuckyUser {
        private String name;
        private String secondName;
        private String patronymic;
        private DocumentType documentType;
        private String documentNumber;
    }
}
