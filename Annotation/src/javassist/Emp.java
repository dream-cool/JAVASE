package javassist;

public class Emp {
    private  int   empno;
    private  String  empname;

    public Emp() {
    }

    public Emp(int empno, String empname) {
        this.empno = empno;
        this.empname = empname;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public int getEmpno() {
        return empno;
    }

    public String getEmpname() {
        return empname;
    }
}
