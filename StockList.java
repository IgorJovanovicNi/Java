package com.igorJovanovic;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class StockList {
    private Map<String,StockItem> list;

    public StockList() {
        this.list =new LinkedHashMap<>();
    }

    public int addToStockList(StockItem item) {
        if(item!=null){
        StockItem inStock=list.getOrDefault(item.getName(),item);

        if (inStock!=item){
          return item.addToStock(inStock.getQuantityInStock());
        }
        list.put(item.getName(),item); }
        return item.getQuantityInStock();
    }

    public int reserveItem(String item,int quantity){//if needed
        StockItem inStock=list.get(item);
        if (inStock!=null && quantity>0 && inStock.availableQuantityInStock()>=quantity){
            return inStock.reservedItem(quantity);
        }else{
            return 0;
        }
    }

    public int unReserveItem(String item,int quantity){//if needed
        StockItem inStock=list.get(item);
        if (inStock!=null && quantity>0 && inStock.getReserved()>0){
            return inStock.unReserveItem(quantity);
        }else{
            return 0;
        }
    }

    public int sellItem(String item,int quantity){
         StockItem inStock=list.get(item);
         if (inStock!=null && quantity>0 && inStock.getReserved()>=quantity){
           return inStock.finalizeSell(quantity);
         }else{
             return 0;
         }}

    public Map<String, StockItem> getList() {
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s="List of items in stock: \n";
        for (Map.Entry<String,StockItem> m:list.entrySet()){
            s+=m.getKey()+" quantity that was not reserved: " +
                    ""+m.getValue().availableQuantityInStock()+" " +
                    "price per one item: "+m.getValue().getPrice()+" number of reserved items:" +
                    " "+m.getValue().getReserved()+" \n";
        }
        return    s;
    }

}
