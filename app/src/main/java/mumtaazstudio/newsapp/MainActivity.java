package mumtaazstudio.newsapp;

import android.graphics.Color;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.android.volley.RequestQueue;

import java.util.ArrayList;

import mumtaazstudio.newsapp.model.ArticlesModel;
import mumtaazstudio.newsapp.model.SourcesModel;
import mumtaazstudio.newsapp.utils.RecyclerTouchListener;

public class MainActivity extends AppCompatActivity {

    static RequestQueue queue;
    static RecyclerView.LayoutManager mLayoutManager;
    static ArrayList<ArticlesModel> articlesModels;
    static View view, viewSources;
    private boolean listView;
    SwipeRefreshLayout swipeRefreshLayout;
    RecyclerView recyclerView;
    ArrayList<SourcesModel> sourcesModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recylerView_sources);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        swipeRefreshLayout.setProgressBackgroundColorSchemeColor(getResources().getColor(R.color.colorGreen));
        swipeRefreshLayout.setBackgroundResource(android.R.color.white);
        swipeRefreshLayout.setColorSchemeResources(android.R.color.white, android.R.color.holo_purple, android.R.color.white);
        swipeRefreshLayout.setRefreshing(true);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(true);
                getRecyclerViewSources();
            }
        });

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(this, recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                if (viewSources != null){
                    viewSources.setBackgroundColor(Color.WHITE);
                }
                viewSources = view;
                view.setBackgroundColor(Color.rgb(255, 144, 64));
                swipeRefreshLayout.setRefreshing(true);
                getRecyclerViewArticles(sourcesModelArrayList.get(position).getId());
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));


    }
}
