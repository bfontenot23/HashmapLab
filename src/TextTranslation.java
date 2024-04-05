import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class TextTranslation {

    static Scanner in = new Scanner(System.in);
    public static Scanner getInputFile() throws FileNotFoundException
    {
        File file;
        boolean validFile = false;
        String filename, filepath;
        System.out.println();
        do {
            System.out.print("\nEnter input filename: ");
            filename = in.next();
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

        System.out.print("Enter abbreviated text: ");
        String userInput = in.nextLine();
        // Regular expression to split the string based on spaces
        String[] words = userInput.split("\\s+");
// missing code for hashmap lookup and string concatenation

        in.close();
    }
}
