package presentation.centersalesmanui.loadui;

import java.awt.CardLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import po.Formstate;
import presentation.tip.TipDialog;
import vo.CenterloadVO;
import businesslogic.logisticsbl.CenterloadPack.CenterloadController;
import businesslogic.managerbl.ExamPack.ExamController;
import businesslogicservice.logisticsblservice.CenterloadBlService;
import businesslogicservice.managerblservice.ExamCLForms;

public class CenterLoadCheckPanel extends JPanel {
	private JTable table;
	private CenterloadBlService controller;
	private List<CenterloadVO> volist;
	private JButton back;
	private JComboBox<String> stateBox;
	private JButton revise;
	private String orgCode;
	/**
	 * Create the panel.
	 * @param clR 
	 */
	public CenterLoadCheckPanel(JPanel parent, CardLayout card, CenterLoadUpdatePanel child, String orgCode) {
		this.orgCode = orgCode;
		setLayout(null);
		setBackground(SystemColor.inactiveCaptionBorder);
		controller = new CenterloadController();

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 13, 917, 335);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{Boolean.FALSE, null, null, null, null, null},
			},
			new String[] {
				"\u9009\u9879", "\u88C5\u8F7D\u65F6\u95F4", "\u6C7D\u8FD0\u7F16\u53F7", "\u76EE\u7684\u5730", "\u8FD0\u8D39", "\u5BA1\u6279\u72B6\u6001"
			}
		) {
			Class[] columnTypes = new Class[] {
				Boolean.class, Long.class, String.class, String.class, Double.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				true, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		
		revise = new JButton("查看详细");
		revise.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = table.getSelectedRow();
				if(index >= 0){
					card.next(parent);
					child.init(volist.get(index));
				}else{
					TipDialog dialog=new TipDialog("请选择查看的单据！");
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				}
			}
		});
		revise.setBounds(665, 358, 113, 27);
		add(revise);
		
		back = new JButton("返回");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.previous(parent);
			}
		});
		back.setBounds(792, 358, 113, 27);
		add(back);
		
		stateBox = new JComboBox<String>();
		stateBox.setBounds(67, 359, 169, 24);
		add(stateBox);
		
		JButton act = new JButton("执行");
		act.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateVOListState(Formstate.checked);
			}
		});
		act.setBounds(538, 358, 113, 27);
		add(act);
		stateBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				 refreshList();
				 if (stateBox.getSelectedItem().equals(Formstate.pass.getName())) {
						act.setEnabled(true);
					} else {
						act.setEnabled(false);
					}
			}
		});
		addStateItems();

	}
	
	private void updateVOListState(Formstate state) {
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		for (int i = 0; i < volist.size(); i++) {
			if ((boolean) tableModel.getValueAt(i, 0)) {
				CenterloadVO vo = volist.get(i);
				vo.setDocumentstate(state);
				controller.update(vo);
			}
		}
		refreshList();
	}
	
	private void addStateItems() {
		for (Formstate state : Formstate.values()) {
			stateBox.addItem(state.getName());
		}
	}

	void refreshList() {
		for (Formstate state : Formstate.values()) {
			if (stateBox.getSelectedItem().equals(state.getName()))
				volist = controller.findCenterloadForm(state, orgCode);
		}

		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);// 清除原有行

		for (CenterloadVO vo : volist) {
			Object[] row = new Object[6];
			row[0] = false;
			row[1] = vo.getLoadtime();
			row[2] = vo.getMotorcode();
			row[3] = vo.getDestination();
			row[4] = vo.getfee();
			row[5] = vo.getFormstate().getName();

			tableModel.addRow(row);
		}

	}
}
