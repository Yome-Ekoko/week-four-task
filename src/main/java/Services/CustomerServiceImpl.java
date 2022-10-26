package Services;

import interfaces.CustomerInterface;
import models.Customer;
import models.Products;
import models.Store;

import java.util.LinkedList;


public class CustomerServiceImpl implements CustomerInterface {

    private Store store;
    private Customer customer;
    private LinkedList<Customer> customersList;

    public CustomerServiceImpl(Store store, LinkedList<Customer> customersList) {
        this.store = store;
        this.customer = customer;
        this.customersList = customersList;
    }

    public Customer getCustomer() {
        return customer;
    }



    @Override
    public String toString() {
        return "CustomerServiceImpl{" +
                "store=" + store +
                ", customer=" + customer +
                '}';
    }

    @Override
    public void joinQueue(Store store, Customer customer){
        store.setCustomerQueue(customersList);

        for(Products product : store.getAllProducts()){
            if(product.getProductName().equals(customer.getProductName())){
                store.getCustomerQueue().add(customer);
            }
        }
    }
}
