package com.clubnu.domain.club.service;

import com.clubnu.domain.club.entity.Club;
import com.clubnu.domain.club.repository.ClubRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClubRdsQueryService {
    private final ClubRepository clubRepository;

    public Club findClubById(Long clubId) {
        return clubRepository.findById(clubId)
                .orElseThrow(() -> new IllegalArgumentException("Club not found with id: " + clubId));
    }

    public List<Club> findAllClubs() {
        return clubRepository.findAll();
    }
}
