package com.kdpark0723.keyboardchanger.handel;

import com.kdpark0723.keyboardchanger.handel.GetChangedKeyboardStringHandler;
import com.kdpark0723.keyboardchanger.model.KeyboardString;
import com.kdpark0723.keyboardchanger.model.KeyboardType;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;

public class GetChangedKeyboardStringToKoreanHandler extends GetChangedKeyboardStringHandler {

    public GetChangedKeyboardStringToKoreanHandler() {
        super(KeyboardType.KOREAN);
    }

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
    static private final ArrayList<Character> KoreanVowels = new ArrayList<>(
            Arrays.asList('ㅏ', 'ㅑ', 'ㅓ', 'ㅕ', 'ㅗ', 'ㅛ', 'ㅜ', 'ㅠ', 'ㅡ', 'ㅣ', 'ㅔ' , 'ㅐ', 'ㅒ', 'ㅖ')
    );

    @NotNull
    @Override
    public KeyboardString change(@NotNull KeyboardString string, @NotNull KeyboardType requireType) {
        ArrayList<Character> splitedStringArray = new ArrayList<>();
        ArrayList<Character> splitedKoreanArray = new ArrayList<>();
        ArrayList<Character> resultKoreanArray = new ArrayList<>();
        String inputString = string.getValue();
        String resultString = "";
        KeyboardString resultKeyboardString;
        splitedStringArray = splitInputString(inputString, splitedStringArray);

        if (requireType == KeyboardType.KOREAN && string.getType() == KeyboardType.ENGLISH) {
            splitedKoreanArray = changeEnglish2Korean(splitedStringArray, splitedKoreanArray);
            resultKoreanArray = assembleSplitedKorean(splitedKoreanArray, resultKoreanArray);

            for (int i = 0; i < resultKoreanArray.size(); i++) {
                resultString = resultString.concat(resultKoreanArray.get(i).toString());
            }
        }
        resultKeyboardString = new KeyboardString(resultString, KeyboardType.KOREAN);

        return resultKeyboardString;
    }

