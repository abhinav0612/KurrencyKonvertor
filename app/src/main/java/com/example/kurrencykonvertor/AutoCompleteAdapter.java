package com.example.kurrencykonvertor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class AutoCompleteAdapter extends ArrayAdapter {
    private List<CountryList> listFull;

    public AutoCompleteAdapter(@NonNull Context context,@NonNull List<CountryList> objects) {
        super(context, 0, objects);
        listFull  = new ArrayList<>(objects);
    }

    @NonNull
    @Override
    public Filter getFilter() {
        return filter;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.autocomplete_layout
            ,parent,false);
        }
        TextView country = convertView.findViewById(R.id.tv_country);
        TextView countrycode = convertView.findViewById(R.id.tv_code);
        ImageView flag = convertView.findViewById(R.id.iv_image);

       CountryList item = (CountryList) getItem(position);
        if (item!= null)
        {
            country.setText(item.getCountryName());
            countrycode.setText(item.getCurrencyCode());
            flag.setImageResource(item.getImageid());
        }

        return convertView;
    }



    private Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            List<CountryList> suggestinList = new ArrayList<>();
            if (constraint == null || constraint.length()==0)
            {
                suggestinList.addAll(listFull);
            }
            else {
                String filterPattern =  constraint.toString().toLowerCase().trim();
                for (CountryList item : listFull)
                {
                    if (item.getCountryName().toLowerCase().startsWith(filterPattern))
                    {
                        suggestinList.add(item);
                    }
                }
            }
            results.values = suggestinList;
            results.count = suggestinList.size();
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            clear();
            addAll((List) results.values);
            notifyDataSetChanged();
        }

        @Override
        public CharSequence convertResultToString(Object resultValue) {
            return ((CountryList) resultValue).getCurrencyCode();
        }
    };
}
