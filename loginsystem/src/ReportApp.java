import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class ReportApp {

  
    static class ReportModel {
        public String generateReport() {
            StringBuilder report = new StringBuilder();
            report.append("==== System Report ====\n");
            report.append("Date: ").append(LocalDate.now()).append("\n");
            report.append("Total Users: 25\n");
            report.append("Total Backups: 5\n");
            report.append("System Logs Checked: Yes\n");
            report.append("Attendance Rules Set: Yes\n");
            report.append("========================\n");
            return report.toString();
        }
    }

    // === VIEW: Builds GUI components ===
    static class ReportView extends JFrame {
        JButton btnGenerate;
        JTextArea txtReport;

        public ReportView() {
            setTitle("Admin Report Generator");
            setSize(500, 400);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLocationRelativeTo(null);

            btnGenerate = new JButton("Generate Report");
            txtReport = new JTextArea();
            txtReport.setEditable(false);

            JScrollPane scrollPane = new JScrollPane(txtReport);

            setLayout(new BorderLayout());
            add(btnGenerate, BorderLayout.NORTH);
            add(scrollPane, BorderLayout.CENTER);
        }
    }

    // === CONTROLLER: Connects view and model ===
    static class ReportController {
        ReportModel model;
        ReportView view;

        public ReportController(ReportModel model, ReportView view) {
            this.model = model;
            this.view = view;

            view.btnGenerate.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String report = model.generateReport();
                    view.txtReport.setText(report);
                }
            });
        }

        public void showView() {
            view.setVisible(true);
        }
    }

    // === MAIN method to start the application ===
    public static void main(String[] args) {
        ReportModel model = new ReportModel();
        ReportView view = new ReportView();
        ReportController controller = new ReportController(model, view);
        controller.showView();
    }
}
