package jp.co.sss.crud.io;

public class EmployeeEmpIdReader implements IConsoleReader {

    @Override
    public String getErrorMsg() {
        return "社員IDは半角数字で入力してください。";
    }

    @Override
    public boolean isValid(String inputString) {
        // 半角数字のみ許可
        return inputString != null && inputString.matches("\\d+");
    }

    @Override
    public boolean isParseInt() {
        return true;
    }
}
