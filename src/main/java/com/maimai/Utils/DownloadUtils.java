package com.maimai.Utils;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

public class DownloadUtils {

	public static String download(HttpServletResponse response) {
    	
        try (OutputStream os = response.getOutputStream();) {
        	
        	String inputString = "Hello World!";
        	byte[] byteArrray = inputString.getBytes();

            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment; filename=test.txt");
            response.setContentLength(byteArrray.length);
            os.write(byteArrray);
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
