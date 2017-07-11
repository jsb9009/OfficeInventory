package example.test.dto;

/**
 * Created by jaliya on 7/10/17.
 */

/**
 * encapsulation of employee data
 */
public class EmployeeDto {

    private String employeeNumber;
    private String employeeName;
    private String employeePosition;

    /**
     * set the value for employeeNumber
     * @param empNo
     */
    public void setEmployeeNumber(String empNo){

        this.employeeNumber=empNo;
    }

    /**
     *set the value for employeeName
     * @param empName
     */
    public void setEmployeeName(String empName){

        this.employeeName=empName;
    }

    /**
     *set the value for employeePosition
     * @param empPositiom
     */
    public void setEmployeePosition(String empPositiom){

        this.employeePosition=empPositiom;
    }

    /**
     * return the value of employeeNumber
     * @return employeeNumber value
     */
    public String getEmployeeNumber(){
        return this.employeeNumber;
    }

    /**
     *return the value of employeeName
     * @return employeeName value
     */
    public String getEmployeeName(){
        return this.employeeName;
    }

    /**
     *return the value of employeePosition
     * @return employeePosition value
     */
    public String getEmployeePosition(){
        return this.employeePosition;
    }

}
