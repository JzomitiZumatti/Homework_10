import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Product {
    private int id;
    private final String type;
    private double price;
    private boolean discount;
    private LocalDateTime dateAdded;

    public Product(String type, double price) {
        this.type = type;
        this.price = price;
    }

    public Product(String type, double price, boolean Discount) {
        this.type = type;
        this.price = price;
        this.discount = Discount;
    }

    public Product(String type, double price, boolean discount, LocalDateTime dateAdded) {
        this.type = type;
        this.price = price;
        this.discount = discount;
        this.dateAdded = dateAdded;
    }

    public Product(int id, String type, double price, boolean discount, LocalDateTime dateAdded) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.discount = discount;
        this.dateAdded = dateAdded;
    }

    public String getType() {
        return type;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public boolean getDiscount() {
        return discount;
    }

    public LocalDateTime getDateAdded() {
        return dateAdded;
    }
    @Override
    public String toString() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
        return Stream.of(
                        "type: \"" + type + "\"",
                        "price: " + price,
                        (discount) ? "discount: " + discount : "discount: false",
                        (dateAdded != null) ? "createDate: " + dateAdded.format(dateFormatter) : null
                )
                .filter(Objects::nonNull)
                .collect(Collectors.joining(", "));
    }
}