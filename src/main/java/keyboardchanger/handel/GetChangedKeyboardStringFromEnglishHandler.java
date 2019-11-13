package keyboardchanger.handel;

import com.kdpark0723.keyboardchanger.handel.GetChangedKeyboardStringHandler;
import com.kdpark0723.keyboardchanger.model.KeyboardString;
import com.kdpark0723.keyboardchanger.model.KeyboardType;
import jdk.nashorn.internal.runtime.regexp.JoniRegExp;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;

public class GetChangedKeyboardStringFromEnglishHandler extends GetChangedKeyboardStringHandler {


    static private final ArrayList<String> KoreanCharacters = new ArrayList<>(
            Arrays.asList("ㅂ","ㅈ","ㄷ","ㄱ","ㅅ","ㅛ","ㅕ","ㅑ","ㅐ","ㅔ","ㅁ","ㄴ","ㅇ","ㄹ","ㅎ","ㅗ","ㅓ","ㅏ","ㅣ","ㅋ","ㅌ","ㅊ","ㅍ","ㅠ","ㅜ","ㅡ","ㅃ","ㅉ","ㄸ","ㄲ",
                    "ㅆ","ㅒ","ㅖ")
    );
    static private final ArrayList<String> EnglishCharacters = new ArrayList<>(
            Arrays.asList("q","w","e","r","t","y","u","i","o","p","a","s","d","f","g","h","j","k","l","z","x","c","v","b","n","m","Q","W","E","R",
                    "T","O","P")
    );
    static private final ArrayList<String> KoreanConsonants = new ArrayList<>(
            Arrays.asList("ㄱ","ㄲ","ㄴ","ㄷ","ㄸ","ㄹ","ㅁ","ㅂ","ㅃ","ㅅ","ㅆ","ㅇ","ㅈ","ㅉ","ㅊ","ㅋ","ㅌ","ㅍ","ㅎ")
    );

