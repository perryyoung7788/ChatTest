package com.example.chattest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.ViewHolder> {
    private List<Msg> mMsg;

    public MsgAdapter(List<Msg> mMsg) {
        this.mMsg = mMsg;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hostview,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Msg massage = mMsg.get(position);
        if (massage.getType()== Msg.TYPE_RECEIVED){
            holder.receivedLayout.setVisibility(View.VISIBLE);
            holder.sendLayout.setVisibility(View.GONE);
            holder.receivedTextView.setText(massage.getContent());
            holder.receivedImageView.setImageResource(R.drawable.dog);
        }
        if (massage.getType()== Msg.TYPE_SEND){
            holder.sendLayout.setVisibility(View.VISIBLE);
            holder.receivedLayout.setVisibility(View.GONE);
            holder.sendTextView.setText(massage.getContent());
            holder.sendImageView.setImageResource(R.drawable.cat);
        }
    }

    @Override
    public int getItemCount() {
        return mMsg.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private ConstraintLayout sendLayout,receivedLayout;

        private TextView sendTextView, receivedTextView;

        private ImageView sendImageView, receivedImageView;

        public ViewHolder(@NonNull View view) {
            super(view);
            sendLayout = view.findViewById(R.id.ll_send);
            receivedLayout = view.findViewById(R.id.ll_received);
            sendTextView = view.findViewById(R.id.tv_send);
            receivedTextView = view.findViewById(R.id.tv_received);
            sendImageView = view.findViewById(R.id.iv_send);
            receivedImageView = view.findViewById(R.id.iv_received);
        }
    }
}
