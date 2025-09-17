package com.example.bt3.Service;


import com.example.bt3.Entity.Mail;

public interface IMailService {
    Mail getInfo();
    boolean updateInfo(Mail mail);
}
