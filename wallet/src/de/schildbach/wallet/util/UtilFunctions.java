package de.schildbach.wallet.util;

import android.util.Log;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by kaushikg on 30-01-2018.
 */

/*Created to put common Util functions and use it globally in a whole app*/

public class UtilFunctions {

        public static boolean checkPasswordStrength(String pw){
                    // .*[A-Za-z].*   check for the presence of at least one letter
                    // .*[0-9].*      check for the presence of at least one number
                    // [A-Za-z0-9]*   check that only numbers and letters compose this string
            String text = pw;
            //if (text.matches(".*[A-Za-z].*") && text.matches(".*[0-9].*") && text.matches("[A-Za-z0-9]*")) {
            if (text.matches(".*[A-Z].*") &&text.matches(".*[a-z].*") &&
                    text.matches(".*[0-9].*") && text.matches("[A-Za-z0-9]*")) {
                Log.i("checkPasswordStrength","Its Alphanumeric");
                return true;
            } else {
                Log.i("checkPasswordStrength","Its NOT Alphanumeric");
                return false;
            }

        }

    public static   boolean getSpecialCharacterCount(String s) {
            boolean returnval = false;

        if (s == null || s.trim().isEmpty()) {
            return false;
        }
        int theCount = 0;

        try {

            Pattern p = Pattern.compile("[^A-Za-z0-9]");
            Matcher m = p.matcher(s);
            // boolean b = m.matches();
            boolean b = m.find();
            returnval = b;
            Log.i("getSpecialChar", "m.find()= " + m.find());
            if (b == true) {
                System.out.println("There is a special character in my string ");
                Log.i("getSpecialChar", "There is a special character in my string " + theCount);
                returnval = true;
            }
            else {
                System.out.println("There is no special char.");
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            Log.i("getSpecialChar", "Exception= "+ e);
        }

        return returnval;
    }

        //To make proper text address and remove unusual text
    public static String addresstextOptimization(String text){
            String returntext = text;
        if(returntext.contains("bitcoin:")){
            //Remove text "bitcoin:" in copying aaddress
            returntext = returntext.replace("bitcoin:","");
        }
        if(returntext.contains("?")){
            returntext =    returntext.substring(0,returntext.indexOf("?"));
        }
            return returntext;
    }


    public static int passwordmatches(String pw){
        if (pw == null || pw.trim().isEmpty()) {
            return 0;
        }
        String text = pw;
        int returnval = 0;

        if (text.matches(".*[A-Z].*")){
            returnval++;
        }
        if (text.matches(".*[a-z].*")){
            returnval++;
        }
        if ( text.matches(".*[0-9].*")){
            returnval++;
        }
        if(getSpecialCharacterCount(text)){
            returnval++;
        }
         return returnval;
     }


}
