package week2.package1;

import java.util.Scanner;

public class Lion {
    Scanner scanner = new Scanner(System.in);

    // 인스턴스 변수 선언
    public String name;
    String major;
    private int cohort;

    // 생성자
    public Lion() {}

    public Lion(String name, String major, int cohort) {
        this.name = name;
        this.major = major;
        this.cohort = cohort;
    }

    // 입력 메서드 추가
    public void enterName(){
        name = scanner.nextLine();
    }

    public void enterMajor(){
        major = scanner.nextLine();
    }

    public void enterCohort(){
        cohort = scanner.nextInt();
    }

    // 유효성 검사
    public  boolean isValid() {
        if (name.isEmpty()) {
            System.out.println("⏩️입력값 검증을 통과하여 아기사자 객체 생성을 확인합니다.");
            System.out.println("❌이름은 비어 있을 수 없습니다.");
            System.out.println("❌잘못된 아기사자 정보입니다.");
            return false;
        }

        if (major.isEmpty()) {
            System.out.println("⏩️입력값 검증을 통과하여 아기사자 객체 생성을 확인합니다.");
            System.out.println("❌전공은 비어 있을 수 없습니다.");
            System.out.println("❌잘못된 아기사자 정보입니다.");
            return false;
        }

        if (cohort <= 0) {
            System.out.println("⏩️입력값 검증을 통과하여 아기사자 객체 생성을 확인합니다.");
            System.out.println("❌기수는 0 이상의 정수입니다.");
            System.out.println("❌잘못된 아기사자 정보입니다.");
            return false;
        }

        return true;
    }

    // 출력 메서드 기능
    public void print(){
        if(isValid()) {
            System.out.println("⏩️입력값 검증을 통과하여 아기사자 객체 생성을 진행합니다.");
            System.out.println("✅아기사자 객체를 성공적으로 생성하였습니다.");
            System.out.println("🦁아기사자 정보를 출력합니다.");
            System.out.println("이름: " + getName() + " | " + "🎓전공: " + getMajor() + " | " + "📌기수: " + getCohort());
        }
    }

    // 변경한 값의 출력 메서드 기능
    public void changedPrint(){
        System.out.println("이름: " + getName() + " | " + "🎓전공: " + getMajor() + " | " + "📌기수: " + getCohort());
    }

    // Getter
    public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }

    public int getCohort() {
        return cohort;
    }

    // Setter // Step2에서 사용 X
    public void setName(String name) {
        this.name = name;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setCohort(int cohort) {
        this.cohort = cohort;
    }
}