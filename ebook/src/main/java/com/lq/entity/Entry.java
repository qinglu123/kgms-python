package com.lq.entity;

/**
 * @BelongsProject: huang
 * @BelongsPackage: com.lq.entity
 * @Author: LuQing
 * @CreateTime: 2023-02-11  21:53
 * @Description: TODO
 * @Version: 1.0
 */
public class Entry {
   Long id;
   Long categoryId;
   String title;
   String summary;
   String uploadUser;
   String createDate;

    public Entry() {
    }

    public Entry(Long id, Long categoryId, String title, String summary, String uploadUser, String createDate) {
        this.id = id;
        this.categoryId = categoryId;
        this.title = title;
        this.summary = summary;
        this.uploadUser = uploadUser;
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "id=" + id +
                ", categoryId=" + categoryId +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", uploadUser='" + uploadUser + '\'' +
                ", createDate=" + createDate +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getUploadUser() {
        return uploadUser;
    }

    public void setUploadUser(String uploadUser) {
        this.uploadUser = uploadUser;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
