package jp.co.sss.crud.dto;

public class Department {
	
	private int departmentId;
	private String departmentName;
	
	//---コンストラクタ
	public Department() {
		
	}
	
	//---setter/getter
	
	public Department(int departmentId,String departmentName) {
		setDepartmentId(departmentId);
		setDepartmentName(departmentName);
		
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId2) {
		this.departmentId = departmentId2;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	//コンソール表示用
	
	@Override
	public String toString() {
		
		return departmentId + "\t" + departmentName;
	}
	
	
	

}
