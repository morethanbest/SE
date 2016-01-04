package presentation.hallsalesmanui.driver;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import presentation.mycomp.MyTextField;
import presentation.mycomp.mycombobox.MyComboBox;
import presentation.tip.NumberField;
import presentation.tip.TipDialog;

public class AddDriverDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
    private MyTextField nameField;
    private MyTextField codeField;
    private NumberField phoneField;
    private MyTextField identityField;
    private MyComboBox<String> SexSelect;
    private MyComboBox<String> ByearSelect;
    private MyComboBox<String> BmouthSelect;
    private MyComboBox<String> BdaySelect;
    private MyComboBox<String> DyearSelect;
    private MyComboBox<String> DmouthSelect;
    private MyComboBox<String> DdaySelect;
    private boolean isagain=false;
	/**
	 * Create the dialog.
	 */
	public AddDriverDialog(final DriverPanel parent) {
		setBounds(100, 100, 549, 351);
		setBackground(SystemColor.inactiveCaptionBorder);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel JLName = new JLabel("姓名：");
		JLName.setBounds(25, 36, 40, 20);
		contentPanel.add(JLName);
		
		nameField = new MyTextField();
		nameField.setBounds(90, 36, 155, 20);
		contentPanel.add(nameField);
		nameField.setColumns(10);
		
		JLabel JLSex = new JLabel("性别：");
		JLSex.setBounds(260, 36, 40, 20);
		contentPanel.add(JLSex);
		
		SexSelect = new MyComboBox<String>();
		SexSelect.setBounds(330, 36, 155, 20);
		SexSelect.addItem("男");
		SexSelect.addItem("女");
		contentPanel.add(SexSelect);
		
		JLabel JLCode = new JLabel("编号：");
		JLCode.setBounds(25, 96, 40, 20);
		contentPanel.add(JLCode);
		
		codeField = new MyTextField();
		codeField.setBounds(90, 96, 155, 20);
		codeField.setEditable(false);
		contentPanel.add(codeField);
		codeField.setColumns(10);
		
		JLabel JLPhone = new JLabel("手机号：");
		JLPhone.setBounds(260, 96, 60, 20);
		contentPanel.add(JLPhone);
		
		phoneField = new NumberField(20);
		phoneField.setBounds(330, 96, 155, 20);
		contentPanel.add(phoneField);
		phoneField.setColumns(10);

		
		JLabel JLBirth = new JLabel("出生日期：");
		JLBirth.setBounds(25, 156, 70, 20);
		contentPanel.add(JLBirth);
		
		ByearSelect = new MyComboBox<String>();
		ByearSelect.setBounds(90, 156, 60, 20);
		contentPanel.add(ByearSelect);
		addyearItem(ByearSelect);
		
		ItemListener Blistener= new ItemListener(){			//用于判断这个月的天数
			@Override
			public void itemStateChanged(ItemEvent e) {
				addDayItem(BdaySelect,BmouthSelect,ByearSelect);
			}
		};
		
		BmouthSelect = new MyComboBox<String>();
		BmouthSelect.setBounds(157, 156, 40, 20);
		contentPanel.add(BmouthSelect);
		addmonthItem(BmouthSelect);
		
		BdaySelect = new MyComboBox<String>();
		BdaySelect.setBounds(205, 156, 40, 20);
		contentPanel.add(BdaySelect);
		addDayItem(BdaySelect,BmouthSelect,ByearSelect);
		
		ByearSelect.addItemListener(Blistener);
		BmouthSelect.addItemListener(Blistener);
		
		JLabel JLDriver = new JLabel("行驶期限：");
		JLDriver.setBounds(260, 156, 70, 20);
		contentPanel.add(JLDriver);
		
		DyearSelect = new MyComboBox<String>();
		DyearSelect.setBounds(330, 156, 65, 20);
		contentPanel.add(DyearSelect);
		addyearItem(DyearSelect);
		
		ItemListener Dlistener= new ItemListener(){			//用于判断这个月的天数
			@Override
			public void itemStateChanged(ItemEvent e) {
				addDayItem(DdaySelect,DmouthSelect,DyearSelect);
			}
		};
		
		DmouthSelect = new MyComboBox<String>();
		DmouthSelect.setBounds(401, 156, 40, 20);
		contentPanel.add(DmouthSelect);
		addmonthItem(DmouthSelect);
		
		DdaySelect = new MyComboBox<String>();
		DdaySelect.setBounds(445, 156, 40, 20);
		contentPanel.add(DdaySelect);
		addDayItem(DdaySelect,DmouthSelect,DyearSelect);
		
		DyearSelect.addItemListener(Dlistener);
		DmouthSelect.addItemListener(Dlistener);
		
		JLabel JLidentity = new JLabel("身份证号：");
		JLidentity.setBounds(25, 216, 70, 20);
		contentPanel.add(JLidentity);
		
		identityField = new MyTextField();
		identityField.setBounds(90, 216, 155, 20);
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
                        if(isagain==false){
                        	
                        	String drivername=nameField.getText();
    						
    						long birthtime=Long.parseLong((String)ByearSelect.getSelectedItem()+BmouthSelect.getSelectedItem()+BdaySelect.getSelectedItem());
    						String identifiercode=identityField.getText();
    						String cellphone=phoneField.getText();
    						String drivergender=(String)SexSelect.getSelectedItem();
    						long timelimit=Long.parseLong((String)DyearSelect.getSelectedItem()+DmouthSelect.getSelectedItem()+DdaySelect.getSelectedItem());
    						if(drivername.equals("")){
    							TipDialog Dialog=new TipDialog("请输入姓名！");
    							Dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    							Dialog.setVisible(true);
    						}
    						else if(identifiercode.equals("")){
    							TipDialog failDialog=new TipDialog("请输入身份证号！");
    							failDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    							failDialog.setVisible(true);
    						}
    						else if(phoneField.getText().equals("")){
    							TipDialog failDialog=new TipDialog("请输入手机号！");
    							failDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    							failDialog.setVisible(true);
    						}
    						else {
    							String drivercode=parent.getcode();
    							codeField.setText(drivercode);
    							parent.addDriver(drivername, drivercode, birthtime, identifiercode, cellphone, drivergender, timelimit);
    							isagain=true;								
    						}
                        }
                        else{
                        	dispose();	
                        }
                        
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			
		}
	}
	private void addyearItem(JComboBox<String> yearselect){
		for(int i=1950;i<2100;i++){
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
