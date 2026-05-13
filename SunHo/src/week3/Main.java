package week3;

import week3.role.Lion;
import week3.role.Member;
import week3.role.Staff;

import java.util.Scanner;

public class Main {

    static void main() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("====== 🦁아기사자 정보 입력 ======");

        System.out.print("👤이름: ");
        String lionName = scanner.nextLine();

        System.out.print("🎓전공: ");
        String lionMajor = scanner.nextLine();

        System.out.print("📌기수: ");
        int lionCohort = scanner.nextInt();

        System.out.print("💻파트 (백엔드/프론트엔드/기획/디자인): ");
        String lionPart = scanner.next();

        scanner.nextLine();

        System.out.print("🆔학번: ");
        int studentId = scanner.nextInt();

        scanner.nextLine();

        System.out.println("\n====== 🙎운영진 정보 입력 ======");

        System.out.print("👤이름: ");
        String staffName = scanner.nextLine();

        System.out.print("🎓전공: ");
        String staffMajor = scanner.nextLine();

        System.out.print("📌기수: ");
        int staffCohort = scanner.nextInt();

        scanner.nextLine();

        System.out.print("💻파트 (백엔드/프론트엔드/기획/디자인): ");
        String staffPart = scanner.nextLine();

        System.out.print("⭐️직책 (대표/부대표/파트장/멘토): ");
        String role = scanner.nextLine();

        System.out.println("\n====== 📋결과 출력 ======\n");

        Lion lion = new Lion(lionName, lionMajor, lionCohort, lionPart, studentId);
        Staff staff = new Staff(staffName, staffMajor, staffCohort, staffPart, role);

        printResult(lion);
        printResult(staff);
    }

    private static void printResult(Member member) {
        System.out.println(member.getDetails());
        System.out.println("과제 제출 가능 여부: " + (member.isSubmittable() ? "✅ 가능" : "❌ 불가능"));
    }
}
