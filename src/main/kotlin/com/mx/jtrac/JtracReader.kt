package com.mx.jtrac

import java.io.InputStreamReader
import java.io.BufferedReader
import java.net.URL


class JtracReader(private val jtracNo: Int) {


     fun getContent():JtracInfo {
        val url = URL("http://109.14.6.42:70/jtrac/app/item/V2A-$jtracNo")
        val br = BufferedReader(
            InputStreamReader(
                url.openStream(), "utf-8"
            )
        )
        var s:String
        val sb = StringBuffer("")
        while (true) {
            s = br.readLine()
            if (s != null)
                sb.append(s)
            else
                break
        }
        br.close()

        val regex = Regex("^(.+)<td(.+?)>状态</td>\\s+<td>(.+?)</td>(.+)$")

        val jtracInfo = JtracInfo(jtracNo.toString())
        jtracInfo.state = sb.toString().replace(regex, "$3")
        return jtracInfo
    }
}