import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CollegeSimulator {
private static List<String> collegeList = Arrays.asList(
    "Harvard University",
    "Massachusetts Institute of Technology (MIT)",
    "Stanford University",
    "Yale University",
    "Princeton University",
    "Duke University",
    "Columbia University",
    "University of Pennsylvania (UPenn)",
    "Northwestern University",
    "Dartmouth College",
    "Brown University",
    "Vanderbilt University",
    "Cornell University",
    "University of Chicago (UChicago)",
    "Rice University",
    "California Institute of Technology (Caltech)",
    "Washington University in St. Louis (WashU)",
    "Johns Hopkins University (JHU)",
    "University of California, Los Angeles (UCLA)",
    "University of Southern California (USC)",
    "University of Michigan",
    "Georgetown University",
    "University of Notre Dame",
    "University of California, Berkeley",
    "Emory University",
    "Carnegie Mellon University (CMU)",
    "Tufts University",
    "University of North Carolina at Chapel Hill (UNC Chapel Hill)",
    "Northeastern University",
    "University of Virginia (UVA)",
    "University of Florida (UFlorida)",
    "Georgia Institute of Technology (Georgia Tech)",
    "New York University (NYU)",
    "University of California, Davis (UCD)",
    "University of California, San Diego (UCSD)",
    "University of Illinois Urbana-Champaign (UIUC)",
    "Boston College (BC)",
    "University of Texas at Austin (UT Austin)",
    "Wake Forest University",
    "University of California, Santa Barbara (UCSB)",
    "Boston University (BU)",
    "College of William & Mary (W&M)",
    "University of Wisconsin-Madison (UW Madison)",
    "University of Washington, Seattle (UW Seattle)",
    "Purdue University",
    "University of Rochester",
    "Lehigh University",
    "University of California, Irvine (UCI)",
    "University of Miami",
    "Texas A&M University",
    "Case Western Reserve University",
    "University of Maryland (UMD)",
    "Santa Clara University (SCU)",
    "Tulane University",
    "George Washington University (GW)",
    "University of Georgia (UGA)",
    "Virginia Tech",
    "University of Minnesota Twin Cities (UM Twin Cities)",
    "Ohio State University (OSU)",
    "Villanova University",
    "Rensselaer Polytechnic Institute (RPI)",
    "Southern Methodist University (SMU)",
    "North Carolina State University (NCSU)",
    "Brigham Young University (BYU)",
    "Michigan State University (MSU)",
    "Indiana University Bloomington (IU Bloomington)",
    "University of Connecticut (UConn)",
    "Brandeis University",
    "Florida State University (FSU)",
    "University of Pittsburgh (Pitt)",
    "Loyola Marymount University",
    "Worcester Polytechnic Institute (WPI)",
    "Pennsylvania State University (PSU)",
    "Pepperdine University",
    "Syracuse University",
    "Clemson University",
    "University of Utah (UUtah)",
    "University of Massachusetts Amherst (UMass Amherst)",
    "University of Delaware (UDelaware)",
    "State University of New York at Binghamton (SUNY Binghamton)",
    "University of San Diego (USD)",
    "State University of New York at Buffalo (SUNY Buffalo)",
    "University of Iowa (UIowa)",
    "Saint Louis University (SLU)",
    "Yeshiva University",
    "University of Arizona",
    "Texas Christian University (TCU)",
    "American University",
    "Stevens Institute of Technology",
    "Rutgers University",
    "Drexel University",
    "State University of New York at Stony Brook (SUNY Stony Brook)",
    "University of Denver",
    "Marquette University",
    "Baylor University",
    "Colorado School of Mines",
    "University of Colorado Boulder (UC Boulder)",
    "University of California, Riverside (UCR)",
    "Creighton University",
    "University of San Francisco (USF)"
    );

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        System.out.println();
        System.out.println("Welcome to the College Application Simulator!");
        System.out.println("Choose an option:");
        System.out.println("(a) Completely simulate the application");
        System.out.println("(b) Go through the application questions and simulate answers");
        System.out.println("(c) Manually enter everything");

        System.out.println();
        String option = input.next().toLowerCase();
        System.out.println();

        switch (option) {
            case "a":
                simulateCompleteApplication(input, random);
                break;
            case "b":
                simulateApplicationQuestions(input, random);
                break;
            case "c":
                manuallyEnterInformation(input);
                break;
            default:
                System.out.println("Invalid option. Please restart the program and choose a valid option.");
                System.out.println();
            }
    }

    private static void simulateCompleteApplication(Scanner input, Random random) {
        String name = Input.input("Enter your name: ");
        System.out.println();
        double GPA = statsSimulator.simulateGPA(random);
        double essayStrength = statsSimulator.simulateEssayStrength(input);
        double extracurriculars = statsSimulator.simulateExtracurriculars(input);
        double courseRigor = statsSimulator.simulateRigor(input);
        String ethnicity = statsSimulator.simulateEthnicity(input);
        String income = statsSimulator.simulateIncome(input);
        boolean firstGen = statsSimulator.simulateFirstGen(input);

        System.out.println();
        int SAT = statsSimulator.simulateScoreSAT(random);
        int ACT = statsSimulator.simulateScoreACT(random);
        System.out.println();
    
        printProfile(name, GPA, essayStrength, extracurriculars, courseRigor, SAT, ACT, ethnicity, income, firstGen);
    
        System.out.println();
        ArrayList<Integer> colleges = collegeApplications(input, GPA, SAT, ACT, extracurriculars, courseRigor, essayStrength, ethnicity, income, firstGen);
        System.out.println();

        ArrayList<Double> interviewList = interviewList(colleges, random);
        System.out.println();

        ArrayList<Double> admissionChanceList = new ArrayList<Double>();
        admissionChanceList = printResults(colleges, GPA, SAT, ACT, extracurriculars, courseRigor, essayStrength, interviewList, ethnicity, income, firstGen);
        makeCollegeDecisions(colleges, name, admissionChanceList);

        System.out.println();
        System.out.println("Thank you for using the College Application Simulator!");
        System.out.println();
    }    

    private static ArrayList<Double> interviewList(ArrayList<Integer> colleges, Random random) {
        ArrayList<Double> interviewStrengthList = new ArrayList<>();

        for (Integer college : colleges) {
            double interviewStrength = statsSimulator.simulateInterviewStrength(random);
            interviewStrengthList.add(interviewStrength);

        }
        return interviewStrengthList;

    }

    private static ArrayList<Double> printResults(ArrayList<Integer> colleges,
                                                     double GPA, int SAT, int ACT,
                                                     double extracurriculars, double courseRigor, double essayStrength, ArrayList<Double> interviewList,
                                                     String ethnicity, String income, boolean firstGen) {
    System.out.println("Simulating interview strength for each school:");
    
    // Separate lists for interview strengths and admission chances
    List<String> interviewStrengthList = new ArrayList<>();
    List<String> admissionChanceList = new ArrayList<>();
    ArrayList<Double> chancesList = new ArrayList<>();

    for (int i = 0; i < colleges.size(); i++) {
        double interviewStrength = interviewList.get(i);
        interviewStrengthList.add(getCollegeById(colleges.get(i)) + ": Interview Strength - " + interviewStrength);

        double admissionChance = collegeChances.chances(colleges.get(i), GPA, SAT, ACT, extracurriculars, courseRigor, essayStrength, interviewStrength, ethnicity, income, firstGen);
        chancesList.add(admissionChance);
        String formattedChance = String.format("%.2f", admissionChance);
        admissionChanceList.add(getCollegeById(colleges.get(i)) + ": Admission Chance - " + formattedChance + "% || (" + collegeChances.getType(admissionChance) + ")");
    }

    // Print interview strengths
    System.out.println("Interview Strengths:");
    for (String strength : interviewStrengthList) {
        System.out.println(strength);
    }

    // Print admission chances
    System.out.println("\nAdmission Chances:");
    for (String chance : admissionChanceList) {
        System.out.println(chance);
    }

    System.out.println();
    return chancesList;

}

    private static void simulateApplicationQuestions(Scanner input, Random random) {
        String name = Input.input("Enter your name: ");
        System.out.println();
        double GPA = statsSimulator.simulateGPA(random);
        double essayStrength = statsSimulator.simulateEssayStrength(input);
        double extracurriculars = statsSimulator.simulateExtracurriculars(input);
        double courseRigor = statsSimulator.simulateRigor(input);

        System.out.println();
        System.out.println("Select your ethnicity:");
        String ethnicityN = Input.input("1. White\n2. Black\n3. Hispanic\n4. Asian\n5. Native American\n6. Pacific Islander\n7. Mixed\n");
        System.out.println();
        System.out.println("Select your income level:");
        String incomeN = Input.input("1. Low Income\n2. Lower Middle Income\n3. Middle Income\n4. Upper Middle Income\n5. High Income \n");
        System.out.println();

        // convert numbers to actual ethniity/ income
        
        boolean firstGen = Input.inputBoolean(input, "Are you a first-generation college student? (Yes / No): ");

        String ethnicity = statsSimulator.convertEthnicity(ethnicityN);
        String income = statsSimulator.convertIncomeLevel(incomeN);

        System.out.println();
        int SAT = statsSimulator.simulateSAT(input, random);
        int ACT = statsSimulator.simulateACT(input, random);
        System.out.println();
    
        printProfile(name, GPA, extracurriculars, courseRigor, essayStrength, SAT, ACT, ethnicity, income, firstGen);
    
        ArrayList<Integer> colleges = collegeApplications(input, GPA, SAT, ACT, extracurriculars, courseRigor, essayStrength, ethnicity, income, firstGen);
        System.out.println();
    
        ArrayList<Double> interviewList = interviewList(colleges, random);
        System.out.println();

        ArrayList<Double> admissionChanceList = new ArrayList<Double>();
        admissionChanceList = printResults(colleges, GPA, SAT, ACT, extracurriculars, courseRigor, essayStrength, interviewList, ethnicity, income, firstGen);
        makeCollegeDecisions(colleges, name, admissionChanceList);
    
        System.out.println();
        System.out.println("Thank you for using the College Application Simulator!");
        System.out.println();
    }
    
    private static void manuallyEnterInformation(Scanner input) {
        String name = Input.input("Enter your name: ");
        double GPA = Input.inputDoubleRange("Enter your GPA (between 0.00 and 100.00): ", 0.00, 100.00);
        double essayStrength = Input.inputDoubleRange("Enter your essay strength (out of 10): ", 0, 10);
        double extracurriculars = Input.inputDoubleRange("Enter your extracurricular activities strength (out of 10): ", 0, 10);
        double courseRigor = Input.inputDoubleRange("Please rate the level of rigor of the courses you took at your school (out of 10): ", 0, 10);
        
        System.out.println();
        System.out.println("Select your ethnicity:");
        String ethnicityN = Input.input("1. White\n2. Black\n3. Hispanic\n4. Asian\n5. Native American\n6. Pacific Islander\n7. Mixed \n");
        System.out.println();
        System.out.println("Select your income level:");
        String incomeN = Input.input("1. Low Income\n2. Lower Middle Income\n3. Middle Income\n4. Upper Middle Income\n5. High Income \n");
        System.out.println();
        boolean firstGen = Input.inputBoolean(input, "Are you a first-generation college student? (Yes / No): ");
    
        int SAT;
        do {
            System.out.println();
            SAT = Input.inputInt("Enter your SAT score (0 if not applicable): ");
            if (SAT % 10 != 0 || (SAT > 0 && SAT < 400) || SAT > 1600) {
                System.out.println("That SAT is not possible!");
            }
        } while (SAT % 10 != 0 || (SAT > 0 && SAT < 400) || SAT > 1600);
    
        int ACT;
        do {
            System.out.println();
            ACT = Input.inputInt("Enter your ACT score (0 if not applicable): ");
            if (ACT < 0 || ACT > 36) {
                System.out.println("That ACT is not possible!");
            }
        } while (ACT < 0 || ACT > 36);
    
        Random random = new Random();
        String ethnicity = statsSimulator.convertEthnicity(ethnicityN);
        String income = statsSimulator.convertIncomeLevel(incomeN);

        System.out.println();
        printProfile(name, GPA, essayStrength, courseRigor, extracurriculars, SAT, ACT, ethnicity, income, firstGen);

        ArrayList<Integer> colleges = collegeApplications(input, GPA, SAT, ACT, extracurriculars, courseRigor, essayStrength, ethnicity, income, firstGen);
    
        ArrayList<Double> interviewList = interviewList(colleges, random);
        System.out.println();

        ArrayList<Double> admissionChanceList = new ArrayList<Double>();
        admissionChanceList = printResults(colleges, GPA, SAT, ACT, extracurriculars, courseRigor, essayStrength, interviewList, ethnicity, income, firstGen);
        makeCollegeDecisions(colleges, name, admissionChanceList);

        System.out.println();
        System.out.println("Thank you for using the College Application Simulator!");
        System.out.println();
    }
    
    private static void printProfile(String name, double GPA, double essayStrength, double extracurriculars, double courseRigor, int SAT, int ACT, String ethnicity, String income, boolean firstGen) {
        System.out.println("STUDENT PROFILE");
        System.out.println("Name: " + name);
        System.out.println("GPA: " + GPA);
        System.out.println("Essay Strength: " + essayStrength + "/10.0");
        System.out.println("Extracurriculars: " + extracurriculars + "/10.0");
        System.out.println("Course Rigor: " + courseRigor + "/10.0");
        System.out.println();
        System.out.println("Ethnicity: " + ethnicity);
        System.out.println("Income: " + income);
        System.out.println("First Gen: " + firstGen);
        System.out.println("Demographic Rating: " + statsSimulator.demRating(ethnicity, income, firstGen) + "/10.0");
        System.out.println();
        System.out.println("SAT: " + (SAT != 0 ? SAT : "N/A"));
        System.out.println("ACT: " + (ACT != 0 ? ACT : "N/A"));
        System.out.println();
    }
    
    private static ArrayList<Integer> collegeApplications(Scanner input, double GPA, int SAT, int ACT, double extracurriculars, double courseRigor, double essayStrength, String ethnicity, String income, boolean firstGen) {
        System.out.println();
        ArrayList<Integer> colleges = new ArrayList<>();
        int collegesLeft = 12;
        String option = "";
    
        boolean displayMenu = true;
    
        while (collegesLeft > 0) {
            if (collegesLeft == 12 && displayMenu) {
                System.out.println();
                System.out.println("Choose an option for the regular decision applications process:");
                System.out.println("a) Manually enter preferences");
                System.out.println("b) Select random colleges");
                System.out.println("c) Choose recommended colleges");
    
                System.out.print("Enter your option (a, b, or c): ");
                option = input.next().toLowerCase();
                System.out.println();
            }
    
            if (option.equals("a")) {
                displayMenu = false;  // Reset the flag to display the menu next time
    
                System.out.println("What school do you want to apply to? You can apply to " + collegesLeft + " more colleges. Type 'help' to find out colleges you can apply to, and type 'done' when you are done.");
                String userInput = input.next();
    
                if (userInput.equalsIgnoreCase("help")) {
                    System.out.println();
                    System.out.println("List of Colleges:");
                    listColleges();
                    System.out.println();
                    continue;
                }
    
                if (userInput.equalsIgnoreCase("done")) {
                    break;
                }
    
                try {
                    int collegeId = Integer.parseInt(userInput);
                    if (isValidCollegeId(collegeId) && !colleges.contains(collegeId)) {
                        colleges.add(collegeId);
                        collegesLeft--;
                        System.out.println("You have applied to: " + getCollegeById(collegeId));
                        System.out.println();
                    } else {
                        System.out.println("Invalid college ID or you have already applied to this college. Please choose a different college.");
                        System.out.println();
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid college ID, type 'help' for assistance, or type 'done' to finish.");
                    System.out.println();
                }
    
                printAppliedColleges(colleges);
            } else if (option.equals("b")) {
                displayMenu = false;  // Don't display the menu when selecting random colleges
    
                ArrayList<Integer> coll = collegeApplicationSimulation(new Random());
                for (int college : coll) {
                    if (collegesLeft > 0) {
                        colleges.add(college);
                        collegesLeft--;
                    } else {
                        break;
                    }
                }
            } else if (option.equals("c")) {
                displayMenu = false;  // Don't display the menu when choosing recommended colleges
    
                ArrayList<Integer> rec = statsSimulator.recommendedColleges(GPA, SAT, ACT, essayStrength, courseRigor, extracurriculars, ethnicity, income, firstGen);
    
                int size = Math.min(rec.size(), collegesLeft);  // Limit the size to available slots
                for (int i = 0; i < size; i++) {
                    if (!colleges.contains(rec.get(i))) {
                        colleges.add(rec.get(i));
                        collegesLeft--;
                    }
                }
            } else {
                System.out.println("Invalid option. Please restart the program and choose a valid option.");
                System.out.println();
                break;  // Terminate the loop if an invalid option is chosen
            }
        }
    
        return colleges;
    }
    
    

    private static ArrayList<Integer> collegeApplicationSimulation(Random random) {
        System.out.println();
        ArrayList<Integer> colleges = new ArrayList<>();
        int collegesLeft = 12;

        while (collegesLeft > 0) {
            int randomCollegeId = random.nextInt(collegeList.size()) + 1;
            if (!colleges.contains(randomCollegeId)) {
                colleges.add(randomCollegeId);
                collegesLeft--;
            }
    }

        return colleges;
    }

    private static void listColleges() {
        for (int i = 0; i < collegeList.size(); i++) {
            System.out.println((i + 1) + ". " + collegeList.get(i));
        }
    }

    public static String getCollegeById(int collegeId) {
        if (isValidCollegeId(collegeId)) {
            return collegeList.get(collegeId - 1);
        } else {
            return "N/A";
        }
    }

    private static boolean isValidCollegeId(int collegeId) {
        return collegeId >= 1 && collegeId <= collegeList.size();
    }

    private static void printAppliedColleges(ArrayList<Integer> colleges) {
        System.out.println("Colleges you have applied to: ");
        for (Integer college : colleges) {
            System.out.println(getCollegeById(college));
        }
        System.out.println();
    }


    private static String collegeAdmission(double chances) {
        Random random = new Random();
        
        // Add a bit of randomness (+- 1-2%)
        double randomFactor = random.nextDouble() * 10 - 6;
        double modifiedChances = chances + randomFactor;

        // Check if the modified chances are greater than a random value between 0 and 100
        double yourFate = random.nextDouble() * 100 - 1.5;

        if (modifiedChances > yourFate + 20) {
            return "Scholarship";
        }
        else if (modifiedChances > yourFate) {
            return "Admitted";
        }
        else if (modifiedChances + 10 > yourFate) {
            return "Waitlisted";
        }
        else {
            return "Rejected";
        }

    }

    private static void makeCollegeDecisions(ArrayList<Integer> colleges, String name, ArrayList<Double> chances) {
        int[] collegeArray = new int[colleges.size()];
        double[] chancesArray = new double[chances.size()];

        for (int i = 0; i < colleges.size(); i++) {
            collegeArray[i] = colleges.get(i);
            chancesArray[i] = chances.get(i);
        }

        collegeDecision(collegeArray, name, chancesArray);
    }

    private static void collegeDecision(int[] colleges, String name, double[] chances) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> acceptedColleges = new ArrayList<>();
        ArrayList<String> waitlistColleges = new ArrayList<>();
        ArrayList<String> scholarshipColleges = new ArrayList<>();
        int curNum = 0;
        double curAv = 0.0;
        int score;
        double avCAP;
        int resulted = 0;
    
        for (int i = 0; i < colleges.length; i++) {
            String collegeName = getCollegeById(colleges[i]);
            double chance = chances[i];
    
            System.out.println("Admissions decision for " + collegeName + " is in for " + name + ". Would you like to see the decision? (yes/no)");
    
            String proceed = scanner.next().toLowerCase();
    
            if (proceed.equals("no")) {
                System.out.println("No action taken for " + collegeName + ". Moving on to the next college...");
                System.out.println();
                continue;
            }
            else {
    
            String result = collegeAdmission(chance);
            System.out.println();
            System.out.println("--------------------------------------------------------------------------------------------------------------");

            if (result.equals("Scholarship")) {
                int v = (int) (Math.random() * 4);
                switch (v) {
                    case 0:
                        System.out.println("Congratulations! You've earned a scholarship at " + collegeName + "!");
                        break;
                    case 1:
                        System.out.println("Fantastic news! You've been awarded a scholarship to attend " + collegeName + "!");
                        break;
                    case 2:
                        System.out.println("Celebrate! You've secured a scholarship for your studies at " + collegeName + "!");
                        break;
                    case 3:
                        System.out.println("Great work! You're the recipient of a scholarship for " + collegeName + "!");
                        break;
                }
                scholarshipColleges.add(collegeName);
                resulted++;
            } else if (result.equals("Admitted")) {
                int v = (int) (Math.random() * 4);
                switch (v) {
                    case 0:
                        System.out.println("Congratulations! You've been admitted to " + collegeName + "!");
                        break;
                    case 1:
                        System.out.println("Exciting news! You've gained admission to " + collegeName + "!");
                        break;
                    case 2:
                        System.out.println("Wonderful! You're officially accepted at " + collegeName + "!");
                        break;
                    case 3:
                        System.out.println("Hooray! You're in! Welcome to " + collegeName + "!");
                        break;
                }
                acceptedColleges.add(collegeName);
                resulted++;
            } else if (result.equals("Waitlisted")) {
                int v = (int) (Math.random() * 4);
                switch (v) {
                    case 0:
                        System.out.println("Your application to " + collegeName + " is waitlisted. Further updates will follow.");
                        break;
                    case 1:
                        System.out.println("Your application to " + collegeName + " is under waitlist consideration. Updates will be provided soon.");
                        break;
                    case 2:
                        System.out.println("You're on the waitlist for " + collegeName + ". Updates on your status will follow shortly.");
                        break;
                    case 3:
                        System.out.println("Your application to " + collegeName + " has been waitlisted. Anticipate further updates soon.");
                        break;
                }
                waitlistColleges.add(collegeName);
            } else if (result.equals("Rejected")) {
                int v = (int) (Math.random() * 4);
                switch (v) {
                    case 0:
                        System.out.println("We regret to inform you that your application to " + collegeName + " has been rejected.");
                        break;
                    case 1:
                        System.out.println("Unfortunately, your application to " + collegeName + " was not successful. We appreciate your effort.");
                        break;
                    case 2:
                        System.out.println("We're sorry to say that your application to " + collegeName + " was not accepted.");
                        break;
                    case 3:
                        System.out.println("It's disappointing, but your application to " + collegeName + " has been declined.");
                        break;
                }
                resulted++;
            } else {
                System.out.println("Error: Your application was not successfully submitted.");
            }
            

            System.out.println("--------------------------------------------------------------------------------------------------------------");
            System.out.println();

            int funNum = calculateScore(acceptedColleges);
            int bosNum = calculateSScore(scholarshipColleges);
            curNum = bosNum + funNum;
            curAv = calculateRawScore(resulted, curNum);

            System.out.println("Your College Admission Points: " + curNum);
            System.out.println("Your Average College Admission Points: " + curAv);
            System.out.println();
        }        
    }

        System.out.println();

        System.out.println();
        System.out.println("Accepted Colleges:");
        for (String college : acceptedColleges) {
            System.out.println(college);
        }
        for (String college : scholarshipColleges) {
            System.out.println(college + " [SCHOLARSHIP]");
        }

        System.out.println();
        System.out.println("Waitlisted Colleges:");
        for (String college : waitlistColleges) {
            System.out.println(college);
        }

        if (waitlistColleges.isEmpty()) {
            System.out.println();
            System.out.println("Updated Accepted Colleges:");  // Change the label to indicate it's updated
            for (String college : acceptedColleges) {
                System.out.println(college);
            }
            for (String college : scholarshipColleges) {
                System.out.println(college + " [SCHOLARSHIP]");
            }

            int score1 = calculateScore(acceptedColleges);
            int score2 = calculateSScore(scholarshipColleges);

            score = score1 + score2;
            avCAP = calculateRawScore(12, score);
        }
        else {
            System.out.println();
            ArrayList<String> waitlistAccepted = Waitlist.waitlistResults(waitlistColleges);
            System.out.println("Updated Accepted Colleges:");  // Change the label to indicate it's updated
            for (String college : acceptedColleges) {
                System.out.println(college);
            }
            for (String college : waitlistAccepted) {
                System.out.println(college);
            }
            for (String college : scholarshipColleges) {
                System.out.println(college + " [SCHOLARSHIP]");
            }

            int score1 = calculateScore(acceptedColleges);
            int score2 = calculateSScore(scholarshipColleges);
            int score3 = calculateWScore(waitlistAccepted);

            score = score1 + score2 + score3;
            avCAP = calculateRawScore(12, score);

            acceptedColleges.addAll(waitlistAccepted);
        }



        System.out.println();
        System.out.println("Your College Admission Points: " + score);
        System.out.println("Your Average College Admission Points: " + avCAP);

        System.out.println();

        int pos;

        acceptedColleges.addAll(scholarshipColleges);


        if (!acceptedColleges.isEmpty()) {
                System.out.println("Which college would you like to attend? Enter the position of the college on this list:");
                System.out.println(acceptedColleges);
                scanner.next();
                pos = scanner.nextInt();
        
                if (pos > 0 && pos <= acceptedColleges.size()) {
                    System.out.println();
                    System.out.println("--------------------------------------------------------------------------------------------------------------");
                    System.out.println("You are now enrolled in " + acceptedColleges.get(pos - 1) + "! Congratulations!");
                    System.out.println("--------------------------------------------------------------------------------------------------------------");
                    System.out.println();
                }
                else {
                    System.out.println();
                    System.out.println("--------------------------------------------------------------------------------------------------------------");
                    System.out.println("Invalid input! All acceptances have expired. Your opportunity to select a college has ended.");
                    System.out.println("--------------------------------------------------------------------------------------------------------------");
                    System.out.println();

                }
            }
        else  {
            System.out.println();
            System.out.println("--------------------------------------------------------------------------------------------------------------");
            System.out.println("Unfortunately, none of your college applications resulted in acceptance. Consider exploring opportunities at your local Community College to continue your academic journey.");
            System.out.println("--------------------------------------------------------------------------------------------------------------");
        }

    }
    



    public static int getCollegeIdByName(String collegeName) {
        int index = collegeList.indexOf(collegeName);
        if (index != -1) {
            // College name found, return the corresponding college ID (adding 1)
            return index + 1;
        } else {
            // College name not found or invalid
            return -1;
        }
    }
    
    public static int calculateScore(ArrayList<String> acceptedColleges) {
        int score = 0;
        for (String college : acceptedColleges) {
            score += 100- getCollegeIdByName(college);

        }

        return (int) (score);
    }

    public static int calculateSScore(ArrayList<String> scholarshipColleges) {
        int score = 0;
        for (String college : scholarshipColleges) {
            score += (100 - getCollegeIdByName(college)) * 1.5;

        }

        return (int) (score);
    }

    public static int calculateWScore(ArrayList<String> waitlistColleges) {
        int score = 0;
        for (String college : waitlistColleges) {
            score += (100 - getCollegeIdByName(college)) * 0.5;

        }

        return (int) (score);
    }

    public static double calculateRawScore(int left, int score) {
        double rawScore = ((score / (double) left) / 100) * 100;
        return Math.round(rawScore * 100.0) / 100.0;
    }

}    