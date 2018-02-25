package nfnlabs.in.aruncolourpalletecheck;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    ColourPalleteUtil colourPalleteUtil;
    @BindView(R.id.ivProfile)
    ImageView ivProfile;
    @BindView(R.id.rlDominant)
    RelativeLayout rlDominant;
    @BindView(R.id.rlVibrant)
    RelativeLayout rlVibrant;
    @BindView(R.id.rlMutant)
    RelativeLayout rlMutant;
    @BindView(R.id.rlDarkMuted)
    RelativeLayout rlDarkMuted;
    @BindView(R.id.rlLightVibrant)
    RelativeLayout rlLightVibrant;
    @BindView(R.id.rlLightMuted)
    RelativeLayout rlLightMuted;
    @BindView(R.id.fabGetColor)
    FloatingActionButton fabGetColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        colourPalleteUtil = new ColourPalleteUtil();
        Picasso.with(this).load(R.drawable.sachin).into(ivProfile);


    }


    private Bitmap getBitmap() {

        Bitmap bitmap = ((BitmapDrawable)ivProfile.getDrawable()).getBitmap();
//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.newyork);

        return bitmap;
    }

    @OnClick(R.id.fabGetColor)
    public void onViewClicked() {
        colourPalleteUtil.getImageColorData(getBitmap(), new PalleteColourListener() {
            @Override
            public void getColurPallete(Palette pallete) {
                rlMutant.setBackgroundColor(pallete.getDarkMutedColor(pallete.getMutedColor(0)));
                rlDominant.setBackgroundColor(pallete.getDominantColor(pallete.getLightVibrantColor(0)));
                rlVibrant.setBackgroundColor(pallete.getVibrantColor(pallete.getLightVibrantColor(0)));
                rlLightVibrant.setBackgroundColor(pallete.getLightVibrantColor(pallete.getLightVibrantColor(0)));
                rlDarkMuted.setBackgroundColor(pallete.getDarkMutedColor(pallete.getLightVibrantColor(0)));
                rlLightMuted.setBackgroundColor(pallete.getLightMutedColor(pallete.getLightVibrantColor(0)));
            }
        });
    }
}
