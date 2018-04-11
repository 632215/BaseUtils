package weis.www.baseframe.timeutils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2018/2/5.
 */

public class TimeUtils {
    /**
     * 获取当前格式的时间戳
     *
     * @return
     */
    public static String getTimeCurrentDate() {
        Date date = new Date();
        return String.valueOf(date.getTime());
    }

    /**
     * 获取指定格式的当前时间数据
     *
     * @param format
     * @return
     */
    public static String getFormatCurrentDate(String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        Date date = new Date();
        return simpleDateFormat.format(date);
    }

    /**
     * 获取长整型数据的指定格式时间数据
     *
     * @param format
     * @param longTime
     * @return
     */
    public static String getFormatLongDate(String format, String longTime) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        Date date = new Date(Long.parseLong(longTime));
        return simpleDateFormat.format(date);
    }

    /**
     * 获取时间戳
     *
     * @return
     */
    public static String getTime(String formatTime) {
        Date date = new Date(formatTime);
        return String.valueOf(date.getTime());
    }
}
