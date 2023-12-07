package AdminPages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("serial")
public class UserDataDialog extends JDialog {

    private Map<String, String> userData;

    private JTextField nameField;
    private JTextField userAccountField;
    private JPasswordField passwordField;

    private JTextField phoneField;
    private JTextField addressField;
    private JTextField gmailField;
    private JTextField idPesonnalField;

    public UserDataDialog(Frame owner, String title, boolean modal) {
        super(owner, title, modal);
        initializeUI();
    }

    private void initializeUI() {
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(8, 2));

        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("User Account:"));
        userAccountField = new JTextField();
        add(userAccountField);

        add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        add(passwordField);

        add(new JLabel("Phone:"));
        phoneField = new JTextField();
        add(phoneField);

        add(new JLabel("Address:"));
        addressField = new JTextField();
        add(addressField);

        add(new JLabel("Gmail:"));
        gmailField = new JTextField();
        add(gmailField);

        add(new JLabel("ID Pesonnal:"));
        idPesonnalField = new JTextField();
        add(idPesonnalField);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveUserData();
            }
        });
        add(saveButton);
    }

    private void saveUserData() {
        String name = nameField.getText();
        String userAccount = userAccountField.getText();
        String password = new String(passwordField.getPassword());
        String role = "user";
        String phone = phoneField.getText();
        String address = addressField.getText();
        String gmail = gmailField.getText();
        String idPesonnal = idPesonnalField.getText();

        userData = new HashMap<>();
        userData.put("Name", name);
        userData.put("User Account", userAccount);
        userData.put("Password", password);
        userData.put("Role", role);
        userData.put("Phone", phone);
        userData.put("Address", address);
        userData.put("Gmail", gmail);
        userData.put("ID Pesonnal", idPesonnal);

        setVisible(false);
    }

    public Map<String, String> getUserData() {
        return userData;
    }
}
