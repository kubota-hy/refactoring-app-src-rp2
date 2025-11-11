package jp.co.sss.crud.io;

import static jp.co.sss.crud.util.ConstantMSG.*;

import jp.co.sss.crud.dto.Employee;

/**
 * コンソール出力を統一管理するクラス。
 * メッセージ、一覧表、エラー表示などの責務を持つ。
 */
public class ConsoleWriter {

    /**
     * 通常メッセージを出力
     * 
     * @param message 出力文字列
     */
    public void printLine(String message) {
        System.out.println(message);
    }

    /**
     * 空行を出力
     */
    public void printBlank() {
        System.out.println();
    }

    /**
     * 区切り線を出力
     */
    public void printLine() {
        System.out.println("--------------------------------------------");
    }

    /**
     * エラーメッセージを出力
     * 
     * @param errorMsg エラー内容
     */
    public void printError(String errorMsg) {
        System.err.println("[ERROR] " + errorMsg);
    }

    /**
     * 社員情報テーブルのヘッダーを出力
     */
    public void printHeader() {
        System.out.println(EMPLOYEE_HEADER);
    }

    /**
     * 社員情報1件を整形して出力
     * 
     * @param emp 社員情報
     */
    public void printEmployee(Employee emp) {
        // 性別を文字列に変換
        String genderStr;
        switch (emp.getGender()) {
            case 1 -> genderStr = GENDER_MALE;
            case 2 -> genderStr = GENDER_FEMALE;
            case 9 -> genderStr = GENDER_OTHER;
            default -> genderStr = GENDER_NONE;
        }

        String deptName = (emp.getDepartment() != null)
                ? emp.getDepartment().getDepartmentName()
                : "部署未登録";



        // 整形して出力
        System.out.printf("%d\t%s\t%s\t%s\t%s%n",
                emp.getEmployeeId(),
                emp.getEmployeeName(),
                genderStr,
                emp.getBirthday(),
                deptName);
    }
    
    /**
     * メニューを出力する
     */
    public void printMenu() {
        System.out.println(MENU_TITLE);
        System.out.println(MENU_ALL_DISPLAY);
        System.out.println(MENU_SEARCH_BY_NAME);
        System.out.println(MENU_SEARCH_BY_DEPT);
        System.out.println(MENU_INSERT);
        System.out.println(MENU_UPDATE);
        System.out.println(MENU_DELETE);
        System.out.println(MENU_EXIT);
    }
}
