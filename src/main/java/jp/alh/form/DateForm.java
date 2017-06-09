package jp.alh.form;

public class DateForm {
	
	private String previousDate;
	private String selectedDate;
	private String nextDate;
	
	public String getPreviousDate() {
		return previousDate;
	}
	public void setPreviousDate(String previousDate) {
		this.previousDate = previousDate;
	}
	public String getSelectedDate() {
		return selectedDate;
	}
	public void setSelectedDate(String currentDate) {
		this.selectedDate = currentDate;
	}
	public String getNextDate() {
		return nextDate;
	}
	public void setNextDate(String nextDate) {
		this.nextDate = nextDate;
	}
}
