package EnumsPackage;

public enum Products_SauceDemoEnums {
    CLOTHING_Name_Backpack("Sauce Labs Backpack"),
    CLOTHING_Name_Bike_Light("Sauce Labs Bike Light"),
    CLOTHING_Name_Bolt_TShirt("Sauce Labs Bolt T-Shirt"),
    CLOTHING_Name_Fleece_Jacket("Sauce Labs Fleece Jacket"),
    CLOTHING_Name_Onesie("Sauce Labs Onesie"),
    CLOTHING_Name_TShirtRed("Test.allTheThings() T-Shirt");

    private String name ;

    Products_SauceDemoEnums(String name) {
        this.name=name;
    }

    public String getResourcesName() {
        return name;
    }

}