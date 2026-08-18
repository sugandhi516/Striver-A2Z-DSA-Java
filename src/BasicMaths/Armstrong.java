package BasicMaths;

import java.util.Scanner;

public class Armstrong{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        int original = n;
        int temp = n;

        // Count number of digits
        int digits = 0;
      //calculatews how many digits present in the number;
        while (temp != 0) {
            digits++;
            temp = temp / 10;
        }

        int sum = 0;
        temp = n;

        // Calculate Armstrong sum
        while (temp != 0) {
            int digit = temp % 10;
            // Current code (only works correctly for 3-digit numbers):
          //  sum += (digit * digit * digit);//

// To fix it and make use of 'digits' for numbers of any length:
            sum += Math.pow(digit, digits);
            temp = temp / 10;
        }

        if (sum == original) {
            System.out.println("Armstrong Number");
        } else {
            System.out.println("Not an Armstrong Number");
        }
    }
}