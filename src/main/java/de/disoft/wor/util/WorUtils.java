package de.disoft.wor.util;

import java.io.IOException;
import java.io.InputStream;

public final class WorUtils {

    private WorUtils() {

    }

    public static void closeInputStream(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException ioe) {
                // Do nothing.
            }
        }
    }
}
