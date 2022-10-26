package models;

import enums.Departments;
import enums.Gender;
import enums.Role;

public class Cashier extends Staff {

    private static Integer count = 0;
    private Store store;
    private Customer customer;

    public Cashier() {
    }

    public Cashier(Store store, Customer customer) {
        this.store = store;
        this.customer = customer;
    }

    public Cashier(Integer id, Departments department, Role role) {
        super(id, department, role);
    }

    public Cashier(String name, Gender gender, String email, Integer age, Integer id, Departments department, Role role) {
        super(name, gender, email, age, id, department, role);
    }

    @Override
    public String toString() {
        return "Cashier{" +
                "} " + super.toString();
    }

}

