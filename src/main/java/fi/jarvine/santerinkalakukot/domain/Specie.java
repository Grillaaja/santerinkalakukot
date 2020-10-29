package fi.jarvine.santerinkalakukot.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Specie {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long specieid;
	private String name;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "specie")
	private List<Kalakukko> kalakukot;
	
	public Specie() {
		
	}
	
	public Specie(String name) {
		super();
		this.name = name;
	}

	public Long getSpecieid() {
		return specieid;
	}

	public void setSpecieid(Long specieid) {
		this.specieid = specieid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Kalakukko> getKalakukot() {
		return kalakukot;
	}

	public void setKalakukot(List<Kalakukko> kalakukot) {
		this.kalakukot = kalakukot;
	}
	
	
	
}
