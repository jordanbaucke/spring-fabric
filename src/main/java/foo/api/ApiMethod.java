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
@NamedQuery(name = ApiMethod.FIND_ALL_METHODS, query = "select a from ApiMethod a")
public class ApiMethod {
	
	public static final String FIND_ALL_METHODS = "ApiMethod.findAllMethods";
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(unique = true)
	private String title;
	
	protected ApiMethod() {
		
	}
	
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
