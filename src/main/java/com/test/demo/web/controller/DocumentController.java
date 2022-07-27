package com.test.demo.web.controller;

import com.test.demo.web.dto.UserCityDTO;
import com.test.demo.web.entity.UserDocument;
import com.test.demo.web.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author yangqingfang
 * @since 2022/7/20 16:39
 */
@RestController
public class DocumentController {

    @Autowired
    DocumentService documentService;

    @RequestMapping("/createUserDocument")
    public Boolean createUserDocument(UserDocument document) throws Exception{
        return documentService.createUserDocument(document);
    }

    @RequestMapping("/bulkCreateUserDocument")
    public Boolean bulkCreateUserDocument(List<UserDocument> documents) throws Exception{
        return documentService.bulkCreateUserDocument(documents);
    }

    @RequestMapping("/getUserDocument")
    public UserDocument getUserDocument(String id) throws Exception{
        return documentService.getUserDocument(id);
    }

    @RequestMapping("/updateUserDocument")
    public Boolean updateUserDocument(UserDocument document) throws Exception{
        return documentService.updateUserDocument(document);
    }

    @RequestMapping("/deleteUserDocument")
    public String deleteUserDocument(String id) throws Exception{
        return documentService.deleteUserDocument(id);
    }

    @RequestMapping("/searchUserByCity")
    public List<UserDocument> searchUserByCity(String city) throws Exception{
        return documentService.searchUserByCity(city);
    }

    @RequestMapping("/aggregationsSearchUser")
    public List<UserCityDTO> aggregationsSearchUser() throws Exception{
        return documentService.aggregationsSearchUser();
    }

}
