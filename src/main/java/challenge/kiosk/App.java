package challenge.kiosk;

public class App {
    public static void main(String[] args) {
        //키오스크 시작(객체 생성)
        Kiosk kiosk = new Kiosk();
        kiosk.start();
        kiosk.typingShowMenu();
        kiosk.startMenuSelect();
    }
}
