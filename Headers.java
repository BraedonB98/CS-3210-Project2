import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Headers {
    static String checker;

    public static void findHeaders(String[] pythonLines) {
        for(int i=0;i<pythonLines.length;i++) {
            checker = pythonLines[i].trim();
            if(checker.startsWith("def ")) {
               pythonLines[i] = fixHeaders(pythonLines[i]);
            }
        }    }

    public static String fixHeaders(String fixCode) {
        String fix = fixCode.replace("def ","");
        String regex = "[a-zA-Z0-9_]+\\(";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(fix);

        if(!matcher.find()) {
            fix = fix.replace("):","");
            fix = fix + "(";
        }

        regex = "\\([^()]*\\(";
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(fix);

        while(matcher.find()) {
            fix = fix.replace("\\([^()]*\\(", "\\([^()]*");
        }

        regex = "[^()]*\\([^()]*\\):";
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(fix);

        if(!matcher.find()) {
            fix = fix.replace(")", "");
            fix = fix.replace(":", "");

            while(fix.contains("((")){
                fix = fix.replace("((","(");
            }

            if(fix.contains("(")) {
                fix = fix + "):";
            }
            else {
                fix = fix + "():";
            }
        }
        fixCode = "def " + fix;
        return fixCode;
    }

    public static boolean parenCount(String fix){
        if(fix.contains("(")){

            return true;
        }

        return false;
    }

}