import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicTabbedPaneUI.TabbedPaneLayout;
import javax.swing.table.DefaultTableModel;
import javax.xml.ws.AsyncHandler;

import org.w3c.dom.ls.LSException;
import net.proteanit.sql.DbUtils;
import java.awt.*;
import java.lang.Thread.State;
import java.sql.*;
import java.awt.event.*;
import javax.swing.border.MatteBorder;

public class ResultMain extends JFrame {

	private JPanel contentPane;
	private JTextField name,session,ID,year,CC1,cr1,IDno,nam,sess,subj,idn,eyr,IdNo,sc1,CC4,cr4,sc4,CC7,cr7,sc7,CC2,CC5,cr5,cr2,sc2,sc5,CC3,CC6,cr6,cr3,sc3,sc6;
	private JTable searchtable,updatetable;
	private DefaultTableModel model;
	JTabbedPane tabbedPane;
	float res1,cr11=0,sc11=0,cr12=0,cr13=0,cr14=0,cr15=0,cr16=0,cr17=0,cr18=0,cr19=0,sc12=0,sc13=0,sc14=0,sc15=0,sc16=0,sc17=0,sc18=0,sc19=0;
	/**
	 * Launch the application.
	 */
	public void result() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResultMain frame = new ResultMain();
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
	Connection con;
	private JTextField semestr,res,code1,gpa1,gpa4,code4,code2,code5,credit2,credit5,code3,code6,gpa3,gpa6,code7,gpa7,RES,credit1,credit4,credit7,gpa8,credit8,code8,gpa9,credit9,code9,credit3,credit6,gpa2,gpa5,CC8,cr8,sc8,CC9,cr9,sc9;
	private JTextField semyear;
	private JTable deletetable;
	private JTextField sem;
	private JTextField eyrs;
	private JTextField yrs;
	public JTextField log;
	public ResultMain() {
		setResizable(false);
		setBackground(Color.WHITE);
		con = SqliteConnection.dbConnector();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(70, 130, 180));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblResultCalculation = new JLabel("Result Calculation");
		lblResultCalculation.setIcon(new ImageIcon(ResultMain.class.getResource("/IMG/images (1).jpg")));
		lblResultCalculation.setBackground(new Color(0, 128, 128));
		lblResultCalculation.setForeground(new Color(0, 0, 0));
		lblResultCalculation.setBounds(5, 0, 1909, 175);
		lblResultCalculation.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultCalculation.setFont(new Font("Algerian", Font.BOLD, 40));
		contentPane.add(lblResultCalculation);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setForeground(Color.BLACK);
		tabbedPane.setBackground(new Color(0, 128, 128));
		tabbedPane.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 23));
		tabbedPane.setBounds(5, 176, 1920, 1012);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(176, 196, 222));
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab("Result", new ImageIcon(ResultMain.class.getResource("/IMG/images (9).png")), panel, null);
		panel.setLayout(null);
		
		JLabel lblName = new JLabel("Name (*)");
		lblName.setForeground(Color.YELLOW);
		lblName.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(275, 144, 112, 36);
		panel.add(lblName);
		
		name = new JTextField();
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		name.setBackground(UIManager.getColor("Button.background"));
		name.setBounds(168, 181, 314, 44);
		panel.add(name);
		name.setColumns(10);
		
		session = new JTextField();
		session.setHorizontalAlignment(SwingConstants.CENTER);
		session.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		session.setBackground(UIManager.getColor("Button.background"));
		session.setColumns(10);
		session.setBounds(549, 181, 210, 44);
		panel.add(session);
		
		JLabel lblSession = new JLabel("Session (*)");
		lblSession.setForeground(Color.YELLOW);
		lblSession.setHorizontalAlignment(SwingConstants.CENTER);
		lblSession.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		lblSession.setBounds(572, 144, 165, 36);
		panel.add(lblSession);
		
		ID = new JTextField();
		ID.setHorizontalAlignment(SwingConstants.CENTER);
		ID.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		ID.setBackground(UIManager.getColor("Button.background"));
		ID.setColumns(10);
		ID.setBounds(1094, 181, 205, 44);
		panel.add(ID);
		
		JLabel lblExamYear = new JLabel("ID No (*)");
		lblExamYear.setForeground(Color.YELLOW);
		lblExamYear.setHorizontalAlignment(SwingConstants.CENTER);
		lblExamYear.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		lblExamYear.setBounds(1109, 144, 177, 36);
		panel.add(lblExamYear);
		
		year = new JTextField();
		year.setHorizontalAlignment(SwingConstants.CENTER);
		year.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		year.setBackground(UIManager.getColor("Button.background"));
		year.setColumns(10);
		year.setBounds(1358, 181, 185, 44);
		panel.add(year);
		
		JLabel lblSemester = new JLabel("Exam year (*)");
		lblSemester.setForeground(Color.YELLOW);
		lblSemester.setHorizontalAlignment(SwingConstants.CENTER);
		lblSemester.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		lblSemester.setBounds(1348, 144, 205, 36);
		panel.add(lblSemester);
		
		CC1 = new JTextField();
		CC1.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		CC1.setBackground(UIManager.getColor("Button.background"));
		CC1.setColumns(10);
		CC1.setBounds(168, 302, 165, 46);
		panel.add(CC1);
		
		JLabel lblCourseCode = new JLabel("Course Code");
		lblCourseCode.setForeground(Color.YELLOW);
		lblCourseCode.setHorizontalAlignment(SwingConstants.CENTER);
		lblCourseCode.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		lblCourseCode.setBounds(178, 245, 153, 44);
		panel.add(lblCourseCode);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(ResultMain.class.getResource("/IMG/images (7).png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nam = name.getText();
				String ses = session.getText();
				String id = ID.getText();
				String sems = sem.getText();
				String yr = year.getText();
				String course1 = CC1.getText();
				String score1 = sc1.getText();
				String course2 = CC2.getText();
				String score2 = sc2.getText();
				String course3 = CC3.getText();
				String score3 = sc3.getText();
				String course4 = CC4.getText();
				String score4 = sc4.getText();
				String course5 = CC5.getText();
				String score5 = sc5.getText();
				String course6 = CC6.getText();
				String score6 = sc6.getText();
				String course7 = CC7.getText();
				String course8 = CC8.getText();
				String course9 = CC9.getText();
				String score7 = sc7.getText();
				String score8 = sc8.getText();
				String score9 = sc9.getText();
				String fResult = res.getText();
				String Cr1 = cr1.getText();
				String Cr2 = cr2.getText();
				String Cr3 = cr3.getText();
				String Cr4 = cr4.getText();
				String Cr5 = cr5.getText();
				String Cr6 = cr6.getText();
				String Cr7 = cr7.getText();
				String Cr8 = cr8.getText();
				String Cr9 = cr9.getText();
				
				String query = "";
				
				if(nam.isEmpty() || ses.isEmpty() || id.isEmpty() || yr.isEmpty() || fResult.isEmpty() || sems.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please fill out all (*) marked field.");
				}
				else {
					query = "insert into ResultTable (Name,Session,ID,Semester,Course1,Credit1,CGPA1,Course2,Credit2,CGPA2,Course3,Credit3,CGPA3,Course4,Credit4,CGPA4,Course5,Credit5,CGPA5,Course6,Credit6,CGPA6,Course7,Credit7,CGPA7,Course8,Credit8,CGPA8,Course9,Credit9,CGPA9,FinalResult,ExamYear) Values('"+nam+"','"+ses+"','"+id+"','"+sems+"','"+course1+"','"+Cr1+"','"+score1+"','"+course2+"','"+Cr2+"','"+score2+"','"+course3+"','"+Cr3+"','"+score3+"','"+course4+"','"+Cr4+"','"+score4+"','"+course5+"','"+Cr5+"','"+score5+"','"+course6+"','"+Cr6+"','"+score6+"','"+course7+"','"+Cr7+"','"+score7+"','"+course8+"','"+Cr8+"','"+score8+"','"+course9+"','"+Cr9+"','"+score9+"','"+fResult+"','"+yr+"')";

					try {
						Statement st = con.createStatement();
						
						st.execute(query);
						
						JOptionPane.showMessageDialog(null, "Information has been added Successfully");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		});
		btnNewButton_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		btnNewButton_1.setBounds(1453, 637, 89, 44);
		panel.add(btnNewButton_1);
		
		JLabel lblCredit = new JLabel("Credit");
		lblCredit.setHorizontalAlignment(SwingConstants.CENTER);
		lblCredit.setForeground(Color.YELLOW);
		lblCredit.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		lblCredit.setBounds(345, 244, 100, 46);
		panel.add(lblCredit);
		
		cr1 = new JTextField();
		cr1.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		cr1.setBackground(UIManager.getColor("Button.background"));
		cr1.setBounds(345, 301, 100, 47);
		panel.add(cr1);
		cr1.setColumns(10);
		
		sc1 = new JTextField();
		sc1.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		sc1.setBackground(UIManager.getColor("Button.background"));
		sc1.setColumns(10);
		sc1.setBounds(457, 302, 100, 46);
		panel.add(sc1);
		
		JLabel lblScore = new JLabel("Score");
		lblScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore.setForeground(Color.YELLOW);
		lblScore.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		lblScore.setBounds(468, 253, 89, 29);
		panel.add(lblScore);
		
		CC4 = new JTextField();
		CC4.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		CC4.setBackground(UIManager.getColor("Button.background"));
		CC4.setColumns(10);
		CC4.setBounds(168, 409, 165, 46);
		panel.add(CC4);
		
		JLabel label = new JLabel("Course Code");
		label.setForeground(Color.YELLOW);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		label.setBounds(172, 361, 161, 37);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Credit");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.YELLOW);
		label_1.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		label_1.setBounds(345, 361, 100, 37);
		panel.add(label_1);
		
		cr4 = new JTextField();
		cr4.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		cr4.setBackground(UIManager.getColor("Button.background"));
		cr4.setColumns(10);
		cr4.setBounds(345, 409, 100, 47);
		panel.add(cr4);
		
		JLabel lblCgpa = new JLabel("Score");
		lblCgpa.setHorizontalAlignment(SwingConstants.CENTER);
		lblCgpa.setForeground(Color.YELLOW);
		lblCgpa.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		lblCgpa.setBounds(457, 362, 100, 29);
		panel.add(lblCgpa);
		
		sc4 = new JTextField();
		sc4.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		sc4.setBackground(UIManager.getColor("Button.background"));
		sc4.setColumns(10);
		sc4.setBounds(457, 409, 100, 46);
		panel.add(sc4);
		
		CC7 = new JTextField();
		CC7.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		CC7.setBackground(UIManager.getColor("Button.background"));
		CC7.setColumns(10);
		CC7.setBounds(172, 530, 165, 46);
		panel.add(CC7);
		
		JLabel label_3 = new JLabel("Course Code");
		label_3.setForeground(Color.YELLOW);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		label_3.setBounds(176, 476, 157, 44);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("Credit");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(Color.YELLOW);
		label_4.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		label_4.setBounds(345, 484, 100, 36);
		panel.add(label_4);
		
		cr7 = new JTextField();
		cr7.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		cr7.setBackground(UIManager.getColor("Button.background"));
		cr7.setColumns(10);
		cr7.setBounds(345, 530, 100, 47);
		panel.add(cr7);
		
		JLabel lblCgpa_1 = new JLabel("Score");
		lblCgpa_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCgpa_1.setForeground(Color.YELLOW);
		lblCgpa_1.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		lblCgpa_1.setBounds(466, 488, 91, 29);
		panel.add(lblCgpa_1);
		
		sc7 = new JTextField();
		sc7.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		sc7.setBackground(UIManager.getColor("Button.background"));
		sc7.setColumns(10);
		sc7.setBounds(461, 530, 96, 46);
		panel.add(sc7);
		
		JLabel label_6 = new JLabel("Course Code");
		label_6.setForeground(Color.YELLOW);
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		label_6.setBounds(653, 252, 165, 29);
		panel.add(label_6);
		
		CC2 = new JTextField();
		CC2.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		CC2.setBackground(UIManager.getColor("Button.background"));
		CC2.setColumns(10);
		CC2.setBounds(653, 301, 165, 46);
		panel.add(CC2);
		
		JLabel label_7 = new JLabel("Course Code");
		label_7.setForeground(Color.YELLOW);
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		label_7.setBounds(653, 364, 165, 29);
		panel.add(label_7);
		
		CC5 = new JTextField();
		CC5.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		CC5.setBackground(UIManager.getColor("Button.background"));
		CC5.setColumns(10);
		CC5.setBounds(653, 409, 165, 46);
		panel.add(CC5);
		
		cr5 = new JTextField();
		cr5.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		cr5.setBackground(UIManager.getColor("Button.background"));
		cr5.setColumns(10);
		cr5.setBounds(830, 409, 100, 48);
		panel.add(cr5);
		
		JLabel label_10 = new JLabel("Credit");
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setForeground(Color.YELLOW);
		label_10.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		label_10.setBounds(830, 365, 100, 29);
		panel.add(label_10);
		
		JLabel label_11 = new JLabel("Credit");
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setForeground(Color.YELLOW);
		label_11.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		label_11.setBounds(830, 252, 100, 29);
		panel.add(label_11);
		
		cr2 = new JTextField();
		cr2.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		cr2.setBackground(UIManager.getColor("Button.background"));
		cr2.setColumns(10);
		cr2.setBounds(830, 301, 100, 47);
		panel.add(cr2);
		
		sc2 = new JTextField();
		sc2.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		sc2.setBackground(new Color(255, 240, 245));
		sc2.setColumns(10);
		sc2.setBounds(942, 301, 100, 46);
		panel.add(sc2);
		
		JLabel lblCgpa_2 = new JLabel("Score");
		lblCgpa_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblCgpa_2.setForeground(Color.YELLOW);
		lblCgpa_2.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		lblCgpa_2.setBounds(942, 252, 100, 29);
		panel.add(lblCgpa_2);
		
		JLabel lblCgpa_3 = new JLabel("Score");
		lblCgpa_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblCgpa_3.setForeground(Color.YELLOW);
		lblCgpa_3.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		lblCgpa_3.setBounds(942, 364, 90, 29);
		panel.add(lblCgpa_3);
		
		sc5 = new JTextField();
		sc5.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		sc5.setBackground(UIManager.getColor("Button.background"));
		sc5.setColumns(10);
		sc5.setBounds(942, 409, 100, 49);
		panel.add(sc5);
		
		JLabel label_15 = new JLabel("Course Code");
		label_15.setForeground(Color.YELLOW);
		label_15.setHorizontalAlignment(SwingConstants.CENTER);
		label_15.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		label_15.setBounds(1137, 253, 162, 29);
		panel.add(label_15);
		
		CC3 = new JTextField();
		CC3.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		CC3.setBackground(UIManager.getColor("Button.background"));
		CC3.setColumns(10);
		CC3.setBounds(1134, 302, 165, 46);
		panel.add(CC3);
		
		JLabel label_26 = new JLabel("Course Code");
		label_26.setForeground(Color.YELLOW);
		label_26.setHorizontalAlignment(SwingConstants.CENTER);
		label_26.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		label_26.setBounds(1137, 365, 162, 29);
		panel.add(label_26);
		
		CC6 = new JTextField();
		CC6.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		CC6.setBackground(UIManager.getColor("Button.background"));
		CC6.setColumns(10);
		CC6.setBounds(1134, 409, 165, 46);
		panel.add(CC6);
		
		cr6 = new JTextField();
		cr6.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		cr6.setBackground(UIManager.getColor("Button.background"));
		cr6.setColumns(10);
		cr6.setBounds(1323, 409, 100, 46);
		panel.add(cr6);
		
		JLabel label_30 = new JLabel("Credit");
		label_30.setHorizontalAlignment(SwingConstants.CENTER);
		label_30.setForeground(Color.YELLOW);
		label_30.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		label_30.setBounds(1313, 365, 100, 29);
		panel.add(label_30);
		
		JLabel label_31 = new JLabel("Credit");
		label_31.setHorizontalAlignment(SwingConstants.CENTER);
		label_31.setForeground(Color.YELLOW);
		label_31.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		label_31.setBounds(1327, 253, 96, 29);
		panel.add(label_31);
		
		cr3 = new JTextField();
		cr3.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		cr3.setBackground(UIManager.getColor("Button.background"));
		cr3.setColumns(10);
		cr3.setBounds(1323, 302, 100, 46);
		panel.add(cr3);
		
		sc3 = new JTextField();
		sc3.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		sc3.setBackground(new Color(255, 240, 245));
		sc3.setColumns(10);
		sc3.setBounds(1443, 302, 100, 46);
		panel.add(sc3);
		
		JLabel lblCgpa_4 = new JLabel("Score");
		lblCgpa_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblCgpa_4.setForeground(Color.YELLOW);
		lblCgpa_4.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		lblCgpa_4.setBounds(1443, 253, 100, 29);
		panel.add(lblCgpa_4);
		
		JLabel lblCgpa_5 = new JLabel("Score");
		lblCgpa_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblCgpa_5.setForeground(Color.YELLOW);
		lblCgpa_5.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		lblCgpa_5.setBounds(1453, 365, 90, 29);
		panel.add(lblCgpa_5);
		
		sc6 = new JTextField();
		sc6.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		sc6.setBackground(new Color(255, 240, 245));
		sc6.setColumns(10);
		sc6.setBounds(1443, 409, 100, 47);
		panel.add(sc6);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(ResultMain.class.getResource("/IMG/images (2).jpg")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(cr1.getText().isEmpty())
					cr1.setText("0.0");
				else
					cr11 = Float.parseFloat(cr1.getText());
				if(sc1.getText().isEmpty())
					sc1.setText("0.0");
				else
					sc11 = Float.parseFloat(sc1.getText());
				if(cr2.getText().isEmpty())
					cr2.setText("0.0");
				else
					cr12 = Float.parseFloat(cr2.getText());
				if(sc2.getText().isEmpty())
					sc2.setText("0.0");
				else
					sc12 = Float.parseFloat(sc2.getText());
				if(cr3.getText().isEmpty())
					cr3.setText("0.0");
				else
					cr13 = Float.parseFloat(cr3.getText());
				if(sc3.getText().isEmpty())
					sc3.setText("0.0");
				else
					sc13 = Float.parseFloat(sc3.getText());
				if(cr4.getText().isEmpty())
					cr4.setText("0.0");
				else
					cr14 = Float.parseFloat(cr4.getText());
				if(sc4.getText().isEmpty())
					sc4.setText("0.0");
				else
				 sc14 = Float.parseFloat(sc4.getText());
				if(cr5.getText().isEmpty())
					cr5.setText("0.0");
				else
				 cr15 = Float.parseFloat(cr5.getText());
				if(sc5.getText().isEmpty())
					sc5.setText("0.0");
				else
				 sc15 = Float.parseFloat(sc5.getText());
				if(cr6.getText().isEmpty())
					cr6.setText("0.0");
				else
				 cr16 = Float.parseFloat(cr6.getText());
				if(sc6.getText().isEmpty())
					sc6.setText("0.0");
				 sc16 = Float.parseFloat(sc6.getText());
				if(cr7.getText().isEmpty())
					cr7.setText("0.0");
				else
				 cr17 = Float.parseFloat(cr7.getText());
				if(sc7.getText().isEmpty())
					sc7.setText("0.0");
				else 
				  sc17 = Float.parseFloat(sc7.getText());
				if(cr8.getText().isEmpty())
					cr8.setText("0.0");
				else
				 cr18 = Float.parseFloat(cr8.getText());
				if(sc8.getText().isEmpty())
					sc8.setText("0.0");
				else 
				  sc18 = Float.parseFloat(sc8.getText());
				if(cr9.getText().isEmpty())
					cr9.setText("0.0");
				else
				 cr19 = Float.parseFloat(cr9.getText());
				if(sc9.getText().isEmpty())
					sc9.setText("0.0");
				else 
				  sc19 = Float.parseFloat(sc7.getText());
				
				
				res1 = (cr11*sc11 + cr12*sc12 + cr13*sc13 + cr14*sc14 + cr15*sc15 + cr16*sc16 + cr18*sc18+cr19*sc19+cr17*sc17)/ (cr11+cr12+cr13+cr14+cr15+cr16+cr17+cr18+cr19); 
				JOptionPane.showMessageDialog(null, "Name: "+name.getText()+"   "+"ID No: "+ID.getText()+"   Semester: "+sem.getText()+"   Session: "+session.getText()+"   Result : "+res1);
				String res2 = String.valueOf(res1);
				res.setText(res2);
			}
		});
		
		JLabel lblFinalResult = new JLabel("Final Result (*)");
		lblFinalResult.setForeground(Color.YELLOW);
		lblFinalResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblFinalResult.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblFinalResult.setBounds(932, 637, 252, 41);
		panel.add(lblFinalResult);
		
		res = new JTextField();
		res.setEditable(false);
		res.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		res.setBackground(UIManager.getColor("Button.background"));
		res.setColumns(10);
		res.setBounds(1171, 637, 228, 44);
		panel.add(res);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(0, 128, 128));
		btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		btnNewButton.setBounds(770, 637, 104, 44);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Add Information of Student");
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setForeground(Color.YELLOW);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 35));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 39, 1735, 69);
		panel.add(lblNewLabel_1);
		
		JLabel label_5 = new JLabel("Course Code");
		label_5.setForeground(Color.YELLOW);
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		label_5.setBounds(653, 488, 177, 29);
		panel.add(label_5);
		
		CC8 = new JTextField();
		CC8.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		CC8.setBackground(UIManager.getColor("Button.background"));
		CC8.setColumns(10);
		CC8.setBounds(653, 530, 165, 46);
		panel.add(CC8);
		
		cr8 = new JTextField();
		cr8.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		cr8.setBackground(UIManager.getColor("Button.background"));
		cr8.setColumns(10);
		cr8.setBounds(830, 530, 100, 46);
		panel.add(cr8);
		
		JLabel label_8 = new JLabel("Credit");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setForeground(Color.YELLOW);
		label_8.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		label_8.setBounds(820, 487, 100, 29);
		panel.add(label_8);
		
		JLabel lblGpa_7 = new JLabel("Score");
		lblGpa_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblGpa_7.setForeground(Color.YELLOW);
		lblGpa_7.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		lblGpa_7.setBounds(932, 487, 100, 29);
		panel.add(lblGpa_7);
		
		sc8 = new JTextField();
		sc8.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		sc8.setBackground(UIManager.getColor("Button.background"));
		sc8.setColumns(10);
		sc8.setBounds(942, 530, 100, 46);
		panel.add(sc8);
		
		CC9 = new JTextField();
		CC9.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		CC9.setBackground(UIManager.getColor("Button.background"));
		CC9.setColumns(10);
		CC9.setBounds(1134, 530, 165, 47);
		panel.add(CC9);
		
		JLabel label_22 = new JLabel("Course Code");
		label_22.setForeground(Color.YELLOW);
		label_22.setHorizontalAlignment(SwingConstants.CENTER);
		label_22.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		label_22.setBounds(1134, 484, 165, 29);
		panel.add(label_22);
		
		JLabel label_25 = new JLabel("Credit");
		label_25.setHorizontalAlignment(SwingConstants.CENTER);
		label_25.setForeground(Color.YELLOW);
		label_25.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		label_25.setBounds(1313, 491, 100, 29);
		panel.add(label_25);
		
		cr9 = new JTextField();
		cr9.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		cr9.setBackground(UIManager.getColor("Button.background"));
		cr9.setColumns(10);
		cr9.setBounds(1323, 530, 100, 47);
		panel.add(cr9);
		
		JLabel lblGpa_8 = new JLabel("Score");
		lblGpa_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblGpa_8.setForeground(Color.YELLOW);
		lblGpa_8.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		lblGpa_8.setBounds(1452, 491, 91, 29);
		panel.add(lblGpa_8);
		
		sc9 = new JTextField();
		sc9.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		sc9.setBackground(new Color(255, 240, 245));
		sc9.setColumns(10);
		sc9.setBounds(1443, 530, 100, 47);
		panel.add(sc9);
		
		JButton clearButton = new JButton("");
		clearButton.setIcon(new ImageIcon(ResultMain.class.getResource("/IMG/index.jpg")));
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name.setText(""); session.setText(""); ID.setText(""); year.setText(""); sem.setText("");
				CC1.setText(""); CC2.setText(""); CC3.setText(""); CC4.setText(""); CC5.setText(""); CC6.setText(""); CC7.setText(""); CC8.setText("");CC9.setText("");
				cr1.setText(""); cr2.setText(""); cr3.setText(""); cr4.setText(""); cr5.setText(""); cr6.setText(""); cr7.setText(""); cr8.setText(""); cr9.setText(""); 
				sc1.setText(""); sc2.setText(""); sc3.setText(""); sc4.setText(""); sc5.setText(""); sc6.setText(""); sc7.setText(""); sc8.setText(""); sc9.setText("");
				res.setText("");
			}
		});
		clearButton.setBounds(1510, 52, 89, 44);
		panel.add(clearButton);
		
		JLabel lblSemester_1 = new JLabel("Semester (*)");
		lblSemester_1.setForeground(Color.YELLOW);
		lblSemester_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSemester_1.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		lblSemester_1.setBounds(831, 144, 205, 36);
		panel.add(lblSemester_1);
		
		sem = new JTextField();
		sem.setHorizontalAlignment(SwingConstants.CENTER);
		sem.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		sem.setColumns(10);
		sem.setBackground(SystemColor.menu);
		sem.setBounds(845, 181, 176, 44);
		panel.add(sem);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(ResultMain.class.getResource("/IMG/main1.jpeg")));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(0, 0, 1735, 868);
		panel.add(lblNewLabel_4);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		tabbedPane.addTab("Search", new ImageIcon(ResultMain.class.getResource("/IMG/images79.png")), panel_2, null);
		panel_2.setLayout(null);
		
		IDno = new JTextField();
		IDno.setHorizontalAlignment(SwingConstants.CENTER);
		IDno.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		IDno.setBackground(UIManager.getColor("Button.background"));
		IDno.setColumns(10);
		IDno.setBounds(336, 154, 256, 48);
		panel_2.add(IDno);
		
		JLabel label_16 = new JLabel("ID NO");
		label_16.setForeground(Color.YELLOW);
		label_16.setHorizontalAlignment(SwingConstants.CENTER);
		label_16.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		label_16.setBounds(212, 151, 112, 45);
		panel_2.add(label_16);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon(ResultMain.class.getResource("/IMG/images (6).png")));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String idno = IDno.getText();
				
				
				String query1 = "select * from ResultTable where ID = '"+idno+"'";
				
				try {
					Statement st1 = con.createStatement();

					ResultSet rs1 = st1.executeQuery(query1);					
					
					searchtable.setModel(DbUtils.resultSetToTableModel(rs1));
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBackground(Color.DARK_GRAY);
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		btnNewButton_2.setBounds(403, 231, 91, 36);
		panel_2.add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane(searchtable,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(12, 331, 1699, 351);
		panel_2.add(scrollPane);
		
		searchtable = new JTable();
		searchtable.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
		searchtable.setBackground(new Color(153, 153, 153));
		searchtable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane.setViewportView(searchtable);
		
		JLabel lblNewLabel = new JLabel("Individual Result");
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(235, 83, 363, 60);
		panel_2.add(lblNewLabel);
		
		JLabel lblSemesterResult = new JLabel("Semester Result");
		lblSemesterResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblSemesterResult.setForeground(Color.YELLOW);
		lblSemesterResult.setFont(new Font("Segoe UI", Font.BOLD, 35));
		lblSemesterResult.setBackground(Color.LIGHT_GRAY);
		lblSemesterResult.setBounds(1115, 83, 363, 60);
		panel_2.add(lblSemesterResult);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(ResultMain.class.getResource("/IMG/images (6).png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String smstr = semestr.getText();
				String emr = eyrs.getText();
				
				String query3 = "select * from ResultTable where Semester = '"+smstr+"' and ExamYear = '"+emr+"'";
			
				try {
					Statement st3 = con.createStatement();
					
					ResultSet rs3 = st3.executeQuery(query3);
					
					searchtable.setModel(DbUtils.resultSetToTableModel(rs3));
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		button.setBackground(Color.DARK_GRAY);
		button.setBounds(1329, 263, 91, 36);
		panel_2.add(button);
		
		JLabel lblSemester_2 = new JLabel("Semester");
		lblSemester_2.setForeground(Color.YELLOW);
		lblSemester_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblSemester_2.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		lblSemester_2.setBounds(1031, 154, 217, 43);
		panel_2.add(lblSemester_2);
		
		semestr = new JTextField();
		semestr.setHorizontalAlignment(SwingConstants.CENTER);
		semestr.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		semestr.setBackground(UIManager.getColor("Button.background"));
		semestr.setColumns(10);
		semestr.setBounds(1227, 154, 256, 41);
		panel_2.add(semestr);
		
		eyrs = new JTextField();
		eyrs.setHorizontalAlignment(SwingConstants.CENTER);
		eyrs.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		eyrs.setColumns(10);
		eyrs.setBackground(SystemColor.menu);
		eyrs.setBounds(1227, 210, 256, 43);
		panel_2.add(eyrs);
		
		JLabel lblExamYear_1 = new JLabel("Exam Year");
		lblExamYear_1.setForeground(Color.YELLOW);
		lblExamYear_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblExamYear_1.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		lblExamYear_1.setBounds(1031, 212, 217, 38);
		panel_2.add(lblExamYear_1);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon(ResultMain.class.getResource("/IMG/main1.jpeg")));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(0, 0, 1735, 868);
		panel_2.add(lblNewLabel_5);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("Update", new ImageIcon(ResultMain.class.getResource("/IMG/images (2).png")), panel_1, null);
		panel_1.setLayout(null);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setIcon(new ImageIcon(ResultMain.class.getResource("/IMG/images (5).png")));
		btnNewButton_3.setBackground(Color.DARK_GRAY);
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String SEM = IdNo.getText();
		    	
		    	String query5 = "select * from ResultTable where ID='"+SEM+"'";
				
			
				try {
					Statement st5 = con.createStatement();
					
					ResultSet rs5 = st5.executeQuery(query5);
					
					updatetable.setModel(DbUtils.resultSetToTableModel(rs5));
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton_3.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnNewButton_3.setBounds(483, 11, 89, 36);
		panel_1.add(btnNewButton_3);
		
		JScrollPane scrollPane_1 = new JScrollPane(updatetable,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane_1.setBounds(23, 72, 1684, 157);
		panel_1.add(scrollPane_1);
		
		updatetable = new JTable();
		updatetable.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
		updatetable.setBackground(new Color(153, 153, 153));
		updatetable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		updatetable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = updatetable.getSelectedRow();
				String n = updatetable.getModel().getValueAt(row, 0).toString();
				String ses = updatetable.getModel().getValueAt(row, 3).toString();
				
				String query8 = "select * from ResultTable where Name= '"+n+"' and Semester = '"+ses+"'"; 
				try {
					java.sql.Statement st8 = con.createStatement();
					ResultSet rs8 = st8.executeQuery(query8);
					
					while(rs8.next()){
						nam.setText(rs8.getString("Name"));
						sess.setText(rs8.getString("Session"));
						idn.setText(rs8.getString("ID"));
						eyr.setText(rs8.getString("ExamYear"));
						subj.setText(rs8.getString("Semester"));
						gpa1.setText(rs8.getString("CGPA1"));
						gpa2.setText(rs8.getString("CGPA2"));
						gpa3.setText(rs8.getString("CGPA3"));
						gpa4.setText(rs8.getString("CGPA4"));
						gpa5.setText(rs8.getString("CGPA5"));
						gpa6.setText(rs8.getString("CGPA6"));
						gpa7.setText(rs8.getString("CGPA7"));
						gpa8.setText(rs8.getString("CGPA8"));
						gpa9.setText(rs8.getString("CGPA9"));
						code1.setText(rs8.getString("Course1"));
						code2.setText(rs8.getString("Course2"));
						code3.setText(rs8.getString("Course3"));
						code4.setText(rs8.getString("Course4"));
						code5.setText(rs8.getString("Course5"));
						code6.setText(rs8.getString("Course6"));
						code7.setText(rs8.getString("Course7"));
						code8.setText(rs8.getString("Course8"));
						code9.setText(rs8.getString("Course9"));
						credit1.setText(rs8.getString("Credit1"));
						credit2.setText(rs8.getString("Credit2"));
						credit3.setText(rs8.getString("Credit3"));
						credit4.setText(rs8.getString("Credit4"));
						credit5.setText(rs8.getString("Credit5"));
						credit6.setText(rs8.getString("Credit6"));
						credit7.setText(rs8.getString("Credit7"));
						credit8.setText(rs8.getString("Credit8"));
						credit9.setText(rs8.getString("Credit9"));	
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		scrollPane_1.setViewportView(updatetable);
		
		JLabel lblName_1 = new JLabel("Name (*)");
		lblName_1.setForeground(Color.YELLOW);
		lblName_1.setBackground(new Color(176, 196, 222));
		lblName_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblName_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblName_1.setBounds(411, 266, 112, 29);
		panel_1.add(lblName_1);
		
		nam = new JTextField();
		nam.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		nam.setBackground(UIManager.getColor("Button.background"));
		nam.setColumns(10);
		nam.setBounds(310, 292, 327, 36);
		panel_1.add(nam);
		
		JLabel lblSession_1 = new JLabel("Session (*)");
		lblSession_1.setForeground(Color.YELLOW);
		lblSession_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSession_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblSession_1.setBounds(659, 266, 155, 29);
		panel_1.add(lblSession_1);
		
		sess = new JTextField();
		sess.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		sess.setBackground(UIManager.getColor("Button.background"));
		sess.setColumns(10);
		sess.setBounds(647, 292, 195, 36);
		panel_1.add(sess);
		
		JLabel lblSemester_3 = new JLabel("Semester (*)");
		lblSemester_3.setForeground(Color.YELLOW);
		lblSemester_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblSemester_3.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblSemester_3.setBounds(884, 266, 112, 29);
		panel_1.add(lblSemester_3);
		
		subj = new JTextField();
		subj.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		subj.setBackground(UIManager.getColor("Button.background"));
		subj.setColumns(10);
		subj.setBounds(857, 292, 176, 36);
		panel_1.add(subj);
		
		JLabel lblIdNo = new JLabel("ID NO (*)");
		lblIdNo.setForeground(Color.YELLOW);
		lblIdNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdNo.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblIdNo.setBounds(1086, 262, 112, 29);
		panel_1.add(lblIdNo);
		
		idn = new JTextField();
		idn.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		idn.setBackground(UIManager.getColor("Button.background"));
		idn.setColumns(10);
		idn.setBounds(1043, 292, 205, 36);
		panel_1.add(idn);
		
		JLabel lblSemesterexamYear_1 = new JLabel("Exam Year (*)");
		lblSemesterexamYear_1.setForeground(Color.YELLOW);
		lblSemesterexamYear_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSemesterexamYear_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblSemesterexamYear_1.setBounds(1257, 262, 205, 29);
		panel_1.add(lblSemesterexamYear_1);
		
		eyr = new JTextField();
		eyr.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		eyr.setBackground(UIManager.getColor("Button.background"));
		eyr.setColumns(10);
		eyr.setBounds(1270, 292, 176, 36);
		panel_1.add(eyr);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.setIcon(new ImageIcon(ResultMain.class.getResource("/IMG/images14.png")));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = nam.getText();
				String session = sess.getText();
				String id = idn.getText();
				String exmyr = eyr.getText();
				String subjt = subj.getText();
				String course1 = code1.getText();
				String score1 = gpa1.getText();
				String Credit1 = credit1.getText();
				String course2 = code2.getText();
				String score2 = gpa2.getText();
				String Credit2 = credit2.getText();
				String course3 = code3.getText();
				String score3 = gpa3.getText();
				String Credit3 = credit3.getText();
				String course4 = code4.getText();
				String score4 = gpa4.getText();
				String Credit4 = credit4.getText();
				String course5 = code5.getText();
				String score5 = gpa5.getText();
				String Credit5 = credit5.getText();
				String course6 = code6.getText();
				String score6 = gpa6.getText();
				String Credit6 = credit6.getText();
				String course7 = code7.getText();
				String score7 = gpa7.getText();
				String Credit7 = credit7.getText();
				String course8 = code8.getText();
				String score8 = gpa8.getText();
				String Credit8 = credit8.getText();
				String course9 = code9.getText();
				String score9 = gpa9.getText();
				String Credit9 = credit9.getText();
				String fResult = RES.getText();
				
				if(name.isEmpty() || session.isEmpty() || id.isEmpty() || exmyr.isEmpty() || subjt.isEmpty() || fResult.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please fill out all (*) marked field.");
				}
				else {
					String query7 = "Update ResultTable Set Name='"+name+"',Session = '"+session+"',ID = '"+id+"', Semester = '"+subjt+"',ExamYear = '"+exmyr+"', Course1 = '"+course1+"',Credit1 = '"+Credit1+"',CGPA1 = '"+score1+"',Course2 = '"+course2+"',Credit2 = '"+Credit2+"',CGPA2 = '"+score2+"',Course3 = '"+course3+"',Credit3 = '"+Credit3+"',CGPA3 = '"+score3+"',Course4 = '"+course4+"',Credit4 = '"+Credit4+"',CGPA4 = '"+score4+"' ,Course5 = '"+course5+"',Credit5 = '"+Credit5+"',CGPA5 = '"+score5+"' ,Course6 = '"+course6+"',Credit6 = '"+Credit6+"',CGPA6 ='"+score6+"' ,Course7 = '"+course7+"',Credit7 = '"+Credit7+"',CGPA7 = '"+score7+"',Course8 = '"+course8+"',Credit8 = '"+Credit8+"',CGPA8 = '"+score8+"',Course9 = '"+course9+"',Credit9 = '"+Credit9+"',CGPA9 = '"+score9+"',FinalResult = '"+fResult+"' where ID ='"+id+"' and Semester = '"+subjt+"'";
					
					try {
						Statement st7 = con.createStatement();
						st7.execute(query7);
						JOptionPane.showMessageDialog(null, "Information has been Updated Successsfully!");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
			
		});
		btnNewButton_4.setForeground(Color.WHITE);
		btnNewButton_4.setBackground(Color.DARK_GRAY);
		btnNewButton_4.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnNewButton_4.setBounds(1281, 691, 89, 43);
		panel_1.add(btnNewButton_4);
		
		IdNo = new JTextField();
		IdNo.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		IdNo.setBackground(UIManager.getColor("Button.background"));
		IdNo.setColumns(10);
		IdNo.setBounds(178, 11, 267, 36);
		panel_1.add(IdNo);
		
		JLabel lblSemesterexamYear = new JLabel("ID No");
		lblSemesterexamYear.setForeground(Color.YELLOW);
		lblSemesterexamYear.setBackground(new Color(128, 128, 128));
		lblSemesterexamYear.setHorizontalAlignment(SwingConstants.CENTER);
		lblSemesterexamYear.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		lblSemesterexamYear.setBounds(10, 11, 205, 35);
		panel_1.add(lblSemesterexamYear);
		
		JLabel label_2 = new JLabel("Course Code");
		label_2.setForeground(Color.YELLOW);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		label_2.setBounds(230, 360, 132, 29);
		panel_1.add(label_2);
		
		code1 = new JTextField();
		code1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		code1.setBackground(UIManager.getColor("Button.background"));
		code1.setColumns(10);
		code1.setBounds(230, 400, 138, 36);
		panel_1.add(code1);
		
		JLabel lblGpa_1 = new JLabel("GPA");
		lblGpa_1.setForeground(Color.YELLOW);
		lblGpa_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblGpa_1.setBounds(502, 361, 61, 29);
		panel_1.add(lblGpa_1);
		
		gpa1 = new JTextField();
		gpa1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		gpa1.setBackground(UIManager.getColor("Button.background"));
		gpa1.setColumns(10);
		gpa1.setBounds(479, 400, 100, 36);
		panel_1.add(gpa1);
		
		JLabel lblGpa = new JLabel("GPA");
		lblGpa.setForeground(Color.YELLOW);
		lblGpa.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblGpa.setBounds(506, 447, 61, 29);
		panel_1.add(lblGpa);
		
		gpa4 = new JTextField();
		gpa4.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		gpa4.setBackground(UIManager.getColor("Button.background"));
		gpa4.setColumns(10);
		gpa4.setBounds(483, 487, 100, 36);
		panel_1.add(gpa4);
		
		JLabel label_13 = new JLabel("Course Code");
		label_13.setForeground(Color.YELLOW);
		label_13.setHorizontalAlignment(SwingConstants.CENTER);
		label_13.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		label_13.setBounds(234, 447, 132, 29);
		panel_1.add(label_13);
		
		code4 = new JTextField();
		code4.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		code4.setBackground(UIManager.getColor("Button.background"));
		code4.setColumns(10);
		code4.setBounds(230, 487, 138, 36);
		panel_1.add(code4);
		
		JLabel label_14 = new JLabel("Course Code");
		label_14.setForeground(Color.YELLOW);
		label_14.setHorizontalAlignment(SwingConstants.CENTER);
		label_14.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		label_14.setBounds(699, 359, 132, 29);
		panel_1.add(label_14);
		
		code2 = new JTextField();
		code2.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		code2.setBackground(UIManager.getColor("Button.background"));
		code2.setColumns(10);
		code2.setBounds(695, 399, 132, 36);
		panel_1.add(code2);
		
		JLabel label_17 = new JLabel("Course Code");
		label_17.setForeground(Color.YELLOW);
		label_17.setHorizontalAlignment(SwingConstants.CENTER);
		label_17.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		label_17.setBounds(695, 447, 132, 29);
		panel_1.add(label_17);
		
		code5 = new JTextField();
		code5.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		code5.setBackground(UIManager.getColor("Button.background"));
		code5.setColumns(10);
		code5.setBounds(695, 487, 132, 36);
		panel_1.add(code5);
		
		JLabel lblGpa_3 = new JLabel("Credit");
		lblGpa_3.setForeground(Color.YELLOW);
		lblGpa_3.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblGpa_3.setBounds(860, 360, 61, 29);
		panel_1.add(lblGpa_3);
		
		credit2 = new JTextField();
		credit2.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		credit2.setBackground(UIManager.getColor("Button.background"));
		credit2.setColumns(10);
		credit2.setBounds(837, 400, 100, 36);
		panel_1.add(credit2);
		
		JLabel lblGpa_4 = new JLabel("Credit");
		lblGpa_4.setForeground(Color.YELLOW);
		lblGpa_4.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblGpa_4.setBounds(860, 447, 61, 29);
		panel_1.add(lblGpa_4);
		
		credit5 = new JTextField();
		credit5.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		credit5.setBackground(UIManager.getColor("Button.background"));
		credit5.setColumns(10);
		credit5.setBounds(837, 486, 100, 36);
		panel_1.add(credit5);
		
		JLabel label_27 = new JLabel("Course Code");
		label_27.setForeground(Color.YELLOW);
		label_27.setHorizontalAlignment(SwingConstants.CENTER);
		label_27.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		label_27.setBounds(1156, 360, 132, 29);
		panel_1.add(label_27);
		
		code3 = new JTextField();
		code3.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		code3.setBackground(UIManager.getColor("Button.background"));
		code3.setColumns(10);
		code3.setBounds(1152, 400, 138, 36);
		panel_1.add(code3);
		
		JLabel label_28 = new JLabel("Course Code");
		label_28.setForeground(Color.YELLOW);
		label_28.setHorizontalAlignment(SwingConstants.CENTER);
		label_28.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		label_28.setBounds(1156, 448, 132, 29);
		panel_1.add(label_28);
		
		code6 = new JTextField();
		code6.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		code6.setBackground(UIManager.getColor("Button.background"));
		code6.setColumns(10);
		code6.setBounds(1152, 488, 138, 36);
		panel_1.add(code6);
		
		JLabel lblGpa_5 = new JLabel("GPA");
		lblGpa_5.setForeground(Color.YELLOW);
		lblGpa_5.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblGpa_5.setBounds(1415, 362, 61, 29);
		panel_1.add(lblGpa_5);
		
		gpa3 = new JTextField();
		gpa3.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		gpa3.setBackground(UIManager.getColor("Button.background"));
		gpa3.setColumns(10);
		gpa3.setBounds(1398, 400, 100, 36);
		panel_1.add(gpa3);
		
		JLabel lblGpa_6 = new JLabel("GPA");
		lblGpa_6.setForeground(Color.YELLOW);
		lblGpa_6.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblGpa_6.setBounds(1415, 450, 61, 29);
		panel_1.add(lblGpa_6);
		
		gpa6 = new JTextField();
		gpa6.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		gpa6.setBackground(UIManager.getColor("Button.background"));
		gpa6.setColumns(10);
		gpa6.setBounds(1398, 487, 100, 36);
		panel_1.add(gpa6);
		
		code7 = new JTextField();
		code7.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		code7.setBackground(UIManager.getColor("Button.background"));
		code7.setColumns(10);
		code7.setBounds(230, 574, 138, 36);
		panel_1.add(code7);
		
		JLabel label_35 = new JLabel("Course Code");
		label_35.setForeground(Color.YELLOW);
		label_35.setHorizontalAlignment(SwingConstants.CENTER);
		label_35.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		label_35.setBounds(234, 534, 132, 29);
		panel_1.add(label_35);
		
		JLabel lblGpa_2 = new JLabel("GPA");
		lblGpa_2.setForeground(Color.YELLOW);
		lblGpa_2.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblGpa_2.setBounds(502, 535, 61, 29);
		panel_1.add(lblGpa_2);
		
		gpa7 = new JTextField();
		gpa7.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		gpa7.setBackground(UIManager.getColor("Button.background"));
		gpa7.setColumns(10);
		gpa7.setBounds(483, 574, 96, 36);
		panel_1.add(gpa7);
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				float cr111 = Float.parseFloat(credit1.getText());
				float cr112 = Float.parseFloat(credit2.getText());
				float cr113 = Float.parseFloat(credit3.getText());
				float cr114 = Float.parseFloat(credit4.getText());
				float cr115 = Float.parseFloat(credit5.getText());
				float cr116 = Float.parseFloat(credit6.getText());
				float cr117 = Float.parseFloat(credit7.getText());
				float cr118 = Float.parseFloat(credit8.getText());
				float cr119 = Float.parseFloat(credit9.getText());
				float sc111 = Float.parseFloat(gpa1.getText());
				float sc112 = Float.parseFloat(gpa2.getText());
				float sc113 = Float.parseFloat(gpa3.getText());
				float sc114 = Float.parseFloat(gpa4.getText());
				float sc115 = Float.parseFloat(gpa5.getText());
				float sc116 = Float.parseFloat(gpa6.getText());
				float sc117 = Float.parseFloat(gpa7.getText());
				float sc118 = Float.parseFloat(gpa8.getText());
				float sc119 = Float.parseFloat(gpa9.getText());
			
				float res11 = (cr111*sc111 + cr112*sc112 + cr113*sc113 + cr114*sc114 + cr115*sc115 + cr116*sc116 + cr117*sc117)/ (cr111+cr112+cr113+cr114+cr115+cr116+cr117); 
				JOptionPane.showMessageDialog(null, "Updated Result\nName: "+nam.getText()+"  "+"ID: "+idn.getText()+"\n"+subj.getText()+" Semester's Result is: "+res11);
				String res12 = String.valueOf(res11);
				RES.setText(res12);
			}
		});
		button_1.setIcon(new ImageIcon(ResultMain.class.getResource("/IMG/images (2).jpg")));
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		button_1.setBackground(new Color(0, 128, 128));
		button_1.setBounds(605, 690, 106, 44);
		panel_1.add(button_1);
		
		JLabel lblFinalResult_1 = new JLabel("Final Result (*)");
		lblFinalResult_1.setForeground(new Color(255, 255, 51));
		lblFinalResult_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblFinalResult_1.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblFinalResult_1.setBounds(742, 700, 240, 29);
		panel_1.add(lblFinalResult_1);
		
		RES = new JTextField();
		RES.setEditable(false);
		RES.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		RES.setBackground(UIManager.getColor("Button.background"));
		RES.setColumns(10);
		RES.setBounds(991, 691, 228, 43);
		panel_1.add(RES);
		
		JLabel lblCredit_1 = new JLabel("Credit");
		lblCredit_1.setForeground(Color.YELLOW);
		lblCredit_1.setBackground(new Color(176, 196, 222));
		lblCredit_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblCredit_1.setBounds(395, 359, 61, 29);
		panel_1.add(lblCredit_1);
		
		credit1 = new JTextField();
		credit1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		credit1.setBackground(UIManager.getColor("Button.background"));
		credit1.setColumns(10);
		credit1.setBounds(372, 399, 100, 36);
		panel_1.add(credit1);
		
		JLabel lblCredit_2 = new JLabel("Credit");
		lblCredit_2.setForeground(Color.YELLOW);
		lblCredit_2.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblCredit_2.setBounds(399, 446, 61, 29);
		panel_1.add(lblCredit_2);
		
		credit4 = new JTextField();
		credit4.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		credit4.setBackground(UIManager.getColor("Button.background"));
		credit4.setColumns(10);
		credit4.setBounds(376, 486, 100, 36);
		panel_1.add(credit4);
		
		JLabel lblCredit_3 = new JLabel("Credit");
		lblCredit_3.setForeground(Color.YELLOW);
		lblCredit_3.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblCredit_3.setBounds(395, 534, 61, 29);
		panel_1.add(lblCredit_3);
		
		credit7 = new JTextField();
		credit7.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		credit7.setBackground(UIManager.getColor("Button.background"));
		credit7.setColumns(10);
		credit7.setBounds(376, 573, 96, 36);
		panel_1.add(credit7);
		
		JLabel label_12 = new JLabel("GPA");
		label_12.setForeground(Color.YELLOW);
		label_12.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		label_12.setBounds(970, 535, 61, 29);
		panel_1.add(label_12);
		
		gpa8 = new JTextField();
		gpa8.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		gpa8.setBackground(UIManager.getColor("Button.background"));
		gpa8.setColumns(10);
		gpa8.setBounds(951, 574, 96, 36);
		panel_1.add(gpa8);
		
		JLabel lblCredit_4 = new JLabel("Credit");
		lblCredit_4.setForeground(Color.YELLOW);
		lblCredit_4.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblCredit_4.setBounds(856, 534, 61, 29);
		panel_1.add(lblCredit_4);
		
		credit8 = new JTextField();
		credit8.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		credit8.setBackground(UIManager.getColor("Button.background"));
		credit8.setColumns(10);
		credit8.setBounds(837, 573, 96, 36);
		panel_1.add(credit8);
		
		code8 = new JTextField();
		code8.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		code8.setBackground(UIManager.getColor("Button.background"));
		code8.setColumns(10);
		code8.setBounds(691, 574, 138, 36);
		panel_1.add(code8);
		
		JLabel label_23 = new JLabel("Course Code");
		label_23.setForeground(Color.YELLOW);
		label_23.setHorizontalAlignment(SwingConstants.CENTER);
		label_23.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		label_23.setBounds(695, 534, 132, 29);
		panel_1.add(label_23);
		
		JLabel label_24 = new JLabel("GPA");
		label_24.setForeground(Color.YELLOW);
		label_24.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		label_24.setBounds(1421, 535, 61, 29);
		panel_1.add(label_24);
		
		gpa9 = new JTextField();
		gpa9.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		gpa9.setBackground(UIManager.getColor("Button.background"));
		gpa9.setColumns(10);
		gpa9.setBounds(1402, 574, 96, 36);
		panel_1.add(gpa9);
		
		JLabel lblCredit_7 = new JLabel("Credit");
		lblCredit_7.setForeground(Color.YELLOW);
		lblCredit_7.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblCredit_7.setBounds(1314, 534, 61, 29);
		panel_1.add(lblCredit_7);
		
		credit9 = new JTextField();
		credit9.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		credit9.setBackground(UIManager.getColor("Button.background"));
		credit9.setColumns(10);
		credit9.setBounds(1295, 573, 96, 36);
		panel_1.add(credit9);
		
		code9 = new JTextField();
		code9.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		code9.setBackground(UIManager.getColor("Button.background"));
		code9.setColumns(10);
		code9.setBounds(1149, 574, 138, 36);
		panel_1.add(code9);
		
		JLabel label_29 = new JLabel("Course Code");
		label_29.setForeground(Color.YELLOW);
		label_29.setHorizontalAlignment(SwingConstants.CENTER);
		label_29.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		label_29.setBounds(1153, 534, 132, 29);
		panel_1.add(label_29);
		
		JLabel lblCredit_5 = new JLabel("Credit");
		lblCredit_5.setForeground(Color.YELLOW);
		lblCredit_5.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblCredit_5.setBounds(1310, 362, 61, 29);
		panel_1.add(lblCredit_5);
		
		credit3 = new JTextField();
		credit3.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		credit3.setBackground(UIManager.getColor("Button.background"));
		credit3.setColumns(10);
		credit3.setBounds(1293, 400, 100, 36);
		panel_1.add(credit3);
		
		JLabel lblCredit_6 = new JLabel("Credit");
		lblCredit_6.setForeground(Color.YELLOW);
		lblCredit_6.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblCredit_6.setBounds(1310, 450, 61, 29);
		panel_1.add(lblCredit_6);
		
		credit6 = new JTextField();
		credit6.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		credit6.setBackground(UIManager.getColor("Button.background"));
		credit6.setColumns(10);
		credit6.setBounds(1293, 488, 100, 36);
		panel_1.add(credit6);
		
		gpa2 = new JTextField();
		gpa2.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		gpa2.setBackground(UIManager.getColor("Button.background"));
		gpa2.setColumns(10);
		gpa2.setBounds(947, 400, 100, 36);
		panel_1.add(gpa2);
		
		JLabel label_34 = new JLabel("GPA");
		label_34.setForeground(Color.YELLOW);
		label_34.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		label_34.setBounds(970, 448, 61, 29);
		panel_1.add(label_34);
		
		gpa5 = new JTextField();
		gpa5.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		gpa5.setBackground(UIManager.getColor("Button.background"));
		gpa5.setColumns(10);
		gpa5.setBounds(947, 487, 100, 36);
		panel_1.add(gpa5);
		
		JLabel label_36 = new JLabel("GPA");
		label_36.setForeground(Color.YELLOW);
		label_36.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		label_36.setBounds(963, 359, 61, 29);
		panel_1.add(label_36);
		
		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nam.setText(""); sess.setText(""); idn.setText(""); subj.setText(""); eyr.setText("");
				code1.setText(""); code2.setText(""); code3.setText(""); code4.setText(""); code5.setText(""); code6.setText(""); code7.setText(""); code8.setText(""); code9.setText("");
				credit1.setText(""); credit2.setText(""); credit3.setText(""); credit4.setText(""); credit5.setText(""); credit6.setText(""); credit7.setText(""); credit8.setText(""); credit9.setText(""); 
				gpa1.setText(""); gpa2.setText(""); gpa3.setText(""); gpa4.setText(""); gpa5.setText(""); gpa6.setText(""); gpa7.setText(""); gpa8.setText(""); gpa9.setText(""); 
				RES.setText(""); IdNo.setText("");
			}
		});
		btnNewButton_5.setIcon(new ImageIcon(ResultMain.class.getResource("/IMG/index.jpg")));
		btnNewButton_5.setBounds(1409, 691, 89, 43);
		panel_1.add(btnNewButton_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(ResultMain.class.getResource("/IMG/main1.jpeg")));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(0, 0, 1735, 868);
		panel_1.add(lblNewLabel_6);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		tabbedPane.addTab("Delete", new ImageIcon(ResultMain.class.getResource("/IMG/index2.jpg")), panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Semester");
		lblNewLabel_2.setForeground(Color.YELLOW);
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(55, 96, 142, 45);
		panel_3.add(lblNewLabel_2);
		
		semyear = new JTextField();
		semyear.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		semyear.setBackground(UIManager.getColor("Button.background"));
		semyear.setBounds(194, 96, 264, 45);
		panel_3.add(semyear);
		semyear.setColumns(10);
		
		JButton btnNewButton_6 = new JButton("");
		btnNewButton_6.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String smstryr = semyear.getText();
				String yer = yrs.getText();
				
				String query10 = "select * from ResultTable where Semester = '"+smstryr+"' and ExamYear = '"+yer+"'";
			
				try {
					Statement st10 = con.createStatement();
					
					ResultSet rs10 = st10.executeQuery(query10);
					
					deletetable.setModel(DbUtils.resultSetToTableModel(rs10));
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton_6.setIcon(new ImageIcon(ResultMain.class.getResource("/IMG/images (6).png")));
		btnNewButton_6.setBounds(499, 126, 92, 37);
		panel_3.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("");
		btnNewButton_7.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int choice  = JOptionPane.showConfirmDialog(null, "Are you sure to Delete?","Confirmation",JOptionPane.YES_NO_OPTION);
			if(choice == JOptionPane.YES_OPTION){
				int row = deletetable.getSelectedRow();
				
				if(row >= 0){ 
					String n = deletetable.getModel().getValueAt(row, 2).toString(); 
					String n1 = deletetable.getModel().getValueAt(row, 3).toString();
					String n2 = deletetable.getModel().getValueAt(row, 32).toString();
		        try{
		        	String query8 = "delete from ResultTable where ID = '"+n+"'and Semester='"+n1+"' and ExamYear='"+n2+"'"; 
		
		           PreparedStatement pstmt = con.prepareStatement(query8);
		            
		            pstmt.execute();
		          
		            pstmt.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		        try {
		        	String smtryr = semyear.getText();
					String year = yrs.getText();
					String query12 = "select * from ResultTable where Semester = '"+smtryr+"' and ExamYear='"+year+"'" ;
					java.sql.Statement st12 = con.createStatement();
					
					ResultSet rs12 = st12.executeQuery(query12);
					deletetable.setModel(DbUtils.resultSetToTableModel(rs12));
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        JOptionPane.showMessageDialog(null, "Data has been Deleted Successfully");
				}
				else {
					JOptionPane.showMessageDialog(null, "No Data is selected or No Data is Available");
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "No Data has been Deleted");
			}	
			}
		});
		btnNewButton_7.setIcon(new ImageIcon(ResultMain.class.getResource("/IMG/index1.jpg")));
		btnNewButton_7.setBounds(634, 126, 92, 37);
		panel_3.add(btnNewButton_7);
		
		JScrollPane scrollPane_2 = new JScrollPane(deletetable,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane_2.setBounds(52, 298, 1647, 394);
		panel_3.add(scrollPane_2);
		
		deletetable = new JTable();
		deletetable.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
		deletetable.setBackground(new Color(153, 153, 153));
		deletetable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane_2.setViewportView(deletetable);
		
		yrs = new JTextField();
		yrs.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		yrs.setColumns(10);
		yrs.setBackground(SystemColor.menu);
		yrs.setBounds(194, 148, 264, 45);
		panel_3.add(yrs);
		
		JLabel lblExamYear_2 = new JLabel("Exam Year");
		lblExamYear_2.setForeground(Color.YELLOW);
		lblExamYear_2.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		lblExamYear_2.setBounds(55, 148, 142, 45);
		panel_3.add(lblExamYear_2);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(ResultMain.class.getResource("/IMG/main1.jpeg")));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(0, 0, 1735, 868);
		panel_3.add(lblNewLabel_7);
		
		JLabel lblNewLabel_3 = new JLabel("Log in as");
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(1556, 48, 122, 40);
		contentPane.add(lblNewLabel_3);
		
		log = new JTextField();
		log.setHorizontalAlignment(SwingConstants.CENTER);
		log.setEditable(false);
		log.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		log.setBounds(1677, 51, 196, 34);
		contentPane.add(log);
		log.setColumns(10);
		
		JButton btnNewButton_8 = new JButton("Log Out");
		btnNewButton_8.setBackground(new Color(0, 153, 204));
		btnNewButton_8.setForeground(new Color(0, 0, 0));
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				FirstPage first = new FirstPage();
				first.setVisible(true);
				JOptionPane.showMessageDialog(null, "You have successfully Logged out");
			}
		});
		btnNewButton_8.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnNewButton_8.setBounds(1752, 90, 122, 40);
		contentPane.add(btnNewButton_8);
		
	}
}
