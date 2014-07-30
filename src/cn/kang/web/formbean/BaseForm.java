package cn.kang.web.formbean;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

public class BaseForm extends ActionForm {
	private static Properties properties = new Properties();
	static{
		try {
			properties.load(BaseForm.class.getClassLoader().getResourceAsStream("arrowuploadfiletype.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/** ��ȡ��ǰҳ **/
	private int page;
	/** �����Ƿ���в��� **/
	private String query;

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}
	public int getPage() {
		return page<1? 1 : page;
	}

	public void setPage(int page) {
		this.page = page;
	}
	/**
	 * ��֤�ϴ��ļ������Ƿ�����ͼƬ��ʽ
	 * @return
	 */
	public static boolean validateImageFileType(FormFile formfile){
		if(formfile!=null && formfile.getFileSize()>0){
			List<String> arrowType = Arrays.asList("image/bmp","image/png","image/gif","image/jpg","image/jpeg","image/pjpeg");
			List<String> arrowExtension = Arrays.asList("gif","jpg","bmp","png");
			String ext = getExt(formfile);
			return arrowType.contains(formfile.getContentType().toLowerCase()) && arrowExtension.contains(ext);
		}
		return true;
	}
	
	public static String getExt(FormFile formfile){
		return formfile.getFileName().substring(formfile.getFileName().lastIndexOf('.')+1).toLowerCase();
	}
	/**
	 * ��֤�ϴ��ļ��Ƿ�����ͼƬ/flash����/word�ļ�/exe�ļ�/pdf�ļ�/TxT�ļ�/xls�ļ�/ppt�ļ�
	 * @param formfile
	 * @return
	 */
	public static boolean validateFileType(FormFile formfile){
		if(formfile!=null && formfile.getFileSize()>0){
			String ext = formfile.getFileName().substring(formfile.getFileName().lastIndexOf('.')+1).toLowerCase();
			List<String> arrowType = new ArrayList<String>();
			for(Object key : properties.keySet()){
				String value = (String)properties.get(key);
				String[] values = value.split(",");
				for(String v : values){
					arrowType.add(v.trim());
				}
			}
			return arrowType.contains(formfile.getContentType().toLowerCase()) && properties.keySet().contains(ext);
		}
		return true;
	}
	
	/**
	 * �����ļ�
	 * @param savedir ���Ŀ¼
	 * @param fileName �ļ����
	 * @param data ���������
	 * @return ������ļ�
	 * @throws Exception
	 */
	public static File saveFile(File savedir, String fileName, byte[] data) throws Exception{
		if(!savedir.exists()) savedir.mkdirs();//���Ŀ¼�����ھʹ���
		File file = new File(savedir, fileName);
		FileOutputStream fileoutstream = new FileOutputStream(file);
		fileoutstream.write(data);
		fileoutstream.close();
		return file;
	}
	/*
	public boolean validateFileType(String propertyName) throws Exception{
		PropertyDescriptor[] propertydesc = Introspector.getBeanInfo(this.getClass()).getPropertyDescriptors();
		boolean exsit = false;
		for(PropertyDescriptor property : propertydesc){
			if(property.getName().equals(propertyName)){
				exsit = true;
				Method method = property.getReadMethod();
				if(method!=null){
					FormFile formfile = (FormFile) method.invoke(this);
					if(formfile!=null && formfile.getFileSize()>0){
						List<String> arrowType = Arrays.asList("image/bmp","image/png","image/gif","image/jpeg","image/pjpeg");
						return arrowType.contains(formfile.getContentType().toLowerCase());
					}
				}else{
					new RuntimeException(propertyName+"���Ե�getter����������");
				}
			}
		}
		if(!exsit) new RuntimeException(propertyName+"���Բ�����");
		return true;
	}*/
}
