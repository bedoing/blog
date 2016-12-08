package org.bedoing.constant;

/**
 * Created by ken on 12/7/2016.
 */
public enum TableAttrEnum {
    ID("id"),
    ARTICLE_ID("articleId"),
    CLICKS("clicks"),CLICKS_CLICKS("clicks");

    private String name;

    private TableAttrEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
