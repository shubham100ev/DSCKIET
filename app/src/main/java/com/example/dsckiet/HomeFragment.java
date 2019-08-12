package com.example.dsckiet;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;


public class HomeFragment extends Fragment {

    FragmentManager fm = getFragmentManager();

    public HomeFragment() {
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        CardView eventsCard = rootView.findViewById(R.id.events_card);
        CardView projectCard = rootView.findViewById(R.id.project_card);
        CardView scoreCard = rootView.findViewById(R.id.score_card);
        CardView storiesCard = rootView.findViewById(R.id.stories_cars);
        CardView aboutCard = rootView.findViewById(R.id.about_card);
        CardView teamCard = rootView.findViewById(R.id.team_card);

        eventsCard.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                fragChange(new UpcomingEventsFragment());
                return true;
            }
        });
        projectCard.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                fragChange(new ProjectsFragment());
                return true;
            }
        });
        scoreCard.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                fragChange(new CodeOfConductFragment());
                return true;
            }
        });
        storiesCard.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                fragChange(new OurStoriesFragment());
                return true;
            }
        });
        aboutCard.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                fragChange(new AboutFragment());
                return true;
            }
        });
        teamCard.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                fragChange(new TeamFragment());
                return true;
            }
        });

        return rootView;
    }

    private void fragChange(Fragment fragment) {
        FragmentManager frag = getActivity().getSupportFragmentManager();
        frag.beginTransaction().replace(R.id.fragment_container, fragment).commit();
    }


}
