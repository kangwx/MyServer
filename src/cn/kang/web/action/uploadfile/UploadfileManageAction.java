package cn.kang.web.action.uploadfile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.springframework.stereotype.Controller;

import cn.kang.bean.uploadfile.UploadFile;
import cn.kang.service.uploadfile.UploadFileService;
import cn.kang.utils.SiteUrl;
import cn.kang.web.formbean.uploadfile.UploadfileForm;
 


@Controller("/control/uploadfile/manage")
public class UploadfileManageAction extends DispatchAction {
	@Resource(name="uploadFileServiceBean")
	private UploadFileService uploadFileService;
	
	/**
	 * ɾ��
	 */
	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {		
		UploadfileForm formbean = (UploadfileForm) form;
		List<String> files = uploadFileService.getFilepath(formbean.getFileids());
		if(files!=null){
			for(String file : files){
				String realpath = request.getSession().getServletContext().getRealPath(file);
				File deletefile = new File(realpath);
				if(deletefile.exists()) deletefile.delete();
			}
			uploadFileService.delete((Serializable[])formbean.getFileids());
		}
		request.setAttribute("message", "�ļ�ɾ��ɹ�");
		request.setAttribute("urladdress", SiteUrl.readUrl("control.uploadfile.list"));
		return mapping.findForward("message");
	}
	/**
	 * �ϴ�����
	 */
	public ActionForward uploadUI(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {		
		return mapping.findForward("upload");
	}
	
	/**
	 * �����ϴ��ļ�
	 */
	public ActionForward upload(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		UploadfileForm formbean = (UploadfileForm) form;
		if(formbean.getUploadfile()!=null && formbean.getUploadfile().getFileSize()>0){
			if(!UploadfileForm.validateFileType(formbean.getUploadfile())){
				request.setAttribute("message", "�ļ���ʽ����ȷ,ֻ�����ϴ�ͼƬ/flash����/word�ļ�/exe�ļ�/pdf�ļ�/TxT�ļ�/xls�ļ�/ppt�ļ�");
				return mapping.findForward("error");
			}
			String ext = UploadfileForm.getExt(formbean.getUploadfile());
			if(("gif".equals(ext) || "jpg".equals(ext) || "bmp".equals(ext) || "png".equals(ext))
					&& formbean.getUploadfile().getFileSize()>204800){
				request.setAttribute("message", "ͼƬ���ܴ���200K");
				return mapping.findForward("error");
			}
			SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd/HH");
			String pathdir = "/images/uploadfile/"+ dateformat.format(new Date());//�����ļ������Ŀ¼
			//�õ�ͼƬ����Ŀ¼����ʵ·��
			String realpathdir = request.getSession().getServletContext().getRealPath(pathdir);
			File savedir = new File(realpathdir);
			if(!savedir.exists()) savedir.mkdirs();//���Ŀ¼�����ھʹ���			
			String filename = UUID.randomUUID().toString()+ "."+ext;//�����ļ����
			FileOutputStream fileoutstream = new FileOutputStream(new File(realpathdir, filename));
			fileoutstream.write(formbean.getUploadfile().getFileData());
			fileoutstream.close();
			String path = pathdir+"/"+filename;
			UploadFile uploadfile = new UploadFile(path);
			uploadFileService.save(uploadfile);
			request.setAttribute("imagepath", uploadfile.getFilepath());			
			return mapping.findForward("uploadfinish");
		}else{
			request.setAttribute("error", "���ϴ��ļ�");
		}
		return mapping.findForward("message");
	}
}
