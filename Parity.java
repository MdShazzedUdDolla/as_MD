import java.util.Scanner;

public class Parity
{
    public static void main (String [] args)
    {

        //  variables
        String msg, msgWithEvenParity, msgWithOddParity;
        Scanner kbd = new Scanner(System.in);

        // Input the message (sting containg only zeros and ones)
        System.out.print("Message (0s and 1s)? ");
        msg = kbd.nextLine();

        //------------------------------------------------------------
        // Count the number of ones in the message 
        //------------------------------------------------------------

        int onesCount = 0;    
        // Walk through msg char by char counting the number of 1s
        int index = 0;
        while (index < msg.length())
        {
            if (msg.charAt(index) == '1')
                onesCount++;
            index++;
        }

        // Set the parity bit based on the # of 1's in the message
        if (onesCount % 2 == 0)
        {
            msgWithEvenParity = msg + "0";  // add a 0 to keep even
            msgWithOddParity = msg + "1";   // add a 1 to make odd
        }
        else
        {
            msgWithEvenParity = msg + "1"; // add a 1 to make even
            msgWithOddParity = msg + "0";  // add a 0 to keep odd
        }

        // send the message including the parity bit    
        System.out.println("\nOriginal message:         [" + msg + "]");
        System.out.println("Message with even parity: [" + msgWithEvenParity + "]");
        System.out.println("Message with odd parity:  [" + msgWithOddParity + "]");
    }      

}
