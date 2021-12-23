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
	int getYear() 		{return 1900+date.getYear();}
	Goal(Date date, String player, String team) {
		this.date =date; this.player=player; this.team=team;
	}
}


class GroupByExamples {

	public static void main(String[] lala) {
		System.out.println("-Examples of Analytic Queries (GROUP BY queries)");
		
		List<Goal> goals 	= new ArrayList<>();
		try {
			goals.add(new Goal(new SimpleDateFormat("yyyy-MM-dd").parse("2018-01-01"),"Mesi","Barcelona"));
			goals.add(new Goal(new SimpleDateFormat("yyyy-MM-dd").parse("2019-01-01"),"Mesi","Barcelona"));
			goals.add(new Goal(new SimpleDateFormat("yyyy-MM-dd").parse("2020-01-01"),"Mesi","Barcelona"));
			goals.add(new Goal(new SimpleDateFormat("yyyy-MM-dd").parse("2020-01-01"),"Papadakis","Ofi"));
		} catch (ParseException e) {e.printStackTrace();}
		
		
		
		System.out.println("\n A. Number  of goals by  year ");
        Map<Integer, Long> numOfGoalsByYear = 
        		goals.stream()
        		  .collect(Collectors
        				  .groupingBy(Goal::getYear,Collectors.counting()));
        System.out.println(numOfGoalsByYear);
       
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
        
	}

}
