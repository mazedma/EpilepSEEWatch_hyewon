package kr.co.episode.epilepseewatch;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import kr.co.episode.epilepseewatch.databinding.ActivityDrugBinding;

public class DrugActivity extends Activity {

    private TextView mTextView;
    private ActivityDrugBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDrugBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mTextView = binding.text;
    }
}