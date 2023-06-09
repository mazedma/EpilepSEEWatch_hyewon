package kr.co.episode.epilepseewatch;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import kr.co.episode.epilepseewatch.databinding.ActivitySideEffectCompleteBinding;

public class SideEffectCompleteActivity extends Activity {

    private TextView mTextView;
    private ActivitySideEffectCompleteBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySideEffectCompleteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mTextView = binding.text;
    }

}