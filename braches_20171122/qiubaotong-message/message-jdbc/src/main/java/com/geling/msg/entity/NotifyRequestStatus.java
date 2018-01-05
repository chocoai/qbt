package com.geling.msg.entity;

public enum NotifyRequestStatus {

	IN_PROCESS(0),SUCCESS(1),FAILED_RETRYING(2),FAILED(3);
	
	private int value;

	NotifyRequestStatus(int value){
		this.value = value;
	}
	
	public int value(){
		return this.value;
	}
	
	
	public NotifyRequestStatus fromInt(int value){
		switch (value) {
		case 0:
			return IN_PROCESS;
		case 1:
			return SUCCESS;
		case 2:
			return FAILED_RETRYING;
		case 3:
			return FAILED;
		}
		return null;
	}
}
