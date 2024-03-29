package com.example.button2;
// androidx
import androidx.appcompat.app.AppCompatActivity;
// no androidx
//import android.support.v7.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout.LayoutParams buttonLayoutParams;
    private TextView textView;
    private Button button;
    private int buttonWidth, buttonHeight;
    private float scale;
    private boolean flag = false;

    int mParent = RelativeLayout.LayoutParams.MATCH_PARENT;
    int wContent = RelativeLayout.LayoutParams.WRAP_CONTENT;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // リラティブレイアウトの設定
        RelativeLayout layout = new RelativeLayout(this);

        layout.setLayoutParams(new RelativeLayout.LayoutParams(
                mParent, mParent));

        // 背景色の設定
        layout.setBackgroundColor(Color.rgb(220,255,240));

        setContentView(layout);

        // dp 設定
        scale = getResources().getDisplayMetrics().density;

        // テキスト設定
        textView = new TextView(this);
        textView.setText(R.string.hello);
        // テキストサイズ 30sp
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 50);
        // テキストカラー
        textView.setTextColor(Color.rgb(0x0, 0x0, 0xff));

        RelativeLayout.LayoutParams textLayoutParams =
                new RelativeLayout.LayoutParams(wContent, wContent);

        // setMargins (int left, int top, int right, int bottom)
        textLayoutParams.setMargins((int)(150*scale), (int)(300*scale), 0, 0);

        textView.setLayoutParams(textLayoutParams);
        layout.addView(textView);

        // ボタンの設定
        button = new Button(this);
        button.setText(R.string.button);

        button.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24);
        // ボタンサイズ
        buttonWidth = (int)(200 * scale);
        buttonHeight = (int)(100 * scale);
        buttonLayoutParams = new RelativeLayout.LayoutParams(buttonWidth, buttonHeight);

        // button margin : left, top, right, bottom
        buttonLayoutParams.setMargins((int)(105*scale), (int)(360*scale), 0, 0);

        button.setLayoutParams(buttonLayoutParams);

        layout.addView(button);

        // リスナーをボタンに登録
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // flagがtrueの時
                if (flag) {
                    textView.setText(R.string.hello);
                    mode1();

                    flag = false;
                }
                // flagがfalseの時
                else {
                    textView.setText(R.string.world);
                    mode2();

                    flag = true;
                }
            }
        });
    }

    private void mode1(){
        buttonWidth = (int)(250 * scale);
        buttonHeight = (int)(100 * scale);
        buttonLayoutParams = new RelativeLayout.LayoutParams(buttonWidth, buttonHeight);
        // setMargins (int left, int top, int right, int bottom)
        buttonLayoutParams.setMargins((int)(150*scale), (int)(360*scale), 0, 0);
        button.setLayoutParams(buttonLayoutParams);

    }

    private void mode2(){
        buttonWidth = (int)(270 * scale);
        buttonHeight = (int)(200 * scale);
        buttonLayoutParams = new RelativeLayout.LayoutParams(buttonWidth, buttonHeight);
        // setMargins (int left, int top, int right, int bottom)
        buttonLayoutParams.setMargins((int) (5 * scale), (int)(100 * scale),
                (int)(50 * scale), (int)(20 * scale));
        button.setLayoutParams(buttonLayoutParams);

    }

}