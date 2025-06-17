package com.clubnu.domain.club.service;

import com.clubnu.domain.club.entity.Club;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClubCommandDomainService {

    private final ClubRdsCommandService clubRdsCommandService;

    public Club createClub(Club club) {
        return clubRdsCommandService.createClub(club);
    }
}
