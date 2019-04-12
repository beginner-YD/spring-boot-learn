package net.learn.order_service.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductOrder implements Serializable {

    private int id;

    private String productName;
    /**
     * 订单流水号
     */
    private String tradeNo;

    private int price;

    private Date createTime;

    private int userId;

    private String userName;

}
