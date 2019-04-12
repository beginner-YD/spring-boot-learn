package net.learn.product_service.service.impl;

import net.learn.product_service.domain.Product;
import net.learn.product_service.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {

    private final Logger logger= LoggerFactory.getLogger(getClass());

    private static final Map<Integer,Product> daoMap=new HashMap<>();

    static {
        Product p1 = new Product(1, "Iphone X", 9999, 10);
        Product p2 = new Product(2, "冰箱", 99, 10);
        Product p3 = new Product(3, "洗衣机", 999, 10);
        Product p4 =new Product(4,"床",9,10);
        Product p5 =new Product(5,"被子",1,10);
        daoMap.put(p1.getId(),p1);
        daoMap.put(p2.getId(),p2);
        daoMap.put(p3.getId(),p3);
        daoMap.put(p4.getId(),p4);
        daoMap.put(p5.getId(),p5);

    }

    @Override
    public List<Product> listProduct() {
        Collection<Product> collection = daoMap.values();
        return new ArrayList<>(collection);
    }

    @Override
    public Product findById(int id) {
        logger.info("service findById");
        return daoMap.get(id);
    }
}
