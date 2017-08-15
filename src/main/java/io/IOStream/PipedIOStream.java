package io.IOStream;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * Created by Ежище on 05.02.2017.
 */
public class PipedIOStream {
    /* с помощью потока ввода в этот массив будут переписаны данные из потока вывода: **/
    public byte[] inData;
    /* счетчик заполненных ячеек в массиве-приемнике inData **/
    private int filledCount;

    public byte[] inOutStream(int inDataLength, char start) {
        inData = new byte[inDataLength];
        try (PipedInputStream pipeIn = new PipedInputStream(); PipedOutputStream pipeOut = new PipedOutputStream();) {
            /* установим связь между исходящим и входящим потоками **/
            pipeOut.connect(pipeIn);
              /* int для счетчика в цикле, которые заодно будут записываться в поток вывода pipeOut (они при этом
               * автоматически приведутся к byte). Получаем его из char, переданного в метод, а на печати
                * преобразуем записанные байты опять в char, так прикольно:**/
            int charCount = (int)start;
            /* цикл, в котором будет происходить чтение из потока вывода в массив inData **/
            while (inDataLength > filledCount) {
                /* вначале записываем несколько байт в поток вывода pipeOut: **/
                for (int i = charCount; i < charCount + 7; i++)
                    pipeOut.write(i);
                /* чтобы потом продолжить с того, на чем остановились; **/
                charCount += 7;
                /* опорожняем внутренний буфер потока вывода, чтобы убедиться, что все данные переданы в поток, а не
                 * хранятся в его внутреннем буфере: **/
                pipeOut.flush();
                /* Теперь считываем эти байты при помощи потока ввода pipeIn в массив inData. Количество байт,
                * которые будут прочитаны из потока pipeIn, равно количеству ДОСТУПНЫХ байт в потоке pipeIn:**/
                int willRead = pipeIn.available();
                /* нам нужно не записать в массив случайно больше байт, чем у него осталось свободных ячеек
                 * (+ 1 для того, чтобы потом я мог еще вставить дополнительный разграничитель): **/
                if (willRead + filledCount +1 > inDataLength)
                    willRead = inDataLength - filledCount - 1;
                /* Затем записываем байты из потока вывода в массив inData с помощью потока ввода pipeIn,
                 * воспользовавшись перегруженным методом read, который принимает массив, offset и количество байт.
                 * Поскольку этот метод возвращает также количество байт, которые были считаны из потока вывода и
                 * переписаны в массив inData, то сразу одним действием также увеличиваем счетчик свободных ячеек: **/
                filledCount += pipeIn.read(inData, filledCount, willRead);
                /* и вставляем в массив дополнительный разграничитель для красоты (47 - это (int)'/'): **/
                inData[filledCount] = 47;
                filledCount++;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return inData;
    }

    public static void main(String[] args) {
        PipedIOStream ps = new PipedIOStream();
        for (byte b : ps.inOutStream(180, '~'))
            System.out.print((char) (b * 1));
    }
}
