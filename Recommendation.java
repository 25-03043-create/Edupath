
public class Recommendation {

    private Course course;
    private double compatibilityScore;

    public Recommendation(Course course, double compatibilityScore) {
        this.course = course;
        this.compatibilityScore = compatibilityScore;
    }

    public Course getCourse() {
        return course;
    }

    public double getCompatibilityScore() {
        return compatibilityScore;
    }
}
