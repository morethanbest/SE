package presentation.managerui.examui.examcentersalesmanui;

import java.awt.CardLayout;
import java.awt.SystemColor;
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

import po.Formstate;
import presentation.managerui.examui.ExamPanel;
import vo.ArrivalVO;
import businesslogic.managerbl.ExamPack.ExamController;
import businesslogicservice.managerblservice.ExamArrivals;

public class ArrivalExamPanel extends JPanel {
	private JTable table;
	private ExamArrivals ea;
	private List<ArrivalVO> volist;
	private JComboBox<String> stateBox;
	private JButton pass;
	private JButton refused;
	private JButton revise;
	private JButton back;

	/**
	 * Create the panel.
	 * 
	 * @param card
	 * @param examPanel
	 */
	public ArrivalExamPanel(ExamPanel parent, CardLayout card) {
		setBackground(SystemColor.inactiveCaptionBorder);
		ea = new ExamController();

		setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 35, 917, 335);
		add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] { { null, null,
				null, null, null, null }, }, new String[] { "\u9009\u9879",
				"\u4E2D\u8F6C\u4E2D\u5FC3\u7F16\u53F7",
				"\u5230\u8FBE\u65F6\u95F4", "\u4E2D\u8F6C\u5355\u7F16\u53F7",
				"\u76EE\u7684\u5730", "\u5BA1\u6279\u72B6\u6001" }) {
			Class[] columnTypes = new Class[] { Boolean.class, String.class,
					Long.class, String.class, String.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { false, false, false,
					false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(15);

		scrollPane.setViewportView(table);

		pass = new JButton("通过");
		pass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateVOListState(Formstate.pass);
			}
		});
		pass.setBounds(411, 380, 113, 27);
		add(pass);

		refused = new JButton("否决");
		refused.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateVOListState(Formstate.fail);
			}
		});
		refused.setBounds(538, 380, 113, 27);
		add(refused);

		revise = new JButton("查看详细");
		revise.setBounds(665, 380, 113, 27);
		add(revise);

		back = new JButton("返回");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(parent, "select");
			}
		});
		back.setBounds(792, 380, 113, 27);
		add(back);

		stateBox = new JComboBox<String>();
		stateBox.setBounds(67, 381, 169, 24);
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
				ArrivalVO vo = volist.get(i);
				vo.setDocumentstate(state);
				ea.updateArrivalForm(vo);
			}
		}
		refreshList();
	}

	private void refreshList() {
		for (Formstate state : Formstate.values()) {
			if (stateBox.getSelectedItem().equals(state.getName()))
				volist = ea.getArrivalForm(state);
		}

		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);// 清除原有行

		for (ArrivalVO vo : volist) {
			Object[] row = new Object[6];
			row[0] = false;
			row[1] = vo.getCentercode();
			row[2] = vo.getArrivaltime();
			row[3] = vo.getTranscode();
			row[4] = vo.getDeparture();
			row[5] = vo.getFormstate().getName();

			tableModel.addRow(row);
		}

	}
}
