package 찐찐맛집_VO;

public class PJ_MemoVO {
	private String id;
	private String res_name;
	private String memo;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRes_name() {
		return res_name;
	}
	public void setRes_name(String res_name) {
		this.res_name = res_name;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	@Override
	public String toString() {
		return "PJ_MemoVO [id=" + id + ", res_name=" + res_name + ", memo=" + memo + "]";
	}
	
	
}
