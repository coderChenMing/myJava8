package com.learn.java8.word2Pdf;

import cn.afterturn.easypoi.word.WordExportUtil;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Word2Pdf {
    private final static Logger LOGGER = LoggerFactory.getLogger(Word2Pdf.class);
    public static void main(String[] args) throws Exception {
        String templatePath = "D:\\test\\receipt_patch.docx";
        String temDir = "D:\\test";
        String fileNname = "回执单.docx";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("number", "123");
        params.put("userName", "peiguanghao");
        params.put("year", "2021");
        params.put("month", "08");
        params.put("day", "27");
        params.put("product", "测试产品");
        params.put("model", "测试型号");
        params.put("edition", "测试版本");
        params.put("type", "测试类型");
        params.put("level", "测试等级");
        Word2Pdf wordUtil = new Word2Pdf();
        wordUtil.exportWord(templatePath, temDir, fileNname, params);

        WordUtil.wordToPDF("D:\\test\\回执单.docx", "D:\\test\\回执单.pdf");
    }

    /**
     * 导出word
     * <p>第一步生成替换后的word文件，只支持docx</p>
     * <p>第二步下载生成的文件</p>
     * <p>第三步删除生成的临时文件</p>
     * 模版变量中变量格式：{{foo}}
     *
     * @param templatePath word模板地址
     * @param temDir       生成临时文件存放地址{最终输出路径+fileName}
     * @param fileName     文件名
     * @param params       替换的参数
     */
    public void exportWord(String templatePath, String temDir, String fileName, Map<String, Object> params) throws Exception {
        Assert.notNull(templatePath, "模板路径不能为空");
        Assert.notNull(temDir, "临时文件路径不能为空");
        Assert.notNull(fileName, "导出文件名不能为空");
        Assert.isTrue(fileName.endsWith(".docx"), "word导出请使用docx格式");
        if (!temDir.endsWith(File.separator)) {
            temDir = temDir + File.separator;
        }
        File dir = new File(temDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        // FileOutputStream fos = null;
        XWPFDocument doc = null;
        BufferedOutputStream fos = null;
        try {
            doc = WordExportUtil.exportWord07(templatePath, params);
            String tmpPath = temDir + fileName;
            LOGGER.info("统计报告|输出路径=" + tmpPath);
            //fos = new FileOutputStream(tmpPath);
            fos = new BufferedOutputStream(new FileOutputStream(tmpPath));
            doc.write(fos);
            fos.flush();

        } catch (Exception e) {
            LOGGER.error("生成docx文档错误", e);
        } finally {
            try {
                assert fos != null;
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
