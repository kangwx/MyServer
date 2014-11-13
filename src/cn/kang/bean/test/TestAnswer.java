package cn.kang.bean.test;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class TestAnswer {

	private Integer id;
	
	private String content;
	
	private TestBean test;
	
	@Id @GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	@Column(length=255,nullable=false)
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name="testid")
	public TestBean getTest() {
		return test;
	}

	public void setTest(TestBean test) {
		this.test = test;
	}
	
	
	
}
