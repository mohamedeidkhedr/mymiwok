package com.example.mohamedeidkhedr.miwakapp;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    MediaPlayer.OnCompletionListener onCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            mediaPlayer.release();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
        final ArrayList<Word> words = new ArrayList<>();
        words.add(new Word(getString(R.string.number_one), getString(R.string.number_one), R.drawable.number_one, R.raw.number_one));
        words.add(new Word(getString(R.string.number_two), getString(R.string.number_two), R.drawable.number_two, R.raw.number_two));
        words.add(new Word(getString(R.string.number_three), getString(R.string.number_one), R.drawable.number_three, R.raw.number_three));
        words.add(new Word(getString(R.string.number_four), getString(R.string.number_one), R.drawable.number_four, R.raw.number_four));
        words.add(new Word(getString(R.string.number_five), getString(R.string.number_one), R.drawable.number_five, R.raw.number_five));
        words.add(new Word(getString(R.string.number_six), getString(R.string.number_one), R.drawable.number_six, R.raw.number_six));
        words.add(new Word(getString(R.string.number_seven), getString(R.string.number_one), R.drawable.number_seven, R.raw.number_seven));
        words.add(new Word(getString(R.string.number_eight), getString(R.string.number_one), R.drawable.number_eight, R.raw.number_eight));
        words.add(new Word(getString(R.string.number_nine), getString(R.string.number_one), R.drawable.number_nine, R.raw.number_nine));
        words.add(new Word(getString(R.string.number_ten), getString(R.string.number_one), R.drawable.number_ten, R.raw.number_ten));

//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, words);
//        ListView listView = (ListView) findViewById(R.id.root_view);
//        listView.setAdapter(adapter);
        WordAdapter adapter = new WordAdapter(this, words, R.color.numberColor);
        ListView listView = (ListView) findViewById(R.id.numbers_list_view);
        listView.setAdapter(adapter);
        AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mediaPlayer = MediaPlayer.create(NumbersActivity.this, words.get(i).getAudioResource());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(onCompletionListener);
            }
        };


        listView.setOnItemClickListener(onItemClickListener);


    }
}
