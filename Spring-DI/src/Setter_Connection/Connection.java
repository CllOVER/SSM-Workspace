package Setter_Connection;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

//集合的注入
public class Connection {

	private List<String> listValue;
	private Set<String> setValue;
	private String[] arrayValue;
	private Map<String ,String> mapValue;
	private Properties propValue;
	public void setListValue(List<String> listValue) {
		this.listValue = listValue;
	}
	public void setSetValue(Set<String> setValue) {
		this.setValue = setValue;
	}
	public void setArrayValue(String[] arrayValue) {
		this.arrayValue = arrayValue;
	}
	public void setMapValue(Map<String, String> mapValue) {
		this.mapValue = mapValue;
	}
	public void setPropValue(Properties propValue) {
		this.propValue = propValue;
	}
	@Override
	public String toString() {
		return "Connection [listValue=" + listValue + ",\n setValue=" + setValue + ",\n arrayValue="
				+ Arrays.toString(arrayValue) + ",\n mapValue=" + mapValue + ",\n propValue=" + propValue + "]";
	}
	
	
}
