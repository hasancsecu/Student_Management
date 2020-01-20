import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class StudentSignUp extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public void signup() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentSignUp frame = new StudentSignUp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection = null;
	private JTextField textField_3;
	/**
	 * Create the frame.
	 */
	public StudentSignUp() {
		setResizable(false);
		connection = SqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student's Sign Up");
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 280, 1920, 68);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setForeground(new Color(255, 255, 0));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblNewLabel_1.setBounds(801, 423, 106, 46);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		textField.setBounds(919, 422, 270, 48);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		textField_1.setColumns(10);
		textField_1.setBounds(919, 483, 270, 49);
		contentPane.add(textField_1);
		
		JLabel lblSession = new JLabel("Session");
		lblSession.setForeground(new Color(255, 255, 0));
		lblSession.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSession.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblSession.setBounds(801, 484, 106, 46);
		contentPane.add(lblSession);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		textField_2.setColumns(10);
		textField_2.setBounds(919, 545, 270, 50);
		contentPane.add(textField_2);
		
		JLabel lblIdNo = new JLabel("ID No");
		lblIdNo.setForeground(new Color(255, 255, 0));
		lblIdNo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIdNo.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblIdNo.setBounds(801, 550, 106, 41);
		contentPane.add(lblIdNo);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(255, 255, 0));
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblPassword.setBounds(752, 668, 149, 46);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		passwordField.setBounds(919, 668, 270, 46);
		contentPane.add(passwordField);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setForeground(new Color(255, 255, 0));
		lblConfirmPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblConfirmPassword.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblConfirmPassword.setBounds(671, 727, 230, 46);
		contentPane.add(lblConfirmPassword);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		passwordField_1.setBounds(919, 727, 270, 46);
		
		contentPane.add(passwordField_1);
		
		JButton btnNewButton = new JButton("Sign up");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(0, 153, 204));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = textField.getText();
				String session = textField_1.getText();
				String id = textField_2.getText();
				String pass = passwordField.getText();
				String cpass = passwordField_1.getText();
				String user = textField_3.getText();
				
				String query1 = "select * from Student where UserName='"+user+"'";
				
				Statement pst;
				try {
					pst = connection.createStatement();
					
					ResultSet rs = pst.executeQuery(query1);
					int cnt = 0;
					while(rs.next()){
						cnt++;
					}
					String query2 = "select * from Student where ID='"+id+"'";
					
					Statement st = connection.createStatement();
						
						ResultSet rs1 = st.executeQuery(query2);
						int cnt1 = 0;
						while(rs1.next()){
							cnt1++;
						}

					if(cnt1 >= 1){
							JOptionPane.showMessageDialog(null, "ID already exists.");
						}

					else if(cnt >= 1){
						JOptionPane.showMessageDialog(null, "Username already exists. Please try another");
					}
					else if(name.isEmpty() || id.isEmpty() || session.isEmpty() || pass.isEmpty() || cpass.isEmpty() || user.isEmpty()){
						JOptionPane.showMessageDialog(null, "Sorry! You have to fill up all the field.");
					}
					
					else if(!pass.equals(cpass)){
						JOptionPane.showMessageDialog(null, "Password doesn't match. Please try again!");
						 
					}
					else{
					String query = "insert into Student (Name,Session,ID,UserName,Password) values ('"+name+"','"+session+"','"+id+"','"+user+"','"+pass+"')";
					
					Statement statement;
				
						statement = connection.createStatement();
						statement.execute(query);
						JOptionPane.showMessageDialog(null, "Signed up Successfully!");
						dispose();
						StudentLogin login = new StudentLogin();
						login.setVisible(true);
					
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			
			}
		});
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 25));
		btnNewButton.setBounds(825, 786, 139, 58);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBackground(new Color(0, 153, 204));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				FirstPage first = new FirstPage();
				first.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Segoe UI", Font.BOLD, 25));
		btnNewButton_1.setBounds(1064, 786, 125, 58);
		contentPane.add(btnNewButton_1);
		
		JLabel lblUserName = new JLabel("User name");
		lblUserName.setForeground(new Color(255, 255, 0));
		lblUserName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUserName.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblUserName.setBounds(783, 608, 125, 47);
		contentPane.add(lblUserName);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		textField_3.setColumns(10);
		textField_3.setBounds(919, 608, 270, 48);
		contentPane.add(textField_3);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(StudentSignUp.class.getResource("/IMG/sign.jpg")));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(642, 133, 650, 722);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(StudentSignUp.class.getResource("/IMG/main.jpeg")));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setBounds(0, 0, 1920, 1080);
		contentPane.add(lblNewLabel_2);
	}
}
