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
import javax.lang.model.util.SimpleAnnotationValueVisitor14;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.sql.*;
import java.text.SimpleDateFormat;

import connection.ConnectionProvider;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;




public class Payment extends JFrame {
	String month;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Payment frame = new Payment();
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
	public Payment() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Payment.class.getResource("/img/icons8-gym-100.png")));
		date();
		JLabel labeldate = new JLabel("dd-mm-yyyy");
		JComboBox comboBox = new JComboBox();
		comboBox.setEnabled(false);
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idd = Integer.parseInt(textField.getText());
				String monthh=labeldate.getText();
				int amountt = 0;
				switch (comboBox.getSelectedIndex()) {
				case 0:
					amountt = 200;
					break;
				case 1:
					amountt = 550;
					break;
				case 2:
					amountt = 1000;
					break;
				case 3:
					amountt = 1800;
					break;
				default:
					break;	
				}
				
				
				try {
					Connection con = ConnectionProvider.getCon();
					PreparedStatement ps = con.prepareStatement("insert into payment values(?,?,?)");
					ps.setInt(1, idd);
					ps.setString(2, monthh);
					ps.setInt(3,amountt);
					ps.executeUpdate();
					tableDetails();
					JOptionPane.showMessageDialog(null, "Successfully paid!");
					setVisible(false);
					new Payment().setVisible(true);
					
				}
				catch(Exception ex){
					JOptionPane.showMessageDialog(null, ex);
				}
				
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1 month plan (200tl)", "3 month plan (550tl)", "6 month plan (1000tl)", "1 year plan (1800tl)"}));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(238, 232, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Payment");
		lblNewLabel.setIcon(new ImageIcon(Payment.class.getResource("/img/icons8-payment-64.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 36));
		lblNewLabel.setBounds(10, 20, 586, 71);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Identity No");
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(50, 142, 137, 28);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setText("");
		textField.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		textField.setColumns(10);
		textField.setBounds(197, 144, 149, 28);
		contentPane.add(textField);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				tableDetails();
				int checkid=0;
				String id= textField.getText();
				String month = labeldate.getText();
				try {
					Connection conx = ConnectionProvider.getCon();
					Statement stx = conx.createStatement();
					ResultSet rsx = stx.executeQuery("select *from member where id='"+id+"'");
					while (rsx.next()) {
						checkid=1;
						textField.setEditable(false);
						textField_1.setText(rsx.getString(2));
						switch(rsx.getString(8)) {
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
						JOptionPane.showMessageDialog(null, "Member ID does not exist");
					}
					ResultSet rsl = stx.executeQuery("select *from payment inner join member where payment.month='"+month+"' and payment.id='"+id+"' and member.id='"+id+"'");
					while(rsl.next()) {
						btnSave.setVisible(false);
						JOptionPane.showMessageDialog(null, "Payment is already done for this month!");
					}
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null,e);
				}
			
			}
		});
		btnSearch.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnSearch.setBounds(377, 136, 129, 43);
		contentPane.add(btnSearch);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		textField_1.setColumns(10);
		textField_1.setBounds(239, 276, 301, 43);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Name Surname");
		lblNewLabel_1_1.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(50, 282, 159, 28);
		contentPane.add(lblNewLabel_1_1);
		
		
		comboBox.setFont(new Font("Arial", Font.PLAIN, 18));
		comboBox.setBounds(239, 350, 301, 43);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_1_4_1_1 = new JLabel("Payment plan");
		lblNewLabel_1_4_1_1.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblNewLabel_1_4_1_1.setBounds(50, 355, 159, 28);
		contentPane.add(lblNewLabel_1_4_1_1);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox.setSelectedIndex(-1);
				textField.setText("");
				textField.setEditable(true);
				btnSave.setVisible(true);
				
			}
		});
		btnReset.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnReset.setBounds(270, 464, 129, 43);
		contentPane.add(btnReset);
		
		
		btnSave.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnSave.setBounds(75, 464, 129, 43);
		contentPane.add(btnSave);
		
		table = new JTable();
		table.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		table.setBackground(new Color(0, 0, 0));
		table.setForeground(new Color(240, 230, 140));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Month", "Amount"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.setBounds(567, 90, 409, 451);
		contentPane.add(table);
		
		JLabel lblNewLabel_2 = new JLabel("Date");
		lblNewLabel_2.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(50, 204, 95, 28);
		contentPane.add(lblNewLabel_2);
		
		
		labeldate.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		labeldate.setBounds(197, 204, 149, 28);
		contentPane.add(labeldate);
		labeldate.setText(month);
		
		
		
	}
	public void tableDetails() {
		DefaultTableModel dtm = (DefaultTableModel)table.getModel();
		dtm.setRowCount(0);
		String id = textField.getText();
		try {
			Connection con = ConnectionProvider.getCon();
			Statement st = con.createStatement();
			ResultSet rs=st.executeQuery("select *from payment where id ='"+id+"'");
			while(rs.next()) {
				dtm.addRow(new Object[] {rs.getString(2),rs.getString(3)});
			}
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
	}
	public void date() {
		SimpleDateFormat dformat = new SimpleDateFormat("MMMM-yyyy");
		Date date = new Date();
		month = dformat.format(date);
		
	}
	

}
