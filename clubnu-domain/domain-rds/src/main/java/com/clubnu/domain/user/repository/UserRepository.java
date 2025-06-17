package com.clubnu.domain.user.repository;

import com.clubnu.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserIdentity_EmailAndIsDeletedFalse(String email);
    Optional<User> findByUserIdAndIsDeletedFalse(Long id);

}
