package org.cynerds.mgb.model;

public class Test {
    private Integer id;
    private String msg;
    private String createDate;

    public Integer getId() {
        return id;
    }

    public Test setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public Test setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public String getCreateDate() {
        return createDate;
    }

    public Test setCreateDate(String createDate) {
        this.createDate = createDate;
        return this;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", createDate='" + createDate + '\'' +
                '}';
    }
}
