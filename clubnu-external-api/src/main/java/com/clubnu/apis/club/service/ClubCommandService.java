package com.clubnu.apis.club.service;

import com.clubnu.apis.club.dto.ClubCreateRequest;
import com.clubnu.domain.club.entity.Club;
import com.clubnu.domain.club.entity.ClubCategory;
import com.clubnu.domain.club.service.ClubCategoryQueryDomainService;
import com.clubnu.domain.club.service.ClubCategoryRdsQueryService;
import com.clubnu.domain.club.service.ClubCommandDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClubCommandService {

    private final ClubCommandDomainService clubCommandDomainService;
    private final ClubCategoryQueryDomainService clubCategoryQueryDomainService;

    public Club createClub(ClubCreateRequest request) {
        ClubCategory category = clubCategoryQueryDomainService
                .getClubCategoryById(request.category());
        Club club = Club.builder()
                .name(request.name())
                .description(request.description())
                .category(category)
                .logoImageUrl(request.logoImageUrl())
                .goal(request.goal())
                .location(request.location())
                .memberCount(request.memberCount())
                .build();
        return clubCommandDomainService.createClub(club);
    }
}
