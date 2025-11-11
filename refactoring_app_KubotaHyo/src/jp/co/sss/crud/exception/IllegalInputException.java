package jp.co.sss.crud.exception;

public class IllegalInputException extends Exception{
	
	//コンストラクタ(メッセージのみ）
	public IllegalInputException(String message) {
		super(message);
	}
	
	//コンストラクタ(メッセージ+原因の例外)
	public IllegalInputException(String message,Throwable cause) {
		super(message,cause);
	}
	

}
