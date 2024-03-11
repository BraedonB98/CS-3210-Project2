import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            // Parse Python file into string array
            String filePath = "Resources\\testFile1.py";
            String[] oldLines = PythonParser.fileToStringArray(filePath);
            String[] newLines = oldLines.clone();

            // Fix indentation
            newLines = Indentation.fixTabs(newLines);

            // Fix headers
            Headers.findHeaders(newLines);

            // Count and replace print statements
            int numPrint = PrintCounter.findPrint(newLines);

            try {
                FileWriter writer = new FileWriter("Resources\\Output.txt");
                writer.write("Original Code:\n-----------------------\n");
                for (int i = 0; i < oldLines.length; i++) {
                    writer.write(oldLines[i]+"\n");
                }
                writer.write("\n-----------------------\nNew Code:\n-----------------------\n");
                for (int i = 0; i < newLines.length; i++) {
                    writer.write(newLines[i]+"\n");
                }
                writer.write("\n-----------------------\nTimes keyword “print” is used as keyword: " + numPrint);
                writer.flush();
                writer.close();
                System.out.println("Python code formatted and saved successfully!");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            // Print success message
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
