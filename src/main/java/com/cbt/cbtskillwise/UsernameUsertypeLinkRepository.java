package com.cbt.cbtskillwise;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsernameUsertypeLinkRepository extends JpaRepository<UsernameUsertypeLink, Integer> {
}