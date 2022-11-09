package com.maimai.Master.Grammar;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GrammarService {
	@Autowired
	GrammarDao dao;
  
	/**
	 * insert用メソッド.
	 */
	public boolean insert(GrammarReqModel grammar) {

		// insert実行
		int rowNumber = dao.insertOne(grammar);

		// 判定用変数
		boolean result = false;

		if (rowNumber > 0) {
			// insert成功
			result = true;
		}

		return result;
	}

	/**
	 * カウント用メソッド.
	 */
	public int count() {
		return dao.count();
	}

	/**
	 * 全件取得用メソッド.
	 */
	public List<GrammarReqModel> selectMany() {
		// 全件取得
		return dao.selectMany();
	}

	/**
	 * １件取得用メソッド.
	 */
	public GrammarReqModel selectOne(String grammarId) {
		// selectOne実行
		return dao.selectOne(grammarId);
	}

	/**
	 * １件更新用メソッド.
	 */
	public boolean updateOne(GrammarReqModel grammar) {

		// 判定用変数
		boolean result = false;

		// １件更新
		int rowNumber = dao.updateOne(grammar);

		if (rowNumber > 0) {
			// update成功
			result = true;
		}

		return result;
	}

	/**
	 * １件削除用メソッド.
	 */
	public boolean deleteOne(String grammarId) {

		// １件削除
		int rowNumber = dao.deleteOne(grammarId);

		// 判定用変数
		boolean result = false;

		if (rowNumber > 0) {
			// delete成功
			result = true;
		}
		return result;
	}

    String download(HttpServletResponse response) {
    	
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
