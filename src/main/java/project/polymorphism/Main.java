package project.polymorphism;

public class Main {
    public static void main(String[] args) {
        Animal animal1 = new Cat(); // 업캐스팅
        Animal animal2 = new Dog();

        animal1.exist();
        animal1.makeSound();


        animal2.exist();
        animal2.makeSound();
    }
}
