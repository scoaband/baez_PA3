import java.util.Random;
import java.util.Scanner;
public class baez_p1 {

    // Method SecureRandom Object
    public static int makeDigits(int counter) {
        Random rand = new Random();
        int ranNum1, ranNum2;
        // counter / 10 Question
        ++counter;

        //Generating randoms less than 10
        ranNum1 = rand.nextInt(10);
        ranNum2 = rand.nextInt(10);

        System.out.println("\n " + counter + " / 10 Questions \n");
        System.out.println(" How much is " + ranNum1 + " times " + ranNum2 + "?\t");

        return ranNum1 * ranNum2;
    }

    public static int grade(int gradePoint){
        gradePoint *= 10;
        gradePoint = 100 - gradePoint;
        return gradePoint;
    }

    public static int choice(int correctAns, int answer){
        Random rand = new Random();
        int count;
        count = rand.nextInt(4);
        //Checking if the answer is right
            if (answer == correctAns) {

                switch (count){
                    case 0:
                        System.out.println(" Very Good! ");
                        break;
                    case 1:
                        System.out.println(" Excellent! ");
                        break;
                    case 2:
                        System.out.println(" Nice work! ");
                        break;
                    case 3:
                        System.out.println(" Keep up the good work! ");
                        break;
                }
            } else {

                switch (count){
                    case 0:
                        System.out.println(" No. Please try again.");
                        break;
                    case 1:
                        System.out.println(" Wrong. Try once more. ");
                        break;
                    case 2:
                        System.out.println(" Don’t give up!");
                        break;
                    case 3:
                        System.out.println(" No. Keep trying.");
                        break;
                }

        }
        return answer;
    }

    public static void main(String[] args) {
        final int TEST_NUM = 10;
        int counter;
        for(int i = 0; i < TEST_NUM; ++i) {
            Scanner sc = new Scanner(System.in);
            // variable declaration
            int correctAns, answer;
            counter = i;
            correctAns = makeDigits(counter);

            //Asking for guess
            System.out.print(" Your answer:  ");
            answer = sc.nextInt();
            choice(correctAns, answer);
        }

        System.out.println("Score:");

    }

}
