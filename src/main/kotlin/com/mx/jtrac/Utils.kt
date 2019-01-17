package com.mx.jtrac


object Utils {

    val EXCEL_ROOT:String = "E:\\bak\\"
    val EXCEL_NAME:String = "test.xlsx"

    fun getRootPath(): String {
        return System.getProperty("base") ?: EXCEL_ROOT
    }

    fun getFileName(): String {
        return System.getProperty("file") ?: EXCEL_NAME
    }

}