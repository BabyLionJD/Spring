package week4.package2;

import week4.role.Lion;
import week4.role.Role;
import week4.role.Staff;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Role> members = new ArrayList<>();
        Map<String, List<Role>> partMap = new HashMap<>();

        while (true) {
            System.out.println("===== 🦁 멤버 관리 시스템 =====");
            System.out.println("1. 멤버 등록");
            System.out.println("2. 전체 멤버 조회");
            System.out.println("3. 이름으로 검색");
            System.out.println("4. 파트별 조회");
            System.out.println("5. 종료");
            System.out.print("선택: ");

            int menu = sc.nextInt();
            sc.nextLine();

            if (menu == 1) {
                System.out.println("-- 📝 멤버 등록 --");

                System.out.print("역할 선택 (1: 아기사자, 2: 운영진): ");
                int roleChoice = sc.nextInt();
                sc.nextLine();

                System.out.print("이름: ");
                String name = sc.nextLine();

                boolean duplicated = false;

                for (Role member : members) {
                    if (member.getName().equals(name)) {
                        duplicated = true;
                        break;
                    }
                }

                if (duplicated) {
                    System.out.println("❌ 등록 실패: 이미 존재하는 이름입니다.");
                    continue;
                }

                System.out.print("전공: ");
                String major = sc.nextLine();

                System.out.print("기수: ");
                int cd = sc.nextInt();
                sc.nextLine();

                System.out.print("파트: ");
                String part = sc.nextLine();

                Role member;

                if (roleChoice == 1) {
                    System.out.print("학번: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    member = new Lion(name, major, cd, part, id);

                } else if (roleChoice == 2) {
                    System.out.print("직책: ");
                    String position = sc.nextLine();

                    member = new Staff(name, major, cd, part, position);

                } else {
                    System.out.println("❌ 잘못된 역할 선택입니다.");
                    continue;
                }

                members.add(member);

                if (!partMap.containsKey(part)) {
                    partMap.put(part, new ArrayList<>());
                }

                partMap.get(part).add(member);

                System.out.println("✅ 등록 완료: " + name);

            } else if (menu == 2) {
                System.out.println("-- 📋 전체 멤버 목록 --");

                if (members.isEmpty()) {
                    System.out.println("등록된 멤버가 없습니다.");
                    continue;
                }

                for (int i = 0; i < members.size(); i++) {
                    Role member = members.get(i);

                    String roleName;

                    if (member instanceof Lion) {
                        roleName = "아기사자";
                    } else {
                        roleName = "운영진";
                    }

                    System.out.println((i + 1) + ". [" + roleName + "] "
                            + member.getName() + " - " + member.getCd() + "기");
                }

                System.out.println("📊 총 " + members.size() + "명");

            } else if (menu == 3) {
                System.out.println("-- 🔍 이름으로 검색 --");

                System.out.print("검색할 이름: ");
                String searchName = sc.nextLine();

                Role found = null;

                for (Role member : members) {
                    if (member.getName().equals(searchName)) {
                        found = member;
                        break;
                    }
                }

                if (found == null) {
                    System.out.println("❌ 검색 결과가 없습니다.");
                } else {
                    System.out.println("✨ [검색 결과]");
                    System.out.println(found.getDetailInfo());

                    if (found.submit()) {
                        System.out.println("📝 과제 제출 가능 여부: ✅ 가능");
                    } else {
                        System.out.println("📝 과제 제출 가능 여부: ❌ 불가능");
                    }
                }

            } else if (menu == 4) {
                System.out.println("-- 💻 파트별 조회 --");

                if (partMap.isEmpty()) {
                    System.out.println("등록된 파트가 없습니다.");
                    continue;
                }

                System.out.println("📂 등록된 파트: " + partMap.keySet());

                System.out.print("조회할 파트: ");
                String searchPart = sc.nextLine();

                if (!partMap.containsKey(searchPart)) {
                    System.out.println("❌ 해당 파트가 없습니다.");
                    continue;
                }

                List<Role> partMembers = partMap.get(searchPart);

                System.out.println("✨ [" + searchPart + " 파트 멤버]");

                for (int i = 0; i < partMembers.size(); i++) {
                    Role member = partMembers.get(i);

                    String roleName;

                    if (member instanceof Lion) {
                        roleName = "아기사자";
                    } else {
                        roleName = "운영진";
                    }

                    System.out.println((i + 1) + ". "
                            + member.getName()
                            + " (" + roleName + ") - "
                            + member.getCd() + "기");
                }

            } else if (menu == 5) {
                System.out.println("프로그램을 종료합니다.");
                break;

            } else {
                System.out.println("잘못된 선택입니다.");
            }
        }
    }
}