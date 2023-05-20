package org.example;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class Tests extends Main {


    //Task 1
    @DataProvider(name = "test1Data")
    public Object[][] test1Data() {
        return new Object[][]{
                {"Vehicle 1", "BMW", "Red", "2020"},
//                {"Jane", "Doe", 30},
//                {"Bob", "Smith", 40}
        };
    }

    @Test(dataProvider = "test1Data")
    public void Test1(String Name, String Model, String Color, String Year) {
        VehiclePage vehicle =new VehiclePage(driver);
        ClonedVehiclePage clonedVehicle =new ClonedVehiclePage(driver);
        vehicle.TestInput(Name, Model, Color, Year);
        Asserts( Name, Model, Color, Year, clonedVehicle );
        driver.navigate().refresh();
    }

    //Task 2
    @DataProvider(name = "test2Data")
    public Object[][] test2Data() {
        return new Object[][]{
                {"Vehicle 1", "BMW", "Mazda", "Red", "2020"},
//                {"Jane", "Doe", 30},
//                {"Bob", "Smith", 40}
        };
    }

    @Test(dataProvider = "test2Data")
    public void Test2(String Name, String Model1, String Model2, String Color, String Year) {
        VehiclePage vehicle =new VehiclePage(driver);
        ClonedVehiclePage clonedVehicle =new ClonedVehiclePage(driver);
        vehicle.TestModification(Name, Model1, Model2,  Color, Year);
        Asserts( Name, Model2, Color, Year, clonedVehicle );
        driver.navigate().refresh();
    }


    public void Asserts(String Name, String Model, String Color, String Year, ClonedVehiclePage clonedVehicle) {
        Assert.assertEquals(clonedVehicle.getTName().getAttribute("value"), Name );
        Assert.assertEquals(clonedVehicle.getTModel().getFirstSelectedOption().getAttribute("value"),Model );
        Assert.assertEquals(clonedVehicle.getTColor().getFirstSelectedOption().getAttribute("value"),Color );
        Assert.assertEquals(clonedVehicle.getTYear().getAttribute("value"),Year );
    }
}
