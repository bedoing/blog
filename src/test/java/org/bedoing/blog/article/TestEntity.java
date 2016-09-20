package org.bedoing.blog.article;

import lombok.Data;

/**
 * Created by ejiggun on 9/20/2016.
 */
@Data
public class TestEntity {
    private int articleId;
    private String title;
    private int articleType; // 1.article  2.subject
    private String summary;
    private String content;
}
