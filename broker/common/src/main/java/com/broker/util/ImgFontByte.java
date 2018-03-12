package com.broker.util;

import java.awt.*;

/**
 * Created by Administrator on 2017/2/10.
 */
public class ImgFontByte {

    public Font getFont(int fontHeight) throws Exception{
//            Font baseFont = Font.createFont(Font.TRUETYPE_FONT, new ByteArrayInputStream(hex2byte(this.getFontByteStr())));
        return new Font("Arial",Font.PLAIN, fontHeight);
    }

    private  byte[] hex2byte(String str) {
        if (str == null)
            return null;
        str = str.trim();
        int len = str.length();
        if (len == 0 || len % 2 == 1)
            return null;

        byte[] b = new byte[len / 2];
        try {
            for (int i = 0; i < str.length(); i += 2) {
                b[i / 2] = (byte) Integer
                        .decode("0x" + str.substring(i, i + 2)).intValue();
            }
            return b;
        } catch (Exception e) {
            return null;
        }
    } /**
     * ttf字体文件的十六进制字符串
     * @return
     */
    private String getFontByteStr(){
        return null;
    }
}