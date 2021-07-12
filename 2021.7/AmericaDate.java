package com.qiuwuyu.java;

import java.util.Calendar;

/**
 * @author paralog
 * @date 2021/7/12 13:59
 */
public class AmericaDate {

    public static void main(String[] args) {
        AmericaDate date = new AmericaDate();
//        System.out.println(date.calWeek(20, 14, 20));
        date.calDate("2016");
    }

    public void calDate(String year) {
        System.out.println(year + ".1.1" + "元旦");
        System.out.println(calDate(year, 1, 3, 1));
        System.out.println(calDate(year, 2, 3, 1));
        System.out.println(calMayDate(year));
        System.out.println(year + ".7.4" + "独立日");
        System.out.println(calDate(year, 9, 1, 1));
        System.out.println(calDate(year, 11, 4, 4));
        System.out.println(year + ".12.25" + "圣诞节");
    }

    //计算这个月第一天是星期几
    public String calDate(String year, int mouth, int week, int day) {
        int y = Integer.parseInt(year);
        int m = mouth;
        if (mouth == 1 || mouth == 2) {
            m = 12 + mouth;
            y--;
        }
        String newYear = String.valueOf(y);
        int length = newYear.length();
        y = Integer.parseInt(newYear.substring(newYear.length() - 2, newYear.length()));
        int c = Integer.parseInt(newYear) / 100;
        int weekDay = calWeek(y, m, c);
        int leaveWeek = week;
        if (weekDay == 0) {
            weekDay = 7;
        }
        int finalDay = 1;
        if (weekDay < day) {
            finalDay += (day - weekDay);
        } else if(weekDay > day) {
            finalDay += (day + 7 - weekDay);
        }
        finalDay = finalDay + (leaveWeek - 1) * 7;
        return year + "." + mouth + "." + finalDay + "一个节日";

    }

    public int calWeek(int y, int m, int c) {
        int weekDay = y + (y / 4) + (c / 4) - 2 * c + (26 * (m + 1) / 10);
        return (weekDay % 7);
    }

    public int calMayWeek(int y, int m, int c) {
        int weekDay = y + (y / 4) + (c / 4) - 2 * c + (26 * (m + 1) / 10) + 30;
        return (weekDay % 7);
    }

    public String calMayDate(String year) {
        int length = year.length();
        int y = Integer.parseInt(year.substring(year.length() - 2, year.length()));
        int c = Integer.parseInt(year) / 100;
        int m = 5;
        int i = calMayWeek(y, m, c);
        if (i == 0) {
            i = 7;
        }
        int finalDay = 31 - (i - 1);
        return year + "." + 5 + "." + finalDay + "一个节日";
    }

}
