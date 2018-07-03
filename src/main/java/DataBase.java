
import java.sql.*;
import java.sql.DriverManager;
import java.sql.Statement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Arpitagarwal
 */
public class DataBase {
    WebDriver driver;
    public DataBase(WebDriver driver){
        this.driver = driver;
}
    public void EnterDetails(String username, String password) throws ClassNotFoundException, SQLException{
        String symbol1 = driver.findElement(By.id("symboldisplay")).getText();
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://10.0.1.86/tatoc", username, password);
        Statement smt = con.createStatement();
        ResultSet rs = smt.executeQuery("select id from identity where symbol="+"'"+symbol1+"';");
        int id = -1;
        while(rs.next())  
        id = rs.getInt(1);
        String name = "";
        String passkey = "";
        if(id!=-1){
        ResultSet rs1 = smt.executeQuery("select * from credentials where id="+id);
        while(rs1.next()){
            name = rs1.getString("name");
            passkey = rs1.getString("passkey");
         
        }
        System.out.println(name+" "+passkey);
        driver.findElement(By.id("name")).sendKeys(name);
        driver.findElement(By.id("passkey")).sendKeys(passkey);
        driver.findElement(By.id("submit")).click();
        con.close(); 
        
        }
    }
}
        
    


