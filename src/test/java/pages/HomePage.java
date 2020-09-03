package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class HomePage {
    public HomePage open() {
        Selenide.open("/");
        return this;
    }

    public HomePage selectCategory(String categoryName) {
        $("#open-categories-btn").click();
        for (SelenideElement element : $$("li[id^='category']")) {
            if (element.text().matches(categoryName)) {
                element.click();
                break;
            }
        }
        return this;
    }

    public HomePage addAllProductsToCart() {
        $$("button[id^='add-product-']").forEach(SelenideElement::click);
        return this;
    }

    public HomePage addProductToCart(String productName) {
        int index = 0;
        for (SelenideElement element : $$("h1[data-id^='product-']")) {
            if (element.text().matches(productName)) {
                $$("button[id^='add-product']").get(index).click();
            }
            index +=1;
        }
        return this;
    }

    public CartPage accessCartPage() {
        $("img[src*='/shopping-cart']").click();
        return new CartPage();
    }
}
