package businesslogic.accountbl.NewBookPack;

import businesslogicservice.accountblservice.NewBookBlService;
import dataservice.accountdataservice.NewBookDataService;
import po.NewbookPO;
import po.ResultMessage;
import vo.NewbookVO;

import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by Administrator on 2015/12/8.
 */
public class NewBookController implements NewBookBlService {


    @Override
    public ResultMessage NewBook(long id) {
        AddNewbook add=new AddNewbook();
        ResultMessage result=add.addNew(id);
        return result;
    }

    @Override
    public NewbookVO find(long time) {
        FindNewbook find=new FindNewbook();
        NewbookVO vo=find.find(time);
        return vo;
    }

    @Override
    public long getid() {
        IdGet idgetter=new IdGet();
        long id=idgetter.getid();
        return id;
    }
}
