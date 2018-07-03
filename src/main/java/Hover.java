/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 *
 * @author Arpitagarwal
 */
class Hover {
    WebDriver driver;
    public Hover(WebDriver driver){
        this.driver = driver;
    }
    public DataBase SelectCorrectMenu(){
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]"));
        action.moveToElement(we).moveToElement(driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/span[5]"))).click().build().perform();
        return new DataBase(driver);
    }
}
//body > div > div.page > div.menutop.m2 > span:nth-child(5)