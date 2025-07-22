package kiosk3;

import kiosk3.MenuItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        //키오스크 시작(객체 생성)
        Kiosk kiosk = new Kiosk();
        kiosk.turnOn();
        kiosk.typingShowMenu();
    }
}
