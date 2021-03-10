/*
 * Description: Tests for Employee and EmployeeList objects
 * Author(s): Ross Monaghan
 * Version: 1.0
 * Date Created: 10/03/21
 */

package ie.gmit.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EmployeeTest
{
    Employee employee;
    EmployeeList employeeList;

    // Initializing a new valid Employee and EmployeeList before tests
    @BeforeEach
    void init()
    {
        employee = new Employee("Ross Monaghan","00001");
        employeeList = new EmployeeList();
        employeeList.addEmployee(employee);
    }

    // Testing that a valid name entry does not throw an exception
    @Test
    void testNameSuccess()
    {
        assertEquals("Ross Monaghan", employee.getName());
    }

    // Testing that an invalid name entry throws an exception
    @Test
    void testNameFail()
    {
        Exception e = assertThrows(IllegalArgumentException.class, () -> new Employee("", "00001"));
        assertEquals("Invalid name entry", e.getMessage());
    }

    // Testing that a valid employee number entry does not throw an exception
    @Test
    void testEmployeeNumberSuccess()
    {
        assertEquals("00001", employee.getEmployeeNum());
    }

    // Testing that an invalid employee number entry throws an exception
    @Test
    void testEmployeeNumberFail()
    {
        Exception e = assertThrows(IllegalArgumentException.class, () -> new Employee("Ross Monaghan", ""));
        assertEquals("Employee number must be 5 digits", e.getMessage());
    }

    // Testing that a valid Employee can be added to an EmployeeList object
    @Test
    void testAddEmployeeSuccess()
    {
        Employee employeeAdd = new Employee("John Doe", "00002");

        int listLength = employeeList.getListSize();
        employeeList.addEmployee(employeeAdd);
        assertEquals(listLength + 1, employeeList.getListSize());
    }

    // Testing that an invalid Employee cannot be added to an EmployeeList object
    @Test
    void testAddEmployeeFail()
    {
        Employee employeeAdd = new Employee("Ross Monaghan", "00001");

        Exception e = assertThrows(IllegalArgumentException.class, () -> employeeList.addEmployee(employeeAdd));
        assertEquals("Duplicate Employee details found, no object added", e.getMessage());
    }

    // Testing that the correct string is returned when an employee is deleted
    @Test
    void testRemoveEmployeeSuccess()
    {
        String result = employeeList.deleteEmployee(employee.getEmployeeNum());
        assertEquals("Employee deleted from list", result);
    }

    // Testing that the correct string is returned when an employee cannot be deleted
    @Test
    void testDeleteEmployeeFail()
    {
        String result = employeeList.deleteEmployee("");
        assertEquals("No matching Employee found", result);
    }
}
