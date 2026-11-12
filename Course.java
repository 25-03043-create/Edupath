
public class Course {

    // Encapsulated attributes
    private String courseCode;
    private String courseName;
    private String description;
    private String careers;
    private String estimatedSalary;

    // Constructor
    public Course(String courseCode, String courseName,
                  String description, String careers,
                  String estimatedSalary) {

        this.courseCode = courseCode;
        this.courseName = courseName;
        this.description = description;
        this.careers = careers;
        this.estimatedSalary = estimatedSalary;
    }

    // Getters
    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getDescription() {
        return description;
    }

    public String getCareers() {
        return careers;
    }

    public String getEstimatedSalary() {
        return estimatedSalary;
    }

    // Display name in the course list
    @Override
    public String toString() {
        return courseCode + " - " + courseName;
    }
}
