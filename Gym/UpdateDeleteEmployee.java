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

public class UpdateDeleteEmployee extends JFrame {

	private JPanel contentPane;
	private JTextField namefield;
	private JTextField agefield;
	private JTextField phonefield;
	private JTextField salaryfied;
	private JTextField idfield;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateDeleteEmployee frame = new UpdateDeleteEmployee();
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
	public UpdateDeleteEmployee() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(UpdateDeleteEmployee.class.getResource("/img/icons8-gym-100.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		try {

		} catch (Exception e) {
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

		JLabel lblNewLabel = new JLabel("Update Delete Employee");
		lblNewLabel.setBackground(new Color(238, 232, 170));
		lblNewLabel.setIcon(new ImageIcon(UpdateDeleteMember.class.getResource("/img/icons8-update-48.png")));
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 30));
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

		JLabel lblNewLabel_1_4_1 = new JLabel("Salary");
		lblNewLabel_1_4_1.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblNewLabel_1_4_1.setBounds(40, 285, 137, 28);
		contentPane.add(lblNewLabel_1_4_1);

		JLabel lblNewLabel_1_4_2 = new JLabel("Phone Number");
		lblNewLabel_1_4_2.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblNewLabel_1_4_2.setBounds(40, 247, 159, 28);
		contentPane.add(lblNewLabel_1_4_2);

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

		salaryfied = new JTextField();
		salaryfied.setBackground(new Color(238, 232, 170));
		salaryfied.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		salaryfied.setColumns(10);
		salaryfied.setBounds(229, 287, 301, 28);
		contentPane.add(salaryfied);

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
				int id = Integer.parseInt(idfield.getText());
				String name = namefield.getText();
				int age = Integer.parseInt(agefield.getText());
				String phoneNumber = phonefield.getText();
				float salary = Float.parseFloat(salaryfied.getText());
				String job = (String) comboBox.getSelectedItem();
				String type = comboBox.getSelectedItem().toString();
				try {
					Connection con = ConnectionProvider.getCon();
					if (radio1.isSelected()) {
						String gender = "Male";
						PreparedStatement ps = con.prepareStatement(
								"update employee set type=?,name=?,gender=?,age=?,phonenum=?,salary=?where id='" + id
										+ "'");
						ps.setString(1, type);
						ps.setString(2, name);
						ps.setString(3, gender);
						ps.setInt(4, age);
						ps.setString(5, phoneNumber);
						ps.setFloat(6, salary);
						ps.executeUpdate();
						JOptionPane.showMessageDialog(null, "Successfully updated!");

					} else if (radio2.isSelected()) {
						String gender = "Female";
						PreparedStatement ps = con.prepareStatement(
								"update employee set type=?,name=?,gender=?,age=?,phonenum=?,salary=?where id='" + id
										+ "'");
						ps.setString(1, type);
						ps.setString(2, name);
						ps.setString(3, gender);
						ps.setInt(4, age);
						ps.setString(5, phoneNumber);
						ps.setFloat(6, salary);
						ps.executeUpdate();
						JOptionPane.showMessageDialog(null, "Successfully updated!");
					} else {
						String gender = "Other";
						PreparedStatement ps = con.prepareStatement(
								"update employee set type=?,name=?,gender=?,age=?,phonenum=?,salary=?where id='" + id
										+ "'");
						ps.setString(1, type);
						ps.setString(2, name);
						ps.setString(3, gender);
						ps.setInt(4, age);
						ps.setString(5, phoneNumber);
						ps.setFloat(6, salary);
						ps.executeUpdate();
						JOptionPane.showMessageDialog(null, "Successfully updated!");
					}

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}

			}
		});

		btnNewButton.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		btnNewButton.setBounds(70, 396, 129, 43);
		contentPane.add(btnNewButton);

		JButton btnReset = new JButton("Reset");
		btnReset.setBackground(new Color(238, 232, 170));
		btnReset.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				idfield.setEditable(true);
				idfield.setText("");
				namefield.setText("");
				agefield.setText("");
				phonefield.setText("");
				salaryfied.setText("");
				radio1.setSelected(true);
				radio2.setSelected(false);
				radio3.setSelected(false);
				comboBox.setSelectedIndex(-1);
				
			}
		});
		btnReset.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		btnReset.setBounds(401, 396, 129, 43);
		contentPane.add(btnReset);

		comboBox.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		comboBox.setModel(new DefaultComboBoxModel(
				new String[] { "Trainer", "Caretaker", "Dietician", "Security", "Office Service" }));
		comboBox.setBounds(229, 325, 301, 28);
		contentPane.add(comboBox);

		JLabel lblNewLabel_1_4_1_1 = new JLabel("Job");
		lblNewLabel_1_4_1_1.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblNewLabel_1_4_1_1.setBounds(40, 323, 159, 28);
		contentPane.add(lblNewLabel_1_4_1_1);

		idfield = new JTextField();
		idfield.setBackground(new Color(238, 232, 170));
		idfield.setText("");
		idfield.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		idfield.setColumns(10);
		idfield.setBounds(229, 95, 149, 28);
		contentPane.add(idfield);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(new Color(238, 232, 170));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = JOptionPane.showConfirmDialog(null, "Do you really want to Delete ", "Select",
						JOptionPane.YES_NO_OPTION);
				if (a == 0) {
					String id = idfield.getText();
					try {
						Connection con = ConnectionProvider.getCon();
						Statement st = con.createStatement();
						st.executeUpdate("delete from employee where id='" + id + "'");
						JOptionPane.showMessageDialog(null, "Successfully Deleted!.");
						setVisible(false);
						new UpdateDeleteEmployee().setVisible(true);
					} catch (Exception ex) {

					}
				}
			}
		});
		btnDelete.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		btnDelete.setBounds(235, 396, 129, 43);
		contentPane.add(btnDelete);

		JButton btnSearch = new JButton("Search");
		btnSearch.setBackground(new Color(238, 232, 170));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int checkid = 0;
				String id = idfield.getText();
				try {
					Connection con = ConnectionProvider.getCon();
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery("Select *from employee where id='" + id + "'");
					while (rs.next()) {
						checkid = 1;
						idfield.setEditable(false);
						idfield.setText(rs.getString(1));
						namefield.setText(rs.getString(3));
						switch (rs.getString(4)) {
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
						agefield.setText(rs.getString(5));
						phonefield.setText(rs.getString(6));
						salaryfied.setText(rs.getString(7));
						switch (rs.getString(2)) {
						case "Trainer":
							comboBox.setSelectedIndex(0);
							break;
						case "Caretaker":
							comboBox.setSelectedIndex(1);
							break;
						case "Dietician":
							comboBox.setSelectedIndex(2);
							break;
						case "Security":
							comboBox.setSelectedIndex(3);
							break;
						case "Office Service":
							comboBox.setSelectedIndex(4);
							break;
						default:
							break;

						}
					}

					if (checkid == 0) {
						JOptionPane.showMessageDialog(null, "Employee ID does not exist!");
					}
				} catch (Exception exx) {
					JOptionPane.showMessageDialog(null, exx);

				}
			}
		});
		btnSearch.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		btnSearch.setBounds(401, 80, 129, 43);
		contentPane.add(btnSearch);
	}
}
