package task1.Factories;


import task1.Abstract.DairyFactory;
import task1.Abstract.Product;
import task1.SimpleClasses.Malar;

public class MalarDairyFactory extends DairyFactory {
    @Override
    public Product createHourse() {
        return new Malar();
    }

    @Override
    public Product createLos() {
        return new Product() {
            @Override
            public void printInfo() {
                System.out.println("Маляр рисует кистью из лосиного волоса");
            }
        };
    }


    @Override
    public Product createDog() {
        return new Product() {
            @Override
            public void printInfo() {
                System.out.println("Маляр рисует кистью из собачьего волоса");
            }
        };
    }
}