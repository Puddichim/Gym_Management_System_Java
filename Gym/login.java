import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JCheckBox;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(login.class.getResource("/img/icons8-gym-100.png")));
		JCheckBox checkbox1 = new JCheckBox("Show password");
		checkbox1.setOpaque(false);
		setBackground(new Color(188, 143, 143));
		setResizable(false);
		JLabel label1 = new JLabel("Wrong username or password!");
		passwordField = new JPasswordField();
		setTitle("Login");
		setForeground(new Color(255, 255, 0));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				label1.setVisible(false);
				passwordField.setText("Enter password");
				checkbox1.setBackground(new Color(255,211,0));
			}
			@Override
			public void windowClosing(WindowEvent e) {
				int a=JOptionPane.showConfirmDialog(null, "Do you want to exit application?","Select",JOptionPane.YES_NO_OPTION);
				if (a==0) {
					System.exit(0);
				}
			}
		});
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 562, 778);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		label1.setForeground(Color.BLACK);
		label1.setIcon(new ImageIcon(login.class.getResource("/img/close_icon_143104.png")));
		label1.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		label1.setBounds(68, 148, 400, 29);
		contentPane.add(label1);
		
		JLabel lblLogn = new JLabel("LOGIN");
		lblLogn.setFont(new Font("Century Gothic", Font.BOLD, 55));
		lblLogn.setBounds(179, 28, 179, 110);
		contentPane.add(lblLogn);
		
		txtUsername = new JTextField();
		txtUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				label1.setVisible(false);
				if(txtUsername.getText().equals("Enter username"))
					txtUsername.setText("");
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtUsername.getText().equals(""))
					txtUsername.setText("Enter username");
			}
		});
		txtUsername.setToolTipText("Username");
		txtUsername.setText("Enter username");
		txtUsername.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		txtUsername.setBounds(83, 204, 361, 29);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		
		passwordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				label1.setVisible(false);
				if(passwordField.getText().equals("Enter password"))
					passwordField.setText("");
				
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(passwordField.getText().equals(""))
					passwordField.setText("Enter password");
			}
		});
		passwordField.setToolTipText("Enter password");
		passwordField.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		passwordField.setBounds(83, 276, 361, 29);
		contentPane.add(passwordField);
		
		JButton btnNewButton_1 = new JButton("Login");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtUsername.getText().equals("admin") && passwordField.getText().equals("123")) {
					setVisible(false);
					new Home().setVisible(true);
				}
				else {
					label1.setVisible(true);
				}
			}
		});
		btnNewButton_1.setFont(new Font("Century Gothic", Font.BOLD, 20));
		btnNewButton_1.setBounds(83, 344, 133, 40);
		contentPane.add(btnNewButton_1);
		
		
		checkbox1.setBackground(new Color(255, 204, 0));
		checkbox1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkbox1.isSelected()) {
					passwordField.setEchoChar((char)0);
				}
				else {
					passwordField.setEchoChar('●');
				}
			}
		});
		checkbox1.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		checkbox1.setBounds(253, 351, 149, 29);
		contentPane.add(checkbox1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(login.class.getResource("/img/6a92c52877dd8275b22759a784f305cf.jpg")));
		lblNewLabel_1.setBounds(0, 0, 580, 862);
		contentPane.add(lblNewLabel_1);
	}
}
