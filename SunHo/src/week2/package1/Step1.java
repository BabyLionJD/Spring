package week2.package1;

import java.util.Scanner;

public class Step1 {

    static void main() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("🦁아기사자 이름을 입력해주세요.");
        String name = scanner.nextLine();
        System.out.println("🎓전공을 입력해주세요.");
        String major = scanner.nextLine();
        System.out.println("📌기수를 입력해주세요");
        int cohort = scanner.nextInt();

        System.out.println("📌입력값 검증을 진행합니다.");

        // 유효성 검사
        if (name.isEmpty()){
            System.out.println("⏩️입력값 검증을 통과하여 아기사자 객체 생성을 확인합니다.");
            System.out.println("❌이름은 비어 있을 수 없습니다.");
            return;
        }

        if(major.isEmpty()){
            System.out.println("⏩️입력값 검증을 통과하여 아기사자 객체 생성을 확인합니다.");
            System.out.println("❌전공은 비어 있을 수 없습니다.");
            return;
        }

        if(cohort <= 0){
            System.out.println("⏩️입력값 검증을 통과하여 아기사자 객체 생성을 확인합니다.");
            System.out.println("❌잘못된 아기사자 정보입니다.");
            return;
        }

        Lion lion = new Lion(name, major, cohort);
        System.out.println("⏩️입력값 검증을 통과하여 아기사자 객체 생성을 진행합니다.");
        System.out.println("✅아기사자 객체를 성공적으로 생성하였습니다.");
        System.out.println("🦁아기사자 정보를 출력합니다.");
        System.out.println("이름: " + lion.getName() + " | " + "🎓전공: " + lion.getMajor() + " | " + "📌기수: " + lion.getCohort());
    }
}


