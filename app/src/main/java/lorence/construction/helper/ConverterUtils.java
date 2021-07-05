package lorence.construction.helper;

import android.widget.EditText;

import javax.inject.Inject;

public class ConverterUtils {

    @Inject
    public ConverterUtils() {
    }

    public String getText(EditText editText) {
        return editText.getText().toString().trim();
    }

    public Double getDoubleValue(EditText editText) {
        return Double.parseDouble(editText.getText().toString().trim());
    }

}
