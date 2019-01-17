package com.mx.jtrac

import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.FileInputStream
import org.apache.poi.ss.usermodel.DataFormatter


class ExcelReader(private val filePath: String) {

    init {
        readExcel()
    }

    var outerList: List<JtracInfo>? = null

    fun readExcel() {
        val fileType = filePath.substring(filePath.lastIndexOf(".") + 1, filePath.length)
        val stream = FileInputStream(filePath)
        var wb: Workbook? = null
        when (fileType) {
            "xls" ->
                wb = HSSFWorkbook(stream)
            "xlsx" ->
                wb = XSSFWorkbook(stream)
            else ->
                println("您输入的excel格式不正确")
        }

        val sheet1 = wb!!.getSheetAt(0)
        val formatter = DataFormatter()

        val list = mutableListOf<JtracInfo>()
        var jtracInfo: JtracInfo
        var conflictList = mutableListOf<JtracInfo>()
        for (row in sheet1) {
            val date = formatter.formatCellValue(row.getCell(0))
            val no = formatter.formatCellValue(row.getCell(1))
            val conflictNo = formatter.formatCellValue(row.getCell(2)).substring(4)

            if (no != "") {
                jtracInfo = JtracInfo(no.substring(4))
                conflictList = mutableListOf(JtracInfo(conflictNo))
                jtracInfo.date = date
                jtracInfo.confilctNo = conflictList
                list.add(jtracInfo)
            } else {
                conflictList.add(JtracInfo(conflictNo))
            }
        }
        outerList = list
    }


}