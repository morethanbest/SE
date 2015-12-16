package presentation.centersalesmanui.arrivalui;

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
import presentation.centersalesmanui.CenterSalesmanPanel;
import presentation.tip.TipDialog;
import vo.ArrivalVO;
import businesslogic.logisticsbl.ArrivalPack.ArrivalController;
import businesslogic.managerbl.ExamPack.ExamController;
import businesslogicservice.logisticsblservice.ArrivalBlService;
import businesslogicservice.managerblservice.ExamArrivals;

public class ArrivalCheckPanel extends JPanel {
	private JTable table;
	private ArrivalBlService controller;
	private List<ArrivalVO> volist;
	private JComboBox<String> stateBox;
	private JButton revise;
	private JButton back;
	private String orgCode;
	private String orgName;
	/**
	 * Create the panel.
	 * 
	 * @param card
	 * @param examPanel
	 */
	public ArrivalCheckPanel(JPanel parent, CardLayout card, ArrivalUpdatePanel child, String orgCode,String orgName) {
		this.orgCode = orgCode;
		this.orgName = orgName;
		setBackground(SystemColor.inactiveCaptionBorder);
		controller = new ArrivalController();

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

			boolean[] columnEditables = new boolean[] { true, false, false,
					false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(15);

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
		revise.setBounds(665, 380, 113, 27);
		add(revise);

		back = new JButton("返回");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(parent, "arrival");
			}
		});
		back.setBounds(792, 380, 113, 27);
		add(back);

		stateBox = new JComboBox<String>();
		stateBox.setBounds(67, 381, 169, 24);
		add(stateBox);
		
		JButton act = new JButton("执行");
		act.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateVOListState(Formstate.checked);
			}
		});
		act.setBounds(538, 380, 113, 27);
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
				ArrivalVO vo = volist.get(i);
				vo.setDocumentstate(state);
				if(vo.getwhefromhall())
					controller.updateFromHall(vo, orgName);
				else
					controller.updateFromCenter(vo, orgName);
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
				volist = controller.search(orgCode, state);
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
