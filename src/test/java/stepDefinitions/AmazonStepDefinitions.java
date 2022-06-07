package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class AmazonStepDefinitions {
    AmazonPage amazonPage=new AmazonPage();
    @Given("kullanici amazon anasayfasinda")
    public void kullanici_amazon_anasayfasinda() {
        //Amazona gitmesi için PAGEOBJECTMODELE gore giderim
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
    }
    @Then("kullanici Nutella için arama yapar")
    public void kullanici_nutella_için_arama_yapar() {
     //Nutella için arama yapmak için LOCATO a ihtiyac var
     //Bunun için obje olusturmam lazım ama objeyi Class seviyesinde en yukaıda olusturmalıyım
   //Objeyi burda olusturursam diğerleri kullanamaz
    //Amazon page teki locateri alack.Bir once projenin amazon pagesini alıp
        //burdaki page ye yapıştırdık
   //Class sevieyesinde obje oluturduktan sonra buraya da !!!!!!!!!!!
        //Arama yapması için keys.ENTER yapıyoruz
        amazonPage.aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
    }

    @Then("sonuclarin Nutella içerdiğini test eder")
    public void sonuclarin_nutella_içerdiğini_test_eder() {
        //Test etmek için once sonucu almak lazım
        String arananKelime="Nutella";
        String actualAramaSonucStr=amazonPage.aramaSonucElementi.getText();
        Assert.assertTrue(actualAramaSonucStr.contains(arananKelime));

    }
    @Then("sayfayi kapatir")
    public void sayfayi_kapatir() {
        Driver.closeDriver();

    }

}
