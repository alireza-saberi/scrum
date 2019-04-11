package com.scrum.selector;

import java.util.Arrays;

public class Selector {
    private static Selector _instance = null;

    private final static String[] scrumTeam = new String[]{"Alan", "Cati", "Tarek", "Etienne Ali", "Brian",
            "Teo", "Dan", "Disha", "Vivek", "Andre", "Vitaliy",
            "Dennis", "Parth", "Gery", "Svitlana", "Sam",
            "Taylor", "Fadi", "William","Ben","Harry",
            "Lan", "Kalyan", "Antoine", "Jia","Gurjant",
            "Robert", "Jeffee", "Jacques", "Jan Rockemann", "Sebastien"};
//    30 persons
    private final static int teamSize = scrumTeam.length;
    private String[] newSeries;
    private int[] randomArray;
    private static int count;

    private Selector() {
        this.randomArray = new int[teamSize];
        this.newSeries = new String[teamSize];
        this.count = 0;
        createNewSeries();
//        getNewSeries();
    }

    public static Selector getInstance()
    {
        if (_instance == null)
            _instance = new Selector();

        return _instance;
    }

    private void createNewSeries() {
        createRandomArray();

        for (int i = 0; i < this.randomArray.length; i++) {
            this.newSeries[i] = this.scrumTeam[randomArray[i]];
        }

//        return newSeries;
    }

    private void createRandomArray() {

        Arrays.fill(randomArray, -1);

        int counter = 0;
        while(counter < teamSize) {
            int randomIndex = (int) (Math.random() * teamSize);

            if (!isDuplicate(randomIndex)) {
                randomArray[counter] = randomIndex;
                counter++;
            }
        }
    }

    private boolean isDuplicate(int randomIndex) {
        for (int j =0; j < randomArray.length; j++) {
            if(randomArray[j] == randomIndex) {
                return true;
            }
        }
        return false;
    }
    
    public String getNextPerson() {
    	String temp;
    	if (count < teamSize) {
    		int no = count + 1;
    		temp = newSeries[count] + " as number " + no;
    		count++;
    		return temp;
    	}
    	temp = " finished!, Yeay!";
    	count = 0;
    	return temp;
    }

	
}
