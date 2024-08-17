package com.techviz.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techviz.app.pojos.Mess;
@Repository
public interface MessRepository extends JpaRepository<Mess, Integer> {

}
