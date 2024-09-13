package com.ch10.repository;

import com.ch10.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//insert sql 메서드를 처리해줌
@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
