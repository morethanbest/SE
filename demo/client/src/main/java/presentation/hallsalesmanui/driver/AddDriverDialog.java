package presentation.hallsalesmanui.driver;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AddDriverDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
    private JTextField nameField;
    private JTextField codeField;
    private JTextField phoneField;
    private JTextField identityField;
    private JComboBox<String> SexSelect;
    private JComboBox<String> ByearSelect;
    private JComboBox<String> BmouthSelect;
    private JComboBox<String> BdaySelect;
    private JComboBox<String> DyearSelect;
    private JComboBox<String> DmouthSelect;
    private JComboBox<String> DdaySelect;
	/**
	 * Create the dialog.
	 */
	public AddDriverDialog(final DriverPanel parent) {
		setBounds(100, 100, 549, 351);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel JLName = new JLabel("姓名：");
		JLName.setBounds(25, 36, 40, 20);
		contentPanel.add(JLName);
		
		nameField = new JTextField();
		nameField.setBounds(80, 36, 155, 20);
		contentPanel.add(nameField);
		nameField.setColumns(10);
		
		JLabel JLSex = new JLabel("性别：");
		JLSex.setBounds(250, 36, 40, 20);
		contentPanel.add(JLSex);
		
		SexSelect = new JComboBox<String>();
		SexSelect.setBounds(320, 36, 155, 20);
		SexSelect.addItem("男");
		SexSelect.addItem("女");
		contentPanel.add(SexSelect);
		
		JLabel JLCode = new JLabel("编号：");
		JLCode.setBounds(25, 96, 40, 20);
		contentPanel.add(JLCode);
		
		codeField = new JTextField();
		codeField.setBounds(80, 96, 155, 20);
		codeField.setEditable(false);
		codeField.setText(parent.getid());
		contentPanel.add(codeField);
		codeField.setColumns(10);
		
		JLabel JLPhone = new JLabel("手机号：");
		JLPhone.setBounds(250, 96, 60, 20);
		contentPanel.add(JLPhone);
		
		phoneField = new JTextField();
		phoneField.setBounds(320, 96, 155, 20);
		contentPanel.add(phoneField);
		phoneField.setColumns(10);
		
		JLabel JLBirth = new JLabel("出生日期：");
		JLBirth.setBounds(25, 156, 70, 20);
		contentPanel.add(JLBirth);
		
		ByearSelect = new JComboBox<String>();
		ByearSelect.setBounds(80, 156, 60, 20);
		contentPanel.add(ByearSelect);
		addyearItem(ByearSelect);
		
		BmouthSelect = new JComboBox<String>();
		BmouthSelect.setBounds(147, 156, 40, 20);
		contentPanel.add(BmouthSelect);
		addmonthItem(BmouthSelect);
		
		BdaySelect = new JComboBox<String>();
		BdaySelect.setBounds(195, 156, 40, 20);
		contentPanel.add(BdaySelect);
		addDayItem(BdaySelect,BmouthSelect,ByearSelect);
		
		JLabel JLDriver = new JLabel("行驶期限：");
		JLDriver.setBounds(250, 156, 70, 20);
		contentPanel.add(JLDriver);
		
		DyearSelect = new JComboBox<String>();
		DyearSelect.setBounds(320, 156, 65, 20);
		contentPanel.add(DyearSelect);
		addyearItem(DyearSelect);
		
		DmouthSelect = new JComboBox<String>();
		DmouthSelect.setBounds(391, 156, 40, 20);
		contentPanel.add(DmouthSelect);
		addmonthItem(DmouthSelect);
		
		DdaySelect = new JComboBox<String>();
		DdaySelect.setBounds(435, 156, 40, 20);
		contentPanel.add(DdaySelect);
		addDayItem(DdaySelect,DmouthSelect,DyearSelect);
		
		JLabel JLidentity = new JLabel("身份证号：");
		JLidentity.setBounds(25, 216, 70, 20);
		contentPanel.add(JLidentity);
		
		identityField = new JTextField();
		identityField.setBounds(80, 216, 155, 20);
		contentPanel.add(identityField);
		identityField.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						String drivername=nameField.getText();
						String drivercode=codeField.getText();
						long birthtime=Long.parseLong((String)ByearSelect.getSelectedItem()+BmouthSelect.getSelectedItem()+BdaySelect.getSelectedItem());
						String identifiercode=identityField.getText();
						String cellphone=phoneField.getText();
						String drivergender=(String)SexSelect.getSelectedItem();
						long timelimit=Long.parseLong((String)DyearSelect.getSelectedItem()+DmouthSelect.getSelectedItem()+DdaySelect.getSelectedItem());
						parent.addDriver(drivername, drivercode, birthtime, identifiercode, cellphone, drivergender, timelimit);
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
	private void addyearItem(JComboBox<String> yearselect){
		for(int i=2000;i<2100;i++){
			yearselect.addItem(Integer.toString(i));
		}
	}
	
	private void addmonthItem(JComboBox<String> monthselect){
		for(int i=1;i<=9;i++){
			monthselect.addItem("0"+Integer.toString(i));
		}
		for(int i=10;i<=12;i++){
			monthselect.addItem(Integer.toString(i));
		}
	}
	
	private void addDayItem(JComboBox<String> dayselect,JComboBox<String> monthselect,JComboBox<String> yearselect){
		dayselect.removeAllItems();
		
		//得到这个月的天数
		int days=getDays(Integer.parseInt((String)yearselect.getSelectedItem()),Integer.parseInt((String)monthselect.getSelectedItem()));
			
		for(int i=1;i<=9;i++){
			dayselect.addItem("0"+Integer.toString(i));
		}
		for(int i=10;i<=days;i++){
			dayselect.addItem(Integer.toString(i));
		}
	}
	
	public boolean isleap(Integer year){
		if(year%400==0){
			return true;
		}else if(year%100==0){
			return false;
		}else if(year%4==0){
			return true;
		}else{
			return false;
		}
	}
	
	public int getDays(Integer year,Integer month){				//得到这个月的天数
		int day[]={31,28,31,30,31,30,31,31,30,31,30,31};
		if(month==2&&isleap(year)){
			return 29;
		}
		return day[month-1];
	}
	

}
