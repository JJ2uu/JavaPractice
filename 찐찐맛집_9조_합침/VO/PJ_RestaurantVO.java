package VO;

//RAM에 만드는 저장공간을 만든다.
public class PJ_RestaurantVO {
	// PJ_RestaurantVO가방에 넣은 데이터는 PJ_Restaurant테이블에 들어갈 예정
	// 각 컬럼과 일치시켜 줌.
	private String name;
	private String address;
	private String category;
	private String n_Stars;
	private String k_Stars;
	private String g_Stars;
	private String menu;
	private String img;
	private String views;
	private String no;
	private String avg;
	
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

	public String getN_Stars() {
		return n_Stars;
	}

	public void setN_Stars(String n_Stars) {
		this.n_Stars = n_Stars;
	}

	public String getK_Stars() {
		return k_Stars;
	}

	public void setK_Stars(String k_Stars) {
		this.k_Stars = k_Stars;
	}

	public String getG_Stars() {
		return g_Stars;
	}

	public void setG_Stars(String g_Stars) {
		this.g_Stars = g_Stars;
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
	
	public String getViews() {
		return views;
	}
	
	public void setViews(String views) {
		this.views = views;
	}
	
	public String getNo() {
		return no;
	}
	
	public void setNo(String no) {
		this.no = no;
	}
	
	public String getAvg() {
		return avg;
	}
	
	public void setAvg(String avg) {
		this.avg = avg;
	}

	// 하나의 변수당 set/get하나씩 만들어줌.
	// 가방에 하나씩 값을 넣어주어야 함. ==> setter

	@Override
	public String toString() {
		return img + name + address + category + n_Stars  + k_Stars + g_Stars;
	}

	// 가방에 어떤 값들이 들어있는지 string으로 다 찍어볼 수 있다.

}