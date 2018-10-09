package com.two.train.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.two.train.common.ServerResponse;
import com.two.train.entity.TrainType;
import com.two.train.service.ITrainTypeService;
import com.two.train.vo.TrainTypeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author chsm
 * @since 2018-10-09
 */
@RestController
@RequestMapping("/trainType")
public class TrainTypeController {

    private final ITrainTypeService trainTypeService;

    @Autowired
    public TrainTypeController(ITrainTypeService trainTypeService) {
        this.trainTypeService = trainTypeService;
    }

    @PostMapping("/after/addList")
    public ServerResponse<String> addList(@RequestBody List<TrainType> trainType) {
        return trainTypeService.addList(trainType);
    }

    @DeleteMapping("/after/delete")
    public ServerResponse<String> delete(Integer id) {
        return trainTypeService.delete(id);
    }

    @PutMapping("/after/update")
    public ServerResponse<String> update(@RequestBody TrainType trainType) {
        return trainTypeService.update(trainType);
    }

    @GetMapping("/after/queryByType")
    public ServerResponse<List<TrainType>> queryByType(String trainType) {
        return trainTypeService.queryByType(trainType);
    }

    @PostMapping("/after/queryPage")
    public ServerResponse<IPage<TrainType>> queryPage(@RequestBody TrainTypeVo trainTypeVo) {
        return trainTypeService.queryPage(trainTypeVo);
    }

}

