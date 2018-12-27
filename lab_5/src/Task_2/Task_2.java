package Task_2;

import java.io.Writer;
import java.util.*;
import java.io.IOException;
import java.io.FileWriter;

public class Task_2
{
    public static void main(String[] args) throws IOException
    {
        ArrayList<Integer> alphaList = new ArrayList<Integer>();
        for (int i = 0; i < 150; i++)
            alphaList.add( (int)Math.round((Math.random() *199) + 1) );

        System.out.println("Alpha list at the start");
        System.out.println(alphaList);

        ArrayList<Integer> betaList = new ArrayList<Integer>(alphaList);
        betaList.sort(Collections.reverseOrder());
        for (int i=0; i<135; i++)
            betaList.remove(betaList.size()-1);

        System.out.println("Beta list");
        System.out.println(betaList);
        System.out.println("Alpha list at the end");
        System.out.println(alphaList);

        FileWriter fileWriter = new FileWriter("betaList.txt");
        fileWriter.write(betaList.toString());
        fileWriter.close();
    }
}