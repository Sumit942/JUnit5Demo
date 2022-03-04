package com.example.demo.employee;

import java.util.Objects;

public class Employee_withEqAndHash implements Comparable<Employee_withEqAndHash> {
    private int id;
    private String firstName;
    private String lastName;

    public Employee_withEqAndHash (){}
    public Employee_withEqAndHash(int id, String fName, String lName) {
        this.id = id;
        this.firstName = fName;
        this.lastName = lName;
    }
    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee_withEqAndHash that = (Employee_withEqAndHash) o;
        return id == that.id && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public int compareTo(Employee_withEqAndHash o) {
        return (this.getId()+this.getFirstName()+this.getLastName())
                .compareTo(o.getId()+o.getFirstName()+o.getLastName());
    }
}