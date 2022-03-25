package com.form.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.form.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{


}