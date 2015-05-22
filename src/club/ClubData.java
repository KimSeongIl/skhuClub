package club;

public class ClubData {

	private String name;
	private String clubExplain;
	private String homePage;
	private String clubEvent;
	
	public void setClubExplain(String clubExplain){
		this.clubExplain=clubExplain;
		
	}
	public String getClubExplain(){
		return clubExplain;
	}
	
	public void setClubEvent(String clubEvent){
		this.clubEvent=clubEvent;
	}
	
	public String getClubEvent(){
		return clubEvent;
	}
	
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	
	public void setHomePage(String homePage){
		this.homePage=homePage;
	}
	public String getHomePage(){
		return homePage;
	}
}
