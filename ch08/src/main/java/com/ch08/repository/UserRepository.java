package com.ch08.repository;

import com.ch08.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//insert sql 메서드를 처리해줌
@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
