package com.clubnu.domain.club.service;

import com.clubnu.domain.club.entity.Club;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClubQueryDomainService {
    private final ClubRdsQueryService clubRdsQueryService;

    public Club findClubById(Long clubId) {
        return clubRdsQueryService.findClubById(clubId);
    }

    public List<Club> findAllClubs() {
        return clubRdsQueryService.findAllClubs();
    }
}
