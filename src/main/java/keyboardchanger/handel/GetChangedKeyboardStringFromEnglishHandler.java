package keyboardchanger.handel;

import com.kdpark0723.keyboardchanger.handel.GetChangedKeyboardStringHandler;
import com.kdpark0723.keyboardchanger.model.KeyboardString;
import com.kdpark0723.keyboardchanger.model.KeyboardType;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;

public class GetChangedKeyboardStringFromEnglishHandler extends GetChangedKeyboardStringHandler {

    static private final ArrayList<Character> KoreanCharacters = new ArrayList<>(
        Arrays.asList('ㅂ', 'ㅈ', 'ㄷ', 'ㄱ', 'ㅅ', 'ㅛ', 'ㅕ', 'ㅑ', 'ㅐ', 'ㅔ', 'ㅁ', 'ㄴ', 'ㅇ', 'ㄹ', 'ㅎ', 'ㅗ', 'ㅓ', 'ㅏ', 'ㅣ', 'ㅋ', 'ㅌ', 'ㅊ', 'ㅍ', 'ㅠ', 'ㅜ', 'ㅡ', 'ㅃ', 'ㅉ', 'ㄸ', 'ㄲ',
            'ㅆ', 'ㅒ', 'ㅖ')
    );

    static private final ArrayList<Character> EnglishCharacters = new ArrayList<>(
        Arrays.asList('q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'z', 'x', 'c', 'v', 'b', 'n', 'm', 'Q', 'W', 'E', 'R',
            'T', 'O', 'P')
    );

    static private final ArrayList<Character> KoreanConsonants = new ArrayList<>(
        Arrays.asList('ㄱ', 'ㄲ', 'ㄴ', 'ㄷ', 'ㄸ', 'ㄹ', 'ㅁ', 'ㅂ', 'ㅃ', 'ㅅ', 'ㅆ', 'ㅇ', 'ㅈ', 'ㅉ', 'ㅊ', 'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ')
    );

    static private final ArrayList<Character> DoubleKoreanConsonants = new ArrayList<>(
        Arrays.asList('ㄲ', 'ㄸ', 'ㅃ', 'ㅆ', 'ㅉ')
    );

    static private final ArrayList<Character> KoreanVowels = new ArrayList<>(
        Arrays.asList('ㅏ', 'ㅑ', 'ㅓ', 'ㅕ', 'ㅗ', 'ㅛ', 'ㅜ', 'ㅠ', 'ㅡ', 'ㅣ', 'ㅐ', 'ㅖ')
    );

    private static int chosungCodePoint(Character chosung) {
        final ArrayList<Character> chosungArray = new ArrayList<>(
            Arrays.asList('ㄱ', 'ㄲ', 'ㄴ', 'ㄷ', 'ㄸ', 'ㄹ', 'ㅁ', 'ㅂ', 'ㅃ', 'ㅅ', 'ㅆ', 'ㅇ', 'ㅈ', 'ㅉ', 'ㅊ', 'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ')
        );

        return chosungArray.indexOf(chosung);
    }

    private static int jungsungCodePoint(Character jungsung) {
        final ArrayList<Character> jungsungArray = new ArrayList<>(
            Arrays.asList('ㅏ', 'ㅐ', 'ㅑ', 'ㅒ', 'ㅓ', 'ㅔ', 'ㅕ', 'ㅖ', 'ㅗ', 'ㅠ', 'ㅘ', 'ㅛ', 'ㅙ', 'ㅚ', 'ㅜ', 'ㅝ', 'ㅞ', 'ㅟ', 'ㅡ', 'ㅢ', 'ㅣ')
        );

        return jungsungArray.indexOf(jungsung);
    }

    private static int jongsungCodePoint(Character jongsung) {
        final ArrayList<Character> jongsungArray = new ArrayList<>(
            Arrays.asList(' ', 'ㄱ', 'ㄲ', 'ㄳ', 'ㄴ', 'ㄵ', 'ㄶ', 'ㄷ', 'ㄹ', 'ㄺ', 'ㄻ', 'ㄼ', 'ㄽ', 'ㄾ', 'ㄿ', 'ㅀ', 'ㅁ', 'ㅂ', 'ㅄ', 'ㅅ', 'ㅆ', 'ㅇ', 'ㅈ',
                'ㅊ', 'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ')
        );

        return jongsungArray.indexOf(jongsung);
    }

