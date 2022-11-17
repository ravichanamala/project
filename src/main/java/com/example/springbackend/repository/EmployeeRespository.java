package com.example.springbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springbackend.entity.Employee;


@Repository
public interface EmployeeRespository extends JpaRepository<Employee, Integer> {

}
