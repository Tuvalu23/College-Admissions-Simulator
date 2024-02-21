import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class statsSimulator {
    public static double simulateGPA(Random random) {
        return simulateScoreGPA(100.0, random);  // Simulate GPA between 0.00 and 100.00
    }

    Scanner input = new Scanner(System.in);

    public static int simulateSAT(Scanner input, Random random) {
        int SAT;
        do {
            System.out.print("Do you want to simulate an SAT score? (Yes / No): ");
            String simulateSAT = input.next();
            System.out.println();

            if (simulateSAT.equalsIgnoreCase("Yes")) {
                SAT = Math.max((random.nextInt(81) + 80) * 10, (random.nextInt(81) + 80) * 10);  // Simulate SAT score between 400 and 1600 in increments of 10
                break;
            } else if (simulateSAT.equalsIgnoreCase("No")) {
                SAT = 0;  // Set SAT to 0 for no SAT score
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
            System.out.println();

            if (simulateACT.equalsIgnoreCase("Yes")) {
                ACT = Math.max(random.nextInt(16) + 20, random.nextInt(16) + 20);  // Simulate ACT score between 1 and 36
                break;
            } else if (simulateACT.equalsIgnoreCase("No")) {
                ACT = 0;  // Set ACT to 0 for no ACT score
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

    public static int simulateScoreSAT(int SAT, Random random) {
        int minRange = Math.max(400, SAT - random.nextInt(100));
        int maxRange = Math.min(1600, SAT + random.nextInt(100));
    
        int simulatedScore = (int) Math.round((random.nextDouble() * (maxRange - minRange) + minRange) / 10) * 10;
        return simulatedScore;
    }
    
    public static int simulateScoreACT(int ACT, Random random) {
        int minRange = Math.max(1, ACT - random.nextInt(5));
        int maxRange = Math.min(36, ACT + random.nextInt(5));
    
        int simulatedScore = Math.max(minRange, random.nextInt(maxRange - minRange + 1) + minRange);
        return simulatedScore;
    }

    public static double simulateInterviewStrength(Random random) {
        return Math.round((Math.max(random.nextDouble() * 10.0, random.nextDouble() * 10.0)) * 100.0) / 100.0;  // Simulate interview strength between 0.0 and 10.0
    }
    
    public static double simulateScoreGPA(double GPA, Random random) {
        double minRange1 = Math.max(0.0, GPA - random.nextDouble() * 20.0);  // Adjusted range for 0-100
        double maxRange1 = Math.min(100.0, minRange1 + random.nextDouble() * 20.0);  // Adjusted range for 0-100
    
        double minRange2 = Math.max(0.0, GPA - random.nextDouble() * 20.0);  // Adjusted range for 0-100
        double maxRange2 = Math.min(100.0, minRange2 + random.nextDouble() * 20.0);  // Adjusted range for 0-100
    
        double simulatedScore1 = Math.min(maxRange1, Math.round(random.nextDouble() * (maxRange1 - minRange1) + minRange1 * 100.0) / 100.0);
        double simulatedScore2 = Math.min(maxRange2, Math.round(random.nextDouble() * (maxRange2 - minRange2) + minRange2 * 100.0) / 100.0);
    
        // Simulate twice and find the maximum
        double maxSimulatedScore = Math.max(simulatedScore1, simulatedScore2);
    
        return Math.round(maxSimulatedScore * 100.0) / 100.0;  // Round to two decimal places
    }

    public static double simulateRigor(Scanner input) {
        double v1 = Math.random() * 10;
        double v2 = Math.random() * 10;
        double maxSimulatedScore = Math.max(v1, v2);
        return Math.round(maxSimulatedScore * 100.0) / 100.0;
    }

     public static ArrayList<Integer> recommendedColleges(double GPA, int SAT, int ACT, double essayStrength, double courseRigor, double extracurriculars) {
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
    
    
    
}