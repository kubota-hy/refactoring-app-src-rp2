package jp.co.sss.crud.service;

import java.sql.SQLException;
import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.io.ConsoleWriter;

/**
 * 社員情報全件取得処理を行うサービスクラス
 */
public class EmployeeAllFindService implements IEmployeeService {

    private final ConsoleWriter writer = new ConsoleWriter();
    private final EmployeeDAO dao = new EmployeeDAO();

    /**
     * 社員一覧表示処理
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    public void execute() throws ClassNotFoundException, SQLException {
        // DAOから全社員情報を取得
		List<Employee> employeeList = dao.findAllEmployee();

		if (employeeList == null || employeeList.isEmpty()) {
		    writer.printLine("社員情報は登録されていません。");
		} else {
		    writer.printLine("【社員一覧】");
		    writer.printLine("-------------------------------");

		    for (Employee emp : employeeList) {
		        writer.printLine(
		                "社員ID: " + emp.getEmployeeId() +
		                " ／ 氏名: " + emp.getEmployeeName() +
		                " ／ 性別: " + emp.getGender() +
		                " ／ 誕生日: " + emp.getBirthday() +
		                " ／ 部署名: " + emp.getDepartment()
		        );
		    }

		    writer.printLine("-------------------------------");
		}

        writer.printBlank();
        writer.printLine("再びメニューを表示します。");
    }
}
