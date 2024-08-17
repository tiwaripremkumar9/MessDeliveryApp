package com.techviz.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techviz.app.pojos.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
