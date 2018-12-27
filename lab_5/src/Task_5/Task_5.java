package Task_5;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class Task_5
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("text.txt");
        Scanner scanner = new Scanner(file);

        String scan_text = "";
        while (scanner.hasNextLine())
            scan_text+= scanner.nextLine() + " ";
        System.out.println(scan_text);

        ArrayList<String> word_array = new ArrayList<String>();
        for (String word: scan_text.split("\\s+"))
            word_array.add(word);

        word_array.sort(new ComporatorString());

        for(String word : word_array)
            System.out.print(word+' ');
    }
}