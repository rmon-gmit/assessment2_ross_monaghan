/*
 * Description: Class to represent an employee
 * Author(s): Ross Monaghan
 * Version: 1.0
 * Date Created: 10/03/21
 */

package ie.gmit.tests;

public class Employee
{
    private String name;
    private String employeeNum;

    // Argument Constructor
    public Employee(String name, String employeeNum)
    {
        setName(name);
        setEmployeeNum(employeeNum);
    }

    // Mutators
    public void setName(String name)
    {
        if (name.length() >= 5) {
            this.name = name;
        }
        else {
            throw new IllegalArgumentException("Invalid name entry");
        }
    }

    public void setEmployeeNum(String employeeNum)
    {
        if (employeeNum.length() == 5) {
            this.employeeNum = employeeNum;
        }
        else {
            throw new IllegalArgumentException("Employee number must be 5 digits");
        }
    }

    // Accessors
    public String getName()
    {
        return name;
    }

    public String getEmployeeNum()
    {
        return employeeNum;
    }
}
