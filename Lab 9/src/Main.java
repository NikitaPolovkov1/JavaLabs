import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean flag = true;
        while(flag) {
            System.out.println("Enter: 1,2,3");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice)
            {
                case 1:
                    FirstThread f_t = new FirstThread();
                    System.out.println(f_t.get());
                    f_t.run();
                    System.out.println(f_t.getState());

                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    flag = false;
                    break;
            }
        }
    }
}