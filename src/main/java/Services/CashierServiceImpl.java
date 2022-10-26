package Services;

import exceptions.InsufficientFundException;
import exceptions.OutOfStockException;
import interfaces.CashierInterface;
import models.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class CashierServiceImpl implements Runnable, CashierInterface {
    private Store store;
    private Customer customer;
    private Cashier cashier;
    private CustomerServiceImpl customerService;


    public CashierServiceImpl(Store store, Customer customer, Cashier cashier) {
        this.store = store;
        this.customer = customer;
        this.cashier = cashier;

    }

    public Products isProductAvailable(Store store, Customer customer) {
        Products product = null;
        try{
            List<Products> productAvail = store.getAllProducts().stream()
                    .filter(product1 -> customer.getProductName().equals(product1.getProductName()))
                    .collect(Collectors.toList());

            product =  productAvail.get(0);
        }catch(NoSuchElementException e){
            e.printStackTrace();
        }

    return product;

    }





    public Boolean isQuantityEnough(Store store, Customer customer) {
        return isProductAvailable(store, customer).getQuantity() >= customer.getQuantity();

    }

    public Boolean isCustomerAmountEnough(Store store, Customer customer) {

        return (isProductAvailable(store, customer).getPrice() * customer.getQuantity()) <= customer.getCustAmount();
    }

    public Receipt1 printReceipt(Store store, Customer customer, Cashier cashier) {
        Receipt1 receipt = new Receipt1();
        int count = 0;

        receipt.setReceiptNum(count++);
        receipt.setCustomerName(customer.getName());
        receipt.setCashierName(cashier.getName());
        receipt.setQuantity(customer.getQuantity());
        receipt.setTotalAmount(Double.valueOf(customer.getQuantity() * isProductAvailable(store, customer).getPrice()));
        receipt.setProductName(customer.getProductName());

        isProductAvailable(store, customer).setQuantity(isProductAvailable(store, customer).getQuantity() - customer.getQuantity());
        customer.setCustAmount(customer.getCustAmount() - (isProductAvailable(store,customer).getPrice() * customer.getQuantity()));

        return receipt;
    }

    public String sellProduct(Store store, Customer customer, Cashier cashier) {
        String status = "";
        isProductAvailable(store, customer);
        if (isQuantityEnough(store, customer).equals(true)) {
            if (isCustomerAmountEnough(store, customer)) {
                status += "Product sold successfully to Customer" + customer.getCustId() + "\n" + printReceipt(store, customer, cashier);
            } else {
                throw new InsufficientFundException("Insufficient fund to complete transaction");
                }
        }else{
            throw new OutOfStockException("OUT OF STOCK");
        }
return status;
    }


    @Override
    public void run() {
        System.out.println(sellProduct(store, customer, cashier));
    }
}