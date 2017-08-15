package io.zipIOStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by Ежище on 19.02.2017.
 */
public class ZipOut {
    public static void main(String[] args) {

        String filename = "src\\main\\java\\io\\zipIOStream\\1.txt",
                filename2 = "src\\main\\java\\io\\zipIOStream\\2.txt";
        try(ZipOutputStream zout = new ZipOutputStream(new FileOutputStream("src\\main\\java\\io\\" +
                "zipIOStream\\output.zip"));
            FileInputStream fis= new FileInputStream(filename); FileInputStream fis2 = new FileInputStream(filename2))
        {
            // создаем запись и добавляем запись (файл) в архив:
            ZipEntry entry1=new ZipEntry(filename);
            zout.putNextEntry(entry1);
            // Теперь нужно записать в архивную запись содежимое файла, иначе он будет пустой.
            // Считываем содержимое файла в массив byte
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer); // читаем байты в buffer
            // добавляем содержимое к архиву
            zout.write(buffer);
            // закрываем текущую запись для новой записи
            zout.closeEntry();

            // еще раз (для каждой новой записи заново):
            ZipEntry entry2 = new ZipEntry(filename2);
            zout.putNextEntry(entry2);
//            fis = new FileInputStream(filename2); // так нельзя, поскольку поток - это финальная переменная
            byte[] buffer2 = new byte[fis2.available()];
            fis2.read(buffer2);
            zout.write(buffer2);
            zout.closeEntry();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
