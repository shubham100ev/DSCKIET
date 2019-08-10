package com.example.dsckiet;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.wangjie.rapidfloatingactionbutton.RapidFloatingActionButton;
import com.wangjie.rapidfloatingactionbutton.RapidFloatingActionHelper;
import com.wangjie.rapidfloatingactionbutton.RapidFloatingActionLayout;
import com.wangjie.rapidfloatingactionbutton.contentimpl.labellist.RFACLabelItem;
import com.wangjie.rapidfloatingactionbutton.contentimpl.labellist.RapidFloatingActionContentLabelList;
import com.wangjie.rapidfloatingactionbutton.util.RFABTextUtil;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RapidFloatingActionContentLabelList.OnRapidFloatingActionContentLabelListListener {

    private RapidFloatingActionLayout rfaLayout;
    private RapidFloatingActionButton rfaButton;
    private RapidFloatingActionHelper rfabHelper;
    FragmentManager fragmentManager = getSupportFragmentManager();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SharedPreferences pref=getSharedPreferences("pref",MODE_PRIVATE);
        boolean firstStart=pref.getBoolean("firstStart",true);


        rfaLayout = findViewById(R.id.label_list_sample_rfal);
        rfaButton = findViewById(R.id.label_list_sample_rfab);
        rfabHandler();
        fragmentManager.beginTransaction().add(R.id.fragment_container, new AboutFragment()).commit();




    }

    void rfabHandler() {
        RapidFloatingActionContentLabelList rfaContent = new RapidFloatingActionContentLabelList(this);
        rfaContent.setOnRapidFloatingActionContentLabelListListener(this);
        List<RFACLabelItem> items = new ArrayList<>();
        items.add(new RFACLabelItem<Integer>()
                .setLabel("About Us")
                .setResId(R.drawable.aboutus)
                .setIconNormalColor(Color.rgb(66, 140, 244))
                .setIconPressedColor(Color.rgb(114, 164, 250))
                .setLabelColor(Color.rgb(66, 140, 244))
                .setWrapper(0)
        );
        items.add(new RFACLabelItem<Integer>()
                .setLabel("Our Projects")
                .setDrawable(getResources().getDrawable(R.drawable.projects))
                .setIconNormalColor(Color.rgb(66, 140, 244))
                .setIconPressedColor(Color.rgb(114, 164, 250))
                .setLabelColor(Color.rgb(66, 140, 244))
                .setWrapper(1)
        );
        items.add(new RFACLabelItem<Integer>()
                .setLabel("Our Team")
                .setResId(R.drawable.team)
                .setIconNormalColor(Color.rgb(66, 140, 244))
                .setIconPressedColor(Color.rgb(114, 164, 250))
                .setLabelColor(Color.rgb(66, 140, 244))
                .setWrapper(2)
        );
        items.add(new RFACLabelItem<Integer>()
                .setLabel("Our Stories")
                .setResId(R.drawable.stories)
                .setIconNormalColor(Color.rgb(66, 140, 244))
                .setIconPressedColor(Color.rgb(114, 164, 250))
                .setLabelColor(Color.rgb(66, 140, 244))
                .setWrapper(3)
        );
        items.add(new RFACLabelItem<Integer>()
                .setLabel("Events")
                .setResId(R.drawable.event)
                .setIconNormalColor(Color.rgb(66, 140, 244))
                .setIconPressedColor(Color.rgb(114, 164, 250))
                .setLabelColor(Color.rgb(66, 140, 244))
                .setWrapper(3)
        );
        items.add(new RFACLabelItem<Integer>()
                .setLabel("Code of Conduct")
                .setResId(R.drawable.codeofconduct)
                .setIconNormalColor(Color.rgb(66, 140, 244))
                .setIconPressedColor(Color.rgb(114, 164, 250))
                .setLabelColor(Color.rgb(66, 140, 244))
                .setWrapper(3)
        );

        rfaContent
                .setItems(items)
                .setIconShadowRadius(RFABTextUtil.dip2px(this, 3))
                .setIconShadowColor(Color.rgb(66, 140, 244))
                .setIconShadowDy(RFABTextUtil.dip2px(this, 5))
        ;

        rfabHelper = new RapidFloatingActionHelper(
                this,
                rfaLayout,
                rfaButton,
                rfaContent
        ).build();

    }


    @Override
    public void onRFACItemLabelClick(int position, RFACLabelItem item) {
//        Toast.makeText(this, "clicked label: " + position, Toast.LENGTH_SHORT).show();
        rfabHelper.toggleContent();
        switch (position) {
            case 0:
                aboutUsFrag();
                break;
            case 1:
                projectFrag();
                break;
            case 2:
                teamFrag();
                break;
            case 3:
                storiesFrag();
                break;
            case 4:
                eventsFrag();
                break;
            case 5:
                conductFrag();
        }

    }

    @Override
    public void onRFACItemIconClick(int position, RFACLabelItem item) {
//        Toast.makeText(this, "clicked icon: " + position, Toast.LENGTH_SHORT).show();
        rfabHelper.toggleContent();
        switch (position) {
            case 0:
                aboutUsFrag();
                break;
            case 1:
                projectFrag();
                break;
            case 2:
                teamFrag();
                break;
            case 3:
                storiesFrag();
                break;
            case 4:
                eventsFrag();
                break;
            case 5:
                conductFrag();
        }
    }

    void aboutUsFrag()
    {
        fragmentManager.beginTransaction().replace(R.id.fragment_container, new AboutFragment()).commit();
    }
    void projectFrag()
    {
        fragmentManager.beginTransaction().replace(R.id.fragment_container, new ProjectsFragment()).commit();
    }
    void teamFrag()
    {
        fragmentManager.beginTransaction().replace(R.id.fragment_container, new TeamFragment()).commit();
    }
    void storiesFrag()
    {
        fragmentManager.beginTransaction().replace(R.id.fragment_container, new OurStoriesFragment()).commit();
    }
    void eventsFrag()
    {
        fragmentManager.beginTransaction().replace(R.id.fragment_container, new PastEventsFragment()).commit();
    }
    void conductFrag()
    {
        fragmentManager.beginTransaction().replace(R.id.fragment_container, new CodeOfConductFragment()).commit();
    }
}
