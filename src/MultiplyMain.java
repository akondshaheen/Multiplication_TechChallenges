public class MultiplyMain {
    // Driver code
    public static void main(String[] args) {
        String number1 = "3984598436594836587346589743658734965";
        String number2 = "9849863874892727638726532323";


        //implementing the program to work against signed integers
        if ((number1.charAt(0) == '-' || number2.charAt(0) == '-') &&
                (number1.charAt(0) != '-' || number2.charAt(0) != '-'))
            System.out.print("-");

        if (number1.charAt(0) == '-') {
            number1 = number1.substring(1);
        }
        if (number2.charAt(0) == '-') {
            number2 = number2.substring(1);
        }
        Multiplication multiplication = new Multiplication();
        System.out.println(multiplication.Multiply(number1, number2));

    }
}

