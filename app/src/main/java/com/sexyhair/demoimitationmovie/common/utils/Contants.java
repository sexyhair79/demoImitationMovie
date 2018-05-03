package com.sexyhair.demoimitationmovie.common.utils;

/**
 * Created by sexyhair on 16/12/13.
 */

public interface Contants {
    /**
     * 连续点击事件的判断间隔 长，一般用于activity间的跳转 短，内部使用
     */
    long jumpLongTime = 800l;
    long jumpShortTime = 500l;

//    底部的五个标签的id
    int mainTab1 = 10001;
    int mainTab2 = 10002;
    int mainTab3 = 10003;
    int mainTab4 = 10004;
    int mainTab5 = 10005;

    String userInfoStatus = "userInfoStatus";

    interface JumpKey{
        String ToNewsSort = "ToNewsSort";
        String ToNewsSortResult = "ToNewsSortResult";
    }

    /**
     * 数据库表名
     */
    interface TableName{
        String userNewsSortTem = "UserNewsSortTem";
        //除去用户选择了新闻分类
        String userNewsSortTemExcept = "UserNewsSortTemExcept";
    }

    interface RequestCode{
        int userNewsSort = 101;
        int mainToUserLogin = 102;
    }




    //静态常量
    final int typeNewsSort = 2;
    final int typeUserNewsSort = 1;

}
