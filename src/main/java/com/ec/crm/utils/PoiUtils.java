//package com.ec.crm.utils;
//
//
//
//import com.ec.common.db.fi.po.CustomerSea;
//import org.apache.poi.ss.usermodel.CellType;
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class PoiUtils {
//
////    //这是把数据导出到本地保存为Excel文件的方法
////    public static ResponseEntity<byte[]> exportJobLevelExcel(List<User> allUser) throws IOException {
////        HSSFWorkbook workbook = new HSSFWorkbook();//创建一个Excel文件
////
////        //创建Excel文档属性，必不可少。少了的话，getDocumentSummaryInformation()方法就会返回null
////        workbook.createInformationProperties();
////        DocumentSummaryInformation info = workbook.getDocumentSummaryInformation();
////        info.setCompany("KYO Ltd.");//设置公司信息
////        info.setManager("kyo");//设置管理者
////        info.setCategory("职称表");//设置文件名
////
////        //设置文件中的日期格式
////        HSSFCellStyle datecellStyle = workbook.createCellStyle();
////        datecellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));//这个文件的日期格式和平时的不一样
////
////        //创建表单
////        HSSFSheet sheet = workbook.createSheet("百威美食尚职称表");
////        HSSFRow r0 = sheet.createRow(0);//创建第一行
////        HSSFCell c0 = r0.createCell(0);// 创建列
////        HSSFCell c1 = r0.createCell(1);// 创建列
////        HSSFCell c2 = r0.createCell(2);// 创建列
////        HSSFCell c3 = r0.createCell(3);// 创建列
////        HSSFCell c4 = r0.createCell(4);// 创建列
////
////        c0.setCellValue("编号");
////        c1.setCellValue("职称名");
////        c2.setCellValue("职称级别");
////        c3.setCellValue("创建时间");
////        c4.setCellValue("是否可用");
////
////        for (int i = 0; i < allJobLevels.size(); i++) {
////            JObLevel jl=allJobLevels.get(i);
////            HSSFRow row = sheet.createRow(i + 1);
////            HSSFCell cell0 = row.createCell(0);
////            cell0.setCellValue(jl.getId());
////            HSSFCell cell1 = row.createCell(1);
////            cell1.setCellValue(jl.getName());
////            HSSFCell cell2 = row.createCell(2);
////            cell2.setCellValue(jl.getTitlelevel());
////            HSSFCell cell3 = row.createCell(3);
////            cell3.setCellStyle(datecellStyle);//让日期格式数据正确显示
////            cell3.setCellValue(jl.getCreatedate());
////            HSSFCell cell4 = row.createCell(4);
////            cell4.setCellValue(jl.getEnabled()?"是":"否");
////        }
////        HttpHeaders headers = new HttpHeaders();
////        headers.setContentDispositionFormData("attachment",
////                new String("职称表.xls".getBytes("UTF-8"),"iso-8859-1"));
////        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
////        ByteArrayOutputStream baos=new ByteArrayOutputStream();
////        workbook.write(baos);
////
////        ResponseEntity<byte[]> entity = new ResponseEntity<>(baos.toByteArray(), headers, HttpStatus.CREATED);
////
////        return entity;
////    }
//
//    //这是解析上传的Excel文件为对象集合，从而批量添加数据的方法
//    public static List<CustomerSea> parseFile2List(MultipartFile file) throws IOException {
//        List<CustomerSea> users=new ArrayList<>();
//        XSSFWorkbook workbook=new XSSFWorkbook(file.getInputStream());
//
//        XSSFSheet sheet = workbook.getSheetAt(0);
//        int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();//获取表单所有的行
//        for (int i = 1; i < physicalNumberOfRows; i++) {
//            XSSFRow row = sheet.getRow(i);
//            CustomerSea  customerSea=new CustomerSea();
//
////            HSSFCell c0 = row.getCell(0);
////            user1.setAccount((int) c0.getNumericCellValue());
//
//            XSSFCell c1 = row.getCell(1);//excel 表里的下表 从0开始
//            user1.setAccount(c1.getStringCellValue());
//
////            XSSFCell c2 = row.getCell(2);
////            user1.setNam(c2.getStringCellValue());
//
//            XSSFCell c2 = row.getCell(2);
//            user1.setEmail(c2.getStringCellValue());
//
//            XSSFCell c3 = row.getCell(3);
//            c3.setCellType(CellType.STRING);
//            user1.setTel(c3.getStringCellValue());
//
//            XSSFCell c5 = row.getCell(5);
//            c5.setCellType(CellType.STRING);
//            user1.setUsername(c5.getStringCellValue());
//
//            XSSFCell c6 = row.getCell(6);
//            c6.setCellType(CellType.STRING);
//            user1.setPassword(c6.getStringCellValue());
//
////            Timestamp timestamp=new Timestamp(System.currentTimeMillis());
////            System.out.println(timestamp);
////            user1.setCreateTime(timestamp);
//
//            users.add(user1);
//        }
//        return users;
//    }
//}
//
