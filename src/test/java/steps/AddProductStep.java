package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.ProductsPage;

public class AddProductStep extends BaseStep {

    public AddProductStep(WebDriver driver) {
        super(driver);
    }


    public void addProduct() {

        ProductsPage productsPage = new ProductsPage(driver, true);


    }



}
