package fi.lut.week_6.example_1;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Lion simba = new Lion("Simba", 5, 30);
        Penguin pingu = new Penguin("Pingu", 3, 20.5);

        // Demonstrating inheritance
        System.out.println(simba.getName() + " says: " + simba.makeSound());
        simba.eat();
        simba.hunt();

        System.out.println(pingu.getName() + " says: " + pingu.makeSound());
        pingu.eat();
        pingu.swim();
    }
}
