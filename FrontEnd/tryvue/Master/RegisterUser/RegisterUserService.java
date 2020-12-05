package com.maimai.Master.RegisterUser;

import java.util.HashMap;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.maimai.Utils.PrintPdf;

@Service
public class RegisterUserService {
	@Autowired
	RegisterUserDao dao;
  
	/**
	 * insert用メソッド.
	 */
	public boolean insert(RegisterUserReqModel user) {

		// insert実行
		int rowNumber = dao.insertOne(user);

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
	public List<RegisterUserReqModel> selectMany() {
		// 全件取得
		return dao.selectMany();
	}

	/**
	 * １件取得用メソッド.
	 */
	public RegisterUserReqModel selectOne(String userId) {
		// selectOne実行
		return dao.selectOne(userId);
	}

	/**
	 * １件更新用メソッド.
	 */
	public boolean updateOne(RegisterUserReqModel user) {

		// 判定用変数
		boolean result = false;

		// １件更新
		int rowNumber = dao.updateOne(user);

		if (rowNumber > 0) {
			// update成功
			result = true;
		}

		return result;
	}

	/**
	 * １件削除用メソッド.
	 */
	public boolean deleteOne(String userId) {

		// １件削除
		int rowNumber = dao.deleteOne(userId);

		// 判定用変数
		boolean result = false;

		if (rowNumber > 0) {
			// delete成功
			result = true;
		}
		return result;
	}

	// ユーザー一覧をCSV出力する.
	/**
	 * @throws DataAccessException
	 */
	public byte[] userCsvOut() throws DataAccessException {
		String header = "UserID,Password,UserName,Birthday,Age,Marriage,Role";
		String contents = "";
		contents = header + "\r\n";

		// CSV内容を取得
		List<RegisterUserReqModel> getResult = dao.selectMany();
		for (RegisterUserReqModel rs : getResult) {
			contents += rs.getUserId() + "," +rs.getPassword() + "," + rs.getUserName() + "," + rs.getBirthday() + ","
					+ rs.getAge() + "," + rs.isMarriage() + "," + rs.getRole();
			contents += "\r\n";
		}
		return contents.getBytes();
	}
	
	public  ResponseEntity<byte[]> printPdf( ) {
		String fileNm="ListUser";
		List<RegisterUserReqModel> list = dao.selectMany();
		HashMap<String, Object> params = new HashMap<String, Object> ();
		 params.put("userId", "yamada@xxx.co.jp");
		return PrintPdf.printPdf(fileNm,list,params);
	}
}
