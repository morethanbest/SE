package presentation.managerui.examui.examfinancial;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import businesslogic.managerbl.ExamPack.ExamController;
import businesslogicservice.managerblservice.ExamCLForms;
import businesslogicservice.managerblservice.ExamRecordpays;
import po.Formstate;
import presentation.managerui.examui.ExamPanel;
import vo.CenterloadVO;
import vo.RecordpayVO;

public class RecordpayExamPanel extends JPanel {
	private JTable table;
	private ExamRecordpays ea;
	private List<RecordpayVO> volist;
	private JButton pass;
	private JButton refused;
	private JButton back;
	private JComboBox<String> stateBox;
	private JButton revise;
	/**
	 * Create the panel.
	 */
	public RecordpayExamPanel(ExamPanel parent, CardLayout card) {
		setLayout(null);
		ea = new ExamController();

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 13, 917, 335);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{Boolean.FALSE, null, null, null, null, null, null},
			},
			new String[] {
				"\u9009\u9879", "\u4ED8\u6B3E\u65F6\u95F4", "\u4ED8\u6B3E\u91D1\u989D", "\u4ED8\u6B3E\u8D26\u53F7", "\u4ED8\u6B3E\u4EBA", "\u6761\u76EE", "\u5BA1\u6279\u72B6\u6001"
			}
		) {
			Class[] columnTypes = new Class[] {
				Boolean.class, Long.class, Double.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				true, false, false, false, false, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		
		pass = new JButton("通过");
		pass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateVOListState(Formstate.pass);
			}
		});
		pass.setBounds(411, 358, 113, 27);
		add(pass);
		
		refused = new JButton("否决");
		refused.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateVOListState(Formstate.fail);
			}
		});
		refused.setBounds(538, 358, 113, 27);
		add(refused);
		
		revise = new JButton("查看详细");
		revise.setBounds(665, 358, 113, 27);
		add(revise);
		
		back = new JButton("返回");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(parent, "select");
			}
		});
		back.setBounds(792, 358, 113, 27);
		add(back);
		
		stateBox = new JComboBox<String>();
		stateBox.setBounds(67, 359, 169, 24);
		add(stateBox);
		stateBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				 refreshList();
				if (stateBox.getSelectedItem().equals(Formstate.pass.getName())) {
					pass.setEnabled(false);
					refused.setEnabled(false);
				} else if (stateBox.getSelectedItem().equals(
						Formstate.fail.getName())) {
					pass.setEnabled(true);
					refused.setEnabled(false);
				} else if (stateBox.getSelectedItem().equals(
						Formstate.checked.getName())) {
					pass.setEnabled(false);
					refused.setEnabled(false);
				} else if (stateBox.getSelectedItem().equals(
						Formstate.waiting.getName())) {
					pass.setEnabled(true);
					refused.setEnabled(true);
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
				RecordpayVO vo = volist.get(i);
			    vo.setFormstate(state);
				ea.updateRecordpayForm(vo);
			}
		}
		refreshList();
	}

	private void refreshList() {
		for (Formstate state : Formstate.values()) {
			if (stateBox.getSelectedItem().equals(state.getName()))
				volist = ea.getRecordpayForm(state);
		}

		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);// 清除原有行

		for (RecordpayVO vo : volist) {
			Object[] row = new Object[6];
			row[0] = false;
			row[1] = vo.getPaytime();
			row[2] = vo.getPaysum();
			row[3] = vo.getPayaccount();
			row[4] = vo.getPayman();
			row[5] = vo.getEntry().getName();
			row[6] = vo.getFormstate().getName();
			tableModel.addRow(row);
		}

	}
}
