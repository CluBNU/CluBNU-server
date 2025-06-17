package com.clubnu.domain.club.service;

import com.clubnu.domain.club.entity.ClubCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClubCategoryQueryDomainService {

    private final ClubCategoryRdsQueryService clubCategoryRdsQueryService;

    public ClubCategory getClubCategoryById(Long id) {
        return clubCategoryRdsQueryService.getClubCategoryById(id);
    }
}
