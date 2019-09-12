import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class AddTenant extends JFrame{

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   	static final String DB_URL = "jdbc:mysql://localhost:3306/estateservice?autoReconnect=true&useSSL=false";
   	static final String USER = "root";
   	static final String PASS = "root";
   	static Connection conn=null;
   	static Statement stmt=null;

	JButton home=new JButton("...");
	JButton add=new JButton("ADD");
	JTextField nameIn=new JTextField("", 20);
	JTextField idIn=new JTextField("", 20);
	static final String[] HOUSES={"1", "2", "3", "4", "5", "6"};
	JComboBox houseChoice=addCombo(HOUSES);

	AddTenant(){
		setTitle("Estate Management");
		setSize(600, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		addListeners();
		createWindow();
		setVisible(true);
	}

	private void createWindow(){
		JPanel panel=new JPanel();
		panel.setLayout(new GridBagLayout());
		addComponent(panel, createAddPanel(), 0, 0, 1, 1);
		addComponent(panel, createPanel(createLabel("Go back home"), home), 0, 3, 1, 1);
		JPanel pan=new JPanel();
		add(panel);
	}

	private void addComponent(Container container, Component component, int gridx, int gridy, int gridwidth, int gridheight){
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = gridx;
		constraints.gridy = gridy;
		constraints.gridwidth = gridwidth;
		constraints.gridheight = gridheight;
		constraints.insets = new Insets(10, 10, 10, 10);
		container.add(component, constraints);
	}

	private JLabel createLabel(String str){
		JLabel label=new JLabel(str);
		label.setPreferredSize(new Dimension(100, 20));
		return label;
	}

	private JPanel createPanel(JLabel label, JButton button){
		JPanel panel=new JPanel();
		panel.add(label);
		button.setPreferredSize(new Dimension(50, 30));
		panel.add(button);
		return panel;
	}

	private JPanel createPanel(JLabel label, JTextField text){
		JPanel panel=new JPanel();
		panel.add(label);
		panel.add(text);
		return panel;
	}

	private JPanel createPanel(JLabel label, JComboBox combo){
		JPanel panel=new JPanel();
		panel.add(label);
		panel.add(combo);
		return panel;
	}

	private JComboBox addCombo(String[] in){
		String[] houses=in;
		JComboBox combo = new JComboBox(houses);
		combo.setSize(1, 25);
		combo.setSelectedIndex(4);
		combo.addActionListener(combo);
		return combo;
	}

	private JPanel createAddPanel(){
		JPanel panel=new JPanel();
		panel.setLayout(new GridBagLayout());
		addComponent(panel, createPanel(createLabel("Enter name"), nameIn), 0, 0, 1, 1);
		addComponent(panel, createPanel(createLabel("ID Number"), idIn), 0, 1, 1, 1);
		addComponent(panel, createPanel(createLabel("House Number"), houseChoice), 0, 2, 1, 1);
		addComponent(panel, add, 1, 3, 1, 1);
		return panel;
	}

	private void doInsert(){
		System.out.println("Start");
   		try{
   			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			DB_URL,USER,PASS);
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from Tenants");  
			while(rs.next())  
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
			con.close();  
		}catch(Exception e){
			System.out.println(e);
		}  

   			/*
   			Class.forName("com.mysql.jdbc.Driver");
   			conn=DriverManager.getConnection(DB_URL, USER, PASS);
   			stmt=conn.createStatement();
   			System.out.format("Hello");
   			String sql="INSERT INTO Tenants "
   			+" VALUES ('"+nameIn.getText()+"',"+Integer.parseInt(idIn.getText())+","+ Integer.valueOf((String)houseChoice.getSelectedItem())+")";
   			stmt.executeUpdate(sql);
   			JOptionPane.showMessageDialog(null, "Successfull");
   		}catch(SQLException e){
   			e.printStackTrace();
			JOptionPane.showMessageDialog(null, " not Successfull");
		}
		catch(ClassNotFoundException e){
			JOptionPane.showMessageDialog(null, " class not Successfull");
		}
   		finally{
   			try{
	        	if(stmt!=null) conn.close();
	      }catch(SQLException se){}
	      try{
	         if(conn!=null) conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }*/
   		//}
   	}

	private void addListeners(){
		home.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new EstateService();
				setVisible(false);
			}
		});

		add.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if (JOptionPane.showConfirmDialog(AddTenant.this, "Confirm add "+nameIn.getText(), "Warning",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE)== JOptionPane.YES_OPTION){
						System.out.println("Doing");
						doInsert();
						System.out.println("Doing again");
				}
			}
		});
	}
	public static void main(String[] args){}
}
