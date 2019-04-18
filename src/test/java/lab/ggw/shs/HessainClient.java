package lab.ggw.shs;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import org.junit.Test;

import com.caucho.hessian.client.HessianProxyFactory;

import lab.ggw.shs.service.ISimpleService;
import lab.ggw.shs.service.User;

public class HessainClient {

	@Test
	public void testHessain() throws Exception {

		String url = "http://localhost:8080/simple";

		HessianProxyFactory factory = new HessianProxyFactory();
		factory.setDebug(true);
//		factory.setHessian2Request(true);

		ISimpleService service = (ISimpleService) factory.create(ISimpleService.class, url);

		System.out.println(service.str());
//		System.out.println(service.bool());
//		System.out.println(service.integerI(Integer.MIN_VALUE));
//		System.out.println(service.longI(Long.MIN_VALUE));
//		System.out.println(service.doubleI(Double.MAX_VALUE));
//		System.out.println(service.doubleI(Double.MIN_VALUE));

//		User u = new User();
//		u.setName("ggwhite");
//		u.setEmail("ggw.chang@gmail.com");
//		u.setFather(null);
//		System.out.println(service.objI(u));
//		System.out.println(service.obj());
		
//		System.out.println(service.map());
		
//		Map<Object, Object> map = new HashMap<Object, Object>();
//		map.put("KeyA", "ValueA");
//		map.put("KeyB", "ValueB");
//		map.put(123, "ValueC");
//		
//		System.out.println(service.mapI(map));
		
//		System.out.println(service.array());
//		System.out.println(service.arrayI(new Object[] {"ValueA", 2, "ValueC", 4.00}));
//		System.out.println(service.strarrayI(new String[] {"ValueA", "2", "ValueC", "4.00"}));
//		System.out.println(service.intarrayI(new int[] {1, 2, 3, 4}));
	}

	@Test
	public void testHttpURLConnection() throws Exception {
		String url = "http://localhost:8080/simple";

		URL u = new URL(url);

		System.out.println(u.getProtocol());
		System.out.println(u.getHost());
		System.out.println(u.getPort());
		System.out.println(u.getPath());

		URLConnection conn = u.openConnection();
		System.out.println(conn);

		HttpURLConnection _conn = (HttpURLConnection) conn;
		_conn.setRequestMethod("POST");
		_conn.setDoOutput(true);
		
		_conn.setRequestProperty("Content-Type", "x-application/hessian");
	    _conn.setRequestProperty("Accept-Encoding", "deflate");
	    
	    
	    OutputStream os = null;
	    os = conn.getOutputStream();
	    
	    os.write('H');
	    os.write(2);
	    os.write(0);
	    
	    os.write('C');
//	    os.write(1);
//	    os.write(0);

	    String method = "numberInput";
//	    os.write('m');
	    int len = method.length();
	    os.write(len >> 8);
	    os.write(len);
	    printString(os, method, 0, len);
	    
//	    os.write('S');
//	    os.write("qq".length() >> 8);
//	    os.write("qq".length());
//	    printString(os, "qq", 0, "qq".length());
	    
	    
	    os.write('I');
	    os.write(321 >> 24);
	    os.write(321 >> 16);
	    os.write(321 >> 8);
	    os.write(321);
	    
	    os.write('z');
	    
	    System.out.println(os.toString());
	    
	    byte[] q = ((ByteArrayOutputStream) os).toByteArray();
	    for (int i = 0; i < q.length; i++) {
	    	System.out.print(q[i]);
	    	System.out.print(" - ");
	    }
	    System.out.println();
	    
	    
	    os.flush();
	    
		System.out.println(_conn.getResponseCode());
		

		InputStream is = null;

		StringBuffer sb = new StringBuffer();
		int ch;

		is = _conn.getInputStream();
		if (is != null) {
			while ((ch = is.read()) >= 0) {
				sb.append((char) ch);
				
				System.out.print(ch);
				System.out.print(" - ");
			}
			System.out.println();
			is.close();
		}
		System.out.println(sb.toString());

		is = _conn.getErrorStream();
		if (is != null) {
			while ((ch = is.read()) >= 0)
				sb.append((char) ch);
			
			is.close();
		}
		System.out.println(sb.toString());
		
	}

	public void printString(OutputStream os, String v, int offset, int length) throws IOException {
		for (int i = 0; i < length; i++) {
			char ch = v.charAt(i + offset);

			if (ch < 0x80)
				os.write(ch);
			else if (ch < 0x800) {
				os.write(0xc0 + ((ch >> 6) & 0x1f));
				os.write(0x80 + (ch & 0x3f));
			} else {
				os.write(0xe0 + ((ch >> 12) & 0xf));
				os.write(0x80 + ((ch >> 6) & 0x3f));
				os.write(0x80 + (ch & 0x3f));
			}
		}
	}
}
