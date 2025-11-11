package jp.co.sss.crud.io;

/**
 * 部署ID入力専用Readerクラス
 * <p>
 * 1〜3の範囲の整数値を受け付ける。
 */
public class EmployeeDeptIdReader implements IConsoleReader {

    @Override
    public String getErrorMsg() {
        return "部署IDは1〜3の範囲で入力してください。";
    }

    @Override
    public boolean isValid(String inputString) {
        try {
            int id = Integer.parseInt(inputString);
            return id >= 1 && id <= 3;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public boolean isParseInt() {
        return true;
    }
}
