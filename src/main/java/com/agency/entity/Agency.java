package com.agency.entity;

import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
@Entity
public class Agency {
	public Agency() {
	
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer AgencyId;
	private String name;

	public Integer getAgencyId() {
		return AgencyId;
	}
	@OneToMany(targetEntity=Transport.class,cascade=CascadeType.ALL)
	@JoinColumn(name="agencyId")
	Set<Transport> transportList;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public Set<Transport> getTransportList() {
		return transportList;
	}
	public void setTransportList(Set<Transport> transportList) {
		this.transportList = transportList;
	}
	public void setAgencyId(Integer agencyId) {
		AgencyId = agencyId;
	}

	@Override
	public String toString() {
		return "Agency [AgencyId=" + AgencyId + ", name=" + name + ", transportList=" + transportList + "]";
	}
	public Agency(Integer agencyId, String name, Integer transportId, Set<Transport> transportList) {
		super();
		AgencyId = agencyId;
		this.name = name;
		
		this.transportList = transportList;
	}
	@Override
	public int hashCode() {
		return Objects.hash(AgencyId, name, transportList);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agency other = (Agency) obj;
		return Objects.equals(AgencyId, other.AgencyId) && Objects.equals(name, other.name)
				&& Objects.equals(transportList, other.transportList);
	}
	
}



