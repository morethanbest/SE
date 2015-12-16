package presentation.managerui.salary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import businesslogic.managerbl.SalaryPack.SalaryController;
import businesslogicservice.managerblservice.SalaryBlService;
import po.Job;
import vo.SalaryVO;

public class SalaryPanel extends JPanel implements ActionListener{
	
	private JSeparator separator;
	
	private JScrollPane scrollPane;
	
	private JButton addBtn;
	private JButton delBtn;
	private JButton revBtn;
	private JTable table;
	
	private JButton refreshBtn;
	
	
	private SalaryVO vo=null;
	
	
	
	
	public SalaryPanel() {
		// TODO Auto-generated constructor stub
		setLayout(null);
		separator = new JSeparator();
		separator.setBounds(0, 0, 954, 8);
		add(separator);
		scrollPane=new JScrollPane();
		scrollPane.setBounds(40, 20, 700, 330);
		add(scrollPane);
		table=new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
					{null,null,null,null},
				},
				new String[] {
					"职业","薪水策略","底薪","提成（计次）"
				}
			) {
				boolean[] columnEditables = new boolean[] {
					false
				};
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			});
		scrollPane.setViewportView(table);
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setColumnCount(4);
		tableModel.setRowCount(0);

		table.setRowHeight(50);
		
//		refreshList();
		
		addBtn = new JButton();
		addBtn.setText("增加薪水策略");
		addBtn.setBounds(800, 20, 150, 40);
		add(addBtn);
		addBtn.addActionListener(this);
		
		delBtn = new JButton();
		delBtn.setText("删除选中项");
		delBtn.setBounds(200, 380, 150, 40);
		add(delBtn);
		delBtn.addActionListener(this);
		
		revBtn = new JButton();
		revBtn.setText("修改选中项");
		revBtn.setBounds(500, 380, 150, 40);
		add(revBtn);
		revBtn.addActionListener(this);
		
		refreshBtn = new JButton();
		refreshBtn.setText("查找");
		refreshBtn.setBounds(800, 250, 150, 40);
		add(refreshBtn);
		refreshBtn.addActionListener(this);
	}
	
	public void refreshList(){
		SalaryBlService salaryBlService=new SalaryController();
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		Job[] jobs=Job.values();
		tableModel.setRowCount(0);
		for(int i=0;i<jobs.length;i++){
			vo=salaryBlService.getSalary(jobs[i]);
			if(vo!=null){
				String[] strings=new String[4];
				strings[0]=vo.getJob().getName();
				strings[1]=vo.getSalarymode().getName();
				strings[2]=vo.getBase()+"";
				strings[3]=vo.getBonus()+"";
				tableModel.addRow(strings);
			}
		}
	}
	
	public void deleteSalary(Job job){
		SalaryBlService salaryBlService=new SalaryController();
		vo=salaryBlService.getSalary(job);
		salaryBlService.delSalary(vo);
		refreshList();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(delBtn)){
			DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
			try{
				String string=(String)tableModel.getValueAt(table.getSelectedRow(), 0);
				switch (string) {
				case "快递员":
					deleteSalary(Job.Courier);
					break;
				case "营业厅业务员":
					deleteSalary(Job.hallsalesman);
					break;
				case "中转中心业务员":
					deleteSalary(Job.transfercentersalesman);
					break;
				case "中转中心库存管理人员":
					deleteSalary(Job.CenterDepot);
					break;
				case "财务人员":
					deleteSalary(Job.Financial);
					break;
				case "高级财务人员":
					deleteSalary(Job.advanceFinancial);
					break;
				case "司机":
					deleteSalary(Job.drivers);
					break;
				case "管理员":
					deleteSalary(Job.administrator);
					break;
				case "总经理":
					deleteSalary(Job.manager);
					break;
				default:
					break;
				}
			}catch(Exception exception){
				exception.printStackTrace();
			}
		}else if(e.getSource().equals(addBtn)){
			AddSalaryDialog dialog=new AddSalaryDialog(this);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			refreshList();
		}else if(e.getSource().equals(refreshBtn)){
			refreshList();
		}
	}

}
