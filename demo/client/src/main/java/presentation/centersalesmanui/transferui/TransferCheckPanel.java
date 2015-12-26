package presentation.centersalesmanui.transferui;

import java.awt.CardLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import businesslogic.logisticsbl.RecordtransPack.CentertransController;
import businesslogicservice.logisticsblservice.RecordtransBlService;
import po.Formstate;
import presentation.mycomp.MyButton_LightBlue;
import presentation.mycomp.WorkPanel;
import presentation.mycomp.mycombobox.MyComboBox;
import presentation.mycomp.myscrollpane.MyScrollPane;
import vo.RecordtransVO;

public class TransferCheckPanel extends WorkPanel {
	private JTable table;
	private RecordtransBlService controller;
	private List<RecordtransVO> volist;
	private MyComboBox<String> stateBox;
	private MyButton_LightBlue revise;
	private MyButton_LightBlue back;
	private String orgCode;
	private MyButton_LightBlue act;

	/**
	 * Create the panel.
	 */
	public TransferCheckPanel(JPanel parent, CardLayout card, TransferUpdatePanel child, String orgCode) {
		this.orgCode = orgCode;
		setLayout(null);
		setBackground(SystemColor.inactiveCaptionBorder);
		
		controller = new CentertransController();
		
		MyScrollPane scrollPane = new MyScrollPane();
		scrollPane.setBounds(14, 13, 917, 335);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"\u9009\u9879", "\u88C5\u8F7D\u65F6\u95F4", "\u4E2D\u8F6C\u5355\u7F16\u53F7", "\u8FD0\u8F93\u65B9\u5F0F", "\u51FA\u53D1\u5730", "\u76EE\u7684\u5730", "\u5BA1\u6279\u72B6\u6001"
			}
		) {
			Class[] columnTypes = new Class[] {
				Boolean.class, Long.class, String.class, String.class, String.class, String.class, String.class
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
				card.previous(parent);
			}
		});
		back.setBounds(792, 358, 113, 27);
		add(back);
		
		stateBox = new MyComboBox<String>();
		stateBox.setBounds(67, 359, 169, 24);
		add(stateBox);
		
		act = new MyButton_LightBlue("执行");
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
			if((boolean) tableModel.getValueAt(i, 0)){
				RecordtransVO vo = volist.get(i);
				vo.setFormstate(state);
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
				volist = controller.find(state, orgCode);
		}
		
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);// 清除原有行

		for (RecordtransVO vo : volist) {
			Object[] row = new Object[7];
			row[0] = false;
			row[1] = vo.getLoadtime();
			row[2] = vo.getTranscode();
			row[3] = vo.getTransportType();
			row[4] = vo.getDepartrue();
			row[5] = vo.getDestination();
			row[6] = vo.getFormstate().getName();
			
			tableModel.addRow(row);
		}

	}
}
