package Cognizant_DN.DeepSkilling.Week1.EngineeringConcepts.DesignPatternsAndPrinciples.Exercise1_SingletonPattern;

public class SingletonTest {

    public static void main(String[] args) {

        Printer p1 = Printer.getInstance();
        Printer p2 = Printer.getInstance();

        p1.print("Hello");
        p2.print("World");

        System.out.println(p1 == p2);
    }
}