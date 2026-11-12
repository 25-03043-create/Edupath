
import java.util.ArrayList;
import java.util.Comparator;

public class RecommendationEngine {

    private int getCourseWeight(String courseCode, String category) {

        switch (courseCode) {

            case "BSIT":
                switch (category) {
                    case "TECH": return 5;
                    case "LOGIC": return 3;
                    case "ELECTRICAL": return 1;
                }
                break;

            case "BSCS":
                switch (category) {
                    case "TECH": return 4;
                    case "LOGIC": return 5;
                }
                break;

            case "BSPsych":
                switch (category) {
                    case "PEOPLE": return 5;
                    case "HEALTH": return 2;
                }
                break;

            case "BSA":
                switch (category) {
                    case "FINANCE": return 5;
                    case "LOGIC": return 3;
                    case "BUSINESS": return 2;
                }
                break;

            case "BSBA":
                switch (category) {
                    case "BUSINESS": return 5;
                    case "PEOPLE": return 2;
                    case "FINANCE": return 2;
                }
                break;

            case "BSN":
                switch (category) {
                    case "HEALTH": return 5;
                    case "PEOPLE": return 3;
                }
                break;

            case "BSME":
                switch (category) {
                    case "MECHANICAL": return 5;
                    case "LOGIC": return 3;
                    case "ELECTRICAL": return 2;
                }
                break;

            case "BSCE":
                switch (category) {
                    case "CIVIL": return 5;
                    case "LOGIC": return 3;
                    case "MECHANICAL": return 1;
                }
                break;

            case "BSEE":
                switch (category) {
                    case "ELECTRICAL": return 5;
                    case "LOGIC": return 4;
                    case "TECH": return 2;
                }
                break;

            case "BSAT":
                switch (category) {
                    case "AUTO": return 5;
                    case "MECHANICAL": return 4;
                    case "ELECTRICAL": return 2;
                }
                break;
        }

        return 0;
    }

    public ArrayList<Recommendation> generateRecommendations(
            Course[] courses, String[] answers) {

        ArrayList<Recommendation> results = new ArrayList<>();

        for (Course course : courses) {

            double totalScore = 0;

            for (String answer : answers) {
                totalScore += getCourseWeight(
                    course.getCourseCode(), answer
                );
            }

            double percentage =
                (totalScore / (answers.length * 5.0)) * 100;

            results.add(new Recommendation(course, percentage));
        }

        results.sort(
            Comparator.comparingDouble(
                Recommendation::getCompatibilityScore
            ).reversed()
        );

        return results;
    }
}
