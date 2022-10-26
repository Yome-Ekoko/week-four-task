package models;

import enums.Gender;
import enums.Qualification;
import interfaces.CashierApplicantInterface;

public class CashierApplicant extends Person implements CashierApplicantInterface {
    private Qualification qualification;


    public CashierApplicant(Qualification qualification) {
        this.qualification = qualification;
    }

    public CashierApplicant(String name, Gender gender, String email, Integer age, Qualification qualification) {
        super(name, gender, email, age);
        this.qualification = qualification;
    }

    public Qualification getQualification() {
        return qualification;
    }

    public void setQualification(Qualification qualification) {
        this.qualification = qualification;
    }

    @Override
    public String toString() {
        return "CashierApplicant{" +
                "qualification=" + qualification +
                "} " + super.toString();
    }

    @Override
    public String applyForJob() {
        return "Application Successful";
    }
}

