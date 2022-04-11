package br.com.systempro.bookservice.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Book implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String author;
	private Date launchDate;
	private Double price;
	private String title;
	private String currency;
	private String envitonment;

	public Book() {
	}

	public Book(Long id, String author,String title, Date launchDate, Double price,  String currency,
			String envitonment) {
		this.id = id;
		this.author = author;
		this.launchDate = launchDate;
		this.price = price;
		this.title = title;
		this.currency = currency;
		this.envitonment = envitonment;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getLaunchDate() {
		return launchDate;
	}

	public void setLaunchDate(Date launchDate) {
		this.launchDate = launchDate;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getEnvitonment() {
		return envitonment;
	}

	public void setEnvitonment(String envitonment) {
		this.envitonment = envitonment;
	}

	@Override
	public int hashCode() {
		return Objects.hash(author, currency, envitonment, id, launchDate, price, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(author, other.author) && Objects.equals(currency, other.currency)
				&& Objects.equals(envitonment, other.envitonment) && Objects.equals(id, other.id)
				&& Objects.equals(launchDate, other.launchDate) && Objects.equals(price, other.price)
				&& Objects.equals(title, other.title);
	}

}
