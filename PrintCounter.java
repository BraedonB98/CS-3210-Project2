public class PrintCounter {

    static int printNum = 0;
    public static void findPrint(String[] pythonLines) {
        String parse;
        for(int i=0;i<pythonLines.length;i++) {
            parse = pythonLines[i].trim();

            if(parse.startsWith("print(") && parse.endsWith(")")) {
                printNum++;
            }
        }
    }
}