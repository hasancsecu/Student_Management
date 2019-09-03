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
		setBounds(350, 100, 722, 505);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student's Sign Up");
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setFont(new Font("Palatino Linotype", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 696, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setForeground(new Color(255, 255, 0));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Palatino Linotype", Font.BOLD, 20));
		lblNewLabel_1.setBounds(159, 73, 90, 32);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Palatino Linotype", Font.BOLD, 20));
		textField.setBounds(283, 72, 258, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Palatino Linotype", Font.BOLD, 20));
		textField_1.setColumns(10);
		textField_1.setBounds(283, 122, 258, 35);
		contentPane.add(textField_1);
		
		JLabel lblSession = new JLabel("Session");
		lblSession.setForeground(new Color(255, 255, 0));
		lblSession.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSession.setFont(new Font("Palatino Linotype", Font.BOLD, 20));
		lblSession.setBounds(143, 123, 106, 32);
		contentPane.add(lblSession);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Palatino Linotype", Font.BOLD, 20));
		textField_2.setColumns(10);
		textField_2.setBounds(283, 168, 258, 35);
		contentPane.add(textField_2);
		
		JLabel lblIdNo = new JLabel("ID No");
		lblIdNo.setForeground(new Color(255, 255, 0));
		lblIdNo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIdNo.setFont(new Font("Palatino Linotype", Font.BOLD, 20));
		lblIdNo.setBounds(143, 169, 106, 32);
		contentPane.add(lblIdNo);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(255, 255, 0));
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setFont(new Font("Palatino Linotype", Font.BOLD, 20));
		lblPassword.setBounds(144, 268, 104, 32);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 14));
		passwordField.setBounds(283, 265, 258, 40);
		contentPane.add(passwordField);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setForeground(new Color(255, 255, 0));
		lblConfirmPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblConfirmPassword.setFont(new Font("Palatino Linotype", Font.BOLD, 20));
		lblConfirmPassword.setBounds(71, 324, 177, 32);
		contentPane.add(lblConfirmPassword);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		passwordField_1.setBounds(283, 321, 258, 40);
		
		contentPane.add(passwordField_1);
		
		JButton btnNewButton = new JButton("Sign up");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(100, 149, 237));
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
		btnNewButton.setFont(new Font("Palatino Linotype", Font.BOLD, 20));
		btnNewButton.setBounds(283, 392, 113, 40);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBackground(new Color(100, 149, 237));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				FirstPage first = new FirstPage();
				first.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Palatino Linotype", Font.BOLD, 20));
		btnNewButton_1.setBounds(435, 392, 106, 40);
		contentPane.add(btnNewButton_1);
		
		JLabel lblUserName = new JLabel("User name");
		lblUserName.setForeground(new Color(255, 255, 0));
		lblUserName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUserName.setFont(new Font("Palatino Linotype", Font.BOLD, 20));
		lblUserName.setBounds(143, 222, 106, 32);
		contentPane.add(lblUserName);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Palatino Linotype", Font.BOLD, 20));
		textField_3.setColumns(10);
		textField_3.setBounds(283, 221, 258, 35);
		contentPane.add(textField_3);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(StudentSignUp.class.getResource("/IMG/main1.jpg")));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setBounds(0, 0, 716, 476);
		contentPane.add(lblNewLabel_2);
	}
}
