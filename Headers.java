// Headers.fix(pythonParsed);
// fix function headers syntax

public class Headers {

    public static void findHeaders(String[] pythonLines) {
        for(int i=0;i< pythonLines.length;i++) {
            if(pythonLines[i].startsWith("def ")) {
               pythonLines[i] = fixHeaders(pythonLines[i]);
            }
        }
    }

    public static String fixHeaders(String fixCode) {
        if(!fixCode.endsWith("):")) {
                fixCode += "):";
        }
        if(!fixCode.endsWith("(\\([^()]*\\):)")) { //(num):           def getFnum():
                fixCode = fixCode.replace("):", "():");
        }
        return fixCode;
    }

}