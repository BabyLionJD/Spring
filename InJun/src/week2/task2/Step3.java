package week2.task2;

import week2.task.Lion;

public class Step3 {
    public static void main(String[] args) {

        System.out.println("🦁 아기사자 객체를 생성합니다.");

        Lion lion = new Lion("김멋대", "컴퓨터공학과", 14);

        System.out.println("🦁 아기사자 정보를 출력합니다.");
        System.out.println("👤 이름: " + lion.name + " | 📚 전공: " + lion.getMajor() + "| 📌 기수: " + lion.getNum());

        System.out.println("\n📌 Step 3-1. public 필드 접근을 시도합니다.");
        System.out.println("name 필드 값을 변경합니다.");
        lion.name = "홍길동";
        System.out.println("🦁 아기사자 정보를 출력합니다.");
        System.out.println("👤 이름: " + lion.name + " | 📚 전공: " + lion.getMajor() + "| 📌 기수: " + lion.getNum());

/*      // default 접근 불가 (다른 패키지이므로). 주석 해제 시 컴파일 오류 발생
        System.out.println("\n📌 Step 3-2. default 필드 접근을 시도합니다.");
        System.out.println("name 필드 값을 변경합니다.");
        lion.major = "기계공학과";
        System.out.println("🦁 아기사자 정보를 출력합니다.");
        System.out.println("👤 이름: " + lion.name + " | 📚 전공: " + lion.getMajor() + "| 📌 기수: " + lion.getNum());
*/


    /*    //private 접근 불가. 주석을 풀면 에러.
        System.out.println("\n📌 Step 3-3. private 필드 접근을 시도합니다.");
        System.out.println("num 필드 값을 변경합니다.");
        lion.num = 10;
        System.out.println("🦁 아기사자 정보를 출력합니다.");
        System.out.println("👤 이름: " + lion.name + " | 📚 전공: " + lion.getMajor() + "| 📌 기수: " + lion.getNum());
    */




    }
}