    private static String decode(String uni) {
        StringBuilder str = new StringBuilder();
        for (int i = uni.indexOf("\\u"); i > -1; i = uni.indexOf("\\u")) {
            str.append(uni, 0, i);
            str.append((char) Integer.parseInt(uni.substring(i + 2, i + 6), 16));
            uni = uni.substring(i + 6);
        }
        str.append(uni);
        return str.toString();
    }

    @NotNull
    @Override
    public KeyboardString change(@NotNull KeyboardString string, @NotNull KeyboardType requireType) {
        ArrayList<Character> spitedStringArray = new ArrayList<>();
        ArrayList<Character> spitedKoreanArray = new ArrayList<>();
        ArrayList<Character> resultKoreanArray = new ArrayList<>();
        String inputString = string.getValue();
        StringBuilder tempString = new StringBuilder();

        splitInputString(inputString, spitedStringArray);

        if (requireType == string.getType()) {
            changeEnglish2Korean(spitedStringArray, spitedKoreanArray);
            assembleSplitedKorean(spitedKoreanArray, resultKoreanArray);
            for (Character character : resultKoreanArray) {
                tempString.append(character.toString());
            }
        }
        return string;
    }

    private void splitInputString(@NotNull String inputString, @NotNull ArrayList<Character> splitedStringArray) {
        String[] spitedString = inputString.split("");

        for (String s : spitedString) {
            splitedStringArray.add(s.charAt(0));
        }
    }

    private void changeEnglish2Korean(@NotNull ArrayList<Character> splitedStringArray, @NotNull ArrayList<Character> splitedKoreanArray) {
        for (Character character : splitedStringArray) {
            if (EnglishCharacters.contains(character)) {
                splitedKoreanArray.add(KoreanCharacters.get(EnglishCharacters.indexOf(character)));
            } else {
                splitedKoreanArray.add(character);
            }
        } //특수문자의 상황 추가할 것
    }

    private void assembleSplitedKorean(@NotNull ArrayList<Character> splitedKoreanArray, @NotNull ArrayList<Character> resultKoreanArray) {
        String tempString = null;
        Character A = '\uAC00';
        ArrayList<Character> tempArray = new ArrayList<>();  //중간 저장 문자열
        int resultKoreanArrayIndex = -1;
        int i;
        int tempDoubleConsonantCodePoint;
        Character previousLetter;

        for (i = 0; i <= splitedKoreanArray.size() - 1; i++) {
            tempArray.clear();
            if (KoreanCharacters.contains(splitedKoreanArray.get(i))) {
                if (KoreanConsonants.contains(splitedKoreanArray.get(i))) {
                    for (int j = i; j < i + 5 && j < splitedKoreanArray.size(); j++) {
                        tempArray.add(splitedKoreanArray.get(j));
                    }

                    if (KoreanVowels.contains(tempArray.get(1))) {
                        //단어 조합
                        if (tempArray.size() >= 5 && KoreanConsonants.contains(tempArray.get(2)) && KoreanVowels.contains(tempArray.get(4))) {
                            //tempDoubleConsonant = convertDoubleConsonant(tempArray.get(2), tempArray.get(3));
                            resultKoreanArray.add((char) assembleSyllable(tempArray.get(0), tempArray.get(1), tempArray.get(2)));
                            resultKoreanArrayIndex++;
                            i = i + 2;
                        } else if (tempArray.size() >= 5 && isDoubleConsonant(tempArray.get(2), tempArray.get(3)) && !KoreanVowels.contains(tempArray.get(4))) {
                            tempDoubleConsonantCodePoint = convertDoubleConsonant(tempArray.get(2), tempArray.get(3));
                            resultKoreanArray.add((char) assembleSyllable(tempArray.get(0), tempArray.get(1), tempDoubleConsonantCodePoint));
                            resultKoreanArrayIndex++;
                            i = i + 3;
                        } else if (tempArray.size() >= 4 && KoreanConsonants.contains(tempArray.get(2)) && KoreanVowels.contains(tempArray.get(3))) {
                            resultKoreanArray.add((char) assembleSyllable(tempArray.get(0), tempArray.get(1)));
                            resultKoreanArrayIndex++;
                            i = i + 1;
                        } else if (tempArray.size() >= 3 && KoreanConsonants.contains(tempArray.get(2))) {
                            resultKoreanArray.add((char) assembleSyllable(tempArray.get(0), tempArray.get(1), tempArray.get(2)));
                            resultKoreanArrayIndex++;
                            i = i + 2;
                        } else if (tempArray.size() >= 3 && !KoreanConsonants.contains(tempArray.get(2))) {
                            resultKoreanArray.add((char) assembleSyllable(tempArray.get(0), tempArray.get(1)));
                            resultKoreanArrayIndex++;
                            i = i + 1;
                        } else if (tempArray.size() >= 2 && KoreanVowels.contains(tempArray.get(1))) {
                            resultKoreanArray.add((char) assembleSyllable(tempArray.get(0), tempArray.get(1)));
                            resultKoreanArrayIndex++;
                            i = i + 1;
                        } else {
                            resultKoreanArray.add(splitedKoreanArray.get(i));
                            resultKoreanArrayIndex++;
                        }
                    } else {
                        resultKoreanArray.add(splitedKoreanArray.get(i));
                        resultKoreanArrayIndex++;
                    } // 자음뒤에 자음인 경우
                } else {
                    resultKoreanArray.add(splitedKoreanArray.get(i));
                    resultKoreanArrayIndex++;
                }
            } else {
                resultKoreanArray.add(splitedKoreanArray.get(i));
                resultKoreanArrayIndex++;
            }//i번째 문자가 한글이 아닌 경우 그냥 출력
        }
    }

