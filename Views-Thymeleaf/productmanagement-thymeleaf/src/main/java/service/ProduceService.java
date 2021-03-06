package service;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProduceService implements IProduceService {
    private static final Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "Ice Cream", 100, 200));
        products.put(2, new Product(2, "Cake", 450, 10));
        products.put(3, new Product(3, "Cookie", 1000, 3500));
        products.put(4, new Product(4, "Candy", 50, 2000));
        products.put(5, new Product(5, "Meat", 1500, 100));
        products.put(6, new Product(6, "Alcohol", 10000, 200));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public void findByName(String name) {
    }
}