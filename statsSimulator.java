import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class statsSimulator {
    public static double simulateGPA(Random random) {
        System.out.println("Simulating GPA...");
        double score1 = (Math.random() * 20 + 80);
        double score2 = (Math.random() * 20 + 80);

        return Math.round(Math.max(score1, score2) * 100.0) / 100.0;

    }

    Scanner input = new Scanner(System.in);

    public static int simulateSAT(Scanner input, Random random) {
        int SAT;
        do {
            System.out.print("Do you want to simulate an SAT score? (Yes / No): ");
            String simulateSAT = input.next();

            if (simulateSAT.equalsIgnoreCase("Yes")) {
                SAT = simulateScoreSAT(random);
                System.out.println();
                break;
            } else if (simulateSAT.equalsIgnoreCase("No")) {
                SAT = 0;  // Set SAT to 0 for no SAT score
                System.out.println();
                break;
            } else {
                System.out.println("Invalid input. Please enter Yes or No.");
            }
        } while (true);

        return SAT;
    }

    public static int simulateACT(Scanner input, Random random) {
        int ACT;
        do {
            System.out.print("Do you want to simulate an ACT score? (Yes / No): ");
            String simulateACT = input.next();

            if (simulateACT.equalsIgnoreCase("Yes")) {
                ACT = simulateScoreACT(random);
                System.out.println();
                break;
            } else if (simulateACT.equalsIgnoreCase("No")) {
                ACT = 0;  // Set ACT to 0 for no ACT score
                System.out.println();
                break;
            } else {
                System.out.println("Invalid input. Please enter Yes or No.");
            }
        } while (true);

        return ACT;
    }

    public static double simulateEssayStrength(Scanner input) {
        System.out.println("Simulating essay strength...");
        return Math.round((Math.max(Math.random() * 10.0, Math.random() * 10.0)) * 100.0) / 100.0;  // Simulate essay strength between 0.0 and 10.0
    }

    public static double simulateExtracurriculars(Scanner input) {
        System.out.println("Simulating extracurricular involvement...");
        return Math.round((Math.max(Math.random() * 10.0, Math.random() * 10.0) * 100.0) / 100.0);  // Simulate extracurricular involvement between 0.0 and 10.0
    }

    public static int simulateScoreACT(Random random) {
        System.out.println("Simulating ACT...");
        int score1 = (int) (Math.random() * 9 + 27);
        int score2 = (int) (Math.random() * 9 + 27);

        return Math.round(Math.max(score1, score2));
    }
    
    public static int simulateScoreSAT(Random random) {
        System.out.println("Simulating SAT...");
        int score1 = (int) (Math.random() * 600 + 1000);
        int score2 = (int) (Math.random() * 600 + 1000);

        return (int) Math.round(Math.max(score1, score2) / 10.0) * 10;
    }

    public static double simulateInterviewStrength(Random random) {
        return Math.round((Math.max(random.nextDouble() * 10.0, random.nextDouble() * 10.0)) * 100.0) / 100.0;  // Simulate interview strength between 0.0 and 10.0
    }

    public static double simulateRigor(Scanner input) {
        System.out.println("Simulating Course Rigor...");
        double v1 = Math.random() * 10;
        double v2 = Math.random() * 10;
        double maxSimulatedScore = Math.max(v1, v2);
        return Math.round(maxSimulatedScore * 100.0) / 100.0;
    }

    public static String simulateEthnicity(Scanner input) {
        System.out.println("Simulating ethnicity...");
        int num = (int) (Math.random() * 7);
        String[] races = {"White", "Black", "Hispanic", "Asian", "Native American", "Pacific Islander", "Mixed"};

        // Pick a random ethnicity
        String ethnicity = races[num];

        return ethnicity;
    }

    public static String simulateIncome(Scanner input) {
        int num = (int) (Math.random() * 5);
        System.out.println("Simulating income...");
        String[] incomes = {"Low Income", "Lower Middle Income", "Middle Income", "Upper Middle Income", "High Income"};

        // Pick a random income category
        String income = incomes[num];

        return income;
    }

    public static double demRating(String ethnicity, String income, boolean firstGen) {
        double num = 0;

        if (ethnicity.equals("White")) {
            num += (Math.random() * 2) - 1;
        }
        else if (ethnicity.equals("Asian")) {
            num += 0.5 + (Math.random() * 2) - 1;
        }
        else if (ethnicity.equals("Hispanic") || ethnicity.equals("Native American")) {
            num += 3  + (Math.random() * 2) - 1;
        }
        else if (ethnicity.equals("Pacific Islander")) {
            num += 4 + (Math.random() * 2) - 1;
        }
        else if (ethnicity.equals("Black")) {
            num += 5 + (Math.random() * 2) - 1;
        }
        else if (ethnicity.equals("Mixed")) {
            num += 3.6 + (Math.random() * 2) - 1;
        }

        if (income.equals("Low Income")) {
            num += 3 + (Math.random() * 2) - 1;
        }
        else if (income.equals("Lower Middle Income")) {
            num += 1.5 + (Math.random() * 2) - 1;
        }
        else if (income.equals("Middle Income")) {
            num += (Math.random() * 2) - 1;
        }
        else if (income.equals("Upper Middle Income")) {
            num += 1 + (Math.random() * 2) - 1;
        }
        else if (income.equals("High Income")) {
            num += 2.5 + (Math.random() * 2) - 1;
        }

        if (firstGen == true) {
            num += 2 + (Math.random() * 2) - 1;
        }
        else {
            num += (Math.random() * 2) - 1;
        }

        if (num <= 10) {
            return Math.round(num * 10.0) / 10.0;
        }
        else if (num < 0) {
            return 0.0;
        }
        else {
            return 10.0;
        }

    }

    public static boolean simulateFirstGen(Scanner input) {
        int num = (int) (Math.random() * 2);
        return num == 0;
    }

     public static ArrayList<Integer> recommendedColleges(double GPA, int SAT, int ACT, double essayStrength, double courseRigor, double extracurriculars, String ethnicity, String income, boolean firstGen) {
        // 3 safety
        // 3 target
        // 3 reach
        // 2 big reach
        // 2 large reach
        double num = collegeChances.getStudentNum(GPA, SAT, ACT, extracurriculars, courseRigor, essayStrength, 0.0) - 15;
        ArrayList<Integer> colleges = new ArrayList<Integer>();
        Random rand = new Random();

        if (num > 85) { // tier 1 students
            for (int i = 0; i < 3; i++) {
                colleges.add(rand.nextInt(15, 35));
            }
            for (int i = 0; i < 3; i++) {
                colleges.add(rand.nextInt(8, 20));
            }
            for (int i = 0; i < 3; i++) {
                colleges.add(rand.nextInt(5, 15));
            }
            for (int i = 0; i < 2; i++) {
                colleges.add(rand.nextInt(3, 10));
            }
            for (int i = 0; i < 2; i++) {
                colleges.add(rand.nextInt(1, 5));
            }
        }
        else if (num > 78) {
            for (int i = 0; i < 3; i++) {
                colleges.add(rand.nextInt(20, 40));
            }
            for (int i = 0; i < 3; i++) {
                colleges.add(rand.nextInt(10, 25));
            }
            for (int i = 0; i < 3; i++) {
                colleges.add(rand.nextInt(8, 18));
            }
            for (int i = 0; i < 2; i++) {
                colleges.add(rand.nextInt(5, 13));
            }
            for (int i = 0; i < 2; i++) {
                colleges.add(rand.nextInt(1, 7));
            }
        }
        else if (num > 70) {
            for (int i = 0; i < 3; i++) {
                colleges.add(rand.nextInt(25, 45));
            }
            for (int i = 0; i < 3; i++) {
                colleges.add(rand.nextInt(20, 25));
            }
            for (int i = 0; i < 3; i++) {
                colleges.add(rand.nextInt(15, 20));
            }
            for (int i = 0; i < 2; i++) {
                colleges.add(rand.nextInt(10, 15));
            }
            for (int i = 0; i < 2; i++) {
                colleges.add(rand.nextInt(3, 10));
            }
        }
        else if (num > 62) {
            for (int i = 0; i < 3; i++) {
                colleges.add(rand.nextInt(30, 50));
            }
            for (int i = 0; i < 3; i++) {
                colleges.add(rand.nextInt(25, 45));
            }
            for (int i = 0; i < 3; i++) {
                colleges.add(rand.nextInt(15, 20));
            }
            for (int i = 0; i < 2; i++) {
                colleges.add(rand.nextInt(10, 15));
            }
            for (int i = 0; i < 2; i++) {
                colleges.add(rand.nextInt(3, 10));
            }
        }
        else if (num > 53) {
            for (int i = 0; i < 3; i++) {
                colleges.add(rand.nextInt(35, 55));
            }
            for (int i = 0; i < 3; i++) {
                colleges.add(rand.nextInt(25, 45));
            }
            for (int i = 0; i < 3; i++) {
                colleges.add(rand.nextInt(20, 35));
            }
            for (int i = 0; i < 2; i++) {
                colleges.add(rand.nextInt(15, 20));
            }
            for (int i = 0; i < 2; i++) {
                colleges.add(rand.nextInt(7, 20));
            }
        }
        else if (num > 45) {
            for (int i = 0; i < 3; i++) {
                colleges.add(rand.nextInt(40, 70));
            }
            for (int i = 0; i < 3; i++) {
                colleges.add(rand.nextInt(30, 48));
            }
            for (int i = 0; i < 3; i++) {
                colleges.add(rand.nextInt(24, 38));
            }
            for (int i = 0; i < 2; i++) {
                colleges.add(rand.nextInt(20, 30));
            }
            for (int i = 0; i < 2; i++) {
                colleges.add(rand.nextInt(10, 24));
            }
        }
        else if (num > 37) {
            for (int i = 0; i < 3; i++) {
                colleges.add(rand.nextInt(55, 85));
            }
            for (int i = 0; i < 3; i++) {
                colleges.add(rand.nextInt(45, 62));
            }
            for (int i = 0; i < 3; i++) {
                colleges.add(rand.nextInt(30, 52));
            }
            for (int i = 0; i < 2; i++) {
                colleges.add(rand.nextInt(25, 38));
            }
            for (int i = 0; i < 2; i++) {
                colleges.add(rand.nextInt(14, 30));
            }
        }
        else if (num > 29) {
            for (int i = 0; i < 3; i++) {
                colleges.add(rand.nextInt(65, 90));
            }
            for (int i = 0; i < 3; i++) {
                colleges.add(rand.nextInt(60, 80));
            }
            for (int i = 0; i < 3; i++) {
                colleges.add(rand.nextInt(50, 60));
            }
            for (int i = 0; i < 2; i++) {
                colleges.add(rand.nextInt(40, 50));
            }
            for (int i = 0; i < 2; i++) {
                colleges.add(rand.nextInt(20, 40));
            }
        }
        else {
            for (int i = 0; i < 3; i++) {
                colleges.add(rand.nextInt(70, 98));
            }
            for (int i = 0; i < 3; i++) {
                colleges.add(rand.nextInt(65, 85));
            }
            for (int i = 0; i < 3; i++) {
                colleges.add(rand.nextInt(55, 65));
            }
            for (int i = 0; i < 2; i++) {
                colleges.add(rand.nextInt(45, 55));
            }
            for (int i = 0; i < 2; i++) {
                colleges.add(rand.nextInt(25, 45));
            }
        }
        return fixDuplicates(colleges);
    }

    public static ArrayList<Integer> fixDuplicates(ArrayList<Integer> colleges) {
        // Create a new ArrayList to store unique colleges in order
        ArrayList<Integer> uniqueColleges = new ArrayList<>();
        
        // Iterate through the original list and add unique colleges to the new list
        for (Integer college : colleges) {
            if (!uniqueColleges.contains(college)) {
                uniqueColleges.add(college);
            }
        }
        
        // Return the new list containing unique colleges
        return uniqueColleges;
    }

    public static String convertEthnicity(String ethnicityN) {
        switch (ethnicityN) {
            case "1":
                return "White";
            case "2":
                return "Black";
            case "3":
                return "Hispanic";
            case "4":
                return "Asian";
            case "5":
                return "Native American";
            case "6":
                return "Pacific Islander";
            case "7":
                return "Mixed";
            default:
                System.out.println("Invalid input for ethnicity.");
                // Handle invalid input (you can choose to exit, ask again, etc.)
                return null;
        }
    }
    
    public static String convertIncomeLevel(String incomeN) {
        switch (incomeN) {
            case "1":
                return "Low Income";
            case "2":
                return "Lower Middle Income";
            case "3":
                return "Middle Income";
            case "4":
                return "Upper Middle Income";
            case "5":
                return "High Income";
            default:
                System.out.println("Invalid input for income level.");
                // Handle invalid input (you can choose to exit, ask again, etc.)
                return null;
        }
    }
}