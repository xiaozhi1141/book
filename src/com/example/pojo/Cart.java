package com.example.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 购物车对象
 */
public class Cart {
//    private Integer totalCount;
//    private BigDecimal totalPrice;
    private Map<Integer,CartItem> items = new LinkedHashMap<Integer,CartItem>();

    /**
     * 添加商品项
     * @param cartItem
     */
    public void addItem(CartItem cartItem){
        CartItem item = items.get(cartItem.getId());
        if(item == null){
            //之前没有添加个此商品
            items.put(cartItem.getId(),cartItem);
        } else{
            item.setCount(item.getCount() + 1); //数量累加
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount()))); //更新总金额
        }
    }

    /**
     * 删除商品项
     * @param id
     */
    public void deleteItem(Integer id){
        items.remove(id);
    }

    /**
     * 清空购物车
     */
    public void clear(){
        items.clear();
    }

    /**
     * 修改商品数量
     * @param id
     */
    public void updateCount(Integer id,Integer count) {
        CartItem cartItem = items.get(id);
        if (cartItem != null) {
            cartItem.setCount(count); //修改商品数量
            cartItem.setTotalPrice(cartItem.getPrice().multiply(new BigDecimal(cartItem.getCount()))); //更新总金额
        }
    }

    public Integer getTotalCount() {
        Integer totalCount = 0;
        //遍历求总数量
        for(Map.Entry<Integer,CartItem>entry : items.entrySet()){
            totalCount += entry.getValue().getCount();
        }
//        for (CartItem value : items.values()) {
//
//        }
        return totalCount;
    }


    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);
        for (CartItem value : items.values()) {
                totalPrice = totalPrice.add(value.getTotalPrice());
        }
        return totalPrice;
    }


    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }
}
