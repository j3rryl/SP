package com.example.sp1;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sp1.Activities.Calendar;
import com.example.sp1.Activities.Maps;
import com.example.sp1.Activities.Profile;
import com.example.sp1.Activities.Reports;
import com.example.sp1.Adapters.NewsAdapter;
import com.example.sp1.Authentication.AuthenticationActivity;
import com.example.sp1.Models.NewsModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ArrayList<NewsModel> newsModelList = new ArrayList<>();
    private int [] images={R.drawable.dog2, R.drawable.dog3};



    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_profile, container, false);
        ViewPager2 viewPager2 = view.findViewById(R.id.view_pager);
        setUpNewsList();
        viewPager2.setAdapter(new NewsAdapter(newsModelList));
        CardView openProfile = view.findViewById(R.id.open_profile);
        CardView openReports = view.findViewById(R.id.open_reports);
        CardView openMaps = view.findViewById(R.id.open_maps);
        CardView openCalendar = view.findViewById(R.id.openCalendar);
        CardView signOut = view.findViewById(R.id.sign_out);

        openProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(getContext(), Profile.class);
                startActivity(i);
            }
        });
        openCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(getContext(), Calendar.class);
                startActivity(i);
            }
        });
        openMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(getContext(), Maps.class);
                startActivity(i);
            }
        });
        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(getContext(), AuthenticationActivity.class);
                startActivity(i);
            }
        });
        openReports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(getContext(), Reports.class);
                startActivity(i);
            }
        });

        return view;
//        return inflater.inflate(R.layout.fragment_profile, container, false);
    }
    private void setUpNewsList(){
        for(int i = 0; i<images.length;i++) {
            NewsModel newsModelHello = new NewsModel("France", "Mountain View", images[i], 4.5f);
            newsModelList.add(newsModelHello);
        }
    }
}