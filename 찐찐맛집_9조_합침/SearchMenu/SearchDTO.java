package SearchMenu;

public class SearchDTO {
	private String name;
	private String address;
	private String category;
	private float nStars;
	private float kStars;
	private float gStars;
	private String menu;
	private String img;
	private int views;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public float getnStars() {
		return nStars;
	}
	public void setnStars(float nStars) {
		this.nStars = nStars;
	}
	public float getkStars() {
		return kStars;
	}
	public void setkStars(float kStars) {
		this.kStars = kStars;
	}
	public float getgStars() {
		return gStars;
	}
	public void setgStars(float gStars) {
		this.gStars = gStars;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	@Override
	public String toString() {
		return "SearchDTO [name=" + name + ", address=" + address + ", category=" + category + ", nStars=" + nStars
				+ ", kStars=" + kStars + ", gStars=" + gStars + ", menu=" + menu + ", img=" + img + ", views=" + views
				+ "]";
	}
	
	
}
