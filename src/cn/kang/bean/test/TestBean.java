package cn.kang.bean.test;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TestBean {
	
	private Integer testid;
	
	private String title;

	private String content;
	
	private Set<TestAnswer> answers = new HashSet<TestAnswer>();

 

	@Id @GeneratedValue
	public Integer getTestid() {
		return testid;
	}

	public void setTestid(Integer testid) {
		this.testid = testid;
	}

	@Column(length=255)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(length=255)
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	@OneToMany(mappedBy="test") 
	public Set<TestAnswer> getAnswers() {
		return answers;
	}

	public void setAnswers(Set<TestAnswer> answers) {
		this.answers = answers;
	}
	
	
	
	
}
