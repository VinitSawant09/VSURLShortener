package com.urlshortener.model;

import java.util.List;

public class OutputVO {
	private String status;
	private String statusCode;
	private String shortURL;
	private String originalURL;
	private Long urlCount;
	private List<URL> urlList;
	public List<URL> getUrlList() {
		return urlList;
	}
	public void setUrlList(List<URL> urlList) {
		this.urlList = urlList;
	}
	public void setUrlCount(Long urlCount) {
		this.urlCount = urlCount;
	}
	public Long getUrlCount() {
		return urlCount;
	}
	public void setUrlCount(long l) {
		this.urlCount = l;
	}
	public String getOriginalURL() {
		return originalURL;
	}
	public void setOriginalURL(String originalURL) {
		this.originalURL = originalURL;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getShortURL() {
		return shortURL;
	}
	public void setShortURL(String shortURL) {
		this.shortURL = shortURL;
	}
	
	
}
