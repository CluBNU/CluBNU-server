package com.clubnu.domain.club.entity;

import com.clubnu.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "club")
public class Club extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "club_id", nullable = false)
    private Long clubId;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "description", nullable = false)
    private String description;
    @JoinColumn(name = "category_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private ClubCategory category;
    @Column(name = "logo_image_url", nullable = false)
    private String logoImageUrl;
    @Column(name = "goal", nullable = false)
    private String goal;
    @Column(name = "location", nullable = false)
    private String location;
    @Column(name = "member_count", nullable = false)
    private Integer memberCount;

    @Builder
    public Club(Long clubId, String name, String description, ClubCategory category, String logoImageUrl, String goal, String location, Integer memberCount) {
        this.clubId = clubId;
        this.name = name;
        this.description = description;
        this.category = category;
        this.logoImageUrl = logoImageUrl;
        this.goal = goal;
        this.location = location;
        this.memberCount = memberCount;
    }
}
