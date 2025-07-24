package kiosk5;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    protected List<MenuItem> burgerMenu =  new ArrayList<>();
    protected List<MenuItem> beverageMenu =  new ArrayList<>();
    protected List<MenuItem> dessertMenu =  new ArrayList<>();

    protected void makeMenu() {
        makeBurgerMenu();
        makeBeverageMenu();
        makeDessertMenu();
    }

    //TODO: dummyData를 사용하는 방식과 index로 접근하는 방식 중 고민
    private void makeBurgerMenu() {
        burgerMenu.add(new MenuItem("dummyData", 0.0, "dummyData"));
        burgerMenu.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgerMenu.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgerMenu.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgerMenu.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));
    }

    private void makeBeverageMenu() {
        beverageMenu.add(new MenuItem("dummyData", 0.0, "dummyData"));
        beverageMenu.add(new MenuItem("cola", 1.0, "시원한 콜라"));
        beverageMenu.add(new MenuItem("sprite", 1.0, "시원한 사이다"));
        beverageMenu.add(new MenuItem("milkshake", 2.5, "시원한 밀크쉐이크"));
    }

    private void makeDessertMenu() {
        dessertMenu.add(new MenuItem("dummyData", 0.0, "dummyData"));
        dessertMenu.add(new MenuItem("Vanilla Custard", 3.5, "부드럽고 진한 바닐라 커스터드 아이스크림"));
        dessertMenu.add(new MenuItem("Chocolate Custard", 3.5, "달콤한 초콜릿 커스터드 아이스크림"));
        dessertMenu.add(new MenuItem("Brownie", 2.0, "촉촉하고 진한 초콜릿 브라우니"));
        dessertMenu.add(new MenuItem("Cookie", 1.5, "겉은 바삭하고 속은 부드러운 쿠키"));
    }

    //전체 메뉴 출력
    protected void printMenu(int categoryNum){
        System.out.println("------------------------------------------------------------------------------");
        switch (categoryNum){
            case 1:
                System.out.println("|   [SHAKESHAKE - Burger Menu ]                                              |");
                for (int i = 1; i < burgerMenu.size(); i++){
                    System.out.println("|  " + i + ". " + burgerMenu.get(i));
                }
                System.out.println("|  0. 뒤로가기                                                                 |");
                System.out.println("------------------------------------------------------------------------------");
                break;
            case 2:
                System.out.println("|   [SHAKESHAKE - Beverage Menu ]                                            |");
                for (int i = 1; i < beverageMenu.size(); i++){
                    System.out.println("|  " + i + ". " + beverageMenu.get(i));
                }
                System.out.println("|  0. 뒤로가기                                                                 |");
                System.out.println("------------------------------------------------------------------------------");
                break;
            case 3:
                System.out.println("|   [SHAKESHAKE - Dessert Menu ]                                             |");
                for (int i = 1; i < dessertMenu.size(); i++){
                    System.out.println("|  " + i + ". " + dessertMenu.get(i));
                }
                System.out.println("|  0. 뒤로가기                                                                 |");
                System.out.println("------------------------------------------------------------------------------");
                break;
            default:
                System.out.println("메뉴판에 존재하는 번호를 입력해주세요.\n");
        }
    }

    //선택 메뉴 출력
    protected void printManuItem(int currentPage, int inputNum){
        switch(currentPage){
            case 1:
                System.out.println("선택 메뉴명: " + burgerMenu.get(inputNum).getName());
                System.out.println("선택 메뉴가격: " + burgerMenu.get(inputNum).getPrice());
                break;
            case 2:
                System.out.println("선택 메뉴명: " + beverageMenu.get(inputNum).getName());
                System.out.println("선택 메뉴가격: " + beverageMenu.get(inputNum).getPrice());
                break;
            case 3:
                System.out.println("선택 메뉴명: " + dessertMenu.get(inputNum).getName());
                System.out.println("선택 메뉴가격: " + dessertMenu.get(inputNum).getPrice());
                break;
        }
    }
}
