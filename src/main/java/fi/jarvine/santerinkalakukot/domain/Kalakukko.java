package fi.jarvine.santerinkalakukot.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Kalakukko {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private double weight;
	private String gender;
	private String color;
	@ManyToOne
	@JsonIgnore
	@JoinColumn (name="specieid")
	private Specie specie;
	private double latitude;
	private double longitude;
	private String linkki;
	
	
	
	public Kalakukko() {
		
	}
	public Kalakukko(String name, double weight, String gender, String color, Specie specie, double lat, double lon) {
		super();
		this.name = name;
		this.weight = weight;
		this.gender = gender;
		this.color = color;
		this.specie = specie;
		this.latitude = lat;
		this.longitude = lon;
		//this.linkki = "https://www.latlong.net/c/?lat="+this.latitude+"&long="+this.longitude;
		this.linkki = "google.fi";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Specie getSpecie() {
		return specie;
	}
	public void setSpecie(Specie specie) {
		this.specie = specie;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public String getLinkki() {
		return linkki;
	}
	public void setLinkki(String linkki) {
		this.linkki = linkki;
	}
	
	
}
