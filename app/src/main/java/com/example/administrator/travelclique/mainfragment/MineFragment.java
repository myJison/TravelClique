package com.example.administrator.travelclique.mainfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.travelclique.R;

/**
 * Created by Administrator on 2016/11/17.
 */

public class MineFragment extends android.support.v4.app.Fragment {
    private View v=null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v=LayoutInflater.from(getActivity()).inflate(R.layout.mine_fragment_layout,null);
        return v;
    }
}
