package model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @authors Kenneth Nimmo, Taylor Layton, Jennifer Jarrell
 * CIS175 
 * Oct 6, 2023
 */

@Entity
public class Movie {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String title;
    private String genre;
    private LocalDate releaseDate; 

    @ManyToOne
    @JoinColumn(name = "movieNight_id")
    private MovieNight movieNight;

    public Movie() {
        super();
    }

    public Movie(String title, String genre, LocalDate releaseDate) {
        this.title = title;
        this.genre = genre;
        this.releaseDate = releaseDate;
    }

    public Movie(String title, String genre, LocalDate releaseDate, MovieNight movieNight) {
        this.title = title;
        this.genre = genre;
        this.releaseDate = releaseDate;
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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the genre
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * @param genre the genre to set
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}

	/**
	 * @return the releaseDate
	 */
	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	/**
	 * @param releaseDate the releaseDate to set
	 */
	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}
	    /**
	     * @return the movieNight
	     */
	    public MovieNight getMovieNight() {
	        return movieNight;
	    }

	    /**
	     * @param movieNight the movieNight to set
	     */
	    public void setMovieNight(MovieNight movieNight) {
	        this.movieNight = movieNight;
	    }
	}