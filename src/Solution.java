import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter 1st number : ");
        int x = in.nextInt();
        System.out.print("Enter 2sd number : ");
        int y = in.nextInt();
        System.out.print("Enter 3th number : ");
        int z = in.nextInt();
        check(x, y, z);
        in.close();
    }

    private static boolean check(int x, int y, int z){
        boolean result1 = checkCorrectNumberAndPositive(1, 1, x, y, z, 6, 8, 2);
        boolean result2 = checkCorrectNumberAndPositive(1, 0, x, y, z, 6, 1, 4);
        boolean result3 = checkCorrectNumberAndPositive(2, 0, x, y, z, 2, 0, 6);
        boolean result4 = checkCorrectNumberAndPositive(0, 0, x, y, z, 7, 3, 8);
        boolean result5 = checkCorrectNumberAndPositive(1, 0, x, y, z, 7, 8, 0);

        boolean finalResult = result1 && result2 && result3 && result4 && result5;

        if(finalResult){
            System.out.println("Correct number!");
        } else {
            System.out.println("Wrong number!");
        }

        System.out.println("-----Details-----");
        System.out.println(result1 + " -> One number is correct and well placed (6 - 8 - 2)");
        System.out.println(result2 + " -> One number is correct but wrongly placed (6 - 1 - 4)");
        System.out.println(result3 + " -> Two number are correct but wrongly placed (2 - 0 - 6)");
        System.out.println(result4 + " -> Nothing is correct (7 - 3 - 8)");
        System.out.println(result5 + " -> One number is correct but wrongly placed (7 - 8 - 0)");
        return finalResult;
    }

    private static boolean checkCorrectNumberAndPositive(int n1, int n2, int x, int y, int z, int a, int b, int c) {
        boolean correctNumber = correctNumber(n1, x, y, z, a, b, c);
        boolean correctPosition = correctPosition(n2, x, y, z, a, b, c);
        return correctNumber && correctPosition;
    }

    private static boolean correctPosition(int num, int x, int y, int z, int a, int b, int c) {
        boolean validx = (x == a);
        boolean validy = (y == b);
        boolean validz = (z == c);
        return countTrue(validx, validy, validz) == num;
    }

    private static boolean correctNumber(int num, int x, int y, int z, int a, int b, int c) {
        boolean validx = (x == a || x == b || x == c);
        boolean validy = (y == a || y == b || y == c);
        boolean validz = (z == a || z == b || z == c);
        return countTrue(validx, validy, validz) == num;
    }

    private static int countTrue(boolean validx, boolean validy, boolean validz) {
        int count = 0;
        if (validx == true) { count++; }
        if (validy == true) { count++; }
        if (validz == true) { count++; }
        return count;
    }
}
