package Task_4;

import java.util.Scanner;

public class Task_4
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int leftBoarder  = 0 , rightBoarder = 100 , userNumber;
        int target = (int)Math.round((Math.random() *100));

        do{
            System.out.println("left boarder :"+leftBoarder+"\nright boarder :"+rightBoarder);
            System.out.println("Enter number");
            userNumber = in.nextInt();

            if(userNumber <= leftBoarder | rightBoarder <=userNumber)
                System.out.println("Wrong Input! Try again");
            else if(userNumber > target ) {
                System.out.println("Bigger");
                rightBoarder = userNumber - 1;
            }
            else if(userNumber < target ) {
                System.out.println("Fewer");
                leftBoarder = userNumber + 1;
            }

        }while(userNumber != target);

        System.out.println("you win");
    }
}