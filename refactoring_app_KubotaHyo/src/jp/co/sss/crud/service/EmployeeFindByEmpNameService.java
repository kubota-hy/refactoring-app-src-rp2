package jp.co.sss.crud.service;

import java.sql.SQLException;
import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.EmployeeNameReader;
import jp.co.sss.crud.io.IConsoleReader;
import jp.co.sss.crud.util.ConstantMSG;

/**
 * 社員名による検索を行うサービスクラス
 */
public class EmployeeFindByEmpNameService implements IEmployeeService {

    @Override
    public void execute() throws SystemErrorException, IllegalInputException, ClassNotFoundException, SQLException {
        IConsoleReader reader = new EmployeeNameReader();
        ConsoleWriter writer = new ConsoleWriter();
        EmployeeDAO dao = new EmployeeDAO();

        // 入力受付
        System.out.print(ConstantMSG.INPUT_EMP_NAME);
        String empName = (String) reader.input();

        // 検索実行
        List<Employee> employees = dao.findEmployeeByName(empName);

        // 結果出力
        if (employees == null || employees.isEmpty()) {
            writer.printLine(ConstantMSG.NO_RECORD_FOUND);
        } else {
            writer.printLine(ConstantMSG.EMPLOYEE_HEADER);
            for (Employee emp : employees) {
                writer.printLine(emp.toString());
            }
        }

        writer.printLine(""); // 改行
    }
}
