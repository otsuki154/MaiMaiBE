package com.maimai.Master.RegisterUser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
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

import com.maimai.Utils.CsvDownload;
import com.maimai.Utils.CsvUpload;
import com.maimai.Utils.PrintPdf;

@RestController
@CrossOrigin
@RequestMapping("/register")
public class RegisterUserController {

    @Autowired
    RegisterUserService service;

    /**
     * ユーザー全件取得
     */
    @GetMapping("/get")
    public List<RegisterUserReqModel> getUserMany() {

        // ユーザー全件取得
        return service.selectMany();
    }

    /**
     * ユーザー１件取得
     */
    @GetMapping("/register/get/{id:.+}")
    public RegisterUserReqModel getUserOne(@PathVariable("id") String userId) {

        // ユーザー１件取得
        return service.selectOne(userId);
    }

    /**
     * ユーザー１件登録
     */
    @PostMapping("/register/insert")
    public String postUserOne(@RequestBody RegisterUserReqModel user) {

        // ユーザーを１件登録
        boolean result = service.insert(user);

        String str = "";

        if(result == true) {

            str = "{\"result\":\"ok\"}";

        } else {

            str = "{\"result\":\"error\"}";

        }

        // 結果用の文字列をリターン
        return str;
    }

 

    @DeleteMapping("/register/delete/{id:.+}")
    public String deleteUserOne(@PathVariable("id") String userId) {

        // ユーザーを１件削除
        boolean result = service.deleteOne(userId);

        String str = "";

        if(result == true) {

            str = "{\"result\":\"ok\"}";

        } else {

            str = "{\"result\":\"error\"}";

        }

        // 結果用の文字列をリターン
        return str;
    }

    @GetMapping("/csv")
    public ResponseEntity<byte[]> getUserListCsv(Model model) {
        return CsvDownload.getOutputCsvData("sample.csv",service.userCsvOut());
    }
    
    @GetMapping("/print2")
    public ResponseEntity<byte[]> printPdf() {
    	return  service.printPdf();
    }
    
  
    @PostMapping("/upcsv")
    public HttpStatus doUpload(@RequestPart("files") MultipartFile multilPartFile) throws Exception {
    	List<String> result = CsvUpload.readCsvFile(multilPartFile);
    	List<RegisterUserReqModel> listUser = RegisterUserReqModel.getListUser(result);
    	for (RegisterUserReqModel user : listUser) {
    		service.insert(user);
		}
    	return HttpStatus.OK;
    }

}
