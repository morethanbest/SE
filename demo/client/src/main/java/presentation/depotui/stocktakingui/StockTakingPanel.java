package presentation.depotui.stocktakingui;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import businesslogic.commoditybl.StocktakingPack.StocktakingController;
import businesslogicservice.commodityblservice.StocktakingBlService;
import po.Block;
import presentation.mycomp.MyButton_LightBlue;
import presentation.mycomp.WorkPanel;
import presentation.mycomp.mycombobox.MyComboBox;
import presentation.mycomp.myscrollpane.MyScrollPane;
import vo.CommodityTakingVO;

public class StockTakingPanel extends WorkPanel {
	private JTable table;
	private MyComboBox<String> blockBox;
	private MyButton_LightBlue button;
	private JLabel label;
	private List<CommodityTakingVO> list1;
	private List<CommodityTakingVO> list2;
	private List<CommodityTakingVO> list3;
	private List<CommodityTakingVO> list4;
	private StocktakingBlService stocktakingBlService;

	/**
	 * Create the panel.
	 */
	public StockTakingPanel(String orgCode) {
		
		stocktakingBlService = new StocktakingController();
		setLayout(null);
		setBackground(SystemColor.inactiveCaptionBorder);
		
		blockBox = new MyComboBox<String>();
		blockBox.setBounds(250, 0, 174, 24);
		blockBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				selectToDisplay();
			}
		});
		add(blockBox);
		addBlockItems();
		
		MyScrollPane scrollPane = new MyScrollPane();
		scrollPane.setBounds(14, 38, 917, 369);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"\u8BA2\u5355\u53F7", "\u5165\u5E93\u65F6\u95F4", "\u76EE\u7684\u5730", "\u5206\u533A", "\u6392\u53F7", "\u67B6\u53F7", "\u4F4D\u53F7"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		
		label = new JLabel("本次盘点批号：");
		label.setBounds(14, 3, 220, 18);
		add(label);
		
		button = new MyButton_LightBlue("开始盘点");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calendar c = Calendar.getInstance();
				long date = c.get(Calendar.YEAR) * 10000
						+ (c.get(Calendar.MONTH) + 1) * 100
						+ c.get(Calendar.DAY_OF_MONTH);
				list1 = stocktakingBlService.Stocktaking(orgCode, date, Block.flight.getBlocknum()).getList();
				list2 = stocktakingBlService.Stocktaking(orgCode, date, Block.train.getBlocknum()).getList();
				list3 = stocktakingBlService.Stocktaking(orgCode, date, Block.truck.getBlocknum()).getList();
				list4 = stocktakingBlService.Stocktaking(orgCode, date, Block.flexible.getBlocknum()).getList();
				selectToDisplay();
				label.setText("本次盘点批号："+stocktakingBlService.getId(orgCode, date));
			}
		});
		button.setBounds(581, -1, 113, 27);
		add(button);

	}
	
	private void addBlockItems() {
		for (Block block : Block.values()) {
			blockBox.addItem(block.getName());
		}
	}

	private long getBlockIndex(String str) {
		for (Block block : Block.values()) {
			if (block.getName().equals(str))
				return block.getBlocknum();
		}

		return -1;
	}
	
	private String getBlockIndex(long k){
		for (Block block : Block.values()) {
			if (block.getBlocknum() == k)
				return block.getName();
		}

		return null;
	}
	
	private void selectToDisplay(){
		if(list1 == null || list2 == null || list3 == null || list4 == null)
			return;
		String str = (String) blockBox.getSelectedItem();
		if(str.equals(Block.flight.getName()))
			displayByVO(list1);
		else if(str.equals(Block.train.getName()))
			displayByVO(list2);
		else if(str.equals(Block.truck.getName()))
			displayByVO(list3);
		else if(str.equals(Block.flexible.getName()))
			displayByVO(list4);
	}
	
	private void displayByVO(List<CommodityTakingVO> list){
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);// 清除原有行
		for (CommodityTakingVO vo : list) {
			Object[] row= new Object[7];
			row[0] = vo.getOrdercode();
			row[1] = vo.getIntime();
			row[2] = vo.getDestination();
			row[3] = getBlockIndex(vo.getLocation().getBlocknum());
			row[4] = vo.getLocation().getLinenum();
			row[5] = vo.getLocation().getShelfnum();
			row[6] = vo.getLocation().getLocationnum();
			
			tableModel.addRow(row);
		}
	}
}
