public class collegeChances {
    public static double chances(int college, double GPA, int SAT, int ACT, double extracurriculars, double courseRigor, double essayStrength, double interview) {
        double num = getStudentNum(GPA, SAT, ACT, extracurriculars, courseRigor, essayStrength, interview);
        int tier = getStudentTier(num);
        if (college >= 1 && college <= 4) { // tier 1
            if (tier == 1) {
                return (41 + (Math.random() * 8 - 4 - 2));
            }
            else if (tier == 2) {
                return (34 + (Math.random() * 8 - 4 - 2));
            }
            else if (tier == 3) {
                return (23 + (Math.random() * 8 - 4 - 2));
            }
            else if (tier == 4) {
                return (12 + (Math.random() * 6 - 3 - 2));
            }
            else if (tier == 5) {
                return (4 + (Math.random() * 6 - 3));
            }
            else if (tier == 6) {
                return (2 + (Math.random() * 6 - 3));
            }
            else if (tier == 7) {
                return (1 + (Math.random() * 2 - 1));
            }
            else if (tier == 8) {
                return (0.5 + (Math.random() * 0.4 - 0.2));
            }
            else if (tier == 9) {
                return (0.2 + (Math.random() * 0.2 - 0.1));
            }
            else if (tier == 10) {
                return (0.1);
            }
            else {
                return 0.05;
            }
        }
    
        else if (college >= 5 && college <= 13) { // tier 2
            if (tier == 1) {
                return (50 + (Math.random() * 8 - 4 - 2));
            }
            else if (tier == 2) {
                return (44 + (Math.random() * 6 - 3 - 2));
            }
            else if (tier == 3) {
                return (33 + (Math.random() * 6 - 3 - 2));
            }
            else if (tier == 4) {
                return (22 + (Math.random() * 6 - 3 - 2));
            }
            else if (tier == 5) {
                return (15 + (Math.random() * 6 - 3 - 2));
            }
            else if (tier == 6) {
                return (9 + (Math.random() * 6 - 3 - 2));
            }
            else if (tier == 7) {
                return (5 + (Math.random() * 2 - 1 - 2));
            }
            else if (tier == 8) {
                return (3 + (Math.random() * 0.4 - 0.2 - 2));
            }
            else if (tier == 9) {
                return (2 + (Math.random() * 0.2 - 0.1));
            }
            else if (tier == 10) {
                return (1 + (Math.random() * 0.2 - 0.1));
            }
            else {
                return 0.5 + (Math.random() * 0.1 - 0.05);
            }
        }
    
        else if (college >= 14 && college <= 23) { // tier 3
            if (tier == 1) {
                return (60 + (Math.random() * 10 - 5 - 2));
            }
            else if (tier == 2) {
                return (53 + (Math.random() * 8 - 4 - 2));
            }
            else if (tier == 3) {
                return (45 + (Math.random() * 6 - 3 - 2));
            }
            else if (tier == 4) {
                return (36 + (Math.random() * 6 - 3 - 2));
            }
            else if (tier == 5) {
                return (27 + (Math.random() * 6 - 3 - 2));
            }
            else if (tier == 6) {
                return (22 + (Math.random() * 6 - 3 - 2));
            }
            else if (tier == 7) {
                return (17 + (Math.random() * 4 - 2 - 2));
            }
            else if (tier == 8) {
                return (10 + (Math.random() * 2 - 1 - 2));
            }
            else if (tier == 9) {
                return (4 + (Math.random() * 2 - 1 - 2));
            }
            else if (tier == 10) {
                return (2 + (Math.random() * 0.2 - 0.1));
            }
            else {
                return 0.7 + (Math.random() * 0.2 - 0.1);
            }
        }
    
        else if (college >= 23 && college <= 37) { // tier 4
            if (tier == 1) {
                return (68 + (Math.random() * 10 - 5 - 2));
            }
            else if (tier == 2) {
                return (60 + (Math.random() * 8 - 4 - 2));
            }
            else if (tier == 3) {
                return (53 + (Math.random() * 8 - 4 - 2));
            }
            else if (tier == 4) {
                return (46 + (Math.random() * 8 - 4 - 2));
            }
            else if (tier == 5) {
                return (41 + (Math.random() * 6 - 3 - 2));
            }
            else if (tier == 6) {
                return (35 + (Math.random() * 6 - 3 - 2));
            }
            else if (tier == 7) {
                return (27 + (Math.random() * 4 - 2 - 2));
            }
            else if (tier == 8) {
                return (21 + (Math.random() * 2 - 1 - 2));
            }
            else if (tier == 9) {
                return (14+ (Math.random() * 2 - 1 - 2));
            }
            else if (tier == 10) {
                return (7 + (Math.random() * 0.2 - 0.1 - 2));
            }
            else {
                return 3 + (Math.random() * 0.2 - 0.1 - 2);
            }
        }

        else if (college >= 38 && college <= 57) { // tier 5
            if (tier == 1) {
                return (77 + (Math.random() * 10 - 5 - 2));
            }
            else if (tier == 2) {
                return (71 + (Math.random() * 8 - 4 - 2));
            }
            else if (tier == 3) {
                return (65 + (Math.random() * 8 - 4 - 2));
            }
            else if (tier == 4) {
                return (56 + (Math.random() * 8 - 4 - 2));
            }
            else if (tier == 5) {
                return (49 + (Math.random() * 6 - 3 - 2));
            }
            else if (tier == 6) {
                return (41 + (Math.random() * 6 - 3 - 2));
            }
            else if (tier == 7) {
                return (33 + (Math.random() * 4 - 2 - 2));
            }
            else if (tier == 8) {
                return (25 + (Math.random() * 2 - 1 - 2));
            }
            else if (tier == 9) {
                return (18 + (Math.random() * 2 - 1 - 2));
            }
            else if (tier == 10) {
                return (12 + (Math.random() * 2 - 1 - 2));
            }
            else {
                return 4 + (Math.random() * 0.2 - 0.1 - 2);
            }
        }
    
        else if (college >= 58 && college <= 74) { // tier 6
            if (tier == 1) {
                return (88 + (Math.random() * 12 - 6 - 2));
            }
            else if (tier == 2) {
                return (81 + (Math.random() * 8 - 4 - 2));
            }
            else if (tier == 3) {
                return (73 + (Math.random() * 8 - 4 - 2));
            }
            else if (tier == 4) {
                return (65 + (Math.random() * 8 - 4 - 2));
            }
            else if (tier == 5) {
                return (57 + (Math.random() * 8 - 4 - 2));
            }
            else if (tier == 6) {
                return (46 + (Math.random() * 8 - 4 - 2));
            }
            else if (tier == 7) {
                return (39 + (Math.random() * 6 - 3 - 2));
            }
            else if (tier == 8) {
                return (29 + (Math.random() * 4 - 2 - 2));
            }
            else if (tier == 9) {
                return (19 + (Math.random() * 2 - 1 - 2));
            }
            else if (tier == 10) {
                return (9 + (Math.random() * 2 - 1 - 2));
            }
            else {
                return 3 + (Math.random() * 2 - 1 - 2);
            }
        }
    
        else if (college >= 75) { // tier 7
            if (tier == 1) {
                return (93 + (Math.random() * 12 - 6 - 2));
            }
            else if (tier == 2) {
                return (87 + (Math.random() * 8 - 4 - 2));
            }
            else if (tier == 3) {
                return (80 + (Math.random() * 8 - 4 - 2));
            }
            else if (tier == 4) {
                return (74 + (Math.random() * 8 - 4 - 2));
            }
            else if (tier == 5) {
                return (65 + (Math.random() * 8 - 4 - 2));
            }
            else if (tier == 6) {
                return (56 + (Math.random() * 8 - 4 - 2));
            }
            else if (tier == 7) {
                return (45 + (Math.random() * 6 - 3 - 2));
            }
            else if (tier == 8) {
                return (37 + (Math.random() * 4 - 2 - 2));
            }
            else if (tier == 9) {
                return (28 + (Math.random() * 2 - 1 - 2));
            }
            else if (tier == 10) {
                return (24 + (Math.random() * 2 - 1 - 2));
            }
            else {
                return 18 + (Math.random() * 2 - 1 - 2);
            }
        }
        else {
            return 0;
        }
    }

