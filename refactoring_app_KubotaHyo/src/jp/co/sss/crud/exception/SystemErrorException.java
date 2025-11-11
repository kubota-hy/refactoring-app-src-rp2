package jp.co.sss.crud.exception;

/**
 * システムレベルのエラーを表す独自例外
 */
public class SystemErrorException extends Exception {

    // コンストラクタ（メッセージのみ）
    public SystemErrorException(String message) {
        super(message);
    }

    // コンストラクタ（メッセージ + 原因の例外）
    public SystemErrorException(String message, Throwable cause) {
        super(message, cause);
    }
}
