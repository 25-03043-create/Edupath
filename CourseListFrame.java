
import javax.swing.*;
import java.awt.*;

public class CourseListFrame extends JFrame {

    private Course[] courses;
    private JList<Course> courseList;
    private JTextArea detailsArea;

    public CourseListFrame() {

        setTitle("EduPath - College Courses");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Initialize 10 courses
        courses = CourseData.getCourses();

        // Main panel
        JPanel mainPanel = new JPanel(new BorderLayout(15, 15));
        mainPanel.setBackground(new Color(245, 247, 250));
        mainPanel.setBorder(
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        );

        // Header
        JLabel title = new JLabel("Explore College Courses");
        title.setFont(new Font("Arial", Font.BOLD, 26));
        title.setForeground(new Color(35, 55, 90));

        JLabel subtitle = new JLabel(
            "Select a course to view its information."
        );

        JPanel header = new JPanel(new GridLayout(2, 1));
        header.setBackground(new Color(245, 247, 250));
        header.add(title);
        header.add(subtitle);

        // Course list
        DefaultListModel<Course> listModel =
            new DefaultListModel<>();

        for (Course course : courses) {
            listModel.addElement(course);
        }

        courseList = new JList<>(listModel);
        courseList.setFont(new Font("Arial", Font.PLAIN, 14));
        courseList.setSelectionMode(
            ListSelectionModel.SINGLE_SELECTION
        );

        JScrollPane listScroll = new JScrollPane(courseList);
        listScroll.setBorder(
            BorderFactory.createTitledBorder("Available Programs")
        );

        // Course details
        detailsArea = new JTextArea();
        detailsArea.setFont(new Font("Arial", Font.PLAIN, 15));
        detailsArea.setEditable(false);
        detailsArea.setLineWrap(true);
        detailsArea.setWrapStyleWord(true);
        detailsArea.setBackground(Color.WHITE);
        detailsArea.setMargin(new Insets(15, 15, 15, 15));

        JScrollPane detailsScroll = new JScrollPane(detailsArea);
        detailsScroll.setBorder(
            BorderFactory.createTitledBorder("Course Information")
        );

        // Selection event
        courseList.addListSelectionListener(e -> {

            if (!e.getValueIsAdjusting()) {

                Course selected = courseList.getSelectedValue();

                if (selected != null) {

                    detailsArea.setText(
                        "COURSE INFORMATION\n\n" +
                        "Course Code: " + selected.getCourseCode() +
                        "\n\nCourse Name: " + selected.getCourseName() +
                        "\n\nDescription:\n" + selected.getDescription() +
                        "\n\nPossible Careers:\n" + selected.getCareers() +
                        "\n\nEstimated Salary:\n" +
                        selected.getEstimatedSalary()
                    );
                }
            }
        });

        // Layout
        JSplitPane splitPane = new JSplitPane(
            JSplitPane.HORIZONTAL_SPLIT,
            listScroll,
            detailsScroll
        );

        splitPane.setDividerLocation(350);
        splitPane.setResizeWeight(0.4);

        JButton closeButton = new JButton("Back to Dashboard");

        closeButton.addActionListener(e -> dispose());

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        bottomPanel.setBackground(new Color(245, 247, 250));
        bottomPanel.add(closeButton);

        mainPanel.add(header, BorderLayout.NORTH);
        mainPanel.add(splitPane, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        add(mainPanel);

        setVisible(true);
    }
}
