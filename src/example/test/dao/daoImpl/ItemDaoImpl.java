package example.test.dao.daoImpl;

import example.test.util.DBConnector;
import example.test.dao.ItemDao;
import example.test.dto.ItemDto;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 * Created by jaliya on 7/11/17.
 */

/**
 * Implementing the ItemDao interface
 */
public class ItemDaoImpl implements ItemDao {

    DBConnector db = new DBConnector();
    Connection con = db.getConnection();

    /**
     * user's employee inputs are gathered and they are persisted to the database
     *
     * @param itemDto
     * @return null
     */
    @Override
    public ItemDto getItem(ItemDto itemDto) {

        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO item (ItemNo,ItemName,ItemType) VALUES ('" + itemDto.getItemNumber() + "','" + itemDto.getItemName() + "','" + itemDto.getItemType() + "')");    //polymorphism   //encapsulation
            JOptionPane.showMessageDialog(null, "Item successfully registered");    //polymorphism

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    /**
     * show the current assigned items with their corresponding employees from the database
     *
     * @return ResultSet class object
     */
    public ResultSet showItem() {

        try {
            Statement stmt = con.createStatement();    //inheritance
            ResultSet rs = stmt.executeQuery("select ItemNo,ItemType,EmployeeNo from item,employee where item.Assignation=employee.IndexNo");   //polymorphism
            return rs;

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);

            return null;
        }

    }

    /**
     * show the current free items which can be assigned from database
     *
     * @return
     */
    public ResultSet showFreeItem() {
        try {
            Statement stmt = con.createStatement();    //inheritance
            ResultSet rs1 = stmt.executeQuery("select ItemNo,ItemType from item where Assignation IS NULL");    //polymorphism
            while (rs1.next())
                System.out.println(rs1.getString(1) + "    " + rs1.getString(2));     //polymorphism

            return rs1;

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    /**
     * persist the assignation of an item with the item number and the employee number
     *
     * @param employeeNumber
     * @param itemNumber
     */
    public void assignItem(String employeeNumber, String itemNumber) {

        try {
            Statement stmt = con.createStatement();      //inheritance

            stmt.executeUpdate("update item set Assignation=(select IndexNo from employee where EmployeeNo='" + employeeNumber + "') where ItemNo='" + itemNumber + "'"); //polymorphism

            JOptionPane.showMessageDialog(null, "Item was successfully assigned");
            con.close();
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }


    }
}
