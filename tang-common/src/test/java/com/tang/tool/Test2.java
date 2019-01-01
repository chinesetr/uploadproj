package com.tang.tool;

import java.time.LocalDateTime;

import com.tang.common.utils.DateTimeUtils;

public class Test2 {

    public static void main(String[] args) {
	/*
        int num = 1000100001;
        char un[] = { '零', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖' };// 一级单位
        char us[] = { '拾', '佰', '仟' };// 二级单位
        char uu[] = { '万', '亿' }; // 三级单位
        int t, i = 0; // t余数,i循环下标
        int u = 0, f = 1; // u三级单位下标,f标志位控制零不能重复
        boolean bool = false; // 是否加三级单位
        String str = "";
        do {
            String s1 = "";
            t = num % 10;
            if (t > 0) {
                // 一级单位大于0
		s1 = un[t] + "";
                if (i % 4 != 0) { // 取二级单位的条件,不是0 4 8
                    // 取二级单位 1 2 3 ,5 6 7
                    s1 += us[i % 4 - 1];
                } else if (i % 4 == 0 && i >= 4) {
                    // 是否加三级单位
                    u++;
                    bool = true;
                }
                if (u > 0 && bool) {
                    s1 += uu[u - 1];
                    bool = false;
                }
                f = 0;
            } else if (t == 0) {
                if (f == 0) {
                    if (i % 4 != 0) {
                        s1 = un[0] + "";
                        f = 1;
                    }
                }
                if (i % 4 == 0 && i >= 4) {
                    // 是否加三级单位
                    u++;
                    bool = true;
                }
            }
            i++;
            str = s1 + str;
        } while (0 < (num /= 10));

        System.out.println(str);
    */
	String timestr = "2018 九月 09 09:15";
	LocalDateTime ldt = DateTimeUtils.parseTime(timestr);
	LocalDateTime myt = LocalDateTime.now();
	String dtstring = DateTimeUtils.toString(myt);
	System.out.println(ldt);
	System.out.println(dtstring+"解决冲突");
    }
}
