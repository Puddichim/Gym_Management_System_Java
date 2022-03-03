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
import java.util.concurrent.ConcurrentHashMap.KeySetView;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;
public class UpdateDeleteMember extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateDeleteMember frame = new UpdateDeleteMember();
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
	public UpdateDeleteMember() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(UpdateDeleteMember.class.getResource("/img/icons8-gym-100.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		try {
			
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
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(238, 232, 170));
		contentPane.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Update Delete Member");
		lblNewLabel.setIcon(new ImageIcon(UpdateDeleteMember.class.getResource("/img/icons8-update-48.png")));
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
		JButton btnNewButton = new JButton("Update");
		btnNewButton.setBackground(new Color(238, 232, 170));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textField_6.getText();
				String name= textField.getText();
				
				
				int age = Integer.parseInt(textField_1.getText());
				
				String phoneNumber = textField_2.getText();
				
				float weight = Float.parseFloat(textField_3.getText());
				float height = Float.parseFloat(textField_4.getText());
				
				String paymentplan = (String)comboBox.getSelectedItem();
				
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
				
				try {
					Connection con = ConnectionProvider.getCon();
					if(radio1.isSelected()) {
						String gender = "Male";
						PreparedStatement ps = con.prepareStatement("update member set name=?,gender=?,age=?,phoneNumber=?,weight=?,height=?,paymentplan=?,price=? where id=?");
						ps.setString(1,name);
						ps.setString(2,gender);
						ps.setInt(3,age);
						ps.setString(4,phoneNumber);
						ps.setFloat(5,weight);
						ps.setFloat(6,height);
						ps.setString(7,paymentplan);
						ps.setFloat(8,price);
						ps.setString(9,id);
						ps.executeUpdate();
						JOptionPane.showMessageDialog(null,"Successfully updated!");
						
					}
					else if(radio2.isSelected()) {
						String gender = "Female";
						PreparedStatement ps = con.prepareStatement("update member set name=?,gender=?,age=?,phoneNumber=?,weight=?,height=?,paymentplan=?,price=? where id=?");
						ps.setString(1,name);
						ps.setString(2,gender);
						ps.setInt(3,age);
						ps.setString(4,phoneNumber);
						ps.setFloat(5,weight);
						ps.setFloat(6,height);
						ps.setString(7,paymentplan);
						ps.setFloat(8,price);
						ps.setString(9,id);
						ps.executeUpdate();
						JOptionPane.showMessageDialog(null,"Successfully updated!");
					}
					else {
						String gender = "Other";
						PreparedStatement ps = con.prepareStatement("update member set name=?,gender=?,age=?,phoneNumber=?,weight=?,height=?,paymentplan=?,price=? where id=?");
						ps.setString(1,name);
						ps.setString(2,gender);
						ps.setInt(3,age);
						ps.setString(4,phoneNumber);
						ps.setFloat(5,weight);
						ps.setFloat(6,height);
						ps.setString(7,paymentplan);
						ps.setFloat(8,price);
						ps.setString(9,id);
						ps.executeUpdate();
						JOptionPane.showMessageDialog(null,"Successfully updated!");
					}
					

					
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null,ex);
				}
				
				
			}
		});
		
		btnNewButton.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnNewButton.setBounds(65, 468, 129, 43);
		contentPane.add(btnNewButton);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBackground(new Color(238, 232, 170));
		btnReset.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				textField_6.setEditable(true);
				textField_6.setText("");
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
		btnReset.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnReset.setBounds(401, 468, 129, 43);
		contentPane.add(btnReset);
		
		
		comboBox.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1 month plan (200tl)", "3 month plan (550tl)", "6 month plan (1000tl)", "1 year plan (1800tl)"}));
		comboBox.setBounds(229, 361, 301, 28);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_1_4_1_1 = new JLabel("Payment plan");
		lblNewLabel_1_4_1_1.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblNewLabel_1_4_1_1.setBounds(40, 361, 159, 28);
		contentPane.add(lblNewLabel_1_4_1_1);
		
		textField_6 = new JTextField();
		textField_6.setBackground(new Color(238, 232, 170));
		textField_6.setText("");
		textField_6.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		textField_6.setColumns(10);
		textField_6.setBounds(229, 95, 149, 28);
		contentPane.add(textField_6);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(new Color(238, 232, 170));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=JOptionPane.showConfirmDialog(null, "Do you really want to Delete ","Select",JOptionPane.YES_NO_OPTION);
				if(a==0) {
					String id= textField_6.getText();
					try {
						Connection con=ConnectionProvider.getCon();
						Statement st=con.createStatement();
						st.executeUpdate("delete from member where id='"+id+"'");
						JOptionPane.showMessageDialog(null, "Successfully Deleted!.");
						setVisible(false);
						new UpdateDeleteMember().setVisible(true);
					}
					catch(Exception ex){
						
					}
				}
			}
		});
		btnDelete.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnDelete.setBounds(235, 468, 129, 43);
		contentPane.add(btnDelete);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBackground(new Color(238, 232, 170));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int checkid=0;
				String id = textField_6.getText();
				try {
					Connection con = ConnectionProvider.getCon();
					Statement st = con.createStatement();
					ResultSet rs=st.executeQuery("Select *from member where id='"+id+"'");
					while(rs.next()) {
						checkid=1;
						textField_6.setEditable(false);
						textField_6.setText(rs.getString(1));
						textField.setText(rs.getString(2));
						switch (rs.getString(3)) {
						case "Male":
							radio1.setSelected(true);
							break;
						case "Female":
							radio2.setSelected(true);
							break;
						case "Other":
							radio3.setSelected(true);
							break;
						default:
							break;
						}
						textField_1.setText(rs.getString(4));
						textField_2.setText(rs.getString(5));
						textField_3.setText(rs.getString(6));
						textField_4.setText(rs.getString(7));
						switch(rs.getString(8)) {
						case "1 month plan (200tl)":
							comboBox.setSelectedIndex(0);
							break;
						case "3 month plan (550tl)":
							comboBox.setSelectedIndex(1);
							break;
						case "6 month plan (1000tl)":
							comboBox.setSelectedIndex(2);
							break;
						case "1 year plan (1800tl)":
							comboBox.setSelectedIndex(3);
							break;
						default:
							break;
								
						}
					}
					
					if(checkid==0) {
						JOptionPane.showMessageDialog(null,"Member ID does not exist!");
					}
				}
				catch(Exception exx){
					JOptionPane.showMessageDialog(null, exx);
					
				}
			}
		});
		btnSearch.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		btnSearch.setBounds(401, 80, 129, 43);
		contentPane.add(btnSearch);
	}
}
