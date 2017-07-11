package example.test;

/**
 * Created by jaliya on 7/10/17.
 */
public class EmployeeDto {

    private String employeeNumber;
    private String employeeName;
    private String employeePosition;


    public void setEmployeeNumber(String empNo){

        this.employeeNumber=empNo;
    }
    public void setEmployeeName(String empName){

        this.employeeName=empName;
    }
    public void setEmployeePosition(String empPositiom){

        this.employeePosition=empPositiom;
    }
    public String getEmployeeNumber(){
        return this.employeeNumber;
    }
    public String getEmployeeName(){
        return this.employeeName;
    }
    public String getEmployeePosition(){
        return this.employeePosition;
    }

}
