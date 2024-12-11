package ra.emtity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Employee implements IHrManager {
    private int employeeId;
    private String employeeName;
    private String poristion;
    private double salary;
    private Date hireDate;

    //  constructor
    public Employee() {
    }

    public Employee(int employeeId, String employeeName, String poristion, double salary, Date hireDate) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.poristion = poristion;
        this.salary = salary;
        this.hireDate = hireDate;
    }

    //  get set
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getPoristion() {
        return poristion;
    }

    public void setPoristion(String poristion) {
        this.poristion = poristion;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    @Override
    public void inputData(Scanner scan) {
        System.out.println("Nhập id nhân viên: ");
        this.employeeId = Integer.parseInt(scan.nextLine());
        System.out.println("Nhập tên nhân viên: ");
        this.employeeName = scan.nextLine();
        System.out.println("Nhập vị trí nhân viên: ");
        this.poristion = scan.nextLine();
        System.out.println("Nhập mức lương nhân viên: ");
        this.salary = Double.parseDouble(scan.nextLine());
        System.out.println("Nhập ngày tuyển dụng: ");
        String inputDate = scan.nextLine();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.setLenient(false);
            this.hireDate = sdf.parse(inputDate);
        } catch (ParseException e) {
            System.out.println("Ngày tuyển dụng không hợp lệ! Định dạng lại theo dd/MM/yyyy. ");
            this.hireDate = null;
        }
    }

    @Override
    public void displayData() {
        System.out.printf("Id nhân viên %d: ", this.employeeId,
                "Tên nhân viên %s: ", this.employeeName,
                "Vị trí nhân viên %s: ", this.poristion,
                "Mức lương nhân viên %f: ", this.salary,
                "Ngày tuyển dụng: ", this.hireDate
        );

    }
}
