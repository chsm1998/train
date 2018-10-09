package com.two.train.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.two.train.common.ServerResponse;
import com.two.train.entity.TrainType;
import com.baomidou.mybatisplus.extension.service.IService;
import com.two.train.vo.TrainTypeVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author chsm
 * @since 2018-10-09
 */
public interface ITrainTypeService extends IService<TrainType> {

    /**
     * 批量插入
     * @param trainTypes 列车类型
     * @return  是否插入成功
     */
    ServerResponse<String> addList(List<TrainType> trainTypes);

    /**
     * 通过id删除列车类型
     * @param id    列车类型id
     * @return  是否删除成功
     */
    ServerResponse<String> delete(Integer id);

    /**
     * 通过id更新列车类型
     * @param trainType 列车类型信息
     * @return  是否更新成功
     */
    ServerResponse<String> update(TrainType trainType);

    /**
     * 列车类型模糊查询
     * @param type  列车类型
     * @return  列车类型集合
     */
    ServerResponse<List<TrainType>> queryByType(String type);

    /**
     * 分页查询
     * @param trainTypeVo   列车类型视图对象
     * @return  分页信息
     */
    ServerResponse<IPage<TrainType>> queryPage(TrainTypeVo trainTypeVo);

}
