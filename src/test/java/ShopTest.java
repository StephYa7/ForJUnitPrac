import Calculator.Calculator;
import Shop.Shop;
import Shop.Product;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ShopTest {


    Shop test() {
        Shop shop = new Shop();
        Product product1 = new Product(5, "ejtz");
        Product product2 = new Product(4, "ylfqqmn");
        Product product3 = new Product(6, "eeila");
        Product product4 = new Product(3, "nnodrm");
        Product product5 = new Product(7, "tckvts");
        Product product6 = new Product(2, "syquszz");
        Product product7 = new Product(8, "gqmjevj");
        Product product8 = new Product(1, "swsf");
        List<Product> products = new ArrayList<Product>();
        Collections.addAll(products, product1, product2, product3, product4, product5, product6, product7, product8);
        shop.setProducts(products);
        return shop;
    }

    @Test
    void checkingSize() {
        Shop shop = test();
        assertThat(shop.sortProductsByPrice().size()).isEqualTo(8);
    }

    @Test
    void checkingSortingProductByPrice() {
        Shop shop = test();
        List<Product> products = shop.getProducts();
        products.sort(Comparator.comparingInt((Product::getCost)));
        assertThat(shop.sortProductsByPrice()).isEqualTo(products);
    }

    @Test
    void checkingGetMostExpensiveProduct() {
        Shop shop = test();
        List<Product> products = shop.getProducts();
        Product mostExpensive = products.stream().max(Comparator.comparingInt((Product::getCost))).get();
        assertThat(shop.getMostExpensiveProduct()).isEqualTo(mostExpensive);
        assertThat(shop.getMostExpensiveProduct()).isEqualTo(new Product(8, "gqmjevj"));
    }
}