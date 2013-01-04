/**
 * 
 */
package foo.api;

import javax.persistence.*;

/**
 * @author jordanbaucke
 *
 */
@Entity
@Table(name = "apimethod")
public class ApiMethod {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(unique = true)
	private String title;
	
	public ApiMethod(String title){
		this.title = title;
	}
	
	public Long getId(){
		return id;
	}
	
	public String getTitle(){
		return title;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
}
