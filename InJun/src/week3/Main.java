package week3;

import week3.role.Lion;
import week3.role.Role;
import week3.role.Staff;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== 아기사자 정보 입력 =====");
        System.out.print("이름: ");
        String lionName = sc.nextLine();

        System.out.print("전공: ");
        String lionMajor = sc.nextLine();

        System.out.print("기수: ");
        int lionCd = Integer.parseInt(sc.nextLine());

        System.out.print("파트: ");
        String lionPart = sc.nextLine();

        System.out.print("학번: ");
        int lionId = Integer.parseInt(sc.nextLine());

        Role lion = new Lion(lionName, lionMajor, lionCd, lionPart, lionId);

        System.out.println();

        System.out.println("===== 운영진 정보 입력 =====");
        System.out.print("이름: ");
        String staffName = sc.nextLine();

        System.out.print("전공: ");
        String staffMajor = sc.nextLine();

        System.out.print("기수: ");
        int staffCd = Integer.parseInt(sc.nextLine());

        System.out.print("파트: ");
        String staffPart = sc.nextLine();

        System.out.print("직책: ");
        String staffPosition = sc.nextLine();

        Role staff = new Staff(staffName, staffMajor, staffCd, staffPart, staffPosition);

        System.out.println();
        System.out.println("===== 결과 출력 =====");


        printRole(lion);
        System.out.println("-------------------");
        printRole(staff);

        sc.close();
    }

    public static void printRole(Role role) {
        System.out.println(role.getDetailInfo());
        System.out.println("과제 제출 가능 여부: " + (role.submit() ? "가능" : "불가능"));
    }
}
