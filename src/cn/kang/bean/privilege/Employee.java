package cn.kang.bean.privilege;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import cn.kang.bean.Gender;
 
/**
 * Ա��ʵ��
 *
 */
@Entity
public class Employee {
	/* ���,20λ*/
	private String username;
	/* 20λ, ����Ϊnull */
	private String password;
	/* ���� 10λ ����Ϊnull */
	private String realname;
	/* �Ա� 5λ ����Ϊnull */
	private Gender gender;
	/* ѧ�� 10λ */
	private String degree;
	/* ���֤ �����ṩ */
	private IDCard idCard ;//һ��һ,Ա����Ϊ��ϵά����
	/* ��ҵԺУ 20λ */
	private String school;
	/* jϵ�绰 20 */
	private String phone;
	/* �����ʼ� 40 */
	private String email;
	/* ��Ƭ 41 */ 
	private String imageName; //ֻ����ļ����,�����ļ���Ʋ���uuid���,ͼƬ������/images/employee/[username]/Ŀ¼
	/* Ա����ְ״̬ trueΪ��ְ,falseΪ��ְ */
	private Boolean visible = true;
	/* Ա�����ڲ��� */
	private Department department;//˫��һ�Զ�,���һ
	/* Ա�����е�Ȩ�� */
	private Set<PrivilegeGroup> groups = new HashSet<PrivilegeGroup>();
	
	@ManyToMany(cascade=CascadeType.REFRESH, fetch=FetchType.EAGER)
	@JoinTable(name="eg",inverseJoinColumns=@JoinColumn(name="group_id"),
			joinColumns=@JoinColumn(name="username"))
	public Set<PrivilegeGroup> getGroups() {
		return groups;
	}

	public void setGroups(Set<PrivilegeGroup> groups) {
		this.groups = groups;
	}

	@Transient
	public String getImagePath(){
		if(username!=null && imageName!=null) return "/images/employee/"+ username +"/"+ imageName;
		return null;
	}
	
	@Id @Column(length=20)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Column(length=20, nullable=false)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(length=8,nullable=false)
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	@Enumerated(EnumType.STRING) @Column(length=5,nullable=false)
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	@Column(length=10)
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	
	@OneToOne(cascade=CascadeType.ALL, optional=false)
	@JoinColumn(name="card_id")
	public IDCard getIdCard() {
		return idCard;
	}
	public void setIdCard(IDCard idCard) {
		this.idCard = idCard;
	}
	@Column(length=20)
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	@Column(length=18)
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Column(length=40)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(length=41)
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	@Column(nullable=false)
	public Boolean getVisible() {
		return visible;
	}
	public void setVisible(Boolean visible) {
		this.visible = visible;
	}
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name="department_id")
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Employee other = (Employee) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
}
