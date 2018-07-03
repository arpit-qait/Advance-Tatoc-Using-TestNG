/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author Arpitagarwal
 */
public class Intro {
    WebDriver driver;
    
    public Intro(WebDriver driver){
        this.driver = driver;
    }
    
    public Hover SelectCourse(String courseName){
        driver.findElement(By.linkText(courseName)).click();
        return new Hover(driver);
    }
    
}
