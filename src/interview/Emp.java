package interview;

import java.util.Objects;

public class Emp {

    private Integer empId;
    private String empName;
    private int deptId;
    private String status;
    private int sal;

    public Emp(Integer empId, String empName, int deptId, String status, int sal) {
        this.empId = empId;
        this.empName = empName;
        this.deptId = deptId;
        this.status = status;
        this.sal = sal;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emp emp = (Emp) o;
        return empId == emp.empId && deptId == emp.deptId && sal == emp.sal && Objects.equals(empName, emp.empName) && Objects.equals(status, emp.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empId, empName, deptId, status, sal);
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", deptId=" + deptId +
                ", status='" + status + '\'' +
                ", sal=" + sal +
                '}';
    }
}
