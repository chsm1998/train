package com.two.train.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.two.train.common.ServerResponse;
import com.two.train.entity.Site;
import com.baomidou.mybatisplus.extension.service.IService;
import com.two.train.vo.SiteVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author chsm
 * @since 2018-09-27
 */
public interface ISiteService extends IService<Site> {

    /**
     * 新增站点
     * @param site  站点信息
     * @return  是否新增成功
     */
    ServerResponse<String> add(Site site);

    /**
     * 删除站点
     * @param id 站点id
     * @return  删除后的站点信息
     */
    ServerResponse<String> delete(Integer id);

    /**
     * 更新站点信息
     * @param site  站点信息
     * @return  是否更新成功
     */
    ServerResponse<String> update(Site site);

    /**
     * 校验站点名称是否存
     * @param siteName  站点名称
     * @return  是否存
     */
    ServerResponse<String> checkSiteName(String siteName);

    /**
     * 通过站点名查询站点
     * @param siteName  站点名
     * @return  站点信息
     */
    ServerResponse<List<Site>> queryBySiteName(String siteName);

    /**
     * 分页查询站点信息
     * @param siteVo    站点信息
     * @return  查询站点信息
     */
    ServerResponse<IPage<Site>> queryPage(SiteVo siteVo);

}
