package cn.kang.bean;

import java.io.Serializable;

import javax.persistence.Id;
 
public class Activity  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8211297738455318238L;
	
	private int id;
	private String title;
	private String description;
	private String imgUrl;
	@Id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	

}
