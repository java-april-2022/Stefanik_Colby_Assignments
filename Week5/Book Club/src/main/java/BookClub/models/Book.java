package BookClub.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="books")
public class Book {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotBlank(message="You need to state the title before you can recomend")
    private String title;
	
	@NotBlank(message="You need to list an author before you can recomend")
    private String author;
	
	@NotBlank(message="You need to list some thoughts before you can recomend")
    private String thoughts;
    
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="users_id")
    private User user;
    
    public Book() {}
    
    public Book(String title, String author, String thoughts, Date createdAt, Date updatedAt, User user) {
    	this.title = title;
    	this.author = author;
    	this.thoughts = thoughts;
    	this.createdAt = createdAt;
    	this.updatedAt = updatedAt;
    	this.user = user;
    }
    
    //Setters
    public void setID(Long id) {
    	this.id = id;
    }
    public void setTitle(String title) {
    	this.title = title;
    }
    public void setAuthor(String author) {
    	this.author = author;
    }
    public void setThouhts(String thoughts) {
    	this.thoughts = thoughts;
    }
    public void setCreatedAt(Date createdAt) {
    	this.createdAt = createdAt;
    }
    public void setUpdatedAt(Date updatedAt) {
    	this.updatedAt = updatedAt;
    }
    public void setUser(User user) {
    	this.user = user;
    }
    
    //Getters
    public Long getID() {
    	return id;
    }
    public String getTitle() {
    	return title;
    }
    public String getAuthor() {
    	return author;
    }
    public String getThoughts() {
    	return thoughts;
    }
    public Date getCreatedAt() {
    	return createdAt;
    }
    public Date getUpdatedAt() {
    	return updatedAt;
    }
    public User getUser() {
    	return user;
    }
}
