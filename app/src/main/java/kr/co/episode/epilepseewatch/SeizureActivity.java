package kr.co.episode.epilepseewatch;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import kr.co.episode.epilepseewatch.databinding.ActivitySeizureBinding;

public class SeizureActivity extends Activity {

    private ActivitySeizureBinding binding;

    private Handler handler;
    private Runnable runnable;

    private long startTime = 0L;
    private long timeInMilliseconds = 0L;
    private long timeSwapBuff = 0L;
    private long updateTime = 0L;

    private Date seizureStart = null;
    private SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private boolean isRunning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySeizureBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        handler = new Handler();

        binding.startStopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isRunning) {
                    // Start button action
                    if (startTime == 0L) {
                        startTime = System.currentTimeMillis();
                        seizureStart = new Date(startTime);
                    } else {
                        timeSwapBuff = 0L;
                        startTime = System.currentTimeMillis();
                        seizureStart = new Date(startTime);
                    }
                    handler.postDelayed(runnable, 0);
                    binding.startStopButton.setText("Stop");
                } else {
                    // Stop button action
                    timeSwapBuff += timeInMilliseconds;
                    handler.removeCallbacks(runnable);
                    binding.startStopButton.setText("Start");

                    if (seizureStart != null) {
                        // Display seizure duration
                        long seizureDuration = System.currentTimeMillis() - seizureStart.getTime();
                        String formattedDuration = formatTime(seizureDuration);
                        binding.timerTextview.setText(formattedDuration);
                    }
                }
                isRunning = !isRunning;
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runnable);
    }
}
