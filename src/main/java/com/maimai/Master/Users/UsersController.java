package com.maimai.Master.Users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.maimai.Common.UrlConstants;
import com.maimai.Utils.CsvUpload;

@RestController
@CrossOrigin
@Transactional(rollbackFor = Exception.class)
@RequestMapping(UrlConstants.USERS)
public class UsersController {
	
	 @Autowired
	UsersService service;
	 /**
     * ユーザー全件取得
     */
    @GetMapping(UrlConstants.GET)
    public List<UsersReqModel> getUserMany() {
        // ユーザー全件取得
        return service.selectMany();
    }
    
    @PostMapping(UrlConstants.UP_CSV)
    public HttpStatus doUpload(@RequestPart("files") MultipartFile multilPartFile) throws Exception {
    	List<String> result = CsvUpload.readCsvFile(multilPartFile);
    	List<UsersReqModel> listUser = UsersReqModel.getListUser(result);
    	for (UsersReqModel user : listUser) {
    		service.insert(user);
		}
    	return HttpStatus.OK;
    }
}
