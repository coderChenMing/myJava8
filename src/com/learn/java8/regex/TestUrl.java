package com.learn.java8.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Project: myJava8
 * File Created at 2022-07-27 14:44:14:44
 * {@link}
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type TestUrl.java
 * @Description
 * @date 2022/7/27 14:44
 */
public class TestUrl {
    // 子域名
    static final String SUB_DOMAIN = "(?i:[a-z0-9\\u4e00-\\u9fa5]|[a-z0-9\\u4e00-\\u9fa5][-a-z0-9\\u4e00-\\u9fa5]*[a-z0-9\\u4e00-\\u9fa5])";

    // 顶级域名
    static final String TOP_DOMAINS =
        "(?x-i:com\\b" +
            "|edu\\b" +
            "|biz\\b" +
            "|in(?:t|fo)\\b" +
            "|mil\\b" +
            "|net\\b" +
            "|org\\b" +
            "|[a-z][a-z]\\b)" ;// 国家代码
    // 主机名
    static final String HOSTNAME = "(?:" + SUB_DOMAIN + "\\.)+" + TOP_DOMAINS;

    // URL 地址中不允许包括的字符，以及其他的条件
    static final String NOT_IN = ";:\"'<>\\[\\]{}\\s\\x7F-\\xFF";
    // static final String NOT_IN = ";:\"'<>()\\[\\]{}\\s\\x7F-\\xFF";
    static final String NOT_END = "!.,?";
    static final String ANYWHERE = "[^" + NOT_IN + NOT_END + "]";
    static final String EMBEDDED = "[" + NOT_END + "]";
    static final String URL_PATH = "/" + ANYWHERE + "*(" + EMBEDDED + "+" + ANYWHERE + "+)*";

    // 端口号 0～65535
    /*static final String PORT =
        "(?:[0-5]?[0-9]{1,4}|6(?:[0-4][0-9]{3}|5(?:[0-4][0-9]{2}|5(?:[0-2][0-9]|3[0-5]))))";*/
    static final String PORT =
        "(?:" +
            "[0-5]?[0-9]{1,4}" +
            "|" +
            "6(?:" +
            "[0-4][0-9]{3}" +
            "|" +
            "5(?:" +
            "[0-4][0-9]{2}" +
            "|" +
            "5(?:" +
            "[0-2][0-9]" +
            "|" +
            "3[0-5]" +
            ")" +
            ")" +
            ")" +
            ")";


    // URL 表达式
    static final String URL =
        "(?x:" +
            "\\b" +
            "(?:" +
            "(?:ftp|https?)://[-\\w\\u4e00-\\u9fa5]+(\\.[-\\w\\u4e00-\\u9fa5]*)+" +
           // "(?:ftp|https?)://[-\\w\\u4e00-\\u9fa5]+(\\.\\w[-\\w\\u4e00-\\u9fa5]*)+" +
            "|" + HOSTNAME + ")" +
            "(?::" + PORT + ")?" +
            "(?:" + URL_PATH + ")?" +
            ")";
    static final String URL1 ="^\\s*((http(s)?://)|(ftp://)|())\\w+(\\.\\w+)+((:\\d{1,5})|)(/\\w*)*(/\\w+\\.(\\w+|))?([\\w- ./?％&=]*)?";

    static final String URL2 = "\\b(?:(?:ftp|https?)://[-\\w]+(\\.\\w[-\\w]*)+|(?:(?i:[a-z0-9]|[a-z0-9][-a-z0-9]*[a-z0-9])\\.)(?x-i:com\\b|edu\\b|biz\\b|in(?:t|fo)\\b|mil\\b|net\\b|org\\b|[a-z][a-z]\\b))(?::(?:[0-5]?[0-9]{1,4}|6(?:[0-4][0-9]{3}|5(?:[0-4][0-9]{2}|5(?:[0-2][0-9]|3[0-5])))))?(?:/[^;:\"'<>()\\[\\]{}\\s\\x7F-\\xFF!.,?]*([!.,?]+[^;:\"'<>()\\[\\]{}\\s\\x7F-\\xFF!.,?]+)*)?";

