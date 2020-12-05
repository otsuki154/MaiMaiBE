package com.maimai.Utils;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CsvDownload {
	
	public static ResponseEntity<byte[]> getOutputCsvData( String fileNm, byte[] bytes) {
	    //HTTPヘッダーの設定
        HttpHeaders header = new HttpHeaders();
        header.add("Content-Type", "text/csv; charset=UTF-8");
        header.setContentDispositionFormData("filename", fileNm);
        return new ResponseEntity<>(bytes, header, HttpStatus.OK);
	}

}
