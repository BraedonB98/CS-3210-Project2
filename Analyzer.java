import java.io.IOException;

public class Analyzer {
    public static void main(String[] args) throws IOException {
        String[] oldLines = PythonParser.fileToStringArray("Resources\\testFile1.py");

        String[] newLines = Indentation.fixTabs(oldLines);
        Headers.findHeaders(newLines);

        PrintCounter.findPrint(newLines);
        for (int i = 0; i < newLines.length; i++) {
            System.out.println((newLines[i]));
        }


       // Indentation.check(pythonParsed);//check indentation of Python file
        //Indentation.fix(pythonParsed)//Fixed indentation in python file
        //int counted = PrintCounter.count(pythonParsed);//Count how many times print is used(as a keyword)
       // OutputFormatter(pythonOrigional,pythonParsed,counter);
        //output origional input program, output program, and the number of times the keyword "print is used"

    }
}