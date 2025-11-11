package jp.co.sss.crud.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.util.ConstantSQL;

public class EmployeeDAO implements IEmployeeDAO {

    @Override
    public List<Employee> findAllEmployee() throws SQLException, ClassNotFoundException {
        List<Employee> employeeList = new ArrayList<>();
        try (Connection connection = DBManager.getConnection();
             PreparedStatement ps = connection.prepareStatement(ConstantSQL.SQL_ALL_SELECT);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Employee emp = new Employee(
                        rs.getInt("emp_id"),
                        rs.getString("emp_name"),
                        rs.getInt("gender"),
                        rs.getDate("birthday"),
                        rs.getInt("dept_id")
                );
                employeeList.add(emp);
            }
        }
        return employeeList;
    }

    @Override
    public Employee findEmployeeById(int employeeId) throws SQLException, ClassNotFoundException {
        Employee emp = null;
        try (Connection connection = DBManager.getConnection();
             PreparedStatement ps = connection.prepareStatement(ConstantSQL.SQL_SELECT_BASIC)) {

            ps.setInt(1, employeeId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    emp = new Employee(
                            rs.getInt("emp_id"),
                            rs.getString("emp_name"),
                            rs.getInt("gender"),
                            rs.getDate("birthday"),
                            rs.getInt("dept_id")
                    );
                }
            }
        }
        return emp;
    }

    @Override
    public List<Employee> findEmployeeByName(String name) throws SQLException, ClassNotFoundException {
        List<Employee> employeeList = new ArrayList<>();
        try (Connection connection = DBManager.getConnection();
             PreparedStatement ps = connection.prepareStatement(ConstantSQL.SQL_SELECT_BY_EMP_NAME)) {

            ps.setString(1, "%" + name + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Employee emp = new Employee(
                            rs.getInt("emp_id"),
                            rs.getString("emp_name"),
                            rs.getInt("gender"),
                            rs.getDate("birthday"),
                            rs.getInt("dept_id")
                    );
                    employeeList.add(emp);
                }
            }
        }
        return employeeList;
    }

    @Override
    public List<Employee> findEmployeeByDepartmentId(String departmentId) throws SQLException, ClassNotFoundException {
        List<Employee> employeeList = new ArrayList<>();
        try (Connection connection = DBManager.getConnection();
             PreparedStatement ps = connection.prepareStatement(ConstantSQL.SQL_SELECT_BY_DEPT_ID)) {

            ps.setInt(1, Integer.parseInt(departmentId));
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Employee emp = new Employee(
                            rs.getInt("emp_id"),
                            rs.getString("emp_name"),
                            rs.getInt("gender"),
                            rs.getDate("birthday"),
                            rs.getInt("dept_id")
                    );
                    employeeList.add(emp);
                }
            }
        }
        return employeeList;
    }

    @Override
    public int insertEmployee(Employee employee) throws SQLException, ClassNotFoundException {
        int result = 0;
    	try (Connection connection = DBManager.getConnection();
             PreparedStatement ps = connection.prepareStatement(ConstantSQL.SQL_INSERT)) {

            ps.setString(1, employee.getEmployeeName());
            ps.setInt(2, employee.getGender());
            ps.setDate(3, new java.sql.Date(employee.getBirthday().getTime()));
            ps.setInt(4, employee.getDepartmentId());
            //実行件数を受け取る
            result = ps.executeUpdate();
        }
    	return result;
    }

    @Override
    public int updateEmployee(Employee employee) throws SQLException, ClassNotFoundException {
        int result = 0;
    	try (Connection connection = DBManager.getConnection();
             PreparedStatement ps = connection.prepareStatement(ConstantSQL.SQL_UPDATE)) {

            ps.setString(1, employee.getEmployeeName());
            ps.setInt(2, employee.getGender());
            ps.setDate(3, new java.sql.Date(employee.getBirthday().getTime()));
            ps.setInt(4, employee.getDepartmentId());
            ps.setInt(5, employee.getEmployeeId());
            result = ps.executeUpdate();
        }
    	return result;
    }

    @Override
    public void deleteEmployee(int employeeId) throws SQLException, ClassNotFoundException {
        try (Connection connection = DBManager.getConnection();
             PreparedStatement ps = connection.prepareStatement(ConstantSQL.SQL_DELETE)) {

            ps.setInt(1, employeeId);
            ps.executeUpdate();
        }
    }
}
