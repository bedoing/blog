package org.bedoing.vo;

import lombok.Data;

/**
 * Created by ken on 11/1/2016.
 */
@Data
public class SubjectVO {

    private Integer subjectId;

    private Integer articleId;

    private int difficulty;

    private int timeLimit;

    private int memoryLimit;

    private String otherLimit;
}
