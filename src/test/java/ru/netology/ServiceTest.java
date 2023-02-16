package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;


public class ServiceTest {

    Basket basket;

    @BeforeEach
    public void beforeEach() {
        String[] products = new String[]{"Маргарин", "Мясо", "Каша", "Макароны"};
        int[] prices = new int[]{70, 350, 50, 59};
        basket = new Basket(products, prices);
    }

    @ParameterizedTest
    @CsvSource({
            "0, 100",
            "2, 5",
            "3, 10"
    })
    public void paramsTestAddToCart(int i, int z) {

        basket.addToCart(i, z);
        int[] result = new int[4];
        result[i] = z;
        Assertions.assertArrayEquals(basket.amountOfProductsInBasket, result);
    }

    @Test
    public void testAddToCart() {

        basket.addToCart(0, 100);
        basket.addToCart(0, 20);
        basket.addToCart(2, 5);
        basket.addToCart(3, 10);
        int[] result = {120, 0, 5, 10};

        Assertions.assertArrayEquals(basket.amountOfProductsInBasket, result);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 4, 5, 8})
    public void paramsTestAddToCartWithThrows(int i) {
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> basket.addToCart(i, 10));
    }


}