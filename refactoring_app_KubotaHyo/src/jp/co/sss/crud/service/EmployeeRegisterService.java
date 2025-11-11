package jp.co.sss.crud.service;

import static jp.co.sss.crud.util.ConstantMSG.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.db.IEmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.EmployeeBirthReader;
import jp.co.sss.crud.io.EmployeeDeptIdReader;
import jp.co.sss.crud.io.EmployeeGenderReader;
import jp.co.sss.crud.io.EmployeeNameReader;
import jp.co.sss.crud.io.IConsoleReader;

/**
 * 社員情報登録サービスクラス
 */
public class EmployeeRegisterService implements IEmployeeService {

    @Override
    public void execute() throws SystemErrorException, IllegalInputException, ClassNotFoundException {
        IEmployeeDAO dao = new EmployeeDAO();
        ConsoleWriter writer = new ConsoleWriter();

        // 各Readerの準備
        IConsoleReader nameReader = new EmployeeNameReader();
        IConsoleReader genderReader = new EmployeeGenderReader();
        IConsoleReader birthReader = new EmployeeBirthReader();
        IConsoleReader deptReader = new EmployeeDeptIdReader();

        // 社員名入力
        System.out.print(INPUT_EMP_NAME);
        String name = (String) nameReader.input();

        // 性別入力
        System.out.print(INPUT_GENDER);
        int gender = (Integer) genderReader.input();

        // 生年月日入力（yyyy/MM/dd形式）
        System.out.print(INPUT_BIRTHDAY);
        String birth = (String) birthReader.input();

        // 「yyyy/MM/dd」→ LocalDate → java.sql.Date に変換
        java.time.format.DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate localBirth = LocalDate.parse(birth, fmt);
        java.sql.Date birthDate = java.sql.Date.valueOf(localBirth);

        // 部署ID入力
        System.out.print(INPUT_DEPT_ID);
        int deptId = (Integer) deptReader.input();

        // DTO作成
        Employee emp = new Employee();
        emp.setEmployeeName(name);
        emp.setGender(gender);
        emp.setBirthday(birthDate);
        emp.setDepartmentId(deptId);

        // DAO登録処理
        try {
            int count = dao.insertEmployee(emp);
            if (count > 0) {
                writer.printLine(INSERT_COMPLETE);
            } else {
                writer.printLine(INSERT_FAIL);
            }
        } catch (SQLException e) {
            throw new SystemErrorException(MSG_SYSTEM_ERROR, e);
        }
    }
}
