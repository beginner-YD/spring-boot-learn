package net.learn.order_service.service;

import net.learn.order_service.fallback.ProductClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "product-service",fallback = ProductClientFallback.class)
@Component
public interface ProductClient {

    @RequestMapping("/api/v1/product/find")
    String findById(@RequestParam(value = "id")int id);
}
