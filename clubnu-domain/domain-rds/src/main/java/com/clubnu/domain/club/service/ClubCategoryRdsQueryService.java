package com.clubnu.domain.club.service;

import com.clubnu.domain.club.entity.ClubCategory;
import com.clubnu.domain.club.repository.ClubCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClubCategoryRdsQueryService {

    private final ClubCategoryRepository clubCategoryRepository;

    public boolean existCategoryById(Long categoryId) {
        return clubCategoryRepository.existsById(categoryId);
    }

    public ClubCategory getClubCategoryById(Long id) {
        return clubCategoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Club category not found with id: " + id));
    }
}
