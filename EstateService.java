import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EstateService extends JFrame{
	private JButton tenant=new JButton("+");
	private JButton view=new JButton("*");
	private JButton vacate=new JButton("-");

	public EstateService(){
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
		addComponent(panel, createPanel(createLabel("Add Tenant"), tenant), 0, 0, 1, 1);
		//addComponent(panel, createPanel(createLabel("View Status"), view), 0, 1, 1, 1);
		addComponent(panel, createPanel(createLabel("Vacate"), vacate), 0, 2, 1, 1);
		add(panel);
	}

	private JLabel createLabel(String str){
		JLabel label=new JLabel(str);
		label.setPreferredSize(new Dimension(100, 10));
		return label;
	}

	private JPanel createPanel(JLabel label, JButton button){
		JPanel panel=new JPanel();
		panel.add(label);
		button.setPreferredSize(new Dimension(50, 30));
		panel.add(button);
		return panel;
	}

	private JButton addButton(String str){
		JButton button=new JButton(str);
		return button;
	}

	private void addComponent(Container container, Component component, int gridx, int gridy, int gridwidth, int gridheight){
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = gridx;
		constraints.gridy = gridy;
		constraints.gridwidth = gridwidth;
		constraints.gridheight = gridheight;
		//constraints.weightx = weightx;
		//constraints.weighty = weighty;
		//constraints.fill = Fill.VERTCAL;
		//constraints.anchor = anchor;
		constraints.insets = new Insets(5, 5, 5, 5);
		container.add(component, constraints);
	}

	private void addListeners(){
		tenant.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new AddTenant();
				setVisible(false);
			}
		});

		/*view.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new ViewBalance();
				setVisible(false);
			}
		});*/

		vacate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new Vacate();
				setVisible(false);
			}
		});
	}

	public static void main(String[] args){
		new EstateService();
	}
}