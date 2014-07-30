package junit.test;

import java.util.HashMap;
import java.util.Map;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Map<String,String> userMap = new HashMap<String,String>();
         userMap.put("username", "adfsfsdfsa");
         userMap.put("password", "asdfsdfs"); 
         userMap.put("page", "1");
         userMap.put("method", "showList");
         try {
				//SocketHttpRequester.post("http://192.168.1.103/user/reg.do", userMap, "utf-8");
        	 	byte[] bs = SocketHttpRequester.post("http://192.168.1.106/cuisine/show.do", userMap, "utf-8");
        	 	String str = new String(bs);
        	 	System.out.println(str);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
