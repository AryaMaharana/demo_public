package com.example.demo.dao.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "t_address", schema = "sc_arya")
public class Address {
	
	@Id
	@Column(name = "add_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer AddressId;

	@Column(name = "city")
	private String city;

	@Column(name = "addressType")
	private String addressType;

	public Integer getAddressId() {
		return AddressId;
	}

	public void setAddressId(Integer addressId) {
		AddressId = addressId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	@Override
	public int hashCode() {
		return Objects.hash(AddressId, addressType, city);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return Objects.equals(AddressId, other.AddressId) && Objects.equals(addressType, other.addressType)
				&& Objects.equals(city, other.city);
	}

	@Override
	public String toString() {
		return "Address [AddressId=" + AddressId + ", city=" + city + ", addressType=" + addressType + "]";
	}
	
	

}
