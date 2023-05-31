package site.itwill.dto;

public class PhoneDTO {
	private String mdnm;
	private String phname;
	private int memory;
	private String color;
	private int stock;
	
	public PhoneDTO() {
		// TODO Auto-generated constructor stub
	}

	public PhoneDTO(String mdnm, String phname, int memory, String color, int stock) {
		super();
		this.mdnm = mdnm;
		this.phname = phname;
		this.memory = memory;
		this.color = color;
		this.stock = stock;
	}

	public String getMdnm() {
		return mdnm;
	}

	public void setMdnm(String mdnm) {
		this.mdnm = mdnm;
	}

	public String getPhname() {
		return phname;
	}

	public void setPhname(String phname) {
		this.phname = phname;
	}

	public int getMemory() {
		return memory;
	}

	public void setMemory(int memory) {
		this.memory = memory;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	
}
