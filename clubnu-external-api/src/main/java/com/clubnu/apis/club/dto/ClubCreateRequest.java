package com.clubnu.apis.club.dto;

import com.clubnu.domain.club.entity.ClubCategory;

public record ClubCreateRequest (
        String name,
        String description,
        Long category,
        String logoImageUrl,
        String goal,
        String location,
        Integer memberCount
){
}
