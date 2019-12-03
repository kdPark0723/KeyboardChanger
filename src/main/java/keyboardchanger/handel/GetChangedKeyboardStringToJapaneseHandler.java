package keyboardchanger.handel;

import com.kdpark0723.keyboardchanger.handel.GetChangedKeyboardStringHandler;
import com.kdpark0723.keyboardchanger.model.KeyboardString;
import com.kdpark0723.keyboardchanger.model.KeyboardType;
import org.jetbrains.annotations.NotNull;

public class GetChangedKeyboardStringToJapaneseHandler extends GetChangedKeyboardStringHandler {

    GetChangedKeyboardStringToJapaneseHandler() {
        super(KeyboardType.JAPANESE);
    }


    private String changeEnlish2Japanese(String English2JapaneseString){
        English2JapaneseString = English2JapaneseString.replaceAll("ka", "か");
        English2JapaneseString = English2JapaneseString.replaceAll("ki", "き");
        English2JapaneseString = English2JapaneseString.replaceAll("ku", "く");
        English2JapaneseString = English2JapaneseString.replaceAll("ke", "け");
        English2JapaneseString = English2JapaneseString.replaceAll("ko", "こ");
        English2JapaneseString = English2JapaneseString.replaceAll("kya", "きゃ");
        English2JapaneseString = English2JapaneseString.replaceAll("kyu", "きゅ");
        English2JapaneseString = English2JapaneseString.replaceAll("kyo", "きょ");

        English2JapaneseString = English2JapaneseString.replaceAll("ta", "た");
        English2JapaneseString = English2JapaneseString.replaceAll("chi", "ち");
        English2JapaneseString = English2JapaneseString.replaceAll("tsu", "つ");
        English2JapaneseString = English2JapaneseString.replaceAll("te", "て");
        English2JapaneseString = English2JapaneseString.replaceAll("to", "と");
        English2JapaneseString = English2JapaneseString.replaceAll("cha", "ちゃ");
        English2JapaneseString = English2JapaneseString.replaceAll("chu", "ちゅ");
        English2JapaneseString = English2JapaneseString.replaceAll("cho", "ちょ");

        English2JapaneseString = English2JapaneseString.replaceAll("sa", "さ");
        English2JapaneseString = English2JapaneseString.replaceAll("si", "し");
        English2JapaneseString = English2JapaneseString.replaceAll("su", "す");
        English2JapaneseString = English2JapaneseString.replaceAll("se", "せ");
        English2JapaneseString = English2JapaneseString.replaceAll("so", "そ");
        English2JapaneseString = English2JapaneseString.replaceAll("sya", "しゃ");
        English2JapaneseString = English2JapaneseString.replaceAll("syu", "しゅ");
        English2JapaneseString = English2JapaneseString.replaceAll("syo", "しょ");

        English2JapaneseString = English2JapaneseString.replaceAll("na", "な");
        English2JapaneseString = English2JapaneseString.replaceAll("ni", "に");
        English2JapaneseString = English2JapaneseString.replaceAll("nu", "ぬ");
        English2JapaneseString = English2JapaneseString.replaceAll("ne", "ね");
        English2JapaneseString = English2JapaneseString.replaceAll("no", "の");
        English2JapaneseString = English2JapaneseString.replaceAll("nya", "にゃ");
        English2JapaneseString = English2JapaneseString.replaceAll("nyu", "にゅ");
        English2JapaneseString = English2JapaneseString.replaceAll("nyo", "にょ");

        English2JapaneseString = English2JapaneseString.replaceAll("ma", "ま");
        English2JapaneseString = English2JapaneseString.replaceAll("mi", "み");
        English2JapaneseString = English2JapaneseString.replaceAll("mu", "む");
        English2JapaneseString = English2JapaneseString.replaceAll("me", "め");
        English2JapaneseString = English2JapaneseString.replaceAll("mo", "も");
        English2JapaneseString = English2JapaneseString.replaceAll("mya", "みゃ");
        English2JapaneseString = English2JapaneseString.replaceAll("myu", "みゅ");
        English2JapaneseString = English2JapaneseString.replaceAll("myo", "みょ");

        English2JapaneseString = English2JapaneseString.replaceAll("ra", "ら");
        English2JapaneseString = English2JapaneseString.replaceAll("ri", "り");
        English2JapaneseString = English2JapaneseString.replaceAll("ru", "る");
        English2JapaneseString = English2JapaneseString.replaceAll("re", "れ");
        English2JapaneseString = English2JapaneseString.replaceAll("ro", "ろ");
        English2JapaneseString = English2JapaneseString.replaceAll("rya", "りゃ");
        English2JapaneseString = English2JapaneseString.replaceAll("ryu", "りゅ");
        English2JapaneseString = English2JapaneseString.replaceAll("ryo", "りょ");

        English2JapaneseString = English2JapaneseString.replaceAll("wa", "わ");
        English2JapaneseString = English2JapaneseString.replaceAll("wi", "ゐ");
        English2JapaneseString = English2JapaneseString.replaceAll("we", "ゑ");
        English2JapaneseString = English2JapaneseString.replaceAll("wo", "を");

        English2JapaneseString = English2JapaneseString.replaceAll("ga", "が");
        English2JapaneseString = English2JapaneseString.replaceAll("gi", "ぎ");
        English2JapaneseString = English2JapaneseString.replaceAll("gu", "ぐ");
        English2JapaneseString = English2JapaneseString.replaceAll("ge", "げ");
        English2JapaneseString = English2JapaneseString.replaceAll("go", "ご");
        English2JapaneseString = English2JapaneseString.replaceAll("gya", "ぎゃ");
        English2JapaneseString = English2JapaneseString.replaceAll("gyu", "ぎゅ");
        English2JapaneseString = English2JapaneseString.replaceAll("gyo", "ぎょ");

        English2JapaneseString = English2JapaneseString.replaceAll("za", "ざ");
        English2JapaneseString = English2JapaneseString.replaceAll("ji", "じ");
        English2JapaneseString = English2JapaneseString.replaceAll("zu", "ず");
        English2JapaneseString = English2JapaneseString.replaceAll("ze", "ぜ");
        English2JapaneseString = English2JapaneseString.replaceAll("zo", "ぞ");
        English2JapaneseString = English2JapaneseString.replaceAll("ja", "じゃ");
        English2JapaneseString = English2JapaneseString.replaceAll("ju", "じゅ");
        English2JapaneseString = English2JapaneseString.replaceAll("jo", "じょ");

        English2JapaneseString = English2JapaneseString.replaceAll("da", "だ");
        English2JapaneseString = English2JapaneseString.replaceAll("ji", "ぢ");
        English2JapaneseString = English2JapaneseString.replaceAll("zu", "づ");
        English2JapaneseString = English2JapaneseString.replaceAll("de", "で");
        English2JapaneseString = English2JapaneseString.replaceAll("do", "ど");
        English2JapaneseString = English2JapaneseString.replaceAll("ja", "ぢゃ");
        English2JapaneseString = English2JapaneseString.replaceAll("ju", "ぢゅ");
        English2JapaneseString = English2JapaneseString.replaceAll("jo", "ぢょ");

        English2JapaneseString = English2JapaneseString.replaceAll("ba", "ば");
        English2JapaneseString = English2JapaneseString.replaceAll("bi", "び");
        English2JapaneseString = English2JapaneseString.replaceAll("bu", "ぶ");
        English2JapaneseString = English2JapaneseString.replaceAll("be", "べ");
        English2JapaneseString = English2JapaneseString.replaceAll("bo", "ぼ");
        English2JapaneseString = English2JapaneseString.replaceAll("bya", "びゃ");
        English2JapaneseString = English2JapaneseString.replaceAll("byu", "びゅ");
        English2JapaneseString = English2JapaneseString.replaceAll("byo", "びょ");

        English2JapaneseString = English2JapaneseString.replaceAll("pa", "ば");
        English2JapaneseString = English2JapaneseString.replaceAll("pi", "び");
        English2JapaneseString = English2JapaneseString.replaceAll("pu", "ぶ");
        English2JapaneseString = English2JapaneseString.replaceAll("pe", "べ");
        English2JapaneseString = English2JapaneseString.replaceAll("po", "ぼ");
        English2JapaneseString = English2JapaneseString.replaceAll("pya", "びゃ");
        English2JapaneseString = English2JapaneseString.replaceAll("pyu", "びゅ");
        English2JapaneseString = English2JapaneseString.replaceAll("pyo", "びょ");

        English2JapaneseString = English2JapaneseString.replaceAll("ha", "は");
        English2JapaneseString = English2JapaneseString.replaceAll("hi", "ひ");
        English2JapaneseString = English2JapaneseString.replaceAll("hu", "ふ");
        English2JapaneseString = English2JapaneseString.replaceAll("he", "へ");
        English2JapaneseString = English2JapaneseString.replaceAll("ho", "ほ");
        English2JapaneseString = English2JapaneseString.replaceAll("hya", "ひゃ");
        English2JapaneseString = English2JapaneseString.replaceAll("hyu", "ひゅ");
        English2JapaneseString = English2JapaneseString.replaceAll("hyo", "ひょ");

        English2JapaneseString = English2JapaneseString.replaceAll("ya", "や");
        English2JapaneseString = English2JapaneseString.replaceAll("yu", "ゆ");
        English2JapaneseString = English2JapaneseString.replaceAll("yo", "よ");

        English2JapaneseString = English2JapaneseString.replaceAll("a", "あ");
        English2JapaneseString = English2JapaneseString.replaceAll("i", "い");
        English2JapaneseString = English2JapaneseString.replaceAll("u", "う");
        English2JapaneseString = English2JapaneseString.replaceAll("e", "え");
        English2JapaneseString = English2JapaneseString.replaceAll("o", "お");

        English2JapaneseString = English2JapaneseString.replaceAll("n", "ん");

        return English2JapaneseString;
    }

