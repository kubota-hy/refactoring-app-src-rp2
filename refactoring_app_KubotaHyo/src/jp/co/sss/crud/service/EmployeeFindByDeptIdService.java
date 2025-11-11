package jp.co.sss.crud.service;

import static jp.co.sss.crud.util.ConstantMSG.*;

import java.sql.SQLException;
import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.db.IEmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.EmployeeDeptIdReader;
import jp.co.sss.crud.io.IConsoleReader;

/**
 * 部署ID検索サービスクラス
 */
public class EmployeeFindByDeptIdService implements IEmployeeService {

    @Override
    public void execute() throws SystemErrorException, IllegalInputException, ClassNotFoundException {
        IEmployeeDAO dao = new EmployeeDAO();
        IConsoleReader reader = new EmployeeDeptIdReader();
        ConsoleWriter writer = new ConsoleWriter();

        // 部署ID入力
        System.out.print(INPUT_DEPT_ID);
        String deptId = (String) reader.input();

        try {
            // 検索実行
            List<Employee> empList = dao.findEmployeeByDepartmentId(deptId);

            if (empList.isEmpty()) {
                writer.printLine(NO_RECORD_FOUND);
            } else {
                writer.printLine("部署ID " + deptId + " に所属する社員一覧：");
                writer.printHeader();
                for (Employee emp : empList) {
                    writer.printEmployee(emp);
                }
            }

        } catch (SQLException e) {
            throw new SystemErrorException(MSG_SYSTEM_ERROR, e);
        }
    }
}
