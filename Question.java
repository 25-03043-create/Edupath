
public abstract class Question {

    private String prompt;

    public Question(String prompt) {
        this.prompt = prompt;
    }

    public String getPrompt() {
        return prompt;
    }

    // Abstract method
    public abstract String getQuestionType();
}
