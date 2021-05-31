package com.example.webflux.demo.reactor.controller;

import com.example.webflux.demo.reactor.model.Product;
import com.example.webflux.demo.reactor.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ProductController {
    @Autowired
    private IProductService productService;

    /**
     * id 查询
     *
     * @param id
     * @return
     */
    @GetMapping("/product/{id}")
    public Mono<Product> getProductId(@PathVariable int id) {
        return productService.getProductById(id);
    }

    /**
     * @return
     */
    @GetMapping("/product")
    public Flux<Product> getProducts() {
        return productService.getAllProduct();
    }

    /**
     * @param Product
     * @return
     */
    @PostMapping("/saveProduct")
    public Mono<Void> saveProduct(@RequestBody Product Product) {
        Mono<Product> ProductMono = Mono.just(Product);
        return productService.saveProductInfo(ProductMono);
    }
}
