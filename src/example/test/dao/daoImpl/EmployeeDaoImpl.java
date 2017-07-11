package example.test.dao.daoImpl;

import example.test.util.DBConnector;
import example.test.dao.EmployeeDao;
import example.test.dto.EmployeeDto;
import example.test.dto.ItemDto;

import javax.swing.*;
import java.sql.Connection;
import java.sql.Statement;

/**
 * Created by jaliya on 7/11/17.
 */
public class EmployeeDaoImpl implements EmployeeDao {

    DBConnector db = new DBConnector();
    Connection con = db.getConnection();

    /**
     * user's item inputs are gathered and they are persisted to the database
     * @param employeeDto
     * @return null
     */
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



