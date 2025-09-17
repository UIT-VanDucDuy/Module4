package com.example.bt3.Service;

import com.example.bt3.Entity.Mail;
import com.example.bt3.Repo.IMailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailService implements IMailService {
    @Autowired
    private IMailRepo mailRepo;

    @Override
    public Mail getInfo() {
        return mailRepo.getInfo();
    }

    @Override
    public boolean updateInfo(Mail mail) {
        return mailRepo.updateInfo(mail);
    }
}
