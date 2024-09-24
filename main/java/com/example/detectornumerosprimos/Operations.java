package com.example.detectornumerosprimos;

public class Operations {
    /**
     * Makes the operation. It MUST have the form of an integer number, an operation sign, and another
     * integer number. I.E.: 89 + 22
     *
     * @param operation The full operation
     * @return The result of the operation
     * @throws Exception If something goes wrong
     */
    public static String doOperation (String operation) throws Exception{
        String ret = null;
        String firstNumber = "";
        String lastNumber = "";
        if (isAddition(operation)) {
            firstNumber = operation.substring( 0, operation.lastIndexOf( "+" ) );
            lastNumber = operation.substring( operation.lastIndexOf( "+" ) + 1 );
            ret = "" + add(new Integer(firstNumber.trim()).intValue(), new Integer(lastNumber.trim()).intValue());
        } else  if (isSubtraction(operation)) {
            firstNumber = operation.substring( 0, operation.lastIndexOf( "-" ) );
            lastNumber = operation.substring( operation.lastIndexOf( "-" ) + 1 );
            ret = "" + substract(new Integer(firstNumber.trim()).intValue(), new Integer(lastNumber.trim()).intValue());
        }
        return ret;
    }

    /**
     * Returns True if the operation is an addition. It is an addition if the operation has only one
     * "+" and zero "-"
     *
     * @param operation The String
     * @return The number of occurrences
     */
    private static boolean isAddition(String operation) {
        boolean ret = false;
        int countAdd = operation.length() - operation.replace("+", "").length();
        int countSubs = operation.length() - operation.replace("-", "").length();
        if ((countAdd == 1) && (countSubs == 0))
            ret = true;
        return ret;
    }

    /**
     * Returns True if the operation is a subtraction. It is an addition if the operation has only one
     * "-" and zero "+"
     *
     * @param operation The String
     * @return The number of occurrences
     */
    private static boolean isSubtraction(String operation) {
        boolean ret = false;
        int countAdd = operation.length() - operation.replace("-", "").length();
        int countSubs = operation.length() - operation.replace("+", "").length();
        if ((countAdd == 1) && (countSubs == 0))
            ret = true;
        return ret;
    }

    private static int add(int op1, int op2){
        return op1 + op2;
    }

    private static int substract(int op1, int op2){
        return op1 - op2;
    }
    public static boolean isPrimeNumber(int num) {
        if (num <= 1) return false; // Los números menores o iguales a 1 no son primos
        for (int i = 2; i <= Math.sqrt(num); i++) { // Solo hasta la raíz cuadrada
            if (num % i == 0) return false; // Si es divisible por algún número, no es primo
        }
        return true; // Si no tiene divisores, es primo
    }

}
