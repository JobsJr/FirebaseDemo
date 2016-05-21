package com.example.rajeevkr.studioexplore.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rajeevkr.studioexplore.R;
import com.example.rajeevkr.studioexplore.entities.ToDoList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rajeevkr on 5/21/16.
 */

public class ToDoRecyclerViewAdapter extends RecyclerView.Adapter<ToDoRecyclerViewAdapter.ItemViewHolder> {

    List<ToDoList> mToDoList = new ArrayList<>();
    private Context mContext;

    public ToDoRecyclerViewAdapter(Context context) {
        mContext = context;
    }

    public void setData(ArrayList<ToDoList> toDoLists) {
        mToDoList = toDoLists;
        notifyDataSetChanged();
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_todo, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.mTodoItem.setText(mToDoList.get(position).todo);
    }


    @Override
    public int getItemCount() {
        return mToDoList.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView mTodoItem;

        public ItemViewHolder(View itemView) {
            super(itemView);
            mTodoItem = (TextView) itemView.findViewById(R.id.todo_textView);
        }
    }
}
