import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GradeTrackerGUI app = new GradeTrackerGUI();
            app.setVisible(true);
        });
    }
}
