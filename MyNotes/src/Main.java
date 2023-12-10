import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Main extends JFrame {
    Main () {
        initComponents();
    }
    public static void main(String[] args) {
        Main frame = new Main();
        frame.setTitle("MyNotes");
        ImageIcon icon = new ImageIcon("icon\\img.png");
        frame.setIconImage(icon.getImage());
        frame.setVisible(true);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void initComponents() {
        Container cnt = getContentPane();
        cnt.setLayout(null);

        JLabel enterText = new JLabel("Enter text Here :");
        enterText.setBounds(40, 0, 200, 40);
        cnt.add(enterText);

        textArea = new JTextArea();
        textArea.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(30, 40, 328, 145);
        cnt.add(scrollPane);

        JLabel fName = new JLabel("File Name (without extension): ");
        fName.setBounds(30, 195, 200, 20);
        fName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        cnt.add(fName);

        nameOfFile = new JTextField();
        nameOfFile.setBounds(30, 215, 150, 25);
        cnt.add(nameOfFile);

        Handler handle = new Handler();

        save = new JButton("Save");
        save.setBounds(187, 215, 75, 25);
        save.addActionListener(handle);
        cnt.add(save);

        reset = new JButton("Reset All");
        reset.setBounds(267, 215, 90, 25);
        reset.addActionListener(handle);
        cnt.add(reset);
    }
    class Handler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == reset) {
                textArea.setText("");
                nameOfFile.setText("");
            } else if (e.getSource() == save) {
                File file = new File(nameOfFile.getText() + ".txt");
                try {
                    PrintWriter pw = new PrintWriter(file);
                    pw.println(textArea.getText());
                    pw.close();
                    textArea.setText("Saved!");
                } catch (IOException ex) {
                    textArea.setText("An Error found!");
                }
            }
        }
    }
    private JTextArea textArea;
    private JTextField nameOfFile;
    private JButton save, reset;
}