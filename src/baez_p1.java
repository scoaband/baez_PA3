/*
    3. Program stores student response in a double precision floating-point variable
    4. Program uses floating-point comparison to determine if the students answer is correct
    9. Program shall display the number of correct and incorrect responses at the end of a session
    17. choose 5 is a mix of addition, subtraction, multiplication, and division.)
*/

import java.security.SecureRandom;
        import java.util.Random;
        import java.util.Scanner;

public class baez_p1
{
    private int level;

    private baez_p1()
    {
        Scanner scan = new Scanner(System.in);
        int probType;
        int level;

        System.out.println(" Welcome to Computer-Assisted Instruction (CAI)");
        do
        {

            System.out.println(
                    "| 1 = 1 digit\n| 2 = 2 digit\n| 3 = 3 digit\n| 4 = 4 digit");
            System.out.print(" Choose difficulty  Level 1 - 4: ");

            level = scan.nextInt();
            if(level >= 5 || level <= 0)
            {
                System.out.println("Error number: " + level
                        + ", Levels are from 1 to 4, Try again!\n");
            }

        }
        while(level >= 5 || level <= 0);
        do
        {
            System.out
                    .print("| 1 = Addition \n| 2 = Subtraction \n| 3 = Multiplication \n| 4 = Division \n"
                            + "| 5  = Random Type \n"
                            + "| Choose Problem Type: ");
            probType = scan.nextInt();
            if(probType >= 6 || probType <= 0)
            {
                System.out.println("Error number: " + probType
                        + ", problem Type are from 1 to 5, Try again!\n");
            }

        }
        while(probType >= 6 || probType <= 0);

        System.out
                .print("______________________________________________________________________\n");
        String ant = problemType(probType);

        startApp(level, ant, scan);
    }

    private void startApp(int level, String maths, Scanner scan) {
        this.level = level;

        int x1;
        int x2;
        int reset;
        int answer;
        int correctAns = 0;
        int grade = 0;

        do {
            for(int i = 0; i < 10; ++i) {
                String proType = ":)";
                x1 = genRNum();
                x2 = genRNum();

                switch(maths) {

                    case "Random":
                        int x3 = getRanNum(3);
                        System.out.println(x3);
                        switch(x3) {
                            case 0:
                                proType = "+";
                                correctAns = (x1 + x2);
                                break;
                            case 1:
                                proType = "-";
                                correctAns = (x1 - x2);
                                break;
                            case 2:
                                proType = "*";
                                correctAns = (x1 * x2);
                                break;
                            case 3:
                                proType = "/";
                                if(x2 < 1 || x1 != x2) {
                                    correctAns = (x2 / x1);
                                }
                                else {
                                    correctAns = (x1 / x2);
                                }
                                break;
                        }
                        break;
                    case "ADD":
                        proType = "+";
                        correctAns = (x1 + x2);
                        break;
                    case "SUB":
                        proType = "-";
                        correctAns = (x1 - x2);
                        break;
                    case "MULT":
                        proType = "*";
                        correctAns = (x1 * x2);
                        break;
                    case "DIV":
                        proType = "/";
                        if(x2 < 1 || x1 != x2) {
                            correctAns = (x2 / x1);
                        }
                        else {
                            correctAns = (x1 / x2);
                        }
                        break;
                    default:
                        break;
                }

                System.out.print("\n| Level: " + level + "  |  Problem Type: "
                        + maths);
                System.out.print(" | ");

                System.out.print("Question " + (i + 1) + " / 10 ");

                System.out.println();
                genQuest(x1, x2, proType);
                System.out.print(" Your answer:  ");
                answer = scan.nextInt();
                genResponse(correctAns, answer);
                System.out.println();
                if(answer == correctAns) {
                    ++grade;
                }

            }
            reset = Reset();
        }
        while(reset != 1);

        int newGrade = grade * 10;

        if(newGrade >= 75) {

            System.out.println("\n Score: " + newGrade + "%\n"
                    + " Congratulations, you are ready to go to the next level!");
        }
        else {
            System.out.println(" Please ask your teacher for extra help. \n");
        }
        System.out.print(" Press 1 to begin a new session: ");
        int newSession = scan.nextInt();
        if(newSession == 1) {
            System.out.print("\n\n");
            new baez_p1();
        }
        else {
            System.out.println("Good bye!");
        }

        scan.close();
    }

    private int Reset() {

        return 1;
    }

    private int getRanNum(int n) {
        SecureRandom rand = new SecureRandom();
        return rand.nextInt(n);
    }

    private int genRNum() {
        SecureRandom rand = new SecureRandom();
        int seed = 0;
        switch(this.level)
        {
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

        return rand.nextInt(seed);
    }

    private void genQuest(int n1, int n2, String pt)
    {

        System.out.print(" How much is " + n1 + " " + pt + " " + n2 + "?\n");
    }

    private String problemType(int n)
    {

        String PrTy = " ";

        switch(n)
        {
            case 1:
                PrTy = "ADD";
                break;
            case 2:
                PrTy = "SUB";
                break;
            case 3:
                PrTy = "MULT";
                break;
            case 4:
                PrTy = "DIV";
                break;
            case 5:
                PrTy = "RANDTYPE";
                break;
        }
        return PrTy;
    }

    private void genResponse(int correctAns, int answer)
    {
        Random rand = new Random();
        int count;
        count = rand.nextInt(4);
        //Checking if the answer is right
        if(answer == correctAns)
        {

            System.out.print(" Right Answer, ");
            switch(count)
            {
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
            System.out
                    .print("_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_");
        }
        else
        {

            System.out.print(" Wrong Answer, ");
            switch(count)
            {
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

            System.out
                    .print("_._._._._._._._._._._._._._._._._._._._._._._._._._");
        }
    }

    public static void main(String[] args)
    {
        baez_p1 app = new baez_p1();
    }
}
