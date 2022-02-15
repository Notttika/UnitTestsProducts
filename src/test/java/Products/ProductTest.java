package Products;

import blogs.BlogPost;
import blogs.BlogPostType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Named;
import org.junit.jupiter.api.Test;

import javax.lang.model.element.Name;
import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    @Test
    public void checkPriceIsLower200() {
        // given
        List<Product> productList = Arrays.asList(
                new Product("chair", ProductType.furniture, 500, 4),
                new Product("pullover", ProductType.clothes, 200, 1),
                new Product("meat", ProductType.food, 65, 10),
                new Product("coat", ProductType.clothes, 120, 2),
                new Product("sofa", ProductType.furniture, 980, 20),
                new Product("sausage", ProductType.food, 110, 5),
                new Product("skirt", ProductType.clothes, 250, 3),
                new Product("table", ProductType.furniture, 400, 12),
                new Product("vegetables", ProductType.food, 60, 6));

        // when
        long priceIsLower200 = productList.stream().filter(p -> p.getPrice() > 200).count();
        System.out.println(priceIsLower200);
        // then
        Assertions.assertThat(priceIsLower200).isEqualTo(4);

    }

    @Test
    public void checkElementWithWordTable() {
        // given
        List<Product> productList = Arrays.asList(
                new Product("chair", ProductType.furniture, 500, 4),
                new Product("pullover", ProductType.clothes, 200, 1),
                new Product("meat", ProductType.food, 65, 10),
                new Product("coat", ProductType.clothes, 120, 2),
                new Product("sofa", ProductType.furniture, 980, 20),
                new Product("sausage", ProductType.food, 110, 5),
                new Product("skirt", ProductType.clothes, 250, 3),
                new Product("table", ProductType.furniture, 400, 12),
                new Product("vegetables", ProductType.food, 60, 6));

        // when
        boolean wordTable = productList.stream().anyMatch(p -> p.getName() == "table");
        System.out.println(wordTable);
        // then
        Assertions.assertThat(wordTable).isTrue();

    }

    @Test
    public void checkNamesOfProducts() {
        // given
        List<Product> productList = Arrays.asList(
                new Product("chair", ProductType.furniture, 500, 4),
                new Product("pullover", ProductType.clothes, 200, 1),
                new Product("meat", ProductType.food, 65, 10),
                new Product("coat", ProductType.clothes, 120, 2),
                new Product("sofa", ProductType.furniture, 980, 20),
                new Product("sausage", ProductType.food, 110, 5),
                new Product("skirt", ProductType.clothes, 250, 3),
                new Product("table", ProductType.furniture, 400, 12),
                new Product("vegetables", ProductType.food, 60, 6));

        // when
        List<String> namesProducts = productList.stream().map(e -> e.getName()).collect(Collectors.toList());
        System.out.println(namesProducts);
        // then
        Assertions.assertThat(namesProducts).containsExactly("chair", "pullover", "meat", "coat", "sofa", "sausage", "skirt", "table", "vegetables");

    }

    @Test
    public void checkPricePositive() {
        // given
        List<Product> productList = Arrays.asList(
                new Product("chair", ProductType.furniture, 500, 4),
                new Product("pullover", ProductType.clothes, 200, 1),
                new Product("meat", ProductType.food, 65, 10),
                new Product("coat", ProductType.clothes, 120, 2),
                new Product("sofa", ProductType.furniture, 980, 20),
                new Product("sausage", ProductType.food, 110, 5),
                new Product("skirt", ProductType.clothes, 250, 3),
                new Product("table", ProductType.furniture, 400, 12),
                new Product("vegetables", ProductType.food, 60, 6));

        // when
        boolean pricePositive = productList.stream().anyMatch(e -> e.getPrice() > 0);
        System.out.println(pricePositive);
        // then
        Assertions.assertThat(pricePositive).isTrue();
    }

    @Test
    public void checkProductQuantity() {
        // given
        List<Product> productList = Arrays.asList(
                new Product("chair", ProductType.furniture, 500, 4),
                new Product("pullover", ProductType.clothes, 200, 1),
                new Product("meat", ProductType.food, 65, 10),
                new Product("coat", ProductType.clothes, 120, 2),
                new Product("sofa", ProductType.furniture, 980, 20),
                new Product("sausage", ProductType.food, 110, 5),
                new Product("skirt", ProductType.clothes, 250, 3),
                new Product("table", ProductType.furniture, 400, 12),
                new Product("vegetables", ProductType.food, 60, 6));

        // when
        long productQuantity = productList.stream().map(e -> e.getName()).count();
        System.out.println(productQuantity);
        // then
        Assertions.assertThat(productQuantity).isEqualTo(9);
    }

    @Test
    public void groupProductsByTheirTypes() {
        // given
        List<Product> productList = Arrays.asList(
                new Product("chair", ProductType.furniture, 500, 4),
                new Product("pullover", ProductType.clothes, 200, 1),
                new Product("meat", ProductType.food, 65, 10),
                new Product("coat", ProductType.clothes, 120, 2),
                new Product("sofa", ProductType.furniture, 980, 20),
                new Product("sausage", ProductType.food, 110, 5),
                new Product("skirt", ProductType.clothes, 250, 3),
                new Product("table", ProductType.furniture, 400, 12),
                new Product("vegetables", ProductType.food, 60, 6));
        // when
        Map<ProductType, List<Product>> productTypeListMap = productList.stream().collect(Collectors.groupingBy(product -> product.getType()));
        System.out.println(productTypeListMap);
        // then
        assertThat(productTypeListMap.get(ProductType.food).size()).isEqualTo(3);
        assertThat(productTypeListMap.get(ProductType.clothes).size()).isEqualTo(3);
        assertThat(productTypeListMap.get(ProductType.furniture).size()).isEqualTo(3);


    }
}