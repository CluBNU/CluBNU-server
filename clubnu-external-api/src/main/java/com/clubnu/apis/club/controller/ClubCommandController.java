package com.clubnu.apis.club.controller;

import com.clubnu.apis.club.dto.ClubCreateRequest;
import com.clubnu.apis.club.service.ClubCommandService;
import com.clubnu.domain.club.entity.Club;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ClubCommandController {

    private final ClubCommandService clubCommandService;

    @MutationMapping
    public Club createClub(@Argument ClubCreateRequest clubCreateRequest) {
        return clubCommandService.createClub(clubCreateRequest);
    }
}
