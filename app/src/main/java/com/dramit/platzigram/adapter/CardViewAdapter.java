package com.dramit.platzigram.adapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dramit.platzigram.R;
import com.dramit.platzigram.model.Card;
import com.dramit.platzigram.view.CardDetailActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Deiby Ramos on 22/02/2018.
 */

public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.CardViewRecyclerViewHolder>{


    private ArrayList<Card> cards;
    private int resource;
    private Activity activity;

    public CardViewAdapter(ArrayList<Card> cards, int resource, Activity activity) {
        this.cards = cards;
        this.resource = resource;
        this.activity = activity;
    }

    @Override
    public CardViewRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(this.resource, parent, false);

        return new CardViewRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CardViewRecyclerViewHolder holder, int position) {

        Card card = this.cards.get(position);

        holder.usernameCard.setText(card.getUsername());
        holder.likesCard.setText(card.getLikes());
        holder.timeCard.setText(card.getDate());
        Picasso.with(activity).load(card.getPicture()).into(holder.pictureCard);

        holder.pictureCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, CardDetailActivity.class);


                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                    Explode explode = new Explode();
                    explode.setDuration(1000);
                    activity.getWindow().setExitTransition(explode);
                    activity.startActivity(intent,
                            ActivityOptionsCompat.makeSceneTransitionAnimation(activity, v, activity.getString(R.string.transition_name_card)).toBundle());
                }else{
                    activity.startActivity(intent);
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return this.cards.size();
    }

    public class CardViewRecyclerViewHolder extends RecyclerView.ViewHolder{


        private ImageView pictureCard;
        private TextView likesCard;
        private TextView timeCard;
        private TextView usernameCard;

        public CardViewRecyclerViewHolder(View itemView){
            super(itemView);

            this.pictureCard = (ImageView)itemView.findViewById(R.id.cardviewPicture);
            this.timeCard = (TextView)itemView.findViewById(R.id.cardviewTime);
            this.likesCard = (TextView)itemView.findViewById(R.id.cardviewLikes);
            this.usernameCard = (TextView)itemView.findViewById(R.id.cardviewUsername);


        }

    }

}
