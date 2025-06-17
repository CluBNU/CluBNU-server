package com.clubnu.apis.club.service;

import com.clubnu.domain.club.entity.Club;
import com.clubnu.domain.club.service.ClubQueryDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClubQueryService {
    private final ClubQueryDomainService clubQueryDomainService;

    public Club findClubById(Long clubId) {
        return clubQueryDomainService.findClubById(clubId);
    }

    public List<Club> findAllClubs() {
        return clubQueryDomainService.findAllClubs();
    }
}
