package com.example.alab.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FilesRes {
    private Long multyThreadTime;
    private Long singleThreadTime;
}