    private ArrayList<Character> assembleSplitedKorean(@NotNull ArrayList<Character> splitedKoreanArray, @NotNull ArrayList<Character> resultKoreanArray) {
        ArrayList<Character> tempArray = new ArrayList<>();  //중간 저장 문자열
        int i;
        int tempDoubleConsonantCodePoint;
        int tempDoubleVowelCodePoint;

        for (i = 0; i <= splitedKoreanArray.size() - 1; i++) {
            tempArray.clear();
            if (KoreanCharacters.contains(splitedKoreanArray.get(i))) {
                if (KoreanConsonants.contains(splitedKoreanArray.get(i))) {
                    for (int j = i; j < i + 6 && j < splitedKoreanArray.size(); j++) {
                        tempArray.add(splitedKoreanArray.get(j));
                    }

                    if (KoreanVowels.contains(tempArray.get(1))) {
                        //단어 조합

                        if (tempArray.size() >= 3 && KoreanVowels.contains(tempArray.get(2))) {   //이중모음
                            if (tempArray.size() >= 6 && isDoubleVowel(tempArray.get(1), tempArray.get(2)) && isDoubleConsonant(tempArray.get(3), tempArray.get(4)) && KoreanVowels.contains(tempArray.get(5))) {
                                tempDoubleVowelCodePoint = convertDoubleVowel(tempArray.get(1), tempArray.get(2));
                                resultKoreanArray.add((char) assembleSyllable(tempArray.get(0), tempDoubleVowelCodePoint, tempArray.get(3)));
                                i = i + 3;
                            } //자음 + 이중모음 + 겹받침이지만 그 다음에 모음이 오기 때문에 연음
                            else if (tempArray.size() >= 6 && isDoubleVowel(tempArray.get(1), tempArray.get(2)) && isDoubleConsonant(tempArray.get(3), tempArray.get(4)) && !KoreanVowels.contains(tempArray.get(5))) {
                                tempDoubleVowelCodePoint = convertDoubleVowel(tempArray.get(1), tempArray.get(2));
                                tempDoubleConsonantCodePoint = convertDoubleConsonant(tempArray.get(3), tempArray.get(4));
                                resultKoreanArray.add((char) assembleSyllable(tempArray.get(0), tempDoubleVowelCodePoint, tempDoubleConsonantCodePoint));
                                i = i + 4;
                            } //자음 + 이중모음 + 겹받침

                            else if (tempArray.size() >= 5 && isDoubleVowel(tempArray.get(1), tempArray.get(2)) && isDoubleConsonant(tempArray.get(3), tempArray.get(4))) {
                                tempDoubleVowelCodePoint = convertDoubleVowel(tempArray.get(1), tempArray.get(2));
                                tempDoubleConsonantCodePoint = convertDoubleConsonant(tempArray.get(3), tempArray.get(4));
                                resultKoreanArray.add((char) assembleSyllable(tempArray.get(0), tempDoubleVowelCodePoint, tempDoubleConsonantCodePoint));
                                i = i + 4;
                            } //자음 + 이중모음 + 겹받침 (로 끝날 때)

                            else if (tempArray.size() >= 5 && isDoubleVowel(tempArray.get(1), tempArray.get(2)) && KoreanConsonants.contains(tempArray.get(3)) && KoreanVowels.contains(tempArray.get(4))) {
                                tempDoubleVowelCodePoint = convertDoubleVowel(tempArray.get(1), tempArray.get(2));
                                resultKoreanArray.add((char) assembleSyllable(tempArray.get(0), tempDoubleVowelCodePoint));
                                i = i + 2;
                            }  //자음 + 이중모음 + 홑받침이지만 그다음에 모음이와서 연음

                            else if (tempArray.size() >= 4 && isDoubleVowel(tempArray.get(1), tempArray.get(2)) && KoreanConsonants.contains(tempArray.get(3))) {
                                tempDoubleVowelCodePoint = convertDoubleVowel(tempArray.get(1), tempArray.get(2));
                                resultKoreanArray.add((char) assembleSyllable(tempArray.get(0), tempDoubleVowelCodePoint, tempArray.get(3)));
                                i = i + 3;
                            } //자음 + 이중모음 + 홑받침

                            else if (tempArray.size() >= 4 && isDoubleVowel(tempArray.get(1), tempArray.get(2)) && !KoreanConsonants.contains(tempArray.get(3))) {
                                tempDoubleVowelCodePoint = convertDoubleVowel(tempArray.get(1), tempArray.get(2));
                                resultKoreanArray.add((char) assembleSyllable(tempArray.get(0), tempDoubleVowelCodePoint));
                                i = i + 2;
                            }

                            else if (tempArray.size() >= 3 && isDoubleVowel(tempArray.get(1), tempArray.get(2))) {
                                tempDoubleVowelCodePoint = convertDoubleVowel(tempArray.get(1), tempArray.get(2));
                                resultKoreanArray.add((char) assembleSyllable(tempArray.get(0), tempDoubleVowelCodePoint));
                                i = i + 2;
                            }
                        }

                        else if (tempArray.size() >= 5 && isDoubleConsonant(tempArray.get(2), tempArray.get(3)) && !KoreanVowels.contains(tempArray.get(4))) {
                            tempDoubleConsonantCodePoint = convertDoubleConsonant(tempArray.get(2), tempArray.get(3));
                            resultKoreanArray.add((char) assembleSyllable(tempArray.get(0), tempArray.get(1), tempDoubleConsonantCodePoint));
                            i = i + 3;
                        } //자음 + 이중모음 + 모음이 아닐 때

                        else if (tempArray.size() >= 5 && isDoubleConsonant(tempArray.get(2), tempArray.get(3)) && KoreanVowels.contains(tempArray.get(4))) {
                            resultKoreanArray.add((char) assembleSyllable(tempArray.get(0), tempArray.get(1), tempArray.get(2)));
                            i = i + 2;
                        } //자음 + 이중모음 + 모음 일 때

                        else if (tempArray.size() >= 4 && isDoubleConsonant(tempArray.get(2), tempArray.get(3))) {
                            tempDoubleConsonantCodePoint = convertDoubleConsonant(tempArray.get(2), tempArray.get(3));
                            resultKoreanArray.add((char) assembleSyllable(tempArray.get(0), tempArray.get(1), tempDoubleConsonantCodePoint));
                            i = i + 4;
                        }

                        else if (tempArray.size() >= 4 && KoreanConsonants.contains(tempArray.get(2)) && KoreanVowels.contains(tempArray.get(3))) {
                            resultKoreanArray.add((char) assembleSyllable(tempArray.get(0), tempArray.get(1)));
                            i = i + 1;
                        } //자음 + 모음 (+자음 + 모음)

                        else if (tempArray.size() >= 3 && KoreanConsonants.contains(tempArray.get(2))) {
                            resultKoreanArray.add((char) assembleSyllable(tempArray.get(0), tempArray.get(1), tempArray.get(2)));
                            i = i + 2;
                        } // 자음 + 모음 + 자음

                        else if (tempArray.size() >= 3 && !KoreanConsonants.contains(tempArray.get(2))) {
                            resultKoreanArray.add((char) assembleSyllable(tempArray.get(0), tempArray.get(1)));
                            i = i + 1;
                        }

                        else if (tempArray.size() >= 2 && KoreanVowels.contains(tempArray.get(1))) {
                            resultKoreanArray.add((char) assembleSyllable(tempArray.get(0), tempArray.get(1)));
                            i = i + 1;
                        }

                        else {
                            resultKoreanArray.add(splitedKoreanArray.get(i));
                        }
                    }

                    else {
                        resultKoreanArray.add(splitedKoreanArray.get(i));
                    } // 자음뒤에 자음인 경우
                }

                else {
                    resultKoreanArray.add(splitedKoreanArray.get(i));
                }
            }

            else {
                resultKoreanArray.add(splitedKoreanArray.get(i));
            }//i번째 문자가 한글이 아닌 경우 그냥 출력
        }

        return resultKoreanArray;
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

    private boolean isDoubleVowel(Character vowel1, Character vowel2) {
        if (vowel1.equals('ㅗ') && vowel2.equals('ㅏ'))
            return true;
        else if (vowel1.equals('ㅗ') && vowel2.equals('ㅐ'))
            return true;
        else if (vowel1.equals('ㅗ') && vowel2.equals('ㅣ'))
            return true;
        else if (vowel1.equals('ㅜ') && vowel2.equals('ㅓ'))
            return true;
        else if (vowel1.equals('ㅜ') && vowel2.equals('ㅔ'))
            return true;
        else if (vowel1.equals('ㅜ') && vowel2.equals('ㅣ'))
            return true;
        else
            return vowel1.equals('ㅡ') && vowel2.equals('ㅣ');
    }

    private int convertDoubleVowel(Character vowel1, Character vowel2) {
        if (vowel1.equals('ㅗ') && vowel2.equals('ㅏ'))
            return 9;
        else if (vowel1.equals('ㅗ') && vowel2.equals('ㅐ'))
            return 10;
        else if (vowel1.equals('ㅗ') && vowel2.equals('ㅣ'))
            return 11;
        else if (vowel1.equals('ㅜ') && vowel2.equals('ㅓ'))
            return 14;
        else if (vowel1.equals('ㅜ') && vowel2.equals('ㅔ'))
            return 15;
        else if (vowel1.equals('ㅜ') && vowel2.equals('ㅣ'))
            return 16;
        else if (vowel1.equals('ㅡ') && vowel2.equals('ㅣ'))
            return 19;
        else
            return 0;
    }

    private ArrayList<Character> splitInputString(@NotNull String inputString, @NotNull ArrayList<Character> splitedStringArray) {
        String[] splitedString = inputString.split("");

        for (int i = 0; i < splitedString.length; i++) {
            splitedStringArray.add(splitedString[i].charAt(0));
        }

        return splitedStringArray;
    }

    private ArrayList<Character> changeEnglish2Korean(@NotNull ArrayList<Character> splitedStringArray, @NotNull ArrayList<Character> splitedKoreanArray) {
        for (int i = 0; i < splitedStringArray.size(); i++) {
            if (EnglishCharacters.contains(splitedStringArray.get(i))) {
                splitedKoreanArray.add(KoreanCharacters.get(EnglishCharacters.indexOf(splitedStringArray.get(i))));
            }
            else {
                splitedKoreanArray.add(splitedStringArray.get(i));
            }
        }

        return splitedKoreanArray;
    }

    private static int chosungCodePoint(Character chosung) {
        final ArrayList<Character> chosungArray = new ArrayList<>(
                Arrays.asList('ㄱ', 'ㄲ', 'ㄴ', 'ㄷ', 'ㄸ', 'ㄹ', 'ㅁ', 'ㅂ', 'ㅃ', 'ㅅ', 'ㅆ', 'ㅇ', 'ㅈ', 'ㅉ', 'ㅊ', 'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ')
        );

        return chosungArray.indexOf(chosung);
    }

    private static int jungsungCodePoint(Character jungsung) {
        final ArrayList<Character> jungsungArray = new ArrayList<>(
                Arrays.asList('ㅏ', 'ㅐ', 'ㅑ', 'ㅒ', 'ㅓ', 'ㅔ', 'ㅕ', 'ㅖ', 'ㅗ', 'ㅘ', 'ㅙ', 'ㅚ', 'ㅛ', 'ㅜ', 'ㅝ', 'ㅞ', 'ㅟ', 'ㅠ', 'ㅡ', 'ㅢ', 'ㅣ')
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

    private int assembleSyllable(Character chosung, Character jungsung, Character jongsung) {
        Character A = '\uAC00';

        return A + ((chosungCodePoint(chosung) * 21) + jungsungCodePoint(jungsung)) * 28 + jongsungCodePoint(jongsung);
    }

    private int assembleSyllable(Character chosung, Character jungsung) {
        Character A = '\uAC00';

        return A + ((chosungCodePoint(chosung) * 21) + jungsungCodePoint(jungsung)) * 28;
    }

    private int assembleSyllable(Character chosung, int jungsungCodePoint) {
        Character A = '\uAC00';

        return A + ((chosungCodePoint(chosung) * 21) + jungsungCodePoint) * 28;
    }

    private int assembleSyllable(Character chosung, int jungsungCodePoint, Character jongsung) {
        Character A = '\uAC00';

        return A + ((chosungCodePoint(chosung) * 21) + jungsungCodePoint) * 28 + jongsungCodePoint(jongsung);
    }

    private int assembleSyllable(Character chosung, int jungsungCodePoint, int jongsungCodePoint) {
        Character A = '\uAC00';

        return A + ((chosungCodePoint(chosung) * 21) + jungsungCodePoint) * 28 + jongsungCodePoint;
    }

    private int assembleSyllable(Character chosung, Character jungsung, int jongsungCodePoint) {
        Character A = '\uAC00';

        return A + ((chosungCodePoint(chosung) * 21) + jungsungCodePoint(jungsung)) * 28 + jongsungCodePoint;
    }
}