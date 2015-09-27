package club;

public class ClubData {

	private String name;
	private String clubExplain;
	private String homePage;
	private String clubEvent;
	private String image;
	private String member;
	private String phone;
	
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
	public void setImage(String image){
		this.image=image;
	}//클럽이미지
	public String getImage(){
		return image;
	}//클럽이미지
	public void setMember(String member){
		this.member=member;
	}
	public String getMember(){
		return member;
	}
	public void setPhone(String phone){
		this.phone=phone;
	}
	public String getPhone(){
		return phone;
	}
}
