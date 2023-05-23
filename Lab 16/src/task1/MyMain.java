package task1;

import task1.Abstract.DairyFactory;
import task1.Abstract.Product;
import task1.Factories.MalarDairyFactory;
import task1.Factories.XudoshnikDairyFactory;
import task1.Factories.VizashistDairyFactory;

import java.util.Scanner;

public class MyMain {
    public static void main(String[] args) {
        System.out.println("Выберите что хотите сделать\n 1 - Дать художнику кисти\n 2 - Дать визажисту кисти\n 3 - Дать маляру кисти");
        Scanner scanner = new Scanner(System.in);
        int choose =scanner.nextInt();
        switch (choose)
        {
            case 1:
            {
                DairyFactory XudoshnikDairyFactory = new XudoshnikDairyFactory();
                Product konKist = XudoshnikDairyFactory.createHourse();
                Product losKist = XudoshnikDairyFactory.createLos();
                Product dogKist = XudoshnikDairyFactory.createDog();
                konKist.printInfo();
                losKist.printInfo();
                dogKist.printInfo();
                break;
            }
            case 2:
            {
                DairyFactory vizashistDairyFactory = new VizashistDairyFactory();
                Product konKist = vizashistDairyFactory.createHourse();
                Product losKist = vizashistDairyFactory.createLos();
                Product dogKist = vizashistDairyFactory.createDog();

                konKist.printInfo();
                losKist.printInfo();
                dogKist.printInfo();
                break;
            }
            case 3:
            {
                DairyFactory malarDairyFactory = new MalarDairyFactory();
                Product konKist = malarDairyFactory.createHourse();
                Product losKist = malarDairyFactory.createLos();
                Product dogKist = malarDairyFactory.createDog();

                konKist.printInfo();
                losKist.printInfo();
                dogKist.printInfo();
                break;
            }

        }

    }
}