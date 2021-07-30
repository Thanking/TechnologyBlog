package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * <p>
 *
 * </p>
 *
 * @author LSD
 * @since 2021-07-23
 */
@Data
@TableName("t_blog")
public class Blog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type= IdType.AUTO)
    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 首图
     */
    private String firstPicture;

    /**
     * 标记
     */
    private String flag;

    /**
     * 浏览次数
     */
    private Integer views;

    /**
     * 赞赏
     */
    private Boolean appreciation;

    /**
     * 转载声明
     */
    private Boolean shareStatement;

    /**
     * 评论
     */
    private Boolean commentabled;

    /**
     * 发布
     */
    private Boolean published;

    /**
     * 推荐
     */
    private Boolean recommend;

    /**
     * 创建时间
     */

    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 分类id
     */
    private Long typeId;

    /**
     * 拥有者id
     */
    private Long userId;

    /**
     * 文章描述
     */
    private String description;

    /**
     * 标签id
     */
    private String tagIds;


    public Blog() {
    }

    public Blog(Long id, String title, String content, String firstPicture, String flag, Integer views, Boolean appreciation, Boolean shareStatement, Boolean commentabled, Boolean published, Boolean recommend, LocalDateTime createTime, LocalDateTime updateTime, Long typeId, Long userId, String description, String tagIds) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.firstPicture = firstPicture;
        this.flag = flag;
        this.views = views;
        this.appreciation = appreciation;
        this.shareStatement = shareStatement;
        this.commentabled = commentabled;
        this.published = published;
        this.recommend = recommend;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.typeId = typeId;
        this.userId = userId;
        this.description = description;
        this.tagIds = tagIds;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", firstPicture='" + firstPicture + '\'' +
                ", flag='" + flag + '\'' +
                ", views=" + views +
                ", appreciation=" + appreciation +
                ", shareStatement=" + shareStatement +
                ", commentabled=" + commentabled +
                ", published=" + published +
                ", recommend=" + recommend +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", typeId=" + typeId +
                ", userId=" + userId +
                ", description='" + description + '\'' +
                ", tagIds='" + tagIds + '\'' +
                '}';
    }
}
