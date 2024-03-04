//PrintCounter.count(pythonParsed);//Count how many times print is used(as a keyword)
//Return number of times print is used
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PrintCounter {
    static int printNum = 0;
    public static void findPrint(String[] pythonLines) {
        for(int i=0;i<PythonParser.numLines;i++) {

            if(pythonLines[i].startsWith("print(")) {
                pythonLines[i] = countPrint(pythonLines[i]);
            }
        }
    }

    public static String countPrint(String fixCode) {
        String regex = "print\\([^()]*\\)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(fixCode);
        if(!matcher.find()) {
            printNum++;
            return fixCode;
        }
        return fixCode;
    }

}