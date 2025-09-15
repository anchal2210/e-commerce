package src.service;

import src.model.Product;
import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private List<Product> orderedProducts = new ArrayList<>();

    public void orderProduct(Product product) {
        orderedProducts.add(product);
    }

    public List<Product> getOrderedProducts() {
        return orderedProducts;
    }
}
