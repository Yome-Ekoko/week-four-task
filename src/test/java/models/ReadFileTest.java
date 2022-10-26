package models;

import models.Products;
import models.ReadFile;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReadFileTest {

    @Test
    void productListIsNotEmpty() {
        List<Products> productsList = ReadFile.readFile("src/main/resources/ProductList.csv");
        assertEquals(12, productsList.size());
    }

    @Test
    void TestProductContainsCompleteData() {
        List<Products> productsList = ReadFile.readFile("src/main/resources/ProductList.csv");

        assertEquals("monster", productsList.get(0).getProductName());

    }
    @Test
    void TestExceptionThrownForIncorrectFilePath(){
        List<Products> productsList = ReadFile.readFile("src/main/resour/ProductList.csv");
        assertEquals(Collections.emptyList(), productsList);

    }
}