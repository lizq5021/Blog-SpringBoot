package com.songhaozhi.mayday.model.domain;

import java.util.Date;

/**
 * @version 1.0
 * @Auther: 李志强
 * @Date: 2019/4/14 03:50
 * @Description:音乐model
 */
public class Music {
    private Integer mId;

    /**
     * 标题
     */
    private String mTitle;

    /**
     * 作者
     */
    private String mAuthor;

    /**
     * 歌曲链接
     */
    private String mUrl;

    /**
     * 图片链接
     */
    private String mPic;

    /**
     * 歌词
     */
    private String mLrc;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmAuthor() {
        return mAuthor;
    }

    public void setmAuthor(String mAuthor) {
        this.mAuthor = mAuthor;
    }

    public String getmUrl() {
        return mUrl;
    }

    public void setmUrl(String mUrl) {
        this.mUrl = mUrl;
    }

    public String getmPic() {
        return mPic;
    }

    public void setmPic(String mPic) {
        this.mPic = mPic;
    }

    public String getmLrc() {
        return mLrc;
    }

    public void setmLrc(String mLrc) {
        this.mLrc = mLrc;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Music{" +
                "mId=" + mId +
                ", mTitle='" + mTitle + '\'' +
                ", mAuthor='" + mAuthor + '\'' +
                ", mUrl='" + mUrl + '\'' +
                ", mPic='" + mPic + '\'' +
                ", mLrc='" + mLrc + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
