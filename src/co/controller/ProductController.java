package co.controller;

import co.model.Product;
import co.service.ProductService;
import co.singleton.Singleton;
import co.view.ProductView;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ProductController {
    private final Scanner scanner;
    private final ProductService productService;
    private Product product;


    public ProductController() {
        scanner = Singleton.scanner();
        productService = Singleton.productService();
        product = Singleton.products();
    }

    //Product List
    public void listPro() {
        List<Product> products = productService.select();
        ProductView.printProductList(products);
    }

    // Create Product
    public void addPro() {
        System.out.println("Enter Product ID: ");
        product.setId(scanner.nextLong());
        System.out.print("Enter Product Name :");
        product.setName(scanner.next());
        System.out.print("Enter Product Price :");
        product.setPrice(scanner.nextDouble());
        System.out.print("Enter Product Qty :");
        product.setQty(scanner.nextInt());
        product.setImportedDate(LocalDate.now());
        ProductView.printInsertProdcut(productService.insert(product));
    }

    //Update Product Info
    public void updateById() {
        System.out.println("Enter Id product to update :");
        product = productService.selectById(scanner.nextLong());
        System.out.print("Enter Product Name :");
        product.setName(scanner.next());
        System.out.print("Enter Product Price :");
        product.setPrice(scanner.nextDouble());
        System.out.print("Enter Product Qty :");
        product.setQty(scanner.nextInt());
        product.setImportedDate(LocalDate.now());
        ProductView.printUpdateProduct(productService.updateById(product));
    }

    //Delete Product
    public void deleteById() {
        System.out.println("Enter ID to delete : ");
        Long productID = Long.parseLong(scanner.next());
        product = productService.deleteById(productID);

    }
}
