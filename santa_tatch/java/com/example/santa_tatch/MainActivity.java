package com.example.santa_tatch;
//AndroidX
import androidx.appcompat.app.AppCompatActivity;
//import android.support.v7.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private LinearLayout.LayoutParams buttonLayoutParams;
    private  ImageButton imageButton;
    private int scale;
    private int marginR;
    private int marginU;
    private int marginL;
    private int marginD;

    Random r = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // リニアレイアウトの設定
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        int mParent = LinearLayout.LayoutParams.MATCH_PARENT;
        int wContent = LinearLayout.LayoutParams.WRAP_CONTENT;

        layout.setLayoutParams(new LinearLayout.LayoutParams(mParent, mParent));

        // レイアウト中央寄せ
        layout.setGravity(Gravity.CENTER);
        // 背景色
        layout.setBackgroundColor(Color.parseColor("#ffdfcf"));

        setContentView(layout);

        scale = TypedValue.COMPLEX_UNIT_DIP;
        // ボタンの設定
        imageButton = new ImageButton(this);

        //ボタンサイズ
        int dpH = (int) TypedValue.applyDimension(scale, 200, getResources().getDisplayMetrics());
        int dpD = (int) TypedValue.applyDimension(scale, 100, getResources().getDisplayMetrics());
        buttonLayoutParams = new LinearLayout.LayoutParams(dpH, dpD);

        // margin
        int margin10 = 10 * scale;
        buttonLayoutParams.setMargins(margin10, margin10, margin10, margin10);

        // ボタンに画像を設定
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.santa);
        Drawable drawable = new BitmapDrawable(getResources(), bitmap);

        // Bitmapで画像を設定
        imageButton.setImageBitmap(bitmap);

        imageButton.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageButton.setBackgroundColor(Color.parseColor("#00000000"));

        imageButton.setLayoutParams(buttonLayoutParams);
        layout.addView(imageButton);

        // リスナーをボタンに登録
        imageButton. setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch ((int)(r.nextInt(4))) {
                    case 0: mode1();
                            break;
                    case 1: mode2();
                        break;
                    case 2: mode3();
                        break;
                    case 3: mode4();
                        break;
                    default:break;
                }

                buttonLayoutParams.setMargins(marginL, marginU, marginR, marginD);
                imageButton.setLayoutParams(buttonLayoutParams);
            }
        });
    }
    //上右
    private void mode1() {
        marginL = (int) (r.nextInt(300) + 300) * scale;
        marginU = 10 * scale;
        marginR = 10 * scale;
        marginD = (int) (r.nextInt(800) + 400) * scale;
    }
    //上左
    private void mode2() {
        marginL = 10 * scale;
        marginU = 10 * scale;
        marginR = (int) (r.nextInt(300) + 300) * scale;
        marginD = (int) (r.nextInt(800) + 400) * scale;
    }
    //下右
    private void mode3() {
        marginL = (int) (r.nextInt(300) + 300) * scale;
        marginU = (int) (r.nextInt(800) + 400) * scale;
        marginR = 10 * scale;
        marginD = 10 * scale;
    }
    //下左
    private void mode4() {
        marginL = 10 * scale;
        marginU = (int) (r.nextInt(800) + 400) * scale;
        marginR = (int) (r.nextInt(300) + 300) * scale;
        marginD = 10 * scale;
    }

}










/*
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

}
 */