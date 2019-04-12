package net.learn.order_service.service;

import net.learn.order_service.domain.ProductOrder;

public interface ProductOrderService {

    ProductOrder save(int userId,int productId);
}
