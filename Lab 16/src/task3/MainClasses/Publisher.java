package task3.MainClasses;
import task3.SimpleClasses.Subscriber;
import java.util.ArrayList;
import java.util.List;
import task3.SimpleClasses.PrintEdition;
public class Publisher {
    private List<Subscriber> subscribers = new ArrayList<>();

    public void subscribe(Subscriber subscriber) {
        subscribers.add((Subscriber) subscriber);
    }

    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void sendPrintEdition(PrintEdition printEdition) {
        for (Subscriber subscriber : subscribers) {
            subscriber.receivePrintEdition(printEdition);
        }
    }
}