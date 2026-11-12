
public class SkillQuestion extends Question {

    public SkillQuestion(String prompt) {
        super(prompt);
    }

    @Override
    public String getQuestionType() {
        return "Skill";
    }
}
