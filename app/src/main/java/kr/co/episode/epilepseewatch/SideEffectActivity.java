package kr.co.episode.epilepseewatch;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import kr.co.episode.epilepseewatch.databinding.ActivitySideEffectBinding;

public class SideEffectActivity extends Activity {

    private TextView mTextView;
    private ActivitySideEffectBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySideEffectBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mTextView = binding.text;
    }
}