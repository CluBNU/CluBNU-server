package com.clubnu.apis.club.controller;

import com.clubnu.apis.club.service.ClubQueryService;
import com.clubnu.domain.club.entity.Club;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ClubQueryController {

    private final ClubQueryService clubQueryService;

    @QueryMapping
    public Club club(@Argument Long clubId) {
        return clubQueryService.findClubById(clubId);
    }

    @QueryMapping
    public List<Club> clubs() {
        return clubQueryService.findAllClubs();
    }
}
