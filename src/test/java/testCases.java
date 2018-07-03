/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//import com.mycompany.advancetatoc.*;
import java.sql.SQLException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Arpitagarwal
 */
public class testCases {
    
    WebDriver driver;
    Intro intro;
    Hover hover;
    DataBase database;
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @BeforeClass
    public void SetupDriver(){
        System.setProperty("webdriver.chrome.driver", "E:\\My Practice\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://10.0.1.86/tatoc");
        intro = new Intro(driver);
    }
    @Test
    public void CourseSelect(){
        hover = intro.SelectCourse("Advanced Course");
    }
    @Test(dependsOnMethods = {"CourseSelect"})
    public void GoToCorrectMenu(){
        database = hover.SelectCorrectMenu();
    }
    @Test(dependsOnMethods = "GoToCorrectMenu")
    public void DetailsInDataBase() throws ClassNotFoundException, SQLException{
        database.EnterDetails("tatocuser", "tatoc01");
    }


}