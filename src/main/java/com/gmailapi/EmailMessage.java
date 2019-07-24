package com.gmailapi;

public class EmailMessage {
    private String fromEMailAddr;
    private String toEmailAddr;
    private String msgSubject;
    private String msgContent;

    public EmailMessage(String fromEMailAddr, String toEmailAddr,
                        String msgSubject, String msgContent) {
        this.fromEMailAddr = fromEMailAddr;
        this.toEmailAddr = toEmailAddr;
        this.msgSubject = msgSubject;
        this.msgContent = msgContent;
    }

    public String getFromEMailAddr() {
        return fromEMailAddr;
    }

    public void setFromEMailAddr(String fromEMailAddr) {
        this.fromEMailAddr = fromEMailAddr;
    }

    public String getToEmailAddr() {
        return toEmailAddr;
    }

    public void setToEmailAddr(String toEmailAddr) {
        this.toEmailAddr = toEmailAddr;
    }

    public String getMsgSubject() {
        return msgSubject;
    }

    public void setMsgSubject(String msgSubject) {
        this.msgSubject = msgSubject;
    }

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }

    @Override
    public String toString() {
        return	"From: " + fromEMailAddr + "\n" +
                "To: " + toEmailAddr +  "\n" +
                "Subject: " + msgSubject +  "\n" +
                "\n" +
                msgContent;
    }
}

