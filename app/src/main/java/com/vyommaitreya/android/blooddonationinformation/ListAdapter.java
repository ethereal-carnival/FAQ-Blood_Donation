package com.vyommaitreya.android.blooddonationinformation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {

    private Context context;

    private ArrayList<String> question, answer;

    private LayoutInflater layoutInflater;

    public ListAdapter(Context context, ArrayList<String> question, ArrayList<String> answer) {
        this.context = context;
        this.question = question;
        this.answer = answer;
        this.layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    public void updateData(ArrayList<String> question, ArrayList<String> answer) {
        this.question = question;
        this.answer = answer;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return question.size();
    }

    @Override
    public Object getItem(int i) {
        return this;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = layoutInflater.inflate(R.layout.item_list, null);

        TextView textView = convertView.findViewById(R.id.question);
        textView.setText(question.get(position));
        textView = convertView.findViewById(R.id.answer);
        textView.setText(answer.get(position));


        return convertView;
    }


}