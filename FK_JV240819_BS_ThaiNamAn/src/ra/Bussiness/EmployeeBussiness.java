package ra.Bussiness;

import ra.emtity.Department;
import ra.emtity.Employee;
import ra.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeBussiness {
    public static List<Employee> findAll() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Employee> employee = new ArrayList<>();
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_all_employees()}");
            ResultSet rs = callSt.executeQuery();
            employee = new ArrayList<>();
            while (rs.next()) {
                Employee employees = new Employee();
                employees.setEmployeeId(rs.getInt("employee_id"));
                employees.setEmployeeName(rs.getString("employee_name"));
                employees.setPoristion(rs.getNString("poristion"));
                employees.setSalary(rs.getDouble("salary"));
                employees.setHireDate(rs.getDate("hire_date"));
                employee.add(employees);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return employee;
    }

    //
    public static boolean createEmployee(Employee employee) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call create_employee(?,?,?,?,?)}");
            callSt.setString(1, employee.getEmployeeName());
            callSt.setString(2, employee.getPoristion());
            callSt.setDouble(3, employee.getSalary());
            callSt.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }

    //
    public static boolean updateEmployee(Employee employee) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call update_employee(?,?,?,?)}");
            callSt.setString(1, employee.getEmployeeName());
            callSt.setString(2, employee.getPoristion());
            callSt.setDouble(3, employee.getSalary());
            callSt.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }
}
