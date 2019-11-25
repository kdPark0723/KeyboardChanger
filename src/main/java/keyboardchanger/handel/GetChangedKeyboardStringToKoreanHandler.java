package keyboardchanger.handel;

import com.kdpark0723.keyboardchanger.handel.GetChangedKeyboardStringHandler;
import com.kdpark0723.keyboardchanger.model.KeyboardString;
import com.kdpark0723.keyboardchanger.model.KeyboardType;
import org.jetbrains.annotations.NotNull;

public class GetChangedKeyboardStringToKoreanHandler extends GetChangedKeyboardStringHandler {

    GetChangedKeyboardStringToKoreanHandler() {
        super(KeyboardType.KOREAN);
    }

    @NotNull
    @Override
    public KeyboardString change(@NotNull KeyboardString string, @NotNull KeyboardType requireType) {
        return string;
    }
}
