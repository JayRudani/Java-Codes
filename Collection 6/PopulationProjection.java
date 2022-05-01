public class PopulationProjection {

	public static void main(String[] args) {
		int currentPopulation = 312032486; // current population of United States
		int birtheveryday = 86400 / 7, deatheveryday = 86400 / 13, immigranteveryday = 86400 / 45; // calculating
																									// birth, death
																									// and immigrant
																									// per day as a
																									// day consist
																									// of 86400
																									// seconds
		int birtheveryyear = birtheveryday * 365, deatheveryyear = deatheveryday * 365,
				immigranteveryyear = immigranteveryday * 365; // as a year consist of 365 days so multiplying the value
																// of birth, death and immigrant of per day with 365
		int firstYearPopulation = currentPopulation + birtheveryyear - deatheveryyear + immigranteveryyear; // calculating
																											// the
																											// population
																											// at the
																											// end of
																											// first
																											// year
		int secondYearPopulation = firstYearPopulation + birtheveryyear - deatheveryyear + immigranteveryyear; // calculating
																												// the
																												// population
																												// at
																												// the
																												// end
																												// of
																												// second
																												// year
		int thirdYearPopulation = secondYearPopulation + birtheveryyear - deatheveryyear + immigranteveryyear; // calculating
																												// the
																												// population
																												// at
																												// the
																												// end
																												// of
																												// third
																												// year
		int fourthYearPopulation = thirdYearPopulation + birtheveryyear - deatheveryyear + immigranteveryyear; // calculating
																												// the
																												// population
																												// at
																												// the
																												// end
																												// of
																												// fourth
																												// year
		int fifthYearPopulation = fourthYearPopulation + birtheveryyear - deatheveryyear + immigranteveryyear; // calculating
																												// the
																												// population
																												// at
																												// the
																												// end
																												// of
																												// fifth
																												// year

		System.out.println("Population of United States at the end of First Year:" + firstYearPopulation);
		System.out.println("Population of United States at the end of Second Year:" + secondYearPopulation);
		System.out.println("Population of United States at the end of Third Year:" + thirdYearPopulation);
		System.out.println("Population of United States at the end of Fourth Year:" + fourthYearPopulation);
		System.out.println("Population of United States at the end of Fifth Year:" + fifthYearPopulation);

	}

}
