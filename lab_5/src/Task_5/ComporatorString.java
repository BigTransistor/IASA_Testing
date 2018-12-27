package Task_5;

import java.util.Comparator;

public class ComporatorString implements Comparator<String> {

    public int compare(String a, String b)
    {
        return a.toLowerCase().compareTo(b.toLowerCase());
    }

}
