import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            // Parse Python file into string array
            String filePath = "C:\\Users\\bryan\\Desktop\\Spring 2024 Semester\\Principles of Prog. Language M-W\\Project 2 final testing\\CS-3210-Project2\\TestFiles\\TestPython.py";
            String[] pythonLines = PythonParser.fileToStringArray(filePath);

            // Fix indentation
            pythonLines = Indentation.fixTabs(pythonLines);

            // Fix headers
            Headers.findHeaders(pythonLines);

            // Count and replace print statements
            PrintCounter.findPrint(pythonLines);

            // Prepare output
            OutputFormatter formatter = new OutputFormatter(pythonLines, pythonLines, PrintCounter.printNum);
            formatter.saveOutput("output_file.py");

            // Print success message
            System.out.println("Python code formatted and saved successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
