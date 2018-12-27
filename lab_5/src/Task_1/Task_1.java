package Task_1;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.HashSet;
import java.util.AbstractCollection;
import java.util.Iterator;

public class Task_1
{
    public static void main(String[] args)
    {
        int len = 10000;

        System.out.println("Linked list");
        printTimeForAddFindRemove(len, new LinkedList<Integer>());

        System.out.println("Array list");
        printTimeForAddFindRemove(len, new ArrayList<Integer>());

        System.out.println("Tree set");
        printTimeForAddFindRemove(len, new TreeSet<Integer>());

        System.out.println("Hash set");
        printTimeForAddFindRemove(len, new HashSet<Iterator>());
    }

    private static void printTimeForAddFindRemove(int len, AbstractCollection currentCollection)
    {
        long point0 = System.nanoTime();

        for (int i = 0; i < len; i = i + 1) currentCollection.add(i);

        long point1 = System.nanoTime();

        currentCollection.contains(len-1);

        long point2 = System.nanoTime();

        currentCollection.remove( (int)Math.floor(len/2)  );

        long point3 = System.nanoTime();

        System.out.println("elements adding took: " + ((point1 - point0)) + "ns");
        System.out.println("elements finding took: " + ((point2 - point1)) + "ns");
        System.out.println("element delete took: " + ((point3 - point2)) + "ns");
    }
}
