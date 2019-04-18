package lab.ggw.shs.service;

import java.util.Map;

public interface ISimpleService {

	public String str();
	
	public String strI(String msg);
	
	public String strI2(String target, String msg);
	
	public boolean bool();
	
	public boolean boolI(boolean b);
	
	public int integer();
	
	public int integerI(int i);
	
	public long longX();
	
	public long longI(long l);
	
	public double doubleX();
	
	public double doubleI(double d);
	
	public User obj();
	
	public String objI(User u);
	
	public Map map();
	
	public int mapI(Map<Object, Object> map);
	
	public Object[] array();
	
	public Object[] arrayI(Object[] i);
	
	public String[] strarrayI(String[] i);
	
	public int[] intarrayI(int[] i);
}
