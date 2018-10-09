package com.two.train.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.two.train.common.ServerResponse;
import com.two.train.entity.Site;
import com.two.train.mapper.SiteMapper;
import com.two.train.service.ISiteService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.two.train.vo.SiteVo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chsm
 * @since 2018-09-27
 */
@Service
public class SiteServiceImpl extends ServiceImpl<SiteMapper, Site> implements ISiteService {

    @Override
    public ServerResponse<String> add(Site site) {
        Site nullSite = baseMapper.selectOne(new QueryWrapper<Site>()
                .eq("site_name", site.getSiteName()));
        if (nullSite != null) {
            return ServerResponse.createErrorMessage("非法操作，站点已存在");
        }
        int count = baseMapper.insert(site);
        if (count != 1) {
            ServerResponse.createErrorMessage("新增站点失败，服务器异常");
        }
        return ServerResponse.createSuccessMessage("新增站点成功");
    }

    @Override
    public ServerResponse<String> delete(Integer id) {
        int count = baseMapper.deleteById(id);
        if (count != 1) {
            return ServerResponse.createErrorMessage("删除站点失败，服务器异常");
        }
        return ServerResponse.createSuccessMessage("删除站点成功");
    }

    @Override
    public ServerResponse<String> update(Site site) {
        Site oldSite = baseMapper.selectOne(new QueryWrapper<Site>()
                .eq("site_name", site.getSiteName()));
        if (oldSite != null) {
            return ServerResponse.createErrorMessage("非法操作，站点已存在");
        }
        int count = baseMapper.updateById(site);
        if (count != 1) {
            return ServerResponse.createErrorMessage("更新站点信息失败，服务器异常");
        }
        return ServerResponse.createSuccessMessage("更新站点信息成功");
    }

    @Override
    public ServerResponse<String> checkSiteName(String siteName) {
        Site site = baseMapper.selectOne(new QueryWrapper<Site>()
                .eq("site_name", siteName));
        if (site != null) {
            return ServerResponse.createErrorMessage("站点已存在");
        }
        return ServerResponse.createSuccessMessage("站点名称可用");
    }

    @Override
    public ServerResponse<List<Site>> queryBySiteName(String siteName) {
        List<Site> sites = baseMapper.selectList(new QueryWrapper<Site>()
                .like("site_name", siteName));
        return ServerResponse.createSuccessData("获取信息成功", sites);
    }

    @Override
    public ServerResponse<IPage<Site>> queryPage(SiteVo siteVo) {
        IPage<Site> siteIPage = baseMapper.selectPage(
                new Page<>(
                        siteVo.getMyPage().getCurrPage(),
                        siteVo.getMyPage().getPageSize()),
                new QueryWrapper<Site>()
                        .like("site_name", siteVo.getSiteName()));
        return ServerResponse.createSuccessData("获取站点信息成功", siteIPage);
    }
}
