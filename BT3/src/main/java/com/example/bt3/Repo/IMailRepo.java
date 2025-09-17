package com.example.bt3.Repo;

import com.example.bt3.Entity.Mail;

public interface IMailRepo {
    Mail getInfo();
    boolean updateInfo(Mail mail);
}
