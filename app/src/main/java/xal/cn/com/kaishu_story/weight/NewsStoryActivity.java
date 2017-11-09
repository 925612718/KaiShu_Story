package xal.cn.com.kaishu_story.weight;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.OnClick;
import xal.cn.com.kaishu_story.R;
import xal.cn.com.kaishu_story.adapter.NewsStoryAdapter;
import xal.cn.com.kaishu_story.base.BaseActivity;

public class NewsStoryActivity extends BaseActivity {

    @BindView(R.id.news_image_back)
    ImageView newsImageBack;
    @BindView(R.id.news_story_image)
    ImageView newsStoryImage;
    @BindView(R.id.news_story_list)
    ListView newsStoryList;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_news_story;
    }

    @Override
    protected void initView() {
        NewsStoryAdapter storyAdapter =new NewsStoryAdapter(R.layout.news_story_item,null);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initDate() {

    }


    @OnClick({R.id.news_image_back, R.id.news_story_image})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.news_image_back:
                finish();
                break;
            case R.id.news_story_image:
                break;
        }
    }
}
