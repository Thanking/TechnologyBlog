package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("t_type")
public class Type implements Serializable {

    private static final long serialVersionUID = 1L;



    @TableId(type= IdType.AUTO)
    private Long id;

    /**
     * 分类名
     */
    private String name;

    public Type() {
    }

    public Type(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
