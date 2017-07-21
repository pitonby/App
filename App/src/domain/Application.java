package domain;


public class Application {
	
	private String id,
				   firstName, 
	               secondName, 
	               department, 
	               id_number, 
	               pc_number, 
	               text;
	
	private String startTime, endTime;
	
	
	private Flags enumFlag; 
	
	public Application(){
		
	}

	public String getId(){
		return id;
	}
	
	public void setId(String id){
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getId_number() {
		return id_number;
	}

	public void setId_number(String id_number) {
		this.id_number = id_number;
	}

	public String getPc_number() {
		return pc_number;
	}

	public void setPc_number(String pc_number) {
		this.pc_number = pc_number;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}


	public Flags getEnumFlag() {
		return enumFlag;
	}

	public void setEnumFlag(String flag) {
		this.enumFlag = Flags.valueOf(flag);
	}

	@Override
	public String toString() {
		return "Application [id=" + id + ", firstName=" + firstName + ", secondName=" + secondName + ", department="
				+ department + ", id_number=" + id_number + ", pc_number=" + pc_number + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", enumFlag=" + enumFlag + "]"+"\n";
	}


}
