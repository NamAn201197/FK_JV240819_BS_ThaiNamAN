package ra.Bussiness;

import ra.emtity.Department;
import ra.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DepartmenBussiness {

    //  hiển thị danh sách
    public static List<Department> findAll() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Department> departments = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_all_departments}");
            ResultSet rs = callSt.executeQuery();
            departments = new ArrayList<>();
            while (rs.next()) {
                Department department = new Department();
                department.setDepartment_id(rs.getInt("department_id"));
                department.setDepartment_name(rs.getString("department_name"));
                department.setDepartment_status(rs.getBoolean("department_status"));
                departments.add(department);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return departments;
    }

    // thêm mới phòng ban
    public static boolean createDepartment(Department department) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call create_department(?,?)}");
            callSt.setString(1, department.getDepartment_name());
            callSt.setInt(2, department.getDepartment_id());
            callSt.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }

    // Cập nhập thông tin phòng ban
    public static boolean updateDepartment(Department department) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call update_department(?,?,?)}");
            callSt.setString(1, department.getDepartment_name());
            callSt.setInt(2, department.getDepartment_id());
            callSt.setBoolean(3, department.isDepartment_status());
            callSt.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }

    //  Xóa phòng ban
    public static boolean deleteDepartment(int department_id) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call delete_department(?,?)}");
            callSt.setInt(1, department_id);
            callSt.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }

    //  Hiển thị pb nhiều nhân viên nhất



}
