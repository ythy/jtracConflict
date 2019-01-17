package com.mx.jtrac

class JtracInfo(var no:String = "") {
    var date:String = ""
    var confilctNo:List<JtracInfo> = mutableListOf()
    var state:String = ""
}