package com.lodz.android.nihon.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.core.content.ContextCompat;

import com.lodz.android.corekt.utils.ToastUtils;
import com.lodz.android.nihon.R;
import com.lodz.android.nihon.utils.DataUtils;
import com.lodz.android.pandora.base.activity.BaseActivity;
import com.lodz.android.pandora.widget.base.TitleBarLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 主界面
 * Created by zhouL on 2017/2/25.
 */
public class MainActivity extends BaseActivity {

    /** 平假名五十音 */
    @BindView(R.id.main_hiragana_fifty_sound)
    Button mHiraganaFiftySoundButton;
    /** 平假名浊音 */
    @BindView(R.id.main_hiragana_vocal)
    Button mHiraganaVocalButton;
    /** 平假名拗音 */
    @BindView(R.id.main_hiragana_twisted_sound)
    Button mHiraganaTwistedSoundButton;

    /** 片假名五十音 */
    @BindView(R.id.main_katakana_fifty_sound)
    Button mKatakanaFiftySoundButton;
    /** 片假名浊音 */
    @BindView(R.id.main_katakana_vocal)
    Button mKatakanaVocalButton;
    /** 片假名拗音 */
    @BindView(R.id.main_katakana_twisted_sound)
    Button mKatakanaTwistedSoundButton;

    /** 平假名、片假名五十音 */
    @BindView(R.id.main_hiragana_katakana_fifty_sound)
    Button mHiraganaKatakanaFiftySoundButton;
    /** 平假名、片假名浊音 */
    @BindView(R.id.main_hiragana_katakana_vocal)
    Button mHiraganaKatakanaVocalButton;
    /** 平假名、片假名拗音 */
    @BindView(R.id.main_hiragana_katakana_twisted_sound)
    Button mHiraganaKatakanaTwistedSoundButton;

    /** 全混合 */
    @BindView(R.id.main_all)
    Button mAllButton;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void findViews(Bundle savedInstanceState) {
        ButterKnife.bind(this);
    }

    @Override
    protected void setListeners() {
        super.setListeners();
        mHiraganaFiftySoundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StudyActivity.start(getContext(), StudyActivity.SoundType.HIRAGANA_FIFTY_SOUND_TYPE, DataUtils.getFiftySoundList());
            }
        });

        mHiraganaVocalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StudyActivity.start(getContext(), StudyActivity.SoundType.HIRAGANA_VOCAL_TYPE, DataUtils.getVocalList());
            }
        });

        mHiraganaTwistedSoundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showShort(getContext(), "开发中");
            }
        });

        mKatakanaFiftySoundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StudyActivity.start(getContext(), StudyActivity.SoundType.KATAKANA_FIFTY_SOUND_TYPE, DataUtils.getFiftySoundList());
            }
        });

        mKatakanaVocalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StudyActivity.start(getContext(), StudyActivity.SoundType.KATAKANA_VOCAL_TYPE, DataUtils.getVocalList());
            }
        });

        mKatakanaTwistedSoundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showShort(getContext(), "开发中");
            }
        });

        mHiraganaKatakanaFiftySoundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showShort(getContext(), "开发中");
            }
        });

        mHiraganaKatakanaVocalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showShort(getContext(), "开发中");
            }
        });

        mHiraganaKatakanaTwistedSoundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showShort(getContext(), "开发中");
            }
        });

        mAllButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showShort(getContext(), "开发中");
            }
        });
    }

    @Override
    protected void initData() {
        super.initData();
        initTitleBar(getTitleBarLayout());
        showStatusCompleted();
    }

    private void initTitleBar(TitleBarLayout titleBarLayout) {
        titleBarLayout.needBackButton(false);
        titleBarLayout.setTitleName(R.string.app_name);
        titleBarLayout.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorAccent));
    }


}
