package presentation.depotui.stockexamui;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import businesslogic.commoditybl.StockExaminationPack.StockExaminationController;
import businesslogicservice.commodityblservice.StockExaminationBlService;
import po.CommodityLocation;
import presentation.mycomp.WorkPanel;
import presentation.mycomp.mycombobox.MyComboBox;
import presentation.mycomp.myscrollpane.MyScrollPane;
import vo.CommodityExamVO;
import vo.StockExaminationVO;

public class StockExamPanel extends WorkPanel {
	private JTable table;
	private MyComboBox<Long> syearBox;
	private MyComboBox<Long> smonthBox;
	private MyComboBox<Long> sdateBox;
	private MyComboBox<Long> eyearBox;
	private MyComboBox<Long> emonthBox;
	private MyComboBox<Long> edateBox;
	private JLabel allLabel;
	private JLabel outLabel;
	private JLabel inLabel;
	private JLabel endLabel;
	private JLabel startLabel;

	/**
	 * Create the panel.
	 */
	public StockExamPanel(String orgCode) {
		setLayout(null);
		setBackground(SystemColor.inactiveCaptionBorder);
		
		startLabel = new JLabel("开始日期：");
		startLabel.setBounds(28, 240, 160, 18);
		add(startLabel);
		
		endLabel = new JLabel("结束日期：");
		endLabel.setBounds(28, 270, 160, 18);
		add(endLabel);
		
		inLabel = new JLabel("入库数：");
		inLabel.setBounds(28, 301, 160, 18);
		add(inLabel);
		
		outLabel = new JLabel("出库数：");
		outLabel.setBounds(28, 329, 160, 18);
		add(outLabel);
		
		allLabel = new JLabel("总数：");
		allLabel.setBounds(28, 359, 160, 18);
		add(allLabel);
		
		MyScrollPane scrollPane = new MyScrollPane();
		scrollPane.setBounds(224, 15, 705, 383);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u8BA2\u5355\u53F7", "\u5206\u533A", "\u6392\u53F7", "\u67B6\u53F7", "\u4F4D\u53F7"
			}
		));
		scrollPane.setViewportView(table);
		
		syearBox = new MyComboBox<Long>();
		syearBox.setBounds(14, 43, 67, 24);
		add(syearBox);
		
		smonthBox = new MyComboBox<Long>();
		smonthBox.setBounds(95, 43, 47, 24);
		add(smonthBox);
		
		addYearItems(syearBox, smonthBox);
		
		sdateBox = new MyComboBox<Long>();
		sdateBox.setBounds(156, 43, 47, 24);
		add(sdateBox);
		
		addDateItems(syearBox, smonthBox, sdateBox);
		
		eyearBox = new MyComboBox<Long>();
		eyearBox.setBounds(14, 121, 67, 24);
		add(eyearBox);
		
		emonthBox = new MyComboBox<Long>();
		emonthBox.setBounds(95, 121, 47, 24);
		add(emonthBox);
		
		addYearItems(eyearBox, emonthBox);
		
		edateBox = new MyComboBox<Long>();
		edateBox.setBounds(156, 121, 47, 24);
		add(edateBox);
		
		addDateItems(eyearBox, emonthBox, edateBox);
		
		JButton button = new JButton("开始盘点");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Long sdate = (Long) syearBox.getSelectedItem() * 10000
						+ (Long) smonthBox.getSelectedItem() * 100
						+ (Long) sdateBox.getSelectedItem();
				Long edate = (Long) eyearBox.getSelectedItem() * 10000
						+ (Long) emonthBox.getSelectedItem() * 100
						+ (Long) edateBox.getSelectedItem();
				
				StockExaminationBlService s = new StockExaminationController();
				StockExaminationVO vo = s.StockExamination(orgCode, sdate, edate);
				startLabel.setText("开始日期：" + vo.getStartTime());
				endLabel.setText("结束日期：" + vo.getEndTime());
				inLabel.setText("入库数：" + vo.getstocinnum());
				outLabel.setText("出库数：" + vo.getstockoutnum());
				allLabel.setText("总数：" + vo.getallstocknum());
				displayByList(vo.getList());
			}
		});
		button.setBounds(54, 185, 113, 27);
		add(button);
		
		ItemListener listener1 = new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				addDateItems(syearBox, smonthBox, sdateBox);
			}
		};
		syearBox.addItemListener(listener1);
		smonthBox.addItemListener(listener1);
		
		ItemListener listener2 = new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				addDateItems(eyearBox, emonthBox, edateBox);
			}
		};
		eyearBox.addItemListener(listener2);
		emonthBox.addItemListener(listener2);
		
		Calendar c = Calendar.getInstance();
		syearBox.setSelectedItem((long)c.get(Calendar.YEAR));
		smonthBox.setSelectedItem((long)c.get(Calendar.MONTH) + 1);
		sdateBox.setSelectedItem((long)c.get(Calendar.DAY_OF_MONTH));
		eyearBox.setSelectedItem((long)c.get(Calendar.YEAR));
		emonthBox.setSelectedItem((long)c.get(Calendar.MONTH) + 1);
		edateBox.setSelectedItem((long)c.get(Calendar.DAY_OF_MONTH));

	}
	
	private void addYearItems(JComboBox<Long> year, JComboBox<Long> month) {
		for (long i = 2000; i <= 2050; i++) {
			year.addItem(i);
		}

		for (long i = 1; i <= 12; i++) {
			month.addItem(i);
		}
	}

	private void addDateItems(JComboBox<Long> yearBox,
			JComboBox<Long> monthBox, JComboBox<Long> dateBox) {
		dateBox.removeAllItems();
		if ((Long) monthBox.getSelectedItem() == 1
				|| (Long) monthBox.getSelectedItem() == 3
				|| (Long) monthBox.getSelectedItem() == 5
				|| (Long) monthBox.getSelectedItem() == 7
				|| (Long) monthBox.getSelectedItem() == 8
				|| (Long) monthBox.getSelectedItem() == 10
				|| (Long) monthBox.getSelectedItem() == 12) {
			for (long i = 1; i <= 31; i++) {
				dateBox.addItem(i);
			}
		} else if ((Long) monthBox.getSelectedItem() == 4
				|| (Long) monthBox.getSelectedItem() == 6
				|| (Long) monthBox.getSelectedItem() == 9
				|| (Long) monthBox.getSelectedItem() == 11) {
			for (long i = 1; i <= 30; i++) {
				dateBox.addItem(i);
			}
		} else {
			for (long i = 1; i <= 28; i++) {
				dateBox.addItem(i);
			}
			if ((Long) yearBox.getSelectedItem() % 4 == 0)
				dateBox.addItem((long) 29);
		}
	}
	
	private void displayByList(List<CommodityExamVO> list){
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);// 清除原有行
		for (CommodityExamVO vo : list) {
			Object[] row = new Object[5];
			row[0] = vo.getOrdercode();
			CommodityLocation location = vo.getLocation();
			row[1] = getAreaStr(location.getBlocknum());
			row[2] = location.getLinenum();
			row[3] = location.getShelfnum();
			row[4] = location.getLocationnum();
			tableModel.addRow(row);
		}
	} 
	
	private String getAreaStr(long i){
		if(i == 1)
			return "航运区";
		else if(i == 2)
			return "铁运区";
		else if(i == 3)
			return "汽运区";
		else
			return "机动区";
	}
}
