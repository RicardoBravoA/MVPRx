package com.rba.mvprx.app;

import android.app.Application;
import android.content.Context;

import com.rba.mvprx.api.client.DemoApi;
import com.rba.mvprx.api.client.DemoApiManager;

import rx.Scheduler;
import rx.schedulers.Schedulers;

/**
 * Created by Ricardo Bravo on 16/11/16.
 */


public class MVPRxApplication extends Application {
    private DemoApi demoApi;
    private Scheduler mScheduler;
    private static Context context;

    public void onCreate() {
        super.onCreate();
        MVPRxApplication.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return MVPRxApplication.context;
    }

    public DemoApi getSpotifyService() {
        if (demoApi == null) {
            demoApi = DemoApiManager.apiManager();
        }

        return demoApi;
    }

    //For setting mocks during testing
    public void setSpotifyService(DemoApi demoApi) {
        this.demoApi = demoApi;
    }

    public Scheduler SubscribeScheduler() {
        if (mScheduler == null) mScheduler = Schedulers.io();

        return mScheduler;
    }

    //User to change scheduler from tests
    public void setScheduler(Scheduler scheduler) {
        this.mScheduler = scheduler;
    }
}