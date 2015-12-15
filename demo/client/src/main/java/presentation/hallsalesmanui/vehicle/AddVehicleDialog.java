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
import presentation.tip.TipDialog;
import vo.VehicleVO;

public class AddVehicleDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	 private JTextField codeField;
	 private JTextField cardField;
	 private JComboBox<String> daySelect;
	 private JComboBox<String> yearSelect;
	 private JComboBox<String> mouthSelect;
	 private boolean isagain=false;
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
		contentPanel.add(codeField);
		codeField.setColumns(10);
		
		JLabel JLcard = new JLabel("车牌号：");
		JLcard.setBounds(25, 96, 60, 20);
		contentPanel.add(JLcard);
		
		cardField = new JTextField();
		cardField.setBounds(120, 96, 155, 20);
		contentPanel.add(cardField);
		cardField.setColumns(10);
		
		JLabel JLtime = new JLabel("服役期限：");
		JLtime.setBounds(25, 156, 70, 20);
		contentPanel.add(JLtime);
		
		yearSelect = new JComboBox<String>();
		yearSelect.setBounds(120, 156, 80, 20);
		contentPanel.add(yearSelect);
		addyearItem(yearSelect);
		
		mouthSelect = new JComboBox<String>();
		mouthSelect.setBounds(207, 156, 60, 20);
		contentPanel.add(mouthSelect);
		addmonthItem(mouthSelect);
		
		daySelect = new JComboBox<String>();
		daySelect.setBounds(275, 156, 60, 20);
		contentPanel.add(daySelect);
		addDayItem(daySelect,mouthSelect,yearSelect);
		
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
							isagain=true;							
							String card=cardField.getText();
							long time=Long.parseLong((String)yearSelect.getSelectedItem()+mouthSelect.getSelectedItem()+daySelect.getSelectedItem());
							if(card.equals("")){
								TipDialog Dialog=new TipDialog("请输入车牌号！");
								Dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
								Dialog.setVisible(true);
							}
							else{
								String code=parent.getid();
								codeField.setText(code);
								VehicleVO vo=new VehicleVO(code, card, time);
								parent.addVehicle(vo);
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
