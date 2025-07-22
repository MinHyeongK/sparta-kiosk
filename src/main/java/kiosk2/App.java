package kiosk2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        //햄버거 메뉴를 menuItems 객체를 생성하고 추가
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("dummyData", 0.0, "dummyData"));
        menuItems.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        //입력을 위한 스캐너 생성
        Scanner sc = new Scanner(System.in);

        while(true) {
            //키오스크 시작
            System.out.println("[메뉴보기]를 입력하세요.");
            String start = sc.next();
            if (start.equals("메뉴보기")) {
                break;
            }
        }

        while(true){
            //메뉴판 출력
            System.out.println("---------------------------------------------------------------------------");
            System.out.println("|  [ SHAKESHACK MENU ]                                                    |");
            for (int i = 1; i<menuItems.toArray().length; i++){
                System.out.println("|  " + (i) + ". " + menuItems.get(i));
            }
            System.out.println("|  0. 종료             |  종료                                             |");
            System.out.println("---------------------------------------------------------------------------");

            //입력에 따른 출력
            int input = sc.nextInt();
            MenuItem output = null;

            switch (input) {
                case 1:
                    output = menuItems.get(input);
                    break;
                case 2:
                    output = menuItems.get(input);
                    break;
                case 3:
                    output = menuItems.get(input);
                    break;
                case 4:
                    output = menuItems.get(input);
                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("보기에 존재하는 번호를 입력해주세요.\n");
                    continue;
            }
            if (output != null){
                System.out.println("선택메뉴: " + output.getName());
                System.out.println("메뉴금액: " + "W " + output.getPrice());
            }
        }
    }
}
