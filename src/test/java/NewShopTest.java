import NewShop.Cart;
import NewShop.Product;
import NewShop.Shop;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class NewShopTest {
    public static List<Product> getStoreItems() {
        List<Product> products = new ArrayList<>();

        String[] productNames = {"bacon", "beef", "ham", "salmon", "carrot"
                , "potato", "onion", "apple", "melon", "rice", "eggs", "yogurt"};
        Double[] productPrice = {170.00d, 250.00d, 200.00d, 150.00d, 15.00d
                , 30.00d, 20.00d, 59.00d, 88.00d, 100.00d, 80.00d, 55.00d};
        Integer[] stock = {10, 10, 10, 10, 10, 10, 10, 70, 13, 30, 40, 60};

        for (int i = 0; i < productNames.length; i++) {
            products.add(new Product(i + 1, productNames[i], productPrice[i], stock[i]));
        }
        return products;
    }

    private ByteArrayOutputStream output = new ByteArrayOutputStream();

    private Shop shop;
    private Cart cart;

    @BeforeEach
    void setup() {
        shop = new Shop(getStoreItems());
        cart = new Cart(shop);
    }
/*
            ID | Название  | Цена, р. | Кол-во в магазине, шт.
            1  | bacon     | 170.0    | 10
            2  | beef      | 250.0    | 10
            3  | ham       | 200.0    | 10
            4  | salmon    | 150.0    | 10
            5  | carrot    | 15.0     | 10
            6  | potato    | 30.0     | 10
            7  | onion     | 20.0     | 10
            8  | apple     | 59.0     | 70
            9  | melon     | 88.0     | 13
            10 | rice      | 100.0    | 30
            11 | eggs      | 80.0     | 40
            12 | yogurt    | 55.0     | 60
*/

    @Test
    void priceCartIsCorrectCalculated() {
        cart.addProductToCartByID(2);
        cart.addProductToCartByID(3);
        assertThat(cart.getTotalPrice()).isEqualTo(250 + 200);
    }

    @Test
    void whenChangingCartCostRecalculationIsCalled() {
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(2);
        cart.addProductToCartByID(3);
        cart.addProductToCartByID(4);
        cart.addProductToCartByID(5);
        cart.removeProductByID(5);
        assertThat(cart.getTotalPrice()).isEqualTo(770);

    }

    void quantityProductsStoreChanging() {
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(1);
        assertThat(shop.getProductsShop().get(0).getQuantity()).isEqualTo(7);
    }

    @Test
    void lastProductsDisappearFromStore() {
        for (int i = 0; i < 10; i++) {
            cart.addProductToCartByID(1);
        }
        System.setOut(new PrintStream(output));
        cart.addProductToCartByID(1);
        assertThat(output.toString().trim()).isEqualTo("Этого товара нет в наличии");


    }

    @Test
    void deletedProductIsReturnedToShop() {
        int before = shop.getProductsShop().get(2).getQuantity();
        for (int i = 0; i < 3; i++) {
            cart.addProductToCartByID(3);
        }
        for (int i = 0; i < 2; i++) {
            cart.removeProductByID(3);
        }
        int after = shop.getProductsShop().get(2).getQuantity();
        assertThat(before - after).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 14})
    void incorrectProductSelectionCausesException(int i) {
        assertThatThrownBy(() -> cart.addProductToCartByID(i)).isInstanceOf(RuntimeException.class);
    }

    @Test
    void incorrectProductRemoveCausesException() {
        assertThatThrownBy(() -> cart.removeProductByID(1)).isInstanceOf(RuntimeException.class);
    }

    @Disabled
    @RepeatedTest(10)
    @DisplayName("Advanced test for calculating TotalPrice")
    @Timeout(value = 70, unit = TimeUnit.MILLISECONDS)
    void advancedTestForCalculatingTotalPrice() {
        cart.addProductToCartByID(2);
        cart.addProductToCartByID(2);
        assertThat(cart.getTotalPrice()).isEqualTo(500);
    }
}