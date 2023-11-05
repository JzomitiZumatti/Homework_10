import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

public class Main {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static void main(String[] args) {
        BoardOfProducts boardOfProducts = new BoardOfProducts();

        System.out.println(ANSI_RED + "First task:" + ANSI_RESET);
        boardOfProducts.add("Book", 110.0);
        boardOfProducts.add("Watch", 250.0);
        boardOfProducts.add("Book", 251.0);
        boardOfProducts.add("Book", 20.0);
        boardOfProducts.add("Book", 255.0);
        boardOfProducts.add("Jacket", 371.0);
        boardOfProducts.add("Book", 11.0);
        boardOfProducts.add("Book", 555.0);
        boardOfProducts.add("Pants", 333.0);
        boardOfProducts.add("Glasses", 1110.0);

        boardOfProducts.getProductList().stream()
                .forEach(System.out::println);

        boardOfProducts.clearBoard();
        System.out.println(ANSI_RED + "\nSecond task:" + ANSI_RESET);
        boardOfProducts.add("Book", 110.0, false);
        boardOfProducts.add("Book", 250.0, true);
        boardOfProducts.add("Book", 251, true);
        boardOfProducts.add("Book", 20, false);
        boardOfProducts.add("Book", 255, true);
        boardOfProducts.add("Book", 371, false);
        boardOfProducts.add("Book", 11, false);
        boardOfProducts.add("Book", 555, false);
        boardOfProducts.add("Book", 333, true);
        boardOfProducts.add("Book", 1110, true);

        List<Product> discountedProducts = boardOfProducts.getDiscountProductList();
        discountedProducts.stream()
                .forEach(System.out::println);

        boardOfProducts.clearBoard();
        System.out.println(ANSI_RED + "\nThird task:" + ANSI_RESET);
        boardOfProducts.add("Jacket", 110.0, false);
        boardOfProducts.add("Book", 250.0, true);
        boardOfProducts.add("T-shirt", 251, true);
        boardOfProducts.add("Book", 20, false);
        boardOfProducts.add("Book", 255, true);
        boardOfProducts.add("Pants", 371, false);
        boardOfProducts.add("Boots", 11, false);
        boardOfProducts.add("Shirt", 555, false);
        boardOfProducts.add("Book", 333, true);
        boardOfProducts.add("Book", 1110, true);

        boardOfProducts.getCheapestProduct();


        boardOfProducts.clearBoard();
        //to be clearly, you need to uncomment 27-31 rows in Product.class
        System.out.println(ANSI_RED + "\nFourth task:" + ANSI_RESET);
        boardOfProducts.add("Jacket", 110.0, false, LocalDateTime.now());
        boardOfProducts.add("Book", 250.0, true, LocalDateTime.now());
        boardOfProducts.add("T-shirt", 251, true, LocalDateTime.now());
        boardOfProducts.add("Book", 20, false, LocalDateTime.now());
        boardOfProducts.add("Book", 255, true, LocalDateTime.now());
        boardOfProducts.add("Pants", 371, false, LocalDateTime.now());
        boardOfProducts.add("Boots", 11, false, LocalDateTime.now());
        boardOfProducts.add("Shirt", 555, false, LocalDateTime.now());
        boardOfProducts.add("Book", 333, true, LocalDateTime.now());
        boardOfProducts.add("Book", 1110, true, LocalDateTime.now());

        List<Product> lastThreeAddedProducts = boardOfProducts.getLastThreeAddedProducts();
        lastThreeAddedProducts.stream()
                .forEach(System.out::println);


        boardOfProducts.clearBoard();
        System.out.println(ANSI_RED + "\nFifth task:" + ANSI_RESET);
        boardOfProducts.add("Book", 75.0, false, LocalDateTime.of(2023, 11, 5, 12, 30, 0));
        boardOfProducts.add("Book", 250.0, true, LocalDateTime.of(2021, 11, 5, 12, 30, 0));
        boardOfProducts.add("T-shirt", 251, true, LocalDateTime.of(2021, 11, 5, 12, 30, 0));
        boardOfProducts.add("Book", 20, false, LocalDateTime.of(2023, 11, 5, 12, 30, 0));
        boardOfProducts.add("Book", 255, true, LocalDateTime.of(2023, 11, 5, 12, 30, 0));
        boardOfProducts.add("Pants", 371, false, LocalDateTime.of(1925, 11, 5, 12, 30, 0));
        boardOfProducts.add("Book", 11, false, LocalDateTime.of(2024, 11, 5, 12, 30, 0));
        boardOfProducts.add("Shirt", 555, false, LocalDateTime.of(3000, 11, 5, 12, 30, 0));
        boardOfProducts.add("Book", 76, true, LocalDateTime.of(858, 11, 5, 12, 30, 0));
        boardOfProducts.add("Book", 73, true, LocalDateTime.of(2023, 11, 5, 12, 30, 0));

        System.out.printf("General price of products from the \"Book\" category which was added this year " +
                "and have a price which doesn't exceed $75 is: $%.2f.", boardOfProducts.generalPrice());


        boardOfProducts.clearBoard();
        System.out.println(ANSI_RED + "\n\nSixth task:" + ANSI_RESET);
        boardOfProducts.add(123154,"Book", 75.0, false, LocalDateTime.now());
        boardOfProducts.add(13354,"Book", 250.0, true, LocalDateTime.now());
        boardOfProducts.add(7486,"T-shirt", 251, true, LocalDateTime.now());
        boardOfProducts.add(968,"Book", 20, false, LocalDateTime.now());
        boardOfProducts.add(434212,"Book", 255, true, LocalDateTime.now());
        boardOfProducts.add(4345,"Pants", 371, false, LocalDateTime.now());
        boardOfProducts.add(43,"Book", 11, false, LocalDateTime.now());
        boardOfProducts.add(4556,"Shirt", 555, false, LocalDateTime.now());
        boardOfProducts.add(24254,"Book", 76, true, LocalDateTime.now());
        boardOfProducts.add(13548,"Book", 73, true, LocalDateTime.now());

        Map<String, List<Product>> groupedProducts = boardOfProducts.groupProductsByType();
        groupedProducts.forEach((type, productList) -> {
            System.out.println("\"" + type + "\",");
            productList.forEach(s -> {
                System.out.println("\t{" + s + "}");
            });
        });
    }


}
