package com.example.administrator.travelclique;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.travelclique.mainfragment.CustomizeFragment;
import com.example.administrator.travelclique.mainfragment.DestinationFragment;
import com.example.administrator.travelclique.mainfragment.HomeFragment;
import com.example.administrator.travelclique.mainfragment.MessageFragment;
import com.example.administrator.travelclique.mainfragment.MineFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity{
@BindView(R.id.iv_Mine)
ImageView iv_Mine;
    @BindView(R.id.iv_Home)
    ImageView iv_Home;
    @BindView(R.id.iv_Destination)
    ImageView iv_Destination;
    @BindView(R.id.iv_Customize)
    ImageView iv_Customize;
    @BindView(R.id.iv_Message)
    ImageView iv_Message;
    private Fragment homeFragment, destinatioFragment, customizeFragment,messageFragment, mineFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        setSelect(0);
    }

    private void setSelect(int select) {
        FragmentManager manager = getSupportFragmentManager();
        //设置Fragment管理器
        //开启一个事务
        FragmentTransaction transaction = manager.beginTransaction();
        hiadFragment(transaction);
        //将事务给隐藏   生成一个方法
        // 这里面做两件事 把图片设置成亮的
        // 设置内容区域
        switch (select) {
            case 0:
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                    transaction.add(R.id.flContext, homeFragment);
                } else {
                    transaction.show(homeFragment);
                }
                iv_Home.setImageResource(R.mipmap.icon_main_page_selected);
                break;

            case 1:
                if (destinatioFragment == null) {
                    destinatioFragment = new DestinationFragment();
                    transaction.add(R.id.flContext, destinatioFragment);
                } else {
                    transaction.show(destinatioFragment);
                }
                iv_Destination.setImageResource(R.mipmap.ic_tab_trip_selected);
                break;

            case 2:
                if (customizeFragment == null) {
                    customizeFragment = new CustomizeFragment();
                    transaction.add(R.id.flContext, customizeFragment);
                } else {
                    transaction.show(customizeFragment);
                }
                iv_Customize.setImageResource(R.mipmap.icon_cus_selected);
                break;

            case 3:
                if (messageFragment == null) {
                    messageFragment = new MessageFragment();
                    transaction.add(R.id.flContext, messageFragment);
                } else {
                    transaction.show(messageFragment);
                }
                iv_Message.setImageResource(R.mipmap.ic_talk_sleceted);
                break;
            case 4:
                if (mineFragment == null) {
                    mineFragment = new MineFragment();
                    transaction.add(R.id.flContext, mineFragment);
                } else {
                    transaction.show(mineFragment);
                }

                iv_Mine.setImageResource(R.mipmap.ic_person_sleceted);
            default:
                break;
        }
        transaction.commit();

    }
    //获取图标资源ID
    private void resetImgs() {
        iv_Home.setImageResource(R.mipmap.icon_main_page);
        iv_Destination.setImageResource(R.mipmap.ic_tab_trip_default);
       iv_Customize.setImageResource(R.mipmap.icon_cus_default);
        iv_Message.setImageResource(R.mipmap.ic_talk_normal);
        iv_Mine.setImageResource(R.mipmap.ic_person_normal);


    }
    //使用黄油刀就不要使用事件的onclick监听了，不然会重叠
    @OnClick({R.id.ll_Home,R.id.ll_Customize,R.id.ll_Destination,R.id.ll_Message,R.id.ll_Mine})
    public void onClick(View view) {
        resetImgs();
        switch (view.getId()) {
            case R.id.ll_Home:
                setSelect(0);
                break;
            case R.id.ll_Destination:
                setSelect(1);
                break;
            case R.id.ll_Customize:
                setSelect(2);
                break;
            case R.id.ll_Message:
                setSelect(3);
                break;
            case R.id.ll_Mine:
                setSelect(4);
                break;
            default:
                break;
        }
    }
    private  void hiadFragment(FragmentTransaction transaction){
        if (homeFragment!=null){
            transaction.hide(homeFragment);
        }
        if (destinatioFragment!=null){
            transaction.hide(destinatioFragment);
        }
        if (customizeFragment!=null){
            transaction.hide(customizeFragment);
        }
        if (messageFragment!=null){
            transaction.hide(messageFragment);
        }
        if (mineFragment!=null){
            transaction.hide(mineFragment);
        }
    }
}
