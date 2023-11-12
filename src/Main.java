import java.util.List;
import java.util.Map;
import java.time.LocalDateTime;

public class Main {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static void main(String[] args) {
        ProductsBoard productsBoard = new ProductsBoard();

        System.out.println(ANSI_RED + "First task:" + ANSI_RESET);
        productsBoard.add("Book", 110.0);
        productsBoard.add("Watch", 250.0);
        productsBoard.add("Book", 251.0);
        productsBoard.add("Book", 20.0);
        productsBoard.add("Book", 255.0);
        productsBoard.add("Jacket", 371.0);
        productsBoard.add("Book", 11.0);
        productsBoard.add("Book", 555.0);
        productsBoard.add("Pants", 333.0);
        productsBoard.add("Glasses", 1110.0);

        productsBoard.getProducts().stream()
                .forEach(System.out::println);

        productsBoard.clearBoard();
        System.out.println(ANSI_RED + "\nSecond task:" + ANSI_RESET);
        productsBoard.add("Book", 110.0, false);
        productsBoard.add("Book", 250.0, true);
        productsBoard.add("Book", 251, true);
        productsBoard.add("Book", 20, false);
        productsBoard.add("Book", 255, true);
        productsBoard.add("Book", 371, false);
        productsBoard.add("Book", 11, false);
        productsBoard.add("Book", 555, false);
        productsBoard.add("Book", 333, true);
        productsBoard.add("Book", 1110, true);

        List<Product> discountedProducts = productsBoard.getDiscountProducts();
        discountedProducts.stream()
                .forEach(System.out::println);

        productsBoard.clearBoard();
        System.out.println(ANSI_RED + "\nThird task:" + ANSI_RESET);
        productsBoard.add("Jacket", 110.0, false);
        productsBoard.add("Book", 250.0, true);
        productsBoard.add("T-shirt", 251, true);
        productsBoard.add("Book", 20, false);
        productsBoard.add("Book", 255, true);
        productsBoard.add("Pants", 371, false);
        productsBoard.add("Boots", 11, false);
        productsBoard.add("Shirt", 555, false);
        productsBoard.add("Book", 333, true);
        productsBoard.add("Book", 1110, true);

        productsBoard.getCheapestProduct();


        productsBoard.clearBoard();
        System.out.println(ANSI_RED + "\nFourth task:" + ANSI_RESET);
        productsBoard.add("Jacket", 110.0, false, LocalDateTime.now());
        productsBoard.add("Book", 250.0, true, LocalDateTime.now());
        productsBoard.add("T-shirt", 251, true, LocalDateTime.now());
        productsBoard.add("Book", 20, false, LocalDateTime.now());
        productsBoard.add("Book", 255, true, LocalDateTime.now());
        productsBoard.add("Pants", 371, false, LocalDateTime.now());
        productsBoard.add("Boots", 11, false, LocalDateTime.now());
        productsBoard.add("Shirt", 555, false, LocalDateTime.now());
        productsBoard.add("Book", 333, true, LocalDateTime.now());
        productsBoard.add("Book", 1110, true, LocalDateTime.now());

        List<Product> lastThreeAddedProducts = productsBoard.getLastThreeAddedProducts();
        lastThreeAddedProducts.stream()
                .forEach(System.out::println);


        productsBoard.clearBoard();
        System.out.println(ANSI_RED + "\nFifth task:" + ANSI_RESET);
        productsBoard.add("Book", 75.0, false, LocalDateTime.of(2023, 11, 5, 12, 30, 0));
        productsBoard.add("Book", 250.0, true, LocalDateTime.of(2021, 11, 5, 12, 30, 0));
        productsBoard.add("T-shirt", 251, true, LocalDateTime.of(2021, 11, 5, 12, 30, 0));
        productsBoard.add("Book", 20, false, LocalDateTime.of(2023, 11, 5, 12, 30, 0));
        productsBoard.add("Book", 255, true, LocalDateTime.of(2023, 11, 5, 12, 30, 0));
        productsBoard.add("Pants", 371, false, LocalDateTime.of(1925, 11, 5, 12, 30, 0));
        productsBoard.add("Book", 11, false, LocalDateTime.of(2024, 11, 5, 12, 30, 0));
        productsBoard.add("Shirt", 555, false, LocalDateTime.of(3000, 11, 5, 12, 30, 0));
        productsBoard.add("Book", 76, true, LocalDateTime.of(858, 11, 5, 12, 30, 0));
        productsBoard.add("Book", 73, true, LocalDateTime.of(2023, 11, 5, 12, 30, 0));

        System.out.printf("General price of products from the \"Book\" category which was added this year " +
                "and have a price which doesn't exceed $75 is: $%.2f.", productsBoard.generalPrice());


        productsBoard.clearBoard();
        System.out.println(ANSI_RED + "\n\nSixth task:" + ANSI_RESET);
        productsBoard.add(123154,"Book", 75.0, false, LocalDateTime.now());
        productsBoard.add(13354,"Book", 250.0, true, LocalDateTime.now());
        productsBoard.add(7486,"T-shirt", 251, true, LocalDateTime.now());
        productsBoard.add(968,"Book", 20, false, LocalDateTime.now());
        productsBoard.add(434212,"Book", 255, true, LocalDateTime.now());
        productsBoard.add(4345,"Pants", 371, false, LocalDateTime.now());
        productsBoard.add(43,"Book", 11, false, LocalDateTime.now());
        productsBoard.add(4556,"Shirt", 555, false, LocalDateTime.now());
        productsBoard.add(24254,"Book", 76, true, LocalDateTime.now());
        productsBoard.add(13548,"Book", 73, true, LocalDateTime.now());

        Map<String, List<Product>> groupedProducts = productsBoard.groupProductsByType();
        groupedProducts.forEach((type, productList) -> {
            System.out.println("\"" + type + "\",");
            productList.forEach(s -> System.out.println("\t{" + s + "}"));
        });
    }
}
