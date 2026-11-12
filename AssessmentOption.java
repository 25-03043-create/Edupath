
public class AssessmentOption {

    private String category;
    private String label;

    public AssessmentOption(String category, String label) {
        this.category = category;
        this.label = label;
    }

    public String getCategory() {
        return category;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return label;
    }
}
