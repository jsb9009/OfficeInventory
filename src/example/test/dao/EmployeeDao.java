package example.test.dao;

import example.test.dto.EmployeeDto;
import example.test.dto.ItemDto;

/**
 * Created by jaliya on 7/11/17.
 */

/**
 * providing an abstraction for the employee related data
 */
public interface EmployeeDao {

    public ItemDto getEmployee(EmployeeDto employeeDtoDto);

}
