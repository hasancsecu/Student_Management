import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class FirstPage extends JFrame{

	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstPage frame = new FirstPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FirstPage() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Log in as a Teacher");
		btnNewButton.setForeground(new Color(0, 0, 128));
		btnNewButton.setBackground(new Color(0, 153, 204));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				TeachersLogin tLogin = new TeachersLogin();
				tLogin.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 30));
		btnNewButton.setBounds(822, 373, 341, 62);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Log in as a Student");
		btnNewButton_1.setForeground(new Color(0, 0, 128));
		btnNewButton_1.setBackground(new Color(0, 153, 204));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				StudentLogin studentLogin = new StudentLogin();
				studentLogin.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Segoe UI", Font.BOLD, 30));
		btnNewButton_1.setBounds(822, 469, 341, 62);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Department of Computer Science and Engineering");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 50));
		lblNewLabel.setBounds(12, 111, 1920, 85);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("Sign up as a Student");
		btnNewButton_2.setForeground(new Color(25, 25, 112));
		btnNewButton_2.setBackground(new Color(0, 153, 204));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				StudentSignUp studentSignUp = new StudentSignUp();
				studentSignUp.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Segoe UI", Font.BOLD, 30));
		btnNewButton_2.setBounds(822, 564, 341, 65);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("Note: Teacher's Username and Password is provided by Chairman.");
		lblNewLabel_1.setForeground(new Color(255, 255, 0));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblNewLabel_1.setBounds(12, 763, 1920, 75);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Students have to sign up first to log in.");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(new Color(255, 255, 0));
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblNewLabel_2.setBounds(12, 713, 1920, 65);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("University of Chittagong");
		lblNewLabel_3.setForeground(new Color(0, 0, 128));
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.BOLD, 50));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(0, 224, 1920, 75);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(FirstPage.class.getResource("/IMG/main.jpeg")));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(0, 13, 1920, 1080);
		contentPane.add(lblNewLabel_4);
	}
}
