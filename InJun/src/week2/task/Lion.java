package week2.task;

public class Lion {


    public String name;
    String major;
    private int num;

    public Lion(String name, String major, int num) {
        this.name = name;
        this.major = major;
        this.num = num;

    }

    public int getNum() {
        return num;
    }

    public String getMajor() {
        return major;
    }

    public String getName() {
        return name;
    }

}