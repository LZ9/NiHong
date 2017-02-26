package com.lodz.android.nihon.bean;

import java.io.Serializable;

/**
 * 五十音实体
 * Created by zhouL on 2017/2/25.
 */
public class SoundBean implements Serializable{

    /** 发音 */
    public String pronunciation;
    /** 平假名文字 */
    public String hiraganaText;
    /** 片假名文字 */
    public String katakanaText;

}
