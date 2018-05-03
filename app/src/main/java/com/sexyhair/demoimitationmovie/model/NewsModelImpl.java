package com.sexyhair.demoimitationmovie.model;

import com.sexyhair.demoimitationmovie.bean.News;
import com.sexyhair.demoimitationmovie.bean.NewsSort;
import com.sexyhair.demoimitationmovie.common.utils.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sexyhair on 16/12/15.
 */

public class NewsModelImpl implements NewsModel {

    @Override
    public void loadUserNewsSortList(String userId, final OnLoadUserNewsSortListener onLoadUserNewsSortListener) {
        Logger.i(Logger.Log_NetData, "用户的新闻分类---Model层接受请求，调用加载数据方法");
//        ((Activity) AppContext.currentActivity).runOnUiThread(new Runnable() {
//
//            @Override
//            public void run() {
//                // 在这里执行你要想的操作 比如直接在这里更新ui或者调用回调在 在回调中更新ui
//                onLoadUserNewsSortListener.onLoadUserNewsSortSuccess(mUserNewsSortBeans);
//            }
//        });


//        ServerProxy.getCity(userId,new HttpListener() {
//            @Override
//            public void onSucess(ResponseResult result) {
//                Logger.i(Logger.Log_NetData,"用户的新闻分类---Model层接受请求，拿到数据结果---成功");
////                Logger.i(Logger.Log_NetData,"result = "+result.getResult());
//                List<UserNewsSortBean> mUserNewsSortBeans = new ArrayList<UserNewsSortBean>();
//                for(int i = 1 ; i < 5 ; i++){
//                    UserNewsSortBean mUserNewsSortBean = new UserNewsSortBean();
//                    mUserNewsSortBean.setId(i);
//                    mUserNewsSortBean.setSortName("新闻"+i);
//                    mUserNewsSortBeans.add(mUserNewsSortBean);
//                }
////                List<UserNewsSortBean> mBoxofficeInternetBeans =
////                        JSON.parseArray(result.getResult(),UserNewsSortBean.class);
//                onLoadUserNewsSortListener.onLoadUserNewsSortSuccess(mUserNewsSortBeans);
//            }
//
//            @Override
//            public void onFailed(String message) {
//                super.onFailed(message);
//                Logger.i(Logger.Log_NetData,"用户的新闻分类---Model层接受请求，拿到数据结果---失败");
//                onLoadUserNewsSortListener.onLoadUserNewsSortFailure(message);
//            }
//        });

    }

    @Override
    public void laodNewsSortList(final OnLoadNewsSortListListener onLoadNewsSortListListener) {
//        DBManager.getInstance().executeInDataBase(new ExecuteAdapter() {
//            @Override
//            public void execute(DBDataBase db) {
//
//                final List<NewsSort> newsSortList = db.queryAll(NewsSort.class,Contants.TableName.userNewsSortTemExcept);
//                if (newsSortList != null) {
//                    ((Activity) AppContext.currentActivity).runOnUiThread(new Runnable() {
//
//                        @Override
//                        public void run() {
//                            // 在这里执行你要想的操作 比如直接在这里更新ui或者调用回调在 在回调中更新ui
//                            onLoadNewsSortListListener.onLoadNewsSortListSuccess(newsSortList);
//                        }
//                    });
//                }
//            }
//        });
    }

    @Override
    public void loadNewsDetail() {

    }

    @Override
    public void loadNewsList(int newsSortId, OnLoadNewsListListener onLoadNewsListListener) {
        List<News> newsList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            News news = new News();
            news.setTitle("id=" + newsSortId + "    i=" + i);
            newsList.add(news);
        }
        onLoadNewsListListener.onLoadNewsListSuccess(newsList);
        Logger.i(Logger.Log_DBData, "获取一次数据---" + newsSortId);
    }

    @Override
    public void submitUserNewsSort(final NewsSort userSort, final int operationType) {
//        DBManager.getInstance().executeInDataBase(new ExecuteAdapter() {
//            @Override
//            public void execute(DBDataBase db) {
//                long resultInsert = 0;
//                long resultDelete = 0;
//                switch (operationType){
//                    case Contants.typeNewsSort:
//                        resultInsert = db.insert(userSort, Contants.TableName.userNewsSortTem);
//                        resultDelete = db.delete(userSort, Contants.TableName.userNewsSortTemExcept, String.valueOf(userSort.getId()));
//                        Logger.w(Logger.Log_DBData,"插入数据库："+resultInsert);
//                        Logger.w(Logger.Log_DBData,"删除数据库："+resultDelete);
//                    break;
//                    case Contants.typeUserNewsSort:
//                        resultDelete = db.delete(userSort, Contants.TableName.userNewsSortTem, String.valueOf(userSort.getId()));
//                        resultInsert = db.insert(userSort, Contants.TableName.userNewsSortTemExcept);
//                        Logger.w(Logger.Log_DBData,"插入数据库："+resultInsert);
//                        Logger.w(Logger.Log_DBData,"删除数据库："+resultDelete);
//                        break;
//                }
//            }
//        });

    }
}
