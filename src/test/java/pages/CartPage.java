package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CartPage {

    public CartPage open() {
        Selenide.open("/checkoutgetModalText");
        return this;
    }

    public CartPage increaseProductAmount(String productName, int quantity) {
        int index = 0;
        for (SelenideElement element : $$("div[id^='product-']")) {
            if (element.text().matches(productName)) {
                for(int i = 0; i < quantity; i++) {
                    $$("div[id^='add-product']").get(index).click();
                }
            }
            index +=1;
        }
        return this;
    }

    public CartPage decreaseProductAmount(String productName, int quantity) {
        int index = 0;
        for (SelenideElement element : $$("div[id^='product-']")) {
            if (element.text().matches(productName)) {
                for(int i = 0; i < quantity; i++) {
                    $$("div[id^='remove-product']").get(index).click();
                }
            }
            index +=1;
        }
        return this;
    }

    public CartPage finalizeOrder() {
        $("#finish-checkout-button").click();
        return this;
    }

    public SelenideElement getModalText() {
        return $(".ReactModal__Content h2");
    }

    public CartPage closeModalPurchaseConfirmation() {
        $(".close-modal").click();
        return this;
    }

    public Double getTotalCartValue() {
        return Double.parseDouble($("#price-total-checkout").text().replace("R$ ", "").replace(",", "."));
    }

    public Double getTotalItemsValues() {
        double sum = 0.00;
        for (SelenideElement element : $$("li:not(.cart-checkout-subtotal) p[id*='-price']")) {
            sum += Double.parseDouble(element.text().replace("R$ ", "").replace(",", "."));
        }
        return sum;
    }
}
