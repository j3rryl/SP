package com.example.sp1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sp1.Adapters.JobsAdapter;
import com.example.sp1.Adapters.NewsAdapter;
import com.example.sp1.Adapters.WalletAdapter;
import com.example.sp1.Models.Jobs;
import com.example.sp1.Models.NewsModel;
import com.example.sp1.Models.WalletModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WalletFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WalletFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ArrayList<WalletModel>walletModel = new ArrayList<>();


    public WalletFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WalletFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WalletFragment newInstance(String param1, String param2) {
        WalletFragment fragment = new WalletFragment();
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
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_wallet, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.history_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        setUpHistory();
        WalletAdapter walletAdapter = new WalletAdapter(this.getContext(),walletModel);
        recyclerView.setAdapter(walletAdapter);


        return view;
//        return inflater.inflate(R.layout.fragment_wallet, container, false);
    }
    private void setUpHistory(){
        String [] employerName = getResources().getStringArray(R.array.employer_name);
        String [] status = getResources().getStringArray(R.array.status);
        String [] startDate = getResources().getStringArray(R.array.start_date);
        String [] timeframe = getResources().getStringArray(R.array.timeframe);
        String [] priceRange = getResources().getStringArray(R.array.wallet_price);
    //Works
        for(int i=0;i< employerName.length;i++){
            walletModel.add(new WalletModel( employerName[i],
                    status[i],
                    startDate[i],
                    timeframe[i],
                    priceRange[i],
                    R.drawable.nairobi));
        }

    }
}