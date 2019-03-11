package com.lattice.latticeothers.service.impl;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.lattice.latticeothers.service.QiNiuService;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;

/**
 * @Description: ${description}
 * @Author: 张家豪
 * @CreateDate: 2019-01-02 21:57
 * @UpdateUser: 张家豪
 * @UpdateDate: 2019-01-02 21:57
 * @UpdateRemark: 未修改
 * @Version: 1.0
 */
@Service
@PropertySource("classpath:qiniuyun.properties")
public class QiNiuServiceImpl implements QiNiuService {
    private static String accessKey = "VE3UI_2oVOB35ubKJtHlrHD054v3FFjGFxVbaKse";
    
    private static String secretKey = "OihKEDtAy73FZIMVOPMknX5h9Rv40DlGyLI9v9Qm";
    
    private static String bucket = "lattice";
    
    private static UploadManager uploadManager = null;
    
    private static Auth auth = null;
    static {
        Auth auth = Auth.create(accessKey, secretKey);
        Configuration cfg = new Configuration(Zone.zone0());
        // ...其他参数参考类注释
        uploadManager = new UploadManager(cfg);
    }
    
    @Override
    public String upload(MultipartFile file) {
        String name = file.getName();
        String upToken = auth.uploadToken(bucket, name);
        String result = null;
        try {
            InputStream inputStream = file.getInputStream();
            Response put = uploadManager.put(inputStream, name, upToken, null, null);
            result = put.getInfo();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        
        return result;
    }
}
