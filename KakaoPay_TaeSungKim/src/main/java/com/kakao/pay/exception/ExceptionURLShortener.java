package com.kakao.pay.exception;


public class ExceptionURLShortener extends Exception {
	public enum ExceptionLevel{
		NONE, ERROR, WARRING, IGNONE
	}
	public enum ErrorCode{
		U001, U002, U003, U004
	}
	protected ExceptionLevel level;
	
	protected Exception e;

	public ExceptionURLShortener(ErrorCode code) {
		super(getMessage(code));

		switch(code) {
		case U001 : level = ExceptionLevel.IGNONE; break;
		case U002 : level = ExceptionLevel.IGNONE; break;
		case U003 : level = ExceptionLevel.ERROR; break;
		case U004 : level = ExceptionLevel.WARRING; break;
		}
		errorAction();
	}
	
	private void errorAction() {
		
	}
	
	private static String getMessage(ErrorCode code) {
		StringBuffer result = new StringBuffer();
		switch(code) {
		case U001 : result.append("비정상적인 주소입니다."); break;
		case U002 : result.append("변환 가능한 주소가 없습니다."); break;
		case U003 : result.append("에러수준에 예외상황"); break;
		case U004 : result.append("워링상황의 예외상황"); break;
		}
		return result.toString();
	}
}
