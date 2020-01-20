import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.ImageIcon;

public class StudentLogin extends JFrame {

	private JPanel contentPane;
	public  JTextField textField;
	public JPasswordField passwordField;
	public String n10;

	/**
	 * Launch the application.
	 */
	public void student() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentLogin frame = new StudentLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection con = null;
	/**
	 * Create the frame.
	 */
	public StudentLogin() {
		setResizable(false);
		con = SqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student's Log in");
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 40));
		lblNewLabel.setBounds(0, 280, 1920, 66);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("User Name");
		lblNewLabel_1.setForeground(new Color(255, 255, 0));
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(677, 476, 163, 42);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		textField.setBounds(852, 470, 339, 55);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Log in");
		btnNewButton.setBackground(new Color(0, 153, 204));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String query = "select * from Student where UserName=? and Password=?";
				
				try {
					PreparedStatement pst = con.prepareStatement(query);
					pst.setString(1,textField.getText());
					pst.setString(2,passwordField.getText());
					
					ResultSet rs = pst.executeQuery();
					int cnt = 0;
					while(rs.next()){
						cnt++;
					}
					if(cnt==1){
						dispose();
						StudentPage page = new StudentPage();
						page.setVisible(true);
						JOptionPane.showMessageDialog(null, "Log In Successful!");
						page.login.setText(textField.getText());
			
						
					}
					else
						JOptionPane.showMessageDialog(null, "Invalid Username or Password! Please try again");
					//rs.close();
					//pst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		btnNewButton.setBounds(852, 647, 131, 55);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setForeground(new Color(255, 255, 0));
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(677, 560, 167, 42);
		contentPane.add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		passwordField.setBounds(852, 554, 339, 55);
		contentPane.add(passwordField);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.setBackground(new Color(0, 153, 204));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				FirstPage first = new FirstPage();
				first.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		btnNewButton_1.setBounds(1060, 647, 131, 55);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Create an account");
		btnNewButton_2.setBackground(new Color(0, 153, 204));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				StudentSignUp signUp = new StudentSignUp();
				signUp.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		btnNewButton_2.setBounds(852, 742, 271, 42);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(StudentLogin.class.getResource("/IMG/sign.jpg")));
		lblNewLabel_4.setBounds(642, 133, 650, 722);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(StudentLogin.class.getResource("/IMG/main.jpeg")));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(12, 0, 1920, 1080);
		contentPane.add(lblNewLabel_3);
	}

}
