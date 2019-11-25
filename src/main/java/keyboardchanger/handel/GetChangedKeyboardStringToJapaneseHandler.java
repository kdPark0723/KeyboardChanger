package keyboardchanger.handel;

import com.kdpark0723.keyboardchanger.handel.GetChangedKeyboardStringHandler;
import com.kdpark0723.keyboardchanger.model.KeyboardString;
import com.kdpark0723.keyboardchanger.model.KeyboardType;
import org.jetbrains.annotations.NotNull;

public class GetChangedKeyboardStringToJapaneseHandler extends GetChangedKeyboardStringHandler {

    GetChangedKeyboardStringToJapaneseHandler() {
        super(KeyboardType.JAPANESE);
    }

    @NotNull
    @Override
    public KeyboardString change(@NotNull KeyboardString string, @NotNull KeyboardType requireType) {
        return string;
    }
}
