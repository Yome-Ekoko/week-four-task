package Services;

import enums.Departments;
import enums.Gender;
import enums.Role;
import exceptions.InsufficientFundException;
import exceptions.OutOfStockException;
import exceptions.ProductUnavailableException;
import models.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class CashierServiceImplTest {


    @Test
    void testRaceConditionQuantity(){

        Store store = new Store();
        store.setAllProducts(ReadFile.readFile("src/main/resources/ProductList.csv"));



        Customer cust1 = new Customer(212, "monster", 20000.0, 20);
        Customer cust2 = new Customer(213, "monster", 20000.0, 20);
        Customer cust3 = new Customer(214, "monster", 20000.0, 20);



        Cashier cashier1 = new Cashier("Amanda", Gender.FEMALE, "dgwywcsh", 24, 3, Departments.ACCOUNTING, Role.CASHIER);

        LinkedList<Customer> customerList = new LinkedList<>();

        CustomerServiceImpl customerService = new CustomerServiceImpl(store, customerList);



        customerService.joinQueue(store, cust1);
        customerService.joinQueue(store, cust2);
        customerService.joinQueue(store, cust3);

        for (Customer customer : customerList) {
            Thread cashierThread = new Thread(new CashierServiceImpl(store, customer, cashier1));
            cashierThread.start();
        }

        assertNotEquals(0, store.getAllProducts().get(0).getQuantity());
    }

    @Test
    void testForHandledRaceConditionQuantity(){

        Store store = new Store();
        store.setAllProducts(ReadFile.readFile("src/main/resources/ProductList.csv"));



        Customer cust1 = new Customer(212, "monster", 20000.0, 20);
        Customer cust2 = new Customer(213, "monster", 20000.0, 20);
        Customer cust3 = new Customer(214, "monster", 20000.0, 20);



        Cashier cashier1 = new Cashier("Amanda", Gender.FEMALE, "dgwywcsh", 24, 3, Departments.ACCOUNTING, Role.CASHIER);

        LinkedList<Customer> customerList = new LinkedList<>();

        CustomerServiceImpl customerService = new CustomerServiceImpl(store, customerList);



        customerService.joinQueue(store, cust1);
        customerService.joinQueue(store, cust2);
        customerService.joinQueue(store, cust3);

        for (Customer customer : customerList) {
            Thread cashierThread = new Thread(new CashierServiceImpl(store, customer, cashier1));

            cashierThread.start();

            try {
                cashierThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }

        assertEquals(0, store.getAllProducts().get(0).getQuantity());
    }

    @Test
    void testRaceConditionBalance(){

        Store store = new Store();
        store.setAllProducts(ReadFile.readFile("src/main/resources/ProductList.csv"));



        Customer cust1 = new Customer(212, "monster", 5000.0, 5);
        Customer cust2 = new Customer(213, "monster", 20000.0, 20);
        Customer cust3 = new Customer(214, "monster", 20000.0, 5);



        Cashier cashier1 = new Cashier("Amanda", Gender.FEMALE, "dgwywcsh", 24, 3, Departments.ACCOUNTING, Role.CASHIER);

        LinkedList<Customer> customerList = new LinkedList<>();

        CustomerServiceImpl customerService = new CustomerServiceImpl(store, customerList);


        customerService.joinQueue(store, cust1);
        customerService.joinQueue(store, cust2);
        customerService.joinQueue(store, cust3);
        customerService.joinQueue(store, cust1);

        for (Customer customer : customerList) {
            Thread cashierThread = new Thread(new CashierServiceImpl(store, customer, cashier1));
            cashierThread.start();
        }



        assertNotEquals(1000, cust1.getCustAmount());
    }

    @Test
    void testForHandledRaceConditionBalance(){

        Store store = new Store();
        store.setAllProducts(ReadFile.readFile("src/main/resources/ProductList.csv"));



        Customer cust1 = new Customer(212, "monster", 9000.0, 10);
        Customer cust2 = new Customer(213, "monster", 20000.0, 20);
        Customer cust3 = new Customer(214, "monster", 20000.0, 20);



        Cashier cashier1 = new Cashier("Amanda", Gender.FEMALE, "dgwywcsh", 24, 3, Departments.ACCOUNTING, Role.CASHIER);

        LinkedList<Customer> customerList = new LinkedList<>();

        CustomerServiceImpl customerService = new CustomerServiceImpl(store, customerList);


        customerService.joinQueue(store, cust1);
        customerService.joinQueue(store, cust2);
        customerService.joinQueue(store, cust3);

        for (Customer customer : customerList) {
            Thread cashierThread = new Thread(new CashierServiceImpl(store, customer, cashier1));

            cashierThread.start();

            try {
                cashierThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }

        assertEquals(1000, cust1.getCustAmount());
    }

    @Test
    void salesSuccessful(){

        Store store = new Store();
        store.setAllProducts(ReadFile.readFile("src/main/resources/ProductList.csv"));



        Customer cust1 = new Customer(212, "monster", 200_000.0, 20);
        Customer cust2 = new Customer(213, "monster", 10_000.0, 10);
        Customer cust3 = new Customer(214, "monster", 20_000.0, 10);



        Cashier cashier1 = new Cashier("Amanda", Gender.FEMALE, "dgwywcsh", 24, 3, Departments.ACCOUNTING, Role.CASHIER);

        LinkedList<Customer> customerList = new LinkedList<>();

        CustomerServiceImpl customerService = new CustomerServiceImpl(store, customerList);


        customerService.joinQueue(store, cust1);
        customerService.joinQueue(store, cust2);
        customerService.joinQueue(store, cust3);

        Receipt1 receipt = new Receipt1();
        for(int i =0; i< store.getAllProducts().size(); i++){
            Integer count = 0;
            if(store.getAllProducts().get(i).getProductName().equals(cust1.getProductName())){
                receipt.setReceiptNum(count++);
                receipt.setCustomerName(cust2.getName());
                receipt.setCashierName(cashier1.getName());
                receipt.setQuantity(cust2.getQuantity());
                receipt.setTotalAmount(Double.valueOf(cust2.getQuantity() * store.getAllProducts().get(i).getPrice()));
                receipt.setProductName(cust2.getProductName());
                Double originalAmountPaid = cust2.getCustAmount();
                Double balance = originalAmountPaid - (cust2.getQuantity() * store.getAllProducts().get(i).getPrice());
                cust1.setCustAmount(balance);
            }
        }

        String expected = "Product sold successfully to Customer" + cust2.getCustId() + "\n" + receipt ;
        CashierServiceImpl cashierThread = new CashierServiceImpl(store, cust2, cashier1);


        assertEquals(expected, cashierThread.sellProduct(store, cust2,cashier1));
    }

    @Test
    void InsufficientFundException(){

        Store store = new Store();
        store.setAllProducts(ReadFile.readFile("src/main/resources/ProductList.csv"));



        Customer cust1 = new Customer(212, "monster", 200_000.0, 20);
        Customer cust2 = new Customer(213, "monster", 7_000.0, 10);
        Customer cust3 = new Customer(214, "monster", 20_000.0, 10);



        Cashier cashier1 = new Cashier("Amanda", Gender.FEMALE, "dgwywcsh", 24, 3, Departments.ACCOUNTING, Role.CASHIER);

        LinkedList<Customer> customerList = new LinkedList<>();

        CustomerServiceImpl customerService = new CustomerServiceImpl(store, customerList);


        customerService.joinQueue(store, cust1);
        customerService.joinQueue(store, cust2);
        customerService.joinQueue(store, cust3);


        Throwable exception = assertThrows(InsufficientFundException.class, () -> {
            CashierServiceImpl cashierThread = new CashierServiceImpl(store, cust2, cashier1);
            cashierThread.sellProduct(store, cust2, cashier1);
        });


        assertEquals("Insufficient fund to complete transaction", exception.getMessage());
    }

    @Test
    void OutOfStockException(){

        Store store = new Store();
        store.setAllProducts(ReadFile.readFile("src/main/resources/ProductList.csv"));



        Customer cust1 = new Customer(212, "monster", 200_000.0, 20);
        Customer cust2 = new Customer(213, "monster", 7_000.0, 45);
        Customer cust3 = new Customer(214, "monster", 20_000.0, 10);



        Cashier cashier1 = new Cashier("Amanda", Gender.FEMALE, "dgwywcsh", 24, 3, Departments.ACCOUNTING, Role.CASHIER);

        LinkedList<Customer> customerList = new LinkedList<>();

        CustomerServiceImpl customerService = new CustomerServiceImpl(store, customerList);


        customerService.joinQueue(store, cust1);
        customerService.joinQueue(store, cust2);
        customerService.joinQueue(store, cust3);

        Throwable exception = assertThrows(OutOfStockException.class, () -> {
            CashierServiceImpl cashierThread = new CashierServiceImpl(store, cust2, cashier1);
            cashierThread.sellProduct(store, cust2, cashier1);
        });


        assertEquals("OUT OF STOCK", exception.getMessage());
    }

    @Test
    void ProductNotAvailableException(){

        Store store = new Store();
        store.setAllProducts(ReadFile.readFile("src/main/resources/ProductList.csv"));



        Customer cust1 = new Customer(212, "monster", 200_000.0, 20);
        Customer cust2 = new Customer(213, "coffee", 7_000.0, 45);
        Customer cust3 = new Customer(214, "monster", 20_000.0, 10);



        Cashier cashier1 = new Cashier("Amanda", Gender.FEMALE, "dgwywcsh", 24, 3, Departments.ACCOUNTING, Role.CASHIER);

        LinkedList<Customer> customerList = new LinkedList<>();

        CustomerServiceImpl customerService = new CustomerServiceImpl(store, customerList);


        customerService.joinQueue(store, cust1);
        customerService.joinQueue(store, cust2);
        customerService.joinQueue(store, cust3);


        Throwable exception = assertThrows(ProductUnavailableException.class, () -> {
            CashierServiceImpl cashierThread = new CashierServiceImpl(store, cust2, cashier1);
            cashierThread.sellProduct(store, cust2, cashier1);
        });

        assertEquals("Product is not available", exception.getMessage());
    }

}