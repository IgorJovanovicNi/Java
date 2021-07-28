package com.igorJovanovic;

public class Main {
    private static StockList stockList = new StockList();

    public static void main(String[] args) {
        StockItem temp = new StockItem("bread", 0.86, 100);
        stockList.addToStockList(temp);


        temp = new StockItem("cake", 1.10, 7);
        stockList.addToStockList(temp);

        temp = new StockItem("car", 12.50, 2);
        stockList.addToStockList(temp);

        temp = new StockItem("chair", 62.0, 10);
        stockList.addToStockList(temp);

        temp = new StockItem("cup", 0.50, 200);
        stockList.addToStockList(temp);

        temp = new StockItem("door", 72.95, 4);
        stockList.addToStockList(temp);

        temp = new StockItem("juice", 2.50, 36);
        stockList.addToStockList(temp);

        temp = new StockItem("phone", 96.99, 35);
        stockList.addToStockList(temp);

        temp = new StockItem("towel", 2.40, 80);
        stockList.addToStockList(temp);

        temp = new StockItem("vase", 8.76, 40);
        stockList.addToStockList(temp);

        System.out.println(stockList);


        Basket timsBasket = new Basket("Tim");
        putInBasket(timsBasket,"towel",6);
        putInBasket(timsBasket, "car", 2);
        System.out.println(timsBasket);


      putInBasket(timsBasket, "car", 1);
        System.out.println(timsBasket);


      putInBasket(timsBasket, "spanner", 5);
        System.out.println(timsBasket);

      putInBasket(timsBasket, "juice", 4);
      putInBasket(timsBasket, "cup", 201);
      putInBasket(timsBasket, "bread", 1);
        System.out.println(timsBasket);

        System.out.println(stockList);

        Basket basket=new Basket("customer");
      putInBasket(basket,"cup",100);
      putInBasket(basket,"juice",5);
        putOutOfBasket(basket,"cup",1);
        System.out.println(basket);

        putOutOfBasket(timsBasket,"car",1);
        putOutOfBasket(timsBasket,"cup",9);
        putOutOfBasket(timsBasket,"car",1);
        System.out.println(timsBasket);

        System.out.println(timsBasket);

        putOutOfBasket(timsBasket,"bread",1);
        putOutOfBasket(timsBasket,"cup",3);
        putOutOfBasket(timsBasket,"juice",4);
        putOutOfBasket(timsBasket,"cup",3);
        System.out.println(timsBasket);

        System.out.println("\ndisplay stock list before and after checkout");
        System.out.println(basket);
        System.out.println(stockList);
        sellBasket(basket);
        System.out.println(basket);
        System.out.println(stockList);

        sellBasket(timsBasket);
        System.out.println(timsBasket);
    }
    public static boolean putInBasket(Basket basket,String item,int quantity){
        StockItem itemInStock=stockList.getList().get(item);
        if (itemInStock==null){
            System.out.println("We do not sell that item!!");
            return false;
        }
        if (basket!=null && quantity>0){
            basket.addToBasket(itemInStock,quantity);

        }
        return true;
    }

    public static int putOutOfBasket(Basket basket,String item,int quantity){
        StockItem itemInStock=stockList.getList().get(item);
        if (basket!=null && quantity>0 && itemInStock!=null && basket.getList().getOrDefault(itemInStock,0)>0){
          return   basket.removeFromBasket(itemInStock,quantity);
        }
        return 0;
    }

    public static void sellBasket(Basket basket){
        basket.sellBasket();
    }
}
