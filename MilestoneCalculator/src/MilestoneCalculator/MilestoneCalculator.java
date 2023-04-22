package MilestoneCalculator;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;




public class MilestoneCalculator extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JLabel title;
    private JPanel panel;
    private JLabel milestone1Label;
    private JLabel milestone2Label;
    private JLabel terminalAssessmentLabel;
    private JTextField milestone1Field;
    private JTextField milestone2Field;
    private JTextField terminalAssessmentField;
    private JButton calculateButton;
    private JLabel resultLabel;
    private JTextField txtMilestone1, txtMilestone2, txtTerminal, txtResult, resultField;
    private JButton btnCalculate;
    
    private final int MAX_MILESTONE1 = 25;
    private final int MAX_MILESTONE2 = 40;
    private final int MAX_TERMINAL = 35;

    public MilestoneCalculator() {
        
        setTitle("MMDC");
        setSize(410, 370);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.setBackground(Color.BLACK);
        
        

        title = new JLabel("MMDC Milestone Calculator");
        title.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
        title.setForeground(Color.RED);
        panel.add(title);

        milestone1Label = new JLabel("          Milestone 1 (25%):            ");
        milestone1Label.setForeground(Color.WHITE);
        milestone1Label.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
        milestone1Label.setBounds(100, 100, 100, 20);
        panel.add(milestone1Label);
        

        milestone1Field = new JTextField(15);
        panel.add(milestone1Field);

        milestone2Label = new JLabel("          Milestone 2 (40%):            ");
        milestone2Label.setForeground(Color.WHITE);
        milestone2Label.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
        panel.add(milestone2Label);

        milestone2Field = new JTextField(15);
        panel.add(milestone2Field);

        terminalAssessmentLabel = new JLabel("        Terminal Assessment (35%):       ");
        terminalAssessmentLabel.setForeground(Color.WHITE);
        terminalAssessmentLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
        panel.add(terminalAssessmentLabel);

        terminalAssessmentField = new JTextField(15);
        panel.add(terminalAssessmentField);

        resultLabel = new JLabel("                            GPA:                     ");
        resultLabel.setForeground(Color.WHITE);
        resultLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
        panel.add(resultLabel);
        
        resultField = new JTextField(15);
         panel.add(resultField);
        
        
        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(this);
        calculateButton.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
        calculateButton.setBackground(Color.BLUE);
        setForeground(new java.awt.Color(0, 0, 0));
        panel.add(calculateButton);
        
        

        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculateButton) {
            double milestone1, milestone2, terminalAssessment;

            try {
                milestone1 = Double.parseDouble(milestone1Field.getText());
                milestone2 = Double.parseDouble(milestone2Field.getText());
                terminalAssessment = Double.parseDouble(terminalAssessmentField.getText());

                if (milestone1 < 0 || milestone1 > 25) {
                    throw new Exception("Invalid input for Milestone 1");
                }

                if (milestone2 < 0 || milestone2 > 40) {
                    throw new Exception("Invalid input for Milestone 2");
                }

                if (terminalAssessment < 0 || terminalAssessment > 35) {
                    throw new Exception("Invalid input for Terminal Assessment");
                }

                double average = ((milestone1 ) + (milestone2 ) + (terminalAssessment ));
                resultField.setText(String.format("%.2f", average));

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        new MilestoneCalculator();
    }
}




