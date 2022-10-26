package models;

import java.util.List;

public class CartProduct {
    private String prodName;
    private Integer qty;
    private Float price;
//    private Products product;

    public CartProduct() {
    }

    public CartProduct(String prodName, Integer qty) {
        this.prodName = prodName;
        this.qty = qty;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Float getPrice() {
        price = 0.0F;
        List<Products> availableProducts = ReadFile.readFile("src/main/resources/ProductList.csv");
        for(int i = 0; i< availableProducts.size(); i++){
            if(availableProducts.get(i).getProductName().equalsIgnoreCase(this.getProdName())){
                price = availableProducts.get(i).getPrice() * this.getQty();
            }
        }
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;


    }

    @Override
    public String toString() {
        return "CartProduct{" +
                "prodName='" + prodName + '\'' +
                ", qty=" + qty +
                ", price=" + this.getPrice() +
                '}';
    }
}
