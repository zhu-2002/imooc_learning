package jdbc.hrapp.entity;

import java.util.Date;

/**
 * 员工实体类
 */
public class Employee {
    /**
     * 1.具备默认构造函数
     * 2.属性私有
     * 3.存在getter和setter
     */
    private int eno;
    private String ename;
    private float salary;
    private String dname;
    private Date hiredate ;
    public Employee() {
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public int getEno() {
        return eno;
    }

    public void setEno(int eno) {
        this.eno = eno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

}