    public static String getType(double chance) {
        if (chance > 80) {
            return "Highly Likely";
        }
        else if (chance > 65) {
            return "Safety";
        }
        else if (chance > 45) {
            return  "Target";
        }
        else if (chance > 30) {
            return "Hard Target";
        }
        else if (chance > 20) {
            return "Competitive";
        }
        else if (chance > 12) {
            return "Reach";
        }
        else if (chance > 4) {
            return "High Reach";
        }
        else {
            return "Incredibly High Reach";
        }
    }

    public static double getStudentNum(double GPA, int SAT, int ACT, double extracurriculars, double courseRigor, double essayStrength, double interview) {
        double num = 0;
        // GPA 25 pts, SAT 15 pts, EC 25 pts, essay 15 pts, interview 10 pts, rigor 10 pts
        if (GPA == 100) {
            num += 25;
        }
        else if (GPA >= 99) {
            num += 24.2;
        }
        else if (GPA >= 98) {
            num += 22.7;
        }
        else if (GPA >= 97) {
            num += 21.8;
        }
        else if (GPA >= 96) {
            num += 20.7;
        }
        else if (GPA >= 95) {
            num += 20;
        }
        else if (GPA >= 94) {
            num += 19;
        }
        else if (GPA >= 92) {
            num += 17;
        }
        else if (GPA >= 90) {
            num += 15;
        }
        else if (GPA >= 88) {
            num += 12.5;
        }
        else if (GPA >= 85) {
            num += 9;
        }
        else if (GPA >= 81) {
            num += 6;
        }
        else if (GPA >= 75) {
            num += 3;
        }
        else if (GPA >= 65) {
            num += 1;
        }

    if (SAT > ACT * 44.4) {    
        if (SAT == 1600) {
            num += 15;
        }
        else if (SAT >= 1590) {
            num += 14.5;
        }
        else if (SAT >= 1570) {
            num += 14;
        }
        else if (SAT >= 1550) {
            num += 13.5;
        }
        else if (SAT >= 1520) {
            num += 12.5;
        }
        else if (SAT >= 1490) {
            num += 11.5;
        }
        else if (SAT >= 1460) {
            num += 10;
        }
        else if (SAT >= 1430) {
            num += 8.5;
        }
        else if (SAT >= 1390) {
            num += 7.5;
        }
        else if (SAT >= 1320) {
            num += 6;
        }
        else if (SAT >= 1220) {
            num += 4.5;
        }
        else if (SAT >= 1120) {
            num += 3.5;
        }
        else if (SAT >= 1020) {
            num += 2.5;
        }
        else if (SAT >= 800) {
            num += 1.5;
        } 
    else {
        num += 0.5;
    }}
    // ACT points
else if (44.4 * ACT > SAT) {
    if (ACT == 36) {
        num += 15;
    } else if (ACT >= 35) {
        num += 14.5;
    } else if (ACT >= 34) {
        num += 14;
    } else if (ACT >= 33) {
        num += 13.5;
    } else if (ACT >= 32) {
        num += 12.5;
    } else if (ACT >= 31) {
        num += 11.5;
    } else if (ACT >= 30) {
        num += 10.3;
    } else if (ACT >= 29) {
        num += 9.4;
    } else if (ACT >= 28) {
        num += 8.8;
    } else if (ACT >= 27) {
        num += 7.7;
    } else if (ACT >= 26) {
        num += 6.4;
    } else if (ACT >= 25) {
        num += 5.6;
    } else if (ACT >= 24) {
        num += 4.8;
    } else if (ACT >= 23) {
        num += 4;
    } else if (ACT >= 22) {
        num += 3.4;
    }
    else {
        num++;
    }
}

        num += essayStrength * 1.5;
        num += extracurriculars * 2.5;
        num += interview;
        num += courseRigor;
    
        return num + Math.random() * 4 - 2;
    }

    public static int getStudentTier(double num) {
        if (num >= 97) {
            return 1;
        }
        else if (num >= 94) {
            return 2;
        }
        else if (num >= 91) {
            return 3;
        }
        else if (num >= 87) {
            return 4;
        }
        else if (num >= 82) {
            return 5;
        }
        else if (num >= 76) {
            return 6;
        }
        else if (num >= 68) {
            return 7;
        }
        else if (num >= 57) {
            return 8;
        }
        else if (num >= 44) {
            return 9;
        }
        else if (num >= 28) {
            return 10;
        }
        else {
            return 11;
        }
    }
}