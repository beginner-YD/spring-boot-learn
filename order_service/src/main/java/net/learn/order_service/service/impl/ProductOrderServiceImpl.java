package net.learn.order_service.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import net.learn.order_service.domain.ProductOrder;
import net.learn.order_service.service.ProductClient;
import net.learn.order_service.service.ProductOrderService;
import net.learn.order_service.utils.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class ProductOrderServiceImpl implements ProductOrderService {

    private final Logger logger= LoggerFactory.getLogger(getClass());

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private ProductClient productClient;

//    @Autowired
//    private LoadBalancerClient loadBalancerClient;

    @Override
    public ProductOrder save(int userId, int productId) {

        if(userId==1){
            return null;
        }

        //调用订单服务
        String response = productClient.findById(productId);

        //调用用户服务，获取用户名称，用户的级别或者积分信息
        // TODO

        logger.info("service save order");

        JsonNode jsonNode = JsonUtils.str2JsonNode(response);


        //Map<String,Object> productMap = restTemplate.getForObject("http://product-service/api/v1/product/find?id=" + productId, Map.class);

        //调用方式2
//        ServiceInstance instance = loadBalancerClient.choose("PRODUCT-SERVICE");
//        System.out.println(instance.getHost()+":"+instance.getPort());
//
//        String url = String.format("http://%s:%s/api/v1/product/find?id=" + productId, instance.getHost(), instance.getPort());
//        RestTemplate restTemplate = new RestTemplate();
//        Map<String,Object> productMap =restTemplate.getForObject(url,Map.class);

        ProductOrder productOrder = new ProductOrder();
        productOrder.setCreateTime(new Date());
        productOrder.setUserId(userId);
        productOrder.setTradeNo(UUID.randomUUID().toString());
        //productOrder.setProductName(productMap.get("name").toString());
        productOrder.setProductName(jsonNode.get("name").toString());
        //productOrder.setPrice(Integer.parseInt(productMap.get("price").toString()));
        productOrder.setPrice(Integer.parseInt(jsonNode.get("price").toString()));
        productOrder.setUserName("李光洙");
        return productOrder;
    }
}
