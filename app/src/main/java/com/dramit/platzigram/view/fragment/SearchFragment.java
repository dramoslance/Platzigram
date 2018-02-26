package com.dramit.platzigram.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dramit.platzigram.R;
import com.dramit.platzigram.adapter.CardViewAdapter;
import com.dramit.platzigram.model.Card;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {


    private RecyclerView recyclerView;
    private GridLayoutManager layoutManager;

    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        recyclerView = (RecyclerView)view.findViewById(R.id.cardviewRecyclerSearchFragment);

        layoutManager = new GridLayoutManager(getContext(), 2);
        layoutManager.setOrientation(GridLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(layoutManager);

        CardViewAdapter cardViewAdapter = new CardViewAdapter(buildPictures(), R.layout.cardview_picture, getActivity());
        recyclerView.setAdapter(cardViewAdapter);

        return view;

    }

    private ArrayList<Card> buildPictures() {

        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card("http://www.novalandtours.com/images/guide/guilin.jpg", "Uriel Ramírez", "4 días", "3 Me Gusta"));
        cards.add(new Card("http://www.enjoyart.com/library/landscapes/tuscanlandscapes/large/Tuscan-Bridge--by-Art-Fronckowiak-.jpg", "Juan Pablo", "3 días", "10 Me Gusta"));
        cards.add(new Card("http://www.educationquizzes.com/library/KS3-Geography/river-1-1.jpg", "Anahi Salgado", "2 días", "9 Me Gusta"));

        return cards;
    }


}
