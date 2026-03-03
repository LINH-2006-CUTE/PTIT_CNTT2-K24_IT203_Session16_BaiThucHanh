package baithuchanh;

import java.util.List;
import java.util.Scanner;

import java.util.*;

class ProductRepository implements IRepository<Product> {
    private ArrayList<Product> productList = new ArrayList<>();
    private HashMap<String, Product> productMap = new HashMap<>();

    @Override
    public boolean add(Product item) {
        if (item == null) return false;
        productList.add(item);
        productMap.put(item.getId(), item);
        return true;
    }

    @Override
    public boolean removeById(String id) {
        if (id == null || id.isEmpty()) return false;
        Product product = findById(id);
        if (product != null) {
            productList.remove(product);
            productMap.remove(id);
            return true;
        }
        return false;
    }

    @Override
    public Product findById(String id) {
        if (id == null || id.isEmpty()) return null;
        return productMap.get(id);
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }
}