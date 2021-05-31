package com.example.webflux.demo.reactor.service.impl;

import com.example.webflux.demo.reactor.model.Product;
import com.example.webflux.demo.reactor.service.IProductService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProductServiceImpl implements IProductService {
    //创建 map 集合存储数据
    public Map<Integer, Product> products = new HashMap<>();

    public ProductServiceImpl() {
        for (int i = 1; i <= 10; i++) {
            this.products.put(i, new Product(i, "P1001" + i, "苹果-" + i));
        }
    }

    @Override
    public Mono<Product> getProductById(int id) {
        return Mono.justOrEmpty(this.products.get(id));
    }

    @Override
    public Flux<Product> getAllProduct() {
        return Flux.fromIterable(this.products.values());
    }

    @Override
    public Mono<Void> saveProductInfo(Mono<Product> ProductMono) {
        return ProductMono.doOnNext(product -> {
            //向 map 集合里面放值
            int id = products.size() + 1;
            products.put(id, product);
        }).thenEmpty(Mono.empty());
    }
}
