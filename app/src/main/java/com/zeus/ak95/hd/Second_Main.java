package com.zeus.ak95.hd;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

@SuppressWarnings("deprecation")
public class Second_Main extends AppCompatActivity implements View.OnClickListener,AdapterView.OnItemSelectedListener,ViewSwitcher.ViewFactory{
    private ImageSwitcher mSwitcher;
    private Context mContext;
    private Integer[] mThumbIds = {
            R.drawable.pict1, R.drawable.pict2,
            R.drawable.pict3, R.drawable.pict4,
            R.drawable.pict5, R.drawable.pict6,
            R.drawable.pict7, R.drawable.pict8,
            R.drawable.pict9};
    private Integer[] mImageIds = {
            R.drawable.picm1, R.drawable.picm2,
            R.drawable.picm3, R.drawable.picm4,
            R.drawable.picm5, R.drawable.picm6,
            R.drawable.picm7, R.drawable.picm8,
            R.drawable.picm9};
    private Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second__main);

        bt = (Button) findViewById(R.id.sbtn1);
        bt.setOnClickListener(this);


        mSwitcher = (ImageSwitcher) findViewById(R.id.simgs1);
        mSwitcher.setFactory(this);
       // mSwitcher.setAnimation(AnimationUtils.loadAnimation(this, R.anim.fade_in));
       // mSwitcher.setAnimation(AnimationUtils.loadAnimation(this, R.anim.fade_out));

        Gallery g = (Gallery) findViewById(R.id.sgl1);
        g.setAdapter(new ImageAdapter(this));
        g.setOnItemSelectedListener(this);
    }



    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
        mSwitcher.setImageResource(mImageIds[pos]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        mSwitcher.setImageResource(R.drawable.picm1);

    }

    @Override
    public View makeView() {
        ImageView i = new ImageView(this);
        i.setBackgroundColor(0xFF33AA88);
        i.setScaleType(ImageView.ScaleType.FIT_CENTER);
        i.setLayoutParams(new ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));
        return i;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.sbtn1:
                Intent in1 = new Intent(Intent.ACTION_SEND);
                in1.putExtra(Intent.EXTRA_TEXT, "");
                in1.putExtra(Intent.EXTRA_SUBJECT, "FeedBack Mail");
                in1.putExtra(Intent.EXTRA_EMAIL, new String[]{"yoashish1995@gmail.com"});
                in1.setType("message/rfc822");
                startActivity(in1.createChooser(in1,"Choose an Email Client : "));
        }
    }

    public class ImageAdapter extends BaseAdapter{
        public ImageAdapter(Context c){
          mContext = c;
        }

        @Override
        public int getCount() {
            return mThumbIds.length;
        }

        @Override
        public Object getItem(int pos) {
            return pos;
        }

        @Override
        public long getItemId(int pos) {
            return pos;
        }

        @Override
        public View getView(int pos, View view, ViewGroup viewGroup) {
            ImageView i  = new ImageView(mContext);
            i.setImageResource(mThumbIds[pos]);
            i.setAdjustViewBounds(true);
            i.setLayoutParams(new Gallery.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            i.setBackgroundResource(R.drawable.pict1);
            return i;
        }
    }
}
