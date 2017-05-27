package com.example.wally_nagama.paripigrass;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.widget.Toast;

import java.util.Date;

import twitter4j.Twitter;
import twitter4j.TwitterException;

/**
 * Created by wally_nagama on 2017/05/27.
 */

public class Tweet {
    private Context context;
    private Twitter mTwitter;
    Date dTime = new Date();

    public Tweet(Context c, Twitter t){
        //コンストラクタ
        this.context = c;
        this.mTwitter = t;
    }

    public void tweet() {

        AsyncTask<String, Void, Boolean> task = new AsyncTask<String, Void, Boolean>() {
            @Override
            protected Boolean doInBackground(String... params) {
                try {
                    mTwitter.updateStatus("俺はパリピになる！！！！！！！！！！@ " + dTime.toString());
                    return true;
                } catch (TwitterException e) {
                    e.printStackTrace();
                    return false;
                }
            }

            @Override
            protected void onPostExecute(Boolean result) {
                if (result) {
                    showToast("ツイートが完了しました！");
                    //finish();
                } else {
                    showToast("ツイートに失敗しました。。。");
                }
            }
        };

    }

    private void showToast(String text) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }
}