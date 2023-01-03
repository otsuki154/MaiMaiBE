package com.maimai.Master.Grammar;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class GrammarDao {

	@Autowired
	JdbcTemplate jdbc;

	// Grammarテーブルの件数を取得.

	public int count() throws DataAccessException {

		// 全件取得してカウント
		int count = jdbc.queryForObject("SELECT COUNT(*) FROM m_grammar", Integer.class);

		return count;
	}

	// Grammarテーブルにデータを1件insert.

	public int insertOne(GrammarReqModel grammar) throws DataAccessException {
		// １件登録
		int rowNumber = jdbc.update(
				"INSERT INTO m_grammar(grammarCd," + " grammarContent," + " meanVi," + " meanFunction," + " wayUse,"
						+ " literaryNature," + " example," + " diffLevel)" + " VALUES(?, ?, ?, ?, ?, ?, ?, ?)",
				grammar.getGrammarCd(), grammar.getGrammarContent(), grammar.getMeanVi(), grammar.getMeanFunction(),
				grammar.getWayUse(), grammar.getLiteraryNature(), grammar.getExample(), grammar.getDiffLevel());

		return rowNumber;
	}

	// Grammarテーブルのデータを１件取得

	public GrammarReqModel selectOne(String grammarCd) throws DataAccessException {

		// １件取得
		Map<String, Object> map = jdbc.queryForMap("SELECT * FROM m_grammar" + " WHERE grammarCd = ?", grammarCd);

		// 結果返却用の変数
		GrammarReqModel grammar = new GrammarReqModel();

		// 取得したデータを結果返却用の変数にセットしていく
		grammar.setGrammarNo((Integer) map.get("grammarNo"));
		grammar.setGrammarCd((String) map.get("grammarCd"));
		grammar.setGrammarContent((String) map.get("grammarContent"));
		grammar.setMeanVi((String) map.get("meanVi"));
		grammar.setMeanFunction((String) map.get("meanFunction"));
		grammar.setWayUse((String) map.get("wayUse"));
		grammar.setLiteraryNature((String) map.get("literaryNature"));
		grammar.setExample((String) map.get("example"));
		grammar.setDiffLevel((String) map.get("diffLevel"));

		return grammar;
	}

	// Grammarテーブルの全データを取得.

	public List<GrammarReqModel> selectMany() throws DataAccessException {

		// M_USERテーブルのデータを全件取得
		List<Map<String, Object>> getList = jdbc.queryForList("SELECT * FROM m_grammar");

		// 結果返却用の変数
		List<GrammarReqModel> grammarrList = new ArrayList<>();

		// 取得したデータを結果返却用のListに格納していく
		for (Map<String, Object> map : getList) {

			// Grammarインスタンスの生成
			GrammarReqModel grammar = new GrammarReqModel();

			// Grammarインスタンスに取得したデータをセットする
			grammar.setGrammarNo((Integer) map.get("grammarNo"));
			grammar.setGrammarCd((String) map.get("grammarCd"));
			grammar.setGrammarContent((String) map.get("grammarContent"));
			grammar.setMeanVi((String) map.get("meanVi"));
			grammar.setMeanFunction((String) map.get("meanFunction"));
			grammar.setWayUse((String) map.get("wayUse"));
			grammar.setLiteraryNature((String) map.get("literaryNature"));
			grammar.setExample((String) map.get("example"));
			grammar.setDiffLevel((String) map.get("diffLevel"));

			// 結果返却用のListに追加
			grammarrList.add(grammar);
		}

		return grammarrList;
	}

	// Grammarテーブルを１件更新.

	public int updateOne(GrammarReqModel grammar) throws DataAccessException {

		// １件更新
		int rowNumber = jdbc.update(
				"UPDATE m_grammar" + " SET" + " grammarContent = ?," + " meanVi = ?," + " meanFunction = ?,"
						+ " wayUse = ?" + " literaryNature = ?" + " example = ?" + " diffLevel = ?"
						+ " WHERE grammarCd = ?",
				grammar.getGrammarContent(), grammar.getMeanVi(), grammar.getMeanFunction(), grammar.getWayUse(),
				grammar.getLiteraryNature(), grammar.getExample(), grammar.getDiffLevel(), grammar.getGrammarCd());

		// トランザクション確認のため、わざと例外をthrowする
		// if (rowNumber > 0) {
		// throw new DataAccessException("トランザクションテスト") {
		// };
		// }

		return rowNumber;
	}

	// Grammarテーブルを１件削除.

	public int deleteOne(String grammarCd) throws DataAccessException {

		// １件削除
		int rowNumber = jdbc.update("DELETE FROM m_grammar WHERE grammarCd = ?", grammarCd);

		return rowNumber;
	}

	// SQL取得結果をサーバーにCSVで保存する

//    public void grammarrCsvOut() throws DataAccessException {
//
//        // M_USERテーブルのデータを全件取得するSQL
//        String sql = "SELECT * FROM m_grammar";
//
//        // ResultSetExtractorの生成
//        GrammarRowCallbackHandler handler = new GrammarRowCallbackHandler();
//
//        //SQL実行＆CSV出力
//        jdbc.query(sql, handler);
//    }
}
