package po;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/12/3.
 */
public enum RecordpayList implements Serializable{

        rent("租金"),fare("运费"),wages("人员工资"),bonus("奖励");
        
    	private String name;
        
        private RecordpayList(String name){
        	this.name=name;
        }
		public String getName() {
			return name;
		}
        

}
