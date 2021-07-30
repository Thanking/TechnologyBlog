package com.example.vo;

import lombok.Data;

/**
 * @author : LSD
 * @version : 1.0
 * @ClassName : BlogQuery
 * @Description : TODO
 * @date : 2021/7/23 19:52
 **/
@Data
public class BlogQuery {
    private String title;
    private Long typeId;
    private boolean recommend;
}
