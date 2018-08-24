package org.cynerds.mgb.model;

public class User {
    private String userId;
    private String nickname;
    private String createDate;
    private String updater;
    private String updateDate;

    public String getUserId() {
        return userId;
    }

    public User setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getNickname() {
        return nickname;
    }

    public User setNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public String getCreateDate() {
        return createDate;
    }

    public User setCreateDate(String createDate) {
        this.createDate = createDate;
        return this;
    }

    public String getUpdater() {
        return updater;
    }

    public User setUpdater(String updater) {
        this.updater = updater;
        return this;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public User setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", nickname='" + nickname + '\'' +
                ", createDate='" + createDate + '\'' +
                ", updater='" + updater + '\'' +
                ", updateDate='" + updateDate + '\'' +
                '}';
    }
}
