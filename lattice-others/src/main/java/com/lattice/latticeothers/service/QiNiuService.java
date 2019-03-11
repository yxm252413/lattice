package com.lattice.latticeothers.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Description: ${description}
 * @Author: 张家豪
 * @CreateDate: 2019-01-02 21:57
 * @UpdateUser: 张家豪
 * @UpdateDate: 2019-01-02 21:57
 * @UpdateRemark: 未修改
 * @Version: 1.0
 */
public interface QiNiuService {
    
    String upload(MultipartFile file);
}
