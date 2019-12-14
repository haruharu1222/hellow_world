package com.example.santa_tatch;
// androidx
import androidx.appcompat.app.AppCompatActivity;
// no androidx
//import android.support.v7.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout.LayoutParams buttonLayoutParams;
    private LinearLayout.LayoutParams layoutParams;
    private ImageView imageView;
    private TextView textView;
    private Button button;
    private int buttonWidth, buttonHeight;
    private int imageWidth, imageHeight;
    private float scale;
    private boolean flag = false;

    int mParent = RelativeLayout.LayoutParams.MATCH_PARENT;
    int wContent = RelativeLayout.LayoutParams.WRAP_CONTENT;
    Random r = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // リラティブレイアウトの設定
        RelativeLayout layout = new RelativeLayout(this);

        layout.setLayoutParams(new RelativeLayout.LayoutParams(
                mParent, mParent));

        // 背景色の設定
        layout.setBackgroundColor(Color.rgb(220, 255, 240));

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
        textLayoutParams.setMargins((int) (150 * scale), (int) (300 * scale), 0, 0);

        textView.setLayoutParams(textLayoutParams);
        layout.addView(textView);


        // ボタンの設定
        button = new Button(this);
        button.setText(R.string.button);

        button.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24);
        // ボタンサイズ
        buttonWidth = (int) (200 * scale);
        buttonHeight = (int) (100 * scale);
        buttonLayoutParams = new RelativeLayout.LayoutParams(buttonWidth, buttonHeight);

        // button margin : left, top, right, bottom
        buttonLayoutParams.setMargins((int) (105 * scale), (int) (360 * scale), 0, 0);

        button.setLayoutParams(buttonLayoutParams);

        layout.addView(button);

        // リスナーをボタンに登録
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonWidth = (int) ((r.nextInt(100) + 100) * scale);
                buttonHeight = (int) ((r.nextInt(50) + 50) * scale);
                buttonLayoutParams = new RelativeLayout.LayoutParams(buttonWidth, buttonHeight);
                // setMargins (int left, int top, int right, int bottom)
                buttonLayoutParams.setMargins((int) (r.nextInt(300) * scale), (int) (r.nextInt(600) * scale), 100, 0);
                button.setLayoutParams(buttonLayoutParams);
                textView.setText(R.string.hello);
            }
        });
    }
/*
    private void mode1() {
        buttonWidth = (int) ((r.nextInt(100) + 100) * scale);
        buttonHeight = (int) ((r.nextInt(50) + 50) * scale);
        buttonLayoutParams = new RelativeLayout.LayoutParams(buttonWidth, buttonHeight);
        // setMargins (int left, int top, int right, int bottom)
        buttonLayoutParams.setMargins((int) (r.nextInt(300) * scale), (int) (r.nextInt(600) * scale), 100, 0);
        button.setLayoutParams(buttonLayoutParams);
        textView.setText(R.string.hello);
    }
 */
}