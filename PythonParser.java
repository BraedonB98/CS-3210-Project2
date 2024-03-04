import java.io.BufferedReader; //These are needed for reading the python file
import java.io.FileReader;
import java.io.IOException;

public class PythonParser {
    static int numLines;

    //Reads through file line by line to get # of lines
    public static int getNumLines(String filePath) throws IOException {
        numLines = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while (br.readLine() != null) {
                numLines++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return numLines;
    }

    //Calls on NumLines to count number of lines in file to avoid error, then populated a String array with each line of code.
    public static String[] fileToStringArray(String filepath) throws IOException {
        int numLines = getNumLines(filepath);
        BufferedReader br = new BufferedReader(new FileReader(filepath));
        String[] fileLines = new String[numLines];
        for (int i =0; i < numLines; i++) {
            fileLines[i] = br.readLine();
        }
        return fileLines;
    }

    //Outputs number of lines for testing purposes.
    public int getNumLines() {
        return numLines;
    }
}