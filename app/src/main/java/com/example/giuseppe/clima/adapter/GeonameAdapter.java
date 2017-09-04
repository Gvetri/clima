package com.example.giuseppe.clima.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.giuseppe.clima.R;
import com.example.giuseppe.clima.model.Geoname;
import com.example.giuseppe.clima.model.Geoname_;

import java.util.List;

/**
 * Created by giuseppe on 9/4/17.
 */

public class GeonameAdapter extends RecyclerView.Adapter<GeonameAdapter.ViewHolder>  {

    private List<Geoname_> geonameList;

    public GeonameAdapter(List<Geoname_> geonameList) {
        this.geonameList = geonameList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.geoname_row, parent, false);


            return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Geoname_ geoname = geonameList.get(position);
        holder.tv_country_name.setText(geoname.getCountryName());
        holder.tv_name.setText(geoname.getAsciiName());
    }

    @Override
    public int getItemCount() {
        return geonameList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_name,tv_country_name;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_nombre);
            tv_country_name = itemView.findViewById(R.id.tv_nombre_pais);
        }
    }

}
