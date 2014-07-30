package junit.test;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
 

public class SocketHttpRequester {
	/**
	 * ֱ��ͨ��HTTPЭ���ύ��ݵ�������,ʵ��������?�ύ����:
	 *   <FORM METHOD=POST ACTION="http://192.168.0.200:8080/ssi/fileload/test.do" enctype="multipart/form-data">
			<INPUT TYPE="text" NAME="name">
			<INPUT TYPE="text" NAME="id">
			<input type="file" name="imagefile"/>
		    <input type="file" name="zip"/>
		 </FORM>
	 * @param path �ϴ�·��(ע������ʹ��localhost��127.0.0.1�����·�����ԣ���Ϊ���ָ���ֻ�ģ���������ʹ��http://www.itcast.cn��http://192.168.1.10:8080�����·������)
	 * @param params ������� keyΪ������,valueΪ����ֵ
	 * @param file �ϴ��ļ�
	 */
	public static boolean post(String path, Map<String, String> params, FormFile[] files) throws Exception{     
        final String BOUNDARY = "---------------------------7da2137580612"; //��ݷָ���
        final String endline = "--" + BOUNDARY + "--\r\n";//��ݽ����־
        
        int fileDataLength = 0;
        for(FormFile uploadFile : files){//�õ��ļ�������ݵ��ܳ���
        	StringBuilder fileExplain = new StringBuilder();
 	        fileExplain.append("--");
 	        fileExplain.append(BOUNDARY);
 	        fileExplain.append("\r\n");
 	        fileExplain.append("Content-Disposition: form-data;name=\""+ uploadFile.getParameterName()+"\";filename=\""+ uploadFile.getFilname() + "\"\r\n");
 	        fileExplain.append("Content-Type: "+ uploadFile.getContentType()+"\r\n\r\n");
 	        fileDataLength += fileExplain.length();
        	if(uploadFile.getInStream()!=null){
        		fileDataLength += uploadFile.getFile().length();
	 	    }else{
	 	    	fileDataLength += uploadFile.getData().length;
	 	    }
        	fileDataLength += "\r\n".length();
        }
        StringBuilder textEntity = new StringBuilder();
        for (Map.Entry<String, String> entry : params.entrySet()) {//�����ı����Ͳ����ʵ�����
            textEntity.append("--");
            textEntity.append(BOUNDARY);
            textEntity.append("\r\n");
            textEntity.append("Content-Disposition: form-data; name=\""+ entry.getKey() + "\"\r\n\r\n");
            textEntity.append(entry.getValue());
            textEntity.append("\r\n");
        }
        //���㴫���������ʵ������ܳ���
        int dataLength = textEntity.toString().getBytes().length + fileDataLength +  endline.getBytes().length;
        
        URL url = new URL(path);
        int port = url.getPort()==-1 ? 80 : url.getPort();
        Socket socket = new Socket(InetAddress.getByName(url.getHost()), port);	       
        OutputStream outStream = socket.getOutputStream();
        //�������HTTP����ͷ�ķ���
        String requestmethod = "POST "+ url.getPath()+" HTTP/1.1\r\n";
        outStream.write(requestmethod.getBytes());
        String accept = "Accept: image/gif, image/jpeg, image/pjpeg, image/pjpeg, application/x-shockwave-flash, application/xaml+xml, application/vnd.ms-xpsdocument, application/x-ms-xbap, application/x-ms-application, application/vnd.ms-excel, application/vnd.ms-powerpoint, application/msword, */*\r\n";
        outStream.write(accept.getBytes());
        String language = "Accept-Language: zh-CN\r\n";
        outStream.write(language.getBytes());
        String contenttype = "Content-Type: multipart/form-data; boundary="+ BOUNDARY+ "\r\n";
        outStream.write(contenttype.getBytes());
        String contentlength = "Content-Length: "+ dataLength + "\r\n";
        outStream.write(contentlength.getBytes());
        String alive = "Connection: Keep-Alive\r\n";
        outStream.write(alive.getBytes());
        String host = "Host: "+ url.getHost() +":"+ port +"\r\n";
        outStream.write(host.getBytes());
        //д��HTTP����ͷ����HTTPЭ����дһ��س�����
        outStream.write("\r\n".getBytes());
        //�������ı����͵�ʵ����ݷ��ͳ�4
        outStream.write(textEntity.toString().getBytes());	       
        //�������ļ����͵�ʵ����ݷ��ͳ�4
        for(FormFile uploadFile : files){
        	StringBuilder fileEntity = new StringBuilder();
 	        fileEntity.append("--");
 	        fileEntity.append(BOUNDARY);
 	        fileEntity.append("\r\n");
 	        fileEntity.append("Content-Disposition: form-data;name=\""+ uploadFile.getParameterName()+"\";filename=\""+ uploadFile.getFilname() + "\"\r\n");
 	        fileEntity.append("Content-Type: "+ uploadFile.getContentType()+"\r\n\r\n");
 	        outStream.write(fileEntity.toString().getBytes());
 	        if(uploadFile.getInStream()!=null){
 	        	byte[] buffer = new byte[1024];
 	        	int len = 0;
 	        	while((len = uploadFile.getInStream().read(buffer, 0, 1024))!=-1){
 	        		outStream.write(buffer, 0, len);
 	        	}
 	        	uploadFile.getInStream().close();
 	        }else{
 	        	outStream.write(uploadFile.getData(), 0, uploadFile.getData().length);
 	        }
 	        outStream.write("\r\n".getBytes());
        }
        //���淢����ݽ����־����ʾ����Ѿ�����
        outStream.write(endline.getBytes());
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        if(reader.readLine().indexOf("200")==-1){//��ȡweb������ص���ݣ��ж��������Ƿ�Ϊ200�������200���������ʧ��
        	return false;
        }
        outStream.flush();
        outStream.close();
        reader.close();
        socket.close();
        return true;
	}
	
