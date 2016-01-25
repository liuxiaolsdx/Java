package com.liuxiao.blog.entity;

import lombok.Data;

import java.sql.Timestamp;

/**
 * Posts
 * Created by Sean on 16/1/25.
 */
@Data
public class Posts {

    private int id;

    private int userId;

    private Timestamp createTime;

    private Timestamp updateTime;

    private String title;

    private String content;

    private String renderedContent;

    private String permalink;

    private String postFormat;

    private String postStatus;

    private String postType;

}
