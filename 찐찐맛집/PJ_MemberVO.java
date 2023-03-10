package 찐찐맛집;

public class PJ_MemberVO {
	private String id;
	private String pw;
	private String name;
	private String tel;
	private String code;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	@Override
	public String toString() {
		return "PJ_MemberVO [id=" + id + ", pw=" + pw + ", name=" + name + ", tel=" + tel + ", code=" + code + "]";
	}
	

	
	
	
	
	
}
