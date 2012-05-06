package ro.kenjiru.yachin.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LISTINGS")
public class Listing implements Serializable {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "TITLE")
	private String title;
	
	@Column(name = "SUBMIT_DATE")
	private Date submitDate;
	
	@Column(name = "NO_ROOMS")
	private Integer noRooms;

	public Listing() {}

	public Long getId() {
		return id;
	}

	private void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(Date submitDate) {
		this.submitDate = submitDate;
	}

	public Integer getNoRooms() {
		return noRooms;
	}

	public void setNoRooms(Integer noRooms) {
		this.noRooms = noRooms;
	}
}
