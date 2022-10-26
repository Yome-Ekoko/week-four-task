package interfaces;

import models.CartProduct;
import models.Customer;
import models.Store;

import java.io.FileNotFoundException;

public interface CustomerInterface {

    void joinQueue(Store store, Customer customer);

}


