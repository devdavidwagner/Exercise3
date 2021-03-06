//PROG3060-Exercise 3
// DAVID WAGNER - 7256506
//CREATED 3/22/2018
//FINISHED 3/23/2018

//HOUSEHOLD Size CLASS

package prog3060.dwagner;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="HOUSEHOLDSIZE", schema="APP")
public class HouseholdSize {

	@Id
	@Column(name="ID", nullable = false)
	private int id;
	
	@Column(name="DESCRIPTION", nullable = false)
	private String description;
	
	@OneToMany(mappedBy = "householdSize")
	private Set<Household> households;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Household> getHouseholds() {
		return households;
	}

	public void setHouseholds(Set<Household> households) {
		this.households = households;
	}
}
