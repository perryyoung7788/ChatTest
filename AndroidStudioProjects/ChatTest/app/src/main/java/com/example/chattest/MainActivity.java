package com.example.chattest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Msg> msglist = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        final EditText input = findViewById(R.id.editTextView);
        Button sendButton = findViewById(R.id.send_button);
        final RecyclerView recyclerView = findViewById(R.id.recycler_view);
        final MsgAdapter msgAdapter = new MsgAdapter(msglist);
        LinearLayoutManager llManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llManager);
        recyclerView.setAdapter(msgAdapter);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputtext = input.getText().toString();
                if (!inputtext.equals("")){
                    Msg newMsg = new Msg(inputtext,Msg.TYPE_SEND);
                    msglist.add(newMsg);
                    String answer = getAnswer(inputtext); // it can answer automatically
                    Msg answerMsg = new Msg(answer,Msg.TYPE_RECEIVED);
                    msglist.add(answerMsg);
                    msgAdapter.notifyItemInserted(msglist.size()-1);// refresh display
                    recyclerView.scrollToPosition(msglist.size()-1); // set recyclerview to last msg
                    input.setText(""); // clear the input box
                }
            }
        });

    }
    public void init(){
        Msg receiver1 = new Msg("Hi!",0);
        msglist.add(receiver1);
    }
    public String getAnswer(String q){
        if (q.contains("?")){
            if (q.contains("name")){
                return "My name? My name is SuperBoy! hahaha...";
            }
            else if (q.contains("weather")){
                return "It is nice outside, let's go to play soccer, ok?";
            }
            return "Could you say it again?";
        }else {
            int number = (int) (Math.random()*answers.length);
            return answers[number];
        }

    }
    private String[] answers = new String[]{
           "Yes! You are right.",
           "No! I don't think so.",
           "You are right.",
           "Wow!",
           "Good!",
           "How is going?",
           "I don't know what to say, boy!",
            "Let me think for 1 minutes..."
    };
}
