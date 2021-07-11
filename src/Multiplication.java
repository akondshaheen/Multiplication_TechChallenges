import java.lang.reflect.Array;

public class Multiplication {

    /**
     * Multiply the given two number
     * @param number1 the First String
     * @param number2 the Second String
     * @return the result in the string format
     */
    public String Multiply(String number1, String number2) {
        int TempStoreResult[] = new int[number1.length() + number2.length()];

        TemporaryMultiplicationStorage(number1, number2, TempStoreResult);

        //From right of the storage ignore "0"s
        int i = TempStoreResult.length - 1;
        while (i >= 0 && TempStoreResult[i] == 0)
            i--;

        // if one or both are 0;
        if (i == -1)
            return "0";

        // genercharAte the result String
        String Result = "";

        while (i >= 0)
            Result += (TempStoreResult[i--]);

        return Result;
    }

    /**
     * Multiply each character from the given Strings
     * Store the result to a Temporary Vector in reverse order
     * @param number1 the First String
     * @param number2 the Second String
     * @param TempStoreResult Temporal Storage
     * @return
     */
    static String TemporaryMultiplicationStorage(String number1, String number2, int TempStoreResult[]) {

        //Initial check if any of either number is 0
        if (number1.length() == 0 || number2.length() == 0)
            return "0";

        int findPositionInResult1 = 0;
        int findPositionInResult2 = 0;

        for (int i = number1.length() - 1; i >= 0; i--) {
            int carry = 0;
            int activeCharacterNumber1 = number1.charAt(i) - '0';

            //navigate the position the begining
            findPositionInResult2 = 0;

            for (int j = number2.length() - 1; j >= 0; j--) {
                int activeCharacterNumber2 = number2.charAt(j) - '0';

                //sum of each execution
                int sum = activeCharacterNumber1 * activeCharacterNumber2 + TempStoreResult[findPositionInResult1 + findPositionInResult2] + carry;

                //Carry for the next iteration
                carry = sum / 10;

                //Store to the Temporal storage.
                TempStoreResult[findPositionInResult1 + findPositionInResult2] = sum % 10;

                findPositionInResult2++;
            }

            //If carry remain to the last iteration from number2 loop, push it to the storage
            if (carry > 0)
                TempStoreResult[findPositionInResult1 + findPositionInResult2] += carry;

            findPositionInResult1++;
        }
        return TempStoreResult.toString();
    }
}