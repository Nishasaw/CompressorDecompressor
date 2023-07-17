package com_decomp;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;


public class Compressor

{
public static void method(File file) throws IOException
{
    String fileDirectory=file.getParent();

    FileInputStream Fis=new FileInputStream(file);
    FileOutputStream Fos=new FileOutputStream(fileDirectory+"/CompressedFile.gz");
    GZIPOutputStream gzip=new GZIPOutputStream(Fos);
    byte[] buffer=new byte[1024];
    int len;

    while ((len=Fis.read(buffer))!=-1)
    {
        gzip.write(buffer,0,len);
    }
    gzip.close();
    Fis.close();
    Fos.close();
}
public static void main(String args[]) throws IOException
{
    File path=new File("/Users/NishaAc/Documents/Compressor/CompressorDecompressor/TestFile");
    method(path);
}

}
