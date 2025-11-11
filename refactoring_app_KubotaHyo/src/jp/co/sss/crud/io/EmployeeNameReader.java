package jp.co.sss.crud.io;

public class EmployeeNameReader implements IConsoleReader {

    @Override
    public String getErrorMsg() {
        return "1文字以上30文字以内の社員名を入力してください。";
    }

    @Override
    public boolean isValid(String inputString) {
        return inputString != null && !inputString.isBlank() && inputString.length() <= 30;
    }

    @Override
    public boolean isParseInt() {
        return false; // 文字列なのでfalse
    }
}
