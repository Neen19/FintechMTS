package main.java;

public class Main {
    public static void main(String[] args) {
        Shop shop1 = new Shop(10, 1.2, 0.75);
        Shop shop2 = new Shop(10, 1.2, 42.575);
        Shop shop3 = new Shop(10, 1.2, 59.1);
        printPurchasePrice(shop1);
        printPurchasePrice(shop2);
        printPurchasePrice(shop3);
    }

    public static void printPurchasePrice(Shop shop) {
        double defoltFullPrice = shop.getPrice() * shop.getAmount();
        double discountFullPrice = shop.getPrice() * shop.getAmount() * ((100.0 - shop.getDiscount()) / 100.0);
        System.out.printf("Purchase price without discount: %.2f\n", defoltFullPrice);
        System.out.printf("Purchase price with discount: %.2f\n\n",discountFullPrice);
    }
}
