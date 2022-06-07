package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    //Herseyi okuyacak sekilde bir methot olusturmam
    //gerekiyor.Uzantı ismi kesinlikle configreader olmalı
    //Bu class calışmya basladıgı anda static blok devreye girecek
    //Ve properties'e atama yapacak.Propertiesin heryerde kullnanılmasını istediğim icin
    //public yapmalıyım
    //Ve kullanılması için propertiesi static yapmalıyım
    public static Properties properties;
     static{
         String dosyaYolu="configuration.properties";
         try {
             FileInputStream fis = new FileInputStream(dosyaYolu);
             //fis dosyaYolunu tanimladıgımız configuration.properties dosyasini okudu
             properties = new Properties();
             properties.load(fis);//fis'in okudugu bilgileri propertiese yukledi

             //IO exeption hepsini karsıladığığ için tyr cath 'i sildim
         } catch (IOException e) {
             e.printStackTrace();
         }

     }
     public static String getProperty(String key) {
         /*test methodundan yolladıgımız string key degerini alip
         Properties properties clasından getProperty()methodunu kullanarak
         bu key 'e ait valeu yu bize getirir
          */
         //Bu methodun da heryerden kullanılabilmesi için static yapmalıyım
         return properties.getProperty(key);
     }

}


