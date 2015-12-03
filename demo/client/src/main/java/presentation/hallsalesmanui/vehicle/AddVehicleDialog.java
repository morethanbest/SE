package presentation.hallsalesmanui.vehicle;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import presentation.hallsalesmanui.driver.DriverPanel;
import vo.VehicleVO;

public class AddVehicleDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	 private JTextField codeField;
	 private JTextField cardField;
	 private JComboBox<String> daySelect;
	 private JComboBox<String> yearSelect;
	 private JComboBox<String> mouthSelect;
	/**
	 * Create the dialog.
	 */
	public AddVehicleDialog(final VehiclePanel parent) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel JLcode = new JLabel("车辆代号：");
		JLcode.setBounds(25, 36, 60, 20);
		contentPanel.add(JLcode);
		
		codeField = new JTextField();
		codeField.setBounds(120, 36, 155, 20);
		codeField.setEditable(false);
		codeField.setText(parent.getid());
		contentPanel.add(codeField);
		codeField.setColumns(10);
		
		JLabel JLcard = new JLabel("车牌号：");
		JLcard.setBounds(25, 96, 40, 20);
		contentPanel.add(JLcard);
		
		cardField = new JTextField();
		cardField.setBounds(120, 96, 155, 20);
		contentPanel.add(cardField);
		cardField.setColumns(10);
		
		JLabel JLtime = new JLabel("服役期限：");
		JLtime.setBounds(25, 156, 70, 20);
		contentPanel.add(JLtime);
		
		yearSelect = new JComboBox<String>();
		yearSelect.setBounds(120, 156, 60, 20);
		contentPanel.add(yearSelect);
		addyearItem();
		
		mouthSelect = new JComboBox<String>();
		mouthSelect.setBounds(187, 156, 40, 20);
		contentPanel.add(mouthSelect);
		addmouthItem();
		
		daySelect = new JComboBox<String>();
		daySelect.setBounds(235, 156, 40, 20);
		contentPanel.add(daySelect);
		adddayItem();
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						String code=codeField.getText();
						String card=cardField.getText();
						long time=Long.parseLong((String)yearSelect.getSelectedItem()+mouthSelect.getSelectedItem()+daySelect.getSelectedItem());
					    VehicleVO vo=new VehicleVO(code, card, time);
						parent.addVehicle(vo);
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	private void addyearItem(){
		for(int i=1950;i<2050;i++){
			yearSelect.addItem(Integer.toString(i));
		}
	}
	private void addmouthItem(){
		for(int i=1;i<10;i++){
			mouthSelect.addItem("0"+Integer.toString(i));
		}
		mouthSelect.addItem("10");
		mouthSelect.addItem("11");
		mouthSelect.addItem("12");
	}
	private void adddayItem(){
		for(int i=1;i<10;i++){
			daySelect.addItem("0"+Integer.toString(i));
		}
		for(int i=10;i<32;i++){
			daySelect.addItem(Integer.toString(i));
		}
	}
}
