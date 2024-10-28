package com.gila.business;

public interface Notification {

	void send(String message) throws CannotSendMessageException;
}
