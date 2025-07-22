package kiosk;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
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
      //Feeback 1: 메뉴판 리스트(컬렉션 타입을 사용해보기.) String배열은 유연성이 떨어진다. 동적확장성을 위해 collection Type 사용
      //Feeback 2: class(필드 = 속성)설계와 class 간 관계 정의에 중점을 두자.
      //Feeback 3: 객체지향관련 강의(저번에 보내주신 유튜브 강의 CH.6,7,8****)
        String[] menu = {"[ SHAKESHACK MENU ]",
            "1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거",
            "2. SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거",
            "3. Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거",
            "4. Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거",
            "0. 종료           | 종료"};


            //메뉴판 출력
            for (String i: menu){
                System.out.println(i);
            }

          //입력에 따른 출력
            int input = sc.nextInt();
            String output = "";

            switch (input) {
                case 1:
                    output = menu[input];
                    break;
                case 2:
                    output = menu[input];
                    break;
                case 3:
                    output = menu[input];
                    break;
                case 4:
                    output = menu[input];
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
            System.out.println(output + "\n");
        }
    }
}
