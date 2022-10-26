package models;


public class Products {
    private String productName;
    private String productId;
    private Float price;
    private Integer quantity;
    private String category;
    private String availability;

    private Double amount;


    public Products() {
    }

    public Products(String productName, String productId, Float price, Integer quantity, String category, String availability) {
        this.productName = productName;
        this.productId = productId;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.availability = availability;

    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String  getCategory() {
        return category;
    }

    public void setTypeOfProduct(String category) {
        this.category = category;
    }

    public Float getAmount() {
      Float amount =   this.price * this.quantity;
        return amount;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Products{" +
                "productName='" + productName + '\'' +
                ", productId='" + productId + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", category='" + category + '\'' +
                ", availability='" + availability + '\'' +
                ", amount=" + amount +
                '}';
    }
}
