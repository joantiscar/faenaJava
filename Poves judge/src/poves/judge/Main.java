
import java.util.Scanner;

class Main {

    public static void main(String[] args)throws Exception {

        
        Scanner sc = new Scanner(System.in);
        
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        
        if (((num1+num2) % 2) == 0) System.out.println((num1+num2) / 2);
        else System.out.println((float) (num1+num2) / 2);

    }
    
}
