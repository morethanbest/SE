package presentation.managerui.examui.examdepotui;

import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;

import vo.ArrivalVO;
import vo.StockinVO;
import businesslogicservice.managerblservice.ExamArrivals;
import businesslogicservice.managerblservice.ExamInbounds;

public class StockinExamPanel extends JPanel {
	private JButton pass;
	private JButton refused;
	private JButton revise;
	private JButton back;
	private JComboBox<String> stateBox;
	private JTable table;
	private ExamInbounds ea;
	private List<StockinVO> volist;

	/**
	 * Create the panel.
	 */
	public StockinExamPanel() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 13, 917, 335);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		pass = new JButton("通过");
		pass.setBounds(411, 358, 113, 27);
		add(pass);
		
		refused = new JButton("否决");
		refused.setBounds(538, 358, 113, 27);
		add(refused);
		
		revise = new JButton("查看详细");
		revise.setBounds(665, 358, 113, 27);
		add(revise);
		
		back = new JButton("返回");
		back.setBounds(792, 358, 113, 27);
		add(back);
		
		stateBox = new JComboBox<String>();
		stateBox.setBounds(67, 359, 169, 24);
		add(stateBox);

	}

}
