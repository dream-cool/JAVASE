package reflection;

public class User {
    private int id;
    private  int age;
    private  String uname;
    public String tel;

    public User() {
    }

    public User(int id, int age, String uname) {
        this.id = id;
        this.age = age;
        this.uname = uname;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setUname(String unaem) {
        this.uname = unaem;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getUname() {
        return uname;
    }
}
