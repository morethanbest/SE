package presentation.managerui.examui.examdepotui;

import java.awt.CardLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;

import vo.ArrivalVO;
import vo.StockinVO;
import businesslogic.managerbl.ExamPack.ExamController;
import businesslogicservice.managerblservice.ExamArrivals;
import businesslogicservice.managerblservice.ExamInbounds;

import javax.swing.table.DefaultTableModel;

import po.Formstate;
import presentation.managerui.examui.ExamPanel;

public class StockinExamPanel extends JPanel {
	private JButton pass;
	private JButton refused;
	private JButton revise;
	private JButton back;
	private JComboBox<String> stateBox;
	private JTable table;
	private ExamInbounds ea;
	private List<StockinVO> volist;

	/**
	 * Create the panel.
	 */
	public StockinExamPanel(ExamPanel parent, CardLayout card, StockinRevisePanel child) {
		ea = new ExamController();
		setLayout(null);
		setBackground(SystemColor.inactiveCaptionBorder);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 13, 917, 335);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"\u9009\u9879", "\u8BA2\u5355\u53F7", "\u5165\u5E93\u65F6\u95F4", "\u76EE\u7684\u5730", "\u5BA1\u6279\u72B6\u6001"
			}
		) {
			Class[] columnTypes = new Class[] {
				Boolean.class, String.class, Long.class, String.class, String.class
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
		revise.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.next(parent);
				int index = table.getSelectedRow();
				if(index >= 0)
					child.init(volist.get(index));
			}
		});
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
				StockinVO vo = volist.get(i);
				vo.setFormstate(state);
				ea.updateStockinForm(vo);
			}
		}
		refreshList();
	}

	void refreshList() {
		for (Formstate state : Formstate.values()) {
			if (stateBox.getSelectedItem().equals(state.getName()))
				volist = ea.getStockinForm(state);
		}

		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);// 清除原有行

		for (StockinVO vo : volist) {
			Object[] row = new Object[5];
			row[0] = false;
			row[1] = vo.getOrdercode();
			row[2] = vo.getIntime();
			row[3] = vo.getDestination();
			row[4] = vo.getFormstate().getName();

			tableModel.addRow(row);
		}

	}
}
