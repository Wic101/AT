package com.utilslib;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Map;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class ExcelReadHelper {
	
	
	/*
	 * @filePath 用例文件路径
	 * @book 用例文件的Workbook
	 */
	String filePath = "";
	String sheetName = "";
	
	public ExcelReadHelper(String filePath, String sheetName){
		this.filePath = filePath;
		this.sheetName = sheetName;
	}
	
	public Workbook getWorkbook(){
		File f = new File(this.filePath);
		if (!f.exists()){
			System.out.println("指定文件不存在，"+ this.filePath);
			System.exit(0);
		}
		Workbook book;
		try {
			book = Workbook.getWorkbook(f);
			return book;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("文件解析失败！位置：" + this.filePath);
			e.printStackTrace();
			return null;
		} 
		
	}

	
	public Sheet getWorkSheet() throws Exception{

		Sheet sheet = this.getWorkbook().getSheet(this.sheetName);
		Boolean b = (sheet==null);
		if(b){
			throw new Exception("在文件："+this.filePath +" 中无法找到指定sheet："+this.sheetName);
		}
		return sheet;
	}
	
//	获取caseName,用户合成caseID
	public String[] getCaseName() throws Exception{
		Sheet sheet = this.getWorkSheet();
		
		Cell[] cell = sheet.getColumn(0);
		String[] caseName = new String[sheet.getRows()];
		for (int i = 0 ; i < sheet.getRows() ; i++){
			caseName[i] = cell[i].getContents();
		}
		
		return caseName;
	}
	/*
	 *@fileName 当前文件名，不含后缀，用于成成caseID	
	 * 
	 */
	public String getFileName(){
		File f = new File(this.filePath);
		return f.getName().split(".")[0];
	}
	
	/*
	 * @sheetName 当前表名，用户合成caseID
	 * @sheetName 在业务中对应接口名称
	 */
	public String[] getSheetNames(){
		String[] workSheets = this.getWorkbook().getSheetNames();
		return workSheets;
	}
	
	
	/*
	 * @header参数名称，不包含caseName列
	 */
	public String[] getHeader() throws Exception{
		Sheet sheet = this.getWorkSheet();
		Cell[] cell = sheet.getRow(0);
		String[] header = new String[sheet.getColumns()-1];
		for (int i = 1 ; i < sheet.getColumns() ; i++){
			header[i-1] = cell[i].getContents();
		}
		return header;
	}
	
	/*
	 * 	@rowData 获取每一行数据，不包含caseName列
	 *  为key:value 格式的map
	 */
	public Map<String, String> readRecord(int row) throws Exception{
		Sheet sheet = this.getWorkSheet();
		int column_count = sheet.getColumns();
		String[] header = this.getHeader();
		Map<String, String> singleCase = new HashMap<String, String>();
		
		for (int i = 1 ; i < column_count ; i++){
			String key = header[i-1];
			String value = sheet.getCell(i, row).getContents();
			singleCase.put(key, value);
		}
		return singleCase;
	}
	
	/*
	 * @readsheet 读取一张表中所有的数据
	 */
	
	
	public Map<String, Map<String,String>> readSheet( ){
		
		try {
			Sheet sheet = this.getWorkSheet();
			Map<String, Map<String, String>> dataFromSheet = new HashMap<String, Map<String,String>>();
			
			String caseName = "";
			for(int row = 1 ; row < sheet.getRows() ; row++){
				caseName = sheet.getCell(0, row).getContents();//每行的第0列为caseName
				dataFromSheet.put(caseName, this.readRecord(row));
			}
		
			return dataFromSheet;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	

}
