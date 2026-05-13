package week2.task;

import java.util.Scanner;

public class Step1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("\uD83E\uDD81 아기사자 이름을 입력해주세요.");
        String name = scanner.nextLine();


        System.out.println("\uD83D\uDCDA 전공을 입력해주세요.");
        String major = scanner.nextLine();



        System.out.println("\uD83D\uDCCC 기수를 입력해주세요.");
        int num = scanner.nextInt();
        scanner.nextLine();


        System.out.println("\uD83D\uDCCC 입력값 검증을 진행합니다.");

        if(name.isEmpty()) {
            System.out.println("❌ 이름은 비어 있을 수 없습니다.");
            return;
        }
        if (major.isEmpty()) {

            System.out.println("❌ 전공은 비어 있을 수 없습니다.");
            return;
        }
        if(num < 1) {
            System.out.println("❌ 기수는 1 미만일 수 없습니다.");
            return;
        }

        System.out.println("⏩ 입력값 검증을 통과하여 아기사자 객체 생성을 진행합니다.");

        Lion lion = new Lion(name, major, num);

        System.out.println("✅ 아기사자 객체를 성공적으로 생성하였습니다.");

        System.out.println("\uD83E\uDD81 아기사자 정보를 출력합니다.");
        System.out.println("👤 이름: " + lion.name + " | 🧑‍🎓 전공: " + lion.major + " | 📌 기수: " + lion.getNum());


    }
}
