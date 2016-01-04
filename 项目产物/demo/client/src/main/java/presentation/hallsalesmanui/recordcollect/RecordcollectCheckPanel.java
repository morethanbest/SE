package presentation.hallsalesmanui.recordcollect;

import java.awt.CardLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import businesslogic.balancebl.RecordcollectPack.RecordcollectController;
import businesslogicservice.balanceblservice.RecordCollectBlService;
import po.Formstate;
import presentation.mycomp.MyButton_LightBlue;
import presentation.mycomp.WorkPanel;
import presentation.mycomp.mycombobox.MyComboBox;
import presentation.mycomp.myscrollpane.MyScrollPane;
import presentation.tip.TipDialog;
import vo.RecordcollectVO;

public class RecordcollectCheckPanel extends WorkPanel {
	private JTable table;
	private RecordCollectBlService controller;
	private List<RecordcollectVO> volist;
	private MyButton_LightBlue back;
	private MyComboBox<String> stateBox;
	private MyButton_LightBlue revise;
	private String orgCode;
	/**
	 * Create the panel.
	 */
	public RecordcollectCheckPanel(JPanel parent, CardLayout card, RecordcollectUpdatePanel child, String orgCode) {
		this.orgCode = orgCode;
		setLayout(null);
		controller = new RecordcollectController();
		setBackground(SystemColor.inactiveCaptionBorder);
		
		MyScrollPane scrollPane = new MyScrollPane();
		scrollPane.setBounds(14, 13, 917, 335);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{Boolean.FALSE, null, null, null, null, null},
			},
			new String[] {
				"\u9009\u9879", "\u6536\u6B3E\u65F6\u95F4", "\u6536\u6B3E\u91D1\u989D", "\u6536\u6B3E\u8D26\u53F7", "\u6536\u6B3E\u4EBA", "\u5BA1\u6279\u72B6\u6001"
			}
		) {
			Class[] columnTypes = new Class[] {
				Boolean.class, Long.class, Double.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
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
				RecordcollectVO vo = volist.get(i);
				vo.setFormstate(state);
				controller.updateCollect(vo);
			}
		}
		refreshList();
	}

	void refreshList() {
		for (Formstate state : Formstate.values()) {
			if (stateBox.getSelectedItem().equals(state.getName()))
				volist = controller.findform(state, orgCode);
		}

		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);// 清除原有行

		for (RecordcollectVO vo : volist) {
			Object[] row = new Object[6];
			row[0] = false;
			row[1] = vo.getCollectiontime();
			row[2] = vo.getCollectionsum();
			row[3] = vo.getAccountcode();
			row[4] = vo.getCollectiontime();
			row[5] = vo.getFormstate().getName();
			tableModel.addRow(row);
		}

	}
}
