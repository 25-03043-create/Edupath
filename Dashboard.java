
import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame {

    public Dashboard() {

        // Window settings
        setTitle("EduPath - Course Recommendation System");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(245, 247, 250));

        // Header
        JPanel header = new JPanel();
        header.setBackground(new Color(35, 55, 90));
        header.setPreferredSize(new Dimension(900, 90));
        header.setLayout(new GridLayout(2, 1));

        JLabel title = new JLabel("  EDUPATH");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 28));

        JLabel subtitle = new JLabel(
            "  College Course Discovery and Recommendation System"
        );
        subtitle.setForeground(Color.WHITE);
        subtitle.setFont(new Font("Arial", Font.PLAIN, 13));

        header.add(title);
        header.add(subtitle);

        // Center content
        JPanel content = new JPanel();
        content.setBackground(new Color(245, 247, 250));
        content.setLayout(new GridLayout(5, 1, 10, 10));
        content.setBorder(
            BorderFactory.createEmptyBorder(60, 200, 60, 200)
        );

        JLabel welcome = new JLabel(
            "Welcome to EduPath!",
            SwingConstants.CENTER
        );
        welcome.setFont(new Font("Arial", Font.BOLD, 26));

        JLabel description = new JLabel(
            "Discover the college course that matches your interests.",
            SwingConstants.CENTER
        );
        description.setFont(new Font("Arial", Font.PLAIN, 13));

        JButton assessmentButton = new JButton("Start Assessment");
        JButton coursesButton = new JButton("Explore College Courses");
        JButton careerButton = new JButton("Career Information");
        JButton exitButton = new JButton("Exit");

        // Button styling
        styleButton(assessmentButton);
        styleButton(coursesButton);
        styleButton(careerButton);
        styleButton(exitButton);

        // Button actions
        assessmentButton.addActionListener(e ->
            new AssessmentFrame()
    );
        coursesButton.addActionListener(e ->
            new CourseListFrame()
    );

        careerButton.addActionListener(e ->
            JOptionPane.showMessageDialog(
                this, "Career information module coming soon!"
            )
        );

        exitButton.addActionListener(e -> dispose());

        // Add components
        content.add(welcome);
        content.add(description);
        content.add(assessmentButton);
        content.add(coursesButton);
        content.add(careerButton);

        // Footer
        JLabel footer = new JLabel(
            "EduPath | Helping Students Plan Their Future",
            SwingConstants.CENTER
        );
        footer.setPreferredSize(new Dimension(900, 40));

        mainPanel.add(header, BorderLayout.NORTH);
        mainPanel.add(content, BorderLayout.CENTER);
        mainPanel.add(footer, BorderLayout.SOUTH);

        add(mainPanel);

        setVisible(true);
    }

    // Reusable button styling method
    private void styleButton(JButton button) {
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(new Color(35, 55, 90));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
}