    static private final ArrayList<String> DoubleKoreanConsonants = new ArrayList<>(
            Arrays.asList("ㄲ","ㄸ","ㅃ","ㅆ","ㅉ")
    );
    static private final ArrayList<String> KoreanVowels = new ArrayList<>(
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

    private static String decode(String uni){
        StringBuffer str = new StringBuffer();
        for(int i= uni.indexOf("\\u") ; i > -1 ; i = uni.indexOf("\\u")){
            str.append(uni.substring(0, i));
            str.append(String.valueOf((char)Integer.parseInt(uni.substring(i + 2, i + 6),16)));
            uni = uni.substring(i + 6);
        }
        str.append(uni);
        return str.toString();
    }

    private static int chosungCodePoint(Character chosung){
        final ArrayList<Character> chosungArray = new ArrayList<>(
                Arrays.asList('ㄱ', 'ㄲ', 'ㄴ', 'ㄷ', 'ㄸ', 'ㄹ', 'ㅁ', 'ㅂ', 'ㅃ', 'ㅅ', 'ㅆ', 'ㅇ', 'ㅈ', 'ㅉ', 'ㅊ', 'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ')
        );

        return chosungArray.indexOf(chosung);
    }

    private static int jungsungCodePoint(Character jungsung){
        final ArrayList<Character> jungsungArray = new ArrayList<>(
                Arrays.asList('ㅏ', 'ㅐ', 'ㅑ', 'ㅒ', 'ㅓ', 'ㅔ', 'ㅕ', 'ㅖ', 'ㅗ', 'ㅠ', 'ㅘ', 'ㅛ', 'ㅙ', 'ㅚ', 'ㅜ', 'ㅝ', 'ㅞ', 'ㅟ', 'ㅡ', 'ㅢ', 'ㅑ')
        );

        return jungsungArray.indexOf(jungsung);
    }

    private static int jongsungCodePoint(Character jongsung){
        final ArrayList<Character> jongsungArray = new ArrayList<>(
                Arrays.asList(' ', 'ㄱ', 'ㄲ', 'ㄳ', 'ㄴ', 'ㄵ', 'ㄶ', 'ㄷ', 'ㄹ', 'ㄺ', 'ㄻ', 'ㄼ', 'ㄽ', 'ㄾ', 'ㄿ', 'ㅀ', 'ㅁ', 'ㅂ', 'ㅄ', 'ㅅ', 'ㅆ', 'ㅇ', 'ㅈ',
                        'ㅊ', 'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ')
        );

        return jongsungArray.indexOf(jongsung);
    }

    @NotNull
    private String assembleSyllable(Character chosung, Character jungsung, Character jongsung){
        int a = chosungCodePoint(chosung);
        int b = jungsungCodePoint(jungsung);
        int c = jongsungCodePoint(jongsung);
        Character A = '\uAC00';
        return "\\u"+Integer.toHexString(A + ((chosungCodePoint(chosung)*21) + jungsungCodePoint(jungsung))*28 + jongsungCodePoint(jongsung));
    }

    private void assembleSpilitedKorean(@NotNull ArrayList<String> splitedKoreanArray, @NotNull ArrayList<String> resultKoreanArray) {
        String tempString = null;
        Character a = '\uAC00';
        ArrayList<String> tempArray = new ArrayList<>();  //중간 저장 문자열
        int resultKoreanArrayIndex = -1;

        for (int i = 0; i < splitedKoreanArray.size() - 1; i++) {
            tempArray.clear();

            if (i > 0 && i < splitedKoreanArray.size() - 2) {
                if (KoreanVowels.contains(splitedKoreanArray.get(i))) {
                    for (int j = i - 1 ; j < i + 3 ; j++) {
                        tempArray.add(splitedKoreanArray.get(j));
                    }

                    if(KoreanConsonants.contains(tempArray.get(0))){
//                        if(KoreanConsonants.contains(tempArray.get(2)) && KoreanConsonants.contains(tempArray.get(3))){
//                            resultKoreanArray.add( decode("\\u" + Integer.toHexString(a + ((tempArray.get(0).charAt(0)*21)+tempArray.get(1).charAt(0)) + (tempArray.get(2).charAt(0) + tempArray.get(3).charAt(0)))));
//                            resultKoreanArrayIndex++;
//                        }
                        if(KoreanConsonants.contains(tempArray.get(2))){
                            resultKoreanArray.set(resultKoreanArrayIndex, decode(assembleSyllable(tempArray.get(0).charAt(0), tempArray.get(1).charAt(0), tempArray.get(2).charAt(0))));
                            resultKoreanArrayIndex++;
                            i++;
                        }
                    }
                    else{
                        resultKoreanArray.add(tempArray.get(1));
                        resultKoreanArrayIndex++;
                    }
                }

                else if(KoreanConsonants.contains(splitedKoreanArray.get(i))){
                    resultKoreanArray.add(splitedKoreanArray.get(i));

                    if(i == splitedKoreanArray.size() - 3){
                        for(int j = splitedKoreanArray.size() - 3 ; j < splitedKoreanArray.size()  ; j++){
                            tempArray.add(splitedKoreanArray.get(j));
                        }
                        if(KoreanVowels.contains(tempArray.get(1))){
                            if(KoreanConsonants.contains(tempArray.get(2))){
                                resultKoreanArray.set(resultKoreanArrayIndex, decode(assembleSyllable(tempArray.get(0).charAt(0), tempArray.get(1).charAt(0), tempArray.get(2).charAt(0))));
                            }
                        }
                        else{
                            resultKoreanArray.set(resultKoreanArrayIndex, assembleSyllable(tempArray.get(0).charAt(0), tempArray.get(1).charAt(0),' '));
                        }
                    }

                    if(!KoreanVowels.contains(splitedKoreanArray.get(i+1))) {
                        resultKoreanArrayIndex++;
                    }

                }
            }
            else{
                resultKoreanArray.add(splitedKoreanArray.get(i));
                resultKoreanArrayIndex++;
            }
        }



//        for(int i = 0 ; i < splitedKoreanArray.size() ; i++){
//            tempArray.clear();
//            tempArray.add(splitedKoreanArray.get(i));
//            if(KoreanVowels.contains(splitedKoreanArray.get(i))){ //모음을 발견한 경우
//                if(KoreanVowels.contains(tempArray.get(0))){
//                    resultKoreanArray.addAll(tempArray);
//                    resultKoreanArrayIndex++;
//                }
//                else{
//                    for(int j = i-1 ; j < i + 2 || i <= splitedKoreanArray.size()-3; j++){
//                        tempArray.add(splitedKoreanArray.get(j));
//                    }
//
//                    if(KoreanVowels.contains(tempArray.get(0))){
//                        resultKoreanArray.add(tempArray.get(1));
//                        resultKoreanArrayIndex++;
//                        continue;
//                    }
//                    else {
//                       // resultKoreanArray.
//                    }
//                }
//            }
//            else{
//                r
//            }
//
//        }
    }

    @NotNull
    @Override
    public KeyboardString change(@NotNull KeyboardString string, @NotNull KeyboardType requireType) {
        ArrayList<String> splitedStringArray = new ArrayList<>();
        ArrayList<String> splitedKoreanArray = new ArrayList<>();
        ArrayList<String> resultKoreanArray = new ArrayList<>();
        String inputString = string.getValue();

        splitInputString(inputString, splitedStringArray);

        if(requireType == string.getType()){
            changeEnglish2Korean(splitedStringArray, splitedKoreanArray);
            assembleSpilitedKorean(splitedKoreanArray, resultKoreanArray);
        }
        return string;
    }

    public static void main(String[] args){
        GetChangedKeyboardStringFromEnglishHandler changer = new GetChangedKeyboardStringFromEnglishHandler();

        String testString = new String("dkssud");
        ArrayList<String> testSplitedArray = new ArrayList<>();
        ArrayList<String> splitedKoreanArray = new ArrayList<>();
        ArrayList<String> resultKoreanArray = new ArrayList<>();

        changer.splitInputString(testString, testSplitedArray);
        changer.changeEnglish2Korean(testSplitedArray, splitedKoreanArray);
        System.out.print(splitedKoreanArray);
        changer.assembleSpilitedKorean(splitedKoreanArray, resultKoreanArray);
    }
}