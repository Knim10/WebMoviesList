package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author Kenneth Nimmo - Knimmo
 * CIS175 - Fall 2021
 * Oct 14, 2023
 */
@Entity
public class ListDetails {
	@Id
	@GeneratedValue
	private int id;
	private String listName;
	@ManyToOne (cascade=CascadeType.PERSIST)
	private MovieNight movieNight;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<Movie> listOfItems;

	/**
	 * 
	 */
	public ListDetails() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param id
	 * @param listName
	 * @param movieNight
	 * @param listOfItems
	 */
	public ListDetails(int id, String listName, MovieNight movieNight, List<Movie> listOfItems) {
		super();
		this.id = id;
		this.listName = listName;
		this.movieNight = movieNight;
		this.listOfItems = listOfItems;
	}
	
	/**
	 * @param listName
	 * @param movieNight
	 * @param listOfItems
	 */
	public ListDetails(String listName, MovieNight movieNight, List<Movie> listOfItems) {
		super();
		this.listName = listName;
		this.movieNight = movieNight;
		this.listOfItems = listOfItems;
	}
	
	/**
	 * @param listName
	 * @param movieNight
	 */
	public ListDetails(String listName, MovieNight movieNight) {
		super();
		this.listName = listName;
		this.movieNight = movieNight;
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the listName
	 */
	public String getListName() {
		return listName;
	}

	/**
	 * @param listName the listName to set
	 */
	public void setListName(String listName) {
		this.listName = listName;
	}
	
	/**
	 * @return the movieNight
	 */
	public MovieNight getMovieNight() {
		return movieNight;
	}

	/**
	 * @param the movieNight to set
	 */
	public void setMovieNight(MovieNight movieNight) {
		this.movieNight = movieNight;
	}

	/**
	 * @return the listOfItems
	 */
	public List<Movie> getListOfItems() {
		return listOfItems;
	}

	/**
	 * @param listOfItems the listOfItems to set
	 */
	public void setListOfItems(List<Movie> listOfItems) {
		this.listOfItems = listOfItems;
	}

	@Override
	public String toString() {
		return "ListDetails [id=" + id + ", listName=" + listName + ", Movie Night=" + movieNight
				+ ", listOfItems=" + listOfItems + "]";
	}
	
}
