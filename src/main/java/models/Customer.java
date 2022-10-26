package models;

import enums.Gender;

import java.util.LinkedList;

public class Customer extends Person {
    private Integer custId;
    private String productName;
    private volatile Double custAmount;
    private Integer quantity;
    private LinkedList<Customer> customersList;


    public Customer(String productName, Double amountPaid, Integer quantity) {
        this.productName = productName;
        this.custAmount = amountPaid;
        this.quantity = quantity;
    }

    public Customer(Integer custId, Double amountPaid) {
        this.custId = custId;
        this.custAmount = amountPaid;
        this.quantity = quantity;

   }

    public Customer(String name,Integer custId,Double amountPaid) {
        super(name);
        this.custId=custId;
        this.custAmount =amountPaid;
    }

    public Customer(Integer custId, String productName, Double amountPaid, Integer quantity) {
        this.custId = custId;
        this.productName = productName;
        this.custAmount = amountPaid;
        this.quantity = quantity;
    }


    public Customer(String name, Gender gender, String email, Integer age,
                    String productName, Double amountPaid) {
        super(name, gender, email, age);
        this.productName = productName;
        this.custAmount = amountPaid;
        this.quantity = quantity;


    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getCustAmount() {
        return custAmount;
    }

    public void setCustAmount(Double custAmount) {
        this.custAmount = custAmount;
    }

    public Integer getQuantity() {
        return quantity;
    }


    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public void setCustomersList(LinkedList<Customer> customersList) {
        this.customersList = customersList;
    }

    public LinkedList<Customer> getCustomersList() {
        return customersList;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "custId=" + custId +
                ", amountPaid=" + custAmount +
                "} ";
    }

}



