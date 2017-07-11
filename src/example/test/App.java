package example.test;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Created by jaliya on 7/10/17.
 */

//TODO Rename Employee and Item classes as EmployeeDto and ItemDto

/**
 * A class that contains the functionality to register items,employees,assign items to employees and view the current
 * assignation
 */
public class App {

    /**
     * used to register items by getting item inputs via console and save them an the database
     */
    private void registerItems() {     //Encapsulation

        DBConnector db = new DBConnector();  //inheritance
        Connection con = db.getConnection();  //inheritance

        Item item1 = new Item();

        Scanner s = new Scanner(System.in);                //inheritance  //polymorphism
        System.out.println("Enter the item number : ");    //polymorphism

        String itemNumber = s.nextLine();                  //inheritance

        item1.setItemNumber(itemNumber);
        System.out.println("Enter the item name : ");
        String itemName = s.nextLine();
        item1.setItemName(itemName);                        //encapsulation
        System.out.println("Enter the item type : ");
        String itemType = s.nextLine();
        item1.setItemType(itemType);                       //encapsulation

        try {
            //TODO move item related DB operations to ItemDao
            /**Refer https://stackoverflow.com/questions/19154202/data-access-object-dao-in-java
             * https://www.tutorialspoint.com/design_pattern/data_access_object_pattern.htm
             * https://en.wikipedia.org/wiki/Data_access_object
             * **/
            Statement stmt = con.createStatement();    //inheritance
            stmt.executeUpdate("INSERT INTO item (ItemNo,ItemName,ItemType) VALUES ('" + item1.getItemNumber() + "','" +
                    item1.getItemName() + "','" + item1.getItemType() + "')");    //polymorphism   //encapsulation
            JOptionPane.showMessageDialog(null, "Item successfully registered");    //polymorphism
            con.close();
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * used to register employees by getting employee inputs via console and save them an the database
     */
    private void registerEmployees() {     //Encapsulation

        DBConnector db = new DBConnector();
        Connection con = db.getConnection();

        Employee emp = new Employee();

        Scanner s = new Scanner(System.in);                    //inheritance  //polymorphism
        System.out.println("Enter the employee number : ");    //polymorphism
        String employeeNumber = s.nextLine();                  //inheritance
        emp.setEmployeeNumber(employeeNumber);                 //encapsulation

        System.out.println("Enter the employee name : ");
        String employeeName = s.nextLine();
        emp.setEmployeeName(employeeName);                     //encapsulation

        System.out.println("Enter the employee position : ");
        String employeePosition = s.nextLine();
        emp.setEmployeePosition(employeePosition);             //encapsulation

        try {
            //TODO move employee related DB operations to EmployeeDao
            Statement stmt = con.createStatement();           //inheritance
            stmt.executeUpdate(
                    "INSERT INTO employee (EmployeeNo,EmployeeName,Position) VALUES ('" + emp.getEmployeeNumber() +
                            "','" + emp.getEmployeeName() + "','" + emp.getEmployeePosition() +
                            "')");  //polymorphism  //encapsulation
            JOptionPane.showMessageDialog(null, "Employee successfully registered");
            con.close();
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * used to assign each item to an employee and save the assignation to the database
     */
    private void assignItems() {     //Encapsulation

        DBConnector db = new DBConnector();     //inheritance
        Connection con = db.getConnection();    //inheritance

        Scanner s = new Scanner(System.in);                  //inheritance  //polymorphism
        System.out.println("Enter the employee number : ");  //polymorphism
        String employeeNumber = s.nextLine();                //inheritance
        System.out.println("Enter the item number : ");
        String itemNumber = s.nextLine();

        try {
            Statement stmt = con.createStatement();      //inheritance

            stmt.executeUpdate(
                    "update item set Assignation=(select IndexNo from employee where EmployeeNo='" + employeeNumber +
                            "') where ItemNo='" + itemNumber + "'"); //polymorphism

            JOptionPane.showMessageDialog(null, "Item was successfully assigned");
            con.close();
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }


    }

    /**
     * show the current assigned items as well as the free items
     */
    private void showAssignation() {      //Encapsulation

        DBConnector db = new DBConnector();      //inheritance
        Connection con = db.getConnection();     //inheritance

        try {
            Statement stmt = con.createStatement();    //inheritance
            ResultSet rs = stmt.executeQuery(
                    "select ItemNo,ItemType,EmployeeNo from item,employee where item.Assignation=employee.IndexNo");
                      //polymorphism
            while (rs.next())
                System.out.println(
                        rs.getString(1) + "    " + rs.getString(2) + "    " + rs.getString(3));   //polymorphism

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }

        System.out.println("");              //polymorphism
        System.out.println("Free items");    //polymorphism

        try {
            Statement stmt = con.createStatement();    //inheritance
            ResultSet rs =
                    stmt.executeQuery("select ItemNo,ItemType from item where Assignation IS NULL");    //polymorphism
            while (rs.next())
                System.out.println(rs.getString(1) + "    " + rs.getString(2));     //polymorphism

            con.close();
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }


    public static void main(String[] args) {


       /* DBConnector db = new DBConnector();   //inheritance
        Connection con = db.getConnection();  //inheritance     */

        Scanner s = new Scanner(System.in); //inheritance    //polymorphism
        App ts = new App();                 //inheritance


        String mainMenu = ("Select a choice: \n"
                + "1. Enter 1 to register items :\n"
                + "2. Enter 2 to register employees : \n"
                + "3. Enter 3 to assign items : \n"
                + "4. Enter 4 to view assignation : \n"
                + "5. Exit\n");     //polymorphism

        int choice;

        do {

            System.out.println(mainMenu);  //polymorphism

            choice = s.nextInt();

            switch (choice) {
                case 1:
                    ts.registerItems();    //polymorphism
                    break;
                case 2:
                    ts.registerEmployees();
                    break;
                case 3:
                    ts.assignItems();
                    break;
                case 4:
                    ts.showAssignation();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please enter a valid choice! ");
                    System.out.println("");
                    break;
            }

        } while (choice != 0);
    }

}
