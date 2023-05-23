package task2;

public class OperationDecorator implements Operation {
    private Operation operation;

    public OperationDecorator(Operation operation) {
        this.operation = operation;
    }

    @Override
    public void withdrawMoney(int money) {

        operation.withdrawMoney(money);
    }
}
