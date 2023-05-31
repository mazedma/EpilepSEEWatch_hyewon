package kr.co.episode.epilepseewatch;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import kr.co.episode.epilepseewatch.databinding.ActivityPeriodBinding;

public class PeriodActivity extends Activity {

    private TextView mTextView;
    private ActivityPeriodBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPeriodBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mTextView = binding.text;
    }
}