package com.maimai.Master.Grammar;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.maimai.Utils.PrintPdf;
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


	
	public  ResponseEntity<byte[]> printPdf( ) {
		String fileNm="ListGrammar";
		List<GrammarReqModel> list = dao.selectMany();
		HashMap<String, Object> params = new HashMap<String, Object> ();
		 params.put("grammarId", "yamada@xxx.co.jp");
		return PrintPdf.printPdf(fileNm,list,params);
	}
}
