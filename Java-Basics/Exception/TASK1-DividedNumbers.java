import java.util.Scanner;

public class DivideNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("pls enter the frist number");
            int a = sc.nextInt();

            System.out.print(" pls Enter second number ");
            int b = sc.nextInt();

            int result = a / b; // ممكن يطلع ArithmeticException
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero!");
        } catch (Exception e) {
            System.out.println("Invalid input!");
        } 
    }
}
