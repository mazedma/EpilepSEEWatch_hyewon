package kr.co.episode.epilepseewatch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import kr.co.episode.epilepseewatch.databinding.ActivitySideEffectBinding;

public class SideEffectActivity extends Activity {
    private ActivitySideEffectBinding binding;

    long now = System.currentTimeMillis(); // 현재 시간 가져오기
    Date mDate = new Date(now); // Date 형식으로 고치기
    SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd"); // 시간을 나타낼 포맷 설정
    String getTime = simpleDate.format(mDate); // getTime 변수에 값을 저장


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySideEffectBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.date.setText(getTime); //오늘날짜 화면에 출력

        // 기록하기 버튼 클릭 리스너
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SideEffectCompleteActivity.class);
                startActivity(intent);
            }
        });
    }







}