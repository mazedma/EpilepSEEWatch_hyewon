package kr.co.episode.epilepseewatch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import kr.co.episode.epilepseewatch.databinding.ActivitySeizureCompleteBinding;

public class SeizureCompleteActivity extends Activity {

    private ActivitySeizureCompleteBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySeizureCompleteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Get seizure start and duration from intent
        Intent intent = getIntent();
        String seizureStart = intent.getStringExtra("seizureStart");
        String seizureDuration = intent.getStringExtra("seizureDuration");

        // Display seizure start and duration
        binding.seizureStartTextview.setText(seizureStart);
        binding.seizureDurationTextview.setText(seizureDuration);

        binding.closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}