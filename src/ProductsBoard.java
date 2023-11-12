import java.time.Year;
import java.util.*;
import java.util.stream.Collectors;
import java.time.LocalDateTime;

public class ProductsBoard {
    private final List<Product> products;

    public ProductsBoard() {
        this.products = new ArrayList<>();
    }

    public void clearBoard() {
        products.clear();
    }

    public void add(String type, double price) {
        products.add(new Product(type, price));
    }

    public void add(String type, double price, boolean discount) {
        products.add(new Product(type, price, discount));
    }

    public void add(String type, double price, boolean discount, LocalDateTime addingTime) {
        products.add(new Product(type, price, discount, addingTime));
    }

    public void add(int id, String type, double price, boolean discount, LocalDateTime addingTime) {
        products.add(new Product(id, type, price, discount, addingTime));
    }

    public List<Product> getProducts() {
        return products.stream()
                .filter(p -> p.getType().equals("Book"))
                .filter(p -> p.getPrice() > 250)
                .collect(Collectors.toList());
    }

    public List<Product> getDiscountProducts() {
        return products.stream()
                .filter(Product::getDiscount)
                .peek(p -> p.setPrice(p.getPrice() * 0.9))
                .collect(Collectors.toList());
    }

    public void getCheapestProduct() {
        products.stream()
                .filter(p -> p.getType().equals("Book"))
                .min(Comparator.comparing(Product::getPrice))
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("Product from [Book] category didn't find.")
                );
    }

    public List<Product> getLastThreeAddedProducts() {
        return products.stream()
                .sorted(Comparator.comparing(Product::getDateAdded).reversed())
                .limit(3)
                .collect(Collectors.toList());
    }

    public double generalPrice() {
        Year currentYear = Year.now();
        return products.stream()
                .filter(p -> p.getDateAdded().getYear() == currentYear.getValue())
                .filter(p -> p.getType().equals("Book"))
                .filter(p -> p.getPrice() <= 75)
                .mapToDouble(Product::getPrice)
                .sum();
    }

    public Map<String, List<Product>> groupProductsByType() {
        return products.stream()
                .collect(Collectors.groupingBy(Product::getType));
    }

    @Override
    public String toString() {
        return products.toString();
    }
}
