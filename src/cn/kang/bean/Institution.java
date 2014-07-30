package cn.kang.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Institution  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4442619590417158717L;

	private int id;
	
	
	private String name;
	
	/**
	 * ageGroup 年龄段
	 * 0:1~5
	 * 1:6~10
	 * 2:10~15
	 * 
	 */
	private int ageGroup;
	
	/**
	 * area 区域
	 * 0：南山区
	 * 1：福田区
	 * 2：罗湖区
	 */
	private int area;
	
	/**
	 * feature 特色
	 * 0:所有
	 * 1：启蒙类
	 * 2：英语
	 * 
	 */
	private int feature;
	
	/**
	 * 简介
	 */
	private String description;
	
	/**
	 * logo路径
	 */
	private String imgUrl;
	
	/**
	 * 机构评价平均分
	 */
	private int average;
	
	/**
	 * 最后修改时间
	 */
	private String updateTime;

	
	
	@Id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAgeGroup() {
		return ageGroup;
	}

	public void setAgeGroup(int ageGroup) {
		this.ageGroup = ageGroup;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public int getFeature() {
		return feature;
	}

	public void setFeature(int feature) {
		this.feature = feature;
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

	public int getAverage() {
		return average;
	}

	public void setAverage(int average) {
		this.average = average;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
