
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ResultFrame extends JFrame {

    public ResultFrame(
            Student student,
            ArrayList<Recommendation> recommendations) {

        setTitle("EduPath - Your Recommendations");
        setSize(850, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout(15, 15));
        mainPanel.setBackground(new Color(245, 247, 250));
        mainPanel.setBorder(
            BorderFactory.createEmptyBorder(25, 30, 25, 30)
        );

        JLabel title = new JLabel("Your Top 3 Course Recommendations");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setForeground(new Color(35, 55, 90));

        JLabel greeting = new JLabel(
            "Hello, " + student.getName() +
            "! Here are your recommended courses."
        );

        JPanel header = new JPanel(new GridLayout(2, 1, 5, 5));
        header.setBackground(new Color(245, 247, 250));
        header.add(title);
        header.add(greeting);

        JPanel resultsPanel = new JPanel();
        resultsPanel.setLayout(
            new BoxLayout(resultsPanel, BoxLayout.Y_AXIS)
        );
        resultsPanel.setBackground(Color.WHITE);
        resultsPanel.setBorder(
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        );

        int limit = Math.min(3, recommendations.size());

        for (int i = 0; i < limit; i++) {

            Recommendation recommendation = recommendations.get(i);
            Course course = recommendation.getCourse();

            JPanel card = new JPanel(new BorderLayout(10, 10));
            card.setBackground(new Color(245, 247, 250));
            card.setBorder(
                BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(
                        new Color(210, 215, 225)
                    ),
                    BorderFactory.createEmptyBorder(15, 15, 15, 15)
                )
            );

            JLabel courseName = new JLabel(
                (i + 1) + ". " + course.getCourseName()
            );
            courseName.setFont(
                new Font("Arial", Font.BOLD, 17)
            );

            JLabel score = new JLabel(
                String.format(
                    "Compatibility: %.0f%%",
                    recommendation.getCompatibilityScore()
                )
            );
            score.setFont(
                new Font("Arial", Font.BOLD, 15)
            );
            score.setForeground(new Color(35, 110, 75));

            JTextArea description = new JTextArea(
                course.getDescription() +
                "\nPossible Careers: " + course.getCareers()
            );
            description.setEditable(false);
            description.setLineWrap(true);
            description.setWrapStyleWord(true);
            description.setBackground(new Color(245, 247, 250));
            description.setFont(new Font("Arial", Font.PLAIN, 13));

            JPanel top = new JPanel(new BorderLayout());
            top.setOpaque(false);
            top.add(courseName, BorderLayout.WEST);
            top.add(score, BorderLayout.EAST);

            card.add(top, BorderLayout.NORTH);
            card.add(description, BorderLayout.CENTER);

            card.setMaximumSize(new Dimension(
                Integer.MAX_VALUE, 125
            ));

            resultsPanel.add(card);
            resultsPanel.add(Box.createVerticalStrut(15));
        }

        JLabel note = new JLabel(
            "Note: These results are guidance based on your selected interests."
        );
        note.setFont(new Font("Arial", Font.ITALIC, 12));

        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> dispose());

        JPanel bottom = new JPanel(new BorderLayout());
        bottom.setBackground(new Color(245, 247, 250));
        bottom.add(note, BorderLayout.CENTER);
        bottom.add(closeButton, BorderLayout.EAST);

        mainPanel.add(header, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(resultsPanel), BorderLayout.CENTER);
        mainPanel.add(bottom, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
    }
}
