package com.sun.demo1.ui.tab_bar.activity;

import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.sun.base.base.BaseActivity;
import com.sun.base.base.BaseViewModel;
import com.sun.demo1.BR;
import com.sun.demo1.R;
import com.sun.demo1.databinding.ActivityTabBarBinding;
import com.sun.demo1.ui.tab_bar.fragment.TabBar1Fragment;
import com.sun.demo1.ui.tab_bar.fragment.TabBar2Fragment;
import com.sun.demo1.ui.tab_bar.fragment.TabBar3Fragment;
import com.sun.demo1.ui.tab_bar.fragment.TabBar4Fragment;

import java.util.ArrayList;
import java.util.List;

import me.majiajie.pagerbottomtabstrip.NavigationController;
import me.majiajie.pagerbottomtabstrip.listener.OnTabItemSelectedListener;


/**
 * @author: Harper
 * @date: 2022/9/9
 * @note: 底部tab按钮的例子
 *   所有例子仅做参考,理解如何使用才最重要。
 */
public class TabBarActivity extends BaseActivity<ActivityTabBarBinding, BaseViewModel> {
    private List<Fragment> mFragments;

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_tab_bar;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public void initData() {
        //初始化Fragment
        initFragment();
        //初始化底部Button
        initBottomTab();
    }

    private void initFragment() {
        mFragments = new ArrayList<>();
        mFragments.add(new TabBar1Fragment());
        mFragments.add(new TabBar2Fragment());
        mFragments.add(new TabBar3Fragment());
        mFragments.add(new TabBar4Fragment());
        //默认选中第一个
        commitAllowingStateLoss(0);
    }

    private void initBottomTab() {
        NavigationController navigationController = binding.pagerBottomTab.material()
                .addItem(R.mipmap.yingyong, "应用")
                .addItem(R.mipmap.huanzhe, "工作")
                .addItem(R.mipmap.xiaoxi_select, "消息")
                .addItem(R.mipmap.wode_select, "我的")
                .setDefaultColor(ContextCompat.getColor(this, R.color.cl_6C6C6C))
                .build();
        //底部按钮的点击事件监听
        navigationController.addTabItemSelectedListener(new OnTabItemSelectedListener() {
            @Override
            public void onSelected(int index, int old) {
//                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//                transaction.replace(R.id.frameLayout, mFragments.get(index));
//                transaction.commitAllowingStateLoss();
                commitAllowingStateLoss(index);
            }

            @Override
            public void onRepeat(int index) {
            }
        });
    }
    private void commitAllowingStateLoss(int position) {
        hideAllFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        Fragment currentFragment = getSupportFragmentManager().findFragmentByTag(position + "");
        if (currentFragment != null) {
            transaction.show(currentFragment);
        } else {
            currentFragment = mFragments.get(position);
            transaction.add(R.id.frameLayout, currentFragment, position + "");
        }
        transaction.commitAllowingStateLoss();
    }

    //隐藏所有Fragment
    private void hideAllFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        for (int i = 0; i < mFragments.size(); i++) {
            Fragment currentFragment = getSupportFragmentManager().findFragmentByTag(i + "");
            if (currentFragment != null) {
                transaction.hide(currentFragment);
            }
        }
        transaction.commitAllowingStateLoss();
    }
}
