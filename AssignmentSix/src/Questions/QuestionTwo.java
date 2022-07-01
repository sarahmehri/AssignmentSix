package Questions;

public class QuestionTwo {
    static char last_removed; //will store the last char removed during recursion

    // Recursively removes adjacent duplicates from str and
    // returns new string. last_removed is a pointer to
    // last_removed character
    static String removeUtil(String str)
    {

        // If length of string is 1 or 0
        if (str.length() == 0 || str.length() == 1)
            return str;

        // Remove leftmost same characters and recur for
        // remaining string
        if (str.charAt(0) == str.charAt(1)) {
            last_removed = str.charAt(0);
            while (str.length() > 1
                    && str.charAt(0) == str.charAt(1))
                str = str.substring(1, str.length());
            str = str.substring(1, str.length());
            return removeUtil(str);
        }

        // At this point, the first character is definitely
        // different from its adjacent. Ignore first
        // character and recursively remove characters from
        // remaining string
        String rem_str
                = removeUtil(str.substring(1, str.length()));

        // Check if the first character of the rem_string
        // matches with the first character of the original
        // string
        if (rem_str.length() != 0
                && rem_str.charAt(0) == str.charAt(0)) {
            last_removed = str.charAt(0);

            // Remove first character
            return rem_str.substring(1, rem_str.length());
        }

        if (rem_str.length() == 0
                && last_removed == str.charAt(0))
            return rem_str;


        return (str.charAt(0) + rem_str);
    }

    static String remove(String str)
    {
        last_removed = ' ';
        return removeUtil(str);
    }

    // Driver code
    public static void main(String args[])
    {

        String str8 = "azxxxzy";
        System.out.println(remove(str8));
    }
}