package com.learn.java8.common.beanutils.str;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public class StringUtilsTest {
    public static void main(String[] args) {
        // start
        // 1、判断字符串是否为空：null、""、" " 为 true ，其他为 false
        System.out.println(StringUtils.isBlank(null)); // true
        System.out.println(StringUtils.isBlank("")); // true
        System.out.println(StringUtils.isBlank(" ")); // true
        System.out.println(StringUtils.isBlank(" zibo ")); // false

        // 2、判断字符串是否非空（与 isBlank 相反）：null、""、" " 为 false ，其他为 true
        System.out.println(StringUtils.isNotBlank(null)); // false
        System.out.println(StringUtils.isNotBlank("")); // false
        System.out.println(StringUtils.isNotBlank(" ")); // false
        System.out.println(StringUtils.isNotBlank(" zibo ")); // true

        // 3、判断字符串是否为空：null、"" 为 true ，其他为 false
        System.out.println(StringUtils.isEmpty(null)); // true
        System.out.println(StringUtils.isEmpty("")); // true
        System.out.println(StringUtils.isEmpty(" ")); // false
        System.out.println(StringUtils.isEmpty(" zibo ")); // false

        // 4、判断字符串是否非空（与 isEmpty 相反）：null、"" 为 false ，其他为 true
        System.out.println(StringUtils.isNotEmpty(null)); // false
        System.out.println(StringUtils.isNotEmpty("")); // false
        System.out.println(StringUtils.isNotEmpty(" ")); // true
        System.out.println(StringUtils.isNotEmpty(" zibo ")); // true

        // 5、判断字符串是否是数字，不忽略空格
        System.out.println(StringUtils.isNumeric("")); // false
        System.out.println(StringUtils.isNumeric(" ")); // false
        System.out.println(StringUtils.isNumeric("100")); // true
        System.out.println(StringUtils.isNumeric(" 100 ")); // false
        // 注意下面连小数也是返回 `false` ，这是我没想到的！
        System.out.println(StringUtils.isNumeric("100.0")); // false

        // 6、判断字符串是否是数字，忽略空格
        // 空字符串返回 `true` ，我目瞪口呆！
        System.out.println(StringUtils.isNumericSpace("")); // true
        // 空格串返回 `true` ，我目瞪口呆！
        System.out.println(StringUtils.isNumericSpace(" ")); // true
        System.out.println(StringUtils.isNumericSpace("100")); // true
        System.out.println(StringUtils.isNumericSpace(" 100 ")); // true
        // 注意下面连小数也是返回 `false` ，这是我没想到的！
        System.out.println(StringUtils.isNumericSpace("100.0")); // false

        // 7、判断字符串是否是希腊字母，不忽略空格
        // 希腊字母？恐怕一万年之内我不会用到这个功能！
        System.out.println(StringUtils.isAlpha("")); // false
        System.out.println(StringUtils.isAlpha(" ")); // false
        System.out.println(StringUtils.isAlpha("zibo")); // true
        System.out.println(StringUtils.isAlpha(" zibo ")); // false
        System.out.println(StringUtils.isAlpha("zibo zibo")); // false
        System.out.println(StringUtils.isAlpha("zibo123")); // false

        // 8、判断字符串是否是希腊字母，忽略空格
        // 同样是空字符串，忽略空格就返回 `true` ，我目瞪口呆！有区别吗！
        System.out.println(StringUtils.isAlphaSpace("")); // true
        System.out.println(StringUtils.isAlphaSpace(" ")); // true
        System.out.println(StringUtils.isAlphaSpace("zibo")); // true
        System.out.println(StringUtils.isAlphaSpace(" zibo ")); // true
        System.out.println(StringUtils.isAlphaSpace("zibo zibo")); // true
        System.out.println(StringUtils.isAlphaSpace("zibo123")); // false

        // 9、判断字符串是否是希腊字母与数字组成，不忽略空格
        // 又是一个一万年之内不会用到的功能吧！
        System.out.println(StringUtils.isAlphanumeric("")); // false
        System.out.println(StringUtils.isAlphanumeric(" ")); // false
        // 由此可见，这是一种包含关系！不要求一定有字母和数字，有其一也返回 `true` ！
        System.out.println(StringUtils.isAlphanumeric("zibo")); // true
        System.out.println(StringUtils.isAlphanumeric("123")); // true
        System.out.println(StringUtils.isAlphanumeric("zibo123")); // true
        System.out.println(StringUtils.isAlphanumeric("zibo123 ")); // false

        // 10、判断字符串是否是希腊字母与数字组成，忽略空格
        // 同样是空字符串，忽略空格就返回 `true` ，我目瞪口呆！有区别吗！
        System.out.println(StringUtils.isAlphanumericSpace("")); // true
        System.out.println(StringUtils.isAlphanumericSpace(" ")); // true
        System.out.println(StringUtils.isAlphanumericSpace("zibo")); // true
        System.out.println(StringUtils.isAlphanumericSpace("123")); // true
        System.out.println(StringUtils.isAlphanumericSpace("zibo123")); // true
        System.out.println(StringUtils.isAlphanumericSpace("zibo123 ")); // true

        // 11、判断字符串是否全是小写字母
        System.out.println(StringUtils.isAllLowerCase("zibo")); // true
        System.out.println(StringUtils.isAllLowerCase("ZiBo")); // false
        System.out.println(StringUtils.isAllLowerCase("ZIBO")); // false

        // 12、判断字符串是否全是大写字母
        System.out.println(StringUtils.isAllUpperCase("ZIBO")); // true
        System.out.println(StringUtils.isAllUpperCase("ZiBo")); // false
        System.out.println(StringUtils.isAllUpperCase("zibo")); // false

        // 13、判断源字符串是否包含目标字符串
        System.out.println(StringUtils.contains("zibo", "zibo")); // true
        // 可见，区分大小写！
        System.out.println(StringUtils.contains("zibo", "ZIBO")); // false
        System.out.println(StringUtils.contains("zibo", "")); // true
        // 不忽略空格，返回 `false` ！
        System.out.println(StringUtils.contains("zibo", " ")); // false

        // 14、判断源字符串是否包含目标字节
        System.out.println(StringUtils.contains("zibo", 'z')); // true
        // 可见，区分大小写！
        System.out.println(StringUtils.contains("zibo", 'Z')); // false
        System.out.println(StringUtils.contains("zibo", 'a')); // false

        // 15、判断源字符串是否包含目标字符串（多目标）
        System.out.println(StringUtils.containsAny("zibo", "zibo")); // true
        // 多个目标字符串
        System.out.println(StringUtils.containsAny("zibo", "zi", "bo")); // true
        // 可见，区分大小写！
        System.out.println(StringUtils.containsAny("zibo", "ZIBO")); // false

        // 16、判断源字符串是否包含目标字节（多目标）
        // 多个目标字符串
        System.out.println(StringUtils.containsAny("zibo", 'z')); // true
        System.out.println(StringUtils.containsAny("zibo", 'z', 'b')); // true
        // 意料之外：有一个包含，也返回 `true` ！
        System.out.println(StringUtils.containsAny("zibo", 'z', 'a')); // true
        System.out.println(StringUtils.containsAny("zibo", 'a')); // false

        // 17、去掉字符串前后空格(""返回"")
        // 为空时返回空，为 null 时返回 null(不是字符串null，防止空指针异常)
        System.out.println(StringUtils.trim(null)); // null
        System.out.println(StringUtils.trim(" zibo ")); // zibo
        System.out.println(StringUtils.trim(" ")); // ""

        // 18、去掉字符串前后空格(""返回 `null` )
        // 当为空时，返回 null(不是字符串null，防止空指针异常)
        System.out.println(StringUtils.trimToNull(null)); // null
        System.out.println(StringUtils.trimToNull(" zibo ")); // zibo
        System.out.println(StringUtils.trimToNull(" ")); // null

        // 19、去掉字符串前后空格(null返回"" )
        System.out.println(StringUtils.trimToEmpty(null)); // ""
        System.out.println(StringUtils.trimToEmpty(" zibo ")); // zibo
        System.out.println(StringUtils.trimToEmpty(" ")); // ""

        // 20、比较两个字符串是否相等（区分大小写）
        System.out.println(StringUtils.equals("zibo", "zibo")); // true
        System.out.println(StringUtils.equals("zibo", "ZIBO")); // false

        // 21、比较两个字符串是否相等（忽略大小写）
        System.out.println(StringUtils.equalsIgnoreCase("zibo", "zibo")); // true
        System.out.println(StringUtils.equalsIgnoreCase("zibo", "ZIBO")); // true

        // 22、查找目标字符串在源字符串中第一次出现的位置，没有返回-1
        System.out.println(StringUtils.indexOf("zibo", "z")); // 0
        System.out.println(StringUtils.indexOf("zibo", "a")); // -1

        // 23、查找目标字符串在源字符串中第一次出现的位置，没有返回-1（从指定位置开始查找）
        System.out.println(StringUtils.indexOf("zibo", "i", 0)); // 1
        System.out.println(StringUtils.indexOf("zibo", "i", 1)); // 1
        System.out.println(StringUtils.indexOf("zibo", "i", 2)); // -1

        // 24、查找数组中任意元素在源字符串中出现的索引位置，满足多个时，取最小值，没有返回-1（多目标）
        System.out.println(StringUtils.indexOfAny("zibo", "z", "i")); // 0
        System.out.println(StringUtils.indexOfAny("zibo", "b", "o")); // 2
        System.out.println(StringUtils.indexOfAny("zibo", "b", "t")); // 2

        // 25、字符串字母转小写
        System.out.println(StringUtils.lowerCase("ZIBO")); // zibo

        // 26、字符串字母转大写
        System.out.println(StringUtils.upperCase("zibo")); // ZIBO

        // 27、对 str 字符串进行省略号缩写
        // maxWidth 表示长度，必须大于等于4（表示缩写后的长度）
        System.out.println(StringUtils.abbreviate("zibo zibo zibo", 4)); // z...

        // 28、首字母转大写
        System.out.println(StringUtils.capitalize("zibo")); // Zibo

        // 29、将 str 前后用空格填充，使总长度达到 size
        // size 本身小于 str 长度时，不做填充
        System.out.println(StringUtils.center("zibo", 6)); // " zibo "

        // 30、使用指定字符串进行填充
        System.out.println(StringUtils.center("zibo", 6, "*")); // "*zibo*"

        // 31、比较字符串 str1 与 str2 的大小（区分大小写）
        System.out.println(StringUtils.compare("a", "a")); // 0
        System.out.println(StringUtils.compare("a", "b")); // -1
        System.out.println(StringUtils.compare("b", "a")); // 1
        System.out.println(StringUtils.compare("a", "A")); // 32

        // 32、比较字符串 str1 与 str2 的大小（忽略大小写）
        System.out.println(StringUtils.compareIgnoreCase("a", "A")); // 0
        System.out.println(StringUtils.compareIgnoreCase("a", null, true)); // 1
        System.out.println(StringUtils.compareIgnoreCase(null, null, true)); // 0
        System.out.println(StringUtils.compareIgnoreCase("a", null, false)); // -1
        System.out.println(StringUtils.compareIgnoreCase(null, null, false)); // 0
        System.out.println(StringUtils.compareIgnoreCase("z", null, true)); // 1
        System.out.println(StringUtils.compareIgnoreCase("z", null, false)); // -1

        // 33、查找某个目标字符/字符串在源字符串中出现的次数
        System.out.println(StringUtils.countMatches("zibo zibo zibo", "z")); // 3

        // 34、将数组使用指定分隔符连接
        // liubei,guanyu,zhangfei
        System.out.println(StringUtils.join(new String[]{"liubei", "guanyu", "zhangfei"}, ","));
        System.out.println(StringUtils.join("a", "b", "c")); // abc
        System.out.println(StringUtils.join(Arrays.asList("a", "b", "c"), ",")); // a,b,c
        // [a, b, c],[d, e, f]
        System.out.println(StringUtils.joinWith(",", Arrays.asList("a", "b", "c"), Arrays.asList("d", "e", "f")));

        // 35、如果字符串为 null 、""、 " "，则返回默认字符串
        System.out.println(StringUtils.defaultIfBlank(null, "default")); // default
        System.out.println(StringUtils.defaultIfBlank("", "default")); // default
        System.out.println(StringUtils.defaultIfBlank(" ", "default")); // default

        // 36、如果字符串为 null 、"" ，则返回默认字符串
        System.out.println(StringUtils.defaultIfEmpty(null, "default")); // default
        System.out.println(StringUtils.defaultIfEmpty("", "default")); // default
        System.out.println(StringUtils.defaultIfEmpty(" ", "default")); // " "
        // end
    }
}
