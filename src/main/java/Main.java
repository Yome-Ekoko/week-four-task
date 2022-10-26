import Services.CashierServiceImpl;
import Services.CustomerServiceImpl;
import enums.Departments;
import enums.Gender;
import enums.Qualification;
import enums.Role;
import interfaces.ManagerInterface;
import models.*;

import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Store store = new Store();

        store.setAllProducts(ReadFile.readFile("src/main/resources/ProductList.csv"));



        Customer cust1 = new Customer(212, "monster", 20000.0, 20);
        Customer cust2 = new Customer(213, "monster", 20000.0, 15);
        Customer cust3 = new Customer(214, "monster", 20000.0, 5);

        Cashier cashier1 = new Cashier("Amanda", Gender.FEMALE, "dgwywcsh", 24, 3, Departments.ACCOUNTING, Role.CASHIER);
        Cashier cashier2 = new Cashier("Amanda", Gender.FEMALE, "dgwywcsh", 24, 3, Departments.ACCOUNTING, Role.CASHIER);
        Cashier cashier3 = new Cashier("Amanda", Gender.FEMALE, "dgwywcsh", 24, 3, Departments.ACCOUNTING, Role.CASHIER);
        CashierServiceImpl cashierService=new CashierServiceImpl(store,cust1,cashier1);
        LinkedList<Customer> customerList = new LinkedList<>();

        CustomerServiceImpl customerService = new CustomerServiceImpl(store, customerList);


        customerService.joinQueue(store, cust1);
        customerService.joinQueue(store, cust2);
        customerService.joinQueue(store, cust3);
        customerService.joinQueue(store, cust1);


        for (Customer customer : customerList) {

            Thread cashierThread = new Thread(new CashierServiceImpl(store, customer, cashier1));

            cashierThread.start();
            try {
                cashierThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

}