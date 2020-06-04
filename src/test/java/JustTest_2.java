import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class JustTest_2 {
    public static void main(String[] args) throws ParseException {
        WebDriver webDriver = Environment.initDriver();

        try {
            webDriver.get("https://www.e-katalog.ru/ek-list.php?katalog_=298&pr_[]=2777");
            Thread.sleep(5000);
            WebElement Table = webDriver.findElement(By.id("con-1690232"));
            List<WebElement> Notebooks = Table.findElements(By.className("conf-tr"));
            int Max_Price = 0, Notebook_Price = 0;
            String Maximalochka = "";
            for (WebElement Notebook: Notebooks)
            {
                String Notebook_String = Notebook.getText();
                if (Notebook_String.lastIndexOf("..") == -1)
                {
                    Notebook_Price = Integer.parseInt(Notebook_String.substring((Notebook_String.lastIndexOf("ГБ")+2),(Notebook_String.lastIndexOf("р.")-1)).replace(" ",""));
                }
                else
                {
                    Notebook_Price = Integer.parseInt(Notebook_String.substring((Notebook_String.lastIndexOf("..")+3),(Notebook_String.lastIndexOf("р.")-1)).replace(" ",""));
                }

                if (Notebook_Price > Max_Price)
                {
                    Maximalochka = Notebook.getText();
                    Max_Price = Notebook_Price;
                }
            }
            System.out.println("MAXIMUM COMPLICATION: " + Maximalochka.substring(0,Maximalochka.lastIndexOf("Сравнить")));
        }
        catch (Exception e) {
            System.out.println("Error!");
            webDriver.quit();
        }
        webDriver.quit();
    }
}
