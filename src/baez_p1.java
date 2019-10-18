
    import java.security.SecureRandom;
    import java.util.Random;
    import java.util.Scanner;
    import java.lang.Math;

public class baez_p1 {
    // Reset
    private static final String RESET = "\033[0m";  // Text Reset

    // Regular Colors
    public static final String BLACK = "\033[0;30m";   // BLACK
    private static final String RED = "\033[0;31m";    // RED
    public static final String GREEN = "\033[0;32m";   // GREEN
    public static final String YELLOW = "\033[0;33m";  // YELLOW
    private static final String BLUE = "\033[0;34m";   // BLUE
    private static final String PURPLE = "\033[0;35m"; // PURPLE
    private static final String CYAN = "\033[0;36m";   // CYAN
    public static final String WHITE = "\033[0;37m";   // WHITE
    private int level;

    private baez_p1() {
        Scanner scan = new Scanner(System.in);
        int probType;
        int level;

        System.out.println(CYAN + "\n Welcome to Computer-Assisted Instruction (CAI)" + RESET);
        do {

            System.out.println(
                    "| 1 = 1 digit\n| 2 = 2 digit\n| 3 = 3 digit\n| 4 = 4 digit");
            System.out.print(PURPLE +" Choose difficulty  Level 1 - 4: " + RESET);

            // Taking level
             level = scan.nextInt();
            if(level >= 5 || level <= 0)
            {
                System.out.println(RED + "Error number: " + level
                        + RESET + ", Levels are from 1 to 4, Try again!\n");
            }

            // Set Level
            this.level = level;
        }
        while(level >= 5 || level <= 0);
        do {
            System.out.print("| 1 = Addition \n| 2 = Subtraction \n" +
                            "| 3 = Multiplication \n| 4 = Division \n"
                            + "| 5  = Random Type \n"
                            + PURPLE+"| Choose Problem Type: " + RESET);

            // Taking problem type
            probType = scan.nextInt();
            if(probType >= 6 || probType <= 0)
            {
                System.out.println(RED + "Error number: " + probType
                        + RESET + ", problem Type are from 1 to 5, Try again!\n");
            }

        }
        while(probType >= 6 || probType <= 0);

        System.out.print("______________________________________________________________________\n");

        // Set problem type
        String pT = problemType(probType);
        commence(pT, scan);
    }

    // Reset Method
    private int Reset(){
        return 1;
    }


    // Round double precision point
    private double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    private int getRanNum() {
        SecureRandom rand = new SecureRandom();
        return rand.nextInt(4);
    }

    private double genRNum() {
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

    private void genQuest(double n1, double n2, String pt){

        System.out.printf(" How much is  %.0f  %s  %.0f ?\n", n1, pt , n2);
    }

    private String problemType(int n)
    {

        String PrTy = " ";

        switch(n)
        {
            case 1:
                // Add
                PrTy = "0";
                break;
            case 2:
                // Sub
                PrTy = "1";
                break;
            case 3:
                // Mult
                PrTy = "2";
                break;
            case 4:
                // Div
                PrTy = "3";
                break;
            case 5:
                // Random
                PrTy = "4";
                break;
        }
        return PrTy;
    }

    private void genResponse(double collectedAnswer, double userAnswer)
    {
        Random rand = new Random();
        int count;
        count = rand.nextInt(4);

        if(userAnswer == collectedAnswer)
        {

            System.out.print(BLUE + " Right Answer " + RESET + ", ");
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

            System.out.print(RED + " Wrong Answer" + RESET + ", ");

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
            System.out.print("_._._._._._._._._._._._._" +
                    "._._._._._._._._._._._._._");
        }
    }


    private void commence(String pt, Scanner scan) {

        int reset;
        double x1, x2;
        int x3;
        double answer;
        double correctAns = 0;
        int grade = 0;
        int add = 0 , sub = 0, mult = 0, div = 0;

        do {
            for(int i = 0; i < 10; ++i) {

                // Math Type
                String proType = ":)";
                String PT = pt;

                // Gen xNumbers
                x1 = genRNum();
                x2 = genRNum();
                x3 = getRanNum();

                    if(PT == "4"){
                        PT = String.valueOf(x3);
                        if(add >= 3){
                            PT = "1";
                        }
                        if (sub >= 3){
                            PT = "2";
                        }
                        if (mult >= 2){
                            PT = "3";
                        }
                        if(div >= 2){
                            PT = "0";
                        }

                        System.out.println("test " + x3);
                    }


                switch(PT) {
                    case "0":
                        proType = "+";
                        correctAns = (x1 + x2);
                        ++add;
                        break;
                    case "1":
                        proType = "-";
                        correctAns = (x1 - x2);
                        ++sub;
                        break;
                    case "2":
                        proType = "*";
                        correctAns = (x1 * x2);
                        ++mult;
                        break;
                    case "3":
                        do {
                            x2 = genRNum();
                        }while ((x2 < 0));
                        proType = "/";
                        correctAns = (x1 / x2);
                        ++div;
                        break;
                    default:
                        break;
                }


                // Bar Level, Problem type, and Question count
                System.out.print("\n| Level: " + this.level + "  |  Problem Type: " + pt);
                System.out.print(" | " + "Question " + (i + 1) + " / 10 ");
                System.out.println();

                // Generate question genQuest
                genQuest(x1, x2, proType);

                // testing
                // System.out.println(round(correctAns,2));
                // Taking Answer
                System.out.print(" Your answer:  ");
                answer = scan.nextDouble();
                round(answer, 2);
                // Compare Correct and Answer
                genResponse(round(correctAns,2), answer);
                System.out.println();
                if(answer == correctAns) {
                    ++grade;
                }

            }

            // reset
            reset = Reset();
        }while(reset != 1);

        // set Score points
        int newGrade = grade * 10;

        System.out.println("\n Correct Answers: " + grade + "   Incorrect Answer: " + Math.abs(grade - 10));
        if(newGrade >= 75) {

            System.out.println("\n SCORE: " + newGrade + "%\n"
                    + " Congratulations, you are ready to go to the next level!");
        }
        else {
            // print get score
            System.out.println("\n Score: " + newGrade + "%\n"
                    + " Please ask your teacher for extra help. \n");
        }
        System.out.printf(" Data= add: %d sub: %d mult: %d Div: %d ", add, sub, mult, div);
        System.out.print(RED + "\n Press 1 to begin a new session: " + RESET);
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

    public static void main(String[] args) {

        baez_p1 app = new baez_p1();
    }
}
