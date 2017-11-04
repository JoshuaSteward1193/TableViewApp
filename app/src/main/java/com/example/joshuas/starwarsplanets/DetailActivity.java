package com.example.joshuas.starwarsplanets;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    String[] planets;
    String[] descriptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent in = getIntent();
        int index = in.getIntExtra("com.example.joshuas.starwarsplanets.INDEX", -1);
        Resources res = getResources();
        planets = res.getStringArray(R.array.planets);
        descriptions = res.getStringArray(R.array.descriptions);

        if (index > -1) {
            int pic = getImage(index);
            ImageView img = (ImageView) findViewById(R.id.imageView);
            TextView name = (TextView) findViewById(R.id.txtName);
            TextView desc = (TextView) findViewById(R.id.txtDescription);
            scaleImg(img, pic);
            name.setText(planets[index]);
            desc.setText(descriptions[index]);
        }
    }

    private int getImage(int index) {
        switch (index) {
            case 0: return R.drawable.alderaan;
            case 1: return R.drawable.cato_neimoidia;
            case 2: return R.drawable.christophsis;
            case 3: return R.drawable.coruscant;
            case 4: return R.drawable.dagobah;
            case 5: return R.drawable.dantooine;
            case 6: return R.drawable.endor;
            case 7: return R.drawable.felucia;
            case 8: return R.drawable.geonosis;
            case 9: return R.drawable.hoth;
            case 10: return R.drawable.jakku;
            case 11: return R.drawable.kashyyyk;
            case 12: return R.drawable.mandalore;
            case 13: return R.drawable.mustafar;
            default: return -1;
        }
    }

    private void scaleImg(ImageView img, int pic) {
        Display screen = getWindowManager().getDefaultDisplay();
        BitmapFactory.Options options = new BitmapFactory.Options();

        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), pic, options);

        int imgWidth = options.outWidth;
        int screenWidth = screen.getWidth();

        if (imgWidth > screenWidth) {
            int ratio = Math.round( (float)imgWidth / (float)screenWidth);
            options.inSampleSize = ratio;
        }
        options.inJustDecodeBounds = false;
        Bitmap scaledImg = BitmapFactory.decodeResource(getResources(), pic, options);
        img.setImageBitmap(scaledImg);

    }
}
