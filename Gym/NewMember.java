import java.awt.BorderLayout;
import program.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connection.ConnectionProvider;

import java.awt.Point;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;
public class NewMember extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewMember frame = new NewMember();
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
	public NewMember() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(NewMember.class.getResource("/img/icons8-gym-100.png")));
		JLabel textField_6 = new JLabel("number");
		textField_6.setBackground(new Color(238, 232, 170));
		try {
			int id = 1;
			String str1 = String.valueOf(id);
			textField_6.setText(str1);
			Connection con = ConnectionProvider.getCon();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select max(id) from member");
			while(rs.next()) {
				id = rs.getInt(1);
				id = id+1;
				String str = String.valueOf(id);
				textField_6.setText(str);
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e);
		}
		
		
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
			}
		});
		setLocation(new Point(175, 100));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(238, 232, 170));
		contentPane.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New Member");
		lblNewLabel.setBackground(new Color(238, 232, 170));
		lblNewLabel.setIcon(new ImageIcon(NewMember.class.getResource("/img/icons8-add-64.png")));
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 36));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 14, 586, 71);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Identity No");
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(40, 95, 137, 28);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Name Surname");
		lblNewLabel_1_1.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(40, 133, 159, 28);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Age");
		lblNewLabel_1_2.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(40, 209, 137, 28);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Gender");
		lblNewLabel_1_3.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblNewLabel_1_3.setBounds(40, 171, 137, 28);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Weight");
		lblNewLabel_1_4.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblNewLabel_1_4.setBounds(40, 285, 137, 28);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("Height");
		lblNewLabel_1_4_1.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblNewLabel_1_4_1.setBounds(40, 323, 137, 28);
		contentPane.add(lblNewLabel_1_4_1);
		
		JLabel lblNewLabel_1_4_2 = new JLabel("Phone Number");
		lblNewLabel_1_4_2.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblNewLabel_1_4_2.setBounds(40, 247, 159, 28);
		contentPane.add(lblNewLabel_1_4_2);
		
		
		textField_6.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		textField_6.setBounds(229, 95, 137, 28);
		contentPane.add(textField_6);
		
		textField = new JTextField();
		textField.setBackground(new Color(238, 232, 170));
		textField.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		textField.setBounds(229, 133, 301, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBackground(new Color(238, 232, 170));
		textField_1.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(229, 209, 301, 28);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBackground(new Color(238, 232, 170));
		textField_2.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(229, 247, 301, 28);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setBackground(new Color(238, 232, 170));
		textField_3.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		textField_3.setColumns(10);
		textField_3.setBounds(229, 285, 301, 28);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setBackground(new Color(238, 232, 170));
		textField_4.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		textField_4.setColumns(10);
		textField_4.setBounds(229, 323, 301, 28);
		contentPane.add(textField_4);
		
		JRadioButton radio1 = new JRadioButton("Male");
		radio1.setBackground(new Color(238, 232, 170));
		JRadioButton radio2 = new JRadioButton("Female");
		radio2.setBackground(new Color(238, 232, 170));
		JRadioButton radio3 = new JRadioButton("Other");
		radio3.setBackground(new Color(238, 232, 170));
		ButtonGroup group = new ButtonGroup();
		group.add(radio1);
		group.add(radio2);
		group.add(radio3);

		radio1.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		radio1.setBounds(235, 172, 75, 28);
		contentPane.add(radio1);
		
		
		radio2.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		radio2.setBounds(318, 172, 103, 28);
		contentPane.add(radio2);
		
		
		radio3.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		radio3.setBounds(423, 172, 103, 28);
		contentPane.add(radio3);
		
		
		
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(238, 232, 170));
		JButton btnNewButton = new JButton("Save");
		btnNewButton.setBackground(new Color(238, 232, 170));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Float price = 0f;
				switch(comboBox.getSelectedIndex()) {
				case 0:
					price = 200f;
					break;
				case 1:
					price = 550f;
					break;
				case 2:
					price = 1000f;
					break;
				case 3:
					price = 1800f;
					break;
				default:
					break;
				}
				Customers temp = new Customers(textField.getText(),Integer.parseInt(textField_1.getText()),Integer.parseInt(textField_6.getText()),"Male",price,Float.parseFloat(textField_3.getText()), Float.parseFloat(textField_4.getText()),textField_2.getText());
				if(radio1.isSelected()) {
					String gender = "Male";
					temp = new Customers(textField.getText(),Integer.parseInt(textField_1.getText()),Integer.parseInt(textField_6.getText()),gender,price,Float.parseFloat(textField_3.getText()), Float.parseFloat(textField_4.getText()),textField_2.getText());
				}
				else if (radio2.isSelected()) {
					String gender = "Female";
					temp = new Customers(textField.getText(),Integer.parseInt(textField_1.getText()),Integer.parseInt(textField_6.getText()),gender,price,Float.parseFloat(textField_3.getText()), Float.parseFloat(textField_4.getText()),textField_2.getText());
				}
				else {
					String gender = "Other";
					temp = new Customers(textField.getText(),Integer.parseInt(textField_1.getText()),Integer.parseInt(textField_6.getText()),gender,price,Float.parseFloat(textField_3.getText()), Float.parseFloat(textField_4.getText()),textField_2.getText());
				}
				
				String paymentplan = (String)comboBox.getSelectedItem();
				
				try {
					Connection con = ConnectionProvider.getCon();
					PreparedStatement ps = con.prepareStatement("INSERT INTO member values (?,?,?,?,?,?,?,?,?)");
					ps.setInt(1, temp.getID());
					ps.setString(2, temp.getName());
					ps.setString(3, temp.getGender());
					ps.setInt(4, temp.getAge());
					ps.setString(5,temp.getPhoneNum());
					ps.setFloat(6, temp.getWeight());
					ps.setFloat(7, temp.getHeight());
					ps.setString(8, paymentplan);
					ps.setFloat(9,temp.getPrice());
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null,"Successfully saved!");
					setVisible(false);
					new NewMember().setVisible(true);
				}
				catch(Exception ex){
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, e);
				}
			
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {}
		});
		btnNewButton.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		btnNewButton.setBounds(62, 445, 173, 55);
		contentPane.add(btnNewButton);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBackground(new Color(238, 232, 170));
		btnReset.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				radio1.setSelected(true);
				radio2.setSelected(false);
				radio3.setSelected(false);
				
			}
		});
		btnReset.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		btnReset.setBounds(318, 445, 173, 55);
		contentPane.add(btnReset);
		
		
		comboBox.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1 month plan (200tl)", "3 month plan (550tl)", "6 month plan (1000tl)", "1 year plan (1800tl)"}));
		comboBox.setBounds(229, 361, 301, 28);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_1_4_1_1 = new JLabel("Payment plan");
		lblNewLabel_1_4_1_1.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblNewLabel_1_4_1_1.setBounds(40, 361, 159, 28);
		contentPane.add(lblNewLabel_1_4_1_1);
	}
}
