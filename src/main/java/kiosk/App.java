package kiosk;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        while(true) {
            Scanner sc = new Scanner(System.in);

//          키오스크 시작
            System.out.println("[메뉴보기]를 입력하세요.");
            String start = sc.next();
            if(!start.equals("메뉴보기")){
                continue;
            }

//          메뉴판 리스트
            String[] menu = {"[ SHAKESHACK MENU ]",
                "1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거",
                "2. SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거",
                "3. Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거",
                "4. Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거",
                "0. 종료           | 종료"};

//          메뉴판 출력
            for (String i: menu){
                System.out.println(i);
            }

//          종료조건
            String exit = sc.next();
            if (exit.equals("0")){
                System.out.println("키오스크 종료");
                sc.close();
                break;
            }
        }
    }
}
