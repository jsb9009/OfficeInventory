package example.test;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Created by jaliya on 7/10/17.
 */
public class App {

    public void registerItems() {

        DBConnector db = new DBConnector();
        Connection con = db.getConnection();

        Scanner s = new Scanner(System.in);
        System.out.println("Enter the item number : ");
        String itemNumber = s.nextLine();
        System.out.println("Enter the item name : ");
        String itemName = s.nextLine();
        System.out.println("Enter the item type : ");
        String itemType = s.nextLine();

        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO item (ItemNo,ItemName,ItemType) VALUES ('" + itemNumber + "','" + itemName + "','" + itemType + "')");
            JOptionPane.showMessageDialog(null, "Item successfully registered");
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void registerEmployees() {

        DBConnector db = new DBConnector();
        Connection con = db.getConnection();

        Scanner s = new Scanner(System.in);
        System.out.println("Enter the employee number : ");
        String employeeNumber = s.nextLine();
        System.out.println("Enter the employee name : ");
        String employeeName = s.nextLine();
        System.out.println("Enter the employee position : ");
        String employeePosition = s.nextLine();

        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO employee (EmployeeNo,EmployeeName,Position) VALUES ('" + employeeNumber + "','" + employeeName + "','" + employeePosition + "')");
            JOptionPane.showMessageDialog(null, "Employee successfully registered");
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }


    public void assignItems() {

        DBConnector db = new DBConnector();
        Connection con = db.getConnection();

        Scanner s = new Scanner(System.in);
        System.out.println("Enter the employee number : ");
        String employeeNumber = s.nextLine();
        System.out.println("Enter the item number : ");
        String itemNumber = s.nextLine();

        try {
            Statement stmt = con.createStatement();

            stmt.executeUpdate("update item set Assignation=(select IndexNo from employee where EmployeeNo='" + employeeNumber + "') where ItemNo='" + itemNumber + "'");

            JOptionPane.showMessageDialog(null, "Item was successfully assigned");
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }


    }

    public void showAssignation() {

        DBConnector db = new DBConnector();
        Connection con = db.getConnection();

        try {
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select ItemNo,ItemType,EmployeeNo from item,employee where item.Assignation=employee.IndexNo");
            while(rs.next())
                System.out.println(rs.getString(1)+"  "+rs.getString(2)+" "+rs.getString(3));

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }

        System.out.println("");
        System.out.println("Free items");

        try {
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select ItemNo,ItemType from item where Assignation IS NULL");
            while(rs.next())
                System.out.println(rs.getString(1)+"  "+rs.getString(2));

            con.close();
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }



    }


    public static void main(String[] args) {


        DBConnector db = new DBConnector();
        Connection con = db.getConnection();
        if (con != null) {

            System.out.println("Connection successful!!!");
        }

        Scanner s = new Scanner(System.in);
        App ts = new App();

        System.out.println("Enter 1 to register items : ");
        System.out.println("Enter 2 to register employees : ");
        System.out.println("Enter 3 to assign items : ");
        System.out.println("Enter 4 to view assignation : ");

        int choice = s.nextInt();

        // ts.assignItems();


        if (choice == 1) {
            ts.registerItems();

        } else if (choice == 2) {
            ts.registerEmployees();

        } else if (choice == 3) {
            ts.assignItems();

        } else if (choice == 4) {
            ts.showAssignation();

        } else {

            System.out.println("Please enter a valid choice ");
        }

    }

}