    static final String URL3 = "((http|https)://)(www.)?[a-zA-Z0-9@:%._\\\\+~#?&//=]{2,256}\\\\.[a-z]{2,6}\\\\b([-a-zA-Z0-9@:%._\\\\+~#?&//=]*)";
    public static void main(String[] args) {
        // 测试代码
        System.out.println(URL);
        String[] strs = {
            "http://www.13.com/",
            "https://www.asdf.com.cn/asdf",
            "www.23.com",
            "http://www.123.com/tsf",
            "http://www.abc.com/ab:2525/a.asp",
            "http://www.123.com:2563/tsf/a.html?a=2&&b=abc",
            "http://www.aa.com/servlet",
            "http://ee.com/abcSerlvet?a=8&&b=asdf",
            "ftp://192.168.0.2:8080",
            "http://difdcabcg.ipmrdf.xyz/#/no_password",
            "http://ww.ss.com/////",
            "http://dian_md_f.lx.tpxtyc.com",
            "https://银监会在线服务中心.com/",
            "https://www.银监会在线服务中心.com/",
            "https://ww.银监会在线服务中心.com/?abc",
            "https://qianhu.wejianzhan.com/site/wjzst8qm/610643aa-0189-45b3-93b1-aac4aa86a085?source=bdpc&plan=MTCJ_%5Bpinpai%5D(jituan)%7Bchun%7DWAP&unit=daili&keyword=maotaidaili&e_creative=59525187014&e_keywordid=413262002128&e_keywordid2=393006621901&fid=nHcsnj6knH04rHbkPHfsP161rjFxnWcdg1n&ch=4&bd_vid=nHcsnj6knH04rHbkPHfsP161rjFxnWcdg1PxnH0sg1wxPHbdnWRkrjTsnHf&bd_bxst=EiaKoWc207N9GpU900nD0a6Ay0Fa8WR000000Ka4tqUIslMnJQzE1TyYS_jV000000000000cjc1nWTYrj0LPYFAwbPAwDDsfH63fbR4wjf1njmsfHmvAOA0aSJFOGbK0000kbglvsY000jfVdR3m00000C0x60cslMnJQHlsrYJ8x5yLTrG_lXtotL7VtMjJUHlsrYVz284SVgfEJL5S_MnQiYsV5o0eUxw00jfzWL2",
            "https://group.wejianzhan.com/site/wjz03ljz/93f58d2c-d8dc-4e4c-8ed4-e721ae1425d0?dynType=1&source=baidu&DY=%E6%9D%A5%E8%AE%BF%E8%BD%AC%E5%8C%96%E8%AF%8D&GJC=%E8%B4%B5%E5%B7%9E%E8%8C%85%E5%8F%B0%E8%82%A1%E4%BB%BD%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8&JH=%E6%9D%A5%E8%AE%BF%E8%BD%AC%E5%8C%96%E8%AE%A1%E5%88%92%E8%AF%8D&e_keywordid=439973922855&e_keywordid2=439973922855&flowType=1&dynId=108762480&fid=rHR4n104njTvP16kPWTzPWDkrNtznWFxnf&ch=4&bd_vid=rHR4n104njTvP16kPWTzPWDkrNtznWFxnNtknjKxP7tvnHfYnWTvnjnLn6&bd_bxst=EiaKu4UQAHJKcmgX00DD0K0ui6c-AgDA000000z4tqUIslMnJQzE1TR0000000000a9KPRRYnjcYPj01n1ParRc4PYczn1IaPjNan1wjnH9Kn1DYnbn4nYuKcDnkwjK7fHc3njIafbwAnbD3PHnznHfvP101fYmdfH04PnBda3mK443K0000VK4AH630000MiZdsu60000C0x60R8x5yLTrG12B4zUxIYqj5Lohoze3s8x5yLTrG_lXtotL7dIaYS_jV1pWyJWoy_IgfkOWHtoU0EP2YS_jVQn5BEP5jzexw00jDD48a",
            "https://qianhu.wejianzhan.com/site/wjzt17jm/683e2836-5e89-4ff2-b5ff-d44cda199e56?fid=nHmYn1TzrjmvrjR3rHRsnWc4PWwxnHfvnNtk&ch=4&bd_vid=nHmYn1TzrjmvrjR3rHRsnWc4PWwxnHfvnNtkg1Dsn7tYg1mkP1T3njfvnWm1&bd_bxst=EiaKIPbZ0ax4ZridKfDD0ampu0Q2I0s000000KA4tqUIslMnJQeAcQAkV5XlYs00000000000a03PjmYfYu7n1-7njuawbRkP16Yf1fdfW6zwWDYwHnYfdI276k0oG2C0f000jTVfhcr0000-w8KSh6000020Z30aQM1dVLjJTzCQeM1dVLjJUrME2OPkIgfV5o0eUHlsrYV8x5yLTrG_lXtotL7z284So55dIaYS_jV00KeC6EY",
            "https://qianhu.wejianzhan.com/site/wjzst8qm/bb320fad-4e81-4be8-8366-6fb72c62c3fc?source=bdwap&plan=MTCJ_%5Bpinpai%5D(jituan)%7Bchun%7DWAP&unit=liuliang&keyword=maotaizenmeyang&e_creative=59474294225&e_keywordid=412538155762&e_keywordid2=394203513036&fid=rHc3rjR1n1cYnH0znWn1rHDkP-tznWPxnf&ch=4&bd_vid=rHc3rjR1n1cYnH0znWn1rHDkP-tznWPxnNtknjKxP7tdrHfLPjc4PjczPf&bd_bxst=EiaKQ7BQAtNO43jx00DD0a6Ay0FthM0900000KjjJTzCsOEjkUeAd5gjVPZ400000000000CfHN7Pj0zPjfsn1n1fW-arHIanWnLfWfdfWnYf1D3fHnkPjFjrHPAfiKjnRfswRDzrj0LfbFDwWFKrjR1nWDYPWTsnYPAPRDsrwEk60VPPeAu0f000PAdtI6P0000tocsjy0000020Z30a_rG12WRqTrYYxbJ8x5yLTrG_lXtotL7VtMjJUHlsrYVz284SVgfEJL5S_MnQiYsV5o0eUxw000lEnLl"
        };
        Pattern pattern = Pattern.compile(URL);
        Matcher matcher = pattern.matcher("");
        for (int i = 0; i < strs.length; i++) {
            System.out.printf("%s --> %s%n", strs[i], matcher.reset(strs[i]).matches());
        }


    }
}
