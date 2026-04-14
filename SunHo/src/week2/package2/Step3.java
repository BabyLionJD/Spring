package week2.package2;

import week2.package1.Lion;

public class Step3 {

    static void main() {
        Lion lion = new Lion();

        System.out.println("🦁아기사자 이름을 입력해주세요.");
        lion.enterName();
        System.out.println("🎓전공을 입력해주세요.");
        lion.enterMajor();
        System.out.println("📌기수를 입력해주세요");
        lion.enterCohort();

        lion.print();
        System.out.println();

        System.out.println("📌Step 3-1. public 필드 접근을 시도합니다." );
        lion.name = "홍길동";
        System.out.println("👉name 필드 값을 변경합니다.");
        System.out.println("✅public 필드 접근 성공");
        lion.changedPrint();

        //lion.major = "컴퓨터공학과"; //major는 default 접근 제어자
        //lion.cohort = "14"; //cohort는 private 접근 제어자
    }
}

