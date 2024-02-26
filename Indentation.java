//Indentation.check(pythonParsed);
// check indentation of Python file
//Indentation.fix(pythonParsed)
// Fixed indentation in python file
public class Indentation {
    //Parse for spaces & see if each line begins with 0 or multiple of 4 # of spaces
    //Returns String array w/ correct # of spaces.
    public String[] correctLength(String[] stringArray) {
        String addSpace = " ";

        for (int i = 0; i < stringArray.length; i++) {
            int lastSpaceIndex = 0;
            if (stringArray[i].charAt(0) == ' ') {
                while (stringArray[i].charAt(lastSpaceIndex) == ' ') {
                    lastSpaceIndex++;
                }
            }
            else {
                lastSpaceIndex = -1;
            }
            int numSpaces = lastSpaceIndex + 1;
            if ((numSpaces % 4) != 0) {
                for (int j = 0; j < (4-(numSpaces % 4)); j++) {
                    stringArray[i] = addSpace + stringArray[i];
                }
            }
        }
        return stringArray;
    }

}