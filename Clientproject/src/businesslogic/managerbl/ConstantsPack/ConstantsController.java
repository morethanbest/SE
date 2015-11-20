package businesslogic.managerbl.ConstantsPack;

import java.rmi.RemoteException;
import java.util.List;

import businesslogicservice.managerblservice.ConstantsBlService;
import vo.ConstantsVO;
import vo.ResultMessage;

public class ConstantsController implements ConstantsBlService {

	@Override
	public ResultMessage addConstants(ConstantsVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		AddConstants addc=new AddConstants();
		IdInfo id=new IdInfo();
		Constants c=new Constants(addc,id);
		ResultMessage result=c.addConstants(vo);
		return result;
	}

	@Override
	public ResultMessage delConstants(ConstantsVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		DelConstants delc=new DelConstants();
		Constants c=new Constants(delc); 
		ResultMessage result=c.delConstants(vo);
		return result;
	}

	@Override
	public ResultMessage revConstants(String originalname,ConstantsVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		RevConstants revc=new RevConstants();
		Constants c= new Constants(revc);
		ResultMessage result=c.revConstants(originalname,vo);
		return result;
	}

	@Override
	public List<ConstantsVO> getConstants(String name) throws RemoteException {
		// TODO Auto-generated method stub
		FindConstants findc=new FindConstants();
		Constants c=new Constants(findc);
		List<ConstantsVO> listvo=c.fuzzyfindConstants(name);
		return listvo;
	}

}
