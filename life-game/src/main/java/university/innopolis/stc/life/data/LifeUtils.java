package university.innopolis.stc.life.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class LifeUtils {

    public static LifeSnapshot readFromStream(InputStream inputStream) {
        int linesCount = 0;
        List<byte[]> buffer = new LinkedList<>();

        try (InputStreamReader isr = new InputStreamReader(inputStream)) {
            try (BufferedReader br = new BufferedReader(isr)) {
                String line = br.readLine();
                while (line != null) {
                    ++linesCount;
                    buffer.add(toByteArray(line));
                    line = br.readLine();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int lineLength = buffer.iterator().next().length;
        boolean allLinesSameSize = buffer.stream().allMatch(arr -> arr.length == lineLength);
        if (!allLinesSameSize) {
            throw new IllegalArgumentException("Invalid file format!!!");
        }

        LifeSnapshot result = new LifeSnapshot(lineLength, linesCount);
        int line = 0;
        for (byte[] bytes : buffer) {
            System.arraycopy(bytes, 0, result.getData(), line * lineLength, bytes.length);
            ++line;
        }

        return result;
    }

    private static byte[] toByteArray(String line) {
        int length = line.length();
        byte[] result = new byte[length];
        for (int i = 0; i < length; ++i) {
            char c = line.charAt(i);
            if (c == '0') {
                result[i] = 0;
            } else if (c == '1') {
                result[i] = 1;
            } else {
                throw new IllegalArgumentException("Invalid string!!!");
            }
        }
        return result;
    }
}
