package backlog4j.admin.impl;

import backlog4j.admin.MailSetting;

import java.util.Map;

/**
 * @author eguchi
 */
public final class MailSettingImpl implements MailSetting {

    private final Boolean mail;
    private final Boolean comment;


    public MailSettingImpl(Map<String, Object> map) {

        mail = (Boolean) map.get("mail");
        comment = (Boolean) map.get("comment");

    }

    public static MailSetting create(Map<String, Object> map) {
        return map == null ? null : new MailSettingImpl(map);
    }

    @Override
    public Boolean isMail() {
        return mail;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Boolean isComment() {
        return comment;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String toString() {
        return "MailSettingImpl{" +
                "mail=" + mail +
                ", comment=" + comment +
                '}';
    }
}
