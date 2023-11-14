package co.database;

import co.model.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProductDataBase {
    List<Product> products;

    public ProductDataBase() {
        products = new ArrayList<>();
        products.add(new Product(1l, "Pepsi", 30, 2000.0, LocalDate.now()));
        products.add(new Product(2l, "Santa", 50, 2500.0, LocalDate.now()));
        products.add(new Product(3l, "Cocacola", 30, 2000.0, LocalDate.now()));
        products.add(new Product(4l, "Sting", 50, 2500.0, LocalDate.now()));
        products.add(new Product(5l, "Wurk", 50, 2000.0, LocalDate.now()));
    }

    public List<Product> getProducts() {
        return products;
    }
}
