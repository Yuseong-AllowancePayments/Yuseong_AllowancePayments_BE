package com.example.yuseong_allowancepayments_be.thirdparty.excel

import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.apache.poi.openxml4j.util.ZipSecureFile
import org.apache.poi.poifs.crypt.Decryptor
import org.apache.poi.poifs.crypt.EncryptionInfo
import org.apache.poi.poifs.filesystem.POIFSFileSystem
import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.springframework.web.multipart.MultipartFile

fun MultipartFile.transferToExcel(password: String): Workbook {
    val inputStream = this.inputStream
    val fs = POIFSFileSystem(this.inputStream)
    val decryptor = Decryptor.getInstance(EncryptionInfo(fs))
    ZipSecureFile.setMinInflateRatio(0.0)
    decryptor.verifyPassword(password)
    return inputStream.use {
        runCatching {
            val splitFileName = this.originalFilename?.split('.')
            when (splitFileName?.get(splitFileName.lastIndex)) {
                "xls" -> HSSFWorkbook(decryptor.getDataStream(fs))
                "xlsx" -> XSSFWorkbook(decryptor.getDataStream(fs))
                else -> throw RuntimeException("Invalid File")
            }
        }.onFailure {
            it.printStackTrace()
            throw RuntimeException("Invalid File")
        }.getOrThrow()
    }
}
