package comment;

import java.sql.Timestamp;

public class CommentData {
	private int bdid;
	private int bid;
	private String uid;
	private String name;
	private String bdcontent;
	private Timestamp bddate;
	private int bdcount;
	
	public void setBdid(int bdid){
		this.bdid=bdid;
	}
	public int getBdid(){
		return bdid;
	}
	public void setBid(int bid){
		this.bid=bid;
	}
	public int getBid(){
		return bid;
	}
	public void setUid(String uid){
		this.uid=uid;
	}
	public String getUid(){
		return uid;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	public void setBdcontent(String bdcontent){
		this.bdcontent=bdcontent;
	}
	public String getBdcontent(){
		return bdcontent;
	}
	public void setBddate(Timestamp bddate){
		this.bddate=bddate;
	}
	public Timestamp getBddate(){
		return bddate;
	}
	public void setBdcount(int bdcount){
		this.bdcount=bdcount;
	}
	public int getBdcount(){
		return bdcount;
	}

}
