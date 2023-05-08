package model;

public class User {

	private int uid;
	private String uname;
	private String upass;
	private String uemail;
	
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int uid, String uname, String upass, String uemail) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upass = upass;
		this.uemail = uemail;
	}
	
	public User(String uname, String upass, String uemail) {
		super();
		this.uname = uname;
		this.upass = upass;
		this.uemail = uemail;
	}
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", upass=" + upass + ", uemail=" + uemail + "]";
	}
	
	
	
}
