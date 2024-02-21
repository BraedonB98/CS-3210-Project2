import Headers.java;
import Indentation.java;
import OutputFormatter.java;
import PrintCounter.java;
import PythonParser.java;

public class Analyzer { 
    public static void main(String[] args){
        String[] pythonParsed = PythonParse();//get parsed python file from PaythonParse File
        Indentation.check(pythonParsed);//check indentation of Python file
        Indentation.fix(pythonParsed)//Fixed indentation in python file
        Headers.check(pythonParsed);//check function headers syntax
        Headers.fix(pythonParsed);//fix function headers syntax
        int counted = PrintCounter.count(pythonParsed);//Count how many times print is used(as a keyword)
        OutputFormatter(pythonOrigional,pythonParsed,counter);//output origional input program, output program, and the number of times the keyword "print is used"

    }
}