//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

    public class Main {
        public static void main(String[] args) {
            // a) Tạo danh sách sản phẩm
            ProductRepository productRepository = new ProductRepository();
            ElectronicProduct electronic1 = new ElectronicProduct("E001", "Tivi", 1000.0, 12);
            ElectronicProduct electronic2 = new ElectronicProduct("E002", "Tủ lạnh", 1500.0, 24);
            FoodProduct food1 = new FoodProduct("F001", "Bánh ngọt", 20.0, 10);
            FoodProduct food2 = new FoodProduct("F002", "Sữa tươi", 10.0, 5);

            productRepository.add(electronic1);
            productRepository.add(electronic2);
            productRepository.add(food1);
            productRepository.add(food2);

            // b) Thực hiện các thao tác nghiệp vụ
            System.out.println("--- Danh sách sản phẩm ---");
            List<Product> allProducts = productRepository.findAll();
            for (Product product : allProducts) {
                product.displayInfo();
                System.out.println("Thành tiền: " + product.calculateFinalPrice());
            }

            System.out.println("\n--- Tìm sản phẩm theo id ---");
            Product foundProduct = productRepository.findById("E001");
            if (foundProduct != null) {
                foundProduct.displayInfo();
                System.out.println("Thành tiền: " + foundProduct.calculateFinalPrice());
            } else {
                System.out.println("Không tìm thấy sản phẩm");
            }

            System.out.println("\n--- Sắp xếp theo giá tăng dần ---");
            Collections.sort(allProducts, Comparator.comparingDouble(Product::calculateFinalPrice));
            for (Product product : allProducts) {
                product.displayInfo();
                System.out.println("Thành tiền: " + product.calculateFinalPrice());
            }

            System.out.println("\n--- Thống kê số lượng sản phẩm theo loại ---");
            Map<String, Long> productCounts = allProducts.stream()
                    .collect(Collectors.groupingBy(p -> p.getClass().getSimpleName(), Collectors.counting()));
            System.out.println(productCounts);
        }
    }