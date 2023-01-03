package com.maimai.Master.Grammar;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.maimai.Common.UrlConstants;

import com.maimai.Utils.CsvUpload;
import com.maimai.Utils.DownloadUtils;

@RestController
@CrossOrigin
@RequestMapping(UrlConstants.GRAMMAR)
public class GrammarController {
	private static final Logger logger = LoggerFactory.getLogger(GrammarController.class);
	@Autowired
	GrammarService service;

	/**
	 * ユーザー全件取得
	 */
	@GetMapping(UrlConstants.GET)
	public List<GrammarReqModel> getGrammarMany() {
		// ユーザー全件取得-
		return service.selectMany();
	}

	/**
	 * ユーザー１件取得
	 */
	@GetMapping("/register/get/{id:.+}")
	public GrammarReqModel getGrammarOne(@PathVariable("id") String grammarId) {
		// ユーザー１件取得
		return service.selectOne(grammarId);
	}

	/**
	 * ユーザー１件登録
	 */
	@PostMapping("/register/insert")
	public String postGrammarOne(@RequestBody GrammarReqModel grammar) {
		// ユーザーを１件登録
		boolean result = service.insert(grammar);
		String str = "";
		if (result == true) {
			str = "{\"result\":\"ok\"}";
		} else {
			str = "{\"result\":\"error\"}";
		}

		// 結果用の文字列をリターン
		return str;
	}

	@DeleteMapping("/register/delete/{id:.+}")
	public String deleteGrammarOne(@PathVariable("id") String grammarId) {
		// ユーザーを１件削除
		boolean result = service.deleteOne(grammarId);
		String str = "";
		if (result == true) {
			str = "{\"result\":\"ok\"}";
		} else {
			str = "{\"result\":\"error\"}";
		}
		// 結果用の文字列をリターン
		return str;
	}

	@PostMapping("/download")
	public void download(HttpServletResponse response) {
		try {
			DownloadUtils.download(response);
		} catch (Exception e) {
			logger.error("ファイルダウンロードは失敗しました。", e);
		}
	}

	@PostMapping("/upcsv")
	public HttpStatus doUpload(@RequestPart("files") MultipartFile multilPartFile) throws Exception {
		List<String> result = CsvUpload.readCsvFile(multilPartFile);
		List<GrammarReqModel> listGrammar = GrammarReqModel.getListGrammar(result);
		for (GrammarReqModel grammar : listGrammar) {
			service.insert(grammar);
		}
		return HttpStatus.OK;
	}

}
