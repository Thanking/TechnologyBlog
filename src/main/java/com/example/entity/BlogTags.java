package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * <p>
 *
 * </p>
 *
 * @author LSD
 * @since 2021-07-23
 */
@Data
@TableName("t_blog_tags")
public class BlogTags implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type= IdType.AUTO)
    private Integer id;

    private Long tagId;

    private Long blogId;

    public BlogTags() {
    }

    public BlogTags(Integer id, Long tagId, Long blogId) {
        this.id = id;
        this.tagId = tagId;
        this.blogId = blogId;
    }

    @Override
    public String toString() {
        return "BlogTags{" +
                "id=" + id +
                ", tagId=" + tagId +
                ", blogId='" + blogId + '\'' +
                '}';
    }
}
