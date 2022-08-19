package com.first.FirstWebApp.repository;

import com.first.FirstWebApp.entity.Student111;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student111,Integer> {

}
