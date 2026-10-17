import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InternTracker extends JFrame {
    public InternTracker() {
        setTitle("MicroX Intern Task Tracker with AI Guard");
        setSize(450, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JLabel heading = new JLabel("Software House Intern Database (AI Verified)", SwingConstants.CENTER);
        heading.setFont(new Font("Arial", Font.BOLD, 14));
        add(heading, BorderLayout.NORTH);

        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> internList = new JList<>(listModel);
        add(new JScrollPane(internList), BorderLayout.CENTER);

        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        
        inputPanel.add(new JLabel(" Intern Name:"));
        JTextField nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel(" Assigned Domain:"));
        JTextField skillField = new JTextField();
        inputPanel.add(skillField);

        JButton addBtn = new JButton("Add Intern Record");
        inputPanel.add(addBtn);

        JButton removeBtn = new JButton("Clear List");
        inputPanel.add(removeBtn);

        add(inputPanel, BorderLayout.SOUTH);

        // Action Listener with Mock AI Data Guard
        addBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText().trim();
                String skill = skillField.getText().trim();
                
                // AI Rule-Based Detection Engine
                if (trackFakeData(name, skill)) {
                    JOptionPane.showMessageDialog(null, 
                        "🚨 AI Guard Alert: Suspicious or invalid data detected! Please provide real professional info.", 
                        "AI Validation Error", 
                        JOptionPane.ERROR_MESSAGE);
                } else if (!name.isEmpty() && !skill.isEmpty()) {
                    listModel.addElement("👤 " + name + " -> [" + skill + "] ✅ Verified");
                    nameField.setText("");
                    skillField.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Fields cannot be empty!");
                }
            }
        });

        removeBtn.addActionListener(e -> listModel.clear());
    }

    // Human-written Mock AI logic to track fake inputs
    private boolean trackFakeData(String name, String skill) {
        if (name.matches(".*\\d+.*") || skill.matches(".*\\d+.*")) {
            return true; // Checks if name or skill contains numbers (e.g. "Test123")
        }
        if (name.length() < 3 || skill.length() < 2) {
            return true; // Checks if input is too short to be real
        }
        if (name.toLowerCase().contains("fake") || name.toLowerCase().contains("test")) {
            return true; // Blocks generic placeholder words
        }
        return false; 
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new InternTracker().setVisible(true));
    }
}