package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {

    ShoppingCart shoppingCart;

    @BeforeEach
    void beforeEach(){
        shoppingCart = new ShoppingCart();
    }

    @Test
    void emptyShoppingCart(){
        assertDoesNotThrow(() -> {
            shoppingCart = new ShoppingCart();
        });
    }

    @Test
    void PositivePriceProduct(){
        assertDoesNotThrow(() -> {
            new Product("apple", 5.0);
        });
    }

    @Test
    void NegativePriceProduct(){
        assertThrows(IllegalArgumentException.class, () -> {
            new Product("apple", -5.0);
        });
    }

    @Test
    void addValidProduct(){
        Product apple = new Product("Apple", 0.5);

        assertDoesNotThrow(() -> {
            shoppingCart.addProduct(apple);
        });

        assertEquals(1, shoppingCart.getItemCount());
    }

    @Test
    void addInvalidProduct(){
        assertThrows(IllegalArgumentException.class, () -> {
            shoppingCart.addProduct(null);
        });
    }

    @Test
    void validPriceAfterAddingOneProduct(){
        Product apple = new Product("Apple", 0.5);

        assertDoesNotThrow(() -> {
            shoppingCart.addProduct(apple);
        });

        assertEquals(0.5, shoppingCart.getTotalPrice());
    }

    @Test
    void validPriceAfterAddingMultipleProduct(){
        Product apple = new Product("Apple", 0.5);
        Product orange = new Product("Apple", 0.7);
        Product banana = new Product("Apple", 1.2);

        assertDoesNotThrow(() -> {
            shoppingCart.addProduct(apple);
            shoppingCart.addProduct(orange);
            shoppingCart.addProduct(banana);
        });

        assertEquals(2.4, shoppingCart.getTotalPrice());
    }

    @Test
    void clearShoppingCart(){
        Product apple = new Product("Apple", 0.5);
        Product orange = new Product("Apple", 0.7);
        Product banana = new Product("Apple", 1.2);

        assertDoesNotThrow(() -> {
            shoppingCart.addProduct(apple);
            shoppingCart.addProduct(orange);
            shoppingCart.addProduct(banana);

            shoppingCart.clearCart();
        });

        assertEquals(0, shoppingCart.getItemCount());
    }
}