package com.datviet.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.datviet.firebase.khoi_tao.ThongTinSach;
import com.datviet.scanner.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Phong Phan on 21-Oct-17.
 */

public class DetailFragment extends android.support.v4.app.Fragment {

    private static DetailFragment fragment;
    DatabaseReference mData;

    TextView ten, loai, tacgia, tinhtrang, soluong, nhaxuatban, namxuatban;

    public static DetailFragment newInstance() {
        if (fragment == null) fragment = new DetailFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();
//        if(bundle!=null){
//
//        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.history_layout, container, false);

        mData = FirebaseDatabase.getInstance().getReference();

        ten = (TextView) viewGroup.findViewById(R.id.tvTensach);
        loai = (TextView) viewGroup.findViewById(R.id.tvTheLoai);
        tacgia = (TextView) viewGroup.findViewById(R.id.tvTacgia);
        tinhtrang = (TextView) viewGroup.findViewById(R.id.tvTinhtrang);
        soluong = (TextView) viewGroup.findViewById(R.id.tvSoluong);
        nhaxuatban = (TextView) viewGroup.findViewById(R.id.tvNhaXuatBan);
        namxuatban = (TextView) viewGroup.findViewById(R.id.tvNamXuatBan);

        mData.child("thongtinsach").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                ThongTinSach thongTinSach = dataSnapshot.getValue(ThongTinSach.class);

                ten.setText(thongTinSach.Tensach);
                loai.setText(thongTinSach.Loaisach);
                tacgia.setText(thongTinSach.Tacgia);
                tinhtrang.setText(thongTinSach.Tinhtrang);
                soluong.setText(String.valueOf(thongTinSach.Soluong));
                nhaxuatban.setText(thongTinSach.Nhaxuatban);
                namxuatban.setText((String.valueOf(thongTinSach.Namxuatban)));
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return inflater.inflate(R.layout.detail_layout, container, false);
    }
}
