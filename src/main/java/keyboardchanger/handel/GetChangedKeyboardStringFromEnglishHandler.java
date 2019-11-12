package keyboardchanger.handel;

import com.kdpark0723.keyboardchanger.handel.GetChangedKeyboardStringHandler;
import com.kdpark0723.keyboardchanger.model.KeyboardString;
import com.kdpark0723.keyboardchanger.model.KeyboardType;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;

public class GetChangedKeyboardStringFromEnglishHandler extends GetChangedKeyboardStringHandler {


    static final ArrayList<String> KoreanCharacters = new ArrayList<String>(
            Arrays.asList("ㅂ","ㅈ","ㄷ","ㄱ","ㅅ","ㅛ","ㅕ","ㅑ","ㅐ","ㅔ","ㅁ","ㄴ","ㅇ","ㄹ","ㅎ","ㅗ","ㅓ","ㅏ","ㅣ","ㅋ","ㅌ","ㅊ","ㅍ","ㅠ","ㅜ","ㅡ","ㅃ","ㅉ","ㄸ","ㄲ",
                    "ㅆ","ㅒ","ㅖ")
    );
    static final ArrayList<String> EnglishCharacters = new ArrayList<String>(
            Arrays.asList("q","w","e","r","t","y","u","i","o","p","a","s","d","f","g","h","j","k","l","z","x","c","v","b","n","m","Q","W","E","R",
                    "T","O","P")
    );
    static final ArrayList<String> KoreanConsonants = new ArrayList<String>(
            Arrays.asList("ㄱ","ㄲ","ㄴ","ㄷ","ㄸ","ㄹ","ㅁ","ㅂ","ㅃ","ㅅ","ㅆ","ㅇ","ㅈ","ㅉ","ㅊ","ㅋ","ㅌ","ㅍ","ㅎ")
    );

    static final ArrayList<String> DoubleKoreanConsonant = new ArrayList<String>(
            Arrays.asList("ㄲ","ㄸ","ㅃ","ㅆ","ㅉ")
    );
    static final ArrayList<String> KoreanVowels = new ArrayList<String>(
            Arrays.asList("ㅏ","ㅑ","ㅓ","ㅕ","ㅗ","ㅛ","ㅜ","ㅠ","ㅡ","ㅣ","ㅐ","ㅖ")
    );



    private void splitInputString(@NotNull String inputString, @NotNull ArrayList<String> splitedStringArray) {
        String[] splitedString = inputString.split("");

        for(int i = 0 ; i < splitedString.length ; i++){
            splitedStringArray.add(splitedString[i]);
        }
    }

    private void changeEnglish2Korean(@NotNull ArrayList<String> splitedStringArray, @NotNull ArrayList<String> splitedKoreanArray){
        for(int i = 0 ; i < splitedStringArray.size() ; i++){
            splitedKoreanArray.add(KoreanCharacters.get(EnglishCharacters.indexOf(splitedStringArray.get(i))));
        }
    }

    @NotNull
    @Override
    public KeyboardString change(@NotNull KeyboardString string, @NotNull KeyboardType requireType) {
        ArrayList<String> splitedStringArray = new ArrayList<String>();
        ArrayList<String> splitedKoreanArray = new ArrayList<String>();
        ArrayList<String> resultKoreanArray = new ArrayList<String>();
        String inputString = string.getValue();

        splitInputString(inputString, splitedStringArray);

        if(requireType == string.getType()){
            changeEnglish2Korean(splitedStringArray, splitedKoreanArray);
        }
        return string;
    }

    public static void main(String[] args){
        GetChangedKeyboardStringFromEnglishHandler changer = new GetChangedKeyboardStringFromEnglishHandler();

        String testString = new String("dkssud");
        ArrayList<String> testSplitedArray = new ArrayList<String>();
        ArrayList<String> splitedKoreanArray = new ArrayList<String>();

        changer.splitInputString(testString, testSplitedArray);
        changer.changeEnglish2Korean(testSplitedArray, splitedKoreanArray);
        System.out.print(splitedKoreanArray);
    }
}
