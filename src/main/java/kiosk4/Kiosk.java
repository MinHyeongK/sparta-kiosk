package kiosk4;

import java.util.List;
import java.util.Scanner;

//키오스크 프로그램의 메뉴 관리, 사용자 입력 처리 담당
public class Kiosk {
    private Scanner sc = new Scanner(System.in);
    private final Menu menu = new Menu();
    private boolean isStarted;
    private int currentPage = 0; //0: MainPage, 1: Burger, 2.Beverage 3.Dessert
    //메인페이지를 출력해야되는 경우 true(반복 출력 방지)
    private boolean isMainPagePrint = true;

    //키오스크 시작 메서드
    protected void start(){
        this.isStarted = true;

        //상세 메뉴 구성
        menu.makeMenu();
    }

    //메뉴보기 입력 처리 메서드
    protected void typingShowMenu(){
        sc = new Scanner(System.in);
        if (isStarted){
            // 메뉴보기 버튼 클릭(문자 입력으로 대체)
            while(true) {
                System.out.println("[메뉴보기]를 입력하세요.");
                String start = sc.next();
                if (!start.equals("메뉴보기")) {
                    break;
                }
            }
        }
    }

    //메뉴판 출력
    private void showMainPage(){
        currentPage = 0;
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("|   [SHAKESHAKE - MAIN MENU ]                                                |");
        System.out.println("|  1. Burger Menu");
        System.out.println("|  2. Beverage Menu");
        System.out.println("|  3. Dessert Menu");
        System.out.println("|  0. 종료                                                                    |");
        System.out.println("------------------------------------------------------------------------------");
    }

    // 메뉴 보여주기
    private void showMenu(int inputNum){
            switch(inputNum){
                case 1:
                    menu.printMenu(1);
                    break;
                case 2:
                    menu.printMenu(2);
                    break;
                case 3:
                    menu.printMenu(3);
                    break;
            }
    }

    // 입력시작
    public void startMenuSelect(){
        while (true){
            if (currentPage == 0){
                if (isMainPagePrint){
                    showMainPage();
                    isMainPagePrint = false;
                }
                int inputNum = sc.nextInt();
                handleMenuCategoryInput(inputNum);
            } else{
                int inputNum = sc.nextInt();
                handleMenuDetailInput(inputNum);
            }
        }
    }

    private void handleMenuCategoryInput(int inputNum){
        switch(inputNum){
            case 0:
                System.out.println("키오스크를 종료합니다.");
                turnOffKiosk();
            case 1:
            case 2:
            case 3:
                currentPage = inputNum;
                showMenu(inputNum);
                break;
            default:
                System.out.println("메뉴에 존재하는 번호를 입력해주세요.\n");
                break;
        }
    }

    private void handleMenuDetailInput(int inputNum){
        try{
            if (inputNum == 0){
                currentPage = 0;
                isMainPagePrint = true;
                startMenuSelect();
                return;
            }
            menu.printManuItem(currentPage, inputNum);
        }catch (IndexOutOfBoundsException e){
        System.out.println("메뉴판에 존재하는 번호를 입력해주세요.\n");
        }
    }

    private void turnOffKiosk(){
        sc.close();
        System.exit(0);
    }
}
