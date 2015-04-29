package member;

public class MemberBean {
	private String id;
	private String pw;
	private int sNum;
	private String name;
	private String phone;
	private String email;
	private String authority;
	
	public void setId(String id){
		this.id=id;
	}
	public String getId(){
		return id;
	}
	public void setPw(String pw){
		this.pw=pw;
	}
	public String getPw(){
		return pw;
	}
	public void setSNum(int sNum){
		this.sNum=sNum;
	}
	public int getSNum(){
		return sNum;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	public void setPhone(String phone){
		this.phone=phone;
	}
	public String getPhone(){
		return phone;
	}
	public void setEmail(String email){
		this.email=email;
	}
	public String getEmail(){
		return email;
	}
	public void setAuthority(String authority){
		this.authority=authority;
	}
	public String getAuthority(){
		return authority;
	}
}
