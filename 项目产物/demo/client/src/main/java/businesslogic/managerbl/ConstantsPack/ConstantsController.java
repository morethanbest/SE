package businesslogic.managerbl.ConstantsPack;

import java.util.List;

import businesslogicservice.managerblservice.ConstantsBlService;
import po.ResultMessage;
import vo.CityVO;
import vo.ConstantsVO;

public class ConstantsController implements ConstantsBlService {

	@Override
	public ResultMessage addConstants(ConstantsVO vo){
		// TODO Auto-generated method stub
		AddConstants addc=new AddConstants();
		IdInfo id=new IdInfo();
		Constants c=new Constants(addc,id);
		ResultMessage result=c.addConstants(vo);
		return result;
	}

	@Override
	public ResultMessage delConstants(ConstantsVO vo){
		// TODO Auto-generated method stub
		DelConstants delc=new DelConstants();
		Constants c=new Constants(delc); 
		ResultMessage result=c.delConstants(vo);
		return result;
	}

	@Override
	public ResultMessage revConstants(ConstantsVO vo){
		// TODO Auto-generated method stub
		RevConstants revc=new RevConstants();
		Constants c= new Constants(revc);
		ResultMessage result=c.revConstants(vo);
		return result;
	}

	@Override
	public List<ConstantsVO> getConstants(String name){
		// TODO Auto-generated method stub
		FindConstants findc=new FindConstants();
		Constants c=new Constants(findc);
		List<ConstantsVO> listvo=c.fuzzyfindConstants(name);
		return listvo;
	}
	

	@Override
	public ResultMessage addCity(CityVO vo){
		AddCity addCity=new AddCity();
		Constants constants=new Constants(addCity);
		ResultMessage result=constants.addCity(vo);
		return result;
	}
	@Override
	public ResultMessage delCity(CityVO vo){
		DelCity delCity=new DelCity();
		Constants constants=new Constants(delCity);
		ResultMessage result=constants.delCity(vo);
		return result;
	}
	
	@Override
	public ResultMessage revCity(CityVO vo){
		RevCity revCity=new RevCity();
		Constants constants=new Constants(revCity);
		ResultMessage result=constants.revCity(vo);
		return result;
	}
	
	@Override
	public List<CityVO> getAllCity(){
		FindCity findCity=new FindCity();
		Constants constants=new Constants(findCity);
		List<CityVO> list=constants.getAll();
		return list;
	}
	
	@Override
	public CityVO findCity(String name){
		FindCity findCity=new FindCity();
		Constants constants=new Constants(findCity);
		CityVO vo=constants.findCity(name);
		return vo;
	}
	
}
