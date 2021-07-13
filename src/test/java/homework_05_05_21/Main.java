package homework_05_05_21;

public class Main {
    public static void main (String[] args) {
        Bird popug = new Bird();

        popug.setColor("Green");
        popug.setName("Petya");
        popug.setHeight(10);

        System.out.println(popug.getInfo());
    }
}
