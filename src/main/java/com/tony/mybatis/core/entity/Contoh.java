package com.tony.mybatis.core.entity;

import java.io.Serializable;

public class Contoh implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8227025053882538379L;

	private Long id;
	private String nama;
	private String alamat;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public String getAlamat() {
		return alamat;
	}
	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}
}
