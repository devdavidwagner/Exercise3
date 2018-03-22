//PROG3060-Exercise 3
// DAVID WAGNER - 7256506
//CREATED 3/22/2018
//FINISHED 3/23/2018

//HOUSEHOLD CLASS

package prog3060.dwagner;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Household", schema="APP")
public class Household {
	
	public Household() {};
	
	public Household(int numberReported, GeographicArea geographicArea, HouseholdType householdType,
			HouseholdSize householdSize, HouseholdsByAgeRange householdsByAgeRange, HouseholdEarners householdEarners,
			TotalIncome totalIncome, CensusYear censusYear) {
		
		this.numberReported = numberReported;
		this.geographicArea = geographicArea;
		this.householdType = householdType;
		this.householdSize = householdSize;
		this.householdsByAgeRange = householdsByAgeRange;
		this.householdEarners = householdEarners;
		this.totalIncome = totalIncome;
		this.censusYear = censusYear;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", nullable = false)
	private int householdID;
	
	@Column(name="NUMBERREPORTED", nullable = false)
	private int numberReported;
	
	@ManyToOne
	@Column(name="GEOGRAPHICAREA", nullable = false)
	private GeographicArea geographicArea;
	
	@ManyToOne
	@Column(name="HOUSEHOLDTYPE", nullable = false)
	private HouseholdType householdType;
	
	@ManyToOne
	@Column(name="HOUSEHOLDSIZE", nullable = false)
	private HouseholdSize householdSize;
	
	@ManyToOne
	@Column(name="HOUSEHOLDSBYAGERANGE", nullable = false)
	private HouseholdsByAgeRange householdsByAgeRange;
	
	@ManyToOne
	@Column(name="HOUSEHOLDEARNERS", nullable = false)
	private HouseholdEarners householdEarners;
	
	@ManyToOne
	@Column(name="TOTALINCOME", nullable = false)
	private TotalIncome totalIncome;
	
	@ManyToOne
	@Column(name="CENSUSYEAR", nullable = false)
	private CensusYear censusYear;
	
	
	public int getHouseholdID() {
		return householdID;
	}
	public void setHouseholdID(int householdID) {
		this.householdID = householdID;
	}
	public int getNumberReported() {
		return numberReported;
	}
	public void setNumberReported(int numberReported) {
		this.numberReported = numberReported;
	}
	public GeographicArea getGeographicArea() {
		return geographicArea;
	}
	public void setGreographicArea(GeographicArea geographicArea) {
		this.geographicArea = geographicArea;
	}
	public HouseholdType getHouseholdType() {
		return householdType;
	}
	public void setHouseholdType(HouseholdType householdType) {
		this.householdType = householdType;
	}
	public HouseholdSize getHouseholdSize() {
		return householdSize;
	}
	public void setHouseholdSize(HouseholdSize householdSize) {
		this.householdSize = householdSize;
	}
	public HouseholdsByAgeRange getHouseholdsByAgeRange() {
		return householdsByAgeRange;
	}
	public void setHouseholdsByAgeRange(HouseholdsByAgeRange householdsByAgeRange) {
		this.householdsByAgeRange = householdsByAgeRange;
	}
	public HouseholdEarners getHouseholdEarners() {
		return householdEarners;
	}
	public void setHouseholdEarners(HouseholdEarners householdEarners) {
		this.householdEarners = householdEarners;
	}
	public TotalIncome getTotalIncome() {
		return totalIncome;
	}
	public void setTotalIncome(TotalIncome totalIncome) {
		this.totalIncome = totalIncome;
	}
	public CensusYear getCensusYear() {
		return censusYear;
	}
	public void setCensusYear(CensusYear censusYear) {
		this.censusYear = censusYear;
	}
	

}
