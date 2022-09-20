package com.first.FirstWebApp.repository;

import com.first.FirstWebApp.entity.Student111;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student111, Integer> {
    List<Student111> findByName(String name);

    @Query(value = "select * from student111 where Surname=?1", nativeQuery = true)
    List<Student111> getStudentBySurname(String surname);


}