    private int assembleSyllable(Character chosung, Character jungsung, Character jongsung) {
        char A = '\uAC00';
        return A + ((chosungCodePoint(chosung) * 21) + jungsungCodePoint(jungsung)) * 28 + jongsungCodePoint(jongsung);
    }

    private int assembleSyllable(Character chosung, Character jungsung) {
        char A = '\uAC00';
        return A + ((chosungCodePoint(chosung) * 21) + jungsungCodePoint(jungsung)) * 28;
    }

    private int assembleSyllable(Character chosung, Character jungsung, int jongsungCodePoint) {
        char A = '\uAC00';
        return A + ((chosungCodePoint(chosung) * 21) + jungsungCodePoint(jungsung)) * 28 + jongsungCodePoint;
    }

    private boolean isDoubleConsonant(Character consonant1, Character consonant2) {
        if (consonant1.equals('ㄱ') && consonant2.equals('ㅅ'))
            return true;
        else if (consonant1.equals('ㄴ') && consonant2.equals('ㅈ'))
            return true;
        else if (consonant1.equals('ㄴ') && consonant2.equals('ㅎ'))
            return true;
        else if (consonant1.equals('ㄹ') && consonant2.equals('ㄱ'))
            return true;
        else if (consonant1.equals('ㄹ') && consonant2.equals('ㅁ'))
            return true;
        else if (consonant1.equals('ㄹ') && consonant2.equals('ㅂ'))
            return true;
        else if (consonant1.equals('ㄹ') && consonant2.equals('ㅅ'))
            return true;
        else if (consonant1.equals('ㄹ') && consonant2.equals('ㅌ'))
            return true;
        else if (consonant1.equals('ㄹ') && consonant2.equals('ㅍ'))
            return true;
        else if (consonant1.equals('ㄹ') && consonant2.equals('ㅎ'))
            return true;
        else return consonant1.equals('ㅂ') && consonant2.equals('ㅅ');
    }

    private int convertDoubleConsonant(Character consonant1, Character consonant2) {
        if (consonant1.equals('ㄱ') && consonant2.equals('ㅅ'))
            return 3;
        else if (consonant1.equals('ㄴ') && consonant2.equals('ㅈ'))
            return 5;
        else if (consonant1.equals('ㄴ') && consonant2.equals('ㅎ'))
            return 6;
        else if (consonant1.equals('ㄹ') && consonant2.equals('ㄱ'))
            return 9;
        else if (consonant1.equals('ㄹ') && consonant2.equals('ㅁ'))
            return 10;
        else if (consonant1.equals('ㄹ') && consonant2.equals('ㅂ'))
            return 11;
        else if (consonant1.equals('ㄹ') && consonant2.equals('ㅅ'))
            return 12;
        else if (consonant1.equals('ㄹ') && consonant2.equals('ㅌ'))
            return 13;
        else if (consonant1.equals('ㄹ') && consonant2.equals('ㅍ'))
            return 14;
        else if (consonant1.equals('ㄹ') && consonant2.equals('ㅎ'))
            return 15;
        else if (consonant1.equals('ㅂ') && consonant2.equals('ㅅ'))
            return 18;
        else
            return 0;
    }
}