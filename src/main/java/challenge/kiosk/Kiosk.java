package challenge.kiosk;

import java.util.Scanner;

//키오스크 프로그램의 메뉴 관리, 사용자 입력 처리 담당
public class Kiosk {
    private Scanner sc = new Scanner(System.in);
    private final Menu menu = new Menu();
    private final Basket basket = new Basket();
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
                if (start.equals("메뉴보기")) {
                    break;
                }
            }
        }
    }

    //메뉴판(메인페이지) 출력
    private void showMainPage(){
        currentPage = 0;
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("|                               [ SHAKESHAKE ]                               |");
        System.out.println("|   [ MAIN MENU ]                                                            |");
        System.out.println("|  1. Burger Menu                                                            |");
        System.out.println("|  2. Beverage Menu                                                          |");
        System.out.println("|  3. Dessert Menu                                                           |");
        System.out.println("|  0. 종료                                                                    |");
        if (!basket.getBasketItems().isEmpty()){
            System.out.println("|                                                                            |");
            System.out.println("|   [ ORDER MENU ]                                                           |");
            System.out.println("|  4. Orders                                                                 |");
            System.out.println("|  5. Cancel                                                                 |");
        }
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
            } else if(currentPage < 4){
                int inputNum = sc.nextInt();
                handleMenuDetailInput(inputNum);
            } else if(currentPage == 4){
                int inputNum = sc.nextInt();
                handleOrder(inputNum);
            } else{
                int inputNum = sc.nextInt();
                handleCancel(inputNum);
            }
        }
    }

    //메인메뉴에서의 입력 처리
    private void handleMenuCategoryInput(int inputNum){
        switch(inputNum){
            case 0:
                System.out.println("키오스크를 종료합니다.");
                turnOffKiosk();
                break;
            case 1:
            case 2:
            case 3:
                showMenu(inputNum);
                currentPage = inputNum;
                break;
            case 4:
                if(!basket.getBasketItems().isEmpty()){
                    currentPage = inputNum;
                } else{
                    System.out.println("메뉴에 존재하는 번호를 입력해주세요.\n");
                }
                break;
            case 5:
                System.out.println("구현 중...");
                break;
            default:
                System.out.println("메뉴에 존재하는 번호를 입력해주세요.\n");
                break;
        }
    }

    //상세메뉴에서의 입력처리
    private void handleMenuDetailInput(int inputNum){
        try{
            if (inputNum == 0){
                currentPage = 0;
                isMainPagePrint = true;
                startMenuSelect();
                return;
            }
            menu.printMenuItem(currentPage, inputNum);
            //장바구니에 넣을 대상에 대한 임시 변수
            String tempItem = menu.tempMenuItem(currentPage, inputNum);
            selectItemToAdd(tempItem);
            handleMenuCategoryInput(currentPage);
        }catch (IndexOutOfBoundsException e){
        System.out.println("메뉴판에 존재하는 번호를 입력해주세요.\n");
        }
    }

    private void selectItemToAdd(String tempItem){
        int inputNum = sc.nextInt();
        if(inputNum == 1){
            basket.addItem(tempItem);
            System.out.println(tempItem + "을 장바구니에 담았습니다.\n");
        } else if (inputNum == 2){
            //showMenu();
        } else{
            System.out.println("메뉴에 존재하는 번호를 입력해주세요.\n");
        }
    }

    private void handleOrder(int inputNum){
    // 장바구니 확인 후 주문 여부 구현
        System.out.println("아래와 같이 주문 하시겠습니까?");
        System.out.println();
        System.out.println("[ Orders ]");

    }

    private void handleCancel(int inputNum){
    // 진행중인 주문 취소 구현
    }

    //키오스크 종료 처리
    private void turnOffKiosk(){
        sc.close();
        System.exit(0);
    }
}
