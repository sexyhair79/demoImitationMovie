package com.sexyhair.demoimitationmovie.common.utils;

import android.support.v4.app.Fragment;

import com.sexyhair.demoimitationmovie.activity.fragment.NewsListCommonFragment;


/**
 * Created by sexyhair on 16/12/15.
 * 项目中所有的枚举
 */

public class Enums {
    /**
     * 所有的新闻分类，和数据库是对应的
     */
    public enum NewsSort {
        //要闻:用户选择必须有的
        FocusNews(1),
        //足球
        FootballNews(2),
        //财经
        FinanceNews(3),
        //娱乐
        EntertainmentNews(4),
        //体育新闻
        SportsNews(5),
        //科技新闻
        TechnologyNews(6),
        //社会新闻
        SocialNews(7),
        //军事新闻
        MilitaryNews(8),
        //时尚新闻
        FashionNews(9),
        //记录新闻
        Recordnews(10),
        //家居新闻
        HomeNews(11),
        //国际新闻
        InternationalNews(12),
        //文化新闻
        CultureNews(13),
        //房产新闻
        HouseNews(14),
        //图片居新
        ImageNews(15),
        //视频新闻
        VedioNews(16),
        //汽车新闻
        AutomotiveNews(17),
        //家居新闻
        GameNews(18);
        private int sortId;

        private NewsSort(int code) {
            this.sortId = sortId;
        }

        public int getSortId() {
            return sortId;
        }

        public static NewsSort parseSort(int sortId) {
            for (NewsSort newsSort : NewsSort.values()) {
                if (newsSort.getSortId() == sortId) {
                    return newsSort;
                }
            }
            return null;
        }

        public static Fragment getNewsSortFragment(int sortId){
            return NewsListCommonFragment.newInstance(sortId);
        }
    }
}
