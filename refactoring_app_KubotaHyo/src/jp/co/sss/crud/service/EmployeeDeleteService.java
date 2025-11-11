package jp.co.sss.crud.service;

import java.sql.SQLException;

import jp.co.sss.crud.db.EmployeeDAO;
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
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    public void execute() throws ClassNotFoundException, SQLException {
        try {
            writer.printLine("社員IDを入力してください：");
            Integer empId = (Integer) reader.input();

            jp.co.sss.crud.dto.Employee employee = dao.findEmployeeById(empId);

            if (employee == null) {
                writer.printError("該当する社員は存在しません。");
            } else {
                dao.deleteEmployee(empId);
                writer.printLine("社員ID " + empId + " の情報を削除しました。");
            }

        } catch (IllegalInputException e) {
            writer.printError(e.getMessage());
        } catch (SystemErrorException e) {
            writer.printError("システムエラーが発生しました。");
        }

        writer.printBlank();
        writer.printLine("再びメニューを表示します。");
    }
}
