package com.lattice.latticeothers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.lattice.latticeothers.service.QiNiuService;
import com.qiniu.storage.model.DefaultPutRet;

/**
 * @Description: ${description}
 * @Author: 张家豪
 * @CreateDate: 2019-01-02 21:43
 * @UpdateUser: 张家豪
 * @UpdateDate: 2019-01-02 21:43
 * @UpdateRemark: 未修改
 * @Version: 1.0
 */
@RestController
@RequestMapping("/qiniu")
public class QiNiuController {
    @Autowired
    private QiNiuService qiNiuService;
    
    @PostMapping("/upload")
    public boolean upload(@RequestParam("file") MultipartFile file) {
        String upload = qiNiuService.upload(file);
        Gson gson = new Gson();
        DefaultPutRet defaultPutRet = gson.fromJson(upload, DefaultPutRet.class);
        System.out.println(upload);
        System.out.println(defaultPutRet);
        return upload != null;
    }
}
