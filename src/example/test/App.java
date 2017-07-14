package example.test;

import example.test.dao.EmployeeDao;
import example.test.dao.ItemDao;
import example.test.dao.daoImpl.EmployeeDaoImpl;
import example.test.dao.daoImpl.ItemDaoImpl;
import example.test.dto.EmployeeDto;
import example.test.dto.ItemDto;


import javax.swing.*;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 * Created by jaliya on 7/10/17.
 */


/**
 * A class that contains the functionality to register items,employees,assign items to employees and view the current assignation
 */
public class App {

    /**
     * used to register items by getting item inputs via console and save them in the database
     */
    private void registerItems() {     //Encapsulation

        ItemDto item1 = new ItemDto();  //inheritance

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

        ItemDao itemDao = new ItemDaoImpl();       //inheritance

        itemDao.getItem(item1);                    //polymorphism    //encapsulation

    }


    /**
     * used to register employees by getting employee inputs via console and save them in the database
     */
    private void registerEmployees() {     //Encapsulation

        EmployeeDto emp = new EmployeeDto();

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

        EmployeeDao employeeDao = new EmployeeDaoImpl();      //inheritance
        employeeDao.getEmployee(emp);                         //polymorphism    //encapsulation

    }

    /**
     * used to assign each item to an employee and save the assignation to the database
     */
    private void assignItems() {     //Encapsulation

        Scanner s = new Scanner(System.in);                  //inheritance  //polymorphism
        System.out.println("Enter the employee number : ");  //polymorphism
        String employeeNumber = s.nextLine();                //inheritance
        System.out.println("Enter the item number : ");
        String itemNumber = s.nextLine();

        ItemDaoImpl itemDaoImpl = new ItemDaoImpl();
        itemDaoImpl.assignItem(employeeNumber, itemNumber);

    }


    /**
     * show the current assigned items as well as the free items
     */
    private void showAssignation() {      //Encapsulation


        ItemDaoImpl itemDao = new ItemDaoImpl();

        try {
            ResultSet resultSet = itemDao.showItem();
            while (resultSet.next())
                System.out.println(resultSet.getString(1) + "    " + resultSet.getString(2) + "    " + resultSet.getString(3));   //polymorphism
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);

        }

        System.out.println("");              //polymorphism
        System.out.println("Free items");    //polymorphism

        try {

            ResultSet resultSet2 = itemDao.showFreeItem();

            while (resultSet2.next())
                System.out.println(resultSet2.getString(1) + "    " + resultSet2.getString(2));     //polymorphism

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * display the main menu and get the user's choice and then navigate according to user's choice
     */
    private void showChoices() {

        Scanner s = new Scanner(System.in); //inheritance    //polymorphism
        App ts1 = new App();                //inheritance

        String mainMenu = ("Select a choice: \n"
                + "1. Enter 1 to register items :\n"
                + "2. Enter 2 to register employees : \n"
                + "3. Enter 3 to assign items : \n"
                + "4. Enter 4 to view assignation : \n"
                + "5. Exit\n");

        int choice;

        do {
            System.out.println("");
            System.out.println("");
            System.out.println(mainMenu);  //polymorphism

            choice = s.nextInt();
            switch (choice) {
                case 1:
                    ts1.registerItems();
                    break;
                case 2:
                    ts1.registerEmployees();
                    break;
                case 3:
                    ts1.assignItems();
                    break;
                case 4:
                    ts1.showAssignation();
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

    public static void main(String[] args) {

        App ts = new App();                 //inheritance
        ts.showChoices();

    }

}