	/**
	 * �ύ��ݵ�������
	 * @param path �ϴ�·��(ע������ʹ��localhost��127.0.0.1�����·�����ԣ���Ϊ���ָ���ֻ�ģ���������ʹ��http://www.itcast.cn��http://192.168.1.10:8080�����·������)
	 * @param params ������� keyΪ������,valueΪ����ֵ
	 * @param file �ϴ��ļ�
	 */
	public static boolean post(String path, Map<String, String> params, FormFile file) throws Exception{
	   return post(path, params, new FormFile[]{file});
	}
	 

	/**
	 * ��������
	 * @param path ����·��
	 * @param params ������� keyΪ������� valueΪ����ֵ
	 * @param encode �������ı���
	 */
	public static byte[] post(String path, Map<String, String> params, String encode) throws Exception{
		//String params = "method=save&name="+ URLEncoder.encode("�ϱ�", "UTF-8")+ "&age=28&";//��Ҫ���͵Ĳ���
		StringBuilder parambuilder = new StringBuilder("");
		if(params!=null && !params.isEmpty()){
			for(Map.Entry<String, String> entry : params.entrySet()){
				parambuilder.append(entry.getKey()).append("=")
					.append(URLEncoder.encode(entry.getValue(), encode)).append("&");
			}
			parambuilder.deleteCharAt(parambuilder.length()-1);
		}
		byte[] data = parambuilder.toString().getBytes();
		URL url = new URL(path);
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		conn.setDoOutput(true);//������ⷢ���������
		conn.setUseCaches(false);//�����л���
		conn.setConnectTimeout(5 * 1000);
		conn.setRequestMethod("POST");
		//��������http����ͷ
		conn.setRequestProperty("Accept", "image/gif, image/jpeg, image/pjpeg, image/pjpeg, application/x-shockwave-flash, application/xaml+xml, application/vnd.ms-xpsdocument, application/x-ms-xbap, application/x-ms-application, application/vnd.ms-excel, application/vnd.ms-powerpoint, application/msword, */*");
		conn.setRequestProperty("Accept-Language", "zh-CN");
		conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 5.2; Trident/4.0; .NET CLR 1.1.4322; .NET CLR 2.0.50727; .NET CLR 3.0.04506.30; .NET CLR 3.0.4506.2152; .NET CLR 3.5.30729)");
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		conn.setRequestProperty("Content-Length", String.valueOf(data.length));
		conn.setRequestProperty("Connection", "Keep-Alive");
		
		//���Ͳ���
		DataOutputStream outStream = new DataOutputStream(conn.getOutputStream());
		outStream.write(data);//�Ѳ����ͳ�ȥ
		outStream.flush();
		outStream.close();
		if(conn.getResponseCode()==200){
			return readStream(conn.getInputStream());
		}
		return null;
	}
	
	/**
	 * ��ȡ��
	 * @param inStream
	 * @return �ֽ�����
	 * @throws Exception
	 */
	public static byte[] readStream(InputStream inStream) throws Exception{
		ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len = -1;
		while( (len=inStream.read(buffer)) != -1){
			outSteam.write(buffer, 0, len);
		}
		outSteam.close();
		inStream.close();
		return outSteam.toByteArray();
	}
}
