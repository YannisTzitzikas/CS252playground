/**
 * 
 */
package week15_Java8;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * @author Yannis Tzitzikas (yannistzitzik@gmail.com)
 *
 */

class Goal {
	Date date;
	String player;
	String team;
	String getPlayer() 	{return player;}
	String getTeam() 	{return team;}
	String getFirstLetterOfScorerName() {
		return player.substring(0,1);
	}
	int getYear() 		{return 1900+date.getYear();}
	
	String getTeamAndYear ( )		{return getTeam() + "-"+ getYear();}
	Goal(Date date, String player, String team) {
		this.date =date; this.player=player; this.team=team;
	}
}
 

class GroupByExamples {

	public static void main(String[] lala) {
		System.out.println("-Examples of Analytic Queries (GROUP BY queries)");
		
		Object[] la = new Object[1999];
		Stream.of(la).foreach(x -> System.out.println(x));
		
		
		
		
		List<Goal> goals 	= new ArrayList<>();
		
		
		
		try {
			goals.add(new Goal(new SimpleDateFormat("yyyy-MM-dd").parse("2018-01-01"),"Mesi","Barcelona"));
			goals.add(new Goal(new SimpleDateFormat("yyyy-MM-dd").parse("2019-01-01"),"Mesi","Barcelona"));
			goals.add(new Goal(new SimpleDateFormat("yyyy-MM-dd").parse("2020-01-01"),"Mesi","Barcelona"));
			goals.add(new Goal(new SimpleDateFormat("yyyy-MM-dd").parse("2020-01-01"),"Semedo","Ofi"));
			goals.add(new Goal(new SimpleDateFormat("yyyy-MM-dd").parse("2022-01-01"),"Titos","Panathinaikos"));
			goals.add(new Goal(new SimpleDateFormat("yyyy-MM-dd").parse("2022-11-12"),"Titos","Panathinaikos"));
			goals.add(new Goal(new SimpleDateFormat("yyyy-MM-dd").parse("2022-11-12"),"Yannis","Panathinaikos"));
			goals.add(new Goal(new SimpleDateFormat("yyyy-MM-dd").parse("2023-12-19"),"Yannis","Minoiki"));
			goals.add(new Goal(new SimpleDateFormat("yyyy-MM-dd").parse("2023-12-19"),"Argyros","Minoiki"));
			goals.add(new Goal(new SimpleDateFormat("yyyy-MM-dd").parse("2024-12-11"),"Yamal","Barcelona"));
			
		} catch (ParseException e) {e.printStackTrace();}
		
		
		
		System.out.println("\n A. Number  of goals by  year ");
        Map<Integer, Long> numOfGoalsByYear = 
        		goals.stream()
        		  .collect(Collectors
        				  .groupingBy(Goal::getYear,Collectors.counting()));   // counts the number of objects of each group
        System.out.println(numOfGoalsByYear);
       
        
        System.out.println("\n A. Number  of goals by  scorer's first letter of name ");
        Map<String, Long> tmp = 
        		goals.stream()
        		  .collect(Collectors
        	.groupingBy(Goal::getFirstLetterOfScorerName,Collectors.counting()));   // counts the number of objects of each group
        System.out.println(tmp);
       
        
       
        
        
        System.out.println("\n B. Number  of goals by player ");
        Map<String, Long> goalsByPlayer = 
        		goals.stream()
        		  .collect(Collectors
        .groupingBy(Goal::getPlayer,Collectors.counting()));
        System.out.println(goalsByPlayer);
       
        
        System.out.println("\n C. Number  of goals per team \n" +
          		goals.stream()
      		  .collect(Collectors
    				  .groupingBy(Goal::getTeam,Collectors.counting())));
        
        
        System.out.println("\n D. Number  of goals per team and year\n" +
          		goals.stream()
      		  .collect(Collectors
    				  .groupingBy(Goal::getTeamAndYear ,Collectors.counting())));
          
	}

}

/*
Notes: The general form of analytic queries (as three functions)
(howToFormGroups,overWhatFieldToCompute,whatToComputeOverThatField)
Examples:
(by team, age, avg)  // avg ages of teams
(by team, goals, count) // count goals of teams

SQL:

SELECT teamName, count (*)
from Goals
GROUP BY team


*/

