package mumtaazstudio.newsapp.controller;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import mumtaazstudio.newsapp.R;
import mumtaazstudio.newsapp.model.SourcesModel;

public class SourcesAdapter extends RecyclerView.Adapter<SourcesAdapter.MyViewHolder> {

    Context context;
    private ArrayList<SourcesModel> sourcesList;

    public SourcesAdapter(Context context, ArrayList<SourcesModel> sourcesList) {
        this.context = context;
        this.sourcesList = sourcesList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_item_source, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SourcesAdapter.MyViewHolder holder, int position) {
        SourcesModel sourcesModel = sourcesList.get(position);
        holder.tvNewsSource.setText(sourcesModel.getName());
    }

    @Override
    public int getItemCount() {
        return sourcesList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tvNewsSource;

        public MyViewHolder(View itemView) {
            super(itemView);

            tvNewsSource = (TextView) itemView.findViewById(R.id.tv_news_source);
        }
    }
}
