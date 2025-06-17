package com.clubnu.domain.club.entity;

import com.clubnu.domain.BaseEntity;
import jakarta.persistence.*;

@Entity
public class ClubCategory extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", nullable = false)
    private Long categoryId;

    @Column(name = "name", nullable = false, unique = true)
    private String name;
}
