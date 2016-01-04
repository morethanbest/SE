package presentation.depotui.stockinui;

import java.awt.CardLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import businesslogic.commoditybl.InboundPack.InboundController;
import businesslogicservice.commodityblservice.InboundBlService;
import po.Formstate;
import presentation.mycomp.MyButton_LightBlue;
import presentation.mycomp.WorkPanel;
import presentation.mycomp.mycombobox.MyComboBox;
import presentation.tip.TipDialog;
import vo.StockinVO;

public class StockinCheckPanel extends WorkPanel {
	private MyButton_LightBlue revise;
	private MyButton_LightBlue back;
	private MyComboBox<String> stateBox;
	private JTable table;
	private InboundBlService controller;
	private List<StockinVO> volist;
	private String orgCode;
	/**
	 * Create the panel.
	 */
	public StockinCheckPanel(JPanel parent, CardLayout card, StockinUpdatePanel child, String orgCode,StockinPanel stockinPanel) {
		this.orgCode = orgCode;
		controller = new InboundController();
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
		
		revise = new MyButton_LightBlue("查看详细");
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
		
		back = new MyButton_LightBlue("返回");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stockinPanel.checkAvailable();
				card.previous(parent);
			}
		});
		back.setBounds(792, 358, 113, 27);
		add(back);
		
		stateBox = new MyComboBox<String>();
		stateBox.setBounds(67, 359, 169, 24);
		add(stateBox);
		
		MyButton_LightBlue act = new MyButton_LightBlue("执行");
		act.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateVOListState(Formstate.checked);
			}
		});
		act.setBounds(541, 358, 113, 27);
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
				StockinVO vo = volist.get(i);
				vo.setFormstate(state);
				controller.update(vo);
			}
		}
		refreshList();
	}

	void refreshList() {
		for (Formstate state : Formstate.values()) {
			if (stateBox.getSelectedItem().equals(state.getName()))
				volist = controller.findInboundForm(state, orgCode);
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
