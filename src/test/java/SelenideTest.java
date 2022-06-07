import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Collections;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTest {
    @Test
    public void clickSubcategoryTest() {
        open("https://litecart.stqa.ru/en/");
        $("[href=\"https://litecart.stqa.ru/en/rubber-ducks-c-1/\"]").hover();
        $("[href=\"https://litecart.stqa.ru/en/rubber-ducks-c-1/subcategory-c-2/\"]").click();
        $("[class='title']").shouldBe(Condition.visible);
    }

    @Test
    public void sortDucksNameTest() {
        open("https://litecart.stqa.ru/en/");
        $("[href=\"https://litecart.stqa.ru/en/rubber-ducks-c-1/\"]").hover();
        $("[href=\"https://litecart.stqa.ru/en/rubber-ducks-c-1/subcategory-c-2/\"]").click();
        $("[href=\"https://litecart.stqa.ru/en/rubber-ducks-c-1/subcategory-c-2/?category_id=2&page=1&sort=name\"]")
                .click();
        String nameDucksGreenSort = $(By.xpath("//div[@class='name'][contains(text(), 'Green DucK')]")).getText();
        String nameDucksYellowSort = $(By.xpath("//div[@class='name'][contains(text(), 'Yellow Duck')]")).getText();
        ArrayList<String> sortListNameDucks = new ArrayList<>();
        sortListNameDucks.add(nameDucksGreenSort);
        sortListNameDucks.add(nameDucksYellowSort);
        Collections.sort(sortListNameDucks);
        for (String name : sortListNameDucks) {
            System.out.println(name);
        }
        String nameDucksGreen = $(By.xpath("//div[@class='name'][contains(text(), 'Green DucK')]")).getText();
        String nameDucksYellow = $(By.xpath("//div[@class='name'][contains(text(), 'Yellow Duck')]")).getText();
        ArrayList <String> notSortListNameDucks = new ArrayList<>();
        notSortListNameDucks.add(nameDucksGreen);
        notSortListNameDucks.add(nameDucksYellow);
        for (String name : notSortListNameDucks) {
            System.out.println(name);
        }
        Assert.assertEquals(notSortListNameDucks, sortListNameDucks);
    }

    @Test
    public void sortDucksPriceTest() {
        open("https://litecart.stqa.ru/en/");
        $("[href=\"https://litecart.stqa.ru/en/rubber-ducks-c-1/\"]").hover();
        $("[href=\"https://litecart.stqa.ru/en/rubber-ducks-c-1/subcategory-c-2/\"]").click();
        $("[class=\"button active\"]").click();
        String sortYellowDucksPrice = $(By.xpath("//strong[@class=\"campaign-price\"]")).getText();
        String sortGreenDucksPrice = $(By.xpath("//span[@class=\"price\"]")).getText();
        ArrayList <String> sortListPriceDucks = new ArrayList<>();
        sortListPriceDucks.add(sortGreenDucksPrice);
        sortListPriceDucks.add(sortYellowDucksPrice);
        Collections.sort(sortListPriceDucks);
        for (String price : sortListPriceDucks) {
            System.out.println(price);        }

        String yellowDucksPrice = $(By.xpath("//strong[@class='campaign-price']")).getText();
        String greenDucksPrice = $(By.xpath("//span[@class='price']")).getText();
        ArrayList <String> listPriceDucks = new ArrayList<>();
        listPriceDucks.add(yellowDucksPrice);
        listPriceDucks.add(greenDucksPrice);
        for (String price : listPriceDucks) {
            System.out.println(price);
        }

        Assert.assertEquals(sortListPriceDucks, listPriceDucks);

    }

    @Test
    public void checkLabelYellowDuckTest() {
        open("https://litecart.stqa.ru/en/");
        $("[href=\"https://litecart.stqa.ru/en/rubber-ducks-c-1/\"]").hover();
        $("[href=\"https://litecart.stqa.ru/en/rubber-ducks-c-1/subcategory-c-2/\"]").click();
        String labelTextYellowDuck = $(By.xpath("//div[@class=\"sticker sale\"][contains(text(), 'Sale')]")).getText();
        System.out.println(labelTextYellowDuck);

        Assert.assertEquals(labelTextYellowDuck, "SALE");
    }

    @Test
    public void checkLabelGreenDuckTest() {
        open("https://litecart.stqa.ru/en/");
        $("[href=\"https://litecart.stqa.ru/en/rubber-ducks-c-1/\"]").hover();
        $("[href=\"https://litecart.stqa.ru/en/rubber-ducks-c-1/subcategory-c-2/\"]").click();
        String labelTextGreenDuck = $(By.xpath("//div[@title=\"New\"]")).getText();
        System.out.println(labelTextGreenDuck);

        Assert.assertEquals(labelTextGreenDuck, "NEW");
    }

    @Test
    public void clickDeliveryInformationTest() {
        open("https://litecart.stqa.ru/en/");
        $("[class=\"page-2\"]").click();
        $("[id=\"cookies-acceptance\"]").shouldBe(Condition.visible);
    }

}
