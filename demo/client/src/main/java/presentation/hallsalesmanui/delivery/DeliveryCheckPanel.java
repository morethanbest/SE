package presentation.hallsalesmanui.delivery;

import java.awt.CardLayout;
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
import presentation.managerui.examui.ExamPanel;
import presentation.tip.TipDialog;
import vo.DeliveryVO;
import businesslogic.logisticsbl.DeliveryPack.DeliveryController;
import businesslogic.managerbl.ExamPack.ExamController;
import businesslogicservice.logisticsblservice.DeliveryBlService;
import businesslogicservice.managerblservice.ExamDeliverys;

public class DeliveryCheckPanel extends JPanel {
	private JComboBox<String> stateBox;
	private JButton revise;
	private JButton back;
	private JTable table;
	private DeliveryBlService controller;
	private List<DeliveryVO> volist;
	private String orgCode;
	/**
	 * Create the panel.
	 */
	public DeliveryCheckPanel(JPanel parent, CardLayout card, DeliveryUpdatePanel child, String orgCode) {
		this.orgCode = orgCode;
		controller = new DeliveryController();
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 13, 917, 335);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"\u9009\u9879", "\u5230\u8FBE\u65F6\u95F4", "\u8BA2\u5355\u53F7", "\u6D3E\u4EF6\u5458", "\u5BA1\u6279\u72B6\u6001"
			}
		) {
			Class[] columnTypes = new Class[] {
				Boolean.class, Long.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				true, false, false, false, false
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
	
	private void addStateItems() {
		for (Formstate state : Formstate.values()) {
			stateBox.addItem(state.getName());
		}
	}

	private void updateVOListState(Formstate state) {
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		for (int i = 0; i < volist.size(); i++) {
			if ((boolean) tableModel.getValueAt(i, 0)) {
				DeliveryVO vo = volist.get(i);
				vo.setFormstate(state);
				controller.update(vo);
			}
		}
		refreshList();
	}

	void refreshList() {
		for (Formstate state : Formstate.values()) {
			if (stateBox.getSelectedItem().equals(state.getName()))
				volist = controller.find(state, orgCode);
		}

		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);// 清除原有行

		for (DeliveryVO vo : volist) {
			Object[] row = new Object[5];
			row[0] = false;
			row[1] = vo.getArrivaltime();
			row[2] = vo.getBarcode();
			row[3] = vo.getDelivorinfo();
			row[4] = vo.getDocumentstate().getName();

			tableModel.addRow(row);
		}

	}
}