package com.example.PP_3_1_3.repository;

import com.example.PP_3_1_3.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User, Integer>{

    public User findByUsername(String username);

}
