package task2;

public class NotifyOperation extends OperationDecorator {
    private int amount;
    private int money;
    private int maney;

    public NotifyOperation(int amount, Operation operation,int money) {
        super(operation);
        this.amount = amount;
        this.money=money;

    }

    @Override
    public void withdrawMoney(int maney) {
        if(money > maney){
            if(maney>amount)
            System.out.println("Со счета снята сумма "  + maney);
            super.withdrawMoney(money);
            money -= maney;
        }
        else
        {
            System.out.println("Сумма снятия привышает сумму на счете");
        }

    }
}
