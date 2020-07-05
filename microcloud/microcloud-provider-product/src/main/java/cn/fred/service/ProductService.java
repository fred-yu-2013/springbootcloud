package cn.fred.service;

import cn.fred.config.vo.Product;

import java.util.List;

public interface ProductService {
    Product get(long id);
    boolean add(Product product);
    List<Product> list();
}
