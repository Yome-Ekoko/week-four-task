package models;

import enums.Departments;
import enums.Gender;
import enums.Qualification;
import enums.Role;
import models.CashierApplicant;
import models.Manager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ManagerTest {



    @Test
    void cashierIsHired() {
        CashierApplicant applicant = new CashierApplicant("Yomi", Gender.MALE,"musty.abayomi@gmail.com",25, Qualification.OND);
        Manager manager2 = new Manager("Yome",Gender.FEMALE,"", 35,123,Departments.MANAGEMENT,Role.MANAGER);

        String cashierHired = "Congratulations, You are hired";
        String actual = manager2.hireACashier(manager2,applicant);
        assertEquals(cashierHired,actual);

    }

    @Test
    void cashierNotHired() {
        CashierApplicant applicant = new CashierApplicant("Maustapha", Gender.MALE,"musty.abayomi@gmail.com",25, Qualification.BSC);
        Manager manager2 = new Manager("Yome",Gender.FEMALE,"", 35,123,Departments.MANAGEMENT,Role.MANAGER);

        String cashierNotHired = "Sorry you have been disqualified";
        String actual = manager2.hireACashier(manager2,applicant);
        assertEquals(cashierNotHired,actual);

    }
    @Test
    void accessDenied() {
      CashierApplicant applicant = new CashierApplicant("Maustapha", Gender.MALE,"musty.abayomi@gmail.com",25, Qualification.OND);
       Manager manager = new Manager("Yome",Gender.FEMALE,"", 35,123, Departments.MANAGEMENT, Role.CASHIER);

        String accessDenied = " Access Denied!!";
        String actual = manager.hireACashier(manager,applicant);
        assertEquals(accessDenied,actual);

    }

}