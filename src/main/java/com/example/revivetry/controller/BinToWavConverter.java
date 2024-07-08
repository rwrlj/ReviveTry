package com.example.revivetry.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;


public class BinToWavConverter {
    public static void convertToWav(byte[] audioData, String outputPath) throws IOException {
        final int SAMPLE_RATE = 8000;
        final int CHANNELS = 1;
        final int BITS_PER_SAMPLE = 8;

        try (FileOutputStream fos = new FileOutputStream(outputPath)) {
            // WAV文件头格式 (参考 https://en.wikipedia.org/wiki/WAV)
            byte[] header = new byte[44];
            header[0] = 'R'; // 标记
            header[1] = 'I';
            header[2] = 'F';
            header[3] = 'F';
            int fileLength = 36 + audioData.length;
            writeInt(header, 4, fileLength); // 文件长度
            header[8] = 'W'; // 格式
            header[9] = 'A';
            header[10] = 'V';
            header[11] = 'E';
            header[12] = 'f'; // 'fmt ' 块标记
            header[13] = 'm';
            header[14] = 't';
            header[15] = 0x10; // 格式类型 (PCM)
            writeShort(header, 16, (short) 1); // 通道数
            writeShort(header, 18, (short) CHANNELS); // 采样率
            writeInt(header, 20, SAMPLE_RATE);
            writeInt(header, 24, SAMPLE_RATE * CHANNELS * BITS_PER_SAMPLE / 8); // 数据速率
            header[28] = (byte) (CHANNELS * BITS_PER_SAMPLE / 8); // 数据块对齐
            header[29] = 0;
            header[30] = (byte) BITS_PER_SAMPLE; // 样本分辨率
            header[31] = 0;
            writeInt(header, 32, audioData.length); // 数据大小
            header[36] = 'd'; // 'data' 块标记
            header[37] = 'a';
            header[38] = 't';
            header[39] = 'a';
            fos.write(header);
            fos.write(audioData);
        }
    }

    private static void writeInt(byte[] b, int off, int val) {
        b[off + 3] = (byte) (val & 0xFF);
        b[off + 2] = (byte) ((val >> 8) & 0xFF);
        b[off + 1] = (byte) ((val >> 16) & 0xFF);
        b[off] = (byte) ((val >> 24) & 0xFF);
    }

    private static void writeShort(byte[] b, int off, short val) {
        b[off + 1] = (byte) (val & 0xFF);
        b[off] = (byte) ((val >> 8) & 0xFF);
    }

    public static void main(String[] args) throws IOException {
        String filePath = "D:\\zh\\MEASUREMENT_DUT1_K.tdms..bin"; // 替换为你的.bin文件路径
        File file = new File(filePath);

        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] fileContent = new byte[(int) file.length()];
            fis.read(fileContent);

            // 处理字节数组
            byte[] audioData = fileContent;
            convertToWav(audioData, "output.wav");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

