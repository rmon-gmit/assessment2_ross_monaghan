/*
 * Description: Class to contain a list of Employee objects
 * Author(s): Ross Monaghan
 * Version: 1.0
 * Date Created: 10/03/21
 */

package ie.gmit.tests;

import java.util.ArrayList;

public class EmployeeList
{
    ArrayList<Employee> employeeList;

    // Default Constructor
    public EmployeeList()
    {
        employeeList = new ArrayList<>();
    }

    // Method to add an employee to an EmployeeList object
    public void addEmployee(Employee employeeAdd)
    {
        for(Employee employeeExisting : employeeList) {
            if (employeeExisting.getEmployeeNum().equals(employeeAdd.getEmployeeNum())) {
                throw new IllegalArgumentException("Duplicate Employee details found, no object added");
            }
        }
        employeeList.add(employeeAdd);
    }

    // Method to delete an employee from an EmployeeList object
    public String deleteEmployee(String employeeNumber)
    {
        for(Employee employee : employeeList) {
            if (employee.getEmployeeNum().equals(employeeNumber)) {
                employeeList.remove(employee);
                return("Employee deleted from list");
            }
        }
        return("No matching Employee found");
    }

    // Method to return the current number of employee objects in an EmployeeList object
    public int getListSize()
    {
        return employeeList.size();
    }
}
