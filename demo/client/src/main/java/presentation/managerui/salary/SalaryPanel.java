package presentation.managerui.salary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import org.omg.CORBA.PRIVATE_MEMBER;

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
	
	
	private SalaryVO vo=null;
	
	
	
	
	public SalaryPanel() {
		// TODO Auto-generated constructor stub
		setLayout(null);
		separator = new JSeparator();
		separator.setBounds(0, 0, 954, 8);
		add(separator);
		scrollPane=new JScrollPane();
		scrollPane.setBounds(40, 40, 700, 350);
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
		tableModel.setRowCount(10);

		table.setRowHeight(50);
		
		refreshList();
	}
	
	private void refreshList(){
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

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
