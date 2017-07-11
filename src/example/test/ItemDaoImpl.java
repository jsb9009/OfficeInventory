package example.test;

import javax.swing.*;
import java.sql.Connection;
import java.sql.Statement;


/**
 * Created by jaliya on 7/11/17.
 */
public class ItemDaoImpl implements ItemDao {

    DBConnector db = new DBConnector();
    Connection con = db.getConnection();

    @Override
    public ItemDto getItem(ItemDto itemDto) {

        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO item (ItemNo,ItemName,ItemType) VALUES ('" + itemDto.getItemNumber() + "','" + itemDto.getItemName() + "','" + itemDto.getItemType() + "')");    //polymorphism   //encapsulation
            JOptionPane.showMessageDialog(null, "Item successfully registered");    //polymorphism
            con.close();
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
}
