package com.agency.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Transport {

		@Id
		private Integer transportId;
		private String numberOfSeats;
		private String transportType;
		public Transport() {
			
		}
		public Transport(Integer transportId, String numberOfSeats, String transportType) {
			super();
			this.transportId = transportId;
			this.numberOfSeats = numberOfSeats;
			this.transportType = transportType;
		}
		@Override
		public String toString() {
			return "Transport [transportId=" + transportId + ", numberOfSeats=" + numberOfSeats + ", transportType="
					+ transportType + "]";
		}
		public Integer getTransportId() {
			return transportId;
		}
		public void setTransportId(Integer transportId) {
			this.transportId = transportId;
		}
		public String getNumberOfSeats() {
			return numberOfSeats;
		}
		public void setNumberOfSeats(String numberOfSeats) {
			this.numberOfSeats = numberOfSeats;
		}
		public String getTransportType() {
			return transportType;
		}
		public void setTransportType(String transportType) {
			this.transportType = transportType;
			
		}
		@Override
		public int hashCode() {
			return Objects.hash(numberOfSeats, transportId, transportType);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Transport other = (Transport) obj;
			return Objects.equals(numberOfSeats, other.numberOfSeats) && Objects.equals(transportId, other.transportId)
					&& Objects.equals(transportType, other.transportType);
		}
}