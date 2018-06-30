package pro.jing.mybatis.bean;

import java.util.List;

public class PublishingCompany {

	private Integer id;
	private String companyName;
	private String address;
	List<Book> books;
	

	public PublishingCompany() {
	}

	public PublishingCompany(Integer id, String companyName, String address) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.address = address;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "PublishingCompany [id=" + id + ", companyName=" + companyName + ", address=" + address + "]";
	}

}
