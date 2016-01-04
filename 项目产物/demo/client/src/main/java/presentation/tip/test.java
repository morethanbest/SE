package presentation.tip;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import presentation.mycomp.MyButton_LightGreen;
import presentation.mycomp.MyTextField;
import presentation.mycomp.MyTextLabel;
import presentation.mycomp.mycombobox.MyComboBox;

public class test extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			test dialog = new test();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public test() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		MyTextField doubleField = new MyTextField();
		doubleField.setBounds(200, 96, 155, 30);
		contentPanel.add(doubleField);
		doubleField.setColumns(10);
		MyComboBox<String> a = new MyComboBox<String>();
		a.addItem("1231");
		a.addItem("营业厅");
		a.addItem("1231");
		a.addItem("营业厅");
		a.addItem("1231");
		a.addItem("营业厅");
		a.addItem("1231");
		// a.addItem("营业厅");
		// a.addItem("1231");
		// a.addItem("营业厅");
		// a.addItem("1231");
		// a.addItem("营业厅");
		a.setBounds(1, 1, 200, 27);
		contentPanel.add(a);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				MyButton_LightGreen cancelButton = new MyButton_LightGreen(
						"Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
