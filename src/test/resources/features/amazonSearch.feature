Feature: Amazon Search

  Scenario:TC01 kullanici amazonda kelime aratir.

    Given kullanici amazon anasayfasinda
    Then kullanici Nutella için arama yapar
    And  sonuclarin Nutella içerdiğini test eder
    And sayfayi kapatir