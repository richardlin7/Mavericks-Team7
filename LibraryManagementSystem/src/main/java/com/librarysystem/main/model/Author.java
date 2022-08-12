fullpackage com.librarysystem.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String fullName;
	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Author(Long id, String fullName) {
		super();
		this.id = id;
		this.fullName = fullName;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	@Override
	public String toString() {
		return "Author [id=" + id + ", fullName=" + fullName + "]";
	}
	
	
	
	

}
