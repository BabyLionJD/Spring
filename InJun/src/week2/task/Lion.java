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


    public boolean Myresult() {
        if(name.isEmpty()) {
            System.out.println("❌ 이름은 비어 있을 수 없습니다.");
            return false;
        }
        if (major.isEmpty()) {
            System.out.println("❌ 전공은 비어 있을 수 없습니다.");
            return false;
        }
        if(num < 1) {
            System.out.println("❌ 기수는 1 미만일 수 없습니다.");

            return false;
        }

        return true;
    }

}