package example.test;

import javax.swing.*;
import java.sql.Connection;
import java.sql.Statement;

/**
 * Created by jaliya on 7/11/17.
 */
public class EmployeeDaoImpl implements EmployeeDao {

    DBConnector db = new DBConnector();
    Connection con = db.getConnection();

    //TODO inherit javadocs

    @Override
    public ItemDto getEmployee(EmployeeDto employeeDto) {


        try {
            Statement stmt = con.createStatement();           //inheritance
            stmt.executeUpdate("INSERT INTO employee (EmployeeNo,EmployeeName,Position) VALUES ('" + employeeDto.getEmployeeNumber() + "','" + employeeDto.getEmployeeName() + "','" + employeeDto.getEmployeePosition() + "')");  //polymorphism  //encapsulation
            JOptionPane.showMessageDialog(null, "Employee successfully registered");
            con.close();
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }

        return null;
    }
}



