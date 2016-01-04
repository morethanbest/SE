package businesslogic.logisticsbl.LogisticsPack;

import dataservice.logisticsdataservice.LogisticsInfoService;
import init.RMIHelper;
import po.LogisticsPO;
import presentation.tip.TipDialog;
import vo.LogisticsVO;

import java.rmi.RemoteException;
import java.util.List;

import javax.swing.JDialog;

/**
 * Created by Administrator on 2015/11/28.
 */
public class Search {
    public LogisticsVO searchorder(String ordernum){
        LogisticsInfoService dataserv= RMIHelper.getLogisticsinfo();
        LogisticsPO po=null;
        LogisticsVO vo=null;
        try {
            po=dataserv.findLogisticsInfo(ordernum);
			String state = po.getState();
			List<String> history = po.getHistory();
			vo = new LogisticsVO(state, history, ordernum);
        } catch (Exception e) {
        	System.out.println("search logistics by num failed!!!");
        	TipDialog dialog=new TipDialog("该订单不存在！");
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);	
        	e.printStackTrace();
        }
        return vo;



    }
}
