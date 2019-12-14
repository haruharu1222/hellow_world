package com.example.imageview;
//Android
import androidx.appcompat.app.AppCompatActivity;
//import android.support.v7.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private LinearLayout.LayoutParams layoutParams;
    private ImageView imageView;
    private int imageWidth, imageHeight;
    ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // リニアレイアウトのインスタンス生成
        LinearLayout layout = new LinearLayout(this);

        //垂直方向にレイアウト内のパーツを並べる設定とする
        layout.setOrientation(LinearLayout.VERTICAL);

        //レイアウトの縦横サイズをMATCH_PARENTにする
        layout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));

        // レイアウト中央寄せ
        layout.setGravity(Gravity.CENTER);

        // 背景色
        layout.setBackgroundColor(Color.argb(0xff, 0xaa, 0xcc, 0xff));

        //setContentViewにlayoutを設定
        setContentView(layout);


        // ImageViewのインスタンス生成
        imageView = new ImageView(this);
        imageView.setImageResource(R.drawable.santa);

        // 元画像の1/2
        imageWidth = 300;
        imageHeight = 300;

        //画像の縦横サイズをimageViewのサイズとして設定
        layoutParams = new LinearLayout.LayoutParams(imageWidth, imageHeight);
        imageView.setLayoutParams(layoutParams);

        //layoutにimageViewを追加
        layout.addView(imageView);

        // ボタンの設定
        Button button = new Button(this);
        String str = "Button";
        button.setText(str);

        LinearLayout.LayoutParams buttonLayoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        button.setLayoutParams(buttonLayoutParams);
        layout.addView(button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ボタンタップ毎に画像を拡大
                imageWidth += 200;
                imageHeight += 200;

                layoutParams = new LinearLayout.LayoutParams(imageWidth, imageHeight);
                imageView.setLayoutParams(layoutParams);
            }
        });
    }
}