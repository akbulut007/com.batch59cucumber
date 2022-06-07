package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {
    /*POM 'de Driver için TestBase class'ina extends etmek yerine
    Driver class'indan static method'lar kullanarak,driver olusturup
    ilgili ayarların yapılması ve en sonda driver'in kapatılması tercih
    edilmiştir.POM'de Driver class'indaki getDriver()'nin obje olutsurularak kullanilmasni
    engellemek için SİNGLETON pattern kullnimi benimsenmiştir.
    SİNGLETON PATTERN:tekli kullanim,bir class'in farkli classlardan obje olusturularak
    kullnimini engellemek için kullanilir.Driver clasından OBJE olusturulamaz

*/
    private Driver() {

    }
    static WebDriver driver;//static olmalı ki bize return döndürsün.

    public static WebDriver getDriver() {
        //Static old için Driver clasından bana GetDriverin tek vazifesi bana driver getirecek
        //Void olan bir method bana istediğim yere driver getiremez
        //Bana birsey getirmesi  için return olması gerekir
        //Bunun return type WebDriverdir.
        if (driver == null) {
            //Driver ==null ise bu işlemi yap.Driverin degeri bos ise bu sekilde deger ata
            //asagıdaki ayarlarını yap
            switch(ConfigReader.getProperty("browser")){
                case"chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case"opera":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();//Selenium 4 operaya destek vermeyi bıraktı
                    break;
                case"firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();

            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        //Yoksa bu işlemi dondur
            return driver;
        }
        public static void closeDriver() {//Bunun tek vazifesi Driveri kapatır
          if(driver != null)//driver'e deger atanmıssa
              //driveri kapat.Null degilse kapat
              driver.close();
           driver=null;//Null degilse kapat null ise yapacak birşey yok
    //Static methodlarla Driveri acmak kapatmak kullanmak istiyoruz
    //Acmak için SetUp,kapatmak için tearDown kullanıyoruz
    //Yukarıdaki getDriver bize her defasında new Chromedriverdan dolayı yeni pancere acıyor
    //Bakalım diyoruz daha onceden new chrome drivera birsey atanmamıssa yukarıdakı ayarlamaları yapsın
            //Onu da null' a yaptık
            //eger dger atanmısssa o zaman daha onceden atanan degeri dondur
        }}
