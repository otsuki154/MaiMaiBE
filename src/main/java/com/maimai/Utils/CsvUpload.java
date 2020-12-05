package com.maimai.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class CsvUpload {
	   public static List<String> readCsvFile(MultipartFile multilPartFile) {
			List<String> resultList = new ArrayList<String>();
			String line = null;
			try {
				InputStream stream = multilPartFile.getInputStream();
				Reader reader = new InputStreamReader(stream);
				BufferedReader buf = new BufferedReader(reader);
//			ファイルを読込
				while ((line = buf.readLine()) != null) {
					resultList.add(line);
				}

			} catch (IOException e) {

				e.printStackTrace();
			}
			return resultList;
		}

}
