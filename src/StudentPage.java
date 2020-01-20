import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.w3c.dom.ls.LSProgressEvent;

import net.proteanit.sql.DbUtils;

import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

public class StudentPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField_10;
	private JTextField textField_1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public void StudentInfo() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentPage frame = new StudentPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection con = null;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	public JTextField login;
	public JTextField name;
	private JTextField id;
	private JTextField session;
	String Id;
	private JTable table_1;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	/**
	 * Create the frame.
	 */
	public StudentPage() {
		con = SqliteConnection.dbConnector();
			
		setResizable(false);
		con = SqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Semester");
		lblNewLabel_1.setForeground(new Color(255, 255, 0));
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(158, 224, 125, 49);
		contentPane.add(lblNewLabel_1);
		
		textField_10 = new JTextField();
		textField_10.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		textField_10.setBounds(312, 224, 244, 49);
		contentPane.add(textField_10);
		textField_10.setColumns(10);
		
		JLabel lblExamYear = new JLabel("Exam Year");
		lblExamYear.setForeground(new Color(255, 255, 0));
		lblExamYear.setHorizontalAlignment(SwingConstants.CENTER);
		lblExamYear.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		lblExamYear.setBounds(158, 286, 142, 49);
		contentPane.add(lblExamYear);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		textField_1.setColumns(10);
		textField_1.setBounds(312, 290, 244, 45);
		contentPane.add(textField_1);
		
		JButton btnNewButton = new JButton("Show Result");
		btnNewButton.setBackground(new Color(0, 153, 204));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String semester = textField_10.getText();
				String year = textField_1.getText();
			 	String n = login.getText();
				String query8 = "select * from Student where UserName= '"+n+"'"; 
				
				try {
					java.sql.Statement st8 = con.createStatement();
					ResultSet rs8 = st8.executeQuery(query8);
					
					while(rs8.next()){
						Id = rs8.getString("ID");
					}
				}catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				String query = "select * from ResultTable where Semester='"+semester+"' and ExamYear='"+year+"' and ID='"+Id+"'";
				Statement st;
				try {
					st = con.createStatement();
					ResultSet rSet = st.executeQuery(query);
					table_1.setModel(DbUtils.resultSetToTableModel(rSet));
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		}
		});
		btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		btnNewButton.setBounds(617, 255, 170, 49);
		contentPane.add(btnNewButton);
			
		
		JLabel lblNewLabel_2 = new JLabel("Update Information");
		lblNewLabel_2.setForeground(new Color(255, 255, 0));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblNewLabel_2.setBounds(161, 577, 419, 49);
		contentPane.add(lblNewLabel_2);
		
		JLabel label = new JLabel("Name");
		label.setForeground(new Color(255, 255, 0));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		label.setBackground(new Color(176, 196, 222));
		label.setBounds(158, 667, 112, 46);
		contentPane.add(label);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		textField_2.setColumns(10);
		textField_2.setBackground(SystemColor.menu);
		textField_2.setBounds(271, 664, 309, 49);
		contentPane.add(textField_2);
		
		JLabel label_1 = new JLabel("Session\r\n");
		label_1.setForeground(new Color(255, 255, 0));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		label_1.setBounds(147, 726, 112, 45);
		contentPane.add(label_1);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		textField_3.setColumns(10);
		textField_3.setBackground(SystemColor.menu);
		textField_3.setBounds(271, 726, 309, 51);
		contentPane.add(textField_3);
		
		JLabel label_2 = new JLabel("ID NO");
		label_2.setForeground(new Color(255, 255, 0));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		label_2.setBounds(157, 793, 112, 43);
		contentPane.add(label_2);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		textField_4.setColumns(10);
		textField_4.setBackground(SystemColor.menu);
		textField_4.setBounds(271, 790, 309, 49);
		contentPane.add(textField_4);
		
		JLabel lblPasswordChange = new JLabel("Change Password");
		lblPasswordChange.setForeground(new Color(255, 255, 0));
		lblPasswordChange.setHorizontalAlignment(SwingConstants.CENTER);
		lblPasswordChange.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblPasswordChange.setBounds(1286, 577, 403, 49);
		contentPane.add(lblPasswordChange);
		
		JLabel lblOldPassword = new JLabel("Old Password");
		lblOldPassword.setForeground(new Color(255, 255, 0));
		lblOldPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblOldPassword.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		lblOldPassword.setBackground(new Color(176, 196, 222));
		lblOldPassword.setBounds(1215, 660, 191, 51);
		contentPane.add(lblOldPassword);
		
		JLabel lblNewPassword = new JLabel("New Password");
		lblNewPassword.setForeground(new Color(255, 255, 0));
		lblNewPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewPassword.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		lblNewPassword.setBounds(1215, 715, 191, 53);
		contentPane.add(lblNewPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setForeground(new Color(255, 255, 0));
		lblConfirmPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirmPassword.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		lblConfirmPassword.setBounds(1181, 774, 217, 56);
		contentPane.add(lblConfirmPassword);
		
		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.setBackground(new Color(0, 153, 204));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = textField_2.getText();
				String session = textField_3.getText();
				String Id = textField_4.getText();
				String id1 = id.getText();
				if(name.isEmpty() || session.isEmpty() || Id.isEmpty()){
					JOptionPane.showMessageDialog(null, "Sorry! You have to fill up all the field");
				}
				else{
					String query = "update Student set Name='"+name+"', Session= '"+session+"', ID= '"+Id+"' where ID= '"+id1+"'";
					String query1 = "update ResultTable set Name='"+name+"', Session= '"+session+"', ID= '"+Id+"' where ID= '"+id1+"'";
					try {
						Statement st = con.createStatement();
						Statement st1 = con.createStatement();
						st.execute(query);
						st1.execute(query1);
						JOptionPane.showMessageDialog(null, "Information has been Updated Successsfully!");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		});
		btnNewButton_1.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		btnNewButton_1.setBounds(335, 868, 125, 49);
		contentPane.add(btnNewButton_1);
		
		JButton btnChangePassword = new JButton("Change Password");
		btnChangePassword.setBackground(new Color(0, 153, 204));
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String pass = passwordField_1.getText();
				String npass = passwordField_2.getText();
				String query1 = "select * from Student where UserName=? and Password=?";
				
				PreparedStatement pst;
				try {
					pst = con.prepareStatement(query1);
					pst.setString(1,login.getText());
					pst.setString(2,passwordField.getText());
					
					ResultSet rs = pst.executeQuery();
					int cnt = 0;
					while(rs.next()){
						cnt++;
					}
					if(pass.isEmpty() || npass.isEmpty()){
						JOptionPane.showMessageDialog(null, "Sorry! You have to fill up all the field.");
					}
					else if(cnt !=1 ){
						JOptionPane.showMessageDialog(null,"Wrong Password!");
					}
					
					else{
						
						if(pass.equals(npass)){
						String query = "update Student Set Password='"+pass+"' where UserName='"+login.getText()+"'";
						
						Statement statement = con.createStatement();
						statement.execute(query);
						JOptionPane.showMessageDialog(null, "Password has been changed successfully!");
						passwordField.setText(""); passwordField_1.setText(""); passwordField_2.setText("");
						}
						else
							JOptionPane.showMessageDialog(null,"Passwords don't match! Please try again");
					}
					
				}
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnChangePassword.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		btnChangePassword.setBounds(1462, 868, 235, 49);
		contentPane.add(btnChangePassword);
		
		JLabel lblNewLabel_3 = new JLabel("Log in as");
		lblNewLabel_3.setForeground(new Color(255, 255, 0));
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		lblNewLabel_3.setBounds(1737, 34, 95, 46);
		contentPane.add(lblNewLabel_3);
		
		login = new JTextField();
		login.setHorizontalAlignment(SwingConstants.CENTER);
		login.setEditable(false);
		login.setFont(new Font("Segoe UI", Font.BOLD, 20));
		login.setBounds(1675, 83, 206, 33);
		contentPane.add(login);
		login.setColumns(10);
		
		
		JButton btnNewButton_2 = new JButton("Log out");
		btnNewButton_2.setBackground(new Color(0, 153, 204));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				FirstPage firstPage = new FirstPage();
				firstPage.setVisible(true);
				JOptionPane.showMessageDialog(null, "You have successfully Logged out");
			}
		});
		btnNewButton_2.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		btnNewButton_2.setBounds(1756, 132, 125, 45);
		contentPane.add(btnNewButton_2);
		
		name = new JTextField();
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setEditable(false);
		name.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		name.setBounds(620, 119, 326, 58);
		contentPane.add(name);
		name.setColumns(10);
		
		id = new JTextField();
		id.setHorizontalAlignment(SwingConstants.CENTER);
		id.setEditable(false);
		id.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		id.setColumns(10);
		id.setBounds(942, 119, 170, 58);
		contentPane.add(id);
		
		session = new JTextField();
		session.setHorizontalAlignment(SwingConstants.CENTER);
		session.setEditable(false);
		session.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		session.setColumns(10);
		session.setBounds(1109, 119, 148, 58);
		contentPane.add(session);
		
		JScrollPane scrollPane = new JScrollPane(table_1,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(30, 384, 1851, 164);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		table_1.setBackground(new Color(153, 153, 153));
		table_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		table_1.setAutoResizeMode(table_1.AUTO_RESIZE_OFF);
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = table_1.getSelectedRow();
				String n = table_1.getModel().getValueAt(row, 0).toString(); 
				String query8 = "select * from ResultTable where Name = '"+n+"'"; 
				try {
					java.sql.Statement st8 = con.createStatement();
					ResultSet rs8 = st8.executeQuery(query8);
					
					while(rs8.next()){
						textField_2.setText(rs8.getString("Name"));
						textField_3.setText(rs8.getString("Session"));
						textField_4.setText(rs8.getString("ID"));
					}
				}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		scrollPane.setViewportView(table_1);
		
		JButton btnNewButton_3 = new JButton("See Details");
		btnNewButton_3.setBackground(new Color(0, 153, 204));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String n = login.getText();
				String query8 = "select * from Student where UserName= '"+n+"'"; 
				
				try {
					java.sql.Statement st8 = con.createStatement();
					ResultSet rs8 = st8.executeQuery(query8);
					
					while(rs8.next()){
						id.setText(rs8.getString("ID"));
						name.setText(rs8.getString("Name"));
						session.setText(rs8.getString("Session"));
					}
				}catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

			}
		});
		btnNewButton_3.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		btnNewButton_3.setBounds(890, 49, 170, 46);
		contentPane.add(btnNewButton_3);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		passwordField.setBounds(1418, 654, 312, 51);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		passwordField_1.setBounds(1418, 722, 312, 49);
		contentPane.add(passwordField_1);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		passwordField_2.setBounds(1418, 787, 312, 49);
		contentPane.add(passwordField_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(StudentPage.class.getResource("/IMG/main.jpeg")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, -23, 1920, 1080);
		contentPane.add(lblNewLabel);
		
	}
}
