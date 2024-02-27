// OutputFormatter(pythonParsed);
// output origional input program, output program, and the number of times the keyword "print is used"
import java.io.BufferedReader; //These are needed for reading the python file
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class OutputFormatter {
    String[] origionalProgram;
    String[] outputProgram;
    int printUsed;
    String origionalFileName = "";
    String fileName = "testfile.py";

    //Reads through file line by line to get # of lines
    public OutputFormatter(String[] origionalProgram, String[] outputProgram, int printUsed)
    {
        this.origionalProgram = origionalProgram;
        this.outputProgram = outputProgram;
        this.printUsed = printUsed;
    }
    public OutputFormatter()
    {

    }
    public void printOutput(){

    }
    public String saveOutput(){
        String fileName = "testfile.py";
        //need to add a part where it checks if there are string arays due to instatiation of output formatter without inputs
        try{
            PrintWriter newFileWriter = new PrintWriter(fileName);
            for(String i : origionalProgram)
            {
               newFileWriter.println(i);
            }
            newFileWriter.println("\r\n");
            for(String i : outputProgram){
                newFileWriter.println(i);
            }
            newFileWriter.println("\r\n");
            newFileWriter.println("Keyword \"print\" was used : " + printUsed + " Times");
            newFileWriter.close();
        }
        catch(IOException error){
            error.printStackTrace();
        }
        return(fileName);
    }

}