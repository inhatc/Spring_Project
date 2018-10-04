package com.mymac.VO;

import java.util.Date;

public class BoardVO {
	
	private Integer bno;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private int viewcnt;
	private String imge;
	

	public Integer getBno() {
		return bno;
	}


	public void setBno(Integer bno) {
		this.bno = bno;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getWriter() {
		return writer;
	}


	public void setWriter(String writer) {
		this.writer = writer;
	}


	public Date getRegdate() {
		return regdate;
	}


	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}


	public int getViewcnt() {
		return viewcnt;
	}


	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}


	public String getImge() {
		return imge;
	}


	public void setImge(String imge) {
		this.imge = imge;
	}


	@Override
	public String toString() {
		return "Book [bno=" + bno +", title =" + title + ", imge=" + imge +"]";
	}
	
	
}

	