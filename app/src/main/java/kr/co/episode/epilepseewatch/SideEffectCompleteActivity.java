package kr.co.episode.epilepseewatch;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import kr.co.episode.epilepseewatch.databinding.ActivitySideEffectCompleteBinding;

public class SideEffectCompleteActivity extends Activity {
    private ActivitySideEffectCompleteBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySideEffectCompleteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // SideEffectActivity에서 선택된 라디오버튼의 text값 가져오기
        String checkedRadio =((SideEffectActivity)SideEffectActivity.context_sideEffect).checkedRadioSE;
        binding.textView6.setText(checkedRadio); //text값 출력
    }

}