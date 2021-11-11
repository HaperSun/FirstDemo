package com.sun.demo.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;

import com.sun.common.UiHandler;
import com.sun.demo.R;

/**
 * @author: Harper
 * @date: 2021/11/11
 * @note: handle的使用
 */
public class HandleActivity extends AppCompatActivity {

    private final MyHandler mHandler = new MyHandler(this);

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, HandleActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handle);
        mHandler.post(RUNNABLE);
    }

    private static final Runnable RUNNABLE = () -> {

    };

    private static class MyHandler extends UiHandler<HandleActivity> {

        private MyHandler(HandleActivity activity) {
            super(activity);
        }

        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            HandleActivity activity = getRef();
            if (activity != null) {
                if (activity.isFinishing()) {
                    return;
                }
                int msgId = msg.what;
                if (msgId == 1) {
                    //处理消息
                }
            }
        }
    }
}