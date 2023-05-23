package task2;

public class AccountOperation implements Operation{
    @Override
    public void withdrawMoney(int money) {
        System.out.println("Деньги сняты");
    }
}
