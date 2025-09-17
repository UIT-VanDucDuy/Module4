package com.example.bt3.Repo;

import com.example.bt3.Entity.Mail;
import org.springframework.stereotype.Repository;

@Repository
public class MailRepo implements IMailRepo {
    private static Mail mail = new Mail();

    @Override
    public Mail getInfo() {
        return mail;
    }

    @Override
    public boolean updateInfo(Mail mailUpdate) {
        if (mailUpdate == null) {
            return false;
        }
        mail.setLanguage(mailUpdate.getLanguage());
        mail.setPageSize(mailUpdate.getPageSize());
        mail.setSpamFilter(mailUpdate.isSpamFilter());
        mail.setSignature(mailUpdate.getSignature());
        return true;
    }
}
