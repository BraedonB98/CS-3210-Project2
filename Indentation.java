//Indentation.check(pythonParsed);
// check indentation of Python file
//Indentation.fix(pythonParsed)
// Fixed indentation in python file

import java.util.Stack;


//Assumes there is one statement per function/loop/branch

//NOTE: Ask about spacing & if we can anticipate divides between separate functions/commands, how to distinguish?
public class Indentation {
    public static String[] fixTabs(String[] stringArray) {
        int tabNumber = 0;
        for (int i = 0; i < stringArray.length; i++) {
            stringArray[i] = stringArray[i].trim(); //removes all spaces from front/back of string
            if (stringArray[i].isEmpty()) {
                tabNumber = 0;
                continue;
            }
            for (int j = 0; j < tabNumber; j++) {   //indents line of code for each previous indent
                stringArray[i] = ("\t" + stringArray[i]);
            }
            if (stringArray[i].charAt(stringArray[i].length() - 1) == ':') {    //If line ends with a colon, ensures following line indents.
                tabNumber++;
            }
            else if (tabNumber > 0) {  //If line doesn't end in colon, assumes this statement is only one under current indent. Returns tab to previous line.
                tabNumber--;
            }
        }
        return stringArray;
    }
}