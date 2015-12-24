package presentation.depotui.stockoutui;

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
import vo.StockoutVO;
import businesslogic.commoditybl.StockoutPack.StockoutController;
import businesslogic.commoditybl.StocktakingPack.StocktakingController;
import businesslogic.managerbl.ExamPack.ExamController;
import businesslogicservice.commodityblservice.StockoutBlService;
import businesslogicservice.managerblservice.ExamStockouts;

public class StockoutCheckPanel extends JPanel {
	private JTable table;
	private StockoutBlService controller;
	private List<StockoutVO> volist;
	private JComboBox<String> stateBox;
	private JButton revise;
	private JButton back;
	private String orgCode;
	private JButton act;

	/**
	 * Create the panel.
	 * @param orgCode 
	 */
	public StockoutCheckPanel(JPanel parent, CardLayout card, StockoutUpdatePanel child, String orgCode) {
		this.orgCode = orgCode;
		controller = new StockoutController();
		setLayout(null);
		setBackground(SystemColor.inactiveCaptionBorder);
		
		JScrollPane scrollPane = new JScrollPane();
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
		
		act = new JButton("执行");
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
				StockoutVO vo = volist.get(i);
				vo.setFormstate(state);
				controller.update(vo);
			}
		}
		refreshList();
	}

	public void refreshList() {
		for (Formstate state : Formstate.values()) {
			if (stateBox.getSelectedItem().equals(state.getName()))
				volist = controller.findforms(state, orgCode);
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
