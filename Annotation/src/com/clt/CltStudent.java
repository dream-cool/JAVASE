package com.clt;

@Table("tb_student")
public class CltStudent {
    @Clt_Field(columnName ="id",type ="int",legth =10)
    private  int id;
    @Clt_Field(columnName ="studentName",type ="varchar",legth =20)
    private  String studentName;
    @Clt_Field(columnName ="age",type ="int",legth =3)
    private  int age ;

    public void setId(int id) {
        this.id = id;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getAge() {
        return age;
    }
}
