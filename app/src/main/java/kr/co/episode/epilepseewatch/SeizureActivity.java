package kr.co.episode.epilepseewatch;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import android.widget.TextView;

import kr.co.episode.epilepseewatch.databinding.ActivitySeizureBinding;

public class SeizureActivity extends Activity {

    private ActivitySeizureBinding binding;
    private Handler handler;
    private Runnable runnable;

    private long startTime = 0L;
    private long timeInMilliseconds = 0L;
    private long timeSwapBuff = 0L;
    private long updateTime = 0L;

    private long seizureDuration = 0L;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySeizureBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        handler = new Handler();

        binding.startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTime = System.currentTimeMillis();
                handler.postDelayed(runnable, 0);
                binding.startButton.setEnabled(false);
                binding.stopButton.setEnabled(true);
                binding.resetButton.setEnabled(false);
            }
        });

        binding.stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timeSwapBuff += timeInMilliseconds;
                handler.removeCallbacks(runnable);
                seizureDuration = updateTime;
                binding.startButton.setEnabled(true);
                binding.stopButton.setEnabled(false);
                binding.resetButton.setEnabled(true);
            }
        });

        binding.resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTime = 0L;
                timeInMilliseconds = 0L;
                timeSwapBuff = 0L;
                updateTime = 0L;
                seizureDuration = 0L;
                binding.timerTextview.setText("00:00.000");
                binding.startButton.setEnabled(true);
                binding.stopButton.setEnabled(false);
                binding.resetButton.setEnabled(false);
            }
        });

        runnable = new Runnable() {
            @Override
            public void run() {
                timeInMilliseconds = System.currentTimeMillis() - startTime;
                updateTime = timeSwapBuff + timeInMilliseconds;
                binding.timerTextview.setText(formatTime(updateTime));
                handler.postDelayed(this, 0);
            }
        };
    }

    private String formatTime(long time) {
        int milliseconds = (int) (time % 1000);
        int seconds = (int) ((time / 1000) % 60);
        int minutes = (int) ((time / (1000 * 60)) % 60);

        return String.format("%02d:%02d.%03d", minutes, seconds, milliseconds);
    }
}