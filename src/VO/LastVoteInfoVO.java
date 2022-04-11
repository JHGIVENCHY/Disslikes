package VO;

public class LastVoteInfoVO {
	
		private String id;			
		private String img;
		private String title;
		private int like;
		private int dislike;
		private String win;
		private String vt_img_name;
		public LastVoteInfoVO(String id, String img, String title, int like, int dislike, String win, String vt_img_name) {
			//super();
			this.vt_img_name = vt_img_name;
			this.id = id;
			this.img = img;
			this.title = title;
			this.like = like;
			this.dislike = dislike;
			this.win = win;
		}
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

		public int getLike() {
			return like;
		}

		public void setLike(int like) {
			this.like = like;
		}

		public int getDislike() {
			return dislike;
		}

		public void setDislike(int dislike) {
			this.dislike = dislike;
		}

		public String getWin() {
			return win;
		}

		public void setWin(String win) {
			this.win = win;
		}

		public LastVoteInfoVO() { }
		
		
	}			

