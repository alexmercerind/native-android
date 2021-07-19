package com.alexmercerind.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.card.MaterialCardView;


class MyHolder extends RecyclerView.ViewHolder {
    public TextView textView;
    public MaterialCardView materialCardView;
    public MyHolder(View itemView) {
        super(itemView);
        this.textView = (TextView)itemView.findViewById(R.id.ListTileTextView);
        this.materialCardView = (MaterialCardView)itemView.findViewById(R.id.ListTile);
        this.materialCardView.setOnClickListener(
                (View view) -> {
                    Intent intent = new Intent(
                            itemView.getContext(),
                            ChildActivity.class
                    );
                    intent.putExtra("Text", this.textView.getText().toString());
                    view.getContext().startActivity(intent);
                }
        );
    }

}


class MyAdapter extends RecyclerView.Adapter<MyHolder> {

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.list_tile,
                parent,
                false
        );
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.textView.setText(String.format("This is %dth item in the RecyclerView.", position + 1));
    }

    @Override
    public int getItemCount() {
        return 10;
    }
}


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.ListView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter());
    }
}