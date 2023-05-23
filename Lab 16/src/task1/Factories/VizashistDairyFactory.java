package task1.Factories;

import task1.Abstract.DairyFactory;
import task1.Abstract.Product;
import task1.SimpleClasses.Vizashist;

public class VizashistDairyFactory extends DairyFactory {
    @Override
    public Product createHourse() {
        return new Vizashist();
    }

    @Override
    public Product createLos() {
        return new Product() {
            @Override
            public void printInfo() {
                System.out.println("Визажист рисует кистью из лосиного волоса");
            }
        };
    }

    @Override
    public Product createDog() {
        return new Product() {
            @Override
            public void printInfo() {
                System.out.println("Визажист рисует кистью из собачьего волоса");
            }
        };
    }
}