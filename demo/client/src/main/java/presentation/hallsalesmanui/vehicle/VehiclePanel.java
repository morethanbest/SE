package presentation.hallsalesmanui.vehicle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import businesslogic.transportbl.VehiclePack.VehicleController;
import businesslogicservice.transportblservice.VehicleBlService;
import vo.VehicleVO;

public class VehiclePanel extends JPanel implements ActionListener {
	private JTextField codeToSearch;
	private JTextField cardToSearch;
	private JTextField CodeField;
	private JTextField CardField;
    private JComboBox<String> daySelect;
	private JComboBox<String> yearSelect;
	private JComboBox<String> mouthSelect;
	private JButton btnSearchByCode;
	private JButton btnSearchByCard;
	private JButton btnAddVehicle;
	private JButton btnupdate;
	private JButton btndelete;
	private String orgcode;
	private VehicleVO vo;
	boolean isrev=false;
	 
	public VehiclePanel(String orgcode) {
		this.orgcode=orgcode;
		setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 49, 954, 8);
		add(separator);
		
		cardToSearch = new JTextField();
		cardToSearch.setBounds(104, 14, 103, 21);
		add(cardToSearch);
		cardToSearch.setColumns(10);
		
		btnSearchByCard = new JButton("搜索");
		btnSearchByCard.setBounds(217, 13, 66, 23);
		add(btnSearchByCard);
		
		codeToSearch = new JTextField();
		codeToSearch.setColumns(10);
		codeToSearch.setBounds(402, 14, 103, 21);
		add(codeToSearch);
		
		btnSearchByCode = new JButton("搜索");
		btnSearchByCode.setBounds(515, 13, 66, 23);
		add(btnSearchByCode);
		
		btnAddVehicle = new JButton("增加车辆信息");
		btnAddVehicle.setBounds(681, 13, 121, 23);
		add(btnAddVehicle);
		
		JLabel label = new JLabel("车辆代号：");
		label.setBounds(287, 120, 99, 15);
		add(label);
		
		JLabel label_1 = new JLabel("车牌号搜索：");
		label_1.setBounds(22, 17, 92, 15);
		add(label_1);
		
		JLabel label_2 = new JLabel("车辆代号搜索：");
		label_2.setBounds(307, 17, 85, 15);
		add(label_2);
		
		CodeField = new JTextField();
		CodeField.setBounds(539, 117, 143, 21);
		CodeField.setEditable(false);
		add(CodeField);
		CodeField.setColumns(10);
		
		JLabel label_4 = new JLabel("车牌号：");
		label_4.setBounds(286, 203, 54, 15);
		add(label_4);
		
		CardField = new JTextField();
		CardField.setBounds(539, 200, 143, 21);
		CardField.setEditable(false);
		add(CardField);
		CardField.setColumns(10);
		
		JLabel label_6 = new JLabel("服役期限：");
		label_6.setBounds(287, 291, 66, 15);
		add(label_6);
		
		yearSelect = new JComboBox<String>();
		yearSelect.setBounds(539, 291, 54, 21);
		yearSelect.setEditable(false);
		yearSelect.setEnabled(false);
		add(yearSelect);
		addyearItem();
		
		mouthSelect = new JComboBox<String>();
		mouthSelect.setBounds(599, 291, 38, 21);
		mouthSelect.setEditable(false);
		mouthSelect.setEnabled(false);
		add(mouthSelect);
		addmouthItem();
		
		daySelect = new JComboBox<String>();
		daySelect.setBounds(643, 291, 39, 21);
		daySelect.setEditable(false);
		daySelect.setEnabled(false);
		add(daySelect);
		adddayItem();
		
		btnupdate = new JButton("修改");
		btnupdate.setBounds(276, 371, 93, 23);
		add(btnupdate);
		
		btndelete = new JButton("删除");
		btndelete.setBounds(561, 371, 93, 23);
		add(btndelete);
		
		btnSearchByCard.addActionListener(this);
		btnSearchByCode.addActionListener(this);
		btnAddVehicle.addActionListener(this);
		btnupdate.addActionListener(this);
		btndelete.addActionListener(this);
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
	void addVehicle(VehicleVO vo){
		VehicleBlService vehicleBlService=new VehicleController();
		vehicleBlService.addVehicle(vo);
	}
	private void delVehicle(VehicleVO vo){
		VehicleBlService vehicleBlService=new VehicleController();
		vehicleBlService.delVehicle(vo);
		CodeField.setText("");
		CardField.setText("");
		yearSelect.setSelectedIndex(0);
		mouthSelect.setSelectedIndex(0);
		daySelect.setSelectedIndex(0);
		vo=null;
	}
	private void revVehicle(VehicleVO vo){
		VehicleBlService vehicleBlService=new VehicleController();
		vehicleBlService.revVehicle(vo);
	}
	private VehicleVO getVehiclebyVN(String vehicleCode){
		VehicleBlService vehicleBlService=new VehicleController();
		VehicleVO VO=null;
		VO = vehicleBlService.getVehiclebyVN(vehicleCode, orgcode);
		return VO;
	}
	private VehicleVO getVehiclebyPN(String plateNumber){
		VehicleBlService vehicleBlService=new VehicleController();
		VehicleVO VO=null;
		VO = vehicleBlService.getVehiclebyPN(plateNumber, orgcode);
		return VO;
	}
	public String getid(){
		VehicleBlService vehicleBlService=new VehicleController();
		String id="";
		id = vehicleBlService.getid(orgcode);
		return id;
	}
	private void display(){
		if(vo==null){
			CodeField.setText("");
			CardField.setText("");
			yearSelect.setSelectedIndex(0);
			mouthSelect.setSelectedIndex(0);
			daySelect.setSelectedIndex(0);
		}
		else{
			CodeField.setText(vo.getVehiclecode());
			CardField.setText(vo.getVehiclenum());
			long year=vo.getExtendtime()/10000;
			long mouth=vo.getExtendtime()/100-year*100;
			long day=vo.getExtendtime()%100;
			yearSelect.setSelectedItem(Long.toString(year));
			mouthSelect.setSelectedItem(Long.toString(mouth));
			daySelect.setSelectedItem(Long.toString(day));
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btnAddVehicle)){
			AddVehicleDialog dialog=new AddVehicleDialog(this);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}else if(e.getSource().equals(btnSearchByCard)){
			String card=cardToSearch.getText();
			System.out.println(card);
			vo=getVehiclebyPN(card);
			display();
		}else if(e.getSource().equals(btnSearchByCode)){
			String code=codeToSearch.getText();
			vo=getVehiclebyVN(code);
			display();
		}else if(e.getSource().equals(btndelete)){
			delVehicle(vo);
		}else if(e.getSource().equals(btnupdate)){
				if(isrev==false){
					isrev=true;
					btnupdate.setText("确定");
					CardField.setEditable(true);
					yearSelect.setEnabled(true);
					mouthSelect.setEnabled(true);
					daySelect.setEnabled(true);
				}
				else{
					isrev=false;
			        String code=CodeField.getText();
			        String card=CardField.getText();
			        long time=Long.parseLong((String)yearSelect.getSelectedItem()+mouthSelect.getSelectedItem()+daySelect.getSelectedItem());
				    vo=new VehicleVO(code, card, time);
				    display();
				    revVehicle(vo);
				    btnupdate.setText("修改");
				    CardField.setEditable(false);
					yearSelect.setEnabled(false);
					mouthSelect.setEnabled(false);
					daySelect.setEnabled(false);
				}
		}
	}
}
