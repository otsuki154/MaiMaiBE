package com.maimai.RegisterUser;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.maimai.Common.Properties;
import com.maimai.Common.UrlConstants;
import com.maimai.Utils.CsvDownload;
import com.maimai.Utils.CsvUpload;

@RestController
@CrossOrigin
@Transactional(rollbackFor = Exception.class)
@RequestMapping(UrlConstants.USER)
public class RegisterUserController {
	
	 @Autowired
	RegisterUserService service;
	 /**
     * ユーザー全件取得
     */
    @GetMapping(UrlConstants.REGISTER)
    public List<RegisterUserReqModel> getUserMany() {
    	String msg = Properties.getMsg("max_check", new String [] {"UserName","8"});
        // ユーザー全件取得
        return service.selectMany();
    }
    
    @GetMapping("/csv")
    public ResponseEntity<byte[]> getUserListCsv() {
        return CsvDownload.getOutputCsvData("sample.csv",service.userCsvOut());
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
