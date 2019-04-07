package com.atos.feedback.service;

public interface MailService {
	void sentMail(String to, String subject, String content);
}
