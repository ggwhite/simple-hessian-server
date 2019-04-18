package lab.ggw.shs.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class SimpleService implements ISimpleService {

	public String str() {
		System.out.println("str");
		String str = "Hello";
		return str;
	}

	public String strI(String msg) {
		System.out.println("strI");
		return "Hello, " + msg;
	}

	public String strI2(String target, String msg) {
		System.out.println("strI2");
		return "Hello[" + target + "], " + msg;
	}
	
	public boolean bool() {
		System.out.println("bool");
		return true;
	}
	
	public boolean boolI(boolean t) {
		System.out.println("boolI " + t);
		return t;
	}

	public int integer() {
		System.out.println("integer");
		return 123;
	}

	public int integerI(int i) {
		System.out.println("integerI " + i);
		return i;
	}

	public long longX() {
		System.out.println("longX");
		return 222l;
	}

	public long longI(long l) {
		System.out.println("longI " + l);
		return l;
	}

	public double doubleX() {
		System.out.println("doubleX");
		return Double.MIN_VALUE;
	}

	public double doubleI(double d) {
		System.out.println("doubleI " + d);
		return d;
	}
	
	public User obj() {
		System.out.println("obj");
		User u = new User();
		u.setName("ggwhite");
		u.setEmail("ggw.chang@gmail.com");
		u.setFather(null);
		return u;
	}
	
	public String objI(User u) {
		System.out.println("obj " + u);
		return u.name;
	}

	public Map map() {
		System.out.println("map");
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("KeyA", "ValueA");
		map.put("KeyB", "ValueB");
		map.put(123, "ValueC");
		return map;
	}
	
	public int mapI(Map<Object, Object> map) {
		System.out.println("map " + map);
		return map.size();
	}
	
	public Object[] array() {
		System.out.println("array");
		return new Object[] {"ValueA", 2, "ValueC", 4.00};
	}

	public Object[] arrayI(Object[] i) {
		System.out.println("arrayI");
		for (Object obj : i) {
			System.out.println(obj);
		}
		return i;
	}
	
	public String[] strarrayI(String[] i) {
		System.out.println("strarrayI");
		for (String obj : i) {
			System.out.println(obj);
		}
		return i;
	}
	
	public int[] intarrayI(int[] i) {
		System.out.println("intarrayI");
		for (int obj : i) {
			System.out.println(obj);
		}
		return i;
	}
}
