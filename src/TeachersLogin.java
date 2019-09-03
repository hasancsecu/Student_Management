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
import javax.swing.JPasswordField;
import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class TeachersLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public void teacher() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeachersLogin frame = new TeachersLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection conn = null;
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public TeachersLogin(){
		setResizable(false);
		conn = SqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 100, 689, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Teacher's Log in");
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Palatino Linotype", Font.BOLD, 25));
		lblNewLabel.setBounds(10, 11, 673, 58);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("User Name");
		lblNewLabel_1.setForeground(new Color(255, 255, 0));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Palatino Linotype", Font.BOLD, 20));
		lblNewLabel_1.setBounds(134, 104, 117, 32);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Palatino Linotype", Font.BOLD, 20));
		textField.setBounds(261, 100, 270, 42);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setForeground(new Color(255, 255, 0));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Palatino Linotype", Font.BOLD, 20));
		lblNewLabel_2.setBounds(134, 186, 117, 32);
		contentPane.add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 14));
		passwordField.setBounds(261, 182, 270, 42);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Log in");
		btnNewButton.setBackground(new Color(100, 149, 237));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String query = "select * from Teacher where UserName=? and Password=?";
				String name = textField.getText();
				
				try {
					PreparedStatement pst = conn.prepareStatement(query);
					pst.setString(1,textField.getText());
					pst.setString(2,passwordField.getText());
					
					ResultSet rs = pst.executeQuery();
					int cnt = 0;
					while(rs.next()){
						cnt++;
					}
					if(cnt==1){
						dispose();
						ResultMain rMain = new ResultMain();
						rMain.setVisible(true);
						JOptionPane.showMessageDialog(null, "Log In Successful!");
						rMain.log.setText(name);
					}
					else
						JOptionPane.showMessageDialog(null, "Invalid Username or Password! Please try again");
					rs.close();
					pst.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Palatino Linotype", Font.BOLD, 20));
		btnNewButton.setBounds(261, 268, 110, 42);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("Note: If Someone provided wrong activity in this page, he/she will be punished according to law.");
		lblNewLabel_3.setForeground(Color.YELLOW);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Palatino Linotype", Font.BOLD, 14));
		lblNewLabel_3.setBounds(10, 363, 653, 32);
		contentPane.add(lblNewLabel_3);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBackground(new Color(100, 149, 237));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				FirstPage first = new FirstPage();
				first.setVisible(true);
			}
		});
		btnCancel.setFont(new Font("Palatino Linotype", Font.BOLD, 20));
		btnCancel.setBounds(421, 268, 110, 42);
		contentPane.add(btnCancel);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(TeachersLogin.class.getResource("/IMG/main4.jpg")));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(0, -23, 683, 439);
		contentPane.add(lblNewLabel_4);
	}
}
