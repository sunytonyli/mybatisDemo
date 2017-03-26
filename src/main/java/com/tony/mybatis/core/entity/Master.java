package com.tony.mybatis.core.entity;

import java.io.Serializable;
import java.util.List;

public class Master implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3948623657607002144L;

	private String nama;
	private int usia;
	private List<Contoh> contohList;
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public int getUsia() {
		return usia;
	}
	public void setUsia(int usia) {
		this.usia = usia;
	}
	public List<Contoh> getContohList() {
		return contohList;
	}
	public void setContohList(List<Contoh> contohList) {
		this.contohList = contohList;
	}
}
