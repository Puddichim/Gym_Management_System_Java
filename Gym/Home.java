import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Toolkit;

public class Home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Home.class.getResource("/img/icons8-gym-100.png")));
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(238, 232, 170));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorder(new LineBorder(new Color(0, 0, 0)));
		menuBar.setAutoscrolls(true);
		menuBar.setBackground(new Color(135, 206, 250));
		menuBar.setBounds(0, 0, 1379, 218);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("List of members");
		mnNewMenu.setDelay(20);
		mnNewMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				new ListOfMembers().setVisible(true);
			}
		});
		mnNewMenu.setFont(new Font("Century Gothic", Font.BOLD, 12));
		mnNewMenu.setPreferredSize(new Dimension(170, 24));
		mnNewMenu.setIcon(new ImageIcon(Home.class.getResource("/img/icons8-person-64.png")));
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1_1 = new JMenu("Update/Delete member");
		mnNewMenu_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				new UpdateDeleteMember().setVisible(true);
			}
		});
		mnNewMenu_1_1.setDelay(20);
		
		JMenu mnNewMenu_1 = new JMenu("Add member");
		mnNewMenu_1.setDelay(20);
		menuBar.add(mnNewMenu_1);
		mnNewMenu_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new NewMember().setVisible(true);
			}
		});
		mnNewMenu_1.setFont(new Font("Century Gothic", Font.BOLD, 12));
		mnNewMenu_1.setPreferredSize(new Dimension(170, 100));
		mnNewMenu_1.setIcon(new ImageIcon(Home.class.getResource("/img/icons8-add-64.png")));
		mnNewMenu_1_1.setFont(new Font("Century Gothic", Font.BOLD, 12));
		mnNewMenu_1_1.setIcon(new ImageIcon(Home.class.getResource("/img/icons8-update-48.png")));
		mnNewMenu_1_1.setPreferredSize(new Dimension(210, 24));
		menuBar.add(mnNewMenu_1_1);
		
		JMenu mnNewMenu_1_1_1 = new JMenu("Payment");
		mnNewMenu_1_1_1.setDelay(20);
		mnNewMenu_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				new Payment().setVisible(true);
			}
		});

		mnNewMenu_1_1_1.setFont(new Font("Century Gothic", Font.BOLD, 12));
		mnNewMenu_1_1_1.setIcon(new ImageIcon(Home.class.getResource("/img/icons8-payment-check-48.png")));
		mnNewMenu_1_1_1.setPreferredSize(new Dimension(150, 24));
		menuBar.add(mnNewMenu_1_1_1);
		
		JMenu mnNewMenu_1_1_1_1 = new JMenu("Logout");
		mnNewMenu_1_1_1_1.setDelay(20);
		mnNewMenu_1_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int a =JOptionPane.showConfirmDialog(null, "Do you really want to Logout","Select",JOptionPane.YES_NO_OPTION);
				if(a==0) {
					setVisible(false);
					new login().setVisible(true);
				}
			}
		});
		
		JMenu mnNewMenu_2 = new JMenu("Add Employee");
		mnNewMenu_2.setDelay(20);
		mnNewMenu_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				new NewEmployee().setVisible(true);
			}
		});
		mnNewMenu_2.setIcon(new ImageIcon(Home.class.getResource("/img/icons8-add-reminder-50.png")));
		menuBar.add(mnNewMenu_2);
		
		JMenu mnNewMenu_3 = new JMenu("Update/Delete Employee");
		mnNewMenu_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				new UpdateDeleteEmployee().setVisible(true);
			}
		});
		mnNewMenu_3.setDelay(20);
		menuBar.add(mnNewMenu_3);
		mnNewMenu_3.setIcon(new ImageIcon(Home.class.getResource("/img/icons8-employee-50.png")));
		
		JMenu mnNewMenu_4 = new JMenu("Assign task");
		mnNewMenu_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				new GiveDuty().setVisible(true);
			}
		});
		mnNewMenu_4.setDelay(20);
		menuBar.add(mnNewMenu_4);
		mnNewMenu_4.setIcon(new ImageIcon(Home.class.getResource("/img/icons8-task-50.png")));
		mnNewMenu_1_1_1_1.setFont(new Font("Century Gothic", Font.BOLD, 12));
		mnNewMenu_1_1_1_1.setIcon(new ImageIcon(Home.class.getResource("/img/icons8-logout-48.png")));
		mnNewMenu_1_1_1_1.setPreferredSize(new Dimension(150, 24));
		menuBar.add(mnNewMenu_1_1_1_1);
		
		JLabel lblNewLabel = new JLabel("Gym Management System");
		lblNewLabel.setIcon(new ImageIcon(Home.class.getResource("/img/icons8-gym-100.png")));
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 42));
		lblNewLabel.setBounds(368, 228, 676, 178);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Home.class.getResource("/img/e9e0c02b065e4d4ffda88203e2826790.gif")));
		lblNewLabel_1.setBounds(277, 228, 782, 503);
		contentPane.add(lblNewLabel_1);
	}
}
