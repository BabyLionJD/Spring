package week2.package1;

public class Step2 {

    static void main() {
        Lion lion = new Lion();

        System.out.println("🦁아기사자 이름을 입력해주세요.");
        lion.enterName();
        System.out.println("🎓전공을 입력해주세요.");
        lion.enterMajor();
        System.out.println("📌기수를 입력해주세요");
        lion.enterCohort();

        if (lion.isValid()) {
            System.out.println("⏩️입력값 검증을 통과하여 아기사자 객체 생성을 진행합니다.");
            System.out.println("✅아기사자 객체를 성공적으로 생성하였습니다.");
            System.out.println("🦁아기사자 정보를 출력합니다.");
            System.out.println("이름: " + lion.getName() + " | " + "🎓전공: " + lion.getMajor() + " | " + "📌기수: " + lion.getCohort());
        }
    }
}