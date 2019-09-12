import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Vacate extends JFrame{

	JButton home=new JButton("...");

	Vacate(){
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
		addComponent(panel, createPanel(createLabel("Go back home"), home), 3, 3, 1, 1);
		addComponent(panel, createPanel(createLabel("House to vacate"), addCombo()), 0, 0, 1, 1);
		addComponent(panel, new JButton("OK"), 1, 0, 1, 1);
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

	private JPanel createPanel(JLabel label, JComboBox combo){
		JPanel panel=new JPanel();
		panel.add(label);
		panel.add(combo);
		return panel;
	}

	private JComboBox addCombo(){
		String[] houses={"1","2","3","4","5","6", "111"};
		JComboBox combo = new JComboBox(houses);
		combo.setSize(1, 25);
		combo.setSelectedIndex(4);
		combo.addActionListener(combo);
		return combo;
	}

	private void addListeners(){
		home.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new EstateService();
				setVisible(false);
			}
		});
	}
}