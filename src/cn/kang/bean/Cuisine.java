package cn.kang.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Cuisine implements Serializable{
	
	 
	private static final long serialVersionUID = 3034814116182816385L;
	
	private int id;
	private int channelId=0;
	private int categoryId =0;
	private String title="";
	private String author="";
	private String fromPlace="";
	private String zhaiyao="";
	private String linkUrl="";
	private String imgUrl="";
	private String seoTitle="";
	private String seoKeywords="";
	private String seoDescription="";
	private String content="";
	private int sortId=99;
	private int click=0;
	private int isMsg=0;
	private int isTop=0;
	private int isRed=0;
	private int isHot=0;
	private int isSlide=0;
	private int isLock=0;
	private int userId=0;
	private String addTime;
	private int diggGood=0;
	private int diggBad=0;
	
	
	
	public Cuisine() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Cuisine(int id, int channelId, int categoryId, String title,
			String author, String fromPlace, String zhaiyao, String linkUrl,
			String imgUrl, String seoTitle, String seoKeywords,
			String seoDescription, String content, int sortId, int click,
			int isMsg, int isTop, int isRed, int isHot, int isSlide,
			int isLock, int userId, String addTime, int diggGood, int diggBad) {
		super();
		this.id = id;
		this.channelId = channelId;
		this.categoryId = categoryId;
		this.title = title;
		this.author = author;
		this.fromPlace = fromPlace;
		this.zhaiyao = zhaiyao;
		this.linkUrl = linkUrl;
		this.imgUrl = imgUrl;
		this.seoTitle = seoTitle;
		this.seoKeywords = seoKeywords;
		this.seoDescription = seoDescription;
		this.content = content;
		this.sortId = sortId;
		this.click = click;
		this.isMsg = isMsg;
		this.isTop = isTop;
		this.isRed = isRed;
		this.isHot = isHot;
		this.isSlide = isSlide;
		this.isLock = isLock;
		this.userId = userId;
		this.addTime = addTime;
		this.diggGood = diggGood;
		this.diggBad = diggBad;
	}

	@Id  
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getChannelId() {
		return channelId;
	}
	public void setChannelId(int channelId) {
		this.channelId = channelId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getFromPlace() {
		return fromPlace;
	}
	public void setFromPlace(String from) {
		this.fromPlace = fromPlace;
	}
	public String getZhaiyao() {
		return zhaiyao;
	}
	public void setZhaiyao(String zhaiyao) {
		this.zhaiyao = zhaiyao;
	}
	public String getLinkUrl() {
		return linkUrl;
	}
	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getSeoTitle() {
		return seoTitle;
	}
	public void setSeoTitle(String seoTitle) {
		this.seoTitle = seoTitle;
	}
	public String getSeoKeywords() {
		return seoKeywords;
	}
	public void setSeoKeywords(String seoKeywords) {
		this.seoKeywords = seoKeywords;
	}
	public String getSeoDescription() {
		return seoDescription;
	}
	public void setSeoDescription(String seoDescription) {
		this.seoDescription = seoDescription;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getSortId() {
		return sortId;
	}
	public void setSortId(int sortId) {
		this.sortId = sortId;
	}
	public int getClick() {
		return click;
	}
	public void setClick(int click) {
		this.click = click;
	}
	public int getIsMsg() {
		return isMsg;
	}
	public void setIsMsg(int isMsg) {
		this.isMsg = isMsg;
	}
	public int getIsTop() {
		return isTop;
	}
	public void setIsTop(int isTop) {
		this.isTop = isTop;
	}
	public int getIsRed() {
		return isRed;
	}
	public void setIsRed(int isRed) {
		this.isRed = isRed;
	}
	public int getIsHot() {
		return isHot;
	}
	public void setIsHot(int isHot) {
		this.isHot = isHot;
	}
	public int getIsSlide() {
		return isSlide;
	}
	public void setIsSlide(int isSlide) {
		this.isSlide = isSlide;
	}
	public int getIsLock() {
		return isLock;
	}
	public void setIsLock(int isLock) {
		this.isLock = isLock;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getAddTime() {
		return addTime;
	}
	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}
	public int getDiggGood() {
		return diggGood;
	}
	public void setDiggGood(int diggGood) {
		this.diggGood = diggGood;
	}
	public int getDiggBad() {
		return diggBad;
	}
	public void setDiggBad(int diggBad) {
		this.diggBad = diggBad;
	}
	
	
	
}
