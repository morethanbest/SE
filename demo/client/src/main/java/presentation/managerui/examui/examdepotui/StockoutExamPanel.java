package presentation.managerui.examui.examdepotui;

import java.awt.CardLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import businesslogic.managerbl.ExamPack.ExamController;
import businesslogicservice.managerblservice.ExamStockouts;
import po.Formstate;
import presentation.managerui.examui.ExamPanel;
import presentation.mycomp.MyButton_LightBlue;
import presentation.mycomp.WorkPanel;
import presentation.mycomp.mycombobox.MyComboBox;
import presentation.mycomp.myscrollpane.MyScrollPane;
import vo.StockoutVO;

public class StockoutExamPanel extends WorkPanel {
	private JTable table;
	private ExamStockouts ea;
	private List<StockoutVO> volist;
	private MyComboBox<String> stateBox;
	private MyButton_LightBlue pass;
	private MyButton_LightBlue refused;
	private MyButton_LightBlue revise;
	private MyButton_LightBlue back;

	/**
	 * Create the panel.
	 */
	public StockoutExamPanel(ExamPanel parent, CardLayout card, StockoutRevisePanel child) {
		ea = new ExamController();
		setLayout(null);
		setBackground(SystemColor.inactiveCaptionBorder);
		MyScrollPane scrollPane = new MyScrollPane();
		scrollPane.setBounds(14, 13, 917, 335);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"\u9009\u9879", "\u8BA2\u5355\u7F16\u53F7", "\u51FA\u5E93\u65E5\u671F", "\u76EE\u7684\u5730", "\u8FD0\u8F93\u7C7B\u578B", "\u4E2D\u8F6C\u5355\u6216\u6C7D\u8FD0\u7F16\u53F7", "\u5BA1\u6279\u72B6\u6001"
			}
		) {
			Class[] columnTypes = new Class[] {
				Boolean.class, String.class, Long.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				true, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		
		pass = new MyButton_LightBlue("通过");
		pass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateVOListState(Formstate.pass);
			}
		});
		pass.setBounds(411, 358, 113, 27);
		add(pass);
		
		refused = new MyButton_LightBlue("否决");
		refused.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateVOListState(Formstate.fail);
			}
		});
		refused.setBounds(538, 358, 113, 27);
		add(refused);
		
		revise = new MyButton_LightBlue("查看详细");
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
		
		back = new MyButton_LightBlue("返回");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(parent, "select");
			}
		});
		back.setBounds(792, 358, 113, 27);
		add(back);
		
		stateBox = new MyComboBox<String>();
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
				StockoutVO vo = volist.get(i);
				vo.setFormstate(state);
				ea.updateStockoutForm(vo);
			}
		}
		refreshList();
	}

	public void refreshList() {
		for (Formstate state : Formstate.values()) {
			if (stateBox.getSelectedItem().equals(state.getName()))
				volist = ea.getStockoutForm(state);
		}

		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);// 清除原有行

		for (StockoutVO vo : volist) {
			Object[] row = new Object[7];
			row[0] = false;
			row[1] = vo.getOrdercode();
			row[2] = vo.getOuttime();
			row[3] = vo.getDestination();
			row[4] = vo.getTransportType();
			row[5] = vo.getTranscode();
			row[6] = vo.getFormstate().getName();

			tableModel.addRow(row);
		}

	}


}
