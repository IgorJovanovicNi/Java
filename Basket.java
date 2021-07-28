package com.igorJovanovic;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class Basket {
    private String name;
    private Map<StockItem,Integer> list;

    public Basket(String name) {
        this.name = name;
        this.list=new LinkedHashMap<>();
    }

    public int addToBasket(StockItem item,int quantity){
        int inBasket=list.getOrDefault(item,0);
        if (item!=null && quantity>0 && item.availableQuantityInStock()>=quantity){
            list.put(item,quantity+inBasket);

            return    item.reservedItem(inBasket+quantity);
            }
        return 0;
        }

        public int removeFromBasket(StockItem item,int quantity){
       if (item!=null && quantity>0 && list.containsKey(item)){
           int inBasket= list.getOrDefault(item,0);
           if (quantity==inBasket){
               list.remove(item);
               return item.unReserveItem(quantity);
           }else if (inBasket>quantity){
               int temp=inBasket-quantity;
               list.put(item,temp);
               return item.unReserveItem(temp);
           } }
       return 0;
    }

    public void sellBasket(){
        for (Map.Entry<StockItem,Integer> list: list.entrySet()){
            StockList listItem=new StockList();
            listItem.sellItem(list.getKey().getName(),list.getValue());
        }
        list.clear();
    }


    public Map<StockItem, Integer> getList() {
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        double totalPrice=0;
        String s="\n"+this.name+"'s basket list of items: \n";
        for (Map.Entry<StockItem,Integer> m:list.entrySet()){
            s+=m.getKey().getName()+" quantity: "+m.getValue()+" price per one item: "+m.getKey().getPrice()+" \n";
            totalPrice+=(m.getValue() * m.getKey().getPrice());
        }
        return    s+" Total price of the basket is: "+String.format("%.2f",totalPrice)+"\n";
    }
}
