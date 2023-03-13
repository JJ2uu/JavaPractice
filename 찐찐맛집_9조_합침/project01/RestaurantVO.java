package project01;

public class RestaurantVO {
	
	private String name;
	private String address;
	private String category;
	private float n_stars;
	private float k_stars;
	private float g_stars;
	private String menu;
	private String price;
	private String img;
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
	public float getN_stars() {
		return n_stars;
	}
	public void setN_stars(float n_stars) {
		this.n_stars = n_stars;
	}
	public float getK_stars() {
		return k_stars;
	}
	public void setK_stars(float k_stars) {
		this.k_stars = k_stars;
	}
	public float getG_stars() {
		return g_stars;
	}
	public void setG_stars(float g_stars) {
		this.g_stars = g_stars;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	@Override
	public String toString() {
		return "RestaurantVO [name=" + name + ", address=" + address + ", category=" + category + ", n_stars=" + n_stars
				+ ", k_stars=" + k_stars + ", g_stars=" + g_stars + ", menu=" + menu + ", price=" + price + ", img="
				+ img + "]";
	}

}
