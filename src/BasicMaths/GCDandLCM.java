
package BasicMaths;
import java.util.Scanner;
public class GCDandLCM {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int a = sc.nextInt();

        System.out.print("Enter second number: ");
        int b = sc.nextInt();

        int originalA = a;
        int originalB = b;

        // Find GCD using Euclidean Algorithm
        while (b!= 0) {
            int rem=a%b;
            a=b;
            b=rem;
        }

        int gcd = a;

        // LCM = (a * b) / GCD
        int lcm = (originalA * originalB) / gcd;

        System.out.println("GCD = " + gcd);
        System.out.println("LCM = " + lcm);
    }
}
