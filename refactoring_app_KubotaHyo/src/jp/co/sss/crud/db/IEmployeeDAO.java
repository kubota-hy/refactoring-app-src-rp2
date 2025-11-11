package jp.co.sss.crud.db;

import java.sql.SQLException;
import java.util.List;

import jp.co.sss.crud.dto.Employee;

/*
 * 社員情報(Employee)に関するデータアクセス処理を定義するインターフェース
 */
public interface IEmployeeDAO {
	
	List<Employee> findAllEmployee() throws SQLException, ClassNotFoundException;
	
	Employee findEmployeeById(int employeeId)throws SQLException, ClassNotFoundException;
	
	List<Employee> findEmployeeByName(String name) throws SQLException, ClassNotFoundException;
	
	List<Employee> findEmployeeByDepartmentId(String departmentId) throws SQLException, ClassNotFoundException;
	
	int insertEmployee(Employee employee)throws SQLException, ClassNotFoundException;
	
	int updateEmployee(Employee employee)throws SQLException, ClassNotFoundException;
	
	void deleteEmployee(int employeeId)throws SQLException, ClassNotFoundException;
}
