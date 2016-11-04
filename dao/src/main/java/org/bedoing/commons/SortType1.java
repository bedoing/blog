package org.bedoing.commons;

public enum SortType1 {
    AESC(false), DESC(true);

    boolean reverse;

    SortType1(boolean reverse) {
        this.reverse = reverse;
    }

    public boolean isReverse() {
        return reverse;
    }
}