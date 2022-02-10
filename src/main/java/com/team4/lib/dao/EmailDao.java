package com.team4.lib.dao;

import com.team4.lib.model.MailDto;

public interface EmailDao {

  void sendEmail(MailDto email);
}
