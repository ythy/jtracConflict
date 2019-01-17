package com.mx.jtrac

import java.util.*

class Main {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            println("root: ${Utils.getRootPath()}")

            val reader = ExcelReader("${Utils.getRootPath()}\\${Utils.getFileName()}")
            val list = reader.outerList!!
            println("start")


            val scanner = Scanner(System.`in`)
            while(scanner.hasNext()) {
                val input = scanner.nextInt()
                var validNo = false
                list.forEach {
                    if(it.no == input.toString()){
                        validNo = true
                        it.confilctNo.forEach {
                            println("V2A-${it.no}  ${JtracReader(it.no.toInt()).getContent().state}")
                        }
                    }
                }
                if(!validNo)
                    println("未查询到结果")
            }
        }
    }


}