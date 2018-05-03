package com.sexyhair.demoimitationmovie.bean;

import android.text.TextUtils;

import java.io.Serializable;

/**
 * Created by sexyhair on 16/12/15.
 */

public class NewsSort implements Serializable {
    private Integer id;
    private String sortName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSortName() {
        if (TextUtils.isEmpty(sortName)) {
            return "";
        }
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NewsSort newsSort = (NewsSort) o;

        return id.equals(newsSort.id);
    }

}
