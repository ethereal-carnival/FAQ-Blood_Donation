package com.vyommaitreya.android.blooddonationinformation;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class InformationListFragment extends Fragment {

    ArrayList<String> questions, answers;
    ArrayList<Boolean> flag;
    ListView mListView;
    ListAdapter mAdapter;

    public void setQuestions(ArrayList<String> questions) {
        this.questions = questions;
        int c = questions.size();
        flag = new ArrayList<>();
        for (int i = 0; i < c; i++) flag.add(false);
    }

    public void setAnswers(ArrayList<String> answers) {
        this.answers = answers;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_list_information, container, false);

        mAdapter = new ListAdapter(getContext(), questions, answers);
        mListView = (ListView) rootView.getChildAt(0);
        mListView.setDivider(null);
        mListView.setAdapter(mAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                TextView question = view.findViewById(R.id.question);
                TextView answer = view.findViewById(R.id.answer);
                CardView cardView = view.findViewById(R.id.card);

                if (flag.get(i)) {
                    cardView.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
                    question.setVisibility(View.VISIBLE);
                    answer.setVisibility(View.GONE);
                    flag.set(i, false);
                } else {
                    cardView.setCardBackgroundColor(getResources().getColor(R.color.colorBlood));
                    question.setVisibility(View.GONE);
                    answer.setVisibility(View.VISIBLE);
                    flag.set(i, true);
                }
            }
        });

        return rootView;
    }
}
