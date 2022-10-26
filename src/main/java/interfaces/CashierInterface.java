package interfaces;

import Services.CustomerServiceImpl;
import models.Cashier;
import models.Customer;
import models.Store;

import java.util.Queue;

public interface CashierInterface {
    Object sellProduct(Store store, Customer customer, Cashier cashier);
}
