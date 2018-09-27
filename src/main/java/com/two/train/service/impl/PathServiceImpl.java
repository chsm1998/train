package com.two.train.service.impl;

import com.two.train.entity.Path;
import com.two.train.mapper.PathMapper;
import com.two.train.service.IPathService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chsm
 * @since 2018-09-27
 */
@Service
public class PathServiceImpl extends ServiceImpl<PathMapper, Path> implements IPathService {

}
