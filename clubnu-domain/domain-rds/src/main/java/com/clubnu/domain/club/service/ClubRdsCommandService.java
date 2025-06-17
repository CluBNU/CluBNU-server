package com.clubnu.domain.club.service;

import com.clubnu.domain.club.entity.Club;
import com.clubnu.domain.club.repository.ClubRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClubRdsCommandService {

    private final ClubRepository clubRepository;

    public Club createClub(Club club) {
        return clubRepository.save(club);
    }
}
