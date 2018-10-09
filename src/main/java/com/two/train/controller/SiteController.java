package com.two.train.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.two.train.common.ServerResponse;
import com.two.train.entity.Site;
import com.two.train.service.ISiteService;
import com.two.train.vo.SiteVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author chsm
 * @since 2018-09-27
 */
@RestController
@RequestMapping("/site")
public class SiteController {

    @Autowired
    private ISiteService siteService;

    public SiteController(ISiteService siteService) {
        this.siteService = siteService;
    }

    @PostMapping("/after/add")
    public ServerResponse<String> add(@RequestBody Site site) {
        return siteService.add(site);
    }

    @DeleteMapping("/after/delete")
    public ServerResponse<String> delete(Integer id) {
        return siteService.delete(id);
    }

    @PutMapping("/after/update")
    public ServerResponse<String> update(@RequestBody Site site) {
        return siteService.update(site);
    }

    @GetMapping("/after/check")
    public ServerResponse<String> checkSiteName(String siteName) {
        return siteService.checkSiteName(siteName);
    }

    @PostMapping("/after/queryPage")
    public ServerResponse<IPage<Site>> queryPage(@RequestBody SiteVo siteVo) {
        return siteService.queryPage(siteVo);
    }

    @GetMapping("/after/queryBySiteName")
    public ServerResponse<List<Site>> queryBySiteName(String siteName) {
        return siteService.queryBySiteName(siteName);
    }

}

