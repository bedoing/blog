package org.bedoing.blog.article;

/**
 * Created by ejiggun on 9/20/2016.
 */
public class Test {
    public static void main(String[] args) {
        TestEntity te = new TestEntity();
        te.setArticleId(12);
        te.setContent("content...");
        System.out.printf(te.toString());
    }
}
