package task3;

import task3.MainClasses.Publisher;
import task3.SimpleClasses.PrintEdition;
import task3.SimpleClasses.Subscriber;

public class Main {
    public static void main(String[] args) {
        Publisher publisher = new Publisher();
        Subscriber subscriber1 = new Subscriber("Подписчик 1");
        Subscriber subscriber2 = new Subscriber("Подписчик 2");
        Subscriber subscriber3 = new Subscriber("Подписчик 3");
        publisher.subscribe(subscriber1);
        publisher.subscribe(subscriber2);
        publisher.subscribe(subscriber3);
        PrintEdition printEdition = new PrintEdition("Газета 'Новости'");
        publisher.sendPrintEdition(printEdition);
        publisher.unsubscribe(subscriber2);
        PrintEdition printEdition2 = new PrintEdition("Журнал 'Наука и жизнь'");
        publisher.sendPrintEdition(printEdition2);
    }
}
