package jp.co.sss.crud.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

import jp.co.sss.crud.util.ConstantMSG;

public class Employee {

	private int employeeId;
	private String employeeName;
	private int gender;
	private Date birthday;
	private int departmentId;
	private Department department;
	

	//---コンストラクタ

	public Employee() {

	}

	public Employee(int employeeId,String employeeName,int gender,Date birthday,int departmentId) {
		setEmployeeId(employeeId);
		setEmployeeName(employeeName);
		setGender(gender);
		setBirthday(birthday);
		setDepartmentId(departmentId);
		
	}
	
	public Employee(int employeeId,String employeeName,int gender,Date birthday,int departmentId,Department department) {
		setEmployeeId(employeeId);
		setEmployeeName(employeeName);
		setGender(gender);
		setBirthday(birthday);
		setDepartmentId(departmentId);
		setDepartment(department);
		
		
	}

	//--setter/getter

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	

	//---コンソール表示用

	  public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	// 表示用に加工して返す
    @Override
    public String toString() {
        String genderText;
        switch (gender) {
            case 1: genderText = ConstantMSG.GENDER_MALE; break;
            case 2: genderText = ConstantMSG.GENDER_FEMALE; break;
            case 9: genderText = ConstantMSG.GENDER_OTHER; break;
            default: genderText = ConstantMSG.GENDER_NONE;
        }

        String deptName;
        switch (departmentId) {
            case 1: deptName = "営業部"; break;
            case 2: deptName = "経理部"; break;
            case 3: deptName = "総務部"; break;
            default: deptName = "-";
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String birthdayStr = birthday != null ? sdf.format(birthday) : "-";

        return employeeId + "\t" + employeeName + "\t" + genderText + "\t" + birthdayStr + "\t" + deptName;
    }
}
