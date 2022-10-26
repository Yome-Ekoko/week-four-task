package models;

public class Receipt1 {
    public Receipt1(Integer receiptNum) {
        this.receiptNum = receiptNum;
    }

    private Integer receiptNum;
    private String customerName;
    private String cashierName;
    private Integer quantity;
    private Double totalAmount;
    private String productName;

    public Receipt1() {
    }

    public Receipt1(Integer receiptNum, String customerName, String cashierName, Integer quantity, Double totalAmount, String productName) {
        this.receiptNum = receiptNum;
        this.customerName = customerName;
        this.cashierName = cashierName;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
        this.productName = productName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Integer getReceiptNum() {
        return receiptNum;
    }

    public void setReceiptNum(Integer receiptNum) {
        this.receiptNum = receiptNum;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCashierName() {
        return cashierName;
    }

    public void setCashierName(String cashierName) {
        this.cashierName = cashierName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }


    @Override
    public String toString() {
        return "\n"+ customerName + " Receipt of Purchase" +"\n"+
                "============================================" + "\n"+
                "receiptNum=" + receiptNum + "\n"+
                " customerName='" + customerName + "\n"+
                " cashierName='" + cashierName + "\n"  +
                " quantity=" + quantity + "\n" +
                " totalAmount=" + totalAmount + "\n" +
                " productName='" + productName + " \n" +
                "============================================"+ " \n";
    }
}
