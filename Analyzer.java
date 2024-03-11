import java.io.IOException;

public class Analyzer {
    public static void main(String[] args) throws IOException {
        String[] oldLines = PythonParser.fileToStringArray("Resources\\testFile1.py");
        String[] originalLines = PythonParser.fileToStringArray("Resources\\testFile1.py");

        String[] newLines = Indentation.fixTabs(oldLines);
        Headers.findHeaders(newLines);
        PrintCounter.findPrint(newLines);

        for (int i = 0; i < originalLines.length; i++) {
            System.out.println((originalLines[i]));
        }
        for (int i = 0; i < newLines.length; i++) {
            System.out.println((newLines[i]));
        }

        System.out.println("Print functions used: " + PrintCounter.printNum);


        // OutputFormatter(pythonOrigional,pythonParsed,counter);
        //output origional input program, output program, and the number of times the keyword "print is used"

    }
}