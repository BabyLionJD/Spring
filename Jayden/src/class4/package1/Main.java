package class4.package1;

import class4.role.Lion;
import class4.role.Role;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Service service = new Service();

            List<Role> members = new ArrayList<>();
            members.add(new Lion("Jayden", 1, "Computer", "Backend", 1));

            System.out.println("Your name? : ");
            String name = scanner.nextLine();

            System.out.println("lion or staff? : ");
            String role = scanner.nextLine();

            try {
                members = service.addMember(members, name, role);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");

            service.printMembers(members);

            System.out.println("What is the name you are looking for? : ");
            String name2 = scanner.nextLine();

            Role found = service.searchMember(members, name2);
            if (found != null) {
                System.out.println(found.getDetailInfo());
            } else {
                System.out.println("That member doesn't exist");
            }
        }
    }
}
