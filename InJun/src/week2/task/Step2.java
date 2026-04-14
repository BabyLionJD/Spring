package week2.task;

import java.util.Scanner;

public class Step2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("\uD83E\uDD81 아기사자 이름을 입력해주세요.");
        String name = scanner.nextLine();

        System.out.println("\uD83D\uDCDA 전공을 입력해주세요.");
        String major = scanner.nextLine();

        System.out.println("\uD83D\uDCCC 기수를 입력해주세요.");
        int num = scanner.nextInt();
        scanner.nextLine();

        Lion lion = new Lion(name,major,num);

        System.out.println("⏩ 객체 생성이 완료되었습니다. 아기사자 객체의 상태를 확인합니다.");
        boolean result = lion.Myresult();

        if(result) {
            System.out.println("✅ 아기사자 객체가 자신의 상태를 정상으로 판단했습니다.");
            System.out.println("\uD83E\uDD81 아기사자 정보를 출력합니다.");
            System.out.println("👤 이름: " + lion.name + " | 🧑‍🎓 전공: " + lion.major + " | 📌 기수: " + lion.getNum());

        } else {

            System.out.println("❌ 잘못된 아기사자 정보입니다.");
        }

    }
}
