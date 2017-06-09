package jp.alh.entity;

public class ReservationEntity {
	
	private int id;
	private String userId;
	private String locationId;
	private String reservedDate;
	private String reservedStart;
	private String reservedEnd;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getLocationId() {
		return locationId;
	}
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	public String getReservedDate() {
		return reservedDate;
	}
	public void setReservedDate(String reservedDate) {
		this.reservedDate = reservedDate;
	}
	public String getReservedStart() {
		return reservedStart;
	}
	public void setReservedStart(String reservedStart) {
		this.reservedStart = reservedStart;
	}
	public String getReservedEnd() {
		return reservedEnd;
	}
	public void setReservedEnd(String reservedEnd) {
		this.reservedEnd = reservedEnd;
	}
}
