package presentation.centersalesmanui.arrivalui;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JLabel;

public class ArrivalPanel extends JPanel {
	private JTextField codeField;
	private JLabel orgLabel;
	private JComboBox<Long> yearBox;
	private JComboBox<Long> monthBox;
	private JComboBox<Long> dateBox;
	private JButton button;
	private JComboBox<String> departureBox;
	private JComboBox<String> stateBox;

	/**
	 * Create the panel.
	 */
	public ArrivalPanel(String orgCode) {
		setBackground(SystemColor.inactiveCaptionBorder);
		setLayout(null);
		
		orgLabel = new JLabel("");
		orgLabel.setBounds(139, 50, 242, 18);
		add(orgLabel);
		
		yearBox = new JComboBox<Long>();
		yearBox.setBounds(139, 132, 74, 24);
		add(yearBox);
		
		monthBox = new JComboBox<Long>();
		monthBox.setBounds(237, 132, 61, 24);
		add(monthBox);
		
		dateBox = new JComboBox<Long>();
		dateBox.setBounds(320, 132, 61, 24);
		add(dateBox);
		
		stateBox = new JComboBox<String>();
		stateBox.setBounds(547, 131, 242, 24);
		add(stateBox);
		
		button = new JButton("提交");
		button.setBounds(416, 309, 113, 27);
		add(button);
		
		codeField = new JTextField();
		codeField.setColumns(10);
		codeField.setBounds(139, 213, 242, 24);
		add(codeField);
		
		departureBox = new JComboBox<String>();
		departureBox.setBounds(547, 50, 242, 24);
		add(departureBox);

	}
}
