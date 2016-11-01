package org.bedoing.vo;

import lombok.Data;

/**
 * Created by ken on 11/1/2016.
 */
@Data
public class SubjectVO {

    private int subjectId;

    private int articleId;

    private int difficulty;

    private int timeLimit;

    private int memoryLimit;

    private String otherLimit;
}
