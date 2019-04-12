package net.learn.product_service.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {
    private int id;
    /**
     * 商品名称
     */
    private String name;
    /**
     * 价格，分为单位
     */
    private int price;
    /**
     * 库存
     */
    private int store;
}
