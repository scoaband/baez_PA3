
/*



    3. Program stores student response in a double precision floating-point variable

    4. Program uses floating-point comparison to determine if the students answer is correct

    9. Program shall display the number of correct and incorrect responses at the end of a session

    11. Program shall ask the user if they wish to begin a new session once the current session has terminated

    17. 5 is a mix of addition, subtraction, multiplication, and division.)
*/


import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;
public class baez_p1 {

    private static final int ADD = 1;
    private static final int SUB = 2;
    private static final int MULT = 3;
    private static final int DIV = 4;
    private static final int RANDTYPE = 5;

    private static int Lv = 0;

    private static int Reset(){
        int reset = 1;

        return reset;
    }

    private static int setLevel(int n){

        int Lv = n;

        return Lv;
    }

    private static void settings(){
        Scanner scan = new Scanner(System.in);
        int problemType = 0;
        int level = 0;

        System.out.println(" Welcome to Computer-Assisted Instruction (CAI)");
        do{
            System.out.println("1 = 1 digit, 2 = 2 digit, 3 = 3 digit, 4 = 4 digit\n");
            System.out.print(" Choose your Level 1 - 4: ");
            level = scan.nextInt();
            if (level >= 5 || level <= 0){
                System.out.println("Error number: " + level +", Levels are from 1 to 4, Try again!\n");
            }

        }while(level >= 5 || level <= 0);
        do{
            System.out.print(" 1 = Addition | 2 = Subtraction | 3 = Multiplication | 4 = Division | 5  = Random Type |\n" +
                    " Choose Problem Type: ");
            problemType = scan.nextInt();
            if (problemType >= 6 || problemType <= 0){
                System.out.println("Error number: " + problemType +", problem Type are from 1 to 5, Try again!\n");
            }

        }while(problemType >= 6 || problemType <= 0);

        System.out.print("______________________________________________________________________\n");


        Lv = setLevel(level);

        startApp(level, problemType, scan);
    }

    private static int  genRNum(){
        SecureRandom rand = new SecureRandom();
        int level = Lv;

        int seed = 0;
        switch (level){
            case 1:
                seed = 10;
                break;
            case 2:
                seed = 100;
                break;
            case 3:
                seed = 1000;
                break;
            case 4:
                seed = 10000;
                break;
        }

        int genRndNum = rand.nextInt(seed);

        return genRndNum;
    }

    public static double  genQuest(){

        return 0;
    }

    private static int problemType(int problemType){

        switch (problemType){
            case 1:
                problemType = ADD;
                break;
            case 2:
                problemType = SUB;
                break;
            case 3:
                problemType = MULT;
                break;
            case 4:
                problemType = DIV;
                break;
            default:
                problemType = RANDTYPE;
                break;
        }


        return problemType;
    }



    private static int genResponse(int correctAns, int answer){
        Random rand = new Random();
        int count;
        count = rand.nextInt(4);
        //Checking if the answer is right
        if (answer == correctAns) {

            System.out.print(" Right Answer, ");
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
            System.out.print("_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_");
        } else {

            System.out.print(" Wrong Answer, ");
            switch (count){
                case 0:
                    System.out.println(" Please try again.");
                    break;
                case 1:
                    System.out.println(" Try once more. ");
                    break;
                case 2:
                    System.out.println(" Don’t give up!");
                    break;
                case 3:
                    System.out.println(" Keep trying.");
                    break;
            }

            System.out.print("_._._._._._._._._._._._._._._._._._._._._._._._._._");
        }
        return answer;
    }

    private static void  startApp(int level, int problemType, Scanner scan){
        int x1 = 0;
        int x2 = 0;
        int reset = 0;
        int answer = 0;
        int correctAns = 0;
        int grade = 0;

        do{

            for (int i = 0; i < 10; ++i) {
                String proType = " ";
                x1 = genRNum();
                x2 = genRNum();

                System.out.print("\n| Level: " + setLevel(level) + "  |  Problem Type: " + problemType);
                System.out.print(" | ");

                System.out.print("Question " + (i + 1) + " / 10 " );

                switch (problemType) {
                    case 1:
                        proType = " plus";
                        correctAns = (x1 + x2);
                        break;
                    case 2:
                        proType = "minus";
                        correctAns = (x1 - x2);
                        break;
                    case 3:
                        proType = "times";
                        correctAns = (x1 * x2);
                        break;
                    case 4:
                        proType = "quotient";
                        if (x2 < 1 || x1 != x2) {
                            correctAns = (x2 / x1);
                        } else {
                            correctAns = (x1 / x2);
                        }
                        break;
                }

                System.out.println();
                System.out.print(" How much is " + x1 + " " + proType + " " + x2 + "?\n");
                System.out.print(" Your answer:  ");
                answer = scan.nextInt();
                genResponse(correctAns, answer);
                System.out.println();
                if (answer == correctAns){
                    ++grade;
                }

            }
            reset = Reset();
        }while(reset != 1);

        int newGrade = grade * 10;

        if (newGrade >= 75){

            System.out.println("\n Scoare: " +newGrade+ "%\n Congratulations, you are ready to go to the next level!");
        }else {
            System.out.println(" Please ask your teacher for extra help. \n");
        }
            System.out.print(" Press 1 to begin a new session: ");
        int newSession = scan.nextInt();
        switch (newSession){
            case 1:
                System.out.print("\n\n");
                settings();
                break;
            default:
                System.out.println("Good bye!");
        }

        scan.close();
    }

    public static void main(String[] args) {
        settings();

    }
}
