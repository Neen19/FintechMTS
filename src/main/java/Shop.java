package main.java;

/**
 * Class shop contains basic information about product
 * and prints total purchase price taking into account the discount
 */


public class Shop {
    // product amount
    private int amount;
    // price per one product
    private double price;
    // discount on product
    private double discount;

    public Shop(int amount, double price, double discount) {
        if (amount < 0) throw new IllegalArgumentException("amount must be natural number");
        if (price < 0) throw new IllegalArgumentException("price must be natural number");
        if (discount < 0 || discount > 100)
            throw new IllegalArgumentException("discount must be more than 0 and less than 100");
        this.amount = amount;
        this.price = price;
        this.discount = discount;
    }

    public Shop(int amount, double price) {
        this(amount, price, 0D);
    }

    public int getAmount() {
        return amount;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

}
