package part01;

public enum Department {
	ELECTRICAL(0), 
	PHOTOGRAPHIC(1), 
	COMPUTING(2), 
	BOOKS(3), 
	MUSIC(4), 
	FASHION(5), 
	OTHER(6);
	
	private String spelling[] = {"Electrical", "Photographic", "Computing", "Books", "Music", "Fashion", "Other"};
	
	private int index;
	private Department(int num) {
		index = num;
	}
	
	private String getDept() {
		return spelling[index];
	}
	
	public String toString() {
		return getDept();
	}
}
