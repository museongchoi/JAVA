package Week4;

import java.util.Scanner;

public class BOJ10992 {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for(int i = 0; i < N-1; i++)
        {
            for(int j = N-1; j > i; j--)
            {
                System.out.print(" ");
            }
            System.out.print("*");
            if(i != 0)
            {
                for(int k = 0; k < 2*i-1; k++)
                {
                    System.out.print(" ");
                }
                System.out.print("*");
            }
            System.out.print("\n");
        }
        for(int j = 0; j < 2*N-1; j++)
        {
            System.out.print("*");
        }
        System.out.println();
    }
}
