package board_model;

import java.io.Serializable;

public class boDTO implements Serializable {
	private int no;
	private String title;
	private String author;
	private String content;
	private String nal;
	private String readCount;
	public boDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public boDTO(int no, String title, String author, String content, String nal, String readCount) {
		super();
		this.no = no;
		this.title = title;
		this.author = author;
		this.content = content;
		this.nal = nal;
		this.readCount = readCount;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getNal() {
		return nal;
	}
	public void setNal(String nal) {
		this.nal = nal;
	}
	public String getReadCount() {
		return readCount;
	}
	public void setReadCount(String readCount) {
		this.readCount = readCount;
	}
	@Override
	public String toString() {
		return "boDTO [no=" + no + ", title=" + title + ", author=" + author + ", content=" + content + ", nal=" + nal
				+ ", readCount=" + readCount + "]";
	}
	
}
