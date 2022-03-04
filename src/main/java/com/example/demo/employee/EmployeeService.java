package com.example.demo.employee;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class EmployeeService {

    public Integer getSizeOfEmpSet(Set<Employee> empSet) {

        return empSet.stream()
                .map(emp -> emp.getId()+emp.getFirstName()+emp.getLastName())
                .collect(Collectors.toSet())
                .size();
    }

    public Integer getSizeOfEmpWithHashSet(Set<Employee_withHash> empSet) {

        return empSet.stream()
                .map(emp -> emp.getId()+emp.getFirstName()+emp.getLastName())
                .collect(Collectors.toSet())
                .size();
    }

    public Integer getSizeOfEmpWithEqualsSet(Set<Employee_withEq> empSet) {

        return empSet.stream()
                .map(e -> e.getId()+e.getFirstName()+e.getLastName())
                .collect(Collectors.toSet())
                .size();
    }

    public Integer getSizeOfEmpWithHashAndEquals(Set<Employee_withEqAndHash> empSet) {

        return empSet.stream()
                .map(e -> e.getId()+e.getFirstName()+e.getLastName())
                .collect(Collectors.toSet())
                .size();
    }
}
