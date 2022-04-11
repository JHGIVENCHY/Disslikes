package VO;

public class VoteInfoVO {

	private String id;			
	private String img;
	private String title;
	private String vt_img_name;
	
	public VoteInfoVO(String id, String img, String title, String vt_img_name) {
		//super();
		this.vt_img_name = vt_img_name;
		this.id = id;
		this.img = img;
		this.title = title;
	}
	
	public VoteInfoVO() { }
	
	public String getVt_img_name() {
		return vt_img_name;
	}

	public void setVt_img_name(String vt_img_name) {
		this.vt_img_name = vt_img_name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
