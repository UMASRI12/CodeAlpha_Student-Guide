import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GradeTrackerGUI extends JFrame {
    private final ArrayList<Student> students = new ArrayList<>();
    private final JTextField idField = new JTextField();
    private final JTextField nameField = new JTextField();
    private final JTextField marksField = new JTextField();
    private final JTextArea output = new JTextArea();

    public GradeTrackerGUI() {
        setTitle("Student Grade Tracker");
        setSize(650, 520);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JPanel form = new JPanel(new GridLayout(4, 2, 8, 8));
        form.setBorder(BorderFactory.createEmptyBorder(12, 12, 4, 12));
        form.add(new JLabel("Student ID:"));
        form.add(idField);
        form.add(new JLabel("Student Name:"));
        form.add(nameField);
        form.add(new JLabel("Marks (comma separated):"));
        form.add(marksField);

        JButton addButton = new JButton("Add Student");
        JButton viewButton = new JButton("View Students");
        form.add(addButton);
        form.add(viewButton);

        output.setEditable(false);
        output.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 13));
        add(form, BorderLayout.NORTH);
        add(new JScrollPane(output), BorderLayout.CENTER);

        addButton.addActionListener(e -> addStudent());
        viewButton.addActionListener(e -> viewStudents());
        setLocationRelativeTo(null);
    }

    private void addStudent() {
        try {
            int id = Integer.parseInt(idField.getText().trim());
            String name = nameField.getText().trim();
            if (name.isEmpty()) throw new IllegalArgumentException("Enter a student name.");

            for (Student student : students) {
                if (student.getId() == id) {
                    throw new IllegalArgumentException("Student ID already exists.");
                }
            }

            String[] values = marksField.getText().split(",");
            if (values.length == 0 || marksField.getText().trim().isEmpty()) {
                throw new IllegalArgumentException("Enter at least one mark.");
            }

            double[] marks = new double[values.length];
            for (int i = 0; i < values.length; i++) {
                marks[i] = Double.parseDouble(values[i].trim());
                if (marks[i] < 0 || marks[i] > 100) {
                    throw new IllegalArgumentException("Marks must be between 0 and 100.");
                }
            }

            students.add(new Student(id, name, marks));
            JOptionPane.showMessageDialog(this, "Student added successfully.");
            idField.setText("");
            nameField.setText("");
            marksField.setText("");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Enter a valid numeric ID and marks.");
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    private void viewStudents() {
        output.setText("");
        if (students.isEmpty()) {
            output.setText("No student records available.");
            return;
        }
        for (Student s : students) {
            output.append("ID: " + s.getId()
                    + "\nName: " + s.getName()
                    + "\nTotal: " + s.getTotal()
                    + "\nAverage: " + String.format("%.2f", s.getAverage())
                    + "\nHighest: " + s.getHighest()
                    + "\nLowest: " + s.getLowest()
                    + "\nGrade: " + s.getGrade()
                    + "\n------------------------------\n");
        }
    }
}
