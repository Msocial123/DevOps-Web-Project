import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserRegistrationPage extends JFrame {

    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField emailField;
    private JTextField dobField;
    private JButton submitButton;

    public UserRegistrationPage() {
        // Setup the frame
        setTitle("User Registration Page");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create a panel
        JPanel panel = new JPanel(new GridLayout(5, 2));

        // Add labels and text fields to the panel
        panel.add(new JLabel("First Name:"));
        firstNameField = new JTextField();
        panel.add(firstNameField);

        panel.add(new JLabel("Last Name:"));
        lastNameField = new JTextField();
        panel.add(lastNameField);

        panel.add(new JLabel("Email:"));
        emailField = new JTextField();
        panel.add(emailField);

        panel.add(new JLabel("DOB (YYYY-MM-DD):"));
        dobField = new JTextField();
        panel.add(dobField);

        // Add the submit button
        submitButton = new JButton("Submit");
        panel.add(submitButton);

        // Add an empty label to align the button correctly
        panel.add(new JLabel(""));

        // Add the panel to the frame
        add(panel);

        // Add action listener to the button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleSubmit();
            }
        });
    }

    private void handleSubmit() {
        // Get the input data
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String email = emailField.getText();
        String dob = dobField.getText();

        // Validate and display the input data
        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || dob.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this,
                    "Registration Successful!\n\n" +
                            "First Name: " + firstName + "\n" +
                            "Last Name: " + lastName + "\n" +
                            "Email: " + email + "\n" +
                            "DOB: " + dob,
                    "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        // Run the application
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new UserRegistrationPage().setVisible(true);
            }
        });
    }
}
