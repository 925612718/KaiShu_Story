package xal.cn.com.kaishu_story.weight;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import xal.cn.com.kaishu_story.R;

public class Exchange extends AppCompatActivity {

    @BindView(R.id.ex_back)
    ImageView exBack;
    @BindView(R.id.cir_saoyisao)
    CircleImageView cirSaoyisao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exchange);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.ex_back, R.id.cir_saoyisao})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ex_back:
                finish();
                break;
            case R.id.cir_saoyisao:
                startActivity(new Intent(this,ErWeiMa.class));
                break;
        }
    }
}
