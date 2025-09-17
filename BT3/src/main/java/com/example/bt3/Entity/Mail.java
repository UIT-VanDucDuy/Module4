package com.example.bt3.Entity;

public class Mail {
    private String language;
    private int pageSize;
    private boolean spamFilter;
    private String signature;
    public Mail() {}

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setSpamFilter(boolean spamFilter) {
        this.spamFilter = spamFilter;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Mail(String language, int pagesize, boolean spamFilter, String signature) {
        this.language = language;
        this.pageSize = pagesize;
        this.spamFilter = spamFilter;
        this.signature = signature;
    }

    public String getLanguage() {
        return language;
    }

    public int getPageSize() {
        return pageSize;
    }

    public boolean isSpamFilter() {
        return spamFilter;
    }

    public String getSignature() {
        return signature;
    }
}
