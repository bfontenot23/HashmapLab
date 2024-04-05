import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class TextTranslation {

    static Scanner in = new Scanner(System.in);
    public static Scanner getInputFile(String fileName) throws FileNotFoundException
    {
        File file;
        boolean validFile = false;
        String filename, filepath;
        System.out.println();
        do {
            filename = fileName;
            if(!filename.startsWith(":\\", 1) && !filename.startsWith(".\\") && !filename.startsWith(":/", 1) && !filename.startsWith("./") && !filename.startsWith("\\") && !filename.startsWith("/")) filepath = "./" + filename;
            else filepath = filename;
            file = new File(filepath);
            if(!file.exists())
            {
                // NOTE: THIS ERROR MAY RUN IF FOR WHAT EVER REASON WINDOWS DOESN'T LIKE FORWARD SLASH FILEPATHS
                System.out.printf("\nFile specified <%s> does not exist in the project folder.  Would you like to continue? <Y/N> ", filename);
                if(in.next().equals("N"))
                {
                    throw new FileNotFoundException();
                }
            }
            else
            {
                validFile = true;
            }
        }while(!validFile);

        return new Scanner(file);
    }
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<String, String>();

        // missing code for reading the file and loading the data into the map.
        Scanner input;
        try
        {
            input = getInputFile("acronyms.txt");
        }
        catch (FileNotFoundException e)
        {
            return;
        }

        boolean done = false;
        do {
            if(input.hasNextLine())
            {
                String line = input.nextLine();

                String[] split = line.split(",");
                map.put(split[0],split[1]);
            }
            else done = true;
        }while(!done);

        done = false;
        String userInput;
        String[] words;
        StringBuilder out;
        do {
            System.out.print("Enter abbreviated text: ");
            userInput = in.nextLine();

            // Regular expression to split the string based on spaces
            words = userInput.split("\\s+");

            // missing code for hashmap lookup and string concatenation
            out = new StringBuilder();
            for(String word : words)
            {
                if(map.containsKey(word))
                {
                    out.append(map.get(word));
                }
                else out.append(word);
                out.append(" ");
            }

            System.out.println(out.toString());

            System.out.print("Would you like to continue?");
            userInput = in.nextLine();

            if(!userInput.toLowerCase().equals("yes")) done = true;

        }while(!done);


        in.close();
    }
}
