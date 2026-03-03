package baithuchanh;

import java.util.Scanner;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ProductRepository productRepository = new ProductRepository();
        ElectronicProduct electronic1 = new ElectronicProduct("E001", "Tivi", 1000, 12);
        ElectronicProduct electronic2 = new ElectronicProduct("E002", "Tủ lạnh", 1500, 14);
        FoodProduct food1 = new FoodProduct("F001", "Bánh ngọt", 20, 10);
        FoodProduct food2 = new FoodProduct("F002", "Sữa tươi", 10, 5);

        productRepository.add(electronic1);
        productRepository.add(electronic2);
        productRepository.add(food1);
        productRepository.add(food2);

        System.out.println("Danh sách sản phẩm");
        List<Product> allProducts = productRepository.findAll();
        for (Product product : allProducts) {
            product.displayInfo();
            System.out.println("tiền:" + product.calculateFinalPrice());
        }

        System.out.println("Tìm sản phẩm theo id");
        Product foundProduct = productRepository.findById("E001");
        if (foundProduct != null) {
            foundProduct.displayInfo();
            System.out.println("tiền: " + foundProduct.calculateFinalPrice());
        } else {
            System.out.println("Không tìm thấy sản phẩm");
        }

    }
}