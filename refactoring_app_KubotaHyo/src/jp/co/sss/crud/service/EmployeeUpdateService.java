package jp.co.sss.crud.service;

import static jp.co.sss.crud.util.ConstantMSG.*;

import java.sql.SQLException;
import java.util.Optional;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.db.IEmployeeDAO;
import jp.co.sss.crud.dto.Department;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.EmployeeBirthReader;
import jp.co.sss.crud.io.EmployeeDeptIdReader;
import jp.co.sss.crud.io.EmployeeEmpIdReader;
import jp.co.sss.crud.io.EmployeeGenderReader;
import jp.co.sss.crud.io.EmployeeNameReader;
import jp.co.sss.crud.io.IConsoleReader;

/**
 * 社員情報更新サービスクラス
 */
public class EmployeeUpdateService implements IEmployeeService {

    @Override
    public void execute() throws SystemErrorException, IllegalInputException, ClassNotFoundException {
        ConsoleWriter writer = new ConsoleWriter();
        IEmployeeDAO dao = new EmployeeDAO();

        IConsoleReader idReader = new EmployeeEmpIdReader();
        IConsoleReader nameReader = new EmployeeNameReader();
        IConsoleReader genderReader = new EmployeeGenderReader();
        IConsoleReader birthReader = new EmployeeBirthReader();
        IConsoleReader deptReader = new EmployeeDeptIdReader();

        try {
            // 更新対象の社員ID入力
            System.out.print(INPUT_UPDATE_EMP_ID);
            int empId = (Integer) idReader.input();

            // 該当社員の存在確認
            Optional<Employee> empOpt = Optional.ofNullable(dao.findEmployeeById(empId));
            if (empOpt.isEmpty()) {
                writer.printLine(NO_RECORD_FOUND);
                return;
            }

            // 更新情報の入力
            System.out.print(INPUT_EMP_NAME);
            String name = (String) nameReader.input();

            System.out.print(INPUT_GENDER);
            int gender = (Integer) genderReader.input();

            System.out.print(INPUT_BIRTHDAY);
            String birthdayStr = (String) birthReader.input();

            System.out.print(INPUT_DEPT_ID);
            int deptId = (Integer) deptReader.input();

            // Employee作成
            Department dept = new Department();
            dept.setDepartmentId(deptId);

            Employee emp = empOpt.get();
            emp.setEmployeeName(name);
            emp.setGender(gender);
            emp.setBirthday(java.sql.Date.valueOf(birthdayStr));
            emp.setDepartment(dept);

            // DAO呼び出し
            int result = dao.updateEmployee(emp);

            if (result > 0) {
                writer.printLine(UPDATE_COMPLETE);
            } else {
                writer.printLine(NO_RECORD_FOUND);
            }

        } catch (SQLException e) {
            throw new SystemErrorException(MSG_SYSTEM_ERROR, e);
        }
    }
}
