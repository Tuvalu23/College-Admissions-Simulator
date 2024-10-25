import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class UniversitySimulator {
    private static String[][] collegeList = { 
        // school name, percentage chance, ED deflator, EA deflator, REA/Private/Public
        {"Columbia University", "0.02", "1.9", "N", "P"},
        {"Stanford University", "0.03", "N", "1.3", "REA"},
        {"University of Pennsylvania", "0.03", "2.3", "N", "P"},
        {"California Institute of Technology (Caltech)", "0.03", "N", "1.1", "REA"},
        {"Princeton University", "0.06", "N", "1.3", "REA"},
        {"Massachusetts Institute of Technology (MIT)", "0.06", "N", "1.2", "P"},
        {"Yale University", "0.07", "N", "1.3", "REA"},
        {"Harvard University", "0.08", "N", "1.3", "REA"},
        {"University of Chicago", "0.08", "2.5", "1.3", "P"},
        {"Johns Hopkins University", "0.05", "1.7", "N", "P"},
        {"Dartmouth College", "0.09", "2.3", "N", "P"},
        {"Brown University", "0.09", "2.0", "N", "P"},
        {"Duke University", "0.10", "2.0", "N", "P"},
        {"Northwestern University", "0.12", "2.2", "N", "P"},
        {"Vanderbilt University", "0.12", "2.1", "N", "P"},
        {"Rice University", "0.13", "1.8", "N", "P"},
        {"Cornell University", "0.18", "2.2", "N", "P"},
        {"University of Notre Dame", "0.18", "N", "1.2", "REA"},
        {"University of Michigan", "0.18", "N", "1.3", "PUB"},
        {"University of California, Berkeley", "0.15", "N", "N", "PUB"},
        {"University of California, Los Angeles (UCLA)", "0.20", "N", "N", "PUB"},
        {"CUNY Macaulay Honors College", "0.20", "N", "N", "PUB"},
        {"Emory University", "0.14", "1.7", "N", "P"},
        {"Georgetown University", "0.25", "N", "1.3", "REA"},
        {"University of Southern California (USC)", "0.17", "N", "1.3", "P"},
        {"University of Virginia (UVA)", "0.15", "N", "1.3", "PUB"},
        {"University of North Carolina Chapel-Hill", "0.24", "N", "1.4", "PUB"},
        {"Tufts University", "0.12", "2.0", "N", "P"},
        {"New York University (NYU)", "0.22", "1.5", "1.3", "P"},
        {"Wake Forest University", "0.20", "2.1", "N", "P"},
        {"University of Rochester", "0.35", "1.7", "N", "P"},
        {"Boston College", "0.24", "1.8", "1.2", "P"},
        {"Georgia Institute of Technology", "0.16", "N", "1.4", "PUB"},
        {"University of Texas at Austin", "0.30", "N", "1.2", "PUB"},
        {"University of Wisconsin-Madison", "0.30", "N", "1.1", "PUB"},
        {"University of California, San Diego (UCSD)", "0.40", "N", "N", "PUB"},
        {"University of California, Davis", "0.40", "N", "N", "PUB"},
        {"Villanova University", "0.35", "2.5", "1.2", "P"},
        {"University of Illinois Urbana-Champaign", "0.32", "N", "1.2", "PUB"},
        {"University of California, Santa Barbara", "0.35", "N", "N", "PUB"},
        {"Pennsylvania State University", "0.45", "N", "1.1", "PUB"},
        {"University of Miami", "0.40", "1.5", "1.2", "P"},
        {"Ohio State University", "0.50", "N", "1.1", "PUB"},
        {"University of Maryland", "0.45", "N", "1.2", "PUB"},
        {"Purdue University", "0.55", "N", "N", "PUB"},
        {"University of Washington", "0.45", "N", "N", "PUB"},
        {"University of Pittsburgh", "0.55", "N", "1.1", "PUB"},
        {"Syracuse University", "0.60", "N", "N", "P"},
        {"Texas A&M University", "0.55", "N", "1.1", "PUB"},
        {"Indiana University Bloomington", "0.60", "N", "1.1", "PUB"},
        {"University of Connecticut", "0.70", "N", "1.2", "PUB"},
        {"University of Georgia", "0.50", "N", "1.2", "PUB"},
        {"Michigan State University", "0.65", "N", "N", "PUB"},
        {"Rutgers University", "0.70", "N", "N", "PUB"},
        {"University of Colorado Boulder", "0.55", "N", "1.1", "PUB"},
        {"Clemson University", "0.55", "N", "N", "PUB"},
        {"Virginia Tech", "0.60", "N", "1.1", "PUB"},
        {"University of Iowa", "0.65", "N", "N", "PUB"},
        {"University of Minnesota Twin Cities", "0.60", "N", "1.1", "PUB"},
        {"University of Delaware", "0.60", "N", "1.1", "PUB"},
        {"University of Massachusetts Amherst", "0.65", "N", "1.1", "PUB"},
        {"American University", "0.50", "N", "1.2", "P"},
        {"Baylor University", "0.50", "N", "1.2", "P"},
        {"Marquette University", "0.60", "N", "N", "P"},
        {"University of Denver", "0.55", "N", "1.1", "P"},
        {"Stevens Institute of Technology", "0.45", "1.8", "N", "P"},
        {"Lehigh University", "0.40", "2.1", "N", "P"},
        {"University of California, Irvine", "0.35", "N", "N", "PUB"},
        {"University of San Diego", "0.50", "N", "1.1", "P"},
        {"Texas Christian University", "0.50", "N", "1.1", "P"},
        {"University of Arizona", "0.65", "N", "N", "PUB"},
        {"Pepperdine University", "0.55", "N", "1.1", "P"},
        {"Yeshiva University", "0.60", "N", "N", "P"},
        {"Creighton University", "0.60", "N", "1.1", "P"},
        {"Colorado School of Mines", "0.50", "N", "1.1", "PUB"},
        {"University of San Francisco", "0.65", "N", "1.1", "P"},
        {"Loyola Marymount University", "0.60", "N", "1.1", "P"},
        {"Drexel University", "0.55", "N", "1.1", "P"},
        {"University of California, Riverside", "0.50", "N", "N", "PUB"},
        {"Binghamton University (SUNY)", "0.70", "N", "1.3", "PUB"},
        {"Stony Brook University (SUNY)", "0.75", "N", "1.3", "PUB"},
        {"Florida State University", "0.7", "N", "1.1", "PUB"},
        {"Fordham University", "0.60", "N", "1.2", "P"},
        {"Hunter College (CUNY)", "0.70", "N", "N", "PUB"},
        {"University at Albany (SUNY)", "0.68", "N", "N", "PUB"},
        {"Hofstra University", "0.60", "N", "1.1", "P"},
        {"Ithaca College", "0.55", "N", "1.2", "P"},  
        {"University at Buffalo (SUNY)", "0.87", "N", "1.2", "PUB"}  
    };

    // ansi formatting
    public static final String BOLD = "\u001B[1m";
    public static final String UNDERLINE = "\u001B[4m";

    public static final String BRIGHT_BLACK = "\u001B[90m";
    public static final String BRIGHT_RED = "\u001B[91m";
    public static final String BRIGHT_GREEN = "\u001B[92m";
    public static final String BRIGHT_YELLOW = "\u001B[93m";
    public static final String BRIGHT_BLUE = "\u001B[94m";
    public static final String BRIGHT_PURPLE = "\u001B[95m";
    public static final String BRIGHT_CYAN = "\u001B[96m";
    public static final String BRIGHT_WHITE = "\u001B[97m";
    public static final String BRIGHT_LIME = "\u001B[92m";  // Lime is closest to bright green  
    public static final String BRIGHT_ORANGE = "\u001B[38;5;214m"; // ANSI code for orange-like color
    public static final String BRIGHT_DARK_RED = "\u001B[38;5;88m"; // Dark red

    public static final String RESET = "\u001B[0m";


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double gpa = -1.0;
        double sat = -1;
        double act = -1;
        boolean testOptional = false;
        String name = null;
        double extracurriculars = -1;


        int ap_courses = -1;
        double essay_strength = -1;
        int gender = -1;
        int race = -1;
        boolean firstGen = false;

        System.out.println(BOLD + "Welcome to the College Application Simulator!" + RESET);
        System.out.println();
        System.out.println("[NOTE]: This is designed for NY applicants at Stuyvesant High School.");
        System.out.println("[DISCLAIMER]: Dont get too mad if the results do not perfectly match reality. The data is based on trends and probabilities specific to Stuyvesant students, but admissions can always surprise you!");
        System.out.println();
        System.out.println("Click any button to begin your journey!");

        input.nextLine();

        // name
        while (name == null || name.trim().isEmpty()) {  // Check for null or empty name
            try {
                System.out.println("What is your full name?");
                name = input.nextLine();  // Read the full name including spaces
                System.out.println("");
                
                if (name.trim().isEmpty()) {
                    System.out.println("Invalid name. Please enter your name.");
                    System.out.println();
                } else {
                    System.out.println("Welcome, " + name + "!");
                    System.out.println("");
                }
                
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter your full name.");
                input.nextLine();  // Clear the invalid input
                System.out.println();
            }
        }

        // gpa
        while (gpa < 65.0 || gpa > 100.0) {
            try {
                System.out.println("What is your GPA on an 100 point scale?");
                gpa = input.nextDouble();  // Attempt to read GPA
                input.nextLine();
                System.out.println();
                
                if (gpa < 65.0 || gpa > 100.0) {
                    System.out.println("Invalid GPA. Please enter a value between 65 and 100.");
                    System.out.println();
                } else {
                    continue;
                }
                
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a numeric value.");
                input.next();  // Clear the invalid input from the scanner buffer
                System.out.println();
            }
        }

        // sat + act
        System.out.println("Are you applying test-optional? (yes/no)");
        String response = input.nextLine().trim().toLowerCase();  
        System.out.println();
    if (response.equals("yes")) {
        testOptional = true;  
        System.out.println("You have chosen test-optional mode. SAT/ACT score is not required.");
        System.out.println();
    } else {
        // Ask the user to choose between SAT or ACT
        System.out.println("Will you be submitting SAT or ACT scores? (Enter 'SAT', 'ACT', or 'neither')");
        String testChoice = input.nextLine().trim().toLowerCase();
        System.out.println();
        
        if (testChoice.equals("sat")) {
            // SAT input loop for non-test-optional applicants
            while (sat < 400 || sat > 1600 || sat % 10 != 0) {  
                try {
                    System.out.println("What is your highest SAT score/SAT superscore?");
                    sat = input.nextInt();  
                    input.nextLine();  
                    System.out.println();

                    if (sat < 400 || sat > 1600 || sat % 10 != 0) {
                        System.out.println("Invalid SAT score. Please enter a valid score between 400 and 1600, in intervals of 10.");
                        System.out.println();
                    }

                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a numeric value.");
                    input.next();  
                    System.out.println();
                }
            }
            
        } else if (testChoice.equals("act")) {
            // ACT input loop for non-test-optional applicants
            while (act < 1 || act > 36) {  
                try {
                    System.out.println("What is your highest ACT composite score?");
                    act = input.nextInt();  
                    input.nextLine();  
                    System.out.println();

                    if (act < 1 || act > 36) {
                        System.out.println("Invalid ACT score. Please enter a valid score between 1 and 36.");
                        System.out.println();
                    }

                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a numeric value.");
                    input.next();  
                    System.out.println();
                }
            }
            
        } else if (testChoice.equals("neither")) {
            testOptional = true;
            System.out.println("You have chosen not to submit SAT or ACT scores. Test-optional mode enabled.");
            System.out.println();
        } else {
            System.out.println("Invalid choice. Please restart and select 'SAT', 'ACT', or 'neither'.");
            System.out.println();
        }
    }

        //extracurriculars
        while (extracurriculars < 0 || extracurriculars > 10) {
            try {
                System.out.println("On a scale of 0 to 10, how would you rate the strength of your extracurricular activities?");
                extracurriculars = input.nextDouble();  // Attempt to read EC
                input.nextLine();
                System.out.println();
                
                if (extracurriculars < 0 || extracurriculars > 10) {
                    System.out.println("Invalid extracurricular value. Please enter a value between 0 and 10.");
                    System.out.println();
                } else {
                    continue;
                }
                
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a numeric value.");
                input.next();  // Clear the invalid input from the scanner buffer
                System.out.println();
            }
        }
        
        //ap
        while (ap_courses < 0) {
            try {
                System.out.println("How many AP courses have you taken? (Including those you are currently taking)");
                ap_courses = input.nextInt();  // Attempt to read EC
                input.nextLine();
                System.out.println();
                
                if (ap_courses < 0) {
                    System.out.println("Invalid amount of AP courses. Please enter a value 0 or above.");
                    System.out.println();
                } else {
                    continue;
                }
                
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer value.");
                input.next();  // Clear the invalid input from the scanner buffer
                System.out.println();
            }
        }
    
        //essay strength
        while (essay_strength < 0 || essay_strength > 10) {
            try {
                System.out.println("On a scale of 0 to 10, how would you rate the strength of your essays?");
                essay_strength = input.nextDouble();  // Attempt to read EC
                input.nextLine();
                System.out.println();
                
                if (essay_strength < 0 || essay_strength > 10) {
                    System.out.println("Invalid essay strength value. Please enter a value between 0 and 10.");
                    System.out.println();
                } else {
                    continue;
                }
                
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a numeric value.");
                input.next();  // Clear the invalid input from the scanner buffer
                System.out.println();
            }
        }
    
        //demographics
        while (gender < 1 || gender > 3) {
            try {
                System.out.println("What is your gender?");
                System.out.println("- Enter 1 if you identify as male.");
                System.out.println("- Enter 2 if you identify as female.");
                System.out.println("- Enter 3 if you identify as other.");
                gender = input.nextInt();  // Attempt to read EC
                input.nextLine();
                System.out.println();
                
                if (gender < 1 || gender > 3) {
                    System.out.println("Invalid gender value. Please enter either 1, 2, or 3.");
                    System.out.println();
                } else {
                    continue;
                }
                
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a numeric value.");
                input.next();  // Clear the invalid input from the scanner buffer
                System.out.println();
            }
        }
    
        while (race < 1 || race > 9) {
            try {
                System.out.println("What is your race/ethnicity?");
                System.out.println("- Enter 1 if you are Caucasian.");
                System.out.println("- Enter 2 if you are African-American.");
                System.out.println("- Enter 3 if you are Hispanic or Latino.");
                System.out.println("- Enter 4 if you are Asian.");
                System.out.println("- Enter 5 if you are Native American or Alaskan Native.");
                System.out.println("- Enter 6 if you are Pacific Islander.");
                System.out.println("- Enter 7 if you identify as Middle Eastern or North African.");
                System.out.println("- Enter 8 if you prefer not to say.");
                System.out.println("- Enter 9 if you do not see your race/ethnicity listed here.");

                race = input.nextInt();  // Attempt to read
                input.nextLine();
                System.out.println();
                
                if (race < 1 || race > 9) {
                    System.out.println("Invalid race value. Please enter an integer value from 1 to 9.");
                    System.out.println();
                } else {
                    continue;
                }
                
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a numeric value.");
                input.next();  // Clear the invalid input from the scanner buffer
                System.out.println();
            }
        }
    
        boolean validInput = false;
        while (!validInput) {
            System.out.println("Are you a first-generation college student? (yes/no)");
            String response2 = input.nextLine().trim().toLowerCase();  // Read the user's input
            System.out.println();

            if (response2.equals("yes")) {
                firstGen = true;
                validInput = true;  // Exit loop after valid input
            } else if (response2.equals("no")) {
                firstGen = false;
                validInput = true;  // Exit loop after valid input
            } else {
                System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                System.out.println();
            }
        }
      
        double wgpa = weightedGPA(gpa, ap_courses);
        double demScore = demScore(gender, race, firstGen);

        // now print profile
        System.out.println(name.toUpperCase() + "'S COLLEGE APPLICATION PROFILE:");
        System.out.println("UW GPA: " + gpa);
        System.out.println("W GPA: " + wgpa);
        if (testOptional == false) {
            if (sat != -1) {
                System.out.println("SAT: " + (int)(sat));
            }
            if (act != -1) {
                System.out.println("ACT: " + (int)act);
            }
        }
        System.out.println("AP Courses Taken: " + ap_courses);
        System.out.println();
        System.out.println("Extracurricular Activities Strength: " + extracurriculars + "/10.0 -- " + rate(extracurriculars));
        System.out.println("Essay Strength: " + essay_strength + "/10.0 -- " + rate(essay_strength));
        System.out.println();
        System.out.println("Gender: " + getGender(gender));
        System.out.println("Race: " + getRace(race));
        System.out.println("First Generation Student: " + firstGen);
        System.out.println("Demographics Score: " + demScore + "/10.0 -- " + rate(demScore));
        System.out.println();
        
        // ED Selection
        int edSchool = -1;
        int reaSchool = -1;
        ArrayList<Integer> eaSchools = new ArrayList<>();
        System.out.println("Would you like to apply for Early Decision (ED) to one of the schools? (yes/no)");
        String response2 = input.nextLine().trim().toLowerCase();
        System.out.println();

        if (response2.equals("yes")) {
            System.out.println("Note: Early Decision is **binding**, meaning you must attend the school if accepted. Please select a school from the list below by typing its corresponding number.");

            for (int i = 0; i < collegeList.length; i++) {
                if (!collegeList[i][2].equals("N")) {
                    System.out.println((i) + ": " + collegeList[i][0]);
                }
            }

            System.out.println();
            System.out.println("Enter the number corresponding to the school you wish to apply ED to (or type '-1' to skip):");
            edSchool = input.nextInt();
            input.nextLine(); // Clear buffer
            System.out.println();

            if (edSchool > -1 && edSchool < collegeList.length) {
                if (!collegeList[edSchool][2].equals("N")) {
                    System.out.println("You have chosen to apply Early Decision to " + collegeList[edSchool][0] + ".");
                    System.out.println();
                } else {
                    System.out.println("Invalid choice. " + collegeList[edSchool][0] + " does not offer Early Decision.");
                    edSchool = -1;
                }
            } else if (edSchool == -1) {
                System.out.println("You have chosen not to apply Early Decision.");
            } else {
                System.out.println("Invalid selection. Please restart and select a valid number.");
                edSchool = -1;
            }
        }

        // REA Selection
        if (edSchool == -1) {
            System.out.println("Would you like to apply under the Restrictive Early Action (REA) program to one of the schools? (yes/no)");
            String response3 = input.nextLine().trim().toLowerCase();
            System.out.println();

            if (response3.equals("yes")) {
                System.out.println("Note: Applying REA means you cannot apply Early Action (EA) to private schools, but you can apply to public universities.");
                for (int i = 0; i < collegeList.length; i++) {
                    if (collegeList[i][4].equals("REA")) {
                        System.out.println((i) + ": " + collegeList[i][0]);
                    }
                }
                System.out.println();
                System.out.println("Enter the number corresponding to the school you wish to apply REA to (or type '-1' to skip):");
                reaSchool = input.nextInt();
                input.nextLine(); // Clear buffer
                System.out.println();

                if (reaSchool > -1 && reaSchool < collegeList.length && collegeList[reaSchool][4].equals("REA")) {
                    System.out.println("You have chosen to apply Restrictive Early Action to " + collegeList[reaSchool][0] + ".");
                } else if (reaSchool == -1) {
                    System.out.println("You have chosen not to apply under the REA program.");
                } else {
                    System.out.println("Invalid selection. Please restart and select a valid REA school.");
                    reaSchool = -1;
                }
                System.out.println();
            }

            // EA Selection for Public Schools
            if ((reaSchool != -1)) {
                System.out.println("Would you like to apply for Early Action (EA) to any public schools? (yes/no)");
                String response4 = input.nextLine().trim().toLowerCase();
                System.out.println();

                if (response4.equals("yes")) {
                    System.out.println("You can apply EA to the following public universities. Please select schools by typing their corresponding numbers (one at a time).");

                    // public schools offering EA
                    for (int i = 0; i < collegeList.length; i++) {
                        if (collegeList[i][4].equals("PUB") && !collegeList[i][3].equals("N") && (reaSchool != i)) {
                            System.out.println((i) + ": " + collegeList[i][0]);
                        }
                    }
                    System.out.println();

                    // Prompting for selections until '0' is entered
                    while (true) {
                        System.out.println("Enter the number corresponding to the public school you wish to apply EA to (or type '-1' to end your selection):");
                        int eaSelection = input.nextInt();
                        input.nextLine();  // Clear the input buffer
                        System.out.println();

                        if (eaSelection == -1) {
                            break;  // Exit the loop 
                        }

                        // Validate selection and confirm
                        if (eaSelection > -1 && eaSelection < collegeList.length && !collegeList[eaSelection][3].equals("N") && collegeList[eaSelection][4].equals("PUB")) {
                            if (!eaSchools.contains(eaSelection)) {
                                eaSchools.add(eaSelection);  // Add selected school to the list
                                System.out.println("Applied to " + collegeList[eaSelection][0] + " (EA).");
                                System.out.println();
                            } else {
                                System.out.println("You have already applied to this school.");
                                System.out.println();
                            }
                        } else if (eaSelection > -1 && eaSelection < collegeList.length) {
                            System.out.println("Invalid choice. " + collegeList[eaSelection][0] + " does not offer Early Action or is not a public university.");
                            System.out.println();
                        } else {
                            System.out.println("Invalid choice!");
                            System.out.println();
                        }
                    }

                    System.out.println("You have finished selecting your Early Action public schools.");
                    System.out.println();
        
                    // Display selected EA public schools
                    System.out.println("You have applied to the following schools:");
                    if (reaSchool != -1) {
                        System.out.println("- " + collegeList[reaSchool][0] + " (REA)");
                    }
                    if (!eaSchools.isEmpty()) {
                        for (int school : eaSchools) {
                            System.out.println("- " + collegeList[school][0] + " (EA)");
                        }
                    } else {
                        System.out.println("You did not apply EA to any public universities.");
                    }
                    System.out.println();
                }
            }
        }

            // EA selection if ED was picked
            if (reaSchool == -1) {
                System.out.println("Would you like to apply for Early Action (EA) to private non-REA and public schools? (yes/no)");
                String response5 = input.nextLine().trim().toLowerCase();
                System.out.println();

                if (response5.equals("yes")) {
                    System.out.println("You can apply EA to the following private non-REA and public schools. Please select schools by typing their corresponding numbers (multiple selections allowed).");

                    for (int i = 0; i < collegeList.length; i++) {
                        if (!collegeList[i][3].equals("N") && !collegeList[i][4].equals("REA") && (edSchool != i)) {
                            System.out.println((i) + ": " + collegeList[i][0]);
                        }
                    }
                    System.out.println();

                    while (true) {
                        System.out.println("Enter the number corresponding to the schools you wish to apply EA to (or type '-1' to end your selection):");
                        int eadSelection = input.nextInt();
                        input.nextLine();  // Clear the input buffer
                        System.out.println();

                        if (eadSelection == -1) {
                            break;  // Exit the loop if '0' is entered
                        }

                        // Validate selection and confirm
                        if ((eadSelection > -1 && eadSelection < collegeList.length && !collegeList[eadSelection][3].equals("N") && !collegeList[eadSelection][4].equals("REA")) ) {
                            if (!eaSchools.contains(eadSelection) && (edSchool != eadSelection)) {
                                eaSchools.add(eadSelection);  // Add selected school to the list
                                System.out.println("Applied to " + collegeList[eadSelection][0] + " (EA).");
                                System.out.println();
                            } else {
                                System.out.println("You have already applied to this school.");
                                System.out.println();
                            }
                        } else {
                            System.out.println("Invalid selection. Please choose a valid school offering EA.");
                            System.out.println();
                        }
                    }
                    
                    System.out.println("You have applied to the following schools:");
                    if (edSchool != -1) {
                        System.out.println("- " + collegeList[edSchool][0] + " (ED)");
                    }
                    if (!eaSchools.isEmpty()) {
                        for (int school : eaSchools) {
                            System.out.println("- " + collegeList[school][0] + " (EA)");
                        }
                    }
                    System.out.println();
                }
            }

        ArrayList<String[]> collegesApplied = new ArrayList<>();
        if (edSchool != -1) {
            String[] edApp = {collegeList[edSchool][0], "ED", "0", "null", "0", "false", "false"};
            collegesApplied.add(edApp);
        }
        else if (reaSchool != -1) {
            String[] reaApp = {collegeList[reaSchool][0], "REA", "0", "null", "0", "false", "false"};
            collegesApplied.add(reaApp);
        }
        for (int eaSchool : eaSchools) {
            String[] eaApp = {collegeList[eaSchool][0], "EA", "0", "null", "0", "false", "false"};  // Create an entry with college name and type "EA"
            collegesApplied.add(eaApp);  // Add to the list
        }

        System.out.println("Proceeding to the Regular Decision phase. Press any key to continue and view a list of colleges available for application.");
        input.nextLine();
        System.out.println();
        System.out.println("List of Colleges:");
                for (int i = 0; i < collegeList.length; i++) {
                    if (isCollegeInList(collegesApplied, collegeList[i][0])) {
                        System.out.println(i + " : " + collegeList[i][0] + " - ALREADY APPLIED");
                    }
                    else {
                        System.out.println(i + " : " + collegeList[i][0]);
                    }
                }
                System.out.println();

        // rd apps
        boolean done = false;
        while (!done) {
            System.out.println("What school would you like to apply to? Type 'help' to find out colleges you can apply to, and type 'done' when you are done.");
            String userInput = input.next();
            System.out.println();

            if (userInput.equalsIgnoreCase("help")) {
                System.out.println();
                System.out.println("List of Colleges:");
                for (int i = 0; i < collegeList.length; i++) {
                    if (isCollegeInList(collegesApplied, collegeList[i][0])) {
                        System.out.println(i + " : " + collegeList[i][0] + " - ALREADY APPLIED");
                    }
                    else {
                        System.out.println(i + " : " + collegeList[i][0]);
                    }
                }
                System.out.println();
                continue;
            }

            if (userInput.equalsIgnoreCase("done")) {
                done = true;
                break;
            }

            try {
                int collegeId = Integer.parseInt(userInput);
                if (-1 < collegeId && collegeId < collegeList.length && !isCollegeInList(collegesApplied, collegeList[collegeId][0])) {
                    String[] app = {collegeList[collegeId][0], "RD", "0", "null", "0", "false", "false"};
                    collegesApplied.add(app);
                    System.out.println("You have applied to: " + collegeList[collegeId][0] + "!");
                    System.out.println();
                } else {
                    System.out.println("Invalid college ID or you have already applied to this college. Please choose a different college.");
                    System.out.println();
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid college ID, type 'help' for assistance, or type 'done' to finish.");
                System.out.println();
            }

        }
        System.out.println("Colleges you have applied to: ");
        for (int i = 0; i < collegesApplied.size(); i++) {
            String[] application = collegesApplied.get(i);
            application[2] = sim10();
            System.out.println(application[0] + " - (" + application[1] + ")");
        }
        System.out.println();

        System.out.println("Press any key to reveal your admission chances and interview strengths for each school.");
        input.nextLine();
        input.nextLine();
        
        //random interviews
        System.out.println();
        System.out.println("Your interview strength for each college:");
        for (int i = 0; i < collegesApplied.size(); i++) {
            String[] application = collegesApplied.get(i);
            System.out.println(application[0] + " - (" + application[1] + "): " + application[2] + "/10.0 -- " + rate(Double.parseDouble(application[2])));
        }
        System.out.println();

        System.out.println("Your chances and classifications for each college:");
        for (int i = 0; i < collegesApplied.size(); i++) {
            String[] application = collegesApplied.get(i);
            double chances = chanceCollege(collegeList, findInList(collegeList, application[0]), demScore, testOptional, sat, act, extracurriculars, ap_courses, essay_strength, gpa, Double.parseDouble(application[2]), application[1]);
            System.out.println(application[0] + " - (" + application[1] + "): " + chances + "% -- " + getType(chances));
            application[4] = String.valueOf(chances);
        }
        System.out.println();
        System.out.println(BOLD + "Click any button to view your admissions decisions.");
        input.nextLine();

        for (int i = 0; i < collegesApplied.size(); i++) {
            String[] application = collegesApplied.get(i);
            if (application[1].equals("ED")) {
                System.out.println("Your decision for " + application[0] + " (ED) is out! Press any key to view your admissions decision.");
                input.nextLine();
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
                double chances = Double.parseDouble(application[4]);
                String result = admissionsDecision(chances, "ED", i, collegesApplied);
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println();
                System.out.println(BOLD + "All Early Decision application letters have been read. Click any button to advance.");
                input.nextLine();
                if (application[3].equals("D")) {
                    application[5] = "true";
                }
                application[3] = result;
            }
        }

        for (int i = 0; i < collegesApplied.size(); i++) {
            String[] application = collegesApplied.get(i);
            if (application[1].equals("REA")) {
                System.out.println("Your decision for " + application[0] + " (REA) is out! Press any key to view your admissions decision.");
                input.nextLine();
                
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
                double chances = Double.parseDouble(application[4]);
                String result = admissionsDecision(chances, "REA", i, collegesApplied);
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println();
                System.out.println(BOLD + "All Restrictive Early Action application letters have been read. Click any button to advance.");
                input.nextLine();
                
                // Store result in application[3]
                if (result.equals("D")) {
                    application[5] = "true";
                }
                application[3] = result;
            }
        }

        for (int i = 0; i < collegesApplied.size(); i++) {
            String[] application = collegesApplied.get(i);
            if (application[1].equals("EA")) {
                System.out.println("Your decision for " + application[0] + " (EA) is out! Press any key to view your admissions decision.");
                input.nextLine();
                
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
                double chances = Double.parseDouble(application[4]);
                String result = admissionsDecision(chances, "EA", i, collegesApplied);
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println();
                
                // Store result in application[3]
                if (result.equals("D")) {
                    application[5] = "true";
                }
                application[3] = result;
            }
        }
        System.out.println(BOLD + "All Early Action application letters have been read. Click any button to advance to Regular Decision.");
                input.nextLine();

        for (int i = 0; i < collegesApplied.size(); i++) {
            String[] application = collegesApplied.get(i);
            if (application[1].equals("RD") || application[3].equals("D")) {
                System.out.println("Your decision for " + application[0] + " (RD) is out! Press any key to view your admissions decision.");
                input.nextLine();
                
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
                double chances = Double.parseDouble(application[4]);
                String result = admissionsDecision(chances, "RD", i, collegesApplied);
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println();
                
                // Store result in application[3]
                if (result.equals("W")) {
                    application[6] = "true";
                }
                application[3] = result;
            }
        }
        System.out.println(BOLD + "All Regular Decision application letters have been read. Click any button to advance to Waitlist decisions.");
                input.nextLine();

        // waitlist
        for (int i = 0; i < collegesApplied.size(); i++) {
            String[] application = collegesApplied.get(i);
            if (application[3].equals("W")) {
                System.out.println("Your waitlist decision for " + application[0] + " is out! Press any key to view your admissions decision.");
                input.nextLine();
                
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
                double chances = Double.parseDouble(application[4]);
                String result = admissionsDecision(chances, "RD", i, collegesApplied);
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println();
                
                // Store result in application[3]
                application[3] = result;
            }
        }
        System.out.println(BOLD + "All waitlist decision letters have been read. Click any button to advance to school enrollment.");
                input.nextLine();

        // String[] app = {collegeList[collegeId][0], "RD", "0", null, "0", false, false};
        // school enrollment
        System.out.println("Final Results:");
        for (int i = 0; i < collegesApplied.size(); i++) {
            String[] application = collegesApplied.get(i);
            System.out.print(application[0] + " - (" + application[1] + "): ");

            // Deferred Status
            if (application[5].equals("true")) {
                System.out.print("- " + BRIGHT_YELLOW + "Deferred " + RESET);
            }

             // Waitlisted Status
            if (application[6].equals("true")) {
                System.out.print("- " + BRIGHT_YELLOW + "Waitlisted " + RESET);
            }

            // Acceptance Outcomes
            if (application[3].equals("ASH")) {
                System.out.print("- " + BRIGHT_GREEN + "Accepted with Honors & Scholarship" + RESET);
            } else if (application[3].equals("AS")) {
                System.out.print("- " + BRIGHT_GREEN + "Accepted with Scholarship" + RESET);
            } else if (application[3].equals("A")) {
                System.out.print("- " + BRIGHT_GREEN + "Accepted" + RESET);
            } 

            // Rejection Outcomes
           if (application[3].equals("R")) {
                System.out.print("- " + BRIGHT_RED + "Rejected" + RESET);
            }
            System.out.println();
        }

        List<String[]> acceptedSchools = new ArrayList<>();  // Store accepted applications

        // Populate acceptedSchools list with accepted applications
        for (int i = 0; i < collegesApplied.size(); i++) {
            String[] application = collegesApplied.get(i);
            if (application[3].equals("A") || application[3].equals("AS") || application[3].equals("ASH")) {
                acceptedSchools.add(application);  // Add accepted application to the list
            }
        }

        // Check if any schools were accepted
        if (!acceptedSchools.isEmpty()) {
            // Check if any school is an ED school and enroll automatically if found
            String enrolledSchool = null;
            for (String[] application : acceptedSchools) {
                if (application[1].equalsIgnoreCase("ED")) {  // Assuming the second element in the array is the ED status
                    enrolledSchool = application[0];
                    break;  // Automatically enroll in the first ED school found
                }
            }
        
            if (enrolledSchool != null) {
                // Automatically enroll at the ED school
                System.out.println(BRIGHT_GREEN + "You have been automatically enrolled at " + enrolledSchool + " due to Early Decision acceptance!" + RESET);
                System.out.println();
            } else {
                // No ED schools found, allow user to select a school
                System.out.println("\nEnter the corresponding number of the school you wish to enroll at:");
                
                // Display accepted schools
                for (int i = 0; i < acceptedSchools.size(); i++) {
                    String[] application = acceptedSchools.get(i);
                    System.out.println((i + 1) + ": " + application[0]);  // Display the accepted schools
                }
        
                // Ask user for input and enroll in selected school
                int selectedSchoolIndex = input.nextInt() - 1;  // Get user input, adjusted to 0-based index
                if (selectedSchoolIndex >= 0 && selectedSchoolIndex < acceptedSchools.size()) {
                    System.out.println(BRIGHT_GREEN + "You have successfully enrolled at " + acceptedSchools.get(selectedSchoolIndex)[0] + "!" + RESET);
                    System.out.println();
                } else {
                    System.out.println(BRIGHT_RED + "Invalid selection. Please try again." + RESET);
                    System.out.println();
                }
            }
        } else {
            // No accepted schools
            System.out.println(BRIGHT_RED + "Unfortunately, you were not accepted into any of your applied schools." + RESET);
            System.out.println("We recommend enrolling in your local community college as a next step.");
            System.out.println();
        }
        

        input.close();
}

    public static double weightedGPA(double gpa, int ap_courses) {
        double wgpa = gpa;
        int count = ap_courses;
        while (count > 0) {
            wgpa += Math.random() * 0.38;
            count--;
        }
        return Math.round(wgpa * 100.0) / 100.0;
    }
       
    public static String getGender(int gender) {
        switch (gender) {
            case 1:
                return "Male";
            case 2:
                return "Female";
            case 3:
                return "Other";
        }
        return "Unknown";
    }

    public static String getRace(int race) {
        switch (race) {
            case 1:
                return "Caucasian";
            case 2:
                return "African-American";
            case 3:
                return "Hispanic or Latino";
            case 4:
                return "Asian";
            case 5:
                return "Native American or Alaskan Native";
            case 6:
                return "Pacific Islander";
            case 7:
                return "Middle Eastern or North African";
            case 8:
                return "Prefer not to say";
            case 9:
                return "Other";
            default:
                return "Unknown";
        }
    }

    public static double demScore(int gender, int race, boolean firstGen) {
        double score = 5 + Math.random() * 2 - 1;  // Start with a base score of 5
    
        // Gender-based adjustments
        if (gender == 2 || gender == 3) {  // Female or Non-binary
            score += Math.random() * 2.3;  // Slight boost for diversity
        }
    
        // First-generation adjustment
        if (firstGen) {
            score += Math.random() * 3;  // Larger boost for first-generation status
        }
    
        // Race-based adjustments (based on real-world underrepresentation patterns)
        switch (race) {
            case 1:  // Caucasian
                score -= Math.random() * 2;  // Slight reduction, as Caucasian students are typically not underrepresented
                break;
            case 2:  // African-American
                score += Math.random() * 4.5;  // Larger boost for underrepresented minority
                break;
            case 3:  // Hispanic or Latino
                score += Math.random() * 4.5;  // Boost for underrepresented minority
                break;
            case 4:  // Asian
                score -= Math.random() * 3.5;  // Small boost
                break;
            case 5:  // Native American or Alaskan Native
                score += Math.random() * 4;  // Significant boost for underrepresented minority
                break;
            case 6:  // Pacific Islander
                score += Math.random() * 3;  // Boost for underrepresented minority
                break;
            case 7:  // Middle Eastern or North African
                score += Math.random() * 2;  // Moderate boost
                break;
            case 8:  // Prefer not to say
                score -= Math.random() * 1;  // Neutral impact
                break;
            case 9:  
                score += Math.random() * 1.5;  // Slight boost for diversity
                break;
            default:
                score += 0.0;  // No additional adjustment
                break;
        }
    
        if (score > 10) {
            return 10.0;
        } else if (score < 0) {
            return 0.0;
        }
    
        // Return the score rounded to two decimal places
        return Math.round(score * 100) / 100.0;
    }
    
    public static String rate(double value) {
        if (value <= 10 && value >= 8.7) {
            return "\u001B[38;5;22m" + "Outstanding" + BRIGHT_WHITE;
        } else if (value >= 7.2) {
            return BRIGHT_GREEN + "Strong" + BRIGHT_WHITE;
        } else if (value >= 6) {
            return BRIGHT_YELLOW + "Moderate" + BRIGHT_WHITE;
        } else if (value >= 4.5) {
            return BRIGHT_ORANGE + "Fair" + BRIGHT_WHITE;
        } else if (value >= 2) {
            return BRIGHT_RED + "Weak" + BRIGHT_WHITE;
        } else if (value >= 0) {
            return BRIGHT_DARK_RED + "Terrible" + BRIGHT_WHITE;
        }
        return BRIGHT_BLACK + "N/A" + BRIGHT_WHITE;
    }
    
    
    public static boolean isCollegeInList(ArrayList<String[]> collegesApplied, String collegeName) {
        for (String[] application : collegesApplied) {
            if (application[0].equals(collegeName)) {
                return true;
            }
        }
        return false;
    }

    public static String sim10() {
        double var = Math.random() * 10;
        double var2;

        if (var < 1) {
            var2 = Math.random() * 2;
        } else if (var < 3) {
            var2 = Math.random() * 5.5;
        } else if (var < 5) {
            var2 = Math.random() * 9;
        } else if (var < 7) {
            var2 = 2 + Math.random() * 8;
        } else if (var < 9) {
            var2 = 3 + Math.random() * 8;
        } else {
            var2 = 9 + Math.random() * 1.2;
        }

        // Ensure the value doesn't exceed 10
        if (var2 > 10) {
            var2 = 10.0;
        }
        if (var2 < 5) {
            if (var2 <= 1) {
                var2 += Math.random() * 1.5;
            }
            var2 = var2 - 1 + Math.random() * 2.5;
        }
        if (var2 < 0) {
            var2 = 0;
        }

        // Round to 2 decimal places and return as a string
        return String.format("%.2f", var2);
    }
    
    public static int findInList(String[][] collegeList, String college) {
        for (int i = 0; i < collegeList.length; i++) {
            if (collegeList[i][0].equals(college)) {
                return i;  // Return the index of the found college
            }
        }
        return -1;
    }

    public static double chanceCollege(String[][] collegeList, int i, double demScore, boolean testOptional, double sat, double act, 
                                       double extracurriculars, int ap_courses, double essayStrength, double gpa, 
                                       double interviewStrength, String app_type) {
        // Convert acceptance rate and interview strength to double
        double baseChance = Double.parseDouble(collegeList[i][1]); // Convert acceptance rate to percentage
        double interviewScore = (interviewStrength); // Parse interview strength as double
        
        double student_num = 0.0;
        if (testOptional) {
            // gpa = 40 pts, ec = 20 pts, essay = 15 pts, ap = 10pts, interview = 15pts
            if (gpa > 99) {
                student_num += 40;
            } else if (gpa > 98) {
                student_num += 39;
            } else if (gpa > 97) {
                student_num += 38; 
            } else if (gpa > 96) {
                student_num += 36; 
            } else if (gpa > 95) {
                student_num += 34; 
            } else if (gpa > 94) {
                student_num += 32; 
            } else if (gpa > 93) {
                student_num += 29; 
            } else if (gpa > 92) {
                student_num += 26.5; 
            } else if (gpa > 91) {
                student_num += 25; 
            } else if (gpa > 90) {
                student_num += 22; 
            } else if (gpa > 88) {
                student_num += 21; 
            } else if (gpa > 85) {
                student_num += 16; 
            } else if (gpa > 82.5) {
                student_num += 13; 
            } else if (gpa > 80) {
                student_num += 11; 
            } else if (gpa > 75) {
                student_num += 8; 
            } else if (gpa > 70) {
                student_num += 5; 
            }
            else {
                student_num += 2;
            }
            student_num += extracurriculars * 2;
            student_num += ap_courses * 0.9;
            student_num += interviewScore * 1.5;
            student_num += essayStrength * 1.5;
            student_num -= 4;

        } else {
        // gpa = 35 pts, ec = 15 pts, essay = 15 pts, ap = 12.5pts, interview = 12.5pts, sat/act 15 pts
        if (gpa > 99) {
            student_num += 35;
        } else if (gpa > 98) {
            student_num += 34;
        } else if (gpa > 97) {
            student_num += 33;
        } else if (gpa > 96) {
            student_num += 32;
        } else if (gpa > 95) {
            student_num += 30;
        } else if (gpa > 94) {
            student_num += 28;
        } else if (gpa > 93) {
            student_num += 26;
        } else if (gpa > 92) {
            student_num += 24;
        } else if (gpa > 91) {
            student_num += 22;
        } else if (gpa > 90) {
            student_num += 20;
        } else if (gpa > 88) {
            student_num += 18;
        } else if (gpa > 85) {
            student_num += 15;
        } else if (gpa > 82.5) {
            student_num += 12;
        } else if (gpa > 80) {
            student_num += 10;
        } else if (gpa > 75) {
            student_num += 7;
        } else if (gpa > 70) {
            student_num += 5;
        } else {
            student_num += 3;
        }
    
        student_num += extracurriculars * 1.5;    // 15 pts max
        student_num += ap_courses * 1.25;         // 12.5 pts max
        student_num += interviewScore * 1.25;     // 12.5 pts max
        student_num += essayStrength * 1.5;       // 15 pts max
    
        // SAT/ACT contribution (15 pts max)
        if (sat != -1) {
            if (sat == 1600) {
                student_num += 15;
            } else if (sat >= 1570) {
                student_num += 14;
            } else if (sat >= 1540) {
                student_num += 13;
            } else if (sat >= 1510) {
                student_num += 11.5;
            } else if (sat >= 1490) {
                student_num += 10.5;
            } else if (sat >= 1450) {
                student_num += 9;
            } else if (sat >= 1400) {
                student_num += 6;
            } else if (sat >= 1300) {
                student_num += 3;
            } else {
                student_num += 1;
            }
        } else if (act != -1) {
            if (act == 36) {
                student_num += 15;
            } else if (act >= 35) {
                student_num += 14;
            } else if (act >= 34) {
                student_num += 13;
            } else if (act >= 33) {
                student_num += 12;
            } else if (act >= 32) {
                student_num += 11;
            } else if (act >= 31) {
                student_num += 10;
            } else if (act >= 30) {
                student_num += 9;
            } else if (act >= 29) {
                student_num += 7;
            } else if (act >= 27) {
                student_num += 5;
            } else if (act >= 25) {
                student_num += 3;
            } else if (act >= 23) {
                student_num += 2;
            } else {
                student_num += 1;
            }
        }
        }

        if (demScore > 5) {
            student_num += (demScore - 5);
        } else {
            student_num -= (5 - demScore);
        }

        int tier = classify(student_num);
        double chances = 0;
        if (baseChance < 0.05) { // tier 1
            if (tier == 1) {
                chances = (36 + (Math.random() * 8 - 4 - 2));
            }
            else if (tier == 2) {
                chances =  (27 + (Math.random() * 8 - 4 - 2));
            }
            else if (tier == 3) {
                chances =  (21 + (Math.random() * 8 - 4 - 2));
            }
            else if (tier == 4) {
                chances =  (13 + (Math.random() * 6 - 3 - 2));
            }
            else if (tier == 5) {
                chances =  (4 + (Math.random() * 6 - 3));
            }
            else if (tier == 6) {
                chances =  (2 + (Math.random() * 6 - 3));
            }
            else if (tier == 7) {
                chances =  (1 + (Math.random() * 2 - 1));
            }
            else if (tier == 8) {
                chances =  (0.5 + (Math.random() * 0.4 - 0.2));
            }
            else if (tier == 9) {
                chances =  (0.2 + (Math.random() * 0.2 - 0.1));
            }
            else if (tier == 10) {
                chances =  (0.1);
            }
            else {
                chances =  0.05;
            }
        }
        else if (baseChance < 0.1) { // tier 1
            if (tier == 1) {
                chances = (46 + (Math.random() * 8 - 4 - 2));
            }
            else if (tier == 2) {
                chances =  (34 + (Math.random() * 8 - 4 - 2));
            }
            else if (tier == 3) {
                chances =  (27 + (Math.random() * 8 - 4 - 2));
            }
            else if (tier == 4) {
                chances =  (19 + (Math.random() * 6 - 3 - 2));
            }
            else if (tier == 5) {
                chances =  (12 + (Math.random() * 6 - 3));
            }
            else if (tier == 6) {
                chances =  (6 + (Math.random() * 6 - 3));
            }
            else if (tier == 7) {
                chances =  (2 + (Math.random() * 2 - 1));
            }
            else if (tier == 8) {
                chances =  (0.5 + (Math.random() * 0.4 - 0.2));
            }
            else if (tier == 9) {
                chances =  (0.2 + (Math.random() * 0.2 - 0.1));
            }
            else if (tier == 10) {
                chances =  (0.1);
            }
            else {
                chances =  0.05;
            }
        }
        else if (baseChance < 0.16) { // tier 2
            if (tier == 1) {
                chances =  (57 + (Math.random() * 8 - 4 - 2));
            }
            else if (tier == 2) {
                chances =  (44 + (Math.random() * 6 - 3 - 2));
            }
            else if (tier == 3) {
                chances =  (36 + (Math.random() * 6 - 3 - 2));
            }
            else if (tier == 4) {
                chances =  (27 + (Math.random() * 6 - 3 - 2));
            }
            else if (tier == 5) {
                chances =  (21 + (Math.random() * 6 - 3 - 2));
            }
            else if (tier == 6) {
                chances =  (13 + (Math.random() * 6 - 3 - 2));
            }
            else if (tier == 7) {
                chances =  (7 + (Math.random() * 2 - 1 - 2));
            }
            else if (tier == 8) {
                chances =  (3 + (Math.random() * 0.4 - 0.2 - 2));
            }
            else if (tier == 9) {
                chances =  (2 + (Math.random() * 0.2 - 0.1));
            }
            else if (tier == 10) {
                chances =  (1 + (Math.random() * 0.2 - 0.1));
            }
            else {
                chances =  0.5 + (Math.random() * 0.1 - 0.05);
            }
        }
    
        else if (baseChance < 0.25) { // tier 3
            if (tier == 1) {
                chances =  (67 + (Math.random() * 10 - 5 - 2));
            }
            else if (tier == 2) {
                chances =  (55 + (Math.random() * 8 - 4 - 2));
            }
            else if (tier == 3) {
                chances =  (41 + (Math.random() * 6 - 3 - 2));
            }
            else if (tier == 4) {
                chances =  (34 + (Math.random() * 6 - 3 - 2));
            }
            else if (tier == 5) {
                chances =  (25 + (Math.random() * 6 - 3 - 2));
            }
            else if (tier == 6) {
                chances =  (18 + (Math.random() * 6 - 3 - 2));
            }
            else if (tier == 7) {
                chances =  (11 + (Math.random() * 4 - 2 - 2));
            }
            else if (tier == 8) {
                chances =  (6 + (Math.random() * 2 - 1 - 2));
            }
            else if (tier == 9) {
                chances =  (3 + (Math.random() * 2 - 1 - 2));
            }
            else if (tier == 10) {
                chances =  (2 + (Math.random() * 0.2 - 0.1));
            }
            else {
                chances =  0.7 + (Math.random() * 0.2 - 0.1);
            }
        }
    
        else if (baseChance < 0.35) { // tier 4
            if (tier == 1) {
                chances =  (74 + (Math.random() * 10 - 5 - 2));
            }
            else if (tier == 2) {
                chances =  (67 + (Math.random() * 8 - 4 - 2));
            }
            else if (tier == 3) {
                chances =  (58 + (Math.random() * 8 - 4 - 2));
            }
            else if (tier == 4) {
                chances =  (48 + (Math.random() * 8 - 4 - 2));
            }
            else if (tier == 5) {
                chances =  (39 + (Math.random() * 6 - 3 - 2));
            }
            else if (tier == 6) {
                chances =  (35 + (Math.random() * 6 - 3 - 2));
            }
            else if (tier == 7) {
                chances =  (24 + (Math.random() * 4 - 2 - 2));
            }
            else if (tier == 8) {
                chances =  (21 + (Math.random() * 2 - 1 - 2));
            }
            else if (tier == 9) {
                chances =  (14+ (Math.random() * 2 - 1 - 2));
            }
            else if (tier == 10) {
                chances =  (7 + (Math.random() * 0.2 - 0.1 - 2));
            }
            else {
                return 3 + (Math.random() * 0.2 - 0.1 - 2);
            }
        }

        else if (baseChance < 0.45) { // tier 5
            if (tier == 1) {
                chances =  (79 + (Math.random() * 10 - 5 - 2));
            }
            else if (tier == 2) {
                chances =  (71 + (Math.random() * 8 - 4 - 2));
            }
            else if (tier == 3) {
                chances =  (65 + (Math.random() * 8 - 4 - 2));
            }
            else if (tier == 4) {
                chances =  (56 + (Math.random() * 8 - 4 - 2));
            }
            else if (tier == 5) {
                chances =  (49 + (Math.random() * 6 - 3 - 2));
            }
            else if (tier == 6) {
                chances =  (41 + (Math.random() * 6 - 3 - 2));
            }
            else if (tier == 7) {
                chances =  (33 + (Math.random() * 4 - 2 - 2));
            }
            else if (tier == 8) {
                chances =  (25 + (Math.random() * 2 - 1 - 2));
            }
            else if (tier == 9) {
                chances =  (18 + (Math.random() * 2 - 1 - 2));
            }
            else if (tier == 10) {
                chances =  (12 + (Math.random() * 2 - 1 - 2));
            }
            else {
                chances =  4 + (Math.random() * 0.2 - 0.1 - 2);
            }
        }
    
        else if (baseChance < 0.6) { // tier 6
            if (tier == 1) {
                chances =  (85 + (Math.random() * 12 - 6 - 2));
            }
            else if (tier == 2) {
                chances =  (78 + (Math.random() * 8 - 4 - 2));
            }
            else if (tier == 3) {
                chances =  (71 + (Math.random() * 8 - 4 - 2));
            }
            else if (tier == 4) {
                chances =  (65 + (Math.random() * 8 - 4 - 2));
            }
            else if (tier == 5) {
                chances =  (55 + (Math.random() * 8 - 4 - 2));
            }
            else if (tier == 6) {
                chances = (46 + (Math.random() * 8 - 4 - 2));
            }
            else if (tier == 7) {
                chances =  (36 + (Math.random() * 6 - 3 - 2));
            }
            else if (tier == 8) {
                chances =  (25 + (Math.random() * 4 - 2 - 2));
            }
            else if (tier == 9) {
                chances =  (16 + (Math.random() * 2 - 1 - 2));
            }
            else if (tier == 10) {
                chances =  (7 + (Math.random() * 2 - 1 - 2));
            }
            else {
                chances =  3 + (Math.random() * 2 - 1 - 2);
            }
        }
    
        else if (baseChance < 0.8) { // tier 7
            if (tier == 1) {
                chances =  (90 + (Math.random() * 12 - 6 - 2));
            }
            else if (tier == 2) {
                chances =  (87 + (Math.random() * 8 - 4 - 2));
            }
            else if (tier == 3) {
                chances =  (80 + (Math.random() * 8 - 4 - 2));
            }
            else if (tier == 4) {
                chances =  (74 + (Math.random() * 8 - 4 - 2));
            }
            else if (tier == 5) {
                chances =  (65 + (Math.random() * 8 - 4 - 2));
            }
            else if (tier == 6) {
                chances =  (56 + (Math.random() * 8 - 4 - 2));
            }
            else if (tier == 7) {
                chances =  (45 + (Math.random() * 6 - 3 - 2));
            }
            else if (tier == 8) {
                chances =  (37 + (Math.random() * 4 - 2 - 2));
            }
            else if (tier == 9) {
                chances =  (26 + (Math.random() * 2 - 1 - 2));
            }
            else if (tier == 10) {
                chances =  (16 + (Math.random() * 2 - 1 - 2));
            }
            else {
                chances =  13 + (Math.random() * 2 - 1 - 2);
            }
        }
        else {
            if (tier == 1) {
                chances =  (93 + (Math.random() * 12 - 6 - 2));
            }
            else if (tier == 2) {
                chances =  (87 + (Math.random() * 8 - 4 - 2));
            }
            else if (tier == 3) {
                chances =  (80 + (Math.random() * 8 - 4 - 2));
            }
            else if (tier == 4) {
                chances =  (74 + (Math.random() * 8 - 4 - 2));
            }
            else if (tier == 5) {
                chances =  (65 + (Math.random() * 8 - 4 - 2));
            }
            else if (tier == 6) {
                chances =  (56 + (Math.random() * 8 - 4 - 2));
            }
            else if (tier == 7) {
                chances =  (45 + (Math.random() * 6 - 3 - 2));
            }
            else if (tier == 8) {
                chances =  (37 + (Math.random() * 4 - 2 - 2));
            }
            else if (tier == 9) {
                chances =  (28 + (Math.random() * 2 - 1 - 2));
            }
            else if (tier == 10) {
                chances =  (24 + (Math.random() * 2 - 1 - 2));
            }
            else {
                chances =  18 + (Math.random() * 2 - 1 - 2);
            }
        }

        double multiplier = 1;
        if (app_type.equals("ED")) {
            multiplier = Double.parseDouble(collegeList[i][2]);
        }
        if (app_type.equals("EA")) {
            multiplier = Double.parseDouble(collegeList[i][3]);
        }
        if (app_type.equals("REA")) {
            multiplier = Double.parseDouble(collegeList[i][3]);
        }
        chances *= ((multiplier - 1) / 2) + 1;
        chances -= Math.random() * 4 - 1; 
        // Ensure final chance is between 0 and 100
        if (interviewScore < 2) {
            chances -= Math.random() * 7;
        }
        if (interviewScore > 8) {
            chances += Math.random() * 7;
        }
        if (chances <= 0.0) {
            chances = 0.0;
            chances += Math.random() * 1.5;
        }
        if (chances >= 100.0) {
            chances = 100.0;
            chances -= Math.random() * 3;
        }
        if (chances >= 97) {
            chances -= Math.random() * 6;
        }
        return Math.round(chances * 100.0) / 100.0; 
    }

    // Method to classify the chances based on percentag
    public static String getType(double chance) {
        final String RESET = "\033[0m";
        final String GREEN = "\033[0;32m";
        final String LIME_GREEN = "\033[1;32m";
        final String ORANGE = "\033[0;33m";  // ANSI does not have true orange; using yellow
        final String RED = "\033[0;31m";
        final String DARK_RED = "\033[1;31m";
        final String PURPLE = "\033[0;35m";
    
        if (chance > 80) {
            return GREEN + "Highly Likely" + RESET;
        }
        else if (chance > 65) {
            return LIME_GREEN + "Safety" + RESET;
        }
        else if (chance > 45) {
            return ORANGE + "Target" + RESET;
        }
        else if (chance > 30) {
            return ORANGE + "Hard Target" + RESET;
        }
        else if (chance > 21) {
            return ORANGE + "Competitive" + RESET;
        }
        else if (chance > 12) {
            return RED + "Reach" + RESET;
        }
        else if (chance > 5) {
            return DARK_RED + "Big Reach" + RESET;
        }
        else {
            return PURPLE + "Huge Reach" + RESET;
        }
    }

    public static int classify(double num) {
        if (num >= 96) {
            return 1;
        }
        else if (num >= 92) {
            return 2;
        }
        else if (num >= 87) {
            return 3;
        }
        else if (num >= 83) {
            return 4;
        }
        else if (num >= 76) {
            return 5;
        }
        else if (num >= 70) {
            return 6;
        }
        else if (num >= 63) {
            return 7;
        }
        else if (num >= 51) {
            return 8;
        }
        else if (num >= 39) {
            return 9;
        }
        else if (num >= 30) {
            return 10;
        }
        else {
            return 11;
        }
    }

    public static String admissionsDecision(double chances, String appType, int collegeIndex, ArrayList<String[]> collegesApplied) {
        double yourFate = Math.min(Math.random() * 100, Math.random() * 100) + Math.random() * 15;
        String collegeName = collegesApplied.get(collegeIndex)[0];
        String reset = "\u001B[0m";
        String green = "\u001B[32m";
        String yellow = "\u001B[33m";
        String blue = "\u001B[34m";
        String red = "\u001B[31m";

        if (appType.equals("ED")) {
            if (yourFate < chances - Math.random() * 45) {
                System.out.println(green + "Congratulations! " + reset + "You have been admitted to " + blue + collegeName + reset + " with a scholarship and honors under Early Decision.");
                return "ASH";  // Admitted with Scholarship & Honors
            } else if (yourFate < chances - Math.random() * 22) {
                System.out.println(green + "Excellent news! " + reset + "You have been admitted to " + blue + collegeName + reset + " with a scholarship under Early Decision.");
                return "AS";  // Admitted with Scholarship
            } else if (yourFate < chances) {
                System.out.println("You have been accepted to " + blue + collegeName + reset + " under Early Decision. " + green + "Congratulations!");
                return "A";  // Admitted
            } else if (yourFate < chances + Math.random() * 30) {
                System.out.println("Your application to " + blue + collegeName + reset + " has been" + yellow + " deferred. We encourage you to remain hopeful and patient as the regular decision process continues.");
                return "D";  // Deferred
            } else {
                System.out.println("We regret to inform you that your application to " + blue + collegeName + reset + " has been " + red + "declined. Please remember that this is only one step in your journey, and many opportunities still lie ahead." + reset);
                return "R";  // Rejected
            }
        } else if (appType.equals("REA")) {
            // Regular Early Action section
            if (yourFate < chances - Math.random() * 45) {
                System.out.println(green + "Wonderful news! " + reset + "You have been accepted to " + blue + collegeName + reset + " with a scholarship and honors through Restrictive Early Action.");
                return "ASH";  // Admitted with Scholarship & Honors
            } else if (yourFate < chances - Math.random() * 22) {
                System.out.println(green + "Great news! " + reset + "You have been accepted to " + blue + collegeName + reset + " with a scholarship through Restrictive Early Action.");
                return "AS";  // Admitted with Scholarship
            } else if (yourFate < chances) {
                System.out.println(green + "Congratulations! " + reset + "You have been accepted to " + blue + collegeName + reset + " through Restrictive Early Action.");
                return "A";  // Admitted
            } else if (yourFate < chances + Math.random() * 25) {
                System.out.println("Your application to " + blue + collegeName + reset + " has been" + yellow + " deferred. You'll hear back during the regular decision period.");
                return "D";  // Deferred
            } else {
                System.out.println(red + "Unfortunately, your application to " + blue + collegeName + reset + " has been declined. " + reset + "Please continue pursuing other opportunities.");
                return "R";  // Rejected
            }
        } else if (appType.equals("EA")) {
            // Early Action section
            if (yourFate < chances - Math.random() * 45) {
                System.out.println(green + "Fantastic! " + reset + "You have been accepted to " + blue + collegeName + reset + " with a scholarship and honors under Early Action.");
                return "ASH";  // Admitted with Scholarship & Honors
            } else if (yourFate < chances - Math.random() * 22) {
                System.out.println(green + "Great news! " + reset + "You have been accepted to " + blue + collegeName + reset + " with a scholarship under Early Action.");
                return "AS";  // Admitted with Scholarship
            } else if (yourFate < chances) {
                System.out.println(green + "Congratulations! " + reset + "You have been accepted to " + blue + collegeName + reset + " under Early Action.");
                return "A";  // Admitted
            } else if (yourFate < chances + Math.random() * 20) {
                System.out.println(yellow + "Your application to " + blue + collegeName + reset + " has been deferred. You will receive your final decision in the regular decision round.");
                return "D";  // Deferred
            } else {
                System.out.println(red + "Unfortunately, your application to " + blue + collegeName + reset + " has been declined. " + reset + "Please continue pursuing your academic goals.");
                return "R";  // Rejected
            }
        } else if (appType.equals("RD")) {
            // Regular Decision section
            if (yourFate < chances - Math.random() * 45) {
                System.out.println(green + "Congratulations! " + reset + "You have been accepted to " + blue + collegeName + reset + " with a scholarship and honors under Regular Decision.");
                return "ASH";  // Admitted with Scholarship & Honors
            } else if (yourFate < chances - Math.random() * 22) {
                System.out.println(green + "Great news! " + reset + "You have been accepted to " + blue + collegeName + reset + " with a scholarship under Regular Decision.");
                return "AS";  // Admitted with Scholarship
            } else if (yourFate < chances) {
                System.out.println(green + "Congratulations! " + reset + "You have been accepted to " + blue + collegeName + reset + " under Regular Decision.");
                return "A";  // Admitted
            } else if (yourFate < chances + Math.random() * 20) {
                System.out.println(yellow + "You have been placed on the waitlist for " + blue + collegeName + reset + ". You may be offered a spot if space becomes available.");
                return "W";  // Waitlisted
            } else {
                System.out.println(red + "Unfortunately, your application to " + blue + collegeName + reset + " has been declined. " + reset + "We encourage you to pursue other great opportunities.");
                return "R";  // Rejected
            }
        } else if (appType.equals("Waitlist")) {
            // Waitlist section
            if (yourFate < chances) {
                System.out.println(green + "Congratulations! " + reset + "You have been accepted to " + blue + collegeName + reset + " off the waitlist.");
                return "A";  // Accepted off the waitlist
            } else {
                System.out.println(red + "Unfortunately, your application to " + blue + collegeName + reset + " has been declined from the waitlist. " + reset + "We encourage you to explore other opportunities.");
                return "R";  // Rejected from the waitlist
            }
        }
        
        
        return "NO";
    }
}