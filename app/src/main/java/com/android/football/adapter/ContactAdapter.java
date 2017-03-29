package com.android.football.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.football.R;
import com.android.football.model.Fixture;

import java.util.List;


public class ContactAdapter extends ArrayAdapter<Fixture> {

    List<Fixture> contactList;
    Context context;
    private LayoutInflater mInflater;

    // Constructors
    public ContactAdapter(Context context, List<Fixture> objects) {
        super(context, 0, objects);
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
        contactList = objects;
    }

    @Override
    public Fixture getItem(int position) {
        return contactList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder vh;
        if (convertView == null) {
            View view = mInflater.inflate(R.layout.layout_row_view, parent, false);
            vh = ViewHolder.create((RelativeLayout) view);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        Fixture item = getItem(position);

        vh.textViewHomeTeam.setText(item.getHomeTeamName());
        vh.textViewAwayTeam.setText(item.getAwayTeamName());
        vh.textViewAwayTeamScore.setText(item.getResult().getGoalsAwayTeam() + "");
        vh.textViewHomeTeamScore.setText(item.getResult().getGoalsHomeTeam() + "");
        // Picasso.with(context).load(item.getLinks().getHomeTeam().getHref()).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(vh.imageView);

        return vh.rootView;
    }

    private static class ViewHolder {
        public final RelativeLayout rootView;
        public final ImageView imageView;
        public final TextView textViewAwayTeam;
        public final TextView textViewHomeTeam;
        public final TextView textViewAwayTeamScore;
        public final TextView textViewHomeTeamScore;

        private ViewHolder(RelativeLayout rootView, ImageView imageView, TextView textViewHomeTeam, TextView textViewAwayTeam, TextView textViewHomeTeamScore, TextView textViewAwayTeamScore) {
            this.rootView = rootView;
            this.imageView = imageView;
            this.textViewHomeTeam = textViewHomeTeam;
            this.textViewAwayTeam = textViewAwayTeam;
            this.textViewHomeTeamScore = textViewHomeTeamScore;
            this.textViewAwayTeamScore = textViewAwayTeamScore;
        }

        public static ViewHolder create(RelativeLayout rootView) {
            ImageView imageView = (ImageView) rootView.findViewById(R.id.imageViewHome);
            TextView textViewHomeTeam = (TextView) rootView.findViewById(R.id.textViewHomeTeam);
            TextView textViewAwayTeam = (TextView) rootView.findViewById(R.id.textViewAwayTeam);
            TextView textViewHomeTeamScore = (TextView) rootView.findViewById(R.id.textHomeScore);
            TextView textViewAwayTeamScore = (TextView) rootView.findViewById(R.id.textAwayScore);
            return new ViewHolder(rootView, imageView, textViewHomeTeam, textViewAwayTeam, textViewHomeTeamScore, textViewAwayTeamScore);
        }

    }

}
