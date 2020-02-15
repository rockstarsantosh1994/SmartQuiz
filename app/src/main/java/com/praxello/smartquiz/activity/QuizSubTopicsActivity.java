package com.praxello.smartquiz.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.Log;

import com.praxello.smartquiz.R;
import com.praxello.smartquiz.adapter.QuizSubTopicAdapter;
import com.praxello.smartquiz.adapter.QuizTopicAdapter;
import com.praxello.smartquiz.model.QuizData;
import com.praxello.smartquiz.model.allquestion.QuizBO;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class QuizSubTopicsActivity extends AppCompatActivity {

    @BindView(R.id.rv_sub_type)
    RecyclerView rvSubType;
    private static final String TAG="QuizSubTopicsActivity";
    private List<QuizBO> quizBOArrayList;
    String catergoryType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_sub_topics);
        ButterKnife.bind(QuizSubTopicsActivity.this);

        catergoryType=getIntent().getStringExtra("catergory_type");

        Log.e(TAG, "onCreate: "+catergoryType );

        //basic intialisation...
        initViews();

        quizBOArrayList=QuizTopicsActvity.allQuestionDataMap.get(catergoryType);

        rvSubType.setAdapter(new QuizSubTopicAdapter(QuizSubTopicsActivity.this,quizBOArrayList));
    }

    private void initViews(){
        Toolbar toolbar=findViewById(R.id.toolbar_quizsubtopics);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setTitle("Quiz Sub type");
        toolbar.setTitleTextColor(Color.BLACK);
        toolbar.getNavigationIcon().setColorFilter(getResources().getColor(R.color.black), PorterDuff.Mode.SRC_ATOP);

        rvSubType.setLayoutManager(new LinearLayoutManager(QuizSubTopicsActivity.this));


        //rvSubType.setAdapter(new QuizSubTopicAdapter(QuizSubTopicsActivity.this,quizDataArrayList));
    }


}
