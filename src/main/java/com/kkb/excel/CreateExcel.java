package com.kkb.excel;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileOutputStream;
import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CreateExcel {

    private static HSSFSheet sheet ;

    public static void main(String[] args) throws Exception {
        String filePath="d:\\users\\lizw\\桌面\\POI\\sample.xls";//文件路径
        HSSFWorkbook workbook = new HSSFWorkbook();//创建Excel文件(Workbook)

        sheet = workbook.createSheet("Test");//创建工作表(Sheet)
        threadPollCreateRow();
        FileOutputStream out = new FileOutputStream(filePath);
        workbook.write(out);//保存Excel文件
        out.close();//关闭文件流
        System.out.println("OK!");

    }

    public static void createRow(int rowNum ){

        HSSFRow row = sheet.createRow(rowNum);// 创建行,从0开始
        HSSFCell cell = row.createCell(0);// 创建行的单元格,也是从0开始
        cell.setCellValue("李志伟");// 设置单元格内容
        row.createCell(1).setCellValue(false);// 设置单元格内容,重载
        row.createCell(2).setCellValue(new Date());// 设置单元格内容,重载
        row.createCell(3).setCellValue(12.345);// 设置单元格内容,重载

    }

    static class MyThread extends Thread{
        private int num ;

        public  MyThread(int num){
            this.num = num;
        }

        @Override
        public void run() {
            createRow(num);
        }
    }

    public static void threadPollCreateRow(){

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                50,
                100,
                0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());

        for(int i = 0; i <10000; i++){
            executor.submit(new MyThread(i));
        }

        executor.shutdown();

        while(true){
            if(executor.isTerminated()){
                System.out.println("子任务执行完毕");
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


}
