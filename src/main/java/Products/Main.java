package Products;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Product product = new Product("chair", ProductType.furniture, 500, 4);
        Product product1 = new Product("pullover", ProductType.clothes, 200, 1);
        Product product2 = new Product("meat", ProductType.food, 65, 10);
        Product product3 = new Product("coat", ProductType.clothes, 120, 2);
        Product product4 = new Product("sofa", ProductType.furniture, 980, 20);
        Product product5 = new Product("sausage", ProductType.food, 110, 5);
        Product product6 = new Product("skirt", ProductType.clothes, 250, 3);
        Product product7 = new Product("table", ProductType.furniture, 400, 12);
        Product product8 = new Product("vegetables", ProductType.food, 60, 6);

        Product[] products = {product, product1, product2, product3, product4, product5, product6, product7, product8};
         System.out.println(Arrays.toString(products));

        //ArrayList<Product> productList = new ArrayList<>(Arrays.asList(products));

        ArrayList<Product> productList = new ArrayList <> ();
        productList.add(product);
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        productList.add(product5);
        productList.add(product6);
        productList.add(product7);
        productList.add(product8);


        System.out.println("All products: " + productList);

        List<Product> productsFood = productList.stream().filter(p -> p.getType().equals(ProductType.food)).collect(Collectors.toList());
        List<Product> productsFurniture = productList.stream().filter(p -> p.getType().equals(ProductType.furniture)).collect(Collectors.toList());
        List<Product> productsClothes = productList.stream().filter(p -> p.getType().equals(ProductType.clothes)).collect(Collectors.toList());
        System.out.println("Food: " + productsFood);
        System.out.println("Furniture: " + productsFurniture);
        System.out.println("Clothes: " + productsClothes);


        long priceIsLower200 = productList.stream().filter(p -> p.getPrice() > 200).count();
        System.out.println("price is lower 200 - " + priceIsLower200);

        List<Product> wordsWithS = productList.stream().filter(p -> p.getName().startsWith("s")).collect(Collectors.toList());
        System.out.println("Words with s:" + wordsWithS);

        List<Product> wordsTable = productList.stream().filter(p -> p.getName() == "table").collect(Collectors.toList());
        System.out.println("Words table: " + wordsTable);

        long wordsStartsWithS = productList.stream().filter(p -> p.getName().startsWith("s")).count();
        System.out.println("Words starts with S: " + wordsStartsWithS);

        long wordTable = productList.stream().filter(p -> p.getName() == "table").count();
        System.out.println("Word table: " + wordTable);

    }
}