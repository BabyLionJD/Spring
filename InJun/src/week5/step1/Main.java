package week5.step1;

import week5.step1.role.Lion;
import week5.step1.role.Role;
import week5.step1.role.Staff;
import week5.step1.service.MemberService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        MemberService service = new MemberService();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println("🦁 ===== 멋사 멤버 관리 시스템 (Step 1: 직접 생성) ===== 🦁");
            System.out.println("1. ➕ 멤버 등록");
            System.out.println("2. 🗂 전체 멤버 조회");
            System.out.println("3. 🔍 이름으로 검색");
            System.out.println("4. 🚪 종료");
            System.out.print("선택: ");

            int num = scanner.nextInt();
            scanner.nextLine();

            if (num == 1) {
                System.out.print("👤 역할 선택 (1: 아기사자, 2: 운영진): ");
                int number = scanner.nextInt();
                scanner.nextLine();

                System.out.print("이름: ");
                String name = scanner.nextLine();

                System.out.print("전공: ");
                String major = scanner.nextLine();

                System.out.print("기수: ");
                int cd = scanner.nextInt();
                scanner.nextLine();

                System.out.print("파트: ");
                String part = scanner.nextLine();

                Role role;

                if (number == 1) {
                    System.out.print("학번: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    role = new Lion(name, major, cd, part, id);

                } else if (number == 2) {
                    System.out.print("직책: ");
                    String position = scanner.nextLine();

                    role = new Staff(name, major, cd, part, position);

                } else {
                    System.out.println("잘못된 역할 선택입니다.");
                    continue;
                }

                boolean result = service.register(role);

                if (result) {
                    System.out.println("✅ 등록 완료: " + role.getName());
                } else {
                    System.out.println("❌ 이미 같은 이름의 멤버가 있습니다.");
                }

            } else if (num == 2) {
                System.out.println("📋 ===== 전체 멤버 조회 =====");

                List<Role> members = service.findAll();

                if (members.isEmpty()) {
                    System.out.println("등록된 멤버가 없습니다.");
                    continue;
                }

                for (Role member : members) {
                    System.out.println(member.getDetailInfo());
                    System.out.println("📝 과제 제출 가능: " + (member.submit() ? "✅ 가능" : "❌ 불가능"));
                    System.out.println("-------------------------");
                }

            } else if (num == 3) {
                System.out.println("🔍 ===== 이름으로 멤버 검색 =====");

                System.out.print("검색할 이름: ");
                String searchName = scanner.nextLine();

                Role foundMember = service.findByName(searchName);

                if (foundMember == null) {
                    System.out.println("❌ 검색 결과가 없습니다.");
                } else {
                    System.out.println("🎯 검색 결과");
                    System.out.println(foundMember.getDetailInfo());
                    System.out.println("📝 과제 제출 가능: " + (foundMember.submit() ? "✅ 가능" : "❌ 불가능"));
                }

            } else if (num == 4) {
                System.out.println("프로그램을 종료합니다.");
                break;

            } else {
                System.out.println("❌ 잘못된 메뉴입니다.");
            }
        }

        scanner.close();
    }
}