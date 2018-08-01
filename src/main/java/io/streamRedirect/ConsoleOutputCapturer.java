package io.streamRedirect;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

//    https://stackoverflow.com/questions/8708342/redirect-console-output-to-string-in-java

//Here is a utility Class named ConsoleOutputInterceptor. It allows the output to go to the existing console however
// behind the scene keeps capturing the output text. You can control what to capture with the start/stop methods.
// In other words call start to start capturing the console output and once you are done capturing you can call the
// stop method which returns a String value holding the console output for the time window between start-stop calls.
// This class is not thread-safe though.

public class ConsoleOutputCapturer {

    private ByteArrayOutputStream baos;
    private PrintStream previous;
    private boolean capturing;

    public void start() {
        if (capturing) return;

        capturing = true;
        previous = System.out;
        baos = new ByteArrayOutputStream();

        OutputStream outputStreamCombiner =
                new OutputStreamCombiner(Arrays.asList(previous, baos));
        PrintStream custom = new PrintStream(outputStreamCombiner);

//        Схема такова: после установки System.setOut(custom), когда я (или логгер) говорю: System.out.println(...), то
// теперь, вместо вывода в консоль, поток out обратится к потоку custom типа PrintStream и скажет ему: custom.write(...).
// В свою очередь, custom обратится к outputStreamCombiner и скажет: outputStreamCombiner.write(...). По определению
// метода write() класса OutputStreamCombiner, он обратится к методам write() всех потоков у него в листе и скажет им:
// write(). Если у меня там в листе находятся 2 потока: "previous" стандартный PrintStream для вывода в консоль и
// baos типа ByteArrayOutputStream, то запись пойдет и консоль, и в baos, откуда ее потом можно извлечь.
        System.setOut(custom);
    }

    public String stop() {
        if (!capturing) {
            return "";
        }

        System.setOut(previous);

        String capturedValue = baos.toString();

        baos = null;
        previous = null;
        capturing = false;

        return capturedValue;
    }

    private static class OutputStreamCombiner extends OutputStream {
        private List<OutputStream> outputStreams;

        public OutputStreamCombiner(List<OutputStream> outputStreams) {
            this.outputStreams = outputStreams;
        }

        public void write(int b) throws IOException {
            for (OutputStream os : outputStreams) {
                os.write(b);
            }
        }

        public void flush() throws IOException {
            for (OutputStream os : outputStreams) {
                os.flush();
            }
        }

        public void close() throws IOException {
            for (OutputStream os : outputStreams) {
                os.close();
            }
        }
    }
}
