package Task_6;

import java.util.Scanner;

public class Task_6
{
    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        String rev_string = "";

        System.out.print("Write string : ");
        for(char letter : in.nextLine().toCharArray())
            rev_string = letter + rev_string;

        System.out.print("Reverse string : "+rev_string);
    }
}
