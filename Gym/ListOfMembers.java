import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.sql.*;
import connection.ConnectionProvider;
import program.*;
import java.awt.ComponentOrientation;
import java.awt.Color;
import java.awt.Toolkit;

public class ListOfMembers extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public float calculateBodyIndex(float Weight, float Height) {		
		return (Weight*Weight)/ Height;
		
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListOfMembers frame = new ListOfMembers();
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
	public ListOfMembers() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListOfMembers.class.getResource("/img/icons8-gym-100.png")));
		setBackground(new Color(144, 238, 144));
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1300, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(238, 232, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("List Of Members");
		lblNewLabel.setBackground(new Color(238, 232, 170));
		lblNewLabel.setIcon(new ImageIcon(ListOfMembers.class.getResource("/img/icons8-member-64.png")));
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 48));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		table = new JTable();
		table.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		table.setForeground(new Color(255, 255, 0));
		table.setBackground(Color.BLACK);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name", "Gender", "Age", "Phone number", "Weight", "Height", "BMI", "Payment Plan", "Price"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, Integer.class, String.class, Float.class, Float.class, Float.class, String.class, Float.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		contentPane.add(table, BorderLayout.CENTER);
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		try 
		{
			model.addRow(new Object[] {"ID","NAME","GENDER","AGE","PHONE NUMBER","WEIGHT","HEIGHT","BMI","PAYMENT PLAN","PRICE"});
			Connection con = ConnectionProvider.getCon();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select *from member");
			while (rs.next()) {
				model.addRow(new Object[] {rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getFloat(6),rs.getFloat(7),calculateBodyIndex(rs.getFloat(6), rs.getFloat(7)),rs.getString(8),rs.getFloat(9)});
			}
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		renderer.setHorizontalAlignment(lblNewLabel.LEFT);
		for(int i=0;i<10;i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(renderer);
		}
	
	}

}
