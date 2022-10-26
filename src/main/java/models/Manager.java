package models;

import enums.Departments;
import enums.Gender;
import enums.Qualification;
import enums.Role;
import interfaces.ManagerInterface;

public class Manager extends Staff implements ManagerInterface {

    public Manager() {
    }

    public Manager(Integer id, Departments department, Role role) {
        super(id, department, role);
    }

    public Manager(String name, Gender gender, String email, Integer age, Integer id, Departments department, Role role) {
        super(name, gender, email, age, id, department, role);
    }


    @Override
    public String toString() {
        return "Manager{} " + super.toString();
    }

    @Override
    public String hireACashier(Staff staff, CashierApplicant cashierApplicant) {
        String s = ((staff.getRole().equals(Role.MANAGER) && (cashierApplicant.getQualification().equals(Qualification.OND) ||
                cashierApplicant.getQualification().equals(Qualification.WAEC)) && cashierApplicant.getAge() >= 18)) ?
                "Congratulations, You are hired" : (!staff.getRole().equals(Role.MANAGER)) ? " Access Denied!!" : "Sorry you have been disqualified";
        return s;
    }

}