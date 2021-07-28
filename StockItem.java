package com.igorJovanovic;

public class StockItem {
    private String name;
    private double price;
    private int quantityInStock=0;
    private int reserved=0;

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public StockItem(String name, double price, int quantityInStock) {
        this.name = name;
        this.price = price;
        this.quantityInStock = quantityInStock;
    }

    public int addToStock(int quantity){
        if (quantity>0){
             this.quantityInStock+=quantity;
             return quantity;
        }
      return 0;
    }

    public int reservedItem(int quantity){
     if (quantity<=0 && quantityInStock-reserved<quantity){
         return 0;
     }else{
         return this.reserved+=quantity;
     }
    }

    public int unReserveItem(int quantity){
        if (quantity<=0 && this.reserved<=0 && this.reserved<quantity){
            return 0;
        }else{
            this.reserved-=quantity;
            return quantity;
        }
    }

    public int finalizeSell(int quantity){
        if (quantity<=this.reserved){
            this.reserved-=quantity;
            this.quantityInStock-=quantity;
            return quantity;
        }else{
            return 0;
        }
    }


    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int availableQuantityInStock() {
        if (quantityInStock - reserved < 0) {
            return 0;
        }
        return quantityInStock - reserved;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public int getReserved() {
        return reserved;
    }

    @Override
    public String toString() {
        return "StockItem{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantityInStock=" + quantityInStock +
                ", reserved=" + reserved +
                '}';
    }
}
