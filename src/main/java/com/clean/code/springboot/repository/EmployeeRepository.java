package com.clean.code.springboot.repository;

import com.clean.code.springboot.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByFirstName(String firstName);

    List<Employee> findByFirstNameAndLastName(String firstName, String lastName);

    @Query("select e from Employee e WHERE e.firstName = :firstName")
    List<Employee> findByFirstNameQuery(@Param("firstName") String firstName);
    @Query(value = "select * from employee e WHERE e.first_Name = :firstName ", nativeQuery = true)
    List<Employee> findByFirstNameQueryNative(@Param("firstName") String firstName);

    List<Employee> findAllByFirstNameLike(String firstName);
    List<Employee> findAllByFirstNameStartingWith(String firstName);
    List<Employee> findAllByFirstNameEndingWith(String firstName);
    @Query("select e from Employee e where UPPER(e.firstName) like upper(concat('%', :firstName, '%')) ")
    List<Employee> findAllByLike(@Param("firstName") String firstName);
    @Query(value = "select * from employee e WHERE e.first_name like % :firstName %",nativeQuery = true)
    List<Employee> findAllNativeLike(@Param("firstName") String firstName);



}
