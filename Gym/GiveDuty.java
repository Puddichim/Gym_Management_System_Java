import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import connection.ConnectionProvider;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;

public class GiveDuty extends JFrame {

	private JPanel contentPane;
	private JTextField idfield;
	private JTextField namefield;
	private JTable table;
	private JTextField commentfield;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiveDuty frame = new GiveDuty();
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
	public GiveDuty() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(GiveDuty.class.getResource("/img/icons8-gym-100.png")));
		JComboBox responbox = new JComboBox();
		JButton btnSave = new JButton("Save");
		JComboBox comboBox = new JComboBox();
		comboBox.setEnabled(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(238, 232, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Assign a task");
		lblNewLabel.setIcon(new ImageIcon(GiveDuty.class.getResource("/img/icons8-task-50.png")));
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 43));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(238, 232, 170));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Identity No");
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(30, 38, 137, 28);
		panel.add(lblNewLabel_1);
		
		idfield = new JTextField();
		idfield.setText("");
		idfield.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		idfield.setColumns(10);
		idfield.setBounds(177, 40, 301, 28);
		panel.add(idfield);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				responbox.removeAllItems();
				tableDetails();
				int checkid=0;
				int id= Integer.parseInt(idfield.getText());
				try {
					Connection conx = ConnectionProvider.getCon();
					Statement stx = conx.createStatement();
					ResultSet rsx = stx.executeQuery("select *from employee where id='"+id+"'");
					while (rsx.next()) {
						checkid=1;
						idfield.setEditable(false);
						namefield.setText(rsx.getString(3));
						
						switch(rsx.getString(2)) {
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
					if(checkid==0) {
						JOptionPane.showMessageDialog(null, "Member ID does not exist");
					}
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null,e);
				}
				String zort;
				switch (comboBox.getSelectedIndex()) {
				case 0:
					zort = "Trainer";
					 try {
						Connection con = ConnectionProvider.getCon();
						Statement st = con.createStatement();
						ResultSet rs = st.executeQuery("select name from member");
						while(rs.next()) {
							String tempname = rs.getString("name");
							responbox.addItem(tempname);
						}
						
					}
					catch(Exception ex){
						JOptionPane.showMessageDialog(null, ex);
					}
					break;
				case 1:
					zort = "Caretaker";
					responbox.addItem("Gym Halls");
					responbox.addItem("Pools");
					responbox.addItem("Offices");
					responbox.addItem("Restrooms");
					responbox.addItem("Showers");
					responbox.addItem("Strechings");
					break;
				case 2:
					zort = "Dietician";
					try {
						Connection con = ConnectionProvider.getCon();
						Statement st = con.createStatement();
						ResultSet rs = st.executeQuery("select name from member");
						while(rs.next()) {
							String tempname = rs.getString("name");
							responbox.addItem(tempname);
						}
						
					}
					catch(Exception ex){
						JOptionPane.showMessageDialog(null, ex);
					}
					break;
				case 3:
					zort = "Security";
					responbox.addItem("Gym Halls");
					responbox.addItem("Pools");
					responbox.addItem("Offices");
					responbox.addItem("Restrooms");
					responbox.addItem("Showers");
					responbox.addItem("Strechings");
					break;
				case 4:
					zort = "Office Service";
					try {
						Connection con = ConnectionProvider.getCon();
						Statement st = con.createStatement();
						ResultSet rs = st.executeQuery("select name from member");
						while(rs.next()) {
							String tempname = rs.getString("name");
							responbox.addItem(tempname);
						}
						
					}
					catch(Exception ex){
						JOptionPane.showMessageDialog(null, ex);
					}
					break;
				default:
					break;	
				}
			
			}
		});
		btnSearch.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		btnSearch.setBounds(536, 59, 129, 98);
		panel.add(btnSearch);
		
		JLabel lblNewLabel_1_1 = new JLabel("Name");
		lblNewLabel_1_1.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(30, 93, 159, 28);
		panel.add(lblNewLabel_1_1);
		
		namefield = new JTextField();
		namefield.setEditable(false);
		namefield.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		namefield.setColumns(10);
		namefield.setBounds(174, 95, 301, 28);
		panel.add(namefield);
		
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Trainer", "Caretaker", "Dietician", "Security", "Office Service"}));
		comboBox.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		comboBox.setBounds(174, 143, 301, 28);
		panel.add(comboBox);
		
		JLabel lblNewLabel_1_4_1_1 = new JLabel("Job");
		lblNewLabel_1_4_1_1.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblNewLabel_1_4_1_1.setBounds(30, 141, 96, 28);
		panel.add(lblNewLabel_1_4_1_1);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Responsibility", "Comment"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.setForeground(new Color(238, 232, 170));
		table.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		table.setBackground(new Color(0, 0, 0));
		table.setBounds(367, 190, 373, 277);
		panel.add(table);
		
		commentfield = new JTextField();
		commentfield.setText("");
		commentfield.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		commentfield.setColumns(10);
		commentfield.setBounds(29, 322, 301, 28);
		panel.add(commentfield);
		
		JLabel lblNewLabel_1_2 = new JLabel("Responsibility");
		lblNewLabel_1_2.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(32, 203, 137, 28);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Comment");
		lblNewLabel_1_3.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblNewLabel_1_3.setBounds(29, 284, 142, 28);
		panel.add(lblNewLabel_1_3);
		
		
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int id = Integer.parseInt(idfield.getText());
				String job = "";
				switch (comboBox.getSelectedIndex()) {
				case 0:
					job = "Trainer";
					break;
				case 1:
					job = "Caretaker";
					break;
				case 2:
					job = "Dietician";
					break;
				case 3:
					job = "Security";
					break;
				case 4:
					job = "Office Service";
					break;
				default:
					break;	
				}
				String comment = commentfield.getText();	
				
				
				String respon = responbox.getSelectedItem().toString();
				try {
					Connection con = ConnectionProvider.getCon();
					PreparedStatement ps = con.prepareStatement("insert into respon values(?,?,?)");
					ps.setInt(1, id);
					ps.setString(2, respon);
					ps.setString(3, comment);
					ps.executeUpdate();
					tableDetails();
					JOptionPane.showMessageDialog(null, "Successfully entered!");
					setVisible(false);
					new GiveDuty().setVisible(true);
					
				}
				catch(Exception ex){
					JOptionPane.showMessageDialog(null, ex);
				}
				
			
				
			}
		});
		btnSave.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		btnSave.setBounds(29, 396, 129, 43);
		panel.add(btnSave);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				responbox.removeAllItems();
				comboBox.setSelectedIndex(-1);
				namefield.setText("");
				idfield.setEditable(true);
				btnSave.setVisible(true);
				responbox.setSelectedIndex(-1);
				commentfield.setText("");
			}
		});
		btnReset.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		btnReset.setBounds(189, 396, 129, 43);
		panel.add(btnReset);
		

		responbox.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		responbox.setBounds(29, 241, 301, 28);
		panel.add(responbox);
	}
	public void tableDetails() {
		DefaultTableModel dtm = (DefaultTableModel)table.getModel();
		dtm.setRowCount(0);
		String id = idfield.getText();
		try {
			Connection con = ConnectionProvider.getCon();
			Statement st = con.createStatement();
			ResultSet rs=st.executeQuery("select *from respon where id ='"+id+"'");
			while(rs.next()) {
				dtm.addRow(new Object[] {rs.getString(2),rs.getString(3)});
			}
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
	}
}
