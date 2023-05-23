package task2;

public class App {
    public static void main(String[] args) {
        OperationDecorator operation = new NotifyOperation(100, new AccountOperation(),100000);
        operation.withdrawMoney(10000);
        operation.withdrawMoney(50);
        operation.withdrawMoney(500);
        operation.withdrawMoney(89449);
    }
}
