package presentation.managerui.examui.examcourierui;

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
import businesslogicservice.managerblservice.ExamOrdersBlService;
import po.Formstate;
import presentation.managerui.examui.ExamPanel;
import presentation.mycomp.MyButton_LightBlue;
import presentation.mycomp.WorkPanel;
import presentation.mycomp.mycombobox.MyComboBox;
import presentation.mycomp.myscrollpane.MyScrollPane;
import vo.OrderVO;

public class OrderExamPanel extends WorkPanel {
	private JTable table;
	private ExamOrdersBlService ea;
	private List<OrderVO> volist;
	private MyButton_LightBlue pass;
	private MyButton_LightBlue refused;
	private MyButton_LightBlue revise;
	private MyButton_LightBlue back;
	private MyComboBox<String> stateBox;

	/**
	 * Create the panel.
	 */
	public OrderExamPanel(ExamPanel parent, CardLayout card, OrderRevisePanel child) {
		ea = new ExamController();
		setBackground(SystemColor.inactiveCaptionBorder);
		setLayout(null);
		
		MyScrollPane scrollPane = new MyScrollPane();
		scrollPane.setBounds(14, 13, 917, 335);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"\u9009\u9879", "\u8BA2\u5355\u7F16\u53F7", "\u51FA\u53D1\u5730", "\u76EE\u7684\u5730", "\u8FD0\u8D39", "\u5305\u88C5\u7C7B\u578B", "\u5355\u636E\u7C7B\u578B", "\u5BA1\u6279\u72B6\u6001"
			}
		) {
			Class[] columnTypes = new Class[] {
				Boolean.class, String.class, String.class, String.class, Double.class, Object.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				true, false, false, false, false, false, false, false
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
				OrderVO vo = volist.get(i);
				vo.setDocumentstate(state);
				ea.updateOrderForm(vo);
			}
		}
		refreshList();
	}

	public void refreshList() {
		for (Formstate state : Formstate.values()) {
			if (stateBox.getSelectedItem().equals(state.getName()))
				volist = ea.getOrderForm(state);
		}

		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);// 清除原有行

		for (OrderVO vo : volist) {
			Object[] row = new Object[8];
			row[0] = false;
			row[1] = vo.getOrdercode();
			row[2] = vo.getSenderaddress();
			row[3] = vo.getReceiveraddress();
			row[4] = vo.getTotalfee();
			row[5] = vo.getPackagetype();
			row[6] = vo.getOrdertype().getName();
			row[7] = vo.getFormstate().getName();

			tableModel.addRow(row);
		}

	}
}
