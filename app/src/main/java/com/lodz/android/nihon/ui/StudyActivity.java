package com.lodz.android.nihon.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IntDef;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.lodz.android.component.base.activity.BaseActivity;
import com.lodz.android.component.widget.base.TitleBarLayout;
import com.lodz.android.nihon.R;
import com.lodz.android.nihon.bean.SoundBean;

import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * 学习页面
 * Created by zhouL on 2017/2/26.
 */
public class StudyActivity extends BaseActivity {

    @IntDef({SoundType.HIRAGANA_FIFTY_SOUND_TYPE, SoundType.HIRAGANA_VOCAL_TYPE, SoundType.HIRAGANA_TWISTED_SOUND_TYPE,
            SoundType.KATAKANA_FIFTY_SOUND_TYPE, SoundType.KATAKANA_VOCAL_TYPE, SoundType.KATAKANA_TWISTED_SOUND_TYPE,
            SoundType.HIRAGANA_KATAKANA_FIFTY_SOUND_TYPE, SoundType.HIRAGANA_KATAKANA_VOCAL_TYPE, SoundType.HIRAGANA_KATAKANA_TWISTED_SOUND_TYPE,
            SoundType.ALL_TYPE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface SoundType {

        /** 平假名五十音 */
        public static final int HIRAGANA_FIFTY_SOUND_TYPE = 1;
        /** 平假名浊音 */
        public static final int HIRAGANA_VOCAL_TYPE = 2;
        /** 平假名拗音 */
        public static final int HIRAGANA_TWISTED_SOUND_TYPE = 3;

        /** 片假名五十音 */
        public static final int KATAKANA_FIFTY_SOUND_TYPE = 4;
        /** 片假名浊音 */
        public static final int KATAKANA_VOCAL_TYPE = 5;
        /** 片假名拗音 */
        public static final int KATAKANA_TWISTED_SOUND_TYPE = 6;

        /** 平假名、片假名五十音 */
        public static final int HIRAGANA_KATAKANA_FIFTY_SOUND_TYPE = 7;
        /** 平假名、片假名浊音 */
        public static final int HIRAGANA_KATAKANA_VOCAL_TYPE = 8;
        /** 平假名、片假名拗音 */
        public static final int HIRAGANA_KATAKANA_TWISTED_SOUND_TYPE = 9;

        /** 全混合 */
        public static final int ALL_TYPE = 10;
    }

    /** 学习类型 */
    private static final String EXTRA_TYPE = "extra_type";
    /** 音标列表 */
    private static final String EXTRA_SOUND_LIST = "extra_sound_list";

    /**
     * 启动学习页面
     * @param context 上下文
     * @param type 学习类型
     * @param list 音标列表
     */
    public static void start(Context context, @SoundType int type, List<SoundBean> list){
        Intent intent = new Intent();
        intent.setClass(context, StudyActivity.class);
        intent.putExtra(EXTRA_TYPE, type);
        intent.putExtra(EXTRA_SOUND_LIST, (Serializable) list);
        context.startActivity(intent);
    }

    /** 发音 */
    @BindView(R.id.pronunciation)
    TextView mPronunciationTextView;
    /** 主文字 */
    @BindView(R.id.main_text)
    TextView mMainTextView;
    /** 副文字 */
    @BindView(R.id.other_text)
    TextView mOtherTextView;

    /** 显示其他信息 */
    @BindView(R.id.show_other_btn)
    Button mShowOtherButton;
    /** 下一个 */
    @BindView(R.id.next_btn)
    Button mNextButton;

    /** 学习类型 */
    private int mType = SoundType.HIRAGANA_FIFTY_SOUND_TYPE;
    /** 音标列表 */
    private List<SoundBean> mList;

    @Override
    protected void startCreate() {
        super.startCreate();
        Intent intent = getIntent();
        mType = intent.getIntExtra(EXTRA_TYPE, SoundType.HIRAGANA_FIFTY_SOUND_TYPE);
        mList = (List<SoundBean>) intent.getSerializableExtra(EXTRA_SOUND_LIST);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_study_layout;
    }

    @Override
    protected void findViews(Bundle savedInstanceState) {
        ButterKnife.bind(this);
    }

    @Override
    protected void setListeners() {
        super.setListeners();
        mShowOtherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mPronunciationTextView.getVisibility() == View.GONE){
                    mPronunciationTextView.setVisibility(View.VISIBLE);
                    mOtherTextView.setVisibility(View.VISIBLE);
                }else {
                    mPronunciationTextView.setVisibility(View.GONE);
                    mOtherTextView.setVisibility(View.GONE);
                }
            }
        });

        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bindData(mType, mList, getRandom(mList.size()));
            }
        });
    }

    @Override
    protected void initData() {
        super.initData();
        initTitleBar(getTitleBarLayout());
        bindData(mType, mList, getRandom(mList.size()));
        showStatusCompleted();
    }

    private void initTitleBar(TitleBarLayout titleBarLayout) {
        titleBarLayout.setTitleName(getTitleByType(mType));
        titleBarLayout.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorAccent));
    }

    /**
     * 根据类型获取标题
     * @param type 类型
     */
    private String getTitleByType(int type) {
        switch (type){
            case SoundType.HIRAGANA_FIFTY_SOUND_TYPE:
                return getString(R.string.main_hiragana_fifty_sound);
            case SoundType.HIRAGANA_VOCAL_TYPE:
                return getString(R.string.main_hiragana_vocal);
            case SoundType.HIRAGANA_TWISTED_SOUND_TYPE:
                return getString(R.string.main_hiragana_twisted_sound);
            case SoundType.KATAKANA_FIFTY_SOUND_TYPE:
                return getString(R.string.main_katakana_fifty_sound);
            case SoundType.KATAKANA_VOCAL_TYPE:
                return getString(R.string.main_katakana_vocal);
            case SoundType.KATAKANA_TWISTED_SOUND_TYPE:
                return getString(R.string.main_katakana_twisted_sound);
            case SoundType.HIRAGANA_KATAKANA_FIFTY_SOUND_TYPE:
                return getString(R.string.main_hiragana_katakana_fifty_sound);
            case SoundType.HIRAGANA_KATAKANA_VOCAL_TYPE:
                return getString(R.string.main_hiragana_katakana_vocal);
            case SoundType.HIRAGANA_KATAKANA_TWISTED_SOUND_TYPE:
                return getString(R.string.main_hiragana_katakana_twisted_sound);
            case SoundType.ALL_TYPE:
                return getString(R.string.main_all);
            default:
                return getString(R.string.app_name);
        }
    }

    @Override
    protected void clickBackBtn() {
        super.clickBackBtn();
        finish();
    }

    /**
     * 绑定数据
     * @param type 学习类型
     * @param list 音标列表
     * @param index 索引
     */
    private void bindData(int type, List<SoundBean> list, int index) {
        mPronunciationTextView.setVisibility(View.GONE);
        mMainTextView.setVisibility(View.VISIBLE);
        mOtherTextView.setVisibility(View.GONE);

        SoundBean bean = list.get(index);
        mPronunciationTextView.setText(bean.pronunciation);
        switch (type){
            case SoundType.HIRAGANA_FIFTY_SOUND_TYPE:
            case SoundType.HIRAGANA_VOCAL_TYPE:
                mMainTextView.setText(bean.hiraganaText);
                mOtherTextView.setText(bean.katakanaText);
                break;
            case SoundType.HIRAGANA_TWISTED_SOUND_TYPE:
            case SoundType.KATAKANA_FIFTY_SOUND_TYPE:
            case SoundType.KATAKANA_VOCAL_TYPE:
                mMainTextView.setText(bean.katakanaText);
                mOtherTextView.setText(bean.hiraganaText);
                break;
            case SoundType.KATAKANA_TWISTED_SOUND_TYPE:
            case SoundType.HIRAGANA_KATAKANA_FIFTY_SOUND_TYPE:
            case SoundType.HIRAGANA_KATAKANA_VOCAL_TYPE:
            case SoundType.HIRAGANA_KATAKANA_TWISTED_SOUND_TYPE:
            case SoundType.ALL_TYPE:
        }
    }

    private int getRandom(int length){
        Random random = new Random();
        return random.nextInt(length);
    }

}
