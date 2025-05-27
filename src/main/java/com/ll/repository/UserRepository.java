package com.ll.repository;

import com.ll.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // 필요하면 커스텀 쿼리 작성 가능
}
