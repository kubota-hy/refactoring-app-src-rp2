package jp.co.sss.crud.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.util.ConstantColumn;
import jp.co.sss.crud.util.ConstantSQL;

/**
 * 社員テーブルへのアクセスを行うDAOクラス
 */
public class EmployeeDAO implements IEmployeeDAO {

    /**
     * 全件検索
     */
    @Override
    public List<Employee> findAllEmployee() throws SQLException, ClassNotFoundException {
        List<Employee> employees = new ArrayList<>();

        try (Connection conn = DBManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(ConstantSQL.SQL_ALL_SELECT);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                employees.add(mapResultSetToEmployee(rs));
            }
        }
        return employees;
    }

    /**
     * ID指定検索
     */
    @Override
    public Employee findEmployeeById(int employeeId) throws SQLException, ClassNotFoundException {
        Employee employee = null;

        try (Connection conn = DBManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(ConstantSQL.SQL_SELECT_BASIC)) {

            ps.setInt(1, employeeId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    employee = mapResultSetToEmployee(rs);
                }
            }
        }
        return employee;
    }

    /**
     * 名前検索（部分一致）
     */
    @Override
    public List<Employee> findEmployeeByName(String name) throws SQLException, ClassNotFoundException {
        List<Employee> employees = new ArrayList<>();

        try (Connection conn = DBManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(ConstantSQL.SQL_SELECT_BY_EMP_NAME)) {

            ps.setString(1, "%" + name + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    employees.add(mapResultSetToEmployee(rs));
                }
            }
        }
        return employees;
    }

    /**
     * 部署ID検索
     */
    @Override
    public List<Employee> findEmployeeByDepartmentId(String deptId) throws SQLException, ClassNotFoundException {
        List<Employee> employees = new ArrayList<>();

        try (Connection conn = DBManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(ConstantSQL.SQL_SELECT_BY_DEPT_ID)) {

            ps.setInt(1, Integer.parseInt(deptId));
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    employees.add(mapResultSetToEmployee(rs));
                }
            }
        }
        return employees;
    }

    /**
     * 社員登録
     */
    @Override
    public int insertEmployee(Employee employee) throws SQLException, ClassNotFoundException {
        try (Connection conn = DBManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(ConstantSQL.SQL_INSERT)) {

            ps.setString(1, employee.getEmployeeName()); // emp_name
            ps.setInt(2, employee.getGender());          // gender
            ps.setDate(3, new java.sql.Date(employee.getBirthday().getTime())); // birthday
            ps.setInt(4, employee.getDepartmentId());    // dept_id

            return ps.executeUpdate();
        }
    }

    /**
     * 社員更新
     */
    @Override
    public int updateEmployee(Employee employee) throws SQLException, ClassNotFoundException {
        try (Connection conn = DBManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(ConstantSQL.SQL_UPDATE)) {

            ps.setString(1, employee.getEmployeeName()); // emp_name
            ps.setInt(2, employee.getGender());          // gender
            ps.setDate(3, new java.sql.Date(employee.getBirthday().getTime())); // birthday
            ps.setInt(4, employee.getDepartmentId());    // dept_id
            ps.setInt(5, employee.getEmployeeId());      // emp_id

            return ps.executeUpdate();
        }
    }

    /**
     * 社員削除
     */
    @Override
    public void deleteEmployee(int employeeId) throws SQLException, ClassNotFoundException {
        try (Connection conn = DBManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(ConstantSQL.SQL_DELETE)) {

            ps.setInt(1, employeeId);
            ps.executeUpdate();
        }
    }

    /**
     * ResultSet → Employee 変換共通処理
     */
    private Employee mapResultSetToEmployee(ResultSet rs) throws SQLException {
        return new Employee(
                rs.getInt(ConstantColumn.EMP_ID),
                rs.getString(ConstantColumn.EMP_NAME),
                rs.getInt(ConstantColumn.GENDER),
                rs.getDate(ConstantColumn.BIRTHDAY),
                rs.getInt(ConstantColumn.DEPT_ID)
        );
    }
}
