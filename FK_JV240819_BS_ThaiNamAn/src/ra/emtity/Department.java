package ra.emtity;

import java.io.Serializable;
import java.util.Scanner;

public class Department implements IHrManager {
    private int department_id;
    private String department_name;
    private boolean department_status;

    //  constructor
    public Department() {
    }

    public Department(int department_id, String department_name, boolean department_status) {
        this.department_id = department_id;
        this.department_name = department_name;
        this.department_status = department_status;
    }

    // Get set
    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public boolean isDepartment_status() {
        return department_status;
    }

    public void setDepartment_status(boolean department_status) {
        this.department_status = department_status;
    }

    @Override
    public void inputData(Scanner scan) {
        System.out.println("Nhập id phòng ban: ");
        department_id = Integer.parseInt(scan.nextLine());
        System.out.println("Nhập tên phòng ban: ");
        department_name = scan.nextLine();
        System.out.println("Nhập trạng thái phòng ban: ");
        department_status = Boolean.parseBoolean(scan.nextLine());
    }

    @Override
    public void displayData() {
        System.out.printf("Id phòng ban %d:", this.department_id, "Tên phòng ban %s ",
                this.department_name, "Trạng thái %s: ", this.department_status ? "Hoạt động" : "Không hoạt động");

    }
}
