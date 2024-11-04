package Test;

import TestObject.AboutRentPage;
import TestObject.HomePageOrderScooterButton;
import TestObject.OrderPage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;


@RunWith(Parameterized.class)
public class MakingAnOrderTests extends BaseUITest {


    private final String locationPath;
    private final String nameExample;
    private final String lastNameExample;
    private final String addressExample;
    private final String phoneNumberExample;
    private final String color;
    private final String comment;
    private final String expected;


    public MakingAnOrderTests(String locationPath, String nameExample, String lastNameExample, String addressExample, String phoneNumberExample, String color, String comment, String expected) {
        this.locationPath = locationPath;
        this.nameExample = nameExample;
        this.lastNameExample = lastNameExample;
        this.addressExample = addressExample;
        this.phoneNumberExample = phoneNumberExample;
        this.color = color;
        this.comment = comment;
        this.expected = expected;
    }

    @Parameters
    public static Object[][] getData(){
        return new Object[][]{
                {"Button_Button__ra12g", "Дмитрий", "Шабалин", "Москва", "89109999999", "black", "Пока, курьер!", "Заказ оформлен"},
                {"Button_Button__ra12g Button_Middle__1CSJM", "Том", "Ян", "Нижний","+78999999911", "grey", "Привет, курьер!", "Заказ оформлен"}
        };
    }
    @Test
    public void testingQAScooter (){
        HomePageOrderScooterButton homePageOrderScooter = new HomePageOrderScooterButton(driver);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        homePageOrderScooter.orderButtonClick(locationPath);
        OrderPage orderPage = new OrderPage(driver);
        orderPage.jointStep(nameExample,lastNameExample,addressExample,phoneNumberExample);
        AboutRentPage aboutRentPage = new AboutRentPage(driver);
        aboutRentPage.completeOrder(color, comment);
        String actualResult = aboutRentPage.checkOrderStatus();
        Assert.assertThat("Фейлится заказ самоката", actualResult, containsString(expected));
    }
}
