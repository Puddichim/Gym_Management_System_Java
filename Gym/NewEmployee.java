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
import program.*;
import java.awt.Color;
import java.awt.Toolkit;
public class NewEmployee extends JFrame {

	private JPanel contentPane;
	private JTextField namefield;
	private JTextField agefield;
	private JTextField phonefield;
	private JTextField salaryfield;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewEmployee frame = new NewEmployee();
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
	public NewEmployee() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(NewEmployee.class.getResource("/img/icons8-gym-100.png")));
		JLabel idlabel = new JLabel("number");
		idlabel.setBackground(new Color(238, 232, 170));
		try {
			int id = 1;
			String str1 = String.valueOf(id);
			idlabel.setText(str1);
			Connection con = ConnectionProvider.getCon();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select max(id) from employee");
			while(rs.next()) {
				id = rs.getInt(1);
				id = id+1;
				String str = String.valueOf(id);
				idlabel.setText(str);
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
		setBounds(100, 100, 600, 502);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(238, 232, 170));
		contentPane.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New Employee");
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
		
		JLabel lblNewLabel_1_4_2 = new JLabel("Phone Number");
		lblNewLabel_1_4_2.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblNewLabel_1_4_2.setBounds(40, 247, 159, 28);
		contentPane.add(lblNewLabel_1_4_2);
		
		
		idlabel.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		idlabel.setBounds(229, 95, 137, 28);
		contentPane.add(idlabel);
		
		namefield = new JTextField();
		namefield.setBackground(new Color(238, 232, 170));
		namefield.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		namefield.setBounds(229, 133, 301, 28);
		contentPane.add(namefield);
		namefield.setColumns(10);
		
		agefield = new JTextField();
		agefield.setBackground(new Color(238, 232, 170));
		agefield.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		agefield.setColumns(10);
		agefield.setBounds(229, 209, 301, 28);
		contentPane.add(agefield);
		
		phonefield = new JTextField();
		phonefield.setBackground(new Color(238, 232, 170));
		phonefield.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		phonefield.setColumns(10);
		phonefield.setBounds(229, 247, 301, 28);
		contentPane.add(phonefield);
		
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
		JButton savebutton = new JButton("Save");
		savebutton.setBackground(new Color(238, 232, 170));
		savebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String gender = "Male";
				switch(comboBox.getSelectedIndex()) {
				case 0:
					Employee temp = new Trainers(namefield.getText(),Integer.parseInt(agefield.getText()),Integer.parseInt(idlabel.getText()),gender,Float.parseFloat(salaryfield.getText()),phonefield.getText());
					if(radio1.isSelected()) {
						gender = "Male";
						temp = new Trainers(namefield.getText(),Integer.parseInt(agefield.getText()),Integer.parseInt(idlabel.getText()),gender,Float.parseFloat(salaryfield.getText()),phonefield.getText());
					}
					else if (radio2.isSelected()) {
						gender = "Female";
						temp = new Trainers(namefield.getText(),Integer.parseInt(agefield.getText()),Integer.parseInt(idlabel.getText()),gender,Float.parseFloat(salaryfield.getText()),phonefield.getText());
					}
					else {
						gender = "Other";
						temp = new Trainers(namefield.getText(),Integer.parseInt(agefield.getText()),Integer.parseInt(idlabel.getText()),gender,Float.parseFloat(salaryfield.getText()),phonefield.getText());
					}
					try {
						Connection con = ConnectionProvider.getCon();
						PreparedStatement ps = con.prepareStatement("INSERT INTO employee values (?,?,?,?,?,?,?,?)");
						ps.setInt(1, temp.getID());
						ps.setString(3, temp.getName());
						ps.setString(4, temp.getGender());
						ps.setInt(5, temp.getAge());
						ps.setString(6,temp.getPhoneNum());
						ps.setString(2, comboBox.getSelectedItem().toString());
						ps.setFloat(7, temp.getSalary());
						ps.setString(8, "");
						ps.executeUpdate();
						JOptionPane.showMessageDialog(null,"Successfully saved!");
						setVisible(false);
						new NewEmployee().setVisible(true);
					}
					catch(Exception ex){
						ex.printStackTrace();
						JOptionPane.showMessageDialog(null, e);
					}
					break;
				case 1:
					Employee temp2 = new Caretaker(namefield.getText(),Integer.parseInt(agefield.getText()),Integer.parseInt(idlabel.getText()),gender,Float.parseFloat(salaryfield.getText()),phonefield.getText());
					if(radio1.isSelected()) {
						gender = "Male";
						temp2 = new Caretaker(namefield.getText(),Integer.parseInt(agefield.getText()),Integer.parseInt(idlabel.getText()),gender,Float.parseFloat(salaryfield.getText()),phonefield.getText());
					}
					else if (radio2.isSelected()) {
						gender = "Female";
						temp2 = new Caretaker(namefield.getText(),Integer.parseInt(agefield.getText()),Integer.parseInt(idlabel.getText()),gender,Float.parseFloat(salaryfield.getText()),phonefield.getText());
					}
					else {
						gender = "Other";
						temp2 = new Caretaker(namefield.getText(),Integer.parseInt(agefield.getText()),Integer.parseInt(idlabel.getText()),gender,Float.parseFloat(salaryfield.getText()),phonefield.getText());
					}
					try {
						Connection con = ConnectionProvider.getCon();
						PreparedStatement ps = con.prepareStatement("INSERT INTO employee values (?,?,?,?,?,?,?,?)");
						ps.setInt(1, temp2.getID());
						ps.setString(3, temp2.getName());
						ps.setString(4, temp2.getGender());
						ps.setInt(5, temp2.getAge());
						ps.setString(6,temp2.getPhoneNum());
						ps.setString(2, comboBox.getSelectedItem().toString());
						ps.setFloat(7, temp2.getSalary());
						ps.setString(8, "");
						ps.executeUpdate();
						JOptionPane.showMessageDialog(null,"Successfully saved!");
						setVisible(false);
						new NewEmployee().setVisible(true);
					}
					catch(Exception ex){
						ex.printStackTrace();
						JOptionPane.showMessageDialog(null, e);
					}
					break;
				case 2:
					Employee temp3 = new Dietician(namefield.getText(),Integer.parseInt(agefield.getText()),Integer.parseInt(idlabel.getText()),gender,Float.parseFloat(salaryfield.getText()),phonefield.getText());
					if(radio1.isSelected()) {
						gender = "Male";
						temp3 = new Dietician(namefield.getText(),Integer.parseInt(agefield.getText()),Integer.parseInt(idlabel.getText()),gender,Float.parseFloat(salaryfield.getText()),phonefield.getText());
					}
					else if (radio2.isSelected()) {
						gender = "Female";
						temp3 = new Dietician(namefield.getText(),Integer.parseInt(agefield.getText()),Integer.parseInt(idlabel.getText()),gender,Float.parseFloat(salaryfield.getText()),phonefield.getText());
					}
					else {
						gender = "Other";
						temp3 = new Dietician(namefield.getText(),Integer.parseInt(agefield.getText()),Integer.parseInt(idlabel.getText()),gender,Float.parseFloat(salaryfield.getText()),phonefield.getText());
					}
					try {
						Connection con = ConnectionProvider.getCon();
						PreparedStatement ps = con.prepareStatement("INSERT INTO employee values (?,?,?,?,?,?,?,?)");
						ps.setInt(1, temp3.getID());
						ps.setString(3, temp3.getName());
						ps.setString(4, temp3.getGender());
						ps.setInt(5, temp3.getAge());
						ps.setString(6,temp3.getPhoneNum());
						ps.setString(2, comboBox.getSelectedItem().toString());
						ps.setFloat(7, temp3.getSalary());
						ps.setString(8, "");
						ps.executeUpdate();
						JOptionPane.showMessageDialog(null,"Successfully saved!");
						setVisible(false);
						new NewEmployee().setVisible(true);
					}
					catch(Exception ex){
						ex.printStackTrace();
						JOptionPane.showMessageDialog(null, e);
					}
					break;
				case 3:
					Employee temp4 = new Security(namefield.getText(),Integer.parseInt(agefield.getText()),Integer.parseInt(idlabel.getText()),gender,Float.parseFloat(salaryfield.getText()),phonefield.getText());
					if(radio1.isSelected()) {
						gender = "Male";
						temp4 = new Security(namefield.getText(),Integer.parseInt(agefield.getText()),Integer.parseInt(idlabel.getText()),gender,Float.parseFloat(salaryfield.getText()),phonefield.getText());
					}
					else if (radio2.isSelected()) {
						gender = "Female";
						temp4 = new Security(namefield.getText(),Integer.parseInt(agefield.getText()),Integer.parseInt(idlabel.getText()),gender,Float.parseFloat(salaryfield.getText()),phonefield.getText());
					}
					else {
						gender = "Other";
						temp4 = new Security(namefield.getText(),Integer.parseInt(agefield.getText()),Integer.parseInt(idlabel.getText()),gender,Float.parseFloat(salaryfield.getText()),phonefield.getText());
					}
					try {
						Connection con = ConnectionProvider.getCon();
						PreparedStatement ps = con.prepareStatement("INSERT INTO employee values (?,?,?,?,?,?,?,?)");
						ps.setInt(1, temp4.getID());
						ps.setString(3, temp4.getName());
						ps.setString(4, temp4.getGender());
						ps.setInt(5, temp4.getAge());
						ps.setString(6,temp4.getPhoneNum());
						ps.setString(2, comboBox.getSelectedItem().toString());
						ps.setFloat(7, temp4.getSalary());
						ps.setString(8, "");
						ps.executeUpdate();
						JOptionPane.showMessageDialog(null,"Successfully saved!");
						setVisible(false);
						new NewEmployee().setVisible(true);
					}
					catch(Exception ex){
						ex.printStackTrace();
						JOptionPane.showMessageDialog(null, e);
					}
					break;
				case 4:
					Employee temp5 = new OfficeService(namefield.getText(),Integer.parseInt(agefield.getText()),Integer.parseInt(idlabel.getText()),gender,Float.parseFloat(salaryfield.getText()),phonefield.getText());
					if(radio1.isSelected()) {
						gender = "Male";
						temp5 = new OfficeService(namefield.getText(),Integer.parseInt(agefield.getText()),Integer.parseInt(idlabel.getText()),gender,Float.parseFloat(salaryfield.getText()),phonefield.getText());
					}
					else if (radio2.isSelected()) {
						gender = "Female";
						temp5 = new OfficeService(namefield.getText(),Integer.parseInt(agefield.getText()),Integer.parseInt(idlabel.getText()),gender,Float.parseFloat(salaryfield.getText()),phonefield.getText());
					}
					else {
						gender = "Other";
						temp5 = new OfficeService(namefield.getText(),Integer.parseInt(agefield.getText()),Integer.parseInt(idlabel.getText()),gender,Float.parseFloat(salaryfield.getText()),phonefield.getText());
					}
					try {
						Connection con = ConnectionProvider.getCon();
						PreparedStatement ps = con.prepareStatement("INSERT INTO employee values (?,?,?,?,?,?,?,?)");
						ps.setInt(1, temp5.getID());
						ps.setString(3, temp5.getName());
						ps.setString(4, temp5.getGender());
						ps.setInt(5, temp5.getAge());
						ps.setString(6,temp5.getPhoneNum());
						ps.setString(2, comboBox.getSelectedItem().toString());
						ps.setFloat(7, temp5.getSalary());
						ps.setString(8, "");
						ps.executeUpdate();
						JOptionPane.showMessageDialog(null,"Successfully saved!");
						setVisible(false);
						new NewEmployee().setVisible(true);
					}
					catch(Exception ex){
						ex.printStackTrace();
						JOptionPane.showMessageDialog(null, e);
					}
					break;
				default:
					break;
				}
			}
		});
		savebutton.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		savebutton.setBounds(64, 377, 173, 55);
		contentPane.add(savebutton);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBackground(new Color(238, 232, 170));
		btnReset.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				namefield.setText("");
				agefield.setText("");
				phonefield.setText("");
				salaryfield.setText("");
				radio1.setSelected(true);
				radio2.setSelected(false);
				radio3.setSelected(false);
			}
		});
		btnReset.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnReset.setBounds(320, 377, 173, 55);
		contentPane.add(btnReset);
		
		
		comboBox.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Trainer", "Caretaker", "Dietician", "Security", "Office Service"}));
		comboBox.setBounds(229, 325, 301, 28);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_1_4_1_1 = new JLabel("Job");
		lblNewLabel_1_4_1_1.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblNewLabel_1_4_1_1.setBounds(40, 323, 159, 28);
		contentPane.add(lblNewLabel_1_4_1_1);
		
		salaryfield = new JTextField();
		salaryfield.setBackground(new Color(238, 232, 170));
		salaryfield.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		salaryfield.setColumns(10);
		salaryfield.setBounds(229, 287, 301, 28);
		contentPane.add(salaryfield);
		
		JLabel lblNewLabel_1_4_2_1 = new JLabel("Salary");
		lblNewLabel_1_4_2_1.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblNewLabel_1_4_2_1.setBounds(40, 285, 159, 28);
		contentPane.add(lblNewLabel_1_4_2_1);
		
	}
	
	
}
