package 찐찐맛집;

public class UserVO {
	private String id;
	private String pw;
	private String name;
	private String tel;
	private int recommender;
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
	
	public void setRecommender(int recommender) {
		this.recommender = recommender;
	}
	
	public int getRecommender() {
		return recommender;
	}
	
	@Override
	public String toString() {
		return "UserVO [id=" + id + ", pw=" + pw + ", name=" + name + ", tel=" + tel + ", recommender=" + recommender
				+ "]";
	}
	
	
	
	
}
