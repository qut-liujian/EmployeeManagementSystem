package neu.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MapUtil {

	
	public static Map<String, String> convertToMap(Map<String, String[]> params){
		Map<String, String> item=null;
		if(params!=null && params.size()>0) {
			item=new HashMap<String, String>();
			for (Map.Entry<String, String[]> entry : params.entrySet()) {
				String key=entry.getKey();
				String[] values=entry.getValue();
				String value=Arrays.deepToString(values)
						.replace("[", "").replace("]","");
				item.put(key, value);
			}
		}
		return item;
	}
}
