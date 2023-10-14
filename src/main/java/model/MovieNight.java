package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Entity
public class MovieNight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String hostName;
    private LocalDate date;

    @OneToMany(mappedBy = "movieNight", orphanRemoval = true, cascade = javax.persistence.CascadeType.PERSIST)
    private List<Movie> movies;

    public MovieNight() {
        super();
    }

    public MovieNight(String hostName, LocalDate date, List<Movie> movies) {
        super();
        this.hostName = hostName;
        this.date = date;
        this.movies = movies;
    }

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	public MovieNight(String hostName) {
	    this.hostName = hostName;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the hostName
	 */
	public String getHostName() {
		return hostName;
	}

	/**
	 * @param hostName the hostName to set
	 */
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	/**
	 * @return the date
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}

	/**
	 * @return the movies
	 */
	public List<Movie> getMovies() {
		return movies;
	}

	/**
	 * @param movies the movies to set
	 */
	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
}