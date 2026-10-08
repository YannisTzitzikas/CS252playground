/**
 * 
 */
package week3_4;

class Player {
	String name;
	private Team  team;
	int birthYear=2000; 
	static int numOfPlayers = 0 ; // to count how many players have been created
	
	Team getTeam() {
		return this.team;
	}
	void setTeam (Team newTeam) {
		if (this.team !=null) {
			this.team.removePlayer(this);
		}
		this.team = newTeam;
		newTeam.addPlayer(this);
	}
	
	
	public String toString() {
		String teamName = "den paizei pouthena"; 
		if (team!=null)
			teamName = team.name;
		
		return "Football player:" +  name + " birthYear:" + birthYear 
				+ " at team:"+ teamName ;
	}
	Player(String name, int birthYear, Team team) {
		this.name = name;
		this.birthYear = birthYear;
		this.team = team;
		if (team!=null)
			team.addPlayer(this);
		numOfPlayers++;
	}
	Player (String name) {
		this(name, 0, null);
	}
	Player() {
		this("Anonymous",0, null);
	}
}
class Team {
	String name = "ΟΦΗ";
	int  startYear ;
	Player[] roaster = new Player[100];
	int activePlayers = 0;
	
	public String toString() {
		return "Team info. Name:" +  name + " startYear:" + startYear
				+ " " + players() ;
	}
	
	/**
	 * @param player
	 */
	public void addPlayer(Player player) {
		roaster[activePlayers++] = player;
		
	}
	
	public void removePlayer(Player p) {
		boolean found=false;
		for (int i=0; i<activePlayers; i++) {
			if (roaster[i]==p) {
				 roaster[i]=null; // patch 2 fix
				//roaster[i] = roaster[i+1];
			}
		}
		if (found) 
			activePlayers--;
	}

	Team (String n, int b) {
		name = n;
		startYear = b;
	}
	Team () {
		
	}

	/**
	 * @return
	 */
	public String players() {
		String toReturn = "Roaster\n";
		for (int i=0; i< activePlayers; i++)	
			if (roaster[i]!=null)
				toReturn = toReturn + "\t " + roaster[i].name + "\n";
		return toReturn;
	}
}

class FootballAPP {
	public String toString() {
		return "Πρωτάθλημα στον ΟΦΗ!";
	}
	
	public static void main(String[] args) {
		System.out.println("FLASHSCORE 0.01");
		
		Team tpao = new Team("Panathinakos",1908);
		Player p1 = new Player("Teteh", 2001,tpao);
		Player p2 = new Player("Daporda", 205,tpao);
		Player p3 = new Player("Oliveira Rotrigo");
		System.out.println(p3);
		int K = 8;
		Player[] setOfplayers = new Player[K];
		for (int i=0; i<K; i++) {
			setOfplayers[i] = new Player("Παίχτης"+(i+1), 2025, tpao);
		}
		System.out.println("Num of player created: " + Player.numOfPlayers);
		
		for (Player p: setOfplayers)
			System.out.println(p);
		
		System.out.println(tpao.players());
		
		Player pandroutsos = new Player("Ανδρούτσος",2000, 
				new Team("ΟΦΗ",1925));
		System.out.println(pandroutsos);
				
		Player athanasiou = new Player("Αθανασίου",2000, 
				pandroutsos.getTeam());
	
		System.out.println(pandroutsos.getTeam());
		
		pandroutsos.setTeam(new Team("Arsenal", 1900));
		//pandroutsos.se = new Team("Arsenal", 1900);
		
		System.out.println(athanasiou);
		System.out.println(pandroutsos);
		
		System.out.println(p1);
		p1.setTeam(athanasiou.getTeam()); // o τετέι παει οφη
		System.out.println(athanasiou.getTeam());
		
		
			
		
		System.exit(1);
		
		/*
		Team t1 = new Team();
		t1.name = "Panathinaikos";
		t1.startYear = 1908; 
		
		Player p = new Player();
		p.name = "Teteh";
		p.birthYear = 2001; 
		p.team = t1;
		System.out.println(p);
		System.out.println(p.toString());
		
		System.out.println(t1);
		t1.name = "Olympiakos";
		System.out.println(t1);
		
		Team tmp = new Team();
		System.out.println(tmp);
		*/
		
	}

}