    private String changeGatakana(String JapaneseString){
        while(JapaneseString.indexOf(" ") != -1 && JapaneseString.indexOf(" ", JapaneseString.indexOf(" ")+1) != -1){
            JapaneseString = JapaneseString.replace(JapaneseString.substring(JapaneseString.indexOf(" "), JapaneseString.indexOf(" ", JapaneseString.indexOf(" ")+1)+1), changeHiragana2Gatakana(JapaneseString.substring(JapaneseString.indexOf(" "), JapaneseString.indexOf(" ", JapaneseString.indexOf(" ")+1))));
        }
        return JapaneseString;
    }

    private String changeHiragana2Gatakana(String JapaneseSubString){
        JapaneseSubString = JapaneseSubString.trim();
        JapaneseSubString =JapaneseSubString.replaceAll("か", "カ");
        JapaneseSubString =JapaneseSubString.replaceAll("き", "キ");
        JapaneseSubString =JapaneseSubString.replaceAll("く", "ク");
        JapaneseSubString =JapaneseSubString.replaceAll("け", "ケ");
        JapaneseSubString =JapaneseSubString.replaceAll("こ", "コ");
        JapaneseSubString =JapaneseSubString.replaceAll("きゃ", "キャ");
        JapaneseSubString =JapaneseSubString.replaceAll("きゅ", "キュ");
        JapaneseSubString =JapaneseSubString.replaceAll("きょ", "キョ");

        JapaneseSubString =JapaneseSubString.replaceAll("た", "タ");
        JapaneseSubString =JapaneseSubString.replaceAll("ち", "チ");
        JapaneseSubString =JapaneseSubString.replaceAll("つ", "ツ");
        JapaneseSubString =JapaneseSubString.replaceAll("て", "テ");
        JapaneseSubString =JapaneseSubString.replaceAll("と", "ト");
        JapaneseSubString =JapaneseSubString.replaceAll("ちゃ", "チャ");
        JapaneseSubString =JapaneseSubString.replaceAll("ちゅ", "チュ");
        JapaneseSubString =JapaneseSubString.replaceAll("ちょ", "チョ");

        JapaneseSubString =JapaneseSubString.replaceAll("さ", "サ");
        JapaneseSubString =JapaneseSubString.replaceAll("し", "シ");
        JapaneseSubString =JapaneseSubString.replaceAll("す", "ス");
        JapaneseSubString =JapaneseSubString.replaceAll("せ", "セ");
        JapaneseSubString =JapaneseSubString.replaceAll("そ", "ソ");
        JapaneseSubString =JapaneseSubString.replaceAll("しゃ", "シャ");
        JapaneseSubString =JapaneseSubString.replaceAll("しゅ", "シュ");
        JapaneseSubString =JapaneseSubString.replaceAll("しょ", "ショ");

        JapaneseSubString =JapaneseSubString.replaceAll("な", "ナ");
        JapaneseSubString =JapaneseSubString.replaceAll("に", "二");
        JapaneseSubString =JapaneseSubString.replaceAll("ぬ", "ヌ");
        JapaneseSubString =JapaneseSubString.replaceAll("ね", "ネ");
        JapaneseSubString =JapaneseSubString.replaceAll("の", "ノ");
        JapaneseSubString =JapaneseSubString.replaceAll("にゃ", "二ャ");
        JapaneseSubString =JapaneseSubString.replaceAll("にゅ", "二ュ");
        JapaneseSubString =JapaneseSubString.replaceAll("にょ", "二ョ");

        JapaneseSubString =JapaneseSubString.replaceAll("ま", "マ");
        JapaneseSubString =JapaneseSubString.replaceAll("み", "ミ");
        JapaneseSubString =JapaneseSubString.replaceAll("む", "ム");
        JapaneseSubString =JapaneseSubString.replaceAll("め", "メ");
        JapaneseSubString =JapaneseSubString.replaceAll("も", "モ");
        JapaneseSubString =JapaneseSubString.replaceAll("みゃ", "ミャ");
        JapaneseSubString =JapaneseSubString.replaceAll("みゅ", "ミュ");
        JapaneseSubString =JapaneseSubString.replaceAll("みょ", "ミョ");

        JapaneseSubString =JapaneseSubString.replaceAll("ら", "ラ");
        JapaneseSubString =JapaneseSubString.replaceAll("り", "リ");
        JapaneseSubString =JapaneseSubString.replaceAll("る", "ル");
        JapaneseSubString =JapaneseSubString.replaceAll("れ", "レ");
        JapaneseSubString =JapaneseSubString.replaceAll("ろ", "ロ");
        JapaneseSubString =JapaneseSubString.replaceAll("りゃ", "リャ");
        JapaneseSubString =JapaneseSubString.replaceAll("りゅ", "リュ");
        JapaneseSubString =JapaneseSubString.replaceAll("りょ", "リョ");

        JapaneseSubString =JapaneseSubString.replaceAll("わ", "ワ");
        JapaneseSubString =JapaneseSubString.replaceAll("ゐ", "ヰ");
        JapaneseSubString =JapaneseSubString.replaceAll("ゑ", "ヱ");
        JapaneseSubString =JapaneseSubString.replaceAll("を", "ヲ");

        JapaneseSubString =JapaneseSubString.replaceAll("が", "ガ");
        JapaneseSubString =JapaneseSubString.replaceAll("ぎ", "ギ");
        JapaneseSubString =JapaneseSubString.replaceAll("ぐ", "グ");
        JapaneseSubString =JapaneseSubString.replaceAll("げ", "ゲ");
        JapaneseSubString =JapaneseSubString.replaceAll("ご", "ゴ");
        JapaneseSubString =JapaneseSubString.replaceAll("ぎゃ", "ギャ");
        JapaneseSubString =JapaneseSubString.replaceAll("ぎゅ", "ギュ");
        JapaneseSubString =JapaneseSubString.replaceAll("ぎょ", "ギョ");

        JapaneseSubString =JapaneseSubString.replaceAll("ざ", "ザ");
        JapaneseSubString =JapaneseSubString.replaceAll("じ", "ジ");
        JapaneseSubString =JapaneseSubString.replaceAll("ず", "ズ");
        JapaneseSubString =JapaneseSubString.replaceAll("ぜ", "ゼ");
        JapaneseSubString =JapaneseSubString.replaceAll("ぞ", "ゾ");
        JapaneseSubString =JapaneseSubString.replaceAll("じゃ", "ジャ");
        JapaneseSubString =JapaneseSubString.replaceAll("じゅ", "ジュ");
        JapaneseSubString =JapaneseSubString.replaceAll("じょ", "ジョ");

        JapaneseSubString =JapaneseSubString.replaceAll("だ", "ダ");
        JapaneseSubString =JapaneseSubString.replaceAll("ぢ", "ヂ");
        JapaneseSubString =JapaneseSubString.replaceAll("づ", "ヅ");
        JapaneseSubString =JapaneseSubString.replaceAll("で", "デ");
        JapaneseSubString =JapaneseSubString.replaceAll("ど", "ド");
        JapaneseSubString =JapaneseSubString.replaceAll("ぢゃ", "ヂャ");
        JapaneseSubString =JapaneseSubString.replaceAll("ぢゅ", "ヂュ");
        JapaneseSubString =JapaneseSubString.replaceAll("ぢょ", "ヂョ");

        JapaneseSubString =JapaneseSubString.replaceAll("ば", "バ");
        JapaneseSubString =JapaneseSubString.replaceAll("び", "ビ");
        JapaneseSubString =JapaneseSubString.replaceAll("ぶ", "ブ");
        JapaneseSubString =JapaneseSubString.replaceAll("べ", "ベ");
        JapaneseSubString =JapaneseSubString.replaceAll("ぼ", "ボ");
        JapaneseSubString =JapaneseSubString.replaceAll("びゃ", "ビャ");
        JapaneseSubString =JapaneseSubString.replaceAll("びゅ", "ビュ");
        JapaneseSubString =JapaneseSubString.replaceAll("びょ", "ビョ");

        JapaneseSubString =JapaneseSubString.replaceAll("ば", "パ");
        JapaneseSubString =JapaneseSubString.replaceAll("び", "ピ");
        JapaneseSubString =JapaneseSubString.replaceAll("ぶ", "プ");
        JapaneseSubString =JapaneseSubString.replaceAll("べ", "ペ");
        JapaneseSubString =JapaneseSubString.replaceAll("ぼ", "ポ");
        JapaneseSubString =JapaneseSubString.replaceAll("びゃ", "ピャ");
        JapaneseSubString =JapaneseSubString.replaceAll("びゅ", "ピュ");
        JapaneseSubString =JapaneseSubString.replaceAll("びょ", "ピョ");

        JapaneseSubString =JapaneseSubString.replaceAll("は", "ハ");
        JapaneseSubString =JapaneseSubString.replaceAll("ひ", "ヒ");
        JapaneseSubString =JapaneseSubString.replaceAll("ふ", "フ");
        JapaneseSubString =JapaneseSubString.replaceAll("へ", "ヘ");
        JapaneseSubString =JapaneseSubString.replaceAll("ほ", "ホ");
        JapaneseSubString =JapaneseSubString.replaceAll("ひゃ", "ヒャ");
        JapaneseSubString =JapaneseSubString.replaceAll("ひゅ", "ヒュ");
        JapaneseSubString =JapaneseSubString.replaceAll("ひょ", "ヒョ");

        JapaneseSubString =JapaneseSubString.replaceAll("や", "ヤ");
        JapaneseSubString =JapaneseSubString.replaceAll("ゆ", "ユ");
        JapaneseSubString =JapaneseSubString.replaceAll("よ", "ヨ");

        JapaneseSubString =JapaneseSubString.replaceAll("あ", "ア");
        JapaneseSubString =JapaneseSubString.replaceAll("い", "イ");
        JapaneseSubString =JapaneseSubString.replaceAll("う", "ウ");
        JapaneseSubString =JapaneseSubString.replaceAll("え", "エ");
        JapaneseSubString = JapaneseSubString.replaceAll("お", "オ");

        JapaneseSubString = JapaneseSubString.replaceAll("ん", "ン");


        return JapaneseSubString;
    }

    @NotNull
    @Override
    public KeyboardString change(@NotNull KeyboardString string, @NotNull KeyboardType requireType) {
        String inputString = string.getValue();
        KeyboardString resultString;
        if(requireType == KeyboardType.JAPANESE && string.getType() == KeyboardType.ENGLISH){
            inputString = changeEnlish2Japanese(inputString);
            inputString = changeGatakana(inputString);
        }
        resultString = new KeyboardString(inputString, KeyboardType.JAPANESE);
        return resultString;
    }
}
