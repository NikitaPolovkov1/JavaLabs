package task1.Factories;

import task1.Abstract.DairyFactory;
import task1.Abstract.Product;

public class XudoshnikDairyFactory extends DairyFactory {
    @Override
    public Product createHourse() {
        return new task1.SimpleClasses.Xudoshnik();
    }

    @Override
    public Product createLos() {
        return new Product() {
            @Override
            public void printInfo() {
                System.out.println("Художник рисует кистью из лосиного волоса");
            }
        };
    }

    @Override
    public Product createDog() {
        return new Product() {
            @Override
            public void printInfo() {
                System.out.println("Художник рисует кистью из собачьего волоса");
            }
        };
    }
}