package models;

import Services.CustomerServiceImpl;

import java.util.*;

public class Store {
    private Integer id;
    private String storeName;
    private List<Staff> staff;
    private List<Products> allProducts;
    private LinkedList<Customer> customerQueue;

    public Store() {
    }

    public Store(Integer id, String storeName, List<Staff> staff, List<Products> allProducts) {
        this.id = id;
        this.storeName = storeName;
        this.staff = staff;
        this.allProducts = allProducts;
    }

    public Store(Integer id, String storeName, List<Staff> staff, List<Products> allProducts, LinkedList<Customer> customerQueue) {
        this.id = id;
        this.storeName = storeName;
        this.staff = staff;
        this.allProducts = allProducts;
        this.customerQueue = customerQueue;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public List<Staff> getStaff() {
        return staff;
    }

    public void setStaff(List<Staff> staff) {
        this.staff = staff;
    }

    public List<Products> getAllProducts() {
        return allProducts;
    }

    public void setAllProducts(List<Products> allProducts) {
        this.allProducts = allProducts;
    }

    public LinkedList<Customer> getCustomerQueue() {
        return customerQueue;
    }

    public void setCustomerQueue(LinkedList<Customer> customerQueue) {
        this.customerQueue = customerQueue;
    }

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", storeName='" + storeName + '\'' +
                ", staff=" + staff +
                ", allProducts=" + allProducts + " CustomerQueue: " + customerQueue +
                '}';
    }


}

