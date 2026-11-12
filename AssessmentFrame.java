
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AssessmentFrame extends JFrame {

    private JTextField nameField;
    private JComboBox<String> strandBox;
    private JComboBox<AssessmentOption>[] answers;

    private Question[] questions = {
        new InterestQuestion("1. Which activity interests you the most?"),
        new InterestQuestion("2. Which school subject do you enjoy the most?"),
        new InterestQuestion("3. What type of problem would you enjoy solving?"),
        new InterestQuestion("4. Which activity would you prefer during your free time?"),
        new InterestQuestion("5. What kind of working environment do you prefer?"),
        new SkillQuestion("6. Which skill would you like to develop?"),
        new SkillQuestion("7. Which career interests you the most?")
    };

    private AssessmentOption[][] questionChoices = {

        // Question 1
        {
            new AssessmentOption("TECH", "Creating websites and applications"),
            new AssessmentOption("LOGIC", "Solving mathematical puzzles"),
            new AssessmentOption("PEOPLE", "Understanding people's behavior"),
            new AssessmentOption("FINANCE", "Managing money and budgets"),
            new AssessmentOption("BUSINESS", "Starting a business"),
            new AssessmentOption("HEALTH", "Helping sick people"),
            new AssessmentOption("MECHANICAL", "Repairing machines"),
            new AssessmentOption("CIVIL", "Designing buildings and structures"),
            new AssessmentOption("ELECTRICAL", "Working with electrical systems"),
            new AssessmentOption("AUTO", "Maintaining and repairing vehicles")
        },

        // Question 2
        {
            new AssessmentOption("TECH", "Computer and Information Technology"),
            new AssessmentOption("LOGIC", "Mathematics"),
            new AssessmentOption("PEOPLE", "Social Studies and Psychology"),
            new AssessmentOption("FINANCE", "Accounting"),
            new AssessmentOption("BUSINESS", "Business and Entrepreneurship"),
            new AssessmentOption("HEALTH", "Biology and Health Science"),
            new AssessmentOption("MECHANICAL", "Mechanical Technology"),
            new AssessmentOption("CIVIL", "Technical Drawing and Design"),
            new AssessmentOption("ELECTRICAL", "Physics and Electronics"),
            new AssessmentOption("AUTO", "Automotive Technology")
        },

        // Question 3
        {
            new AssessmentOption("TECH", "Computer and software problems"),
            new AssessmentOption("LOGIC", "Complex calculations and logical problems"),
            new AssessmentOption("PEOPLE", "Personal and behavioral problems"),
            new AssessmentOption("FINANCE", "Financial and budgeting problems"),
            new AssessmentOption("BUSINESS", "Business and management challenges"),
            new AssessmentOption("HEALTH", "Health-related problems"),
            new AssessmentOption("MECHANICAL", "Machine and mechanical problems"),
            new AssessmentOption("CIVIL", "Construction and structural problems"),
            new AssessmentOption("ELECTRICAL", "Electrical and electronic problems"),
            new AssessmentOption("AUTO", "Vehicle engine and repair problems")
        },

        // Question 4
        {
            new AssessmentOption("TECH", "Learning computer programming"),
            new AssessmentOption("LOGIC", "Playing strategy and logic games"),
            new AssessmentOption("PEOPLE", "Reading about human behavior"),
            new AssessmentOption("FINANCE", "Organizing personal expenses"),
            new AssessmentOption("BUSINESS", "Planning a small business"),
            new AssessmentOption("HEALTH", "Learning about health and first aid"),
            new AssessmentOption("MECHANICAL", "Exploring how machines work"),
            new AssessmentOption("CIVIL", "Sketching buildings and structures"),
            new AssessmentOption("ELECTRICAL", "Exploring circuits and electronics"),
            new AssessmentOption("AUTO", "Learning about vehicle engines")
        },

        // Question 5
        {
            new AssessmentOption("TECH", "Technology and software companies"),
            new AssessmentOption("LOGIC", "Research and analytical workplaces"),
            new AssessmentOption("PEOPLE", "Schools and counseling centers"),
            new AssessmentOption("FINANCE", "Banks and accounting offices"),
            new AssessmentOption("BUSINESS", "Business offices and organizations"),
            new AssessmentOption("HEALTH", "Hospitals and healthcare facilities"),
            new AssessmentOption("MECHANICAL", "Manufacturing and machine workshops"),
            new AssessmentOption("CIVIL", "Construction sites"),
            new AssessmentOption("ELECTRICAL", "Electrical and industrial facilities"),
            new AssessmentOption("AUTO", "Automotive service centers")
        },

        // Question 6
        {
            new AssessmentOption("TECH", "Programming and web development"),
            new AssessmentOption("LOGIC", "Analytical and computational thinking"),
            new AssessmentOption("PEOPLE", "Communication and understanding people"),
            new AssessmentOption("FINANCE", "Financial analysis and accounting"),
            new AssessmentOption("BUSINESS", "Leadership and entrepreneurship"),
            new AssessmentOption("HEALTH", "Patient care and medical knowledge"),
            new AssessmentOption("MECHANICAL", "Mechanical troubleshooting"),
            new AssessmentOption("CIVIL", "Technical drawing and structural design"),
            new AssessmentOption("ELECTRICAL", "Electrical troubleshooting"),
            new AssessmentOption("AUTO", "Automotive diagnostics and maintenance")
        },

        // Question 7
        {
            new AssessmentOption("TECH", "IT Specialist or Web Developer"),
            new AssessmentOption("LOGIC", "Software Engineer or Data Scientist"),
            new AssessmentOption("PEOPLE", "Psychologist or Counselor"),
            new AssessmentOption("FINANCE", "Accountant or Auditor"),
            new AssessmentOption("BUSINESS", "Business Manager or Entrepreneur"),
            new AssessmentOption("HEALTH", "Nurse or Healthcare Professional"),
            new AssessmentOption("MECHANICAL", "Mechanical Engineer"),
            new AssessmentOption("CIVIL", "Civil Engineer"),
            new AssessmentOption("ELECTRICAL", "Electrical Engineer"),
            new AssessmentOption("AUTO", "Automotive Technician")
        }
    };

    public AssessmentFrame() {

        setTitle("EduPath - Student Assessment");
        setSize(750, 650);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(245, 247, 250));

        // Header
        JLabel title = new JLabel("Student Assessment");
        title.setFont(new Font("Arial", Font.BOLD, 27));
        title.setForeground(new Color(35, 55, 90));

        JLabel subtitle = new JLabel(
            "Tell us about yourself and your interests."
        );

        JPanel header = new JPanel(new GridLayout(2, 1));
        header.setBackground(new Color(245, 247, 250));
        header.add(title);
        header.add(subtitle);

        // Form panel
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBackground(Color.WHITE);
        formPanel.setBorder(
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        );

        // Student name
        JLabel nameLabel = new JLabel("Student Name:");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 14));

        nameField = new JTextField();
        nameField.setMaximumSize(new Dimension(
            Integer.MAX_VALUE, 35
        ));

        // Strand selection
        JLabel strandLabel = new JLabel("Senior High School Strand:");
        strandLabel.setFont(new Font("Arial", Font.BOLD, 14));

        String[] strands = {
            "STEM", "ABM", "HUMSS", "GAS",
            "TVL", "Arts and Design", "Sports"
        };

        strandBox = new JComboBox<>(strands);
        strandBox.setMaximumSize(new Dimension(
            Integer.MAX_VALUE, 35
        ));

        formPanel.add(nameLabel);
        formPanel.add(Box.createVerticalStrut(5));
        formPanel.add(nameField);
        formPanel.add(Box.createVerticalStrut(15));

        formPanel.add(strandLabel);
        formPanel.add(Box.createVerticalStrut(5));
        formPanel.add(strandBox);
        formPanel.add(Box.createVerticalStrut(20));

        // Assessment questions
        @SuppressWarnings("unchecked")
        JComboBox<AssessmentOption>[] questionAnswers =
            (JComboBox<AssessmentOption>[]) new JComboBox<?>[questions.length];

        answers = questionAnswers;

        for (int i = 0; i < questions.length; i++) {

            JLabel questionLabel =
                new JLabel(questions[i].getPrompt());

            questionLabel.setFont(
                new Font("Arial", Font.BOLD, 14)
            );

            answers[i] = new JComboBox<>(questionChoices[i]);

            answers[i].setMaximumSize(new Dimension(
                Integer.MAX_VALUE, 35
            ));

            formPanel.add(questionLabel);
            formPanel.add(Box.createVerticalStrut(5));
            formPanel.add(answers[i]);
            formPanel.add(Box.createVerticalStrut(15));
        }

        // Scroll panel
        JScrollPane scrollPane = new JScrollPane(formPanel);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        // Buttons
        JButton submitButton = new JButton("Submit Assessment");
        JButton backButton = new JButton("Back");

        styleButton(submitButton);
        styleButton(backButton);

        submitButton.addActionListener(e -> submitAssessment());
        backButton.addActionListener(e -> dispose());

        JPanel buttonPanel = new JPanel(
            new FlowLayout(FlowLayout.RIGHT)
        );

        buttonPanel.setBackground(new Color(245, 247, 250));
        buttonPanel.add(backButton);
        buttonPanel.add(submitButton);

        // Add components to main panel
        mainPanel.add(header, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
    }

    private void submitAssessment() {

        String name = nameField.getText().trim();
        String strand = (String) strandBox.getSelectedItem();

        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(
                this,
                "Please enter your name.",
                "Missing Information",
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        Student student = new Student(name, strand);

        String[] studentAnswers = new String[answers.length];

        for (int i = 0; i < answers.length; i++) {

            AssessmentOption selected =
                (AssessmentOption) answers[i].getSelectedItem();

            studentAnswers[i] = selected.getCategory();
        }

        RecommendationEngine engine = new RecommendationEngine();

        ArrayList<Recommendation> recommendations =
            engine.generateRecommendations(
                CourseData.getCourses(),
                studentAnswers
            );

        new ResultFrame(student, recommendations);
        dispose();
    }

    private void styleButton(JButton button) {

        button.setFont(new Font("Arial", Font.BOLD, 13));
        button.setBackground(new Color(35, 55, 90));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
    }
}
