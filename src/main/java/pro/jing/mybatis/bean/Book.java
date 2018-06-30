package pro.jing.mybatis.bean;

import java.util.Date;

public class Book {

	private Integer id;
	private String bookName;
	private String author;
	private Double price;
	private Date publishDate;
	private PublishingCompany publishingCompany;
	
	public Book() {
	}

	public Book(Integer id, String bookName, String author, Double price, Date publishDate,
			PublishingCompany publishingCompany) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.author = author;
		this.price = price;
		this.publishDate = publishDate;
		this.publishingCompany = publishingCompany;
	}

	public PublishingCompany getPublishingCompany() {
		return publishingCompany;
	}

	public void setPublishingCompany(PublishingCompany publishingCompany) {
		this.publishingCompany = publishingCompany;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", bookName=" + bookName + ", author=" + author + ", price=" + price
				+ ", publishDate=" + publishDate + "]";
	}

}
