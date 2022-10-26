package models;

import enums.Departments;
import enums.Gender;
import enums.Role;

public class Staff extends Person {
    private Integer id;
    private Departments department;
    private Role role;
    public Staff() {
    }

    public Staff(Integer id, Departments department, Role role) {
        this.id = id;
        this.department = department;
        this.role = role;
    }

    public Staff(String name, Gender gender, String email, Integer age, Integer id, Departments department, Role role) {
        super(name, gender, email, age);
        this.id = id;
        this.department = department;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Departments getDepartment() {
        return department;
    }

    public void setDepartment(Departments department) {
        this.department = department;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", department=" + department +
                '}';
    }
}
