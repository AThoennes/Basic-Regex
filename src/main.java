/**
 * Alex Thoennes
 */

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.File;
import java.io.IOException;

public class main
{
    public static void main(String[] args) throws IOException
    {
        // pattern to help find emails
        Pattern email = Pattern.compile("([A-Za-z0-9._%+-]+)@([A-Za-z0-9.-]+)\\.([A-Za-z]{2,4})");

        // pattern to help fin names
        Pattern name = Pattern.compile("([A-Za-z]+),\\s*([A-Za-z]+)\\s*([A-Za-z]*\\.*)");

        // scanner to read in file with tab and new line delimiters
        Scanner s = new Scanner(new File("StudentData.txt")).useDelimiter("\t|\n");

        // while there is still something to be read in the file
        while(s.hasNext())
        {
            // save the thing that was read in
            String tkn = s.next();

            // matcher that helps find if a name is found in the token
            // using the name pattern
            Matcher matcherName = name.matcher(tkn);

            // matcher that helps find if an email is found in the token
            // using the email pattern
            Matcher matcherEmail = email.matcher(tkn);

            // if a name was found print it out
            if (matcherName.matches())
            {
                System.out.print(matcherName.group(2)+" "+matcherName.group(3)+" "+matcherName.group(1));

            } // if an email was found print it out
            else if (matcherEmail.matches())
            {
                System.out.println(" - " + matcherEmail.group(1));
            }
        }
    }
}