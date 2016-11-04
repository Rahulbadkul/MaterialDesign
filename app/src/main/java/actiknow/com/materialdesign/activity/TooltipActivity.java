package actiknow.com.materialdesign.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import actiknow.com.materialdesign.R;
import it.sephiroth.android.library.tooltip.Tooltip;


public class TooltipActivity extends AppCompatActivity {

    Button btTooltip;
    TextView tvTooltip;

    private Tooltip.TooltipView tooltip;
    private Tooltip.ClosePolicy mClosePolicy = Tooltip.ClosePolicy.TOUCH_ANYWHERE_CONSUME;


    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_tooltip);

        Toolbar toolbar = (Toolbar) findViewById (R.id.toolbar);
        setSupportActionBar (toolbar);
        getSupportActionBar ().setDisplayHomeAsUpEnabled (true);


        final DisplayMetrics metrics = getResources ().getDisplayMetrics ();

        btTooltip = (Button) findViewById (R.id.btShowTooltip);
        tvTooltip = (TextView) findViewById (R.id.tvTextClick);

        btTooltip.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View v) {
                Tooltip.make (
                        TooltipActivity.this,
                        new Tooltip.Builder ()
                                .anchor (v, Tooltip.Gravity.TOP)
                                .closePolicy (mClosePolicy, 5000)
                                .text (
                                        "RIGHT. Touch outside to close this tooltip. RIGHT. Touch outside to close this tooltip. RIGHT. Touch"
                                                + " outside to close this tooltip.")
                                .withStyleId (R.style.ToolTipLayoutCustomStyle)
                                .fitToScreen (true)
                                .withOverlay (false)
                                .fadeDuration (500)
                                .maxWidth (metrics.widthPixels / 2)
                                .activateDelay (500)
                                .floatingAnimation (Tooltip.AnimationBuilder.SLOW)
                                .build ()
                ).show ();
            }
        });

        tvTooltip.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View v) {
                Tooltip.make (
                        TooltipActivity.this,
                        new Tooltip.Builder ()
                                .anchor (v, Tooltip.Gravity.RIGHT)
                                .closePolicy (mClosePolicy, 5000)
                                .text ("Textview touched")
                                .withStyleId (R.style.ToolTipLayoutCustomStyle)
                                .fitToScreen (true)
                                .withOverlay (false)
                                .fadeDuration (500)
                                .maxWidth (metrics.widthPixels / 2)
                                .activateDelay (500)
                                .floatingAnimation (Tooltip.AnimationBuilder.SLOW)
                                .build ()
                ).show ();
            }
        });
    }
}