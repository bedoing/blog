package org.bedoing.commons;

public enum SortType2 {
    AESC(false), DESC(true);

    boolean reverse;

    SortType2(boolean reverse) {
        this.reverse = reverse;
    }

    public boolean isReverse() {
        return reverse;
    }
}