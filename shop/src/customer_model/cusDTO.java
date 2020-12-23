package customer_model;

import java.io.Serializable;

public class cusDTO implements Serializable {
	private int cus_num;
	private String name;
	private String id;
	private String pw;
	private String addr;
	private String tel;
	public cusDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public cusDTO(int cus_num, String name, String id, String pw, String addr, String tel) {
		super();
		this.cus_num = cus_num;
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.addr = addr;
		this.tel = tel;
	}
	public int getCus_num() {
		return cus_num;
	}
	public void setCus_num(int cus_num) {
		this.cus_num = cus_num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
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
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
	@Override
	public String toString() {
		return "cusDTO [cus_num=" + cus_num + ", name=" + name + ", id=" + id + ", pw=" + pw + ", addr=" + addr
				+ ", tel=" + tel + "]";
	}
	
	
}
