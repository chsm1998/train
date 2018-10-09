package com.two.train.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.two.train.common.ServerResponse;
import com.two.train.entity.TrainType;
import com.two.train.mapper.TrainTypeMapper;
import com.two.train.service.ITrainTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.two.train.vo.TrainTypeVo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chsm
 * @since 2018-10-09
 */
@Service
public class TrainTypeServiceImpl extends ServiceImpl<TrainTypeMapper, TrainType> implements ITrainTypeService {

    @Override
    public ServerResponse<String> addList(List<TrainType> trainTypes) {
        boolean b = saveBatch(trainTypes);
        if (b) {
            return ServerResponse.createSuccessMessage("批量插入列车类型成功");
        }
        return ServerResponse.createErrorMessage("批量插入列车类型失败，服务器异常");
    }

    @Override
    public ServerResponse<String> delete(Integer id) {
        int count = baseMapper.deleteById(id);
        if (count != 1) {
            return ServerResponse.createErrorMessage("删除列车类型失败，服务器异常");
        }
        return ServerResponse.createSuccessMessage("删除列车类型成功");
    }

    @Override
    public ServerResponse<String> update(TrainType trainType) {
        int count = baseMapper.updateById(trainType);
        if (count != 1) {
            return ServerResponse.createErrorMessage("更新列车类型失败，服务器异常");
        }
        return ServerResponse.createSuccessMessage("更新列车类型成功");
    }

    @Override
    public ServerResponse<List<TrainType>> queryByType(String type) {
        List<TrainType> trainTypes = baseMapper.selectList(new QueryWrapper<TrainType>()
                .like("train_type", type));
        return ServerResponse.createSuccessData("获取信息成功", trainTypes);
    }

    @Override
    public ServerResponse<IPage<TrainType>> queryPage(TrainTypeVo trainTypeVo) {
        IPage<TrainType> typeIPage = baseMapper.selectPage(
                new Page<>(trainTypeVo.getMyPage().getCurrPage(),
                        trainTypeVo.getMyPage().getPageSize()),
                new QueryWrapper<TrainType>().like("train_type",
                        trainTypeVo.getTrainType()));
        return ServerResponse.createSuccessData("获取信息成功", typeIPage);
    }
}
