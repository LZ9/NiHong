package com.lodz.android.nihon.utils;

import com.lodz.android.nihon.bean.SoundBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据帮助类
 * Created by zhouL on 2017/2/26.
 */
public class DataUtils {

    /** 五十音发音 */
    private static final String[] mPronunciationFiftySound = new String[]{
            "a", "i", "u", "e", "o",
            "ka", "ki", "ku", "ke", "ko",
            "sa", "shi", "su", "se", "so",
            "ta", "chi", "tsu", "te", "to",
            "na", "ni", "nu", "ne", "no",
            "ha", "hi", "hu", "he", "ho",
            "ma", "mi", "mu", "me", "mo",
            "ya", "yu", "yo",
            "ra", "ri", "ru", "re", "ro",
            "wa", "o",
            "n"};

    /** 平假名五十音 */
    private static final String[] mHiraganaFiftySound = new String[]{
            "あ", "い", "う", "え", "お",
            "か", "き", "く", "け", "こ",
            "さ", "し", "す", "せ", "そ",
            "た", "ち", "つ", "て", "と",
            "な", "に", "ぬ", "ね", "の",
            "は", "ひ", "ふ", "へ", "ほ",
            "ま", "み", "む", "め", "も",
            "や", "ゆ", "よ",
            "ら", "り", "る", "れ", "ろ",
            "わ", "を",
            "ん"};

    /** 片假名五十音 */
    private static final String[] mKatakanaFiftySound = new String[]{
            "ア", "イ", "ウ", "エ", "オ",
            "カ", "キ", "ク", "ケ", "コ",
            "サ", "シ", "ス", "セ", "ソ",
            "タ", "チ", "ツ", "テ", "ト",
            "ナ", "ニ", "ヌ", "ネ", "ノ",
            "ハ", "ヒ", "フ", "ヘ", "ホ",
            "マ", "ミ", "ム", "メ", "モ",
            "ヤ", "ユ", "ヨ",
            "ラ", "リ", "ル", "レ", "ロ",
            "ワ", "ヲ",
            "ン"};

    /** 获取五十音列表 */
    public static List<SoundBean> getFiftySoundList() {
        List<SoundBean> list = new ArrayList<>();
        for (int i = 0; i < mHiraganaFiftySound.length; i++) {
            SoundBean bean = new SoundBean();
            bean.pronunciation = mPronunciationFiftySound[i];
            bean.hiraganaText = mHiraganaFiftySound[i];
            bean.katakanaText = mKatakanaFiftySound[i];
            list.add(bean);
        }
        return list;
    }

    /** 浊音发音 */
    private static final String[] mPronunciationVocal = new String[]{
            "ga", "gi", "gu", "ge", "go",
            "za", "ji", "zu", "ze", "zo",
            "da", "ji", "zu", "de", "do",
            "ba", "bi", "bu", "be", "bo",
            "pa", "pi", "pu", "pe", "po"};
    /** 平假名浊音 */
    private static final String[] mHiraganaVocal = new String[]{
            "が", "ぎ", "ぐ", "げ", "ご",
            "ざ", "じ", "ず", "ぜ", "ぞ",
            "だ", "ぢ", "づ", "で", "ど",
            "ば", "び", "ぶ", "べ", "ぼ",
            "ぱ", "ぴ", "ぷ", "ぺ", "ぽ"};
    /** 片假名浊音 */
    private static final String[] mKatakanaVocal = new String[]{
            "ガ", "ギ", "グ", "ゲ", "ゴ",
            "ザ", "ジ", "ズ", "ゼ", "ゾ",
            "ダ", "ヂ", "ヅ", "デ", "ド",
            "バ", "ビ", "ブ", "ベ", "ボ",
            "パ", "ピ", "プ", "ペ", "ポ"};

    /** 获取浊音列表 */
    public static List<SoundBean> getVocalList() {
        List<SoundBean> list = new ArrayList<>();
        for (int i = 0; i < mHiraganaVocal.length; i++) {
            SoundBean bean = new SoundBean();
            bean.pronunciation = mPronunciationVocal[i];
            bean.hiraganaText = mHiraganaVocal[i];
            bean.katakanaText = mKatakanaVocal[i];
            list.add(bean);
        }
        return list;
    }

    /** 获取拗音列表 */
    public static List<SoundBean> getTwistedSoundList() {
        return null;
    }

}
