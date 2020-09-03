package tests;

import common.BaseTest;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
public class CheckoutTests extends BaseTest {

    @Test
    public void shouldCheckoutWithGroceries() {
        home      .open()
                  .selectCategory("Doces")
                  .addAllProductsToCart()
                  .accessCartPage();

        cart      .increaseProductAmount("Brigadeiro", 4)
                  .finalizeOrder();

        cart.getModalText().shouldHave(text("Pedido realizado com sucesso!"));
        cart.closeModalPurchaseConfirmation();
    }

    @Test
    public void shouldCheckoutWithDifferentCategories() {
        home    .open()
                .selectCategory("Bebidas")
                .addAllProductsToCart()
                .selectCategory("Todos")
                .addProductToCart("Rissole médio")
                .accessCartPage();

        cart      .increaseProductAmount("Rissole médio", 9)
                  .decreaseProductAmount("Rissole médio", 5)
                  .finalizeOrder();

        assertEquals(cart.getTotalCartValue(), cart.getTotalItemsValues());
        cart.getModalText().shouldHave(text("Pedido realizado com sucesso!"));
        cart.closeModalPurchaseConfirmation();
    }
}
