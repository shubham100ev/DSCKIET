package com.example.dsckiet;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.UriPermission;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class AboutFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

//    private OnFragmentInteractionListener mListener;

    public AboutFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_about, container, false);
        ImageView imageLink=root.findViewById(R.id.image_link);
        imageLink.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Intent intent=new Intent(Intent.ACTION_VIEW).setData(Uri.parse("http://www.dsckiet.tech"));
                startActivity(intent);
                return true;
            }
        });

        ImageView imageGit=root.findViewById(R.id.image_github);
        imageGit.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Intent intent=new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://github.com/dsckiet"));
                startActivity(intent);
                return true;
            }
        });

        ImageView imageInsta=root.findViewById(R.id.image_instagram);
        imageInsta.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Intent intent=new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://www.instagram.com/dsckiet/"));
                startActivity(intent);
                return true;
            }
        });

        return root;
    }


}
