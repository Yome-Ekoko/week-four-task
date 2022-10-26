package models;

import enums.Gender;
import enums.Qualification;

import models.CashierApplicant;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CashierApplicantInterfaceTest {


    @Test
    public void applyForJob() {
        CashierApplicant applicant = new CashierApplicant("Mausty", Gender.MALE,"musty.abayomi@gmail.com",25, Qualification.BSC);

        String expected = "Application Successful";
        String actual = applicant.applyForJob();
        assertEquals(expected, actual);

    }
}