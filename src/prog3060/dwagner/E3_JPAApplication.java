//E3 PROG3060- David Wagner
// 3/22/2018
//Main JPA application to print out queries

package prog3060.dwagner;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
public class E3_JPAApplication {
	
	static final String PERSISTENCE_UNIT_NAME = "E3_JPAApplication";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 EntityManagerFactory tempEntityManagerFactory = null;
	        EntityManager tempEntityManager = null;

	        try
	        {

	            tempEntityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	            tempEntityManager = tempEntityManagerFactory.createEntityManager();

	            tempEntityManager.getTransaction().begin();


	            //Insert new Geographic Area
	            GeographicArea newGA = new GeographicArea(499,2,"Frenchville", 24499);
	            tempEntityManager.persist(newGA);



	            // Create a new Household data point
	            //retrieve other household objects to fill data point
	            HouseholdType tempHouseholdType = (HouseholdType) tempEntityManager.find(HouseholdType.class,11);
	            HouseholdSize tempHouseholdSize = (HouseholdSize) tempEntityManager.find(HouseholdSize.class,3);
	            HouseholdsByAgeRange tempAgeRange = (HouseholdsByAgeRange) tempEntityManager.find(HouseholdsByAgeRange.class,7);
	            HouseholdEarners tempHouseholdEarners = (HouseholdEarners) tempEntityManager.find(HouseholdEarners.class,3);
	            TotalIncome tempTotalIncome = (TotalIncome) tempEntityManager.find(TotalIncome.class,14);
	            CensusYear tempCensusYear = (CensusYear) tempEntityManager.find(CensusYear.class,1);

	            
	            Household newHousehold = new Household(4,newGA, tempHouseholdType, tempHouseholdSize, tempAgeRange, tempHouseholdEarners,
	            		tempTotalIncome, tempCensusYear);
	            
	            tempEntityManager.persist(newHousehold);
	            
	        
	            String tempSelectJPQLQuery = "h, ga, cy, ht, hs, hba, he, ti FROM Household h "
	            		+ "JOIN h.geographicArea ga "
	            		+ "JOIN h.censusYear cy "
	            		+ "JOIN h.householdType ht "
	            		+ "JOIN h.householdSize hs "
	            		+ "JOIN h.householdEarners he "
	            		+ "JOIN h.householdsByAgeRange hba "
	            		+ "JOIN h.totalIncome ti "
	                    + "WHERE ga.altCode = :altCode "
	                    + "AND cy.censusYear = :censusYear "
	                    + "AND ht.id = :htDescription "
	                    + "AND hs.id = :hsDescription "
	                    + "AND hba.id = :hbaDescription "
	                    + "AND he.id = :heDescription "
	                    + "AND ti.id = :tiDescription ";
	                 

	            Query tempQuery = tempEntityManager.createQuery(tempSelectJPQLQuery)
	            		.setParameter("altCode", 499)
	            		.setParameter("censusYear", 1)
	            		.setParameter("htDescription", 11)
	            		.setParameter("hsDescription", 3)
	            		.setParameter("hbaDescription", 7)
	            		.setParameter("heDescription", 3)
	            		.setParameter("tiDescription", 14);
	            

	            List<Household> tempList = tempQuery.getResultList();

	            // Produce a simple report showing some data about each player on the retrieved team
	            System.out.println("Begin Report.");

	            List <String> tempOutputTable = new ArrayList <String>();

	            tempOutputTable.add(String.format("%-30s", "Player Name")
	                    + String.format("%-10s", "Jersey")
	                    + String.format("%20s", "Position"));

	            for (Roster tempRetrievedRoster : tempList)
	            {

	                Player tempRetrievedPlayer = tempEntityManager.find(Player.class, tempRetrievedRoster.getPlayer());
	                String tempPlayerFullName = tempRetrievedPlayer.getFullName();
	                int tempJersey = tempRetrievedRoster.getJersey();
	                String tempPosition = tempRetrievedRoster.getPosition();

	                tempOutputTable.add(String.format("%-30s", tempPlayerFullName)
	                        + String.format("%-10d", tempJersey)
	                        + String.format("%20s", tempPosition));

	            }

	            PrintOutput("LeagueDB: " + tempTeam.getTeamName(), tempOutputTable);
	            System.out.println("Report done.");

	            tempEntityManager.getTransaction().rollback();

	        }
	        catch (Exception e)
	        {

	            if (tempEntityManager != null)
	            {

	                tempEntityManager.getTransaction().rollback();

	            }

	            e.printStackTrace();

	        }
	        finally
	        {

	            if (tempEntityManager != null)
	            {

	                tempEntityManager.close();

	            }

	            if (tempEntityManagerFactory != null)
	            {

	                tempEntityManagerFactory.close();

	            }

	        }

	    }

		
	private static void PrintOutput(String tempOutputTableTitle, List <String> tempOutputTable)
	{
	
	    System.out.println("******************************************************************************************");
	    System.out.println();
	    System.out.println(tempOutputTableTitle);
	    System.out.println();
	
	    for (String tempOutputTableElement : tempOutputTable)
	    {
	
	        System.out.println(tempOutputTableElement);
	
	    }
	
	    System.out.println();
	    System.out.println("******************************************************************************************");
	
	}

}
