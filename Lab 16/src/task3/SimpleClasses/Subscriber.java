package task3.SimpleClasses;

public class Subscriber {
    private String name;

    public Subscriber(String name) {
        this.name = name;
    }

    public void receivePrintEdition(PrintEdition printEdition) {
        System.out.println("Подписчик " + name + " получил издание: " + printEdition.getTitle());
    }
}