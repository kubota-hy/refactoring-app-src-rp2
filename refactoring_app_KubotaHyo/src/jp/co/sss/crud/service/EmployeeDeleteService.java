package jp.co.sss.crud.service;

import static jp.co.sss.crud.util.ConstantMSG.*;

import java.sql.SQLException;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.EmployeeEmpIdReader;

/**
 * 社員削除処理を行うサービスクラス
 */
public class EmployeeDeleteService implements IEmployeeService {

    private final ConsoleWriter writer = new ConsoleWriter();
    private final EmployeeDAO dao = new EmployeeDAO();
    private final EmployeeEmpIdReader reader = new EmployeeEmpIdReader();

    /**
     * 社員削除処理
     */
    @Override
    public void execute() throws ClassNotFoundException, SQLException {
        try {
            // 入力促進
            writer.printLine(INPUT_DELETE_EMP_ID);
            Integer empId = (Integer) reader.input();

            // 対象社員検索
            Employee employee = dao.findEmployeeById(empId);

            if (employee == null) {
                writer.printError(NO_RECORD_FOUND);
            } else {
                dao.deleteEmployee(empId);
                writer.printLine(DELETE_COMPLETE + "（社員ID: " + empId + "）");
            }

        } catch (IllegalInputException e) {
            writer.printError(e.getMessage());
        } catch (SystemErrorException e) {
            writer.printError(MSG_SYSTEM_ERROR);
        }

        writer.printBlank();
        writer.printLine("再びメニューを表示します。");
    }
}
